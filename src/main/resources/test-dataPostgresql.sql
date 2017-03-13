DELETE FROM TEST.BLOG_POST;
DELETE FROM TEST.AUTHORITIES;
DELETE FROM TEST.USERR;

--USERS
INSERT INTO TEST.USERR (ID, USERNAME, PASSWORD, ENABLED) VALUES (nextval('test.userr_id_seq'), 'user','password',TRUE);
INSERT INTO TEST.USERR (ID, USERNAME, PASSWORD, ENABLED) VALUES (nextval('test.userr_id_seq'), 'admin','password',TRUE);
INSERT INTO TEST.USERR (ID, USERNAME, PASSWORD, ENABLED) VALUES (nextval('test.userr_id_seq'), 'test1@outlook.com','12345',TRUE);
INSERT INTO TEST.USERR (ID, USERNAME, PASSWORD, ENABLED) VALUES (nextval('test.userr_id_seq'), 'test2@outlook.com','12345',TRUE);


--AUTHORITIES
INSERT INTO TEST.AUTHORITIES (ID, USERNAME,AUTHORITY) VALUES (nextval('test.authorities_id_seq'), 'user','ROLE_USER');
INSERT INTO TEST.AUTHORITIES (ID, USERNAME,AUTHORITY) VALUES (nextval('test.authorities_id_seq'), 'admin','ROLE_ADMIN');
INSERT INTO TEST.AUTHORITIES (ID, USERNAME,AUTHORITY) VALUES (nextval('test.authorities_id_seq'), 'test1@outlook.com','ROLE_USER');
INSERT INTO TEST.AUTHORITIES (ID, USERNAME,AUTHORITY) VALUES (nextval('test.authorities_id_seq'), 'test2@outlook.com','ROLE_USER');


--BLOG POST
INSERT INTO TEST.BLOG_POST (ID, CONTENT,DRAFT,PUBLISHDATE,TITLE,USER_ID)
VALUES (nextval('test.blog_post_id_seq'), 'Test Content Spring MVC',false,NOW(),'test', (SELECT ID FROM TEST.USERR WHERE USERNAME = 'user'));
