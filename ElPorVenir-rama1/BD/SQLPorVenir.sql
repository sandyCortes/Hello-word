DROP DATABASE PorVenir
GO

CREATE DATABASE PorVenir
GO

USE PorVenir
GO

CREATE TABLE Compania(
	idCompania INT PRIMARY KEY NOT NULL IDENTITY,
	descripcion VARCHAR(100) NOT NULL
)
GO

CREATE TABLE TipoProducto(
	idTipoP INT PRIMARY KEY NOT NULL IDENTITY,
	descripcion CHAR(1) CHECK(descripcion = 'A' OR descripcion = 'E')
	/*A = Agramel ; E = Epaquetado*/
)
GO

CREATE TABLE Proveedor(
	idProveedor INT PRIMARY KEY NOT NULL IDENTITY,
	descripcion VARCHAR(100) NOT NULL,
	telefono VARCHAR(10) NOT NULL,
	idCompania INT REFERENCES Compania(idCompania)
)
GO



CREATE TABLE Producto(
	codigoProd CHAR(100) PRIMARY KEY NOT NULL,
	nombreProd VARCHAR(100) NOT NULL,
	fechaCaduc DATETIME NOT NULL,
	idTipoP INT REFERENCES TipoProducto(idTipoP),
	activo INT CHECK(activo = 1 OR activo = 2)
	/* 1 = activo & 2= no activo*/
)
GO

SELECT idTipoP FROM Producto WHERE codigoProd = ''

CREATE TABLE Agranel(
	idAgranel INT PRIMARY KEY NOT NULL IDENTITY,
	codigoProd CHAR(100) REFERENCES Producto(codigoProd),
	cantidad FLOAT NOT NULL
)
GO

CREATE TABLE Empaquetado(
	idEmpaquetado INT PRIMARY KEY NOT NULL IDENTITY,
	codigoProd CHAR(100) REFERENCES Producto(codigoProd),
	contenidoNeto FLOAT NOT NULL
)
GO

CREATE TABLE Unidad(
	idUnidad INT PRIMARY KEY NOT NULL IDENTITY,
	tipoUnidad VARCHAR(10) NOT NULL 
)
GO

INSERT INTO Unidad VALUES('Kg');
INSERT INTO Unidad VALUES('g');
INSERT INTO Unidad VALUES('ml');
INSERT INTO Unidad VALUES('L');

CREATE TABLE ProdUnidad(
	idUnidad INT REFERENCES Unidad(idUnidad),
	idAgranel INT REFERENCES Agranel(idAgranel),
	idEmpaquetado INT REFERENCES Empaquetado(idEmpaquetado)
);
GO

CREATE TABLE Contenido(
	idContenido INT PRIMARY KEY NOT NULL IDENTITY,
	cantidad FLOAT NOT NULL
)
GO

CREATE TABLE ContEmp(
	idEmpaquetado INT REFERENCES Empaquetado(idEmpaquetado),
	idContenido INT REFERENCES Contenido(idContenido)
)
GO

CREATE TABLE SurteProducto(
	idProveedor INT REFERENCES Proveedor(idProveedor),
	codigoProd CHAR(100) REFERENCES Producto(codigoProd),
	precioCompra MONEY NOT NULL
)
GO

CREATE TABLE Almacen(
	idAlmacen INT PRIMARY KEY NOT NULL IDENTITY,
	cantidadMin INT NOT NULL,
	cantidadMax INT NOT NULL
)
GO

INSERT INTO Almacen VALUES(20,500)

CREATE TABLE AlmacenProd(
	idAlmacen INT REFERENCES Almacen(idAlmacen),
	codigoProd CHAR(100) REFERENCES Producto(codigoProd),
	cantidadP INT NOT NULL
)
GO

INSERT INTO AlmacenProd VALUES(1,'123456',200)

CREATE TABLE Pedido(
	nPedido INT NOT NULL PRIMARY KEY IDENTITY,
	fechaGenera DATETIME NOT NULL,
	fechaSurte DATETIME NOT NULL,
	nAlmacen INT REFERENCES Almacen(idAlmacen)
)
GO

	CREATE TABLE DetallePedido(
		nPedido INT REFERENCES Pedido(nPedido),
		codigoProd CHAR(100) REFERENCES Producto(codigoProd),
		cantidadPedido INT
	);
	GO

CREATE TABLE Usuarios(
	idUsuario INT PRIMARY KEY NOT NULL IDENTITY,
	nombreUse VARCHAR(45) NOT NULL,
	aPpUser   VARCHAR(45) NOT NULL,
	aPmUser   VARCHAR(45) NOT NULL,
	fechaNa   DATETIME NOT NULL,
	genero CHAR(1) CHECK(genero = 'F' OR genero = 'M'),
	tipoUser INT NOT NULL CHECK(tipoUser = 1 OR tipoUser = 2 OR tipoUser = 3),
	telefono VARCHAR(15) NOT NULL,
	correo VARCHAR(50),
	actividad INT CHECK(actividad >= 1 AND actividad <= 2) DEFAULT 1,
	/*1 = activo ; 2 = Inactivo */
	contrasena VARCHAR(100) NOT NULL
)
GO

CREATE TABLE Caja(
	nCaja INT PRIMARY KEY NOT NULL IDENTITY,
	montoIniciar MONEY NOT NULL,
	montoFinal MONEY NOT NULL,
	horaCorte DATETIME NOT NULL
)
GO

CREATE TABLE Nota(
	nNota INT PRIMARY KEY NOT NULL IDENTITY,
	nCaja INT REFERENCES Caja(nCaja),
	cantidadVendida MONEY NOT NULL
)
GO

CREATE TABLE Venta(
	nVenta INT PRIMARY KEY NOT NULL IDENTITY,
	fechaVenta DATETIME NOT NULL,
	totalVenta MONEY NOT NULL,
	idUsuario INT REFERENCES Usuarios(IDUsuario),
	nCaja INT REFERENCES Caja(nCaja)
)
GO

CREATE TABLE Stok(
	idStock INT PRIMARY KEY NOT NULL IDENTITY,
	cantStock INT NOT NULL,
	cantMin INT NOT NULL,
	cantMaX INT NOT NULL,
	precioVeta MONEY NOT NULL,
	idAlmacen INT REFERENCES Almacen(idAlmacen)
)
GO

CREATE TABLE DetalleVenta(
	nVenta INT REFERENCES Venta(nVenta),
	nStock INT REFERENCES Stok(idStock),
	cantidad INT NOT NULL,
	precioU MONEY NOT NULL
)
GO