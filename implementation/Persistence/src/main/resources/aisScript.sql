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

ALTER TABLE aisdb.ais.planes
DROP CONSTRAINT "fk_planes-models";

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