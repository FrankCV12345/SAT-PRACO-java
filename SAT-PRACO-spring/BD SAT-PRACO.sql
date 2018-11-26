Create Database BDSatPraco
Go

Use BDSatPraco
Go
create Table Usuario
(
	IdUsuario            int	IDENTITY(1,1)		NOT NULL,
	Nombre               varchar(30)	NOT NULL,
	Apellido             varchar(50)	NOT NULL,
	Email                varchar(150)	NOT NULL,
	Contacto             varchar(14)	NOT NULL,
	IdCargo              int			NOT NULL,
	FechaNacimiento      date			NOT NULL,
	EstadoCivil			 char(1)		NOT NULL,
	Sexo                 char(1)		NOT NULL,
	Nacionalidad         varchar(50)	NOT NULL,
	Domicilio            varchar(200)	NOT NULL,
	IdDocumento          int			NOT NULL,
	NumeroDNI            varchar(14)	NOT NULL, 
)
Go
--=============TABLA Usuario===============9=
Alter Table Usuario
	Add	Constraint	PK_Usuario
	Primary	Key		(IdUsuario)
Go

--====================================================================================================================================================================================
--																					AGREGANDO TABLAS
--====================================================================================================================================================================================

--=============TABLA CARGO==================1=
Create Table Cargo
(
	IdCargo             int			IDENTITY(1,1) NOT NULL,
	NombreCargo         varchar(20)  NOT NULL 
)
Go
--============================================
--=============TABLA CARGO==================1=
Alter Table Cargo
	Add	Constraint	PK_Cargo 
	Primary	Key		(IdCargo)
Go
--============================================
--=============TABLA Documento==============2=
Create Table Documento
(
	IdDocumento         int			IDENTITY(1,1)  NOT NULL,
	Descripcion          varchar(80)  NOT NULL 
)
Go
--============================================
--=============TABLA Documento==============2=
Alter Table Documento
	Add	Constraint	PK_Documento
	Primary	Key		(IdDocumento)
Go
--============================================
--=============TABLA RegistroIngreso=======3=
create Table RegistroIngreso
(
	IdRegistroI         int	IDENTITY(1,1)	  NOT NULL,
	HoraIngreso         datetime  NOT NULL,
	IdUsuario           int       NOT NULL 
)
Go
--=============TABLA RegistroIngreso========3=
Alter Table RegistroIngreso
	Add	Constraint	PK_RegistroIngreso
	Primary	Key		(IdRegistroI)
Go
--============================================
--=============TABLA RegistroIngreso=======3=
Alter Table RegistroIngreso
	Add Constraint	FK_RegistroIngreso_Usuario
	Foreign Key		(IdUsuario)
	References		Usuario(IdUsuario)
Go
--===========================================
--============================================

--=============TABLA RegistroSalida========4=
Create Table RegistroSalida
(
	IdRegistroS        int	 IDENTITY(1,1)	 NOT NULL,
	HoraSalida         datetime  NOT NULL,
	Fecha              datetime  NOT NULL,
	IdUsuario          int	     NOT NULL,
	CantHoras          int	     NOT NULL 
)
Go
--============================================

--=============TABLA Pago===================5=
Create Table Pago
(
	IdPago              int		NOT NULL,
	Monto               money   NOT NULL,
	TotalHoras          int		NOT NULL,
	TipoMoneda          varchar(15)   NOT NULL,
	Observaciones       varchar(100)  NOT NULL,
	IdUsuario           int			  NOT NULL 
)
Go
--============================================

--=============TABLA ListTareas===============6=
CREATE TABLE ListTareas
( 
	IdTarea             int		IDENTITY(1,1)	NOT NULL,
	Descripcion         varchar(100)NOT NULL,
	CantidadHoras       int			NOT NULL,
	Estado              char(1)		NOT NULL 
)
go
--===============================================

--=============TABLA Reporte=================7=
create Table Reporte
(
	IdReporte           int		IDENTITY(1,1)	NOT NULL,
	FechaReporte        datetime	NOT NULL,
	IdUsuario           int			NOT NULL,
	TareasCumplidas     int			NOT NULL,
	TareasIncumplidas   int			NOT NULL,
	PromedioTiempoTermino decimal(5,2)  NOT NULL 
)
Go
--================================================

--=============TABLA TareaUser=====================8=
Create Table TareaUser
(
	IdTareaUser          int	IDENTITY(1,1)	NOT NULL,
	HoraInicio          datetime	 NULL,
	HoraTermino         datetime	 NULL,
	FechaTarea          datetime	NOT NULL,
	HoraInicioE        datetime	NOT NULL,
	HoraTerminoE       datetime	NOT NULL,
	IdUsuario           int		NOT NULL,
	Observacion          varchar(200)   NULL,
	IdTarea             int		NOT NULL,
	IdSupervisor        int		NOT NULL
)
Go
--================================================

--=============TABLA Usuario====================9=

--============================================
--================================================

