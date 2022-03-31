

CREATE TABLE RouteData (
origin varchar,
destination varchar,
distance int,

foreign key (origin) references AirportData(abbreviation),
foreign key (destination) references AirportData(abbreviation)
);

CREATE TABLE AirportData (
airportName varchar,
abbreviation varchar primary key,
cityName varchar,
countryName varchar

);