create database Class
go
use Class
go

create table Student(
	Id int identity primary key,
	Name nvarchar(150),
	Gender bit,
	Birthday date,
	Address nvarchar(150),
	Phone nvarchar(120),
	ClassName nvarchar(200),
)