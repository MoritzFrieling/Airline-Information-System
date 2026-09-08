# Airline Information System - Setup Information

## Local development database

This project was prepared with a local PostgreSQL 16 development instance. It is bound to `localhost:5432` only.

- PostgreSQL administrator: `admin` / `password`
- Application user: `aisdemouser` / `ais`
- Database: `aisdb`
- Schema: `ais`
- Windows service: `postgresql-ais16`
- Data directory: `C:\Program Files\PostgreSQL\16\data`
- GUI evaluation login: username `dev`, leave the password empty

These credentials are for the local development environment only.

## Demo data

The local `aisdb` instance contains a small, repeatable showcase data set: eight airports, five routes, four aircraft models, four aircraft, four upcoming flights, four customers, three bookings, and three tickets. It is also stored in [`implementation/Persistence/src/main/resources/demo-data.sql`](implementation/Persistence/src/main/resources/demo-data.sql).

All demo user accounts use the password `demo123`:

- `manager@ais.local`: Manager
- `officer@ais.local`: Officer
- `employee@ais.local`: Employee
