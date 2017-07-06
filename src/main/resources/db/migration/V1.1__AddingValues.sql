INSERT INTO school(id,name,city)
VALUES
(1,'Christelijk College De Populier', 'Den Haag'),
(2,'Rudolf Steiner College Rotterdam', 'Rotterdam'),
(3,'Instituut Blankestijn', 'Utrecht'),
(4,'Visser t Hooft Lyceum', 'Leiden'),
(5,'Calandlyceum', 'Amstedam');

INSERT INTO students(id,name,birth_date)
VALUES
(1, 'Liselot Stien Angenent', '23-03-01'),
(2, 'Marjolijn Van Houtum', '03-05-02'),
(3, 'Rika Haumann', '01-12-05'),
(4, 'Reinier Alferink', '23-06-04'),
(5, 'Mariska Coolen', '05-06-03'),
(6, 'Wendelin Abbink', '31-08-04'),
(7, 'Meino Dirix', '05-10-02'),
(8, 'Ed Klein', '27-06-00'),
(9, 'Parvin Alberink', '13-11-04'),
(10, 'Stan Draper', '09-09-02'),
(11, 'Ellen Peeters', '02-03-01'),
(12, 'Angela Sault', '15-09-03'),
(13, 'Pierrick Van Denend', '14-11-03'),
(14, 'Jantje Mulder', '11-11-00'),
(15, 'Sixte Reinders', '18-02-04');


INSERT INTO ss_link(id,id_school,id_student)
VALUES
(1,1,1),
(2,1,2),
(3,1,3),
(4,2,4),
(5,2,5),
(6,2,6),
(7,3,7),
(8,3,8),
(9,3,9),
(10,4,10),
(11,4,11),
(12,4,12),
(13,5,13),
(14,5,14),
(15,5,15);


--DECLARE
--  c int := 0;
--
--BEGIN
--FOR i IN 1..5 LOOP
--    FOR j in 1..3 LOOP
--        c := c+1;
--        INSERT INTO ss_link(id, id_school,id_student) VALUES(c,i,i*j);
--    END LOOP;
--END LOOP;
--END
--$$ LANGUAGE plpgsql;
