
/**
 * 注意。在导入此数据库的时候必须先导入group.sql。。。c_project表中有关联c_group的外键
 */
create table c_project (
	c_xm_id integer not null,
	c_zjz_id integer,
    c_xyh_id integer,
    c_zt varchar(5),
	c_xmnbbh_id varchar(50),
	c_xmmc varchar(200),
	c_sqnd varchar(20) ,
	c_cgxs varchar(100),
	c_kssj date,
	c_jssj date,
	c_jhwcsj date,
	c_xmlb varchar(50),
	c_yjlx varchar(50),
	c_xkmc varchar(100),
	c_xkdm varchar(20),
	c_tbsj date,
	c_ysze float(50),
	c_sqze float(50),
	c_sqmx varchar(200),
	c_zcze float(50),
	c_zcmx varchar(200),
	c_sqcn varchar(200),
	c_xswyhyj varchar(200),
	c_fzrdwyj varchar(200),
	c_sjzt1 integer,
	c_psfs float,
	c_psjg varchar(200),
	c_jgsm varchar(500),
	c_sjzt2 integer,
	c_tbr integer,
	c_bz1 varchar(200),
	c_bz2 varchar(200),
	c_bz3 varchar(200),
	c_bz4 varchar(200),
	c_orgcode varchar(20)
	primary key(c_xm_id)
	
);
CREATE SEQUENCE project_sque INCREMENT BY 1 START WITH 1;
comment on table c_project is '申请项目表';
comment on column c_project.c_zjz_id is '专家组表';
comment on column c_project.c_orgcode is '组织机构 存代码字典';
comment on column c_project.c_yjbh is '意见编号';
comment on column c_project.c_zt is '状态';
comment on column c_project.c_xm_id  is '项目编号';
comment on column c_project.c_xmnbbh_id  is '项目内部编号';
comment on column c_project.c_xmmc is '项目名称';
comment on column c_project.c_sqnd  is '申请年度';
comment on column c_project.c_cgxs  is '成果形式';
comment on column c_project.c_kssj  is '开始时间';
comment on column c_project.c_jssj  is '结束时间';
comment on column c_project.c_jhwcsj is '计划完成时间';
comment on column c_project.c_xmlb  is '项目类别';
comment on column c_project.c_yjlx  is '研究类型';
comment on column c_project.c_xkmc  is '学科名称';
comment on column c_project.c_xkdm  is '学科代码';
comment on column c_project.c_tbsj  is '填报时间';
comment on column c_project.c_ysze  is '预算总额';
comment on column c_project.c_sqze  is '申请总额';
comment on column c_project.c_sqmx  is '申请明细';
comment on column c_project.c_zcze  is '自筹总额';
comment on column c_project.c_zcmx  is '自筹明细';
comment on column c_project.c_sqcn  is '申请承诺';
comment on column c_project.c_xswyhyj  is '学术委员会意见';
comment on column c_project.c_fzrdwyj  is '负责人单位意见';
comment on column c_project.c_sjzt1  is '数据状态1';
comment on column c_project.c_psfs  is '评审分数';
comment on column c_project.c_psjg  is '评审结果';
comment on column c_project.c_jgsm  is '结果说明';
comment on column c_project.c_sjzt2  is '数据状态2';
comment on column c_project.c_tbr  is '填报人';
comment on column c_project.c_bz1  is '备注1';
comment on column c_project.c_bz2  is '备注2';
comment on column c_project.c_bz3  is '备注3';
comment on column c_project.c_bz4  is '备注4';


create table c_principal (
	c_fzr_id integer not null,  
	c_fzrxm varchar(50),         
	c_xb varchar(20),
	c_mz varchar(20),
	c_csny date,
	c_xzzw varchar(50),
	c_ywzw varchar(50),
	c_yjzc varchar(50),
	c_zhxl varchar(50),
	c_zhxw varchar(50),
	c_drds varchar(50),
	c_gzdw varchar(200),
	c_lxdh varchar(50),
	c_txdz varchar(200),
	c_yb varchar(20),
	c_sfdrqtxm varchar(20),
	primary key (c_fzr_id)
);
comment on table c_principal is '项目负责人（申报人）情况表';
comment on column c_principal.c_fzr_id is '负责人编号';
comment on column c_principal.c_fzrxm is '负责人姓名';
comment on column c_principal.c_xb is '性别';
comment on column c_principal.c_mz is '民族';
comment on column c_principal.c_csny is '出生年月';
comment on column c_principal.c_xzzw is '行政职务';
comment on column c_principal.c_ywzw is '业务职务';
comment on column c_principal.c_yjzc is '研究专长';
comment on column c_principal.c_zhxl is '最后学历';
comment on column c_principal.c_zhxw is '最后学位';
comment on column c_principal.c_drds is '担任导师';
comment on column c_principal.c_gzdw is '工作单位';
comment on column c_principal.c_lxdh is '联系电话';
comment on column c_principal.c_txdz is '通讯地址';
comment on column c_principal.c_yb is '邮编';
comment on column c_principal.c_sfdrqtxm is '是否担任其他项目';


