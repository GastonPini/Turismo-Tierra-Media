# Turismo Tierra Media

Una aplicación web desarrollada en Java para gestionar atracciones, promociones, usuarios e itinerarios personalizados para un parque de diversiones ficticio de la Tierra Media.

El sistema genera recomendaciones personalizadas en función de las preferencias de cada usuario, el tiempo disponible y el presupuesto, y permite a los usuarios crear y gestionar itinerarios diarios.

## Funcionalidades

- Gestión de atracciones
- Gestión de usuarios
- Gestión de promociones
- Recomendaciones personalizadas de atracciones
- Generación y gestión de itinerarios
- Autenticación de usuarios y gestión de sesiones
- Control de acceso administrativo
- Filtrado de atracciones según las preferencias del usuario
- Restricciones de presupuesto y tiempo
- Resúmenes del costo y duración de los itinerarios

## Sistema de Recomendaciones

La lógica de recomendación considera:

- Preferencias del usuario
- Presupuesto disponible
- Tiempo disponible
- Tipo de atracción
- Atracciones y paquetes adquiridos previamente

El sistema genera recomendaciones de acuerdo con las reglas de negocio definidas.

Las atracciones y paquetes que el usuario no puede pagar o completar dentro del tiempo disponible son excluidos de las recomendaciones.

## Promociones

El sistema admite tres tipos de promociones:

- **Porcentual:** aplica un porcentaje de descuento sobre el precio total.
- **Absoluta:** ofrece un paquete a un precio fijo.
- **A × B:** la compra de un conjunto de atracciones proporciona otra atracción de forma gratuita.

Estos tipos de promociones se modelan de forma independiente en la capa de dominio.

## Arquitectura

La aplicación está organizada en varios componentes:

```text
Interfaz Web
      │
      ▼
Servlets Java / Controladores
      │
      ├── Filtros
      │
      ▼
Capa DAO
      │
      ▼
Base de Datos
```

## Autor

**Gastón Pini**

Backend Developer | Data Engineer | Lic. en Bioinformática

[LinkedIn](https://www.linkedin.com/in/gaston-pini/) · [GitHub](https://github.com/GastonPini)
