

INSERT INTO S_USER VALUES (1, 'samir', 'samir_01', 'samir_01');
INSERT INTO S_USER VALUES (2, 'ahmed', 'ahmed_01', 'ahmed_01');
INSERT INTO S_USER VALUES (3, 'jean', 'jean_01', 'jean_01');
INSERT INTO S_USER VALUES (4, 'aida', 'aida_01', 'aida_01');
INSERT INTO S_USER VALUES (5, 'racem', 'racem_01', 'racem_01');
INSERT INTO S_USER VALUES (6, 'paul', 'paul_01', 'paul_01');


INSERT INTO S_USER_INFO  VALUES (1 , 1 ,  'samir', 'lachiheb');
INSERT INTO S_USER_INFO  VALUES (2 , 2 ,  'ahmed', 'ouderni');
INSERT INTO S_USER_INFO  VALUES (3 , 3 ,  'jean', 'jooko');
INSERT INTO S_USER_INFO  VALUES (4 , 4 ,  'aida', 'tounsi');


INSERT INTO S_PROFILE VALUES (1, 'ADMIN', 'Administrator') ; 
INSERT INTO S_PROFILE VALUES (2, 'CUSTOMER', 'Client/Agent') ;
INSERT INTO S_PROFILE VALUES (3, 'SUPPORT', 'Support IT') ;

INSERT INTO S_USER_PROFILE VALUES (1,1,1);
INSERT INTO S_USER_PROFILE VALUES (2,2,2);
INSERT INTO S_USER_PROFILE VALUES (3,3,2);
INSERT INTO S_USER_PROFILE VALUES (4,4,2);
INSERT INTO S_USER_PROFILE VALUES (5,5,2);
INSERT INTO S_USER_PROFILE VALUES (6,6,3);

INSERT INTO S_ACTION VALUES (1,'GET', 'Get', 1);
INSERT INTO S_ACTION VALUES (2,'POST', 'Post', 1);
INSERT INTO S_ACTION VALUES (3,'DELETE', 'Delete', 1);
INSERT INTO S_ACTION VALUES (4,'PATCH', 'Patch', 1);
INSERT INTO S_ACTION VALUES (5,'GET', 'Get', 2);
INSERT INTO S_ACTION VALUES (6,'GET', 'Get', 3);
INSERT INTO S_ACTION VALUES (7,'POST', 'Post', 3);
INSERT INTO S_ACTION VALUES (8,'PATCH', 'Patch', 3);

INSERT INTO S_SCREEN_CONFIG values (1, 'admin_screen', 1);