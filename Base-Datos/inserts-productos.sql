	/* INSERTS PARA CATEGORIAS */

BEGIN
    BEGIN
INSERT INTO Categoria (ID_Categoria, Nombre)
VALUES(1, 'STARTERS');

INSERT INTO Categoria (ID_Categoria, Nombre)
VALUES(2, 'SMASH');

INSERT INTO Categoria (ID_Categoria, Nombre)
VALUES(3, 'MEDALLION');

INSERT INTO Categoria (ID_Categoria, Nombre)
VALUES(4, 'SANDWITCHES');

INSERT INTO Categoria (ID_Categoria, Nombre)
VALUES(5, 'SAUCES');

INSERT INTO Categoria (ID_Categoria, Nombre)
VALUES(6, 'DESSERTS');

INSERT INTO Categoria (ID_Categoria, Nombre)
VALUES(7, 'DRINKS');
    EXCEPTION
        WHEN OTHERS THEN
            ROLLBACK;
    END;
END;
/


	/* INSERTS PARA PRODUCTOS */

