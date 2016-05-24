
DELETE FROM book;
DELETE FROM library;
DELETE FROM author;
DELETE FROM book_author;

INSERT INTO library (id, name, optlock) VALUES (1, 'Library 1', 1);
INSERT INTO library (id, name, optlock) VALUES (2, 'Library 2', 1); 
INSERT INTO library (id, name, optlock) VALUES (3, 'Library 3', 1);
INSERT INTO library (id, name, optlock) VALUES (4, 'Library 4', 1); 
INSERT INTO library (id, name, optlock) VALUES (5, 'Library 5', 1); 
INSERT INTO library (id, name, optlock) VALUES (6, 'Library 6', 1); 

insert into book (id, title, library_id, optlock) values (1, 'Pierwsza książka', 2, 1);
insert into book (id, title, library_id, optlock) values (2, 'Druga książka', 3, 1);
insert into book (id, title, library_id, optlock) values (3, 'Trzecia książka', 2, 1);
insert into book (id, title, library_id, optlock) values (4, 'Czwarta książka', 2, 1);
insert into book (id, title, library_id, optlock) values (5, 'Piąta książka', 5, 1);
insert into book (id, title, library_id, optlock) values (6, 'Szósta książka', 2, 1);

insert into author (id, first_name, last_name, optlock) values (7, 'Jan', 'Kowalski', 1);
insert into author (id, first_name, last_name, optlock) values (8, 'Zbigniew', 'Nowak', 1);
insert into author (id, first_name, last_name, optlock) values (9, 'Janusz', 'Jankowski', 1);
insert into author (id, first_name, last_name, optlock) values (10, 'Janina', 'Ostaszewska', 1);
insert into author (id, first_name, last_name, optlock) values (11, 'Bronisław', 'Nowakowski', 1);
insert into author (id, first_name, last_name, optlock) values (12, 'Anna', 'Dymna', 1);

insert into book_author(book_id, author_id) values (1, 7);
insert into book_author(book_id, author_id) values (2, 8);
insert into book_author(book_id, author_id) values (3, 9);
insert into book_author(book_id, author_id) values (4, 10);
insert into book_author(book_id, author_id) values (5, 11);
insert into book_author(book_id, author_id) values (6, 12);