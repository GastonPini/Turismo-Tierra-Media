# Turismo Tierra Media

A Java web application for managing attractions, promotions, users and personalized itineraries for a fictional Middle-earth amusement park.

The system generates personalized recommendations based on each user's preferences, available time and budget, and allows users to build and manage daily itineraries.

## Features

- Attraction management
- User management
- Promotion management
- Personalized attraction recommendations
- Itinerary generation and management
- User authentication and session management
- Administrative access control
- Attraction filtering based on user preferences
- Budget and time constraints
- Itinerary cost and duration summaries

## Recommendation System

The recommendation logic considers:

- User preferences
- Available budget
- Available time
- Attraction type
- Previously purchased attractions and packages

The system generates recommendations according to the defined business rules.

Attractions and packages that the user cannot afford or complete within the available time are excluded from the recommendations.

## Promotions

The system supports three types of promotions:

- **Percentage:** applies a percentage discount to the total price.
- **Absolute:** offers a package at a fixed price.
- **A × B:** purchasing a set of attractions provides another attraction for free.

These promotion types are modeled independently in the domain layer.

## Architecture

The application is organized into several components:

```text
Web Interface
      │
      ▼
Java Servlets / Controllers
      │
      ├── Filters
      │
      ▼
DAO Layer
      │
      ▼
Database
```


## Author

**Gastón Pini**  
Backend Developer | Data Engineer | Bioinformatics

[LinkedIn](TU_LINK_DE_LINKEDIN) · [GitHub](https://github.com/GastonPini)
