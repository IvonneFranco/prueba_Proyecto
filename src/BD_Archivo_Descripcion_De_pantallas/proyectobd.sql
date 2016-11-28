DROP DATABASE IF EXISTS prueba-santander;
CREATE DATABASE prueba-santander;
 -- Tabla para crear usuarios e identificar si es cliente o Administrador
create table usuario ( 
  id int(6) NOT NULL auto_increment, 
  nombre varchar(25) NOT NULL, 
  cliente int(8) NOT NULL,
  tipousuario varchar(25) NOT NULL, 
  nip varchar(25) NOT NULL,   
  PRIMARY KEY  (id) 
);
 -- Inserts prueba
INSERT INTO `usuario` (`id`, `nombre`, `cliente`, `tipousuario`, `nip`) VALUES ('1', 'Ivonne', '44567896', 'Administrador', 'qwe,,,789');
INSERT INTO `usuario` (`id`, `nombre`, `cliente`, `tipousuario`, `nip`) VALUES ('2', 'Pedro', '33456345', 'Cliente', '789,,,qwe');

-- Tabla almacenadora de formularios y folios 
create table formulario( 
  id_formulario int(6) NOT NULL auto_increment, 
  nombre varchar(25) NOT NULL, 
  cliente int(8) NOT NULL, 
  folio BIGINT NOT NULL, 
  status varchar(25) NOT NULL,
  tarjeta varchar(40)NOT NULL,
  id int(6) NOT NULL, 
  PRIMARY KEY  (id_formulario),
  FOREIGN KEY (id) REFERENCES usuario(id)
);

-- Procedimientos almacenados No utilizados en esta prueba
-- para hacer uso de ello llamar desde el controlador_ formulario. 
CREATE PROCEDURE buscarcliente (IN cod INT)
	BEGIN
	SELECT * FROM usuario WHERE cliente = cod;
 END
 
CREATE PROCEDURE buscarnip(nipd CHAR(25))

SELECT * FROM usuario WHERE nip = nipd;

CREATE PROCEDURE buscarid (IN codigo INT)
	BEGIN
	SELECT * FROM formulario WHERE id = codigo;
 END
CREATE PROCEDURE buscarestatus(statuspe CHAR(25))

SELECT * FROM formulario WHERE status = statuspe;