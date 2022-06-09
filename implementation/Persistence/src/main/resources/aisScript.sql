create domain string as
    varchar not null ;

create domain number as
    integer not null;


create table airports(
                         "abbreviation" varchar primary key,
                         "Latitude" float(6) not null,
                         "Longitude" float(6) not null,
                         "airport-name" string
);


create table routes(
                       id serial primary key,
                       origin string,
                       destination string,
                       constraint "fk_routes-airports-origin"
                           foreign key(origin)
                               references airports("abbreviation"),

                       constraint "fk_routes-airports-destination"
                           foreign key(destination)
                               references airports("abbreviation")
);


create table "planeModels"(
                              "model-number" varchar primary key ,
                              "manufacturer" string,
                              "seats" number,
                              "range" float4 not null,
                              "speed" number,
                              "weight-capacity" float4 not null
);


create table planes(
                       "plane-number" varchar primary key,
                       "plane-model" string,
                       constraint "fk_planes-models"
                           foreign key ("plane-model")
                               references "planeModels"("model-number")
);


create table flights(
                        "flight-number" serial primary key,
                        "flight-date" date not null,
                        "flight-route-id" number,
                        "flight-plane" string,

                        constraint "fk_flights-routes"
                            foreign key ("flight-route-id")
                                references "routes"("id"),

                        constraint "fk_flights-planes"
                            foreign key ("flight-plane")
                                references "planes"("plane-number")
);


create table customers(
                          "E-Mail" varchar primary key,
                          "customer-name" string,
                          "birthday" date not null,
                          "address" string,
                          "Miles" float(2)
);


create table bookings(
                         "booking-id" serial primary key,
                         "customer-mail" string,
                         "flight-number" number,
                         "price" float(2),

                         constraint "fk_bookings-customers"
                             foreign key ("customer-mail")
                                 references "customers"("E-Mail")
);


create table tickets(
                        "ticket-id" serial primary key,
                        "booking-id" number,
                        "firstname" string,
                        "lastname" string,
                        "food-option" number,
                        "extra-luggage" number,
                        "plane-class" number,
                        "price" float(2) not null,

                        constraint "fk_tickets-bookings"
                            foreign key ("booking-id")
                                references bookings("booking-id")

);

create table accounts(
                         "account-id" serial primary key,
                         "firstname" string,
                         "lastname" string,
                         "position" string,
                         "salt" string,
                         "log-in" string,
                         "password" string
);



-- Adjustments for Plane and PlaneModel--

-- ALTER TABLE aisdb.ais.planes
-- DROP CONSTRAINT "fk_planes-models";

ALTER TABLE aisdb.ais."planeModels"
DROP CONSTRAINT "planeModels_pkey";


ALTER TABLE aisdb.ais."planeModels"
ADD COLUMN "model-ID" serial PRIMARY KEY ;

ALTER TABLE aisdb.ais.planes
DROP COLUMN "plane-model";

ALTER TABLE aisdb.ais.planes
ADD COLUMN "plane-model" integer;

ALTER TABLE aisdb.ais.planes
ADD CONSTRAINT "fk_planeModel"
FOREIGN KEY("plane-model")
REFERENCES  aisdb.ais."planeModels"("model-ID");

ALTER TABLE aisdb.ais.flights
    DROP CONSTRAINT "fk_flights-planes";

ALTER TABLE aisdb.ais.planes
    DROP COLUMN "plane-number";

ALTER TABLE aisdb.ais.planes
    ADD COLUMN "plane-number" serial PRIMARY KEY;

ALTER TABLE aisdb.ais.flights
    drop column "flight-plane";

ALTER TABLE aisdb.ais.flights
    ADD COLUMN "flight-plane" int;

ALTER TABLE aisdb.ais.flights
    ADD CONSTRAINT "fk_flights-planes"
FOREIGN KEY ("flight-plane")
REFERENCES aisdb.ais.planes("plane-number");

ALTER TABLE aisdb.ais.planes
    ADD COLUMN economyClass int,
    ADD COLUMN businessClass int,
    ADD COLUMN firstClass int;

----------------------------------------------

ALTER TABLE aisdb.ais.airports
    ADD COLUMN country string,
    ADD COLUMN city string;
    
    
-------- Adjustments for flight -------------

Alter TABLE aisdb.ais.flights
ADD COLUMN price int,
    ADD COLUMN duration int;

Alter Table aisdb.ais.flights
ALTER COLUMN "flight-date" TYPE timestamp;

