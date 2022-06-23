drop table if exists status cascade;
drop table if exists fakultet cascade;
drop table if exists departman cascade;
drop table if exists student cascade;

drop sequence if exists status_id_seq;
drop sequence if exists fakultet_id_seq;
drop sequence if exists departman_id_seq;
drop sequence if exists student_id_seq;

create table status (
    id integer primary key,
    naziv varchar(100),
    oznaka varchar(10)
);

create table fakultet (
    id integer primary key,
    naziv varchar(100),
    sediste varchar(50)
);

create table departman (
    id integer primary key,
    naziv varchar(100),
    oznaka varchar(10),
    fakultet integer not null,
    constraint fk_departman_fakultet foreign key(fakultet) references fakultet(id)
);

create table student (
    id integer not null,
    ime varchar(50),
    prezime varchar(50),
    broj_indeksa varchar(20),
    status integer not null,
    departman integer not null,
    constraint fk_student_departman foreign key(departman) references departman(id),
    constraint fk_student_status foreign key(status) references status(id)
);

create index idx_pk_status on status(id);
create index idx_pk_fakultet on fakultet(id);
create index idx_pk_departman on departman(id);
create index idx_pk_student on student(id);

create index idx_fk_departman_fakultet on departman(fakultet);
create index idx_fk_student_departman on student(departman);
create index idx_fk_student_status on student(status);


create sequence status_id_seq
minvalue 0
start with 1;

create sequence fakultet_id_seq
minvalue 0
start with 1;

create sequence departman_id_seq
minvalue 0
start with 1;

create sequence student_id_seq
minvalue 0
start with 1;