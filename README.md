# 📋RecibeBook #  
> Nota!

Este proyecto es una solución de una prueba planteada por Empowerment Labs.

## ¿Cómo se realiza la solución del Test?

Se crea un proyecto de Android utilizando JetPack Compose, al terminar la creación para continuar con el proceso se aplica clean architecture y MVVM, esto con la finalidad de poder desacoplar la lógica de negocio de la vista y la infraestructura, además de garantizar que se genera un código limpio, estructurado y legible.

Este proyecto también cuenta con pruebas unitarias basadas en resolver la lógica de negocio y no en cumplir con covertura, en su interior encontramos patrones de diseño y buenas practicas.

Por ultimo, este proyecto aplica buenas practicas de código y principios para garantizar el proceso.


## ¿Qué arquitecturas se utiliza?

A continuación se presenta un diagrama de como se ve Clean Architecture:

![Clean Architecture](https://mahedee.net/assets/images/posts/2021/clean.png)
**Nota:** Para este proyecto no se esta utilizando la capa de Application ni de Persistence.

Para poder implementar la arquitectura limpia debemos crear dos modulos o capas más para el proyecto, los cuales son **Domain** y **Infrastructure**, además se renombra la capa **App** por **Presentation**:
* **Presentation:** Se encuentra todo lo que va de cara al usuario.
* **Domain:** Encontramos toda la lógica de negocio.
* **Infrastructure:** Se implementa la conexión a API's o bases de datos para la obtención de data.

También se aplica **MVVM** como arquitectura de diseño que nos ayuda a aplicar reactividad de una manera más simple:

![MVVM](https://www.adictosaltrabajo.com/wp-content/uploads/2020/06/MVVMPattern.png)

Internamente se aplica diferentes patrones de diseño que se ven explicados posteriormente.

## ¿Qué patrones de diseño usamos?

Los patrones de diseño se utilizan para resolver problemas de los cuales se necesita estandarizar una solución que ayude a disminuir la fricción en cuando al entendimiento de la solución, en este caso utilizamos:
* **Repository pattern:** Nos ayuda a transportar la información desde la capa de infraestructura evitando acoplamiento de capaz.
  ![RepositoryPattern](https://miro.medium.com/max/981/1*5kNXJ7aFSGJvuh4r4egpTg.png)
* **Translate pattern:** Al recibir DTO cuando consumimos el API, nos ayuda a transformar este objeto a uno de Dominio fácilmente.
* **DataBuilder pattern:** Nos ayuda a construir objetos con caracteristicas especiales dependiendo las pruebas que deseemos realizar.
* **Dependency injection:** Nos ayuda a crear los objetos de una manera útil, escalable y nos permite desacoplar completamente el dominio de las demás capaz.

## ¿Qué librerías se utilizaron en el proyecto?

Las librerias cumplen con el proposito de solucionar problemas que a menudo se encuentran en el desarrollo, haciendo mucho más fácil la implementación, para el caso de este proyecto se utilizaron:

* **Hilt:** Inyección de dependencias.
* **Retrofit2:** Realiza la estructura para las peticiones a las API's.
* **LiveData:** Nos ayuda a crear valores reactivos.
* **Mockito:** Crea información fake para las pruebas unitarias que se realizan.

## Consideraciones adicionales

El repositorio es publico, por lo cual no hay necesidad de manejar credenciales adicionales ni solicitar permisos al dueño del repositorio @felipevelasquez08 para poder acceder a su contenido.

El proyecto tiene dos variantes de construcción **PROD**  y **MOCK**:
* **PROD:** Tiene toda la configuración necesaria para realizar las peticiones al servicio.
* **MOCK:** Tiene la información mockeada desde la infraestructura.


# Ejecución del proyecto

Inicialmente necesitamos crear una carpeta con en la cual almacenaremos el repositorio:
### Windows
> md projects
### Linux/Mac
> mkdir projects

Procedemos a entrar a la carpeta de la siguiente manera:
### Windows/Linux/Mac
> cd projects

Ahora clonamos el repositorio:
### Windows/Linux/Mac
> git clone https://github.com/FelipeVelasquez1802/RecipeBook.git

**Nota:** Para realizar este proceso debemos tener git instalado en nuestro equipo.

### Ahora con nuestro IDE de confianza procedemos a abrir el proyecto y ejecutar el aplicativo.
