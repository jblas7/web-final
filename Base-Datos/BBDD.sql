CREATE TABLE Categoria(
    ID_Categoria INTEGER PRIMARY KEY,
    Nombre VARCHAR2(20) UNIQUE
);

CREATE TABLE Cliente(
    ID_Cliente INTEGER PRIMARY KEY,
    Nombre VARCHAR2(40) NOT NULL,
    Telefono VARCHAR2(15) NOT NULL,
    Email VARCHAR2(60) UNIQUE,
    Contrasena VARCHAR2(50) NOT NULL
);

CREATE TABLE Trabajador(
    ID_Trabajador INTEGER PRIMARY KEY,
    Nombre VARCHAR2(40) NOT NULL,
    Numero_SS INTEGER UNIQUE,
    Telefono VARCHAR2(15) UNIQUE,
    Email VARCHAR2(60) UNIQUE,
    Contrasena VARCHAR2(50) NOT NULL,
    Fecha_Contratacion DATE NOT NULL
);

CREATE TABLE Productos(
    ID_Producto INTEGER PRIMARY KEY,
    Nombre VARCHAR2(80) UNIQUE,
    Descripcion VARCHAR2(400),
    Precio NUMBER(5, 2) NOT NULL,
    Ruta_Imagen VARCHAR2(100) NOT NULL,
    ID_Categoria INTEGER,
    FOREIGN KEY (ID_Categoria) REFERENCES Categoria(ID_Categoria)
);

CREATE TABLE Pedidos(
    ID_Pedido INTEGER PRIMARY KEY,
    Fecha DATE NOT NULL,
    Estado VARCHAR2(20) NOT NULL,
    Direccion VARCHAR2(50) NOT NULL,
    ID_Cliente INTEGER,
    ID_Metodo_Pago INTEGER,
    ID_Trabajador INTEGER,
    FOREIGN KEY (ID_Cliente) REFERENCES Cliente(ID_Cliente),
    FOREIGN KEY (ID_Trabajador) REFERENCES Trabajador(ID_Trabajador)
);

CREATE TABLE Detalle_Pedido(
    ID_Detalle INTEGER PRIMARY KEY,
    Cantidad INTEGER NOT NULL,
    ID_Pedido INTEGER,
    ID_Producto INTEGER,
    FOREIGN KEY (ID_Pedido) REFERENCES Pedidos(ID_Pedido),
    FOREIGN KEY (ID_Producto) REFERENCES Productos(ID_Producto)
);
