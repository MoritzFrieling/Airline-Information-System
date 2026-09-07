-- Local showcase data for the Airline Information System.
-- It only adds records that do not already exist, so it can safely be run again.

BEGIN;

INSERT INTO ais.accounts (firstname, lastname, position, salt, "e-Mail", password)
SELECT 'Marina', 'Keller', 'Manager', 'Manager-AIS-2026', 'manager@ais.local',
       '09b059d461ca7fd72d76d4fbac2bf566f9b4c56efaa5717711520a453a01191d35f490f254f708027b43babbfbdc484a4cd42e5c864c708adfe91c130da8052d'
WHERE NOT EXISTS (SELECT 1 FROM ais.accounts WHERE "e-Mail" = 'manager@ais.local');
INSERT INTO ais.accounts (firstname, lastname, position, salt, "e-Mail", password)
SELECT 'Oskar', 'de Vries', 'Officer', 'Officer-AIS-2026', 'officer@ais.local',
       '1b24269dca7c7f55621d71eb40c737c6ed15064cd22d7682a937bd516af635add82f44e332627bed140d054d251348fbee2af5822b21ce05bb378ce98bc8da52'
WHERE NOT EXISTS (SELECT 1 FROM ais.accounts WHERE "e-Mail" = 'officer@ais.local');
INSERT INTO ais.accounts (firstname, lastname, position, salt, "e-Mail", password)
SELECT 'Elena', 'Meyer', 'Employee', 'Employee-AIS-2026', 'employee@ais.local',
       'e3d18a91a98a9c6fff04747b245c88367b954716cf2ccf3a5631e84f40f9b2202bf7e5288c188b04fd53570733240fa650d43bc272eac414d665d0b307f6bf79'
WHERE NOT EXISTS (SELECT 1 FROM ais.accounts WHERE "e-Mail" = 'employee@ais.local');

INSERT INTO ais.airports ("abbreviation", "Latitude", "Longitude", "airport-name", country, city, timezone) VALUES
    ('FRA', 50.0379, 8.5622, 'Frankfurt Airport', 'Germany', 'Frankfurt', 'UTC'),
    ('AMS', 52.3105, 4.7683, 'Amsterdam Airport Schiphol', 'Netherlands', 'Amsterdam', 'UTC'),
    ('CDG', 49.0097, 2.5479, 'Paris Charles de Gaulle Airport', 'France', 'Paris', 'UTC'),
    ('LHR', 51.4700, -0.4543, 'London Heathrow Airport', 'United Kingdom', 'London', 'CAT'),
    ('JFK', 40.6413, -73.7781, 'John F. Kennedy International Airport', 'United States', 'New York', 'EST'),
    ('DXB', 25.2532, 55.3657, 'Dubai International Airport', 'United Arab Emirates', 'Dubai', 'NET'),
    ('SIN', 1.3644, 103.9915, 'Singapore Changi Airport', 'Singapore', 'Singapore', 'BST'),
    ('MUC', 48.3538, 11.7861, 'Munich Airport', 'Germany', 'Munich', 'UTC')
ON CONFLICT ("abbreviation") DO NOTHING;

INSERT INTO ais."planeModels" ("model-number", manufacturer, seats, "range", speed, "weight-capacity")
SELECT v.model_number, v.manufacturer, v.seats, v.range, v.speed, v.weight_capacity
FROM (VALUES
    ('A320-200', 'Airbus', 180, 6150.0, 840, 19900.0),
    ('A321neo', 'Airbus', 220, 7400.0, 870, 23000.0),
    ('737-800', 'Boeing', 189, 5765.0, 842, 20500.0),
    ('787-9', 'Boeing', 296, 14140.0, 913, 35000.0)
) AS v(model_number, manufacturer, seats, range, speed, weight_capacity)
WHERE NOT EXISTS (
    SELECT 1 FROM ais."planeModels" pm
    WHERE pm.manufacturer = v.manufacturer AND pm."model-number" = v.model_number
);

INSERT INTO ais.routes (origin, destination)
SELECT v.origin, v.destination
FROM (VALUES ('FRA', 'JFK'), ('AMS', 'DXB'), ('LHR', 'CDG'), ('MUC', 'SIN'), ('CDG', 'FRA')) AS v(origin, destination)
WHERE NOT EXISTS (SELECT 1 FROM ais.routes r WHERE r.origin = v.origin AND r.destination = v.destination);

