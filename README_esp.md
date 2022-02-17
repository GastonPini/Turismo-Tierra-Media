# Turismo Tierra Media

turismo-tierra-media es un sistema que cuenta con la información de las distintas atracciones de
toda la Tierra Media.
El sistema sugiere visitas a partir de la ubicación de los visitantes y también genera itinerarios a partir de la información de preferencias disponible en el perfil de los usuarios.

Cada atracción cuenta con su costo de visita, el promedio de tiempo necesario para realizarla, el cupo de visitantes diarios y el tipo de atracción (paisaje, de aventura, de degustación).
Por su parte, para cada usuario el sistema conoce su presupuesto, el tiempo disponible para visitas y el tipo de atracción preferida.


### Algunos detalles de implementación:

#### La base de datos contiene tablas para:
- Tipo de Atracciones.
- Atracciones.
- Promociones.
- Usuarios.
- Itinerarios.


Cada promoción incluye una o varias atracciones y beneficia al usuario con una reducción del costo 
total. Se espera que el sistema permita la definición de promociones de tres tipos:
- Promociones porcentuales (X % de descuento en el costo total).
- Promociones absolutas ($ X por todo el paquete).
- Promociones A x B (si el usuario compra A,B,C entonces tiene gratis D).


#### Para cada usuario, el sistema:

- Sugiere una ​atracción que coincida con sus preferencias, costos y tiempos​. Se prioriza la oferta de paquetes, las atracciones más caras y que requieran mayor tiempo, en ese orden.
No se oferta una atracción o paquete que no pueda costearse o para la cual no tenga tiempo disponible. Tampoco se oferta una atracción que ya haya sido incluida en un paquete comprado.
Una vez agotadas las ofertas que coinciden con sus intereses, se ofertam aquellas que no coincidan, bajo el mismo criterio.

- Si el usuario acepta, se guarda dentro de su sugerencia diaria. Una atracción o paquete aceptado no se puede cancelar.

- Se muestra un​ resumen de todo su itinerario​ , contabilizando las horas necesarias para realizarlo y las monedas que deberá gastar.