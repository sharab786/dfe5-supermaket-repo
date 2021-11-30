drop table if exists product CASCADE;
create table product
(
id integer auto_increment,
name varchar (100) not null,
category varchar (100) not null,
price double not null,
colour varchar (30) not null,
quantity int not null,
active_for_sale boolean not null,
primary key (id)
);