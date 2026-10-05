# Turismo Tierra Media

A tourism management and recommendation system designed for a fictional Middle-earth amusement park.

The application manages attractions, users, promotions and itineraries, and generates personalized visit suggestions based on each user's preferences, available time and budget.

## Overview

The system models a tourism platform where users can discover attractions and build personalized itineraries.

Each attraction has:

- Cost
- Estimated duration
- Daily visitor capacity
- Type (landscape, adventure or tasting)

Each user has:

- Available budget
- Available time
- Preferred attraction types

The system uses this information to generate recommendations and build the user's daily itinerary.

## Main Features

### Personalized recommendations

The system suggests attractions or packages according to the user's:

- Preferences
- Available budget
- Available time

Recommendations prioritize packages and then consider attractions according to their cost and required time.

Attractions that the user has already purchased or cannot afford or complete within the available time are excluded.

### Itinerary management

Accepted attractions and packages are added to the user's daily itinerary.

The system provides a summary including:

- Total estimated time
- Total cost
- Selected attractions and packages

### Promotions

The system supports different types of promotions:

- Percentage discounts
- Fixed-price packages
- A × B promotions, where purchasing a set of attractions provides another attraction for free

## Data Model

The application manages the following main entities:

- Users
- Attractions
- Attraction types
- Promotions
- Itineraries

Promotions can include one or multiple attractions and modify the total cost of an itinerary.

## Project Structure

```text
├── src/             # Application source code
├── WebContent/      # Web application resources
├── database/        # Database scripts and data
└── README.md
```

## Purpose

This project was developed as a software engineering project focused on object-oriented design, business rules, data persistence and recommendation logic.

It demonstrates the implementation of a domain-driven application where multiple business constraints are combined to generate personalized recommendations and itineraries.

## Status

This is an academic/personal project and is preserved as a portfolio example.

## Author

**Gastón Pini**

Backend Developer | Data Engineer | Bioinformatics

[GitHub](https://github.com/GastonPini)
