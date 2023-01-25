INSERT INTO category (name, description) VALUES ('Action', 'Description of action');
INSERT INTO category (name, description) VALUES ('Shonen', 'Description of shonen');
INSERT INTO category (name, description) VALUES ('Comedy', 'Description of comedy');
INSERT INTO category (name, description) VALUES ('Sports', 'Description of sports');
INSERT INTO category (name, description) VALUES ('Fantasy', 'Description of fantasy');
INSERT INTO category (name, description) VALUES ('Drama', 'Description of drama');
INSERT INTO category (name, description) VALUES ('Adventure', 'Description of adventure');
INSERT INTO category (name, description) VALUES ('Super power', 'Description of super power');



INSERT INTO anime (name, synopsis, lauch_year, avaliation, img_url) VALUES ('Dragon Ball Z', 'Dragon Ball Z follows the adventures of Goku who, along with the Z Warriors, defends the Earth against evil.', 1989, 9.0, 'https://jpimg.com.br/uploads/2018/04/dragon-ball-z.jpg');
INSERT INTO anime (name, synopsis, lauch_year, avaliation, img_url) VALUES ('Dragon Ball Super', 'After waking up from decades of slumber, Beerus, the god of destruction, wants to defeat Goku, the Super Saiyan God, whom he had seen in his sleep. Goku fights with him to save earth.', 2015, 8.3, 'https://www.einerd.com.br/wp-content/uploads/2015/12/DBSgoku.jpg');


INSERT INTO anime_category (id_anime, id_category) VALUES(1, 1);
INSERT INTO anime_category (id_anime, id_category) VALUES(1, 2);
INSERT INTO anime_category (id_anime, id_category) VALUES(1, 3);
INSERT INTO anime_category (id_anime, id_category) VALUES(1, 7);
INSERT INTO anime_category (id_anime, id_category) VALUES(1, 8);
INSERT INTO anime_category (id_anime, id_category) VALUES(2, 1);
INSERT INTO anime_category (id_anime, id_category) VALUES(2, 2);
INSERT INTO anime_category (id_anime, id_category) VALUES(2, 3);
INSERT INTO anime_category (id_anime, id_category) VALUES(2, 7);
INSERT INTO anime_category (id_anime, id_category) VALUES(2, 8);


INSERT INTO role (authority) VALUES ('ROLE_USER');
INSERT INTO role (authority) VALUES ('ROLE_WORKER');
INSERT INTO role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user (email, password) VALUES ('user@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (email, password) VALUES ('worker@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (email, password) VALUES ('admin@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO user_role (id_user, id_role) VALUES (1, 1);
INSERT INTO user_role (id_user, id_role) VALUES (2, 1);
INSERT INTO user_role (id_user, id_role) VALUES (2, 2);
INSERT INTO user_role (id_user, id_role) VALUES (3, 1);
INSERT INTO user_role (id_user, id_role) VALUES (3, 2);
INSERT INTO user_role (id_user, id_role) VALUES (3, 3);