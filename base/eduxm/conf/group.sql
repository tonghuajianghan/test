create table c_group_a(	
	c_zjz_id number not null, 
	c_zjzmc varchar(200), 
	c_zyly varchar(50), 
	c_nd varchar(20), 
	c_zz number, 
	c_zjzsm varchar(500), 
	c_bz varchar(200), 
	c_zdrs number, 
	c_zdxms number, 
	primary key (c_zjz_id)
);
create sequence group_sque increment by 1 start with 1;

	comment on column "eduxm"."c_group"."c_zjz_id" is '专家组编号';
 
   comment on column "eduxm"."c_group"."c_zjzmc" is '专家组名称';
 
   comment on column "eduxm"."c_group"."c_zyly" is '专业领域';
 
   comment on column "eduxm"."c_group"."c_nd" is '年度';
 
   comment on column "eduxm"."c_group"."c_zz" is '组长';
 
   comment on column "eduxm"."c_group"."c_zjzsm" is '专家组说明';
 
   comment on column "eduxm"."c_group"."c_bz" is '备注';
 
   comment on column "eduxm"."c_group"."c_zdrs" is '最多人数';
 
   comment on column "eduxm"."c_group"."c_zdxms" is '最多项目数';

  
 