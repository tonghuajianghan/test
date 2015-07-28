
CREATE TABLE c_user (
  c_username VARCHAR(20) NOT NULL,
  c_password VARCHAR(20) NOT NULL,
  c_roles VARCHAR(100) NOT NULL,
  c_orgcode VARCHAR(20),
  PRIMARY KEY (c_username));
Insert into C_USER (C_USERNAME,C_PASSWORD,C_ROLES) values ('sa','cust214','sa');

CREATE TABLE c_role (
  c_role_id VARCHAR(10) NOT NULL,
  c_role_name VARCHAR(100) NOT NULL,
  PRIMARY KEY (c_role_id));
INSERT INTO "C_ROLE" (C_ROLE_ID, C_ROLE_NAME) VALUES ('sa', '超级用户');
INSERT INTO "C_ROLE" (C_ROLE_ID, C_ROLE_NAME) VALUES ('sbz', '申报者');
INSERT INTO "C_ROLE" (C_ROLE_ID, C_ROLE_NAME) VALUES ('xxadm', '学校管理员');
INSERT INTO "C_ROLE" (C_ROLE_ID, C_ROLE_NAME) VALUES ('zj', '专家');
INSERT INTO "C_ROLE" (C_ROLE_ID, C_ROLE_NAME) VALUES ('xtadm', '系统管理员');

CREATE TABLE c_permission (
  c_permission_id VARCHAR(30) NOT NULL,
  c_permission_name VARCHAR(100) NOT NULL,
  PRIMARY KEY (c_permission_id));
Insert into C_PERMISSION (C_PERMISSION_ID,C_PERMISSION_NAME) values ('xmsb','项目申报');
Insert into C_PERMISSION (C_PERMISSION_ID,C_PERMISSION_NAME) values ('bdwsh','本单位审核');
Insert into C_PERMISSION (C_PERMISSION_ID,C_PERMISSION_NAME) values ('edush','教育厅审核');
Insert into C_PERMISSION (C_PERMISSION_ID,C_PERMISSION_NAME) values ('psfz','评审分组');
Insert into C_PERMISSION (C_PERMISSION_ID,C_PERMISSION_NAME) values ('psdf','评审打分');
Insert into C_PERMISSION (C_PERMISSION_ID,C_PERMISSION_NAME) values ('psjc','评审决策');
Insert into C_PERMISSION (C_PERMISSION_ID,C_PERMISSION_NAME) values ('zjtj','专家推荐');
Insert into C_PERMISSION (C_PERMISSION_ID,C_PERMISSION_NAME) values ('zjsh','专家审核');


CREATE TABLE c_role_has_c_permission (
  c_role_id VARCHAR(10) NOT NULL,
  c_permission_id VARCHAR(30) NOT NULL,
  PRIMARY KEY (c_role_id, c_permission_id));
alter table "C_ROLE_HAS_C_PERMISSION" add constraint fk_c_role_id foreign key("C_ROLE_ID") references "C_ROLE"("C_ROLE_ID");
alter table "C_ROLE_HAS_C_PERMISSION" add constraint fk_c_permission_id foreign key("C_PERMISSION_ID") references "C_PERMISSION"("C_PERMISSION_ID");
