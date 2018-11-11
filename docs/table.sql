--创建user用户表以及创建自动生成user.id
create table b_user(
    id number primary key,
    username varchar2(15),
    password varchar2(20),
    gender varchar2(20)
);

create sequence b_seq_user;
--创建post文章表以及创建自动生成user.id
create table b_post(
    id number primary key,
    title varchar2(128),
    author_id number references b_user(id),
    content varchar2(4000)
);
create sequence b_post_seq;