-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2020-04-25 01:37:32.701


-- ESTE DOCUMENTO SOLO CONTIENE EL TEXTO EN FORMATO SQL PARA CREAR POR PRIMERA VEZ LA BASE DE DATOS.


-- tables
-- Table: Administrador
CREATE TABLE Administrador (
    Empleado_Persona_idDocumento int NOT NULL,
    CONSTRAINT Administrador_pk PRIMARY KEY (Empleado_Persona_idDocumento)
);

-- Table: Almacen
CREATE TABLE Almacen (
    id int NOT NULL AUTO_INCREMENT,
    nombre varchar(16) NOT NULL,
    telefono varchar(12) NOT NULL,
    direccion varchar(20) NOT NULL,
    CONSTRAINT Almacen_pk PRIMARY KEY (id)
);

-- Table: Categoria
CREATE TABLE Categoria (
    id int NOT NULL AUTO_INCREMENT,
    nombre varchar(16) NOT NULL,
    CONSTRAINT Categoria_pk PRIMARY KEY (id)
);

-- Table: Empleado
CREATE TABLE Empleado (
    Persona_idDocumento int NOT NULL,
    codigoEmpleado int NOT NULL,
    Almacen_id int NOT NULL,
    CONSTRAINT Empleado_pk PRIMARY KEY (Persona_idDocumento)
);

-- Table: Ingeniero
CREATE TABLE Ingeniero (
    Persona_idDocumento int NOT NULL,
    CONSTRAINT Ingeniero_pk PRIMARY KEY (Persona_idDocumento)
);

-- Table: Pedido
CREATE TABLE Pedido (
    id int NOT NULL,
    Provedor_id int NOT NULL,
    Almacen_id int NOT NULL,
    CONSTRAINT Pedido_pk PRIMARY KEY (id)
);

-- Table: Persona
CREATE TABLE Persona (
    idDocumento int NOT NULL,
    nombre varchar(32) NOT NULL,
    apellido varchar(32) NOT NULL,
    fechaNacimiento date NOT NULL,
    telefono varchar(16) NOT NULL,
    contrasena varchar(16) NOT NULL,
    CONSTRAINT Persona_pk PRIMARY KEY (idDocumento)
);

-- Table: Producto
CREATE TABLE Producto (
    id int NOT NULL AUTO_INCREMENT,
    Pedido_id int NOT NULL,
    Categoria_id int NOT NULL,
    codigoProducto int NOT NULL,
    descripcion varchar(64) NOT NULL,
    precioVenta int NOT NULL,
    precioCompra int NOT NULL,
    cantidadUnidades int NOT NULL,
    agotado bool NOT NULL,
    descuento double(3,3) NOT NULL,
    CONSTRAINT Producto_pk PRIMARY KEY (id)
) COMMENT '- agotado : boolean
- descuento : double = 0';

-- Table: Provedor
CREATE TABLE Proveedor (
    llave int NOT NULL AUTO_INCREMENT,
    id int NOT NULL,
    nombre varchar(30) NOT NULL,
    CONSTRAINT Provedor_pk PRIMARY KEY (llave)
);

-- Table: SubCategoria
CREATE TABLE SubCategoria (
    id int NOT NULL,
    Categoria_id int NOT NULL,
    nombre varchar(16) NOT NULL,
    CONSTRAINT SubCategoria_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: Administrador_Empleado (table: Administrador)
ALTER TABLE Administrador ADD CONSTRAINT Administrador_Empleado FOREIGN KEY Administrador_Empleado (Empleado_Persona_idDocumento)
    REFERENCES Empleado (Persona_idDocumento);

-- Reference: Empleado_Almacen (table: Empleado)
ALTER TABLE Empleado ADD CONSTRAINT Empleado_Almacen FOREIGN KEY Empleado_Almacen (Almacen_id)
    REFERENCES Almacen (id);

-- Reference: Empleado_Persona (table: Empleado)
ALTER TABLE Empleado ADD CONSTRAINT Empleado_Persona FOREIGN KEY Empleado_Persona (Persona_idDocumento)
    REFERENCES Persona (idDocumento);

-- Reference: Ingeniero_Persona (table: Ingeniero)
ALTER TABLE Ingeniero ADD CONSTRAINT Ingeniero_Persona FOREIGN KEY Ingeniero_Persona (Persona_idDocumento)
    REFERENCES Persona (idDocumento);

-- Reference: Pedido_Almacen (table: Pedido)
ALTER TABLE Pedido ADD CONSTRAINT Pedido_Almacen FOREIGN KEY Pedido_Almacen (Almacen_id)
    REFERENCES Almacen (id);

-- Reference: Pedido_Provedor (table: Pedido)
ALTER TABLE Pedido ADD CONSTRAINT Pedido_Provedor FOREIGN KEY Pedido_Provedor (Provedor_id)
    REFERENCES Provedor (id);

-- Reference: Producto_Categoria (table: Producto)
ALTER TABLE Producto ADD CONSTRAINT Producto_Categoria FOREIGN KEY Producto_Categoria (Categoria_id)
    REFERENCES Categoria (llave);

-- Reference: Producto_Pedido (table: Producto)
ALTER TABLE Producto ADD CONSTRAINT Producto_Pedido FOREIGN KEY Producto_Pedido (Pedido_id)
    REFERENCES Pedido (id);

-- Reference: SubCategoria_Categoria (table: SubCategoria)
ALTER TABLE SubCategoria ADD CONSTRAINT SubCategoria_Categoria FOREIGN KEY SubCategoria_Categoria (Categoria_id)
    REFERENCES Categoria (id);

-- End of file.