INSERT INTO ais.planes ("plane-model", economyclass, businessclass, firstclass)
SELECT pm."model-ID", v.economyclass, v.businessclass, v.firstclass
FROM (VALUES
    ('Boeing', '787-9', 240, 32, 24),
    ('Airbus', 'A320-200', 160, 20, 0),
    ('Boeing', '737-800', 170, 18, 0),
    ('Airbus', 'A321neo', 185, 28, 0)
) AS v(manufacturer, model_number, economyclass, businessclass, firstclass)
JOIN ais."planeModels" pm ON pm.manufacturer = v.manufacturer AND pm."model-number" = v.model_number
WHERE NOT EXISTS (
    SELECT 1 FROM ais.planes p
    WHERE p."plane-model" = pm."model-ID" AND p.economyclass = v.economyclass
      AND p.businessclass = v.businessclass AND p.firstclass = v.firstclass
);

INSERT INTO ais.flights ("flight-date", "flight-route-id", "flight-plane", price, duration)
SELECT v.flight_date, r.id, p."plane-number", v.price, v.duration
FROM (VALUES
    ('FRA', 'JFK', 'Boeing', '787-9', 240, TIMESTAMP '2026-09-08 09:30:00', 54900, 480),
    ('AMS', 'DXB', 'Airbus', 'A321neo', 185, TIMESTAMP '2026-09-08 13:15:00', 42900, 395),
    ('LHR', 'CDG', 'Airbus', 'A320-200', 160, TIMESTAMP '2026-09-09 08:10:00', 9900, 75),
    ('MUC', 'SIN', 'Boeing', '787-9', 240, TIMESTAMP '2026-09-10 10:45:00', 62900, 710)
) AS v(origin, destination, manufacturer, model_number, economyclass, flight_date, price, duration)
JOIN ais.routes r ON r.origin = v.origin AND r.destination = v.destination
JOIN ais."planeModels" pm ON pm.manufacturer = v.manufacturer AND pm."model-number" = v.model_number
JOIN ais.planes p ON p."plane-model" = pm."model-ID" AND p.economyclass = v.economyclass
WHERE NOT EXISTS (
    SELECT 1 FROM ais.flights f WHERE f."flight-date" = v.flight_date AND f."flight-route-id" = r.id
);

INSERT INTO ais.customers ("E-Mail", "customer-name", birthday, address, "Miles") VALUES
    ('lina.schmidt@example.com', 'Lina Schmidt', DATE '1998-05-14', 'Frankfurt am Main, Germany', 12450),
    ('noah.vermeer@example.com', 'Noah Vermeer', DATE '1993-11-02', 'Amsterdam, Netherlands', 8420),
    ('sophie.dubois@example.com', 'Sophie Dubois', DATE '1987-02-21', 'Paris, France', 19700),
    ('jonas.becker@example.com', 'Jonas Becker', DATE '2001-08-08', 'Munich, Germany', 3650)
ON CONFLICT ("E-Mail") DO NOTHING;

INSERT INTO ais.bookings ("customer-mail", "flight-number", price)
SELECT v.customer_mail, f."flight-number", v.price
FROM (VALUES
    ('lina.schmidt@example.com', 'FRA', 'JFK', 549.00),
    ('noah.vermeer@example.com', 'AMS', 'DXB', 429.00),
    ('sophie.dubois@example.com', 'LHR', 'CDG', 99.00)
) AS v(customer_mail, origin, destination, price)
JOIN ais.routes r ON r.origin = v.origin AND r.destination = v.destination
JOIN ais.flights f ON f."flight-route-id" = r.id
WHERE NOT EXISTS (
    SELECT 1 FROM ais.bookings b WHERE b."customer-mail" = v.customer_mail AND b."flight-number" = f."flight-number"
);

INSERT INTO ais.tickets ("booking-id", firstname, lastname, "food-option", "extra-luggage", "plane-class", price)
SELECT b."booking-id", v.firstname, v.lastname, v.food_option, v.extra_luggage, v.plane_class, v.price
FROM (VALUES
    ('lina.schmidt@example.com', 'Lina', 'Schmidt', 1, 1, 1, 549.00),
    ('noah.vermeer@example.com', 'Noah', 'Vermeer', 2, 0, 0, 429.00),
    ('sophie.dubois@example.com', 'Sophie', 'Dubois', 0, 1, 0, 99.00)
) AS v(customer_mail, firstname, lastname, food_option, extra_luggage, plane_class, price)
JOIN ais.bookings b ON b."customer-mail" = v.customer_mail
WHERE NOT EXISTS (
    SELECT 1 FROM ais.tickets t
    WHERE t."booking-id" = b."booking-id" AND t.firstname = v.firstname AND t.lastname = v.lastname
);

COMMIT;
