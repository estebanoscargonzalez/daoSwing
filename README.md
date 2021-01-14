# daoSwing
TP Final de Paradigmas de Programación 2020

Enunciado del TP

   El propósito del trabajo práctico de la materia es realizar una aplicación programada en Java que permita resolver una situación problemática a libre elección del alumno. Para el desarrollo de la aplicación, se deben utilizar los conceptos que se estudian a lo largo de la materia. La resolución programada de la aplicación debe implementar:
- patrones de diseño vistos en clases;
- acceso a una base de datos mediante JDBC;
- interfaz gráfica con la librería de Swing.

Entrega 1

   En la primera instancia del trabajo práctico, cada alumno debe definir una situación problemática a resolver en la cual se empleen patrones de diseño en el desarrollo 
  de la aplicación. El alumno debe entregar una aplicación con la implementación de distintos patrones de diseño.
	Esto servirá de estructura base para continuar con las entregas restantes del trabajo práctico. Para esta instancia, las entradas y salidas de datos/información serán 
  manipuladas mediante la consola de la IDE.
	Se debe presentar la aplicación programada con los patrones de diseño propuestos para su codificación.

Entrega 2

   Luego de definir e implementar los patrones de diseño, se debe agregar la utilización de persistencia de datos sobre el proyecto. Se deben identificar aquellos datos que 
  pueden ser persistidos en una base de datos. Para persistir y consultar la información, se debe emplear JDBC mediante el patrón DAO. Los datos a persistir no necesariamente 
  tienen que estar relacionados con los patrones de diseño seleccionados. El motor de base de datos a utilizar queda a libre elección del alumno, siempre y cuando sea una base 
  de datos relacional.

Entrega 3

   Habiendo completado las etapas anteriores, por último, se debe incorporar una interfaz gráfica con la librería de Swing que permita la interacción del usuario con la 
  aplicación.
  
  
  Entrega 1:

   La aplicación consiste en representar la producción de una fábrica de helados en conos de distintos tamaño y sabor, con o sin aderezos y/o bañado en chocolate. El patrón de diseño de construcción que se emplea es Factory Method, combinado con el patrón de diseño de estructuración Facade.
Al ejecutar la clase Main del paquete test, se visualizará un menú en la consola. La opción 1 (Encender fabrica) y la opción 5 (Apagar fabrica) imprimirán por pantalla el resultado de la implementación de los patrones de diseño realizados. Esta última opción, a su vez, mostrará una interfaz gráfica de usuario hecha con las librerías de Swing que, al ser cerrada, finalizará la ejecución del programa.

Entrega 2:

   Además, podremos utilizar las opciones 2, 3 y 4 del menú para interactuar con la base de datos, ya sea registrando, buscando o eliminando clientes, cuyos atributos son: legajo, apellido, nombre y cantidad de helados comprados. El motor de base de datos utilizado es DB Browser for SQLite.

Entrega 3:

   La clase FrameCompraDigitalCliente permite que el usuario pueda interactuar con la base de datos desde una IGU.  Allí, los métodos DAO son llamados/invocados desde los componentes de Swing. De esta manera, se evita el alto acoplamiento y dependencia entre Swing y la base de datos.
