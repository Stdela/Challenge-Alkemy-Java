# Challenge-Alkemy-Java
Challenge realizado para ingreso en capacitación Alkemy

## Detalles a trabajar
1. Se realizó correctamente el sistema de correo, registro y login. Por otro lado, si bien se logró realizar la autentificación por Token, esta fue dañada en una posterior modificación dando lugar a un error en la decodificación a través de Base64 (problemas en decodificar la tercera parte del token).Esto significa que por defecto Spring Security ha sido registrado con ***.permitAll()*** , *comentar los filtros en seguridad también es una opción pero mi objetivo era dejar en evidencia ese error en particular*.
2. Por el momento el código no cuenta con Documentación realizada a través de Postman o Swagger
3. Por el momento el código no cuenta con métodos de testing.

### Notas
1. Envío de emails realizado a través de Java Mail Sender.
2. Base de datos: H2.
3. El nombrado de paquetes y clases ha sido realizado sin seguir un patrón de idioma determinado y la API ha sido realizada en su mayoría en Español. Una completa traducción al inglés puede realizarse sin demora en caso de ser necesaria. 
4. Posteriores actualizaciones serán realizadas a la brevedad. 


