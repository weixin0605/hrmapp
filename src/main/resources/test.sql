create database hrm_db;
use hrm_db;
create table dept_inf(
  id int(11) not null auto_increment,
  name varchar(50) not null,
  remark varchar(300) default null,
  primary key (id)
)engine=INNODB auto_increment=10 default charset=utf8;

insert into dept_inf(id,name,remark) values
  (1,'技术部','技术部'),
  (2,'运营部','运营部'),
  (3,'财务部','财务部'),
  (5,'总工办','总工办'),
  (6,'市场部','市场部'),
  (7,'教学部','教学部');

create table job_inf(
  id int(11) not null auto_increment,
  name varchar(50) not null,
  remark varchar(300) default null,
  primary key (id)
)engine=INNODB auto_increment=10 default charset=utf8;

insert into  job_inf(id,name,remark) values
  (1,'职员','职员'),
  (2,'开发工程师','开发工程师'),
  (3,'中级开发工程师','中级开发工程师'),
  (4,'高级开发工程师','高级开发工程师'),
  (5,'系统管理员','系统管理员'),
  (6,'架构师','架构师'),
  (7,'主管','主管'),
  (8,'经理','经理'),
  (9,'总经理','总经理');

create table user_inf(
  id int(11) not null auto_increment,
  loginname varchar(20) not null,
  password varchar(16) not null,
  status int(11) not null default '1',
  createdate timestamp not null default current_timestamp,
  username varchar(20) default null,
  primary key (id)
)engine=INNODB auto_increment=2 default charset=utf8;

insert into user_inf(id,loginname,password,status,createdate,username) values
  (1,'admin','123456',2,'2016-03-12 09:34:28','超级管理员');

create table employee_inf(
  id int(11) not null auto_increment,
  dept_id int(11) not null,
  job_id int(11) not null,
  name varchar(20) not null,
  card_id varchar(18) not null,
  address varchar(50) not null,
  post_code varchar(50) default null,
  tel varchar(16) default null,
  phone varchar(11) not null,
  qq_num varchar(10) default null,
  email varchar(50) not null,
  sex int(11) not null default '1',
  party varchar(10) default null,
  birthday datetime default null,
  race varchar(100) default null,
  education varchar(10) default null,
  speciality varchar(20) default null,
  hobby varchar(100) default null,
  remark varchar(500) default null,
  create_date timestamp not null default current_timestamp,
  primary key (id),
  key fk_emp_dept (dept_id),
  key fk_emp_job (job_id),
  constraint fk_emp_dept foreign key (dept_id) references dept_inf (id),
  constraint fk_emp_job foreign key (job_id) references job_inf (id)
)engine=INNODB auto_increment=21 default charset=utf8;

insert into employee_inf(id,dept_id,job_id,name,card_id,address,post_code,tel,phone,qq_num,
  email,sex,party,birthday,race,education,speciality,hobby,remark,create_date)values
  (1,1,8,'爱丽丝','4328011988','广州天河','510000','020-77777777','13902001111','36750066',
  '251425887@qq.com',0,'党员','1980-01-01 00:00:00','满','本科','美声','唱歌','四大天王','2016-03-14 11:35:18'),
  (2,2,1,'杰克','22623','43234','42427424','42242','4247242','42424',
  '251425887@qq.com',2,null,null,null,null,null,null,null,'2016-03-14 11:35:18'),
  (3,1,2,'bb','432801197711251038','广州','510000','020-99999999','13907351532','36750064',
  '36750064@qq.com',1,'党员','1977-11-25 00:00:00','汉','本科','计算机','爬山','无','2016-07-14 09:54:52');


create table notice_inf(
  id int(11) not null auto_increment,
  title varchar(50) not null,
  content text not null,
  create_date timestamp not null default current_timestamp,
  user_id int(11) default null,
  primary key (id),
  key fk_notice_user (user_id),
  constraint fk_notice_user foreign key (user_id) references user_inf (id)
)engine=INNODB auto_increment=19 default charset=utf8;

create table document_inf(
  id int(11) not null auto_increment,
  title varchar(50) not null,
  filename varchar(300) not null,
  remark varchar(300) default null,
  create_date timestamp not null default current_timestamp,
  user_id int(11) default null,
  primary key (id),
  key fk_document_user (user_id),
  constraint fk_document_user foreign key (user_id) references user_inf (id)
)engine=INNODB auto_increment=7 default charset=utf8;


