USE PorVenir
GO

CREATE VIEW VerUsuarios
AS
SELECT nombreUse,aPpUser,aPmUser,tipoUser,telefono,correo,actividad FROM Usuarios
GO

CREATE VIEW MuestraProductos
AS
	SELECT P.codigoProd,P.nombreProd,C.cantidad,P.fechaCaduc,T.descripcion AS 'Tipo'
	FROM Producto AS P JOIN Empaquetado E ON P.codigoProd = E.codigoProd
	INNER JOIN TipoProducto T ON
	P.idTipoP = T.idTipoP
	INNER JOIN ContEmp  M ON
	M.idEmpaquetado = E.idEmpaquetado
	INNER JOIN  Contenido C
	ON C.idContenido = M.idContenido
GO 

CREATE VIEW MuestraProductosA
AS
	SELECT P.codigoProd,P.nombreProd,A.cantidad,P.fechaCaduc,T.descripcion AS 'Tipo'
	FROM Producto AS P JOIN Agranel A ON P.codigoProd = A.codigoProd
	INNER JOIN TipoProducto T ON 
	P.idTipoP = T.idTipoP	
GO
	
CREATE VIEW ProdStock
AS
	SELECT P.nombreProd,P.fechaCaduc,S.cantStock, S.precioVeta AS 'Precio de Venta',T.descripcion
	FROM Stok AS S JOIN AlmacenProd A
	ON S.idAlmacen = A.idAlmacen 
	INNER JOIN Producto P
	ON P.codigoProd = A.idAlmacen
	INNER JOIN TipoProducto T
	ON P.idTipoP = T.idTipoP
	WHERE P.activo = 1
GO

CREATE VIEW ProdAlmacen 
AS
	SELECT P.nombreProd, P.fechaCaduc,T.descripcion,C.cantidadP,A.cantidadMin,A.cantidadMax
	FROM Almacen AS A JOIN AlmacenProd C
	ON A.idAlmacen = C.idAlmacen
	INNER JOIN Producto P
	ON P.codigoProd = C.codigoProd
	INNER JOIN TipoProducto T
	ON P.idTipoP = T.idTipoP
	WHERE P.activo = 1
GO	

