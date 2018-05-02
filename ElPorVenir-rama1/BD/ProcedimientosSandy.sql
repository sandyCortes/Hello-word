USE PorVenir

CREATE PROCEDURE RegistraProd
	@codProd CHAR(100),
	@nombre VARCHAR(100),
	@cantidad INT,
	@contN FLOAT,
	@unidad varchar(10),
	@fechaCad DATETIME,
	@proveedor VARCHAR(100),
	@preioVenta FLOAT,
	@precioCompra FLOAT,
	@cantMin INT,
	@cantMax INT,
	@cantStock INT,
	@resp VARCHAR(100) OUTPUT
AS
	DECLARE @idProveedor INT,@idTipo INT,@idUnidad INT,@idCont INT,@idEmp INT;
	DECLARE @idAlmacen INT;
	
	IF EXISTS (SELECT * FROM Producto WHERE codigoProd = @codProd)
		BEGIN
			SET @resp = 'Este producto ya existe'
		END
	ELSE 
		BEGIN
			SELECT @idUnidad = idUnidad FROM Unidad WHERE tipoUnidad = @unidad;
			SELECT @idProveedor = idProveedor FROM Proveedor WHERE @proveedor = descripcion;
			INSERT INTO Producto VALUES(@codProd,@nombre,@fechaCad,2,1);
			INSERT INTO Empaquetado VALUES(@codProd,@contN);
			INSERT INTO ProdUnidad VALUES(@idUnidad,@codProd);
			INSERT INTO Contenido VALUES(@contN);
			SELECT @idCont = MAX(idContenido) FROM Contenido;
			SELECT @idEmp = MAX(idEmpaquetado) FROM Empaquetado;
			INSERT INTO ContEmp VALUES(@idCont,@idEmp);
			INSERT INTO Almacen VALUES(@cantMin,@cantMax);
			SELECT @idAlmacen = MAX(idAlmacen) FROM Almacen;
			INSERT INTO AlmacenProd VALUES(@idAlmacen,@codProd,@cantidad);
			INSERT INTO SurteProducto VALUES(@idProveedor,@codProd,@precioCompra);
			INSERT INTO Stok VALUES(@cantStock,@cantMin,@cantMax,@preioVenta,@idAlmacen);
			SET @resp = 'Producto registrado'
		END
GO

CREATE PROCEDURE AgregaAgranel
	@codProd CHAR(100),
	@nombre VARCHAR(100),
	@cantidad INT,
	@contN FLOAT,
	@unidad varchar(10),
	@fechaCad DATETIME,
	@proveedor VARCHAR(100),
	@preioVenta FLOAT,
	@precioCompra FLOAT,
	@cantMin INT,
	@cantMax INT,
	@cantStock INT,
	@resp VARCHAR(100) OUTPUT
AS
	DECLARE @idProveedor INT,@idTipo INT,@idUnidad INT,@idCont INT,@idEmp INT;
	DECLARE @idAlmacen INT;
	IF EXISTS (SELECT * FROM Producto WHERE codigoProd = @codProd)
		BEGIN
			SET @resp = 'Este producto ya existe'
		END
	ELSE
		BEGIN
			SELECT @idUnidad = idUnidad FROM Unidad WHERE tipoUnidad = @unidad;
			SELECT @idProveedor = idProveedor FROM Proveedor WHERE @proveedor = descripcion;
			
			INSERT INTO Producto VALUES(@codProd,@nombre,@fechaCad,1,1);
			INSERT INTO Agranel VALUES(@codProd,@contN);
			INSERT INTO ProdUnidad VALUES(@idUnidad,@codProd);
			INSERT INTO Almacen VALUES(@cantMin,@cantMax);
			SELECT @idAlmacen = MAX(idAlmacen) FROM Almacen;
			INSERT INTO AlmacenProd VALUES(@idAlmacen,@codProd,@cantidad);
			INSERT INTO SurteProducto VALUES(@idProveedor,@codProd,@precioCompra);
			INSERT INTO Stok VALUES(@cantStock,@cantMin,@cantMax,@preioVenta,@idAlmacen);
			SET @resp = 'Producto registrado'
		END
	GO

CREATE PROCEDURE GeneraVenta
	@totalVenta MONEY,
	@nCaja INT,
	@cantProductos INT,
	@codigoP CHAR(100),
	@precioV MONEY,
	@cont INT,
	@res VARCHAR(100) OUTPUT
AS
	DECLARE @idStock INT,@nVent INT
	SELECT @idStock = S.idStock FROM Stok AS S JOIN AlmacenProd A
	ON S.idAlmacen = A.idAlmacen
	WHERE A.codigoProd = @codigoP
	
	IF(@cont = 0)
		BEGIN
			INSERT INTO Venta VALUES(GETDATE(),@totalVenta,@nCaja)
			INSERT INTO Nota VALUES(@nCaja,@totalVenta)
		END

	SELECT @nVent = COUNT(nVenta) FROM Venta

	INSERT INTO DetalleVenta VALUES(@nVent,@idStock,@cantProductos,@precioV)
	UPDATE Stok SET cantStock = cantStock - @cantProductos 
	WHERE idStock = @idStock
GO

CREATE PROCEDURE AbreC
	@nCaja INT,
	@importeI MONEY
AS
	INSERT INTO AbreCaja(nCaja,montoIniciar) VALUES(@nCaja,@importeI)
GO

CREATE PROCEDURE CerrarC
	@nCaja INT,
	@montoFinal MONEY
AS
	UPDATE AbreCaja SET montoFinal = @montoFinal, horaCorte = GETDATE()
	WHERE nCaja = @nCaja