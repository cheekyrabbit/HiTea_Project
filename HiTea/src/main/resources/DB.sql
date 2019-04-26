create table hitea_member(
	hm_id varchar2(20 char) primary key,
	hm_pw varchar2(16 char) not null,
	hm_nickname varchar2(8 char) not null,
	hm_name varchar2(10 char) not null,
	hm_email varchar2(100 char) not null,
	hm_pw_question varchar2(30 char) not null,	
	hm_pw_answer varchar2(50 char) not null,	
	hm_selfIntroduction varchar2(100 char) not null,
	hm_photo_front varchar2(200 char) not null,
	hm_photo_back varchar2(200 char) not null
);
select * from hitea_member;

create table hitea_sns(
	hs_no number(15) primary key,	
	hs_hm_id varchar2(20 char) not null,
	hs_hm_nickname varchar2(8 char) not null,
	hs_txt varchar2(500 char) not null,	
	hs_txt2 varchar2(500 char) not null,
	hs_txt3 varchar2(500 char) not null,
	hs_photo_front varchar2(200 char) not null,
	hs_date date not null					
);

create table hitea_sns_repl(
	hsr_no number(15) primary key,		
	hsr_hs_no number(15) not null,		
	hsr_hm_nickname varchar2(8 char) not null,	
	hsr_txt varchar2(200 char) not null,		
	hsr_date date not null,
	hsr_img varchar2(200 char) not null,
	constraint hitea_sns_repl_haha foreign key(hsr_hs_no) references hitea_sns(hs_no) on delete cascade
);

create table hitea_files(
	hfile_no number(15) not null,
	hfile_img varchar2(500 char) not null,
	hfile_video varchar2(500 char) not null,
	constraint hitea_files_haha foreign key(hfile_no) references hitea_sns(hs_no) on delete cascade
);

create sequence hitea_sns_seq;
create sequence hitea_sns_repl_seq;

create table hitea_follow(
	hf_following_hm_id varchar2(20 char) not null,
	hf_follower_id varchar2(20 char) not null,
	hf_date date not null
);

create table hitea_heart(
	hh_hs_no number(15) not null,
	hh_heart_hm_id varchar2(20 char) not null,
	hh_date date not null,
	constraint sns_heart3 foreign key(hh_hs_no) references hitea_sns(hs_no) on delete cascade
);

create table hitea_hash(
	hhash_hs_no number(15) not null,
	hhash_text varchar2(50 char) not null,
	constraint sns_hash foreign key(hhash_hs_no) references hitea_sns(hs_no) on delete cascade
);

create table hitea_alarm(
	halarm_no number(7) primary key,
	halarm_to_nickname varchar2(8 char) not null,
	halarm_to_id varchar2(20 char) not null,
	halarm_from_id varchar2(20 char) not null,
	halarm_txt varchar2(20 char) not null,
	halarm_date Date not null
);
create sequence hitea_alarm_seq;

create table hitea_report(
	hr_no number(7) primary key,
	hr_this varchar2(20 char) not null,
	hr_report_id varchar2(10 char) not null,
	hr_text varchar2(300 char) not null,
	hr_catego varchar2(10 char) not null,
	hr_date Date not null
);
create sequence hitea_report_seq;


drop table hitea_teabag cascade constraint purge;
drop table hitea_teabagmember cascade constraint purge;
drop table hitea_bbs cascade constraint purge;
drop table hitea_dataroom cascade constraint purge;
drop table hitea_calendar cascade constraint purge;
drop table hitea_joinreq cascade constraint purge;
drop table hitea_pagenotice cascade constraint purge;

create table hitea_teabag(
	ht_no number(10) primary key,
	ht_name varchar2(15char) not null,
	ht_category varchar2(15char) not null,
	ht_date date not null,
	ht_leaderid varchar2(20char) not null,
	ht_profilepic varchar2(200char) not null,
	ht_bgpic varchar2(200char) not null,
	ht_introduce varchar2(100char) not null,
	ht_count number(15) not null,
	ht_notice varchar2(200char) not null
);
create sequence hitea_teabag_seq;
-----------------

create table hitea_teabagmember(
	htm_id varchar2(20char) not null,
	htm_tno number(10) not null,
	htm_date date not null,
	constraint band_member_terms foreign key (htm_tno) references hitea_teabag(ht_no) on delete cascade
);

create sequence hitea_teabag_seq;
-----------------

create table hitea_bbs(
	hb_no number(15) not null,
	hb_id varchar2(30 char) not null,
	hb_content varchar2(200 char) not null,
	hb_date date not null,
	hb_tno number(10) not null,
	constraint hitea_bbs_term 
	foreign key(hb_tno) references hitea_teabag(ht_no)
	on delete cascade
);

create sequence hitea_bbs_seq;
-----------------

create table hitea_dataroom(
	hd_no number(15) primary key,
	hd_id varchar2(20char) not null,
	hd_title varchar2(20char) not null,
	hd_fname varchar2(200char) not null,
	hd_tno number(10) not null,
	hd_ftype varchar2(3char) not null,
	hd_date date not null,
	constraint hitea_dataroom_term 
	foreign key(hd_tno) references hitea_teabag(ht_no)
	on delete cascade
);

create sequence hitea_dataroom_seq;
-----------------

create table hitea_calendar(
	hc_no number(15) primary key,
	hc_tno number(10) not null,
	hc_category varchar2(10char) not null, 
	hc_title varchar2(20char) not null,
	hc_content varchar2(200char) not null,
	hc_start varchar2(20char) not null,
	hc_end varchar2(20char) not null,
	constraint hitea_calendar_term 
	foreign key(hc_tno) references hitea_teabag(ht_no)
	on delete cascade
);

create sequence hitea_calendar_seq;

create table hitea_joinreq(
	hj_no number(15) primary key,
	hj_id varchar2(20 char) not null,
	hj_tno number(10) not null,
	hj_date date not null,
	constraint hitea_joinreq_term 
	foreign key(hj_tno) references hitea_teabag(ht_no)
	on delete cascade
);
select * from hitea_joinreq;

create sequence hitea_joinreq_seq;
-----------------

create table hitea_pagenotice(
	hpn_no number(15) primary key,
	hpn_id varchar2(20char) not null,
	hpn_tno number(10) not null,
	hpn_content varchar2(100char) not null,
	hpn_type varchar2(10char) not null,
	hpn_date date not null,
	constraint hitea_pagenotice_term 
	foreign key(hpn_tno) references hitea_teabag(ht_no)
	on delete cascade
);

create sequence hitea_pagenotice_seq;


-- 2) Messenger List (→ Oracle DB)
create table hitea_messenger_list(
  hmsl_no number(10) primary key, 
  hmsl_m1 varchar2(20 char) not null, 
  hmsl_m2 varchar2(20 char) not null,
  hmsl_last_txt1 varchar2(300 char) not null, 
  hmsl_last_txt2 varchar2(300 char) not null, 
  hmsl_last_date date not null
);


create sequence hitea_messenger_list_seq;


-- Messenger
-- 1) Message (→ Mongo DB)
-- hitea_msg (
--  no number, 
--  sendTo string, 
--  sendFrom string, 
--  txt string, 
--  date date,
--  sfDel boolean, 
--  stDel boolean, 
--  stCheck boolean
-- );