--=============TABLA Horarios====================10=
CREATE TABLE Horarios
( 
	IdHorario           int			NOT NULL,
	FechaInico          datetime	NOT NULL,
	FechaFin            datetime	NOT NULL,
	HoraEntrada         datetime	NOT NULL,
	HoraSalida          datetime	NOT NULL,
	IdUsuario           int			NOT NULL 
)
go
--================================================


--====================================================================================================================================================================================
--																		AGREGAR	Primary	Key	A LAS TABLAS
--====================================================================================================================================================================================







--=============TABLA RegistroSalida=========4=
Alter Table RegistroSalida
	Add	Constraint	PK_RegistroSalida
	Primary	Key		(IdRegistroS)
Go
--============================================

--=============TABLA Pago===================5=
Alter Table Pago
	Add	Constraint	PK_Pago
	Primary	Key		(IdPago)
Go
--============================================

--=============TABLA ListTareas=============6=
Alter Table ListTareas
	Add	Constraint	PK_ListTareas
	Primary	Key		(IdTarea)
Go
--============================================

--=============TABLA Reporte========7=
Alter Table Reporte
	Add	Constraint	PK_Reporte
	Primary	Key		(IdReporte)
Go
--============================================

--=============TABLA TareaUser==============8=
Alter Table TareaUser
	Add	Constraint	PK_TareaUser
	Primary	Key		(IdTareaUser)
Go
--============================================



--=============TABLA Horarios===============10=
Alter Table Horarios
	Add	Constraint	PK_Horarios
	Primary	Key		(IdHorario)
Go
--============================================


--====================================================================================================================================================================================
--																AGREGANDO Foreign Key A LAS TABLAS CON RELACION(USUARIO)
--====================================================================================================================================================================================



--=============TABLA RegistroSalida========4=
Alter Table RegistroSalida
	Add Constraint	FK_RegistroSalida_Usuario
	Foreign Key		(IdUsuario)
	References		Usuario(IdUsuario)
Go
--===========================================

--=============TABLA Pago===================5=
Alter Table Pago
	Add Constraint	FK_Pago_Usuario
	Foreign Key		(IdUsuario)
	References		Usuario(IdUsuario)
Go
--===========================================

--=============TABLA Horarios===============10=
Alter Table Horarios
	Add Constraint	FK_Horarios_Usuario
	Foreign Key		(IdUsuario)
	References		Usuario(IdUsuario)
Go
--============================================

--=============TABLA Reporte================7=
Alter Table Reporte
	Add Constraint	FK_Reporte_Usuario
	Foreign Key		(IdUsuario)
	References		Usuario(IdUsuario)
Go
--==============================================

--=============TABLA TareaUser================8=
Alter Table TareaUser
	Add Constraint	FK_TareaUser_Usuario
	Foreign Key		(IdUsuario)
	References		Usuario(IdUsuario)
Go

Alter table TareaUser
	Add Constraint	FK_TareaUser_TareaUser
	Foreign Key		(IdSupervisor)
	References		Usuario(IdUsuario)
Go

Alter Table TareaUser
	Add Constraint	FK_TareaUser_ListTareas
	Foreign Key		(IdTarea)
	References		ListTareas(IdTarea)
Go
--=============TABLA Usuario==================9=
Alter Table Usuario
	Add Constraint	FK_Usuario_Cargo
	Foreign Key		(IdCargo)
	References		Cargo(IdCargo)
Go

Alter Table Usuario
	Add Constraint	FK_Usuario_Documento
	Foreign Key		(IdDocumento)
	References		Documento(IdDocumento)
Go
--==============================================


--==============================================
--===== inserto cargos===========
insert into Cargo values('empleado')
go
insert into Cargo values('supervisor')
go
insert into Cargo values('administrador')
go
select * from cargo
go
--===================================
--=========== inserto documentos  ==========
insert into Documento values('DNI')
go
--======================================
--============ inserto usarios =========
insert into Usuario values('julio','del carpio rodrigez','julio@gmail.com','990418967',1,'10/10/1996','S','M','PERUANO','CALLE SU CASA 101',1,'71055668')
go
insert into Usuario values('Andrea','lopez rajina','Andrea@gmail.com','990418966',2,'10/10/1996','S','F','PERUANA','CALLE SU CASA 102',1,'71055468')
go
select * from Usuario
go
--======= inserto ingreso ===============
insert  into RegistroIngreso values(SYSDATETIME (), 1)
go


create  PROCEDURE Proc_reg_entrada
@id_user  int
AS 
insert  into RegistroIngreso values(SYSDATETIME (), @id_user);
go

 create procedure Proc_verRI
@id_usu int
as
select RegistroIngreso.HoraIngreso from RegistroIngreso where FORMAT(HoraIngreso,'dd/MM/yyyy')  = FORMAT(GETDATE(),'dd/MM/yyyy')  and RegistroIngreso.IdUsuario = @id_usu
go

