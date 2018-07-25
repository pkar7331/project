

INSERT INTO super_admin(id_super_admin, email, password) values
  (1, "superadmin1@example.com", "$2a$10$bhSTxAHcHPUHlDQiWfD05.c2.XbeiBiSY52awbCMTaT9kKOBWSq/O")
;

INSERT INTO admin(id_admin, email, enabled, password, role, token) values
  (1, "admin1@example.com", true,"$2a$04$XzXzwlx4J1VK/jJ9V.uRh.WGoEH.vFlHyo9zGlL95ZoQNG8S6uaMy", "ROLE_ADMIN", "xxx"),
  (2, "admin2@example.com", true,"$2a$04$ty6JAW4UApzW/rowYbUdWuA9.SfUsjqTrs426h3n4GWDY8rnNQtS.", "ROLE_ADMIN", "xxx")
;

INSERT INTO company(id_company, city, description, flat_number, name, phone, post_code, street, id_admin) values
  (1, "Warszawa", "Firma zajmujaca sie oprogramowaniem", 23, "Asseco", "123434535", "23-440", "Hoffmanowej",1),
  (2, "Poznan", "Firma zajmujaca sie reklama", 34, "Grafica", "432146456", "11-490", "Pilsudskiego",2),
  (3, "Krakow", "Firma zajmujaca sie handlem", 456, "Allegro", "123432433", "56-345", "Krolewska",1),
  (4, "Gdansk", "Firma zajmujaca sie transportem", 678, "Logistics", "1234", "22-456", "Mariacka",1),
  (5, "Wroclaw", "Firma zajmujaca sie produkcja", 45, "Production", "1234", "76-445", "Swidnicka",1)
;

INSERT INTO customer(id_customer, first_name, last_name, email, phone, comment, id_company) values
  (1,"Błazej", "Wisniewski", "bwis@mail.com", "345345237", "komentarz 1",1),
  (2,"Boleslaw", "Dudek", "bdus@mail.com", "345645786", "komentarz 2",1),
  (3,"Anna", "Rybak", "aryb@mail.com", "456456445", "komentarz 3",1),
  (4,"Michal", "Michalski", "mmic@mail.com", "578567445", "komentarz 4",2),
  (5,"Mikolaj", "Kaczmarek", "mkac@mail.com", "746356567", "komentarz 5",2),
  (6,"Anastazja", "Janik", "ajan@mail.com", "134364575", "komentarz 6",2),
  (7,"Zofia", "Kowalska", "zkow@mail.com", "789857634", "komentarz 7",3),
  (8,"Maciej", "Zak", "mzak@mail.com", "477574545", "komentarz 8",2),
  (9,"Michał", "Nowak", "mnow@mail.com", "234665744", "komentarz 9",1),
  (10,"Aleksander", "Jaworski", "ajaw@mail.com", "355758567", "komentarz 10",3),
  (11,"Hubert", "Krupa", "hkru@mail.com", "576756755", "komentarz 11",1),
  (12,"Zofia", "Sobczyk", "zsob@mail.com", "345345345", "komentarz 12",2),
  (13,"Maksymilian", "Ostrowski", "most@mail.com", "538385567", "komentarz 13",3),
  (14,"Marta", "Grabowska", "mgra@mail.com", "285856893", "komentarz 14",1),
  (15,"Jan", "Wrobel", "jwro@mail.com", "853673467", "komentarz 15",3),
  (16,"Karol", "Sikorski", "ksik@mail.com", "696764244", "komentarz 16",1),
  (17,"Aleksandra", "Krawczyk", "akra@mail.com", "875856374", "komentarz 17",3),
  (18,"Kacper", "Jasinski", "kjas@mail.com", "285675755", "komentarz 18",2),
  (19,"Hanna", "Kowalik", "hkow@mail.com", "967834633", "komentarz 19zzzz",1),
  (20,"Oskar", "Sokolowski", "osok@mail.com", "758674643", "komentarz 20",3),
  (21,"Patryk", "Kluk", "systemzarzadzaniawizytami@gmail.com", "123456789", "komentarz 21", 1)
;

INSERT INTO employee(id_employee, first_name, last_name,id_company) values
  (1,"Zuzanna", "Wlodarczyk", 1),
  (2,"Wojciech", "Piotrkowkski", 2),
  (3,"Julianna", "Gorska", 3),
  (4,"Julian", "Tomaszewski", 4),
  (5,"Hubert", "Nowak", 5),
  (6,"Maria", "Muszynska", 1),
  (7,"Jakub", "Wojciechowski", 2),
  (8,"Boleslaw", "Nowak", 3),
  (9,"Marcin", "Kania", 4),
  (10,"Aleksander", "Jakubowski", 5),
  (11,"Slawomir", "Rosicki", 1),
  (12,"Marcin", "Wolak", 2),
  (13,"Marian", "Kowal", 3),
  (14,"Dariusz", "Janowski", 4),
  (15,"Hanna", "Jackowska", 5),
  (16,"Andrzej", "Szymanski", 1),
  (17,"Witold", "Borowski", 2),
  (18,"Jan", "Nowacki", 3),
  (19,"Kamil", "Rowinski", 4),
  (20,"Emil", "Rozycki", 5)
