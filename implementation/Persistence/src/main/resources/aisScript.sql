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
                         "customer-mail" number,
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