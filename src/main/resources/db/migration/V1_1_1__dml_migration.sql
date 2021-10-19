insert into employee (employee_id, emp_first_name, emp_last_name) values ('E001', 'William', 'Rattary');
insert into employee (employee_id, emp_first_name, emp_last_name) values ('E002', 'Madhavan', 'Sivaprakasam');
insert into employee (employee_id, emp_first_name, emp_last_name) values ('E003', 'bill', 'griffin');

insert into department (depart_id, dept_name) values ('D001', 'Finance');
insert into department (depart_id, dept_name) values ('D002', 'Adminstration');
insert into department (depart_id, dept_name) values ('D003', 'Commerce');

insert into emp_depart_map (employee_id, depart_id) values ('E001', 'D001');
insert into emp_depart_map (employee_id, depart_id) values ('E001', 'D002');
insert into emp_depart_map (employee_id, depart_id) values ('E002', 'D001');
insert into emp_depart_map (employee_id, depart_id) values ('E002', 'D002');
insert into emp_depart_map (employee_id, depart_id) values ('E003', 'D003');

insert into project (depart_id, proj_id, proj_name) values ('D001', 'P001', 'threadstone');
insert into project (depart_id, proj_id, proj_name) values ('D002', 'P001', 'threadstone');

insert into proj_emp_map (depart_id, proj_id, employee_id) values ('D001', 'P001', 'E001');
insert into proj_emp_map (depart_id, proj_id, employee_id) values ('D001', 'P001', 'E002');
insert into proj_emp_map (depart_id, proj_id, employee_id) values ('D002', 'P001', 'E001');
insert into proj_emp_map (depart_id, proj_id, employee_id) values ('D002', 'P001', 'E002');
insert into proj_emp_map (depart_id, proj_id, employee_id) values ('D002', 'P001', 'E003');