-- Project Name : drone_mn
-- Date/Time    : 2022/01/20 21:19:33
-- Author       : ok
-- RDBMS Type   : PostgreSQL
-- Application  : A5:SQL Mk-2

/*
  << 注意！！ >>
  BackupToTempTable, RestoreFromTempTable疑似命令が付加されています。
  これにより、drop table, create table 後もデータが残ります。
  この機能は一時的に $$TableName のような一時テーブルを作成します。
  この機能は A5:SQL Mk-2でのみ有効であることに注意してください。
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

comment on table user_account is 'ユーザアカウント';
comment on column user_account.id is 'ユーザID';
comment on column user_account.name is 'ユーザ名';

comment on table reserve is 'reserve';
comment on column reserve.id is '予約番号';
comment on column reserve.drone_id is '機体番号';
comment on column reserve.user_account_id is 'ユーザアカウントID';

comment on table drone is 'drone';
comment on column drone.id is '機体番号';
comment on column drone.name is '機体名';
comment on column drone.reserved is '予約ステータス';

