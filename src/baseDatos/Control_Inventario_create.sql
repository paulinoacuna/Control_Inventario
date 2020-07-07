-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2020-07-05 20:07:36.246

-- tables
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
    idDocumento int NOT NULL,
    nombre varchar(32) NOT NULL,
    apellido varchar(32) NOT NULL,
    fechaNacimiento varchar(32) NOT NULL,
    telefono varchar(16) NOT NULL,
    contrasena varchar(16) NOT NULL,
    codigoEmpleado int NOT NULL,
    Almacen_id int NOT NULL,
    CONSTRAINT Empleado_pk PRIMARY KEY (idDocumento)
);

-- Table: Pedido
CREATE TABLE Pedido (
    id int NOT NULL,
    Provedor_id int NOT NULL,
    Almacen_id int NOT NULL,
    CONSTRAINT Pedido_pk PRIMARY KEY (id)
);

-- Table: Producto
CREATE TABLE Producto (
    id int NOT NULL AUTO_INCREMENT,
    codigoProducto int NOT NULL,
    descripcion varchar(64) NOT NULL,
    precioVenta int NOT NULL,
    precioCompra int NOT NULL,
    cantidadUnidades int NOT NULL,
    descuento double(3,3) NOT NULL,
    Almacen_id int NOT NULL,
    SubCategoria_id int NOT NULL,
    CONSTRAINT Producto_pk PRIMARY KEY (id)
) COMMENT '- agotado : boolean
- descuento : double = 0';

-- Table: Provedor
CREATE TABLE Provedor (
    id int NOT NULL,
    nombre varchar(22) NOT NULL,
    CONSTRAINT Provedor_pk PRIMARY KEY (id)
);

-- Table: SubCategoria
CREATE TABLE SubCategoria (
    id int NOT NULL,
    nombre varchar(16) NOT NULL,
    Categoria_id int NOT NULL,
    CONSTRAINT SubCategoria_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: Empleado_Almacen (table: Empleado)
ALTER TABLE Empleado ADD CONSTRAINT Empleado_Almacen FOREIGN KEY Empleado_Almacen (Almacen_id)
    REFERENCES Almacen (id);

-- Reference: Pedido_Almacen (table: Pedido)
ALTER TABLE Pedido ADD CONSTRAINT Pedido_Almacen FOREIGN KEY Pedido_Almacen (Almacen_id)
    REFERENCES Almacen (id);

-- Reference: Pedido_Provedor (table: Pedido)
ALTER TABLE Pedido ADD CONSTRAINT Pedido_Provedor FOREIGN KEY Pedido_Provedor (Provedor_id)
    REFERENCES Provedor (id);

-- Reference: Producto_Almacen (table: Producto)
ALTER TABLE Producto ADD CONSTRAINT Producto_Almacen FOREIGN KEY Producto_Almacen (Almacen_id)
    REFERENCES Almacen (id);

-- Reference: Producto_SubCategoria (table: Producto)
ALTER TABLE Producto ADD CONSTRAINT Producto_SubCategoria FOREIGN KEY Producto_SubCategoria (SubCategoria_id)
    REFERENCES SubCategoria (id);

-- Reference: SubCategoria_Categoria (table: SubCategoria)
ALTER TABLE SubCategoria ADD CONSTRAINT SubCategoria_Categoria FOREIGN KEY SubCategoria_Categoria (Categoria_id)
    REFERENCES Categoria (id);

-- End of file.

