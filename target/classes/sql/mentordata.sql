ALTER TABLE POST
  ALTER COLUMN create_date SET DEFAULT CURRENT_TIMESTAMP;

-- Users
-- password in plaintext: "password"
INSERT INTO USER (user_id, password, email, username, name, last_name, active)
VALUES
  (1, '$2a$06$OAPObzhRdRXBCbk7Hj/ot.jY3zPwR8n7/mfLtKIgTzdJa4.6TwsIm', 'manvydas@jauga.lt', 'manvydas', 'Manvydas', 'Jauga',
   1);
-- password in plaintext: "password"
INSERT INTO USER (user_id, password, email, username, name, last_name, active)
VALUES
  (2, '$2a$06$OAPObzhRdRXBCbk7Hj/ot.jY3zPwR8n7/mfLtKIgTzdJa4.6TwsIm', 'johndoe@gmail.com', 'johndoe', 'John', 'Doe', 1);
-- password in plaintext: "password"
INSERT INTO USER (user_id, password, email, username, name, last_name, active)
VALUES (3, '$2a$06$OAPObzhRdRXBCbk7Hj/ot.jY3zPwR8n7/mfLtKIgTzdJa4.6TwsIm', 'ana@mail.com', 'ana', 'Ana', 'Surname', 1);

-- Roles
INSERT INTO ROLE (role_id, role)
VALUES (1, 'ROLE_ADMIN');
INSERT INTO ROLE (role_id, role)
VALUES (2, 'ROLE_USER');

-- User Roles
INSERT INTO USER_ROLE (user_id, role_id)
VALUES (1, 1);
INSERT INTO USER_ROLE (user_id, role_id)
VALUES (1, 2);
INSERT INTO USER_ROLE (user_id, role_id)
VALUES (2, 2);
INSERT INTO USER_ROLE (user_id, role_id)
VALUES (3, 2);

-- Posts
INSERT INTO POST (post_id, user_id, title, body, create_date)
VALUES (1, 1, 'Spring karkasas',
        'Spring prasidėjo kaip lengvesnė Java enterprise edition alternatyva. Vietoj sunkių enterprise JavaBeans (EJB) komponentų kūrimo Spring leido kurti java aplikacijas paprasčiau – naudojant priklausomybės injekciją (dependency injection) ir aspektais orientuotą programavimą tam, kad pasiekti EJB galimybes naudojant POJO. Priklausomybės injekcija yra programinės įrangos dizaino modelis, kuriuo sprendžiama priklausomybės problema. Priklausomybės injekcija leidžia klasėms viena kitą naudoti, išlaikant jas nepriklausomas.',
        --         CURRENT_TIMESTAMP());
        {ts '2016-10-19 11:10:13.247'});
INSERT INTO POST (post_id, user_id, title, body, create_date)
VALUES (2, 1, 'Spring MVC problemos',
        'Nors Spring buvo pakankamai lengvas žiūrint iš rašomo kodo perspektyvos, buvo labai daug konfiguracijų, kurios apsunkindavo aplikacijų kūrimą. Spring MVC buvo konfiguruojamas arba su daugybe XML failiukų arba su anotacijomis. Spring 3.0 pristatė Java paremta konfiguraciją, tačiau konfiguracijų skaičius nesumažėjo. Visos konfiguracijos apsunkina programų kūrimą. Mąstymas kaip sukonfiguruoti Spring atitraukia nuo mąstymo kaip išspręsti programuojamą problemą. Tai yra esminė Spring MVC problema',
        --         CURRENT_TIMESTAMP());
        {ts '2016-11-10 11:10:13.247'});