;

INSERT INTO notification_template(id_notification_template, name, content) values
  (1,"Powiadomienie 1","Potwierdz swoja wizyte"),
  (2,"Powiadomienie 2","Przypominamy o nadchodzacej wizycie")
;

INSERT INTO notification(id_notification, date, send, error, id_notification_template, id_visit) values
  (1, "2018-05-24 10:00", true, false, 1,  1),
  (2, "2018-05-24 10:00", true, false, 1,  2),
  (3, "2018-05-10 10:00", true, false, 1,  3),
  (4, "2018-05-21 10:00", true, false, 1,  4),
  (5, "2018-05-17 10:00", true, false, 1,  5),
  (6, "2018-05-27 10:00", true, false, 1,  6),
  (7, "2018-05-28 10:00", true, false, 1,  7),
  (8, "2018-05-20 10:00", true, false, 1,  8),
  (9, "2018-05-23 10:00", true, false, 1,  9),
  (10,"2018-06-12 10:00", true, false, 1, 10),
  (11,"2018-05-30 10:00", true, false, 1, 11),
  (12,"2018-05-22 10:00", true, false, 1, 12),
  (13,"2018-05-21 10:00", true, false, 1, 13),
  (14,"2018-05-29 10:00", true, false, 1, 14),
  (15,"2018-05-11 10:00", true, false, 1, 15),
  (16,"2018-06-10 10:00", true, false, 1, 16),
  (17,"2018-06-2  10:00", true, false, 1, 17),
  (18,"2018-05-15 10:00", true, false, 1, 18),
  (19,"2018-05-19 10:00", true, false, 1, 19),
  (20,"2018-05-16 10:00", true, false, 1, 20),
  (21, "2018-05-23 10:00", true, false, 1,  21),
  (22, "2018-05-23 10:00", true, false, 1,  22),
  (23, "2018-05-9 10:00", true, false, 1,  23),
  (24, "2018-05-20 10:00", true, false, 1,  24),
  (25, "2018-05-16 10:00", true, false, 1,  25),
  (26, "2018-05-26 10:00", true, false, 1,  26),
  (27, "2018-05-27 10:00", true, false, 1,  27),
  (28, "2018-05-21 10:00", true, false, 1,  28),
  (29, "2018-05-22 10:00", true, false, 1,  29),
  (30, "2018-05-17 10:00", true, false, 1, 30),
  (31, "2018-05-23 10:00", true, false, 1,  31),
  (32, "2018-05-23 10:00", true, false, 1,  32),
  (33, "2018-05-9 10:00", true, false, 1,  33),
  (34, "2018-05-20 10:00", true, false, 1,  34),
  (35, "2018-05-16 10:00", true, false, 1,  35),
  (36, "2018-05-26 10:00", true, false, 1,  36),
  (37, "2018-05-27 10:00", true, false, 1,  37),
  (38, "2018-05-19 10:00", true, false, 1,  38),
  (39, "2018-05-22 10:00", true, false, 1,  39),
  (40, "2018-05-15 10:00", true, false, 1, 40),
  (41, "2018-05-23 10:00", true, false, 1,  41),
  (42, "2018-05-23 10:00", true, false, 1,  42),
  (43, "2018-05-9 10:00", true, false, 1,  43),
  (44, "2018-05-20 10:00", true, false, 1,  44),
  (45, "2018-05-16 10:00", true, false, 1,  45),
  (46, "2018-05-26 10:00", true, false, 1,  46),
  (47, "2018-05-27 10:00", true, false, 1,  47),
  (48, "2018-05-19 10:00", true, false, 1,  48),
  (49, "2018-05-15 10:00", true, false, 1, 49),
  (50, "2018-05-22 10:00", true, false, 1,  50)

;

