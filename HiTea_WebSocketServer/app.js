var createError = require('http-errors');
var express = require('express');
var path = require('path');
var cookieParser = require('cookie-parser');
var logger = require('morgan');

var indexRouter = require('./routes/index');
var usersRouter = require('./routes/users');

var app = express();

// view engine setup
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'jade');

app.use(logger('dev'));
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));

//**************************************************
var io = require('socket.io')();

io.listen(31205);

app.listen(43128);

app.get('/message.get', function(req, res){
	var n = req.query.no;
	var db = require('mongojs')('192.168.0.2/xe', ['hitea_msg'])
	db.hitea_msg.find({no: n}).sort({date:1}, function(err, result){
		res.setHeader('Access-Control-Allow-Origin', '*');
		res.send(result);
	});
});

app.get('/message.uncheck.get', function(req, res){
	var n = req.query.no;
	var id = req.query.id;
	var db = require('mongojs')('192.168.0.2/xe', ['hitea_msg'])
	db.hitea_msg.find({no: n, sendTo: id, stCheck: false}, function(err, result){
		res.setHeader('Access-Control-Allow-Origin', '*');
		res.send(result);
	});
});

app.get('/message.delete', function(req, res){
	var n = req.query.no;
	var id = req.query.id;
	var db = require('mongojs')('192.168.0.2/xe', ['hitea_msg'])
	db.hitea_msg.update({no: n, sendTo: id}, {$set: {stDel: true}}, {multi: true}, function(err, result){
		db.hitea_msg.update({no: n, sendFrom: id}, {$set: {sfDel: true}}, {multi: true}, function(err, result){
			res.setHeader('Access-Control-Allow-Origin', '*');
			res.send(result);
		});			
	});
});

app.get('/message.check', function(req, res){
	var n = req.query.no;
	var id = req.query.id;
	var db = require('mongojs')('192.168.0.2/xe', ['hitea_msg'])
	db.hitea_msg.update({no: n, sendTo: id}, {$set: {stCheck: true}}, {multi: true}, function(err, result){
		res.setHeader('Access-Control-Allow-Origin', '*');
		res.send(result);
	});
});

io.sockets.on('connect', function(socket){
	var db = require('mongojs')('192.168.0.2/xe', ['hitea_msg'])
	
	var n = null;
	var st = null;
	var sf = null;
	
	socket.on('chatInfo', function(ci){
		n = ci.no;
		st = ci.sendTo;
		sf = ci.sendFrom;
	});
	
	socket.on('MsgChat', function(txt){
		// 현재 시간
		var date = new Date();
		var year = date.getFullYear();
		var month = date.getMonth();
		var today = date.getDate();
		var hours = date.getHours();
		var minutes = date.getMinutes();
		var seconds = date.getSeconds();
		var milliseconds = date.getMilliseconds();
		var d = new Date(Date.UTC(year, month, today, hours, minutes, seconds, milliseconds));
		
		var msg = {no: n, sendFrom: sf, txt: txt, date: d, sfDel: false, stDel: false};
		db.hitea_msg.insert({no: n, sendTo: st, sendFrom: sf, txt: txt, date: d, sfDel: false, stDel: false, stCheck: false}, function(err, result){
			io.sockets.emit(st + n, msg);
			io.sockets.emit(sf + n, msg);
		});
	});
});

// **************************************************

app.use('/', indexRouter);
app.use('/users', usersRouter);

// catch 404 and forward to error handler
app.use(function(req, res, next) {
  next(createError(404));
});

// error handler
app.use(function(err, req, res, next) {
  // set locals, only providing error in development
  res.locals.message = err.message;
  res.locals.error = req.app.get('env') === 'development' ? err : {};

  // render the error page
  res.status(err.status || 500);
  res.render('error');
});

module.exports = app;
