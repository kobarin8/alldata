set names utf8;
set foreign_key_checks = 0;

drop database if exists study1;
create database if not exists study1;
use study1;


drop table if exists hatugenTABLE;
create table hatugenTABLE(
id int not null primary key auto_increment,
hatugenVALUE varchar(50),

insert_date datetime
);


INSERT INTO hatugentable(hatugenvalue) VALUES("発言");