---------------------------------------------------------------------
-----------ADDING TIMEZONE TABLE AND ENTRIES---------------
---------------------------------------------------------------------
create table aisdb.ais.timezones(
    "abbreviation" varchar primary key,
    "name" string,
    "standard-deviation" int,
    "startLong" float(6) not null,
    "endLong" float(6) not null
);
---------------------------------------------------------------------
INSERT INTO aisdb.ais.timezones(abbreviation, "name", "standard-deviation", "startLong", "endLong")
VALUES ('UTC', 'Universal Coordinated Time', 0, 0, 14.99999);
INSERT INTO aisdb.ais.timezones(abbreviation, "name", "standard-deviation", "startLong", "endLong")
VALUES ('ECT', 'European Central Time', 1, 15, 29.99999);
INSERT INTO aisdb.ais.timezones(abbreviation, "name", "standard-deviation", "startLong", "endLong")
VALUES ('EET', 'Eastern European Time', 2, 30, 44.99999);
INSERT INTO aisdb.ais.timezones(abbreviation, "name", "standard-deviation", "startLong", "endLong")
VALUES ('EAT', 'Eastern African Time', 3, 45, 59.99999);
INSERT INTO aisdb.ais.timezones(abbreviation, "name", "standard-deviation", "startLong", "endLong")
VALUES ('NET', 'Near East Time', 4, 60, 74.99999);
INSERT INTO aisdb.ais.timezones(abbreviation, "name", "standard-deviation", "startLong", "endLong")
VALUES ('PLT', 'Pakistan Lahore Time', 5, 75, 89.99999);
INSERT INTO aisdb.ais.timezones(abbreviation, "name", "standard-deviation", "startLong", "endLong")
VALUES ('BST', 'Bangladesh Standard Time', 6, 90, 104.99999);
INSERT INTO aisdb.ais.timezones(abbreviation, "name", "standard-deviation", "startLong", "endLong")
VALUES ('VST', 'Vietnam Standard Time', 7, 105, 119.99999);
INSERT INTO aisdb.ais.timezones(abbreviation, "name", "standard-deviation", "startLong", "endLong")
VALUES ('CTT', 'China Taiwan Time', 8, 120, 134.99999);
INSERT INTO aisdb.ais.timezones(abbreviation, "name", "standard-deviation", "startLong", "endLong")
VALUES ('JST', 'Japan Standard Time', 9, 135, 149.99999);
INSERT INTO aisdb.ais.timezones(abbreviation, "name", "standard-deviation", "startLong", "endLong")
VALUES ('AET', 'Australia Eastern Time', 10, 150, 164.99999);
INSERT INTO aisdb.ais.timezones(abbreviation, "name", "standard-deviation", "startLong", "endLong")
VALUES ('SST', 'Solomon Standard Time', 11, 165, 179.99999);
INSERT INTO aisdb.ais.timezones(abbreviation, "name", "standard-deviation", "startLong", "endLong")
VALUES ('NST', 'New Zealand Standard Time', 12, 180, -165.00001);
INSERT INTO aisdb.ais.timezones(abbreviation, "name", "standard-deviation", "startLong", "endLong")
VALUES ('CAT', 'Central African Time', -1, -0.00001, -15);
INSERT INTO aisdb.ais.timezones(abbreviation, "name", "standard-deviation", "startLong", "endLong")
VALUES ('GST', 'Greenland Standard Time', -2, -15.00001, -30);
INSERT INTO aisdb.ais.timezones(abbreviation, "name", "standard-deviation", "startLong", "endLong")
VALUES ('BET', 'Brazil Eastern Time', -3, -30.00001, -45);
INSERT INTO aisdb.ais.timezones(abbreviation, "name", "standard-deviation", "startLong", "endLong")
VALUES ('PRT', 'Puerto Rico and US Virgin Islands Time', -4, -45.00001, -60);
INSERT INTO aisdb.ais.timezones(abbreviation, "name", "standard-deviation", "startLong", "endLong")
VALUES ('EST', 'Eastern Standard Time', -5, -60.00001, -75);
INSERT INTO aisdb.ais.timezones(abbreviation, "name", "standard-deviation", "startLong", "endLong")
VALUES ('CST', 'Central Standard Time', -6, -75.00001, -90);
INSERT INTO aisdb.ais.timezones(abbreviation, "name", "standard-deviation", "startLong", "endLong")
VALUES ('MST', 'Mountain Standard Time', -7, -90.00001, -105);
INSERT INTO aisdb.ais.timezones(abbreviation, "name", "standard-deviation", "startLong", "endLong")
VALUES ('PST', 'Pacific Standard Time', -8, -105.000001, -120);
INSERT INTO aisdb.ais.timezones(abbreviation, "name", "standard-deviation", "startLong", "endLong")
VALUES ('AST', 'Alaska Standard Time', -9, -120.00001, -135);
INSERT INTO aisdb.ais.timezones(abbreviation, "name", "standard-deviation", "startLong", "endLong")
VALUES ('HST', 'Hawaii Standard Time', -10, -135.00001, -150);
INSERT INTO aisdb.ais.timezones(abbreviation, "name", "standard-deviation", "startLong", "endLong")
VALUES ('MIT', 'Midway Islands Time', -11, -150.00001, -165);

---------------------------------------------------------------------
ALTER TABLE aisdb.ais.airports
    ADD COLUMN "timezone" string;
ALTER TABLE aisdb.ais.airports
    ADD CONSTRAINT fk_airports_timezones FOREIGN KEY (timezone) REFERENCES aisdb.ais.timezones (abbreviation);
---------------------------------------------------------------------
drop table ais.test;

--------------------------------------------------
