            UPDATES

/* USAR PREVIAMENTE 'SELECT Nombre, Precio FROM Productos;' PARA CONOCER EL ID DEL PRODUCTO O TRABAJADOR O CAMPO QUE QUEREMOS MODIFICAR/BORRAR */

/* ACTUALIZAR PRECIOS A PRODUCTOS EN BASE A SU ID DE PRODUCTO */
UPDATE Productos
SET Precio = (VALOR)
WHERE ID_Producto = 1;

/* ACTUALIZAR LA CATEGORIA ASIGNADA A UN PRODUCTO EN BASE A SU ID DE PRODUCTO */
UPDATE Productos
SET ID_Categoria = (VALOR)
WHERE ID_Producto = 1;

/* ACTUALIZAR EL NOMBRE DE UN PRODUCTO EN BASE A SU ID DE PRODUCTO */
UPDATE Productos
SET Nombre = ('NOMBRE')
WHERE ID_Producto = (VALOR);

/* ACTUALIZAR LA DESCRIPCION DE UN PRODUCTO EN BASE A SU ID DE PRODUCTO */
UPDATE Productos
SET Descripcion = ('DESCRIPCION')
WHERE ID_Producto = (VALOR);

         DELETES

/* ELIMINAR UN PRODUCTO EN BASE A SU ID  DE PRODUCTO*/
DELETE FROM Productos WHERE ID_Producto = (VALOR);

/* ELIMINAR UN PRODUCTO EN BASE A SU ID DE PRODUCTO*/
DELETE FROM Productos WHERE ID_Producto = (VALOR);

/* ELIMINAR UN CONJUNTO DE PRODUCTOS  EN BASE A SU ID DE CATEGORIA*/
DELETE FROM Productos WHERE ID_Categoria = (VALOR);

/* ELIMINAR UNA CATEGORIA DE PRODUCTOS  EN BASE A SU ID DE CATEGORIA*/
DELETE FROM Categoria WHERE ID_Categoria = (VALOR);

/* ELIMINAR UN EMPLEADO EN BASE A SU ID DE EMPLEADO */
DELETE FROM Trabajador WHERE ID_Trabajador = (VALOR);