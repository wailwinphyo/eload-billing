insert into role values (1, 'USER');

insert into user(id, full_name, username, password, enabled) values (1000, 'Admin', 796056727, '12345', true);
insert into user(id, full_name, username, password, enabled) values (1001, 'Jack', 796056723, '12345', true);
insert into user(id, full_name, username, password, enabled) values (1002, 'Walker', 796056724, '12345', true);
insert into user(id, full_name, username, password, enabled) values (1003, 'John', 796056722, '12345', true);
insert into user(id, full_name, username, password, enabled) values (1004, 'Nyi Ye Han', 796056721, '12345', true);
insert into user(id, full_name, username, password, enabled) values (1005, 'Wai Lwin Phyo', 796056728, '12345', true);

insert into user_authorities values (1000, 1);
insert into user_authorities values (1001, 1);
insert into user_authorities values (1002, 1);
insert into user_authorities values (1003, 1);
insert into user_authorities values (1004, 1);
insert into user_authorities values (1005, 1);


insert into operator(id, name, topup_type, status) values (1000, 'Telenor', 'E-LOAD', 'ACTIVE');
insert into operator(id, name, topup_type, status) values (1001, 'Telenor', 'TRANSFER', 'ACTIVE');
insert into operator(id, name, topup_type, status) values (1002, 'Ooredoo', 'E-LOAD', 'ACTIVE');
insert into operator(id, name, topup_type, status) values (1003, 'Ooredoo', 'TRANSFER', 'ACTIVE');
insert into operator(id, name, topup_type, status) values (1004, 'MPT', 'E-LOAD', 'ACTIVE');
insert into operator(id, name, topup_type, status) values (1005, 'MPT', 'TRANSFER', 'INACTIVE');

insert into topup_package(id, name, price, operator_id, status) values (1001, '1000', 1000, 1001,'ACTIVE');
insert into topup_package(id, name, price, operator_id, status) values (1002, '2000', 2000, 1001,'ACTIVE');
insert into topup_package(id, name, price, operator_id, status) values (1003, '3000', 3000, 1001,'ACTIVE');
insert into topup_package(id, name, price, operator_id, status) values (1004, '5000', 5000, 1001,'ACTIVE');
insert into topup_package(id, name, price, operator_id, status) values (1005, '1000', 1000, 1002,'ACTIVE');
insert into topup_package(id, name, price, operator_id, status) values (1006, '5000', 5000, 1002,'ACTIVE');
insert into topup_package(id, name, price, operator_id, status) values (1007, '10000', 10000, 1002,'ACTIVE');
insert into topup_package(id, name, price, operator_id, status) values (1008, '20000', 20000, 1002,'ACTIVE');

