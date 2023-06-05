INSERT INTO "PUBLIC"."BRANDS"(id, name) VALUES
(1, 'Brand 1'),
(2, 'Brand 2'),
(3, 'Brand 3'),
(4, 'Brand 4'),
(5, 'Brand 5'),
(6, 'Brand 6'),
(7, 'Brand 7'),
(8, 'Brand 8');

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

INSERT INTO "PUBLIC"."HARD_DISKS" VALUES
(320.0, 12),
(640.0, 13),
(640.0, 14);

INSERT INTO "PUBLIC"."LAPTOPS" VALUES
(13, 4),
(13, 5),
(15, 6),
(17, 7);

INSERT INTO "PUBLIC"."MONITORS" VALUES
(26.0, 8),
(27.0, 9),
(28.0, 10),
(29.0, 11);

INSERT INTO "PUBLIC"."PERSONAL_COMPUTERS" VALUES
('DESKTOP', 1),
('NETTOP', 2),
('MONOBLOCK', 3);