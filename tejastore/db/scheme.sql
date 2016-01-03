CREATE TABLE Articulo(
 codigo serial UNIQUE NOT NULL,
 nombre varchar(50),
 precio_compra float,
 precio_venta float,
 stock_min integer,
 stock_max integer,
PRIMARY KEY (codigo));

CREATE TABLE Empresa(
 cuit varchar(50) NOT NULL,
 nombre varchar(50),
 email varchar(50),
PRIMARY KEY (cuit));

CREATE TABLE Turno(
 id varchar(50) NOT NULL,
 h_entrada date,
 h_salida date,
PRIMARY KEY (id));

CREATE TABLE Persona(
 dni varchar(50) NOT NULL,
 nombre varchar(100),
 apellido varchar(50),
 email varchar(50),
 cuil varchar(50),
 fecha_nacimiento varchar(50),
PRIMARY KEY (dni));

CREATE TABLE Telefono(
 numero varchar(50) NOT NULL,
 codigo varchar(50),
 tipo varchar(50),
 cuit varchar(50) NOT NULL,
FOREIGN KEY (cuit) REFERENCES Empresa (cuit),
PRIMARY KEY (numero));

CREATE TABLE Rel4(
 id varchar(50) NOT NULL,
 dni varchar(50) NOT NULL,
FOREIGN KEY (id) REFERENCES Turno (id),
FOREIGN KEY (dni) REFERENCES Persona (dni),
PRIMARY KEY (id,dni));

CREATE TABLE Empleado(
 dni varchar(50) NOT NULL,
FOREIGN KEY (dni) REFERENCES Persona (dni),
PRIMARY KEY (dni));

CREATE TABLE Gerente(
 dni varchar(50) NOT NULL,
FOREIGN KEY (dni) REFERENCES Persona (dni),
PRIMARY KEY (dni));

CREATE TABLE Pais(
 id varchar(50) NOT NULL,
 nombre varchar(50),
PRIMARY KEY (id));

CREATE TABLE Rubro(
 id varchar(50) NOT NULL,
 nombre varchar(50),
PRIMARY KEY (id));

CREATE TABLE Rel8(
 codigo serial NOT NULL,
 cuit varchar(50) NOT NULL,
FOREIGN KEY (codigo) REFERENCES Articulo (codigo),
FOREIGN KEY (cuit) REFERENCES Empresa (cuit),
PRIMARY KEY (codigo,cuit));

CREATE TABLE Venta(
 id varchar(50) NOT NULL,
 monto varchar(50),
 horario varchar(50),
 dni varchar(50) NOT NULL,
FOREIGN KEY (dni) REFERENCES Persona (dni),
PRIMARY KEY (id));

CREATE TABLE Contiene(
 codigo serial NOT NULL,
 id varchar(50) NOT NULL,
 cant integer NOT NULL,
FOREIGN KEY (codigo) REFERENCES Articulo (codigo),
FOREIGN KEY (id) REFERENCES Venta (id),
PRIMARY KEY (codigo,id));

CREATE TABLE Rel11(
 codigo serial NOT NULL,
 id varchar(50) NOT NULL,
FOREIGN KEY (codigo) REFERENCES Articulo (codigo),
FOREIGN KEY (id) REFERENCES Rubro (id),
PRIMARY KEY (codigo,id));

CREATE TABLE Provincia(
 Provincia_id varchar(50) NOT NULL,
 nombre varchar(50),
 Pais_id varchar(50) NOT NULL,
FOREIGN KEY (id) REFERENCES Pais (id),
PRIMARY KEY (Provincia_id));

CREATE TABLE Localidad(
 Localidad_id varchar(50) NOT NULL,
 nombre varchar(50),
 Provincia_id varchar(50) NOT NULL,
FOREIGN KEY (id) REFERENCES Provincia (id),
PRIMARY KEY (Localidad_id));

CREATE TABLE Calle(
 Calle_id varchar(50) NOT NULL,
 num integer,
 nombre varchar(50),
 Localidad_id varchar(50) NOT NULL,
FOREIGN KEY (id) REFERENCES Localidad (id),
PRIMARY KEY (Calle_id));

CREATE TABLE Direccion(
 cuit varchar(50) NOT NULL,
 id varchar(50) NOT NULL,
FOREIGN KEY (cuit) REFERENCES Empresa (cuit),
FOREIGN KEY (id) REFERENCES Calle (id),
PRIMARY KEY (cuit,id));

CREATE TABLE Vive(
 id varchar(50) NOT NULL,
 dni varchar(50) NOT NULL,
FOREIGN KEY (id) REFERENCES Calle (id),
FOREIGN KEY (dni) REFERENCES Persona (dni),
PRIMARY KEY (id,dni));


