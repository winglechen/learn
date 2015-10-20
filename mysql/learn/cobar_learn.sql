
create database dbtest1;
use dbtest1;
create table tb1(
    id int(11) unsigned not null auto_increment primary key,
    val int(11) unsigned not null default 0
)engine=innodb;

create database dbtest2;
use dbtest2;
create table tb2(
    id int(11) unsigned not null auto_increment primary key,
    val int(11) unsigned not null default 0
)engine=innodb;


create database dbtest3;
use dbtest3;
create table tb3(
    id int(11) unsigned not null auto_increment primary key,
    val int(11) unsigned not null default 0
)engine=innodb;

