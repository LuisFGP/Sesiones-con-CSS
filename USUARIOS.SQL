create database Usuarios;
Use Usuarios;
create table Usuario(
	Usern	varchar(40),
    Pass	varchar(20),
    Rol		int
);
insert into Usuario values ('Luis','CHCH',1);
select *from Usuario where Usern='Luis' and Pass='CHCH';