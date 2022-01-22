-- Project Name : drone_mn
-- Date/Time    : 2022/01/20 21:19:33
-- Author       : ok
-- RDBMS Type   : PostgreSQL
-- Application  : A5:SQL Mk-2

/*
  << ���ӁI�I >>
  BackupToTempTable, RestoreFromTempTable�^�����߂��t������Ă��܂��B
  ����ɂ��Adrop table, create table ����f�[�^���c��܂��B
  ���̋@�\�͈ꎞ�I�� $$TableName �̂悤�Ȉꎞ�e�[�u�����쐬���܂��B
  ���̋@�\�� A5:SQL Mk-2�ł̂ݗL���ł��邱�Ƃɒ��ӂ��Ă��������B
*/

--* BackupToTempTable
drop table user_account cascade;

--* RestoreFromTempTable
create table user_account (
  id serial not null
  , name character varying
  , constraint user_account_PKC primary key (id)
) ;

--* BackupToTempTable
drop table reserve cascade;

--* RestoreFromTempTable
create table reserve (
  id serial not null
  , drone_id integer
  , user_account_id integer
  , constraint reserve_PKC primary key (id)
) ;

--* BackupToTempTable
drop table drone cascade;

--* RestoreFromTempTable
create table drone (
  id serial not null
  , name varchar(100) not null
  , reserved integer
  , constraint drone_PKC primary key (id)
) ;

alter table reserve
  add constraint reserve_FK1 foreign key (user_account_id) references user_account(id);

alter table reserve
  add constraint reserve_FK2 foreign key (drone_id) references drone(id);

comment on table user_account is '���[�U�A�J�E���g';
comment on column user_account.id is '���[�UID';
comment on column user_account.name is '���[�U��';

comment on table reserve is 'reserve';
comment on column reserve.id is '�\��ԍ�';
comment on column reserve.drone_id is '�@�̔ԍ�';
comment on column reserve.user_account_id is '���[�U�A�J�E���gID';

comment on table drone is 'drone';
comment on column drone.id is '�@�̔ԍ�';
comment on column drone.name is '�@�̖�';
comment on column drone.reserved is '�\��X�e�[�^�X';