create table c_principalproject (
	c_cdxm_id integer not null,
	c_xm_id integer,
	c_xmmc varchar(200),
	c_xmlb varchar(50),
	c_kssj date,
	c_jssj date,
	c_pzdw varchar(100),
	c_zzje float,
	c_ssxm integer,
	primary key(c_cdxm_id)
);
CREATE SEQUENCE principalproject_sque INCREMENT BY 1 START WITH 1;
comment on table c_principalproject is '项目负责人承担项目情况表';
comment on column c_principalproject.c_cdxm_id is '承担项目编号';
comment on column c_principalproject.c_xmmc is '项目名称';
comment on column c_principalproject.c_xmlb is '项目类别';
comment on column c_principalproject.c_kssj is '开始时间';
comment on column c_principalproject.c_jssj is '结束时间';
comment on column c_principalproject.c_pzdw is '批准单位';
comment on column c_principalproject.c_zzje is '资助金额';
comment on column c_principalproject.c_ssxm is '所属项目';

create table c_member (
	c_cy_id integer not null,
  	c_xm_id integer,
  	c_xm varchar(50),
  	c_xb varchar(20),
  	c_csny date,
  	c_zyzw varchar(20),
  	c_yjzc varchar(50),
  	c_xlxw varchar(20),
  	c_dw varchar(200),
  	primary key (c_cy_id)
);
CREATE SEQUENCE member_sque INCREMENT BY 1 START WITH 1;
comment on table c_member is '项目成员情况表';
comment on column c_member.c_cy_id is '成员编号';
comment on column c_member.c_xm is '姓名';
comment on column c_member.c_xb is '性别';
comment on column c_member.c_csny is '出生年月';
comment on column c_member.c_zyzw is '专业职务';
comment on column c_member.c_yjzc is '研究专长';
comment on column c_member.c_xlxw is '学历学位';
comment on column c_member.c_dw is '单位';
 
 
create table c_achievement_before (
  	c_cg_id integer not null,
  	c_xm_id integer,
  	c_cgmc varchar(200),
  	c_cgzz varchar(20),
  	c_cgxs varchar(100),
  	c_fbkw varchar(200),
  	c_fbsj date,
  	c_bz1 varchar(1000),
  	c_bz2 varchar(1000),
  	primary key (c_cg_id)
);
CREATE SEQUENCE achievement_before_sque INCREMENT BY 1 START WITH 1;
comment on table c_achievement_before is '负责人和成员近期的研究成果'; 
comment on column c_achievement_before.c_cg_id is '成果编号';
comment on column c_achievement_before.c_cgmc is '成果名称';
comment on column c_achievement_before.c_cgzz is '成果作者';
comment on column c_achievement_before.c_cgxs is '成果形式';
comment on column c_achievement_before.c_fbkw is '发表刊物';
comment on column c_achievement_before.c_fbsj is '发表时间';
comment on column c_achievement_before.c_bz1 is '备注1';
comment on column c_achievement_before.c_bz2 is '备注2';
alter table c_member
   add constraint fk_memberin_relations_projecti foreign key ("C_XM_ID") references c_project("C_XM_ID");

alter table c_achievement_before
   add constraint fk_principa_relations_projecti foreign key ("C_XM_ID")
      references c_project("C_XM_ID");
      
alter table c_principalproject
   add constraint fk_principa_projecti2 foreign key ("C_XM_ID")
      references c_project ("C_XM_ID");
      
alter table c_group
	add constraint fk_group_relations_projecti foreign key ("C_ZJZ_ID") 
		references c_project("C_ZJZ_ID")
      