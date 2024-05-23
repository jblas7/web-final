	/* INSERTS PARA CATEGORIAS */

INSERT INTO Categoria (ID_Categoria, Nombre)
VALUES(1, 'STARTERS');

INSERT INTO Categoria (ID_Categoria, Nombre)
VALUES(2, 'SMASH');

INSERT INTO Categoria (ID_Categoria, Nombre)
VALUES(3, 'MEDALLION');

INSERT INTO Categoria (ID_Categoria, Nombre)
VALUES(3, 'SAUCES');

INSERT INTO Categoria (ID_Categoria, Nombre)
VALUES(4, 'SANDWITCHES');

INSERT INTO Categoria (ID_Categoria, Nombre)
VALUES(5, 'DESSERTS');

INSERT INTO Categoria (ID_Categoria, Nombre)
VALUES(5, 'DRINKS');

	/* INSERTS PARA PRODUCTOS */

INSERT INTO Productos (ID_Producto, Nombre, Descripcion, Precio, Ruta_Imagen, ID_Categoria)
VALUES (1, 'CHICKEN LOLIPOPS', 'Uncover delight with each bite of our 8 Chicken Lollipop Wings: cooked at
                            low temperature and glazed with homemade bourbon-infused barbecue sauce. An irresistible
                            indulgence in every mouthful.', 11.95, '/IMG/', 1);

INSERT INTO Productos (ID_Producto, Nombre, Descripcion, Precio, Ruta_Imagen, ID_Categoria)
VALUES (2, 'PECEÑOS', 'Enjoy our crispy cheese fingers—melted cheese wrapped in golden wheat
                            flour dough, fried to perfection.', 8.90, '/IMG/', 1);

INSERT INTO Productos (ID_Producto, Nombre, Descripcion, Precio, Ruta_Imagen, ID_Categoria)
VALUES (3, 'PECRANCHO POTATOES', 'Indulge in our delectable petal potatoes, perfectly paired with creamy
                            mac and cheese, succulent fried chicken, and a drizzle of tangy barbecue sauce for an
                            unforgettable culinary experience.', 11.90, '/IMG/', 1);


INSERT INTO Productos (ID_Producto, Nombre, Descripcion, Precio, Ruta_Imagen, ID_Categoria)
VALUES (6, 'TABLESIDE PECAMOLE', 'Freshly made tortilla chips, and a molcajete brought to your table for you to enjoy a 
                            dream-worthy guacamole with avocado, pico de gallo, 
                            chili, and lime, all customized to your taste.', 14.50, '/IMG/', 1);

INSERT INTO Productos (ID_Producto, Nombre, Descripcion, Precio, Ruta_Imagen, ID_Categoria)
VALUES (7, 'PECTINENTE BURGER', 'Our homemade brioche bun with 2 smash burgers, Oxaca, Monterrey, and
                            mozzarella cheese, crispy American bacon, pickles, tomato jam, and PECrancho sauce.', 14.60, '/IMG/', 2);

INSERT INTO Productos (ID_Producto, Nombre, Descripcion, Precio, Ruta_Imagen, ID_Categoria)
VALUES (8, 'THE PECADORA', 'House-made brioche bun, double beef patty and cheddar cheese, shredded
                            lettuce, all accompanied by the worlds most famous burger sauce containing pickles and
                            onions.', 14.80, '/IMG/', 2);

INSERT INTO Productos (ID_Producto, Nombre, Descripcion, Precio, Ruta_Imagen, ID_Categoria)
VALUES (9, 'MC AND PECS BURGER', 'Our fabolus brioche bun with 2 smash burgers, pickles, and mac and cheese
                            oozing from all sides. An irresistible combination!', 13.90, '/IMG/', 2);

INSERT INTO Productos (ID_Producto, Nombre, Descripcion, Precio, Ruta_Imagen, ID_Categoria)
VALUES (10, 'PECLICIOSA BURGER', 'Brioche bun accompanied by 2 thin burgers with delicious cheddar cheese,
                            pickles, and bacon—simple yet doubly satisfying.', 14.50, '/IMG/', 2);


INSERT INTO Productos (ID_Producto, Nombre, Descripcion, Precio, Ruta_Imagen, ID_Categoria)
VALUES (12, 'PECEÑITA BURGER', 'Homemade brioche bun with Morucha and Ox beef, Raclette cheese
                            breaded in panko, pickles, crispy bacon, and slightly spicy El Rancho sauce.', 15.90, '/IMG/', 3);


INSERT INTO Productos (ID_Producto, Nombre, Descripcion, Precio, Ruta_Imagen, ID_Categoria)
VALUES (13, 'PECSCELENTE XXL', 'Brioche bun with a base of smoked barbecue, pickles, Morucha and Ox
                            beef, cheddar cheese, slow-cooked Pulled Pork, and tempura onion.', 18.50, '/IMG/', 3);

INSERT INTO Productos (ID_Producto, Nombre, Descripcion, Precio, Ruta_Imagen, ID_Categoria)
VALUES (14, 'PECDEROSA BURGER', 'Our homemade brioche bun accompanied by a Morucha and Ox beef burger, caramelized onions, bacon, cheddar cheese,
 pickles, PECranch sauce, and right before your eyes, we heap on loads of bacon ash-infused mac 
 & cheese. Are you going to miss out on this?', 15.95, '/IMG/', 3);


INSERT INTO Productos (ID_Producto, Nombre, Descripcion, Precio, Ruta_Imagen, ID_Categoria)
VALUES (15, 'LITTLE PECS BURGER', 'Our homemade brioche bun paired with two Morucha and Ox beef patties totaling 220g, 
caramelized onions, bacon, pickles, cheddar cheese, PECranch sauce, and right in front of you,
 we pile on heaps of mac & cheese. An absolute madness!', 16.50, '/IMG/', 3);

INSERT INTO Productos (ID_Producto, Nombre, Descripcion, Precio, Ruta_Imagen, ID_Categoria)
VALUES (16, 'BIG PECS BURGER', 'The crown jewel, our new Pretzel bun, 200-gram Morucha and Ox beef, 
caramelized onions, Emmy sauce with a spicy kick, 
crispy American bacon, and smoked cheese.', 20.90, '/IMG/', 3);

INSERT INTO Productos (ID_Producto, Nombre, Descripcion, Precio, Ruta_Imagen, ID_Categoria)
VALUES (17, 'PECULIAR BURGER', 'Our new Pretzel bun, 200 grams of Morucha beef and ox meat, caramelized onions, 
Emmy sauce with a spicy kick, crispy American bacon, and smoked cheese.', 16.10, '/IMG/', 3);

INSERT INTO Productos (ID_Producto, Nombre, Descripcion, Precio, Ruta_Imagen, ID_Categoria)
VALUES (18, 'PECARAMEL BURGER', 'Our foodie burger: 200-gram Morucha and Ox beef, served on our
                            homemade brioche bun with a nest of shoestring potatoes, cheddar cheese, crispy bacon,
                            cream, and Lotus biscuit crumble.', 16.90, '/IMG/', 3);

INSERT INTO Productos (ID_Producto, Nombre, Descripcion, Precio, Ruta_Imagen, ID_Categoria)
VALUES (19, 'THE PECHUGERA', 'Our ultimate vegan burger comes with our homemade brioche bun, Beyond
                            Meat patty, lettuce, tomato, pico de gallo, pickles, and barbecue sauce (add cheddar
                            cheese if desired).', 13.90, '/IMG/', 3);

INSERT INTO Productos (ID_Producto, Nombre, Descripcion, Precio, Ruta_Imagen, ID_Categoria)
VALUES (20, 'FELIPEC SANDWICH', 'Feel presidential with our grilled high-quality beef striploin
                            sandwich, layered with sautéed peppers, onions, and melted cheddar cheese, all
                            topped with a smooth sauce and served on artisan brioche bread.', 15.50, '/IMG/', 4);

INSERT INTO Productos (ID_Producto, Nombre, Descripcion, Precio, Ruta_Imagen, ID_Categoria)
VALUES (21, 'THE CHEESERO', 'The "Cheese Craze": Brioche bun with gooey melted cheddar,
                            Monterrey Jack, and Manchego cheeses, topped with pickles and chipotle mayo.', 9.90, '/IMG/', 4);


INSERT INTO Productos (ID_Producto, Nombre, Descripcion, Precio, Ruta_Imagen, ID_Categoria)
VALUES (22, 'LOTUS CHEESPEC', 'The Deliciously creamy cheesecake with Lotus cream and a Lotus biscuit base.', 7.50, '/IMG/', 5);

INSERT INTO Productos (ID_Producto, Nombre, Descripcion, Precio, Ruta_Imagen, ID_Categoria)
VALUES (23, 'HAPPY HIPO CHEESPEC', 'The Deliciously creamy cheesecake infused with Kinder cream and a touch of hippopotamus. What could possibly go wrong with this delightful mix?', 8.00, '/IMG/', 5);

INSERT INTO Productos (ID_Producto, Nombre, Descripcion, Precio, Ruta_Imagen, ID_Categoria)
VALUES (24, 'TRADITIONAL CHEESPEC', 'The queen of the house, the classic cheesecake, creamy, sweet, with that cheesy flavor, simply spectacular.', 7.00, '/IMG/', 5);