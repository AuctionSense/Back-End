INSERT INTO categories (id, name) VALUES ('80a89e72-47d0-11ed-b878-0242ac120003', 'Games');
INSERT INTO categories (id, name) VALUES ('80a89e72-47d0-11ed-b878-0242ac120004', 'Cars');

INSERT INTO genres (id, name) VALUES('80a89e72-47d0-11ed-b878-0242ac120014', 'fantasy');
INSERT INTO genres (id, name) VALUES('80a89e72-47d0-11ed-b878-0242ac120015', 'sport');

INSERT INTO categories_genres (category_id, genre_id) VALUES('80a89e72-47d0-11ed-b878-0242ac120003','80a89e72-47d0-11ed-b878-0242ac120014');
INSERT INTO categories_genres (category_id, genre_id) VALUES('80a89e72-47d0-11ed-b878-0242ac120003','80a89e72-47d0-11ed-b878-0242ac120015');
INSERT INTO categories_genres (category_id, genre_id) VALUES('80a89e72-47d0-11ed-b878-0242ac120004','80a89e72-47d0-11ed-b878-0242ac120015');

INSERT INTO products (id, name, description, category_id) VALUES ('0d313ace-b100-4a5e-82cd-59696de5e64c', 'testItemOne', 'This is the first item!', '80a89e72-47d0-11ed-b878-0242ac120003');
INSERT INTO products (id, name, description, category_id) VALUES ('2d313ace-b100-2a5e-82cd-59696de5e64c', 'testItemTwo', 'This is the second item!', '80a89e72-47d0-11ed-b878-0242ac120004');

INSERT INTO users (id, email, balance) VALUES ('80a89e72-47d0-11ed-b878-0242ac120005', 'admin@gmail.com', 5.23);
INSERT INTO users (id, email, balance) VALUES ('80a89e72-47d0-11ed-b878-0242ac120007', 'alice@gmail.com', 14.55);