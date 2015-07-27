create table c_account(
	c_id varchar(32),
	c_pass varchar(32),
	c_balance float,
	primary key(c_id)
);

create table c_account_roles(
	c_id varchar(32),
	c_role varchar(4),
	primary key(c_id, c_role)
);

create table c_operation(
	c_src_id varchar(32),
	c_id bigint,
	c_des_id varchar(32),
	c_money float,
	c_date datetime,
	c_type int,
	primary key(c_src_id, c_id)
);

insert into c_account values('111','111',100);
insert into c_account values('222','222',200);
insert into c_account_roles values('111', 'comm');
insert into c_account_roles values('222', 'comm');