CREATE TABLE Categoria(
    ID_Categoria INTEGER PRIMARY KEY,
    Nombre VARCHAR2(20) NOT NULL
);

CREATE TABLE Cliente(
    ID_Cliente INTEGER PRIMARY KEY,
    Nombre VARCHAR2(60) NOT NULL,
    Apellido VARCHAR2(60) NOT NULL,
    Telefono VARCHAR2(15) NOT NULL,
    Email VARCHAR2(60) NOT NULL,
    Contrasena VARCHAR2(50) NOT NULL
);

CREATE TABLE Trabajador(
    ID_Trabajador INTEGER PRIMARY KEY,
    Nombre VARCHAR2(60) NOT NULL,
    Apellido VARCHAR2(60) NOT NULL,
    Numero_SS INTEGER UNIQUE,
    Salario NUMBER(6,2) NOT NULL,
    Telefono VARCHAR2(15) NOT NULL,
    Email VARCHAR2(60) NOT NULL,
    Contrasena VARCHAR2(50) NOT NULL,
    Tipo_Trabajo VARCHAR2(50) NOT NULL,
    Fecha_Contratacion DATE NOT NULL
);

CREATE TABLE Productos(
    ID_Producto INTEGER PRIMARY KEY,
    Nombre VARCHAR2(80) NOT NULL,
    Descripcion VARCHAR2(400),
    Precio NUMBER(5, 2) NOT NULL,
    Ruta_Imagen VARCHAR2(300) NOT NULL,
    ID_Categoria INTEGER NOT NULL,
    FOREIGN KEY (ID_Categoria) REFERENCES Categoria(ID_Categoria)
);

CREATE TABLE Pedidos(
    ID_Pedido INTEGER PRIMARY KEY,
    Fecha DATE NOT NULL,
    Estado VARCHAR2(20) NOT NULL,
    Direccion VARCHAR2(50) NOT NULL,
    ID_Cliente INTEGER NOT NULL,
    ID_Trabajador INTEGER NOT NULL,
    FOREIGN KEY (ID_Cliente) REFERENCES Cliente(ID_Cliente),
    FOREIGN KEY (ID_Trabajador) REFERENCES Trabajador(ID_Trabajador)
);

CREATE TABLE Detalle_Pedido(
    ID_Detalle INTEGER PRIMARY KEY,
    Cantidad INTEGER NOT NULL,
    ID_Pedido INTEGER NOT NULL,
    ID_Producto INTEGER NOT NULL,
    FOREIGN KEY (ID_Pedido) REFERENCES Pedidos(ID_Pedido),
    FOREIGN KEY (ID_Producto) REFERENCES Productos(ID_Producto)
);