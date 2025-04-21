create table vendor(
	vendor_id varchar(100) primary key,
	vendor_name varchar(100) not null,
	vendor_address varchar(100),
	contact_number bigint(10) not null,
	contact_person varchar(100) not null
);
