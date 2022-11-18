create table user
(
	id int auto_increment,
	ref_id varchar(35) null,
	username varchar(50) not null,
	email varchar(35) null,
	password varchar(50) null,
	is_active BIT default false null,
	constraint user_pk
		primary key (id)
);

create unique index user_email_uindex
	on user (email);

create unique index user_ref_id_uindex
	on user (ref_id);