INSERT INTO user(id_user, email, enabled, password, role, id_company, id_admin, id_user_settings) values
  (1,"user1@example.com",true,"$2a$04$akXNDuikHTJXHG2YJDkqEu.VZCSPboOHkNedKNg92qNwd0kmv2ES6","ROLE_USER",1,1,null),
  (2,"user2@example.com",true,"$2a$04$WclF6TNebFc/FhlN9V0lrumxQaCjJ9ZpLka0JaS.WwVLUWjHYd2bS","ROLE_USER",2,2,null),
  (3,"user3@example.com",true,"$2a$04$njAlrvnkwVEc8i//FVguSe5hdJpfEKMXc9IZ6rOu22cSgPOz9HDnm","ROLE_USER",3,2,null),
  (4,"user4@example.com",true,"$2a$04$1SW5hcjUDPOb6wdDGAi0V.f60N4yBayQX1VJUXU4dT7yfJgIrFIky","ROLE_USER",4,1,null),
  (5,"user5@example.com",true,"$2a$04$kxskrx/o9mwW4rDxuZ4ZQegT7XsNh818Ho/p5rhiwADsniqycJoEu","ROLE_USER",5,1,null)
;

INSERT INTO visit(id_visit, canceled, completed, description, end, start, verification, id_customer, id_employee, id_company, title) VALUES
  (1, false, true, "Opis wizyty 1", "2018-05-24 14:00","2018-05-24 12:00", false, 2, 1, 1, "Wizyta 1"),
  (2, false, true, "Opis wizyty 2", "2018-05-24 18:00","2018-05-24 16:00", false, 4, 2, 2, "Wizyta 2"),
  (3, false, true, "Opis wizyty 3", "2018-05-10 14:00","2018-05-10 12:00", false, 3, 6, 1, "Wizyta 3"),
  (4, false, true, "Opis wizyty 4", "2018-05-21 14:00","2018-05-21 12:00", true, 6, 7, 2, "Wizyta 4"),
  (5, false, true, "Opis wizyty 5", "2018-05-17 14:00","2018-05-17 12:00", false, 5, 8, 3, "Wizyta 5"),
  (6, false, false, "Opis wizyty 6", "2018-05-27 14:00","2018-05-27 12:00", false, 1, 9, 4, "Wizyta 6"),
  (7, false, false, "Opis wizyty 7", "2018-05-28 18:00","2018-05-28 15:00", true, 9, 3, 3, "Wizyta 7"),
  (8, false, true, "Opis wizyty 8", "2018-05-20 14:00","2018-05-20 13:00", false, 7, 5, 5, "Wizyta 8"),
  (9, false, true, "Opis wizyty 9", "2018-05-23 14:00","2018-05-23 12:00", false, 10, 8, 3, "Wizyta 9"),
  (10, false, false, "Opis wizyty 10", "2018-06-12 14:00", "2018-06-12 11:00", false, 8, 10, 5, "Wizyta 10"),
  (11, false, false, "Opis wizyty 11", "2018-05-30 14:00", "2018-05-30 12:00", false, 12, 7, 2, "Wizyta 11"),
  (12, false, true, "Opis wizyty 12", "2018-05-22 18:00", "2018-05-22 17:00", true, 15, 11, 1, "Wizyta 12"),
  (13, false, true, "Opis wizyty 13", "2018-05-21 14:00","2018-05-21 13:00", false, 13, 3, 3, "Wizyta 13"),
  (14, false, false, "Opis wizyty 14", "2018-05-29 14:00", "2018-05-29 12:00", false, 11, 14, 4, "Wizyta 14"),
  (15, false, true, "Opis wizyty 15", "2018-05-11 14:00", "2018-05-11 11:00", false, 14, 8, 3, "Wizyta 15"),
  (16, false, false, "Opis wizyty 16", "2018-06-10 14:00", "2018-06-10 13:00", true, 12, 7, 2, "Wizyta 16"),
  (17, false, false, "Opis wizyty 17", "2018-06-2 18:00", "2018-06-2 15:00", false, 18, 4, 4, "Wizyta 17"),
  (18, false, true, "Opis wizyty 18", "2018-05-15 14:00", "2018-05-15 13:00", false, 20, 2, 2, "Wizyta 18"),
  (19, false, true, "Opis wizyty 19", "2018-05-19 14:00", "2018-05-19 12:00", true, 17, 15, 5, "Wizyta 19"),
  (20, false, true, "Opis wizyty 20", "2018-05-16 14:00", "2018-05-16 13:00", false, 19, 13, 3, "Wizyta 20"),
  (21, false, true, "Opis wizyty 21", "2018-05-23 10:00","2018-05-23 9:00", false, 5, 16, 1, "Wizyta 21"),
  (22, false, true, "Opis wizyty 22", "2018-05-22 12:00","2018-05-22 11:00", false, 7, 12, 2, "Wizyta 22"),
  (23, false, true, "Opis wizyty 23", "2018-05-11 10:00","2018-05-11 8:00", false, 12, 6, 1, "Wizyta 23"),
  (24, false, true, "Opis wizyty 24", "2018-05-23 10:00","2018-05-23 8:00", true, 14, 7, 2, "Wizyta 24"),
  (25, false, true, "Opis wizyty 25", "2018-05-16 10:00","2018-05-16 8:00", false, 3, 8, 3, "Wizyta 25"),
  (26, false, false, "Opis wizyty 26", "2018-05-26 10:00","2018-05-26 8:00", false, 2, 19, 4, "Wizyta 26"),
  (27, false, false, "Opis wizyty 27", "2018-05-28 12:00","2018-05-28 10:00", true, 7, 18, 3, "Wizyta 27"),
  (28, false, true, "Opis wizyty 28", "2018-05-21 11:00","2018-05-21 9:00", false, 8, 5, 5, "Wizyta 28"),
  (29, false, true, "Opis wizyty 29", "2018-05-20 10:00","2018-05-20 8:00", false, 1, 8, 3, "Wizyta 29"),
  (30, false, true, "Opis wizyty 30", "2018-05-24 8:00","2018-05-24 7:00", false, 13, 1, 1, "Wizyta 30"),
  (31, false, true, "Opis wizyty 31", "2018-05-25 10:00","2018-05-25 8:00", false, 20, 1, 1, "Wizyta 31"),
  (32, false, true, "Opis wizyty 32", "2018-05-24 13:00","2018-05-24 12:00", false, 15, 2, 2, "Wizyta 32"),
  (33, false, true, "Opis wizyty 33", "2018-05-12 10:00","2018-05-12 8:00", false, 16, 6, 1, "Wizyta 33"),
  (34, false, true, "Opis wizyty 34", "2018-05-22 10:00","2018-05-22 9:00", true, 19, 17, 2, "Wizyta 34"),
  (35, false, true, "Opis wizyty 35", "2018-05-15 10:00","2018-05-15 8:00", false, 11, 8, 3, "Wizyta 35"),
  (36, false, false, "Opis wizyty 36", "2018-05-28 10:00","2018-05-28 9:00", false, 4, 9, 4, "Wizyta 36"),
  (37, false, false, "Opis wizyty 37", "2018-05-29 13:00","2018-05-29 12:00", true, 6, 3, 3, "Wizyta 37"),
  (38, false, true, "Opis wizyty 38", "2018-05-20 9:00","2018-05-20 7:00", false, 9, 5, 5, "Wizyta 38"),
  (39, false, true, "Opis wizyty 39", "2018-05-23 10:00","2018-05-23 8:00", false, 17, 8, 3, "Wizyta 39"),
  (40, false, true, "Opis wizyty 40", "2018-05-22 10:00","2018-05-22 9:00", false, 3, 1, 1, "Wizyta 40"),
  (41, false, true, "Opis wizyty 41", "2018-05-24 11:00","2018-05-24 9:00", false, 10, 1, 1, "Wizyta 41"),
  (42, false, true, "Opis wizyty 42", "2018-05-26 14:00","2018-05-26 13:00", false, 1, 2, 2, "Wizyta 42"),
  (43, false, true, "Opis wizyty 43", "2018-05-12 11:00","2018-05-12 10:00", false, 5, 6, 1, "Wizyta 43"),
  (44, false, true, "Opis wizyty 44", "2018-05-21 10:00","2018-05-21 9:00", true, 7, 7, 2, "Wizyta 44"),
  (45, false, true, "Opis wizyty 45", "2018-05-15 13:00","2018-05-15 11:00", false, 3, 8, 3, "Wizyta 45"),
  (46, false, false, "Opis wizyty 46", "2018-05-26 14:00","2018-05-26 12:00", false, 15, 9, 4, "Wizyta 46"),
  (47, false, false, "Opis wizyty 47", "2018-05-28 13:00","2018-05-28 12:00", true, 13, 13, 3, "Wizyta 47"),
  (48, false, true, "Opis wizyty 48", "2018-05-23 11:00","2018-05-23 10:00", false, 8, 5, 5, "Wizyta 48"),
  (49, false, true, "Opis wizyty 49", "2018-05-22 10:00","2018-05-22 9:00", false, 13, 8, 3, "Wizyta 49"),
  (50, false, false, "Opis wizyty 50", "2018-06-12 10:00", "2018-06-12 8:00", false, 19, 20, 5, "Wizyta 50")

;

INSERT INTO attribute_pattern(id_attribute_pattern, name, obligatory, regex, id_company, id_user) VALUES
(1, 'wzorzec 1', 0, '[0..9]*', 1, 1)
;

INSERT INTO system_settings(id_system_settings, email_address, email_login, email_password, email_server, email_protocols, activated) VALUES
(1, 'systemzarzadzaniawizytami@gmail.com', 'systemzarzadzaniawizytami@gmail.com', 'adamnowak#1', 'smtp.gmail.com', 'z', true)
;