create table if not exists brands (
    id bigint generated by default as identity,
    name varchar(255) not null,
    primary key (id)
);

create table if not exists hard_disks (
    capacity float(53) not null,
    id bigint not null,
    primary key (id)
);

create table if not exists laptops (
    size integer not null,
    id bigint not null,
    primary key (id)
);

create table if not exists monitors (
    diagonal float(53) not null,
    id bigint not null,
    primary key (id)
);

create table if not exists personal_computers (
    form_factor varchar(255) not null,
    id bigint not null,
    primary key (id)
);

create table if not exists products (
    type varchar(31) not null,
    id bigint generated by default as identity,
    price numeric(38,2) not null,
    serial_number varchar(255) not null,
    stock bigint not null,
    brand_id bigint not null,
    primary key (id)
);

alter table if exists hard_disks add constraint if not exists CONSTRAINT_CS_001 foreign key (id) references products;
alter table if exists laptops add constraint if not exists CONSTRAINT_CS_002 foreign key (id) references products;
alter table if exists monitors add constraint if not exists CONSTRAINT_CS_003 foreign key (id) references products;
alter table if exists personal_computers add constraint if not exists CONSTRAINT_CS_004 foreign key (id) references products;
alter table if exists products add constraint if not exists CONSTRAINT_CS_005 foreign key (brand_id) references brands;