insert into fakultet
values(nextval('fakultet_id_seq'),'Fakultet tehničkih nauka','Novi Sad');
insert into fakultet
values(nextval('fakultet_id_seq'),'Poljoprivredni fakultet','Novi Sad');
insert into fakultet
values(nextval('fakultet_id_seq'),'Medicinski fakultet','Novi Sad');
insert into fakultet
values(nextval('fakultet_id_seq'),'Ekonomski fakultet','Novi Sad');
insert into fakultet
values(nextval('fakultet_id_seq'),'Filozofski fakultet','Novi Sad');
insert into fakultet
values(nextval('fakultet_id_seq'),'Fakultet tehničkih nauka','Čačak');
insert into fakultet
values(nextval('fakultet_id_seq'),'Medicinski fakultet','Beograd');
insert into fakultet
values(nextval('fakultet_id_seq'),'Medicinski fakultet','Niš');
insert into fakultet
values(nextval('fakultet_id_seq'),'Prirodno matematički fakultet','Novi Sad');
insert into fakultet
values(nextval('fakultet_id_seq'),'Fakultet organizacionih nauka','Beograd');

insert into status
values(nextval('status_id_seq'), 'Budžet', 'BDŽ');
insert into status
values(nextval('status_id_seq'), 'Samofinansiranje', 'SMF');

insert into departman
values(nextval('departman_id_seq'), 'Departman za energetiku, elektroniku i telekomunikacije', 'DEET', 1);
insert into departman
values(nextval('departman_id_seq'), 'Departman za industrijsko inženjerstvo i menadžment', 'IIM', 1);
insert into departman
values(nextval('departman_id_seq'), 'Stomatologija', 'STOM', 3);
insert into departman
values(nextval('departman_id_seq'), 'Departman za ratarstvo i povrtarstvo', 'DRP', 2);
insert into departman
values(nextval('departman_id_seq'), 'Departman za stočarstvo', 'DS', 2);
insert into departman
values(nextval('departman_id_seq'), 'Departman za veterinarsku medicinu', 'DVM', 2);
insert into departman
values(nextval('departman_id_seq'), 'Departman za menadžment', 'DM', 4);
insert into departman
values(nextval('departman_id_seq'), 'Departman za finansije i računovodstvo', 'DFR', 4);
insert into departman
values(nextval('departman_id_seq'), 'Farmacija', 'FAR', 7);
insert into departman
values(nextval('departman_id_seq'), 'Opšta medicina', 'OM', 8);

insert into student
values(nextval('student_id_seq'), 'Đorđe', 'Šević', 'IT-34/2019', 1, 2);
insert into student
values(nextval('student_id_seq'), 'Marko', 'Marković', 'IT-57/2016', 1, 2);
insert into student
values(nextval('student_id_seq'), 'Jovan', 'Jovanović', 'PR-111/2018', 1, 1);
insert into student
values(nextval('student_id_seq'), 'Petar', 'Petrović', 'PR-152/2018', 2, 1);
insert into student
values(nextval('student_id_seq'), 'Ana', 'Antić', 'SM-15/2021', 1, 3);
insert into student
values(nextval('student_id_seq'), 'Marija', 'Marković', 'SM-98/2021', 2, 3);
insert into student
values(nextval('student_id_seq'), 'Bogdan', 'Bogdanović', 'RP-100/2021', 2, 4);
insert into student
values(nextval('student_id_seq'), 'Boško', 'Jotić', 'ST-11/2020', 1, 5);
insert into student
values(nextval('student_id_seq'), 'Boško', 'Jotić', 'ST-19/2020', 1, 5);
insert into student
values(nextval('student_id_seq'), 'Marko', 'Milošević', 'FR-87/2017', 2, 8);



insert into fakultet
values(-100,'Fakultet tehničkih nauka','Novi Sad');
insert into status
values(-100, 'Budžet', 'BDŽ');
insert into departman
values(-100, 'Opšta medicina', 'OM', 8);
insert into student
values(-100, 'Marko', 'Milošević', 'FR-87/2017', 2, 8);