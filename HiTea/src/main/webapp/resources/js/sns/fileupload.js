    var fd = new FormData();
    var map = new Map();
    var ffile = true;
    var nofile =0;
    function submitFile(){
    	
        fd.append('hs_no',$('.hs_no').val());
        fd.append('hs_txt',$('textarea[name=hs_txt]').val().replace('</br>', '\r\n'));
        if ($('.hs_txt2').val()) {
        	var arr2 = $('.hs_txt2').val().split(" ");
        	arr2 = removeA(arr2,"#");
        	var s = arr2.join(' ');
        	$('.hs_txt2').val(s);
        	fd.append('hs_txt2',$('.hs_txt2').val());
		}else {
			fd.append('hs_txt2',$('.hs_txt2').val());			
		}
        
        if ($('.hs_txt3').val()) {
        	var arr3 = $('.hs_txt3').val().split(" ");
        	arr3 = removeA(arr3,"!");
        	var s = arr3.join(' ');
        	$('.hs_txt3').val(s);
        	fd.append('hs_txt3',$('.hs_txt3').val());
		}else {
			fd.append('hs_txt3',$('.hs_txt3').val());
		}

        callback( function(){         	
        	if ($(".hs_txt").val() == "" && ffile) {
				alert("글,사진 둘다 없음");
        		return false;
			}else {
				sendFileToServer();
			}
        })

    }
    
    function removeA(arr) {
        var what, a = arguments, L = a.length, ax;
        while (L > 1 && arr.length) {
            what = a[--L];
            while ((ax= arr.indexOf(what)) !== -1) {
                arr.splice(ax, 1);
            }
        }
        return arr;
    }
    
    
    function submitFile2(){
    	
    	fd.append('hs_no',$('.hs_no').val());
    	fd.append('hs_txt',$('textarea[name=hs_txt]').val().replace('</br>', '\r\n'));
    	fd.append('hs_txt2',$('.hs_txt2').val());
    	fd.append('hs_txt3',$('.hs_txt3').val());
    	
    	callback( function(){         	
    		if ($(".hs_txt").val() == "" && ffile) {
    			alert("글,사진 둘다 없음");
    			return false;
    		}else {
    			sendFileToServer2();
    		}
    		
    		
    	})
    	
    }
    
    function star() {
		alert("sss");
	}
    
    function callback(cb){ cb(); }

   
    
    var sendFileToServer = function() {
        $.ajax({
            type : "POST",
            url : "./fileUpload2.do", 
            data : fd,
            contentType : false,
            processData : false,
            cache : false,
            async : false,
            success : function(data) {
            	if(data) {
                   alert('성공');
                   location.href = 'sns';
                }else {
                   alert('실패');
                }
            }
        });
    }
    var sendFileToServer2 = function() {
    	$.ajax({
    		type : "POST",
    		url : "./fileUpload2.do", 
    		data : fd,
    		contentType : false,
    		processData : false,
    		cache : false,
    		async : false,
    		success : function(data) {
    			if(data) {
    				alert('성공');
    				location.href = 'sns2';
    			}else {
    				alert('실패');
    			}
    		}
    	});
    }
    function handleFileUpload(files) {
    	ffile = false;
        var megaByte = 1024*1024;
        for (var i = 0; i < files.length; i++) {
        	if(map.containsValue(files[i].name) == false && (files[i].size/megaByte) <= 20 ){
                fd.append(files[i].name, files[i]);
                map.put(files[i].name, files[i].name);
                var tag = createFile(files[i].name);
                $('#snsfileTable').append(tag);
                nofile ++;
            }else{
                alert('파일 중복 : ' + files[i].name);
            }
      	}
    }

    function createFile(fileName) {
    	var file = {name : fileName, format : function() {
                    if(name.length > 70){
                        this.name = this.name.substr(0,68)+"...";
                    }
                    return this;
                },
                tag : function() {
                    var tag = new StringBuffer();
                    tag.append('<tr class="snsa" align="center">')
                    tag.append('<td class="snsaaTd"><div class="snsaaDiv"><img class="snsaa"></td></div>')
                    tag.append('<td class="snsaaTd2">'+this.name+'</td>');
                    tag.append("<td><img src='resources/img/sns/close.png' id='"+this.name+"' onclick='delFile(this)'></td>");
                    tag.append('</tr>');
                    return tag.toString(); 
                }
        }
        return file.format().tag();
    }

    function delFile(e) {
        var formName = e.id;
        fd.delete(formName);
        map.remove(formName);
        $(e).parents('.snsa').remove();
        nofile --;
        callback( function(){ 
        	if (nofile == 0) {
        		ffile = true;
        	}
        	alert('삭제 완료!');           	
        })
    }
 

