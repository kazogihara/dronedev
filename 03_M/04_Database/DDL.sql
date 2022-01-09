create table drone (
  id serial not null
  , name varchar(100) not null
  , constraint drone_PKC primary key (id)
) ;

comment on table drone is 'drone';
comment on column drone.id is 'id';
comment on column drone.name is 'name';

