INSERT INTO categories (id, name) VALUES ('80a89e72-47d0-11ed-b878-0242ac120003', 'Games');
INSERT INTO categories (id, name) VALUES ('80a89e72-47d0-11ed-b878-0242ac120004', 'Cars');

INSERT INTO genres (id, name) VALUES('80a89e72-47d0-11ed-b878-0242ac120014', 'fantasy');
INSERT INTO genres (id, name) VALUES('80a89e72-47d0-11ed-b878-0242ac120015', 'sport');
INSERT INTO genres (id, name) VALUES('80a89e72-47d0-11ed-b878-0242ac120016', 'roguelike');
INSERT INTO genres (id, name) VALUES('80a89e72-47d0-11ed-b878-0242ac120017', 'adventure');
INSERT INTO genres (id, name) VALUES('80a89e72-47d0-11ed-b878-0242ac120018', 'rpg');
INSERT INTO genres (id, name) VALUES('80a89e72-47d0-11ed-b878-0242ac120019', 'sandbox');

INSERT INTO categories_genres (category_id, genre_id) VALUES('80a89e72-47d0-11ed-b878-0242ac120003','80a89e72-47d0-11ed-b878-0242ac120014');
INSERT INTO categories_genres (category_id, genre_id) VALUES('80a89e72-47d0-11ed-b878-0242ac120003','80a89e72-47d0-11ed-b878-0242ac120015');
INSERT INTO categories_genres (category_id, genre_id) VALUES('80a89e72-47d0-11ed-b878-0242ac120003','80a89e72-47d0-11ed-b878-0242ac120016');
INSERT INTO categories_genres (category_id, genre_id) VALUES('80a89e72-47d0-11ed-b878-0242ac120003','80a89e72-47d0-11ed-b878-0242ac120017');
INSERT INTO categories_genres (category_id, genre_id) VALUES('80a89e72-47d0-11ed-b878-0242ac120003','80a89e72-47d0-11ed-b878-0242ac120018');
INSERT INTO categories_genres (category_id, genre_id) VALUES('80a89e72-47d0-11ed-b878-0242ac120003','80a89e72-47d0-11ed-b878-0242ac120019');
INSERT INTO categories_genres (category_id, genre_id) VALUES('80a89e72-47d0-11ed-b878-0242ac120004','80a89e72-47d0-11ed-b878-0242ac120015');

INSERT INTO users (id, email, balance) VALUES ('80a89e72-47d0-11ed-b878-0242ac120005', 'admin@gmail.com', 5.23);
INSERT INTO users (id, email, balance) VALUES ('80a89e72-47d0-11ed-b878-0242ac120007', 'alice@gmail.com', 14.55);

INSERT INTO bid_history (id) VALUES ('80a89e72-47d0-11ed-b872-0242ac120007'); 
INSERT INTO bid_history (id) VALUES ('80a89e72-47d0-11ed-b872-0242ac120008'); 
INSERT INTO bid_history (id) VALUES ('80a89e72-47d0-11ed-b872-0242ac120009'); 
INSERT INTO bid_history (id) VALUES ('80a89e72-47d0-11ed-b872-0242ac120010'); 
INSERT INTO bid_history (id) VALUES ('80a89e72-47d0-11ed-b872-0242ac120011'); 
INSERT INTO bid_history (id) VALUES ('80a89e72-47d0-11ed-b872-0242ac120012'); 
INSERT INTO bid_history (id) VALUES ('80a89e72-47d0-11ed-b872-0242ac120013'); 
INSERT INTO bid_history (id) VALUES ('80a89e72-47d0-11ed-b872-0242ac120014'); 
INSERT INTO bid_history (id) VALUES ('80a89e72-47d0-11ed-b872-0242ac120015'); 

