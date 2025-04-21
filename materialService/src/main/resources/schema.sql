create table material_category(
	category_id varchar(255) primary key,
	category_name varchar(255) default null
);


create table material_type(
	type_id varchar(255) primary key,
	type_name varchar(255) default null,
	category_id varchar(255) default null,
	INDEX idx_category_id_type(category_id),
	constraint idx_category_id_type foreign key (category_id) references material_category (category_id)
);


create table unit(
	unit_id varchar(255) primary key,
	unit_name varchar(255) default null,
	category_id varchar(255) default null,
	INDEX idx_category_id_unit(category_id),
	constraint idx_category_id_unit foreign key (category_id) references material_category (category_id)
);

