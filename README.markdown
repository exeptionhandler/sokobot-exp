# Sokobot

Sokobot es un bot de Discord escrito con [JDA](https://github.com/DV8FromTheWorld/JDA) que te deja jugar [Sokoban](https://en.wikipedia.org/wiki/Sokoban), el clásico juego de rompecabezas de empujar cajas.

## Capturas de Pantalla
![Level 1](https://a.fsdn.com/con/app/proj/sokobot-esp/screenshots/sokobot_v1.1.gif/max/max/1)
![Level 2](https://a.fsdn.com/con/app/proj/sokobot-esp/screenshots/sokobot_v1.1_.gif/max/max/1)

## Características
### Niveles Infinitos
Los mapas de Sokobot se generan aleatoriamente, aumentando la dificultad a medida que avanzas.
### Controles Variados
¡Sokobot tiene múltiples opciones de control para mejorar la experiencia del jugador, incluidas las reacciones y los comandos wasd!
### Juegos Simultaneos
Gracias al poder de Java HashMaps ™ ️, varios usuarios pueden usar el bot al mismo tiempo sin interferir entre sí.
### Prefijo Personalizado ``Nuevo!``
Para evitar que Sokobot entre en conflicto con otros bots, los administradores pueden elegir cualquier prefijo de un solo carácter para preceder los comandos de Sokobot.

## Comandos
### Usuario
- ``!play`` se puede utilizar para iniciar un juego si no está en uno.
- ``!stop`` se puede utilizar para detener su juego activo en cualquier momento.
- ``!info`` proporciona algunos detalles útiles sobre el bot y las reglas del juego.
### Administrador ``Nuevo!``
- ``!prefix [character]`` se puede usar para cambiar el prefijo al que responde el bot en el servidor actual.

## Uso
### Hospedaje Publico ``Nuevo!``
Sokobot está disponible en top.gg y se puede agregar a su servidor [en un click](https://top.gg/bot/713635251703906336/)! o [constrúyelo tú mismo](#compiling)

Versión en español [aqui!](https://discordbotlist.com/bots/sokobot-espanol)

### Autohospedaje
Toma la [ultima versión](https://sourceforge.net/projects/sokobot-esp/files/) . Luego, crea una aplicación Bot [aquí](https://discord.com/developers/applications/) y pega el token del bot en ``token.env``. Luego, asegúrese de que los dos archivos estén en el mismo directorio y ejecute el archivo .jar.

## Compilado

Instala [Java 8 JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) y [Gradle](https://gradle.org/).
En la carpeta raíz del proyecto, ejecute ``gradlew shadowJar``.
El archivo .jar compilado se ubicará en ``build/libs``.

## Contribuir
Si quiere contribuir contribuya [aquí](https://github.com/PolyMarsDev/Sokobot)


NEW VERSION MADE BY ME:
[HERE](https://github.com/exeptionhandler/Sokoromi)
