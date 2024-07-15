-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;
insert into project(id, name, age) values(1, 'wildfly',10);
insert into project(id, name, age) values(2, 'quarkus', 5);
insert into project(id, name, age) values(3, 'jbossws', 15);
insert into project(id, name, age) values(4, 'resteasy', 12);
insert into project(id, name, age) values(5, 'hibernate', 25);
insert into project(id, name, age) values(6, 'cxf', 16);