INSERT INTO EMPLOYEE (EMPLOYEE_ID, EMP_FIRST_NAME, EMP_LAST_NAME) VALUES ('E001', 'William', 'Rattary');
INSERT INTO EMPLOYEE (EMPLOYEE_ID, EMP_FIRST_NAME, EMP_LAST_NAME) VALUES ('E002', 'Madhava', 'Sivaprakasam');
INSERT INTO EMPLOYEE (EMPLOYEE_ID, EMP_FIRST_NAME, EMP_LAST_NAME) VALUES ('E003', 'Bill', 'Griffin');

INSERT INTO DEPARTMENT (DEPART_ID, DEPT_NAME) VALUES ('D001', 'FINANCE');
INSERT INTO DEPARTMENT (DEPART_ID, DEPT_NAME) VALUES ('D002', 'ADMINSTRATION');
INSERT INTO DEPARTMENT (DEPART_ID, DEPT_NAME) VALUES ('D003', 'COMMERCE');

INSERT INTO EMP_DEPART_MAP (EMPLOYEE_ID, DEPART_ID) VALUES ('E001', 'D001');
INSERT INTO EMP_DEPART_MAP (EMPLOYEE_ID, DEPART_ID) VALUES ('E001', 'D002');
INSERT INTO EMP_DEPART_MAP (EMPLOYEE_ID, DEPART_ID) VALUES ('E002', 'D001');
INSERT INTO EMP_DEPART_MAP (EMPLOYEE_ID, DEPART_ID) VALUES ('E002', 'D002');
INSERT INTO EMP_DEPART_MAP (EMPLOYEE_ID, DEPART_ID) VALUES ('E003', 'D003');

INSERT INTO PROJECT (DEPART_ID, PROJ_ID, proj_name) VALUES ('D001', 'P001', 'THREADSTONE');
INSERT INTO PROJECT (DEPART_ID, PROJ_ID, proj_name) VALUES ('D002', 'P001', 'THREADSTONE');

INSERT INTO PROJ_EMP_MAP (DEPART_ID, PROJ_ID, EMPLOYEE_ID) VALUES ('D001', 'P001', 'E001');
INSERT INTO PROJ_EMP_MAP (DEPART_ID, PROJ_ID, EMPLOYEE_ID) VALUES ('D001', 'P001', 'E002');
INSERT INTO PROJ_EMP_MAP (DEPART_ID, PROJ_ID, EMPLOYEE_ID) VALUES ('D002', 'P001', 'E001');
INSERT INTO PROJ_EMP_MAP (DEPART_ID, PROJ_ID, EMPLOYEE_ID) VALUES ('D002', 'P001', 'E002');
INSERT INTO PROJ_EMP_MAP (DEPART_ID, PROJ_ID, EMPLOYEE_ID) VALUES ('D002', 'P001', 'E003');