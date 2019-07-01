create table supplier(
    ruc varchar(10) not null primary key ,
    name varchar(100),
    contactEmail varchar (100),
    contactMobilePhone varchar (9)
);

create table product(
    sku varchar (9) not null primary key ,
    name varchar (100),
    stock int (10),
    price double
);