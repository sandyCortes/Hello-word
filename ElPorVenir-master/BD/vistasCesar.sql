USE PorVenir
GO

CREATE VIEW VerUsuarios
AS
SELECT nombreUse,aPpUser,aPmUser,tipoUser,telefono,correo,actividad FROM Usuarios
GO

CREATE VIEW MuestraProductos
AS
	SELECT P.codigoProd,P.nombreProd,E.contenidoNeto,P.fechaCaduc,T.descripcion AS 'Tipo'
	FROM Producto AS P JOIN Empaquetado E ON P.codigoProd = E.codigoProd
	INNER JOIN TipoProducto T ON
	P.idTipoP = T.idTipoP	WHERE T.descripcion = 'E'
	GO 

CREATE VIEW MuestraProductosA
AS
	SELECT P.codigoProd,P.nombreProd,E.contenidoNeto,P.fechaCaduc,T.descripcion AS 'Tipo'
	FROM Producto AS P JOIN Empaquetado E ON P.codigoProd = E.codigoProd
	INNER JOIN TipoProducto T ON
	P.idTipoP = T.idTipoP	
	WHERE T.descripcion = 'A'
	GO
	
	 