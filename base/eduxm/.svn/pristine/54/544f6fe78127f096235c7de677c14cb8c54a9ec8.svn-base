drop table c_project_score cascade constraints purge;
create table c_project_score
(
   c_xm_id     number(38)   not null,
   c_zj_id  varchar(20)   not null,
   c_fs1       number,
   c_fs2       number,
   c_fs3       number,
   c_fs4       number,
   c_zf		   number
)

comment on column "eduxm"."c_project_score"."c_xm_id" is '项目id';
comment on column "eduxm"."c_project_score"."c_zj_id" is '专家id';
comment on column "eduxm"."c_project_score"."c_fs1" is '分数1';
comment on column "eduxm"."c_project_score"."c_fs1" is '分数2';
comment on column "eduxm"."c_project_score"."c_fs1" is '分数3';
comment on column "eduxm"."c_project_score"."c_fs1" is '分数4';
comment on column "eduxm"."c_project_score"."c_fs1" is '总分';

alter table c_project_score add constraint c_project_score_pk2 primary key (c_xm_id,c_zj_id);
