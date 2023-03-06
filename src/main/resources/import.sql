insert into roles (role_name) values ('ROLE_ADMIN');
insert into roles (role_name) values ('ROLE_USER');

insert into users (age, email, user_name, last_name, user_password) values (30, 'admin@gmail.com', 'admin', 'adminskii', '$2a$10$7mbnp8pNOBQFngPN/CdDT.H/eMJ4zfjorglwChXNilCtOF0M14Es6');
insert into users (age, email, user_name, last_name, user_password) values (50, 'user@gmail.com', 'user', 'userevich', '$2a$10$8mOVqDFoLGqE9wHd/FnrV.fF1i7eQb9txn2pLkRMbmtLrsDbTXysu');

insert into users_roles (user_id, role_id) values (1, 1);
insert into users_roles (user_id, role_id) values (1, 2);
insert into users_roles (user_id, role_id) values (2, 2);

