	/* INSERTS PARA CATEGORIAS */

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
    WHEN OTHER THEN
    ROLLBACK;
END;


	/* INSERTS PARA PRODUCTOS */

BEGIN
INSERT INTO Productos (ID_Producto, Nombre, Descripcion, Precio, Ruta_Imagen, ID_Categoria)
VALUES (1, 'CHICKEN LOLIPOPS', 'Uncover delight with each bite of our 8 Chicken Lollipop Wings: cooked at
                            low temperature and glazed with homemade bourbon-infused barbecue sauce. An irresistible
                            indulgence in every mouthful.', 11.95, 'https://i.pinimg.com/originals/fb/05/9d/fb059d302bc74801380cffb71c4ddb92.jpg', 1);

INSERT INTO Productos (ID_Producto, Nombre, Descripcion, Precio, Ruta_Imagen, ID_Categoria)
VALUES (2, 'SPECIAL PECEÑOS', 'Enjoy our crispy cheese fingers—melted cheese wrapped in golden wheat
                            flour dough, fried to perfection.', 8.90, 'https://i.pinimg.com/originals/e8/23/58/e82358080f5e6b95e302509100927524.jpg', 1);

INSERT INTO Productos (ID_Producto, Nombre, Descripcion, Precio, Ruta_Imagen, ID_Categoria)
VALUES (3, 'PECRANCHO POTATOES', 'Indulge in our delectable petal potatoes, perfectly paired with creamy
                            mac and cheese, succulent fried chicken, and a drizzle of tangy barbecue sauce for an
                            unforgettable culinary experience.', 11.90, 'https://i.pinimg.com/originals/ad/91/57/ad9157f6d6b8e296dd6e358f88fbd922.jpg', 1);

INSERT INTO Productos (ID_Producto, Nombre, Descripcion, Precio, Ruta_Imagen, ID_Categoria)
VALUES (4, 'TABLESIDE PECAMOLE', 'Freshly made tortilla chips, and a molcajete brought to your table for you to enjoy a 
                            dream-worthy guacamole with avocado, pico de gallo, 
                            chili, and lime, all customized to your taste.', 14.50, 'https://i.pinimg.com/originals/fb/dd/a7/fbdda7d1b77cdc0035a87d1f81475547.jpg', 1);
                        



INSERT INTO Productos (ID_Producto, Nombre, Descripcion, Precio, Ruta_Imagen, ID_Categoria)
VALUES (5, 'PECTINENTE BURGER', 'Our homemade brioche bun with 2 smash burgers, Oxaca, Monterrey, and
                            mozzarella cheese, crispy American bacon, pickles, tomato jam, and PECrancho sauce.', 14.60, 'https://i.pinimg.com/originals/bf/42/8e/bf428ed451d99079c8359414c4630813.jpg', 2);

INSERT INTO Productos (ID_Producto, Nombre, Descripcion, Precio, Ruta_Imagen, ID_Categoria)
VALUES (6, 'PECADORA  BURGER', 'House-made brioche bun, double beef patty and cheddar cheese, shredded
                            lettuce, all accompanied by the worlds most famous burger sauce containing pickles and
                            onions.', 14.80, 'https://i.pinimg.com/originals/9a/12/0e/9a120ea31bd1bfe18bb5030e413ec14e.jpg', 2);

INSERT INTO Productos (ID_Producto, Nombre, Descripcion, Precio, Ruta_Imagen, ID_Categoria)
VALUES (7, 'MC AND PECS BURGER', 'Our fabolus brioche bun with 2 smash burgers, pickles, and mac and cheese
                            oozing from all sides. An irresistible combination!', 13.90, 'https://i.pinimg.com/originals/4f/ce/c8/4fcec8b8a5dad2e7e21e8d3d48503f28.jpg', 2);

INSERT INTO Productos (ID_Producto, Nombre, Descripcion, Precio, Ruta_Imagen, ID_Categoria)
VALUES (8, 'PECLICIOSA BURGER', 'Brioche bun accompanied by 2 thin burgers with delicious cheddar cheese,
                            pickles, and bacon—simple yet doubly satisfying.', 14.50, 'https://i.pinimg.com/originals/6b/43/d0/6b43d0fc5e0fd1301376338df61fca96.jpg', 2);




INSERT INTO Productos (ID_Producto, Nombre, Descripcion, Precio, Ruta_Imagen, ID_Categoria)
VALUES (9, 'PECEÑITA BURGER', 'Homemade brioche bun with Morucha and Ox beef, Raclette cheese
                            breaded in panko, pickles, crispy bacon, and slightly spicy El Rancho sauce.', 15.90, 'https://i.pinimg.com/originals/da/f3/7a/daf37a79115f5680ad9c68ec242b4e88.jpg', 3);


INSERT INTO Productos (ID_Producto, Nombre, Descripcion, Precio, Ruta_Imagen, ID_Categoria)
VALUES (10, 'PECSCELENTE XXL', 'Brioche bun with a base of smoked barbecue, pickles, Morucha and Ox
                            beef, cheddar cheese, slow-cooked Pulled Pork, and tempura onion.', 18.50, 'https://i.pinimg.com/originals/b8/1b/5c/b81b5c3c9d5e6ebc463431d1f660101f.jpg', 3);

INSERT INTO Productos (ID_Producto, Nombre, Descripcion, Precio, Ruta_Imagen, ID_Categoria)
VALUES (11, 'PECDEROSA BURGER', 'Our homemade brioche bun accompanied by a Morucha and Ox beef burger, caramelized onions, bacon, cheddar cheese,
 pickles, PECranch sauce, and right before your eyes, we heap on loads of bacon ash-infused mac 
 and cheese. Are you going to miss out on this?', 15.95, 'https://i.pinimg.com/originals/c4/ca/0d/c4ca0d4b709f798697bf6bb506fecb15.jpg', 3);


INSERT INTO Productos (ID_Producto, Nombre, Descripcion, Precio, Ruta_Imagen, ID_Categoria)
VALUES (12, 'LITTLE PECS BURGER', 'Our homemade brioche bun paired with two Morucha and Ox beef patties totaling 220g, 
caramelized onions, bacon, pickles, cheddar cheese, PECranch sauce, and right in front of you,
 we pile on heaps of mac and cheese. An absolute madness!', 16.50, 'https://i.pinimg.com/originals/b5/d4/a1/b5d4a181f27f13782ed9091635068a6c.jpg', 3);

INSERT INTO Productos (ID_Producto, Nombre, Descripcion, Precio, Ruta_Imagen, ID_Categoria)
VALUES (13, 'BIG PECS BURGER', 'The crown jewel, our new Pretzel bun, 200-gram Morucha and Ox beef, 
caramelized onions, Emmy sauce with a spicy kick, 
crispy American bacon, and smoked cheese.', 20.90, 'https://i.pinimg.com/originals/23/03/c4/2303c4a680252cae76db641b7959e1c3.jpg', 3);

INSERT INTO Productos (ID_Producto, Nombre, Descripcion, Precio, Ruta_Imagen, ID_Categoria)
VALUES (14, 'PECULIAR BURGER', 'Our new Pretzel bun, 200 grams of Morucha beef and ox meat, caramelized onions, 
Emmy sauce with a spicy kick, crispy American bacon, and smoked cheese.', 16.10, 'https://i.pinimg.com/originals/3c/f6/f9/3cf6f9571e48d33d6043f8b708ac64e1.jpg', 3);

INSERT INTO Productos (ID_Producto, Nombre, Descripcion, Precio, Ruta_Imagen, ID_Categoria)
VALUES (15, 'PECARAMEL BURGER', 'Our foodie burger: 200-gram Morucha and Ox beef, served on our
                            homemade brioche bun with a nest of shoestring potatoes, cheddar cheese, crispy bacon,
                            cream, and Lotus biscuit crumble.', 16.90, 'https://i.pinimg.com/originals/d3/62/77/d3627799cc4a1918790aa5d21b604fb9.jpg', 3);

INSERT INTO Productos (ID_Producto, Nombre, Descripcion, Precio, Ruta_Imagen, ID_Categoria)
VALUES (16, 'PECHUGERA BURGER', 'Our ultimate vegan burger comes with our homemade brioche bun, Beyond
                            Meat patty, lettuce, tomato, pico de gallo, pickles, and barbecue sauce (add cheddar
                            cheese if desired).', 13.90, 'https://i.pinimg.com/originals/b5/e9/58/b5e95826031156989842d70b7fb6bbef.jpg', 3);


INSERT INTO Productos (ID_Producto, Nombre, Descripcion, Precio, Ruta_Imagen, ID_Categoria)
VALUES (17, 'FELIPEC SANDWICH', 'Feel presidential with our grilled high-quality beef striploin
                            sandwich, layered with sautéed peppers, onions, and melted cheddar cheese, all
                            topped with a smooth sauce and served on artisan brioche bread.', 15.50, 'https://i.pinimg.com/originals/fa/d2/01/fad20159653fb800168244252274938b.jpg', 4);

INSERT INTO Productos (ID_Producto, Nombre, Descripcion, Precio, Ruta_Imagen, ID_Categoria)
VALUES (18, 'THE CHEESERO SANDWICH', 'The "Cheese Craze": Brioche bun with gooey melted cheddar,
                            Monterrey Jack, and Manchego cheeses, topped with pickles and chipotle mayo.', 9.90, 'https://i.pinimg.com/originals/28/8e/0c/288e0c49531ccc473df05b4ae7c6c4a2.jpg', 4);

INSERT INTO Productos (ID_Producto, Nombre, Descripcion, Precio, Ruta_Imagen, ID_Categoria)
VALUES (19, 'THE CREAMY BACON BUTTER', 'Simply spectacular. Homemade brioche bread, edam cheese, smoked bacon meremelada,
 smoked cheddar cheese, and to top it off, bacon crunchy to give that crunchy touch in every bite. Brutal.', 10.90, 'https://i.pinimg.com/originals/71/0b/71/710b71b17348c34322594b72ef06b798.jpg', 4);

INSERT INTO Productos (ID_Producto, Nombre, Descripcion, Precio, Ruta_Imagen, ID_Categoria)
VALUES (20, 'THE PECAMOLE BRIOCHE', 'A great and crazy sandwich, cradled in our brioche bread, with a creamy interior, 
thanks to our homemade guacamole...a surprise in every bite!', 10.50, 'https://i.pinimg.com/originals/c8/3b/fc/c83bfcac0f697d6b19aebad356a828cc.jpg', 4);


INSERT INTO Productos (ID_Producto, Nombre, Descripcion, Precio, Ruta_Imagen, ID_Categoria)
VALUES (21, 'BOURBON BBQ SAUCE', '', 0.90, 'https://i.pinimg.com/originals/19/ef/d1/19efd14f2765e21898279b2baa1ea820.jpg', 5);

INSERT INTO Productos (ID_Producto, Nombre, Descripcion, Precio, Ruta_Imagen, ID_Categoria)
VALUES (22, 'CHIPOTLE SAUCE', '', 0.90, 'https://i.pinimg.com/originals/58/0e/d1/580ed1af470c1d9b8488686dd542107e.jpg', 5);

INSERT INTO Productos (ID_Producto, Nombre, Descripcion, Precio, Ruta_Imagen, ID_Categoria)
VALUES (23, 'SMOKED MAYO SAUCE', '', 0.90, 'https://i.pinimg.com/originals/14/b2/29/14b229ce7d5277607fccb1dcda7cda3e.jpg', 5);

INSERT INTO Productos (ID_Producto, Nombre, Descripcion, Precio, Ruta_Imagen, ID_Categoria)
VALUES (24, 'WASABI TOP SAUCE', '', 0.90, 'https://i.pinimg.com/originals/4a/69/7c/4a697c7d48d120a575f6f180f3f08206.jpg', 5);



INSERT INTO Productos (ID_Producto, Nombre, Descripcion, Precio, Ruta_Imagen, ID_Categoria)
VALUES (25, 'LOTUS CHEESPEC', 'The Deliciously creamy cheesecake with Lotus cream and a Lotus biscuit base.', 7.50, 'https://i.pinimg.com/originals/4c/59/ee/4c59ee4b733019a293ea9f04384fdc5f.jpg', 6);

INSERT INTO Productos (ID_Producto, Nombre, Descripcion, Precio, Ruta_Imagen, ID_Categoria)
VALUES (26, 'HIPO CHEESPEC', 'The Deliciously creamy cheesecake infused with Kinder cream and a touch of hippopotamus. What could possibly go wrong with this delightful mix?', 8.45, 'https://i.pinimg.com/originals/60/1b/f6/601bf61d4bbac31957fdb761c50cd420.jpg', 6);

INSERT INTO Productos (ID_Producto, Nombre, Descripcion, Precio, Ruta_Imagen, ID_Categoria)
VALUES (27, 'TRADI CHEESPEC', 'The queen of the house, the classic cheesecake, creamy, sweet, with that cheesy flavor, simply spectacular.', 7.45, 'https://i.pinimg.com/originals/bc/ec/50/bcec500ad05aa3fb6c59a53991f8cb0c.jpg', 6);

INSERT INTO Productos (ID_Producto, Nombre, Descripcion, Precio, Ruta_Imagen, ID_Categoria)
VALUES (28, 'CHOCO BROWPEC', 'Another great option, a chocolate brownie with nuts, accompanied by an almond nougat ice cream, moist, creamy ... delicious.', 6.45, 'https://i.pinimg.com/originals/c1/9c/91/c19c91289bc4d78cf2637966c1049c3e.jpg', 6);



INSERT INTO Productos (ID_Producto, Nombre, Descripcion, Precio, Ruta_Imagen, ID_Categoria)
VALUES (29, 'COCA-COLA® ORIGINAL', '', 1.90, 'https://i.pinimg.com/originals/bf/bd/70/bfbd706993c7d5eb76d611cf00edd30b.jpg', 7);

INSERT INTO Productos (ID_Producto, Nombre, Descripcion, Precio, Ruta_Imagen, ID_Categoria)
VALUES (30, 'COCA‑COLA® ZERO', '', 1.90, 'https://i.pinimg.com/originals/fb/f2/17/fbf21742723b33306ab3d071875357fa.jpg', 7);

INSERT INTO Productos (ID_Producto, Nombre, Descripcion, Precio, Ruta_Imagen, ID_Categoria)
VALUES (31, 'FANTA® ORANGE', '', 1.90, 'https://i.pinimg.com/originals/38/c8/a0/38c8a0691bea98b1a6306d1c837ad315.jpg', 7);

INSERT INTO Productos (ID_Producto, Nombre, Descripcion, Precio, Ruta_Imagen, ID_Categoria)
VALUES (32, 'AQUARIUS® LEMON', '', 1.90, 'https://i.pinimg.com/originals/df/2d/ec/df2decc361750d00bc0de1292ca946fc.jpg', 7);

INSERT INTO Productos (ID_Producto, Nombre, Descripcion, Precio, Ruta_Imagen, ID_Categoria)
VALUES (33, 'NESTEA®', '', 1.90, 'https://i.pinimg.com/originals/90/cc/67/90cc672d1838312a1d5ddf82af340976.jpg', 7);

INSERT INTO Productos (ID_Producto, Nombre, Descripcion, Precio, Ruta_Imagen, ID_Categoria)
VALUES (34, 'SPRITE®', '', 1.90, 'https://i.pinimg.com/originals/80/8d/c2/808dc27a2fff6443900a5505ad2da62b.jpg', 7);

INSERT INTO Productos (ID_Producto, Nombre, Descripcion, Precio, Ruta_Imagen, ID_Categoria)
VALUES (35, 'WATER', '', 1.40, 'https://i.pinimg.com/originals/6f/9b/7a/6f9b7a0bf8870122efc4aed66f5fccd4.jpg', 7);

INSERT INTO Productos (ID_Producto, Nombre, Descripcion, Precio, Ruta_Imagen, ID_Categoria)
VALUES (36, 'BEER', '', 2.10, 'https://i.pinimg.com/originals/1a/27/94/1a2794413e13c0b6c9747150b9688a1f.jpg', 7);

INSERT INTO Productos (ID_Producto, Nombre, Descripcion, Precio, Ruta_Imagen, ID_Categoria)
VALUES (37, 'RED BULL ORIGINAL', '', 2.40, 'https://i.pinimg.com/originals/a9/4b/d6/a94bd6d8b42bbcbdd026df8e3ecc99d5.jpg', 7);

INSERT INTO Productos (ID_Producto, Nombre, Descripcion, Precio, Ruta_Imagen, ID_Categoria)
VALUES (38, 'RED BULL SUGARFREE', '', 2.40, 'https://i.pinimg.com/originals/5b/5e/bb/5b5ebbe1a4ebf840912485af6db21f4f.jpg', 7);

INSERT INTO Productos (ID_Producto, Nombre, Descripcion, Precio, Ruta_Imagen, ID_Categoria)
VALUES (39, 'RED BULL WATERMELON', '', 2.40, 'https://i.pinimg.com/originals/97/13/53/971353b8f26c54ec52d581a123ef436f.jpg', 7);

INSERT INTO Productos (ID_Producto, Nombre, Descripcion, Precio, Ruta_Imagen, ID_Categoria)
VALUES (40, 'RED BULL APRICOT', '', 2.40, 'https://i.pinimg.com/originals/d5/5f/22/d55f22ffc2a1eb0a0df350bbb391dbdd.jpg', 7);
EXCEPTION
    WHEN OTHER THEN
    ROLLBACK;
END;
