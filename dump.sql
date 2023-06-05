-- H2 2.1.214;
;             
CREATE USER IF NOT EXISTS "SA" SALT 'ca88c1ae10a8bffe' HASH 'd9aecee62be88f780833f7d2760fc85db355ad6403f173edc237cf864e2bec21' ADMIN;         
CREATE CACHED TABLE "PUBLIC"."DATABASECHANGELOGLOCK"(
    "ID" INTEGER NOT NULL,
    "LOCKED" BOOLEAN NOT NULL,
    "LOCKGRANTED" TIMESTAMP,
    "LOCKEDBY" CHARACTER VARYING(255)
);    
ALTER TABLE "PUBLIC"."DATABASECHANGELOGLOCK" ADD CONSTRAINT "PUBLIC"."PK_DATABASECHANGELOGLOCK" PRIMARY KEY("ID");            
-- 1 +/- SELECT COUNT(*) FROM PUBLIC.DATABASECHANGELOGLOCK;   
INSERT INTO "PUBLIC"."DATABASECHANGELOGLOCK" VALUES
(1, FALSE, NULL, NULL);  
CREATE CACHED TABLE "PUBLIC"."BRANDS"(
    "ID" BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 1 RESTART WITH 9) NOT NULL,
    "NAME" CHARACTER VARYING(255) NOT NULL
);               
ALTER TABLE "PUBLIC"."BRANDS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_7" PRIMARY KEY("ID");       
-- 8 +/- SELECT COUNT(*) FROM PUBLIC.BRANDS;  
INSERT INTO "PUBLIC"."BRANDS" VALUES
(1, U&'\0411\0440\0435\043d\0434 1'),
(2, U&'\0411\0440\0435\043d\0434 2'),
(3, U&'\0411\0440\0435\043d\0434 3'),
(4, U&'\0411\0440\0435\043d\0434 4'),
(5, U&'\0411\0440\0435\043d\0434 5'),
(6, U&'\0411\0440\0435\043d\0434 6'),
(7, U&'\0411\0440\0435\043d\0434 7'),
(8, U&'\0411\0440\0435\043d\0434 8');  
CREATE CACHED TABLE "PUBLIC"."HARD_DISKS"(
    "CAPACITY" FLOAT(53) NOT NULL,
    "ID" BIGINT NOT NULL
);  
ALTER TABLE "PUBLIC"."HARD_DISKS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_5" PRIMARY KEY("ID");   
-- 3 +/- SELECT COUNT(*) FROM PUBLIC.HARD_DISKS;              
INSERT INTO "PUBLIC"."HARD_DISKS" VALUES
(320.0, 12),
(640.0, 13),
(640.0, 14);            
CREATE CACHED TABLE "PUBLIC"."LAPTOPS"(
    "SIZE" INTEGER NOT NULL,
    "ID" BIGINT NOT NULL
);           
ALTER TABLE "PUBLIC"."LAPTOPS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_2" PRIMARY KEY("ID");      
-- 4 +/- SELECT COUNT(*) FROM PUBLIC.LAPTOPS; 
INSERT INTO "PUBLIC"."LAPTOPS" VALUES
(13, 4),
(13, 5),
(15, 6),
(17, 7); 
CREATE CACHED TABLE "PUBLIC"."MONITORS"(
    "DIAGONAL" FLOAT(53) NOT NULL,
    "ID" BIGINT NOT NULL
);    
ALTER TABLE "PUBLIC"."MONITORS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_1" PRIMARY KEY("ID");     
-- 4 +/- SELECT COUNT(*) FROM PUBLIC.MONITORS;
INSERT INTO "PUBLIC"."MONITORS" VALUES
(26.0, 8),
(27.0, 9),
(28.0, 10),
(29.0, 11);      
CREATE CACHED TABLE "PUBLIC"."PERSONAL_COMPUTERS"(
    "FORM_FACTOR" CHARACTER VARYING(255) NOT NULL,
    "ID" BIGINT NOT NULL
);          
ALTER TABLE "PUBLIC"."PERSONAL_COMPUTERS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_F" PRIMARY KEY("ID");           
-- 3 +/- SELECT COUNT(*) FROM PUBLIC.PERSONAL_COMPUTERS;      
INSERT INTO "PUBLIC"."PERSONAL_COMPUTERS" VALUES
('DESKTOP', 1),
('NETTOP', 2),
('MONOBLOCK', 3);          
CREATE CACHED TABLE "PUBLIC"."PRODUCTS"(
    "TYPE" CHARACTER VARYING(31) NOT NULL,
    "ID" BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 1 RESTART WITH 15) NOT NULL,
    "PRICE" NUMERIC(38, 2) NOT NULL,
    "SERIAL_NUMBER" CHARACTER VARYING(255) NOT NULL,
    "STOCK" BIGINT NOT NULL,
    "BRAND_ID" BIGINT NOT NULL
);  
ALTER TABLE "PUBLIC"."PRODUCTS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_F2" PRIMARY KEY("ID");    
-- 14 +/- SELECT COUNT(*) FROM PUBLIC.PRODUCTS;               
INSERT INTO "PUBLIC"."PRODUCTS" VALUES
('PC', 1, 10.00, '001', 10, 1),
('PC', 2, 20.00, '002', 20, 2),
('PC', 3, 30.00, '003', 30, 2),
('LAPTOP', 4, 40.00, '004', 40, 3),
('LAPTOP', 5, 50.00, '005', 50, 3),
('LAPTOP', 6, 60.00, '006', 60, 4),
('LAPTOP', 7, 70.00, '007', 70, 4),
('MONITOR', 8, 80.00, '008', 80, 5),
('MONITOR', 9, 90.00, '009', 90, 5),
('MONITOR', 10, 100.00, '010', 100, 6),
('MONITOR', 11, 110.00, '011', 110, 6),
('HDD', 12, 120.00, '012', 120, 7),
('HDD', 13, 130.00, '013', 130, 7),
('HDD', 14, 140.00, '014', 140, 8);    
ALTER TABLE "PUBLIC"."PERSONAL_COMPUTERS" ADD CONSTRAINT "PUBLIC"."FKDR1ET3W79MLJMXCRTJTBJ9U25" FOREIGN KEY("ID") REFERENCES "PUBLIC"."PRODUCTS"("ID") NOCHECK;               
ALTER TABLE "PUBLIC"."LAPTOPS" ADD CONSTRAINT "PUBLIC"."FKC2VXQDY4UK247X24E5XOYQ3JL" FOREIGN KEY("ID") REFERENCES "PUBLIC"."PRODUCTS"("ID") NOCHECK;          
ALTER TABLE "PUBLIC"."MONITORS" ADD CONSTRAINT "PUBLIC"."FK1O9YVYPTVS6YOA9M24SY4I0O4" FOREIGN KEY("ID") REFERENCES "PUBLIC"."PRODUCTS"("ID") NOCHECK;         
ALTER TABLE "PUBLIC"."PRODUCTS" ADD CONSTRAINT "PUBLIC"."FKA3A4MPSFDF4D2Y6R8RA3SC8MV" FOREIGN KEY("BRAND_ID") REFERENCES "PUBLIC"."BRANDS"("ID") NOCHECK;     
ALTER TABLE "PUBLIC"."HARD_DISKS" ADD CONSTRAINT "PUBLIC"."FKOQA37DJ3N6JFU5T8Y09PVBPVG" FOREIGN KEY("ID") REFERENCES "PUBLIC"."PRODUCTS"("ID") NOCHECK;       
