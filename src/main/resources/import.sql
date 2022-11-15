INSERT INTO categories (id, name) VALUES ('80a89e72-47d0-11ed-b878-0242ac120003', 'Games');
INSERT INTO categories (id, name) VALUES ('80a89e72-47d0-11ed-b878-0242ac120004', 'Cars');

INSERT INTO genres (id, name) VALUES('80a89e72-47d0-11ed-b878-0242ac120014', 'fantasy');
INSERT INTO genres (id, name) VALUES('80a89e72-47d0-11ed-b878-0242ac120015', 'sport');

INSERT INTO categories_genres (category_id, genre_id) VALUES('80a89e72-47d0-11ed-b878-0242ac120003','80a89e72-47d0-11ed-b878-0242ac120014');
INSERT INTO categories_genres (category_id, genre_id) VALUES('80a89e72-47d0-11ed-b878-0242ac120003','80a89e72-47d0-11ed-b878-0242ac120015');
INSERT INTO categories_genres (category_id, genre_id) VALUES('80a89e72-47d0-11ed-b878-0242ac120004','80a89e72-47d0-11ed-b878-0242ac120015');

INSERT INTO products (id, name, description, category_id) VALUES ('0d313ace-b100-4a5e-82cd-59696de5e64c', 'Minecraft (PC)', 'Minecraft is een sandbox-game ontwikkeld door Mojang Studios. Het spel is gemaakt door Markus "Notch" Persson in de programmeertaal Java. Na verschillende vroege privé-', '80a89e72-47d0-11ed-b878-0242ac120003');
INSERT INTO products (id, name, description, category_id) VALUES ('2d313ace-b100-2a5e-82cd-59696de5e64c', 'Minecraft (PS4)', 'Minecraft is een sandbox-game ontwikkeld door Mojang Studios. Het spel is gemaakt door Markus "Notch" Persson in de programmeertaal Java. Na verschillende vroege privé-', '80a89e72-47d0-11ed-b878-0242ac120003');
INSERT INTO products (id, name, description, category_id) VALUES ('80a89e72-47d0-11ed-b878-0242ac120031', 'Minecraft (XBOX)', 'Minecraft is een sandbox-game ontwikkeld door Mojang Studios. Het spel is gemaakt door Markus "Notch" Persson in de programmeertaal Java. Na verschillende vroege privé-', '80a89e72-47d0-11ed-b878-0242ac120003');
INSERT INTO products (id, name, description, category_id) VALUES ('80a89e72-47d0-11ed-b878-0242ac120032', 'Minecraft (Switch)', 'Minecraft is een sandbox-game ontwikkeld door Mojang Studios. Het spel is gemaakt door Markus "Notch" Persson in de programmeertaal Java. Na verschillende vroege privé-', '80a89e72-47d0-11ed-b878-0242ac120003');
INSERT INTO products (id, name, description, category_id) VALUES ('80a89e72-47d0-11ed-b878-0242ac120033', 'Minecraft (Mojang)', 'Minecraft is een sandbox-game ontwikkeld door Mojang Studios. Het spel is gemaakt door Markus "Notch" Persson in de programmeertaal Java. Na verschillende vroege privé-', '80a89e72-47d0-11ed-b878-0242ac120003');
INSERT INTO products (id, name, description, category_id) VALUES ('80a89e72-47d0-11ed-b878-0242ac120034', 'Minecraft (Microsoft)', 'Minecraft is een sandbox-game ontwikkeld door Mojang Studios. Het spel is gemaakt door Markus "Notch" Persson in de programmeertaal Java. Na verschillende vroege privé-', '80a89e72-47d0-11ed-b878-0242ac120003');
INSERT INTO products (id, name, description, category_id) VALUES ('80a89e72-47d0-11ed-b878-0242ac120035', 'Minecraft (PSIX)', 'Minecraft is een sandbox-game ontwikkeld door Mojang Studios. Het spel is gemaakt door Markus "Notch" Persson in de programmeertaal Java. Na verschillende vroege privé-', '80a89e72-47d0-11ed-b878-0242ac120003');
INSERT INTO products (id, name, description, category_id) VALUES ('80a89e72-47d0-11ed-b878-0242ac120036', 'Minecraft (PIEPOE)', 'Minecraft is een sandbox-game ontwikkeld door Mojang Studios. Het spel is gemaakt door Markus "Notch" Persson in de programmeertaal Java. Na verschillende vroege privé-', '80a89e72-47d0-11ed-b878-0242ac120003');
INSERT INTO products (id, name, description, category_id) VALUES ('80a89e72-47d0-11ed-b878-0242ac120037', 'Minecraft (PIEPOE)', 'Minecraft is een sandbox-game ontwikkeld door Mojang Studios. Het spel is gemaakt door Markus "Notch" Persson in de programmeertaal Java. Na verschillende vroege privé-', '80a89e72-47d0-11ed-b878-0242ac120004');

INSERT INTO users (id, email, balance) VALUES ('80a89e72-47d0-11ed-b878-0242ac120005', 'admin@gmail.com', 5.23);
INSERT INTO users (id, email, balance) VALUES ('80a89e72-47d0-11ed-b878-0242ac120007', 'alice@gmail.com', 14.55);