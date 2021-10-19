drop table if exists emp_depart_map;
drop table if exists proj_emp_map;
drop table if exists employee;
drop table if exists project;
drop table if exists department;

create table department (
	depart_id  varchar(50) not null primary key,
       dept_name varchar(50) not null
);

create table employee(
	employee_id varchar(50) not null primary key, 
	emp_first_name varchar(50) not null,
	emp_last_name varchar(50) not null);

create table project(
	proj_id varchar(50) not null , 
	depart_id varchar(50) not null ,
	proj_name varchar(50) not null,
      primary key(proj_id,depart_id),
      foreign key (depart_id) references department(depart_id));

create table emp_depart_map(
	depart_id varchar(50) not null,
	employee_id varchar(50) not null,
foreign key(depart_id) references department(depart_id) ,
foreign key(employee_id) references employee(employee_id),
constraint uc_emp_depart_map unique(depart_id,employee_id));

create table proj_emp_map(
	proj_id varchar(50) not null,
	depart_id varchar(50) not null,
	employee_id varchar(50) not null,
foreign key(proj_id,depart_id) references project(proj_id,depart_id),
foreign key(employee_id) references employee(employee_id),
constraint uc_proj_emp_map unique(proj_id,depart_id,employee_id));