INSERT INTO products (id, name, description, price, category_id, bid_history_id) VALUES ('2d313ace-b100-2a5e-82cd-59696de5e64c', 'Minecraft (PS4)', 'Minecraft is een sandbox-game ontwikkeld door Mojang Studios. Het spel is gemaakt door Markus "Notch" Persson in de programmeertaal Java. Na verschillende vroege privé-', 4.33, '80a89e72-47d0-11ed-b878-0242ac120003', '80a89e72-47d0-11ed-b872-0242ac120007');
INSERT INTO products (id, name, description, price, category_id, bid_history_id) VALUES ('0d313ace-b100-4a5e-82cd-59696de5e64c', 'Minecraft (PC)', 'Minecraft is een sandbox-game ontwikkeld door Mojang Studios. Het spel is gemaakt door Markus "Notch" Persson in de programmeertaal Java. Na verschillende vroege privé-', 3.22, '80a89e72-47d0-11ed-b878-0242ac120003', '80a89e72-47d0-11ed-b872-0242ac120008');
INSERT INTO products (id, name, description, price, category_id, bid_history_id) VALUES ('80a89e72-47d0-11ed-b878-0242ac120031', 'Minecraft (XBOX)', 'Minecraft is een sandbox-game ontwikkeld door Mojang Studios. Het spel is gemaakt door Markus "Notch" Persson in de programmeertaal Java. Na verschillende vroege privé-', 14.2,'80a89e72-47d0-11ed-b878-0242ac120003', '80a89e72-47d0-11ed-b872-0242ac120009');
INSERT INTO products (id, name, description, category_id, bid_history_id) VALUES ('80a89e72-47d0-11ed-b878-0242ac120032', 'Minecraft (Switch)', 'Minecraft is een sandbox-game ontwikkeld door Mojang Studios. Het spel is gemaakt door Markus "Notch" Persson in de programmeertaal Java. Na verschillende vroege privé-', '80a89e72-47d0-11ed-b878-0242ac120003', '80a89e72-47d0-11ed-b872-0242ac120010');
INSERT INTO products (id, name, description, category_id, bid_history_id) VALUES ('80a89e72-47d0-11ed-b878-0242ac120033', 'Minecraft (Mojang)', 'Minecraft is een sandbox-game ontwikkeld door Mojang Studios. Het spel is gemaakt door Markus "Notch" Persson in de programmeertaal Java. Na verschillende vroege privé-', '80a89e72-47d0-11ed-b878-0242ac120003', '80a89e72-47d0-11ed-b872-0242ac120011');
INSERT INTO products (id, name, description, category_id, bid_history_id) VALUES ('80a89e72-47d0-11ed-b878-0242ac120034', 'Minecraft (Microsoft)', 'Minecraft is een sandbox-game ontwikkeld door Mojang Studios. Het spel is gemaakt door Markus "Notch" Persson in de programmeertaal Java. Na verschillende vroege privé-', '80a89e72-47d0-11ed-b878-0242ac120003', '80a89e72-47d0-11ed-b872-0242ac120012');
INSERT INTO products (id, name, description, category_id, bid_history_id) VALUES ('80a89e72-47d0-11ed-b878-0242ac120035', 'Minecraft (PSIX)', 'Minecraft is een sandbox-game ontwikkeld door Mojang Studios. Het spel is gemaakt door Markus "Notch" Persson in de programmeertaal Java. Na verschillende vroege privé-', '80a89e72-47d0-11ed-b878-0242ac120003', '80a89e72-47d0-11ed-b872-0242ac120013');
INSERT INTO products (id, name, description, category_id, bid_history_id) VALUES ('80a89e72-47d0-11ed-b878-0242ac120036', 'Minecraft (PIEPOE)', 'Minecraft is een sandbox-game ontwikkeld door Mojang Studios. Het spel is gemaakt door Markus "Notch" Persson in de programmeertaal Java. Na verschillende vroege privé-', '80a89e72-47d0-11ed-b878-0242ac120003', '80a89e72-47d0-11ed-b872-0242ac120014');
INSERT INTO products (id, name, description, category_id, bid_history_id) VALUES ('80a89e72-47d0-11ed-b878-0242ac120037', 'Minecraft (PIEPOE)', 'Minecraft is een sandbox-game ontwikkeld door Mojang Studios. Het spel is gemaakt door Markus "Notch" Persson in de programmeertaal Java. Na verschillende vroege privé-', '80a89e72-47d0-11ed-b878-0242ac120004', '80a89e72-47d0-11ed-b872-0242ac120015');

INSERT INTO bids (id, amount, date, user_id, bid_history_id) VALUES ('80a89e72-47d0-11ed-b872-0242ac120001', 2, '2022-12-08T15:43:21', '80a89e72-47d0-11ed-b878-0242ac120007', '80a89e72-47d0-11ed-b872-0242ac120007');
INSERT INTO bids (id, amount, date, user_id, bid_history_id) VALUES ('80a89e72-47d0-11ed-b872-0242ac120002', 4.33, '2022-12-08T16:12:42', '80a89e72-47d0-11ed-b878-0242ac120005', '80a89e72-47d0-11ed-b872-0242ac120007');
