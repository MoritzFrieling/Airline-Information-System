CREATE TABLE Route (
origin varchar primary key,
destination varchar primary key,
distance int,

foreign key (origin) references AirportData(abbreviation),
foreign key (destination) references AirportData(abbreviation)
);

CREATE TABLE Airport (
airportName varchar,
abbreviation varchar primary key,
cityName varchar,
countryName varchar
);

CREATE TABLE Plane(
number int,
planeModelNumber
);

CREATE TABLE PlaneModel (
manufracturer varchar,
number varchar primary key,
seats int,
range double precision,
weightCapactiy double precision
);