create procedure Proc_busca_usu
 @id_usu int
 as
 select Usuario.IdUsuario from Usuario where Usuario.IdUsuario =  @id_usu
go

select * from RegistroIngreso
go
select * from Usuario
go

Proc_verRI 2
go

create procedure proc_fechaingreso
@id_usu int
as
select DATEDIFF(HOUR, RegistroIngreso.HoraIngreso,SYSDATETIME()) from RegistroIngreso  where  RegistroIngreso.IdUsuario = @id_usu and FORMAT(HoraIngreso,'dd/MM/yyyy')  = FORMAT(GETDATE(),'dd/MM/yyyy')
go

 proc_fechaingreso 1
 go
create procedure proc_registrasalida
@id_usu int,
@horas int
as
insert into RegistroSalida values(SYSDATETIME(),GETDATE(),@id_usu,@horas)
go

create procedure proc_list_tipo_doc
as
select * from Documento
go

create procedure proc_list_cargo
as
select * from cargo
go
proc_list_cargo
go
create procedure proc_registra_user
@nombres varchar(30),
@apellidos varchar(50),
@email varchar(150),
@contacto varchar(14),
@cargo int,
@fechaNac date,
@estadocivil char(1),
@sexo char(1),
@Nacionalidad varchar(50),
@domicilio varchar(200),
@idDoc  int,
@nroDini varchar(14)
as
insert into Usuario values(@nombres,@apellidos,@email,@contacto,@cargo,@fechaNac,@estadocivil,@sexo,@Nacionalidad,@domicilio,@idDoc,@nroDini )
go
proc_registra_user 'pedrito','clavo un clavito','pedrito@gmail.com','990412967',1,'10/10/1996','S','M','PERUANO','CALLE SU CASA 202',1,'71055658'
go
select * from Usuario
go

insert into ListTareas values('IR A DEJAR FACTURA',2,'1')
go
insert into ListTareas values('REDACTAR INFORME MENSUAL',18,'1')
go
select * from ListTareas
go


create PROCEDURE proc_asignaTarea

@horarinicioE varchar(180),
@horaTerminoE varchar(180),
@id_user int,
@observacion varchar(200),
@idTarea int,
@idSupervisor int
as
insert into TareaUser values(NULL,NULL,SYSDATETIME(),convert (datetime,@horarinicioE),convert (datetime,@horaTerminoE),@id_user,@observacion,@idTarea,@idSupervisor)
go


create procedure proc_alteraHoraInicio
@HoraInicio datetime,
@idTarea int
as
UPDATE TareaUser SET HoraInicio =@HoraInicio WHERE IdTareaUser = @idTarea
go

create procedure proc_alteraHoraTermino
@HoraTermino datetime,
@idTarea int
as
UPDATE TareaUser SET HoraTermino =@HoraTermino WHERE IdTareaUser = @idTarea
go



 

 create procedure proc_listaUser
 as
 select Usuario.*, Cargo.NombreCargo
  from Usuario JOIN Cargo on Usuario.IdCargo = Cargo.IdCargo
 go
 proc_listaUser 
go
 create procedure proc_listTareas
 as 
 select * from ListTareas where ListTareas.Estado = '1'
 go
create procedure proc_listTareasPorUser
@id_user int
as
select TareaUser.*, ListTareas.Descripcion from TareaUser join ListTareas on ListTareas.IdTarea
 = TareaUser.IdTarea where TareaUser.IdUsuario = @id_user
go
proc_listTareasPorUser 1
go

create procedure Proc_Login
 @id_usu int
 as
 select IdUsuario,Nombre,Apellido,IdCargo from Usuario where Usuario.IdUsuario =  @id_usu
go

proc_listTareasPorUser 2
go
create procedure insertaTareas
@descrip varchar(100),
@horas int,
@estado char(1)
as
insert into ListTareas values(@descrip,@horas,@estado)
go
insertaTareas 'INSTALAR FOCO3',3,'1'
GO
CREATE PROCEDURE updateTarea
@id int,
@descrip varchar(100),
@horas int,
@estado char(1)
as
update ListTareas set Descripcion = @descrip,CantidadHoras = @horas ,Estado=@estado where ListTareas.IdTarea = @id
go
updateTarea 3,'ENTREGAR PEDIDOO',3,'1'
go


proc_alteraHoraInicio '2018-11-19T12:08:36',30
 go
 proc_alteraHoraTermino '2018-11-25T21:08:20',30
 go
create procedure procListaTareasParaRerporte
@id_usu int,
@fecha datetime
as
select * from TareaUser where TareaUser.FechaTarea > @fecha and TareaUser.IdUsuario = @id_usu
go
create procedure procRegistraReporte
@fecha datetime,
@id_user int,
@tareasCum int,
@tareasIncum int,
@promedioTiempo decimal(5,2)
as
 insert into Reporte values(@fecha,@id_user,@tareasCum,@tareasIncum,@promedioTiempo)
 go
 
select * from Reporte
go