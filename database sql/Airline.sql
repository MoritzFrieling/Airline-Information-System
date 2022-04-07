CREATE TABLE public.airport (
	airportname varchar NOT NULL,
	abbreviation varchar NOT NULL,
	cityname varchar NOT NULL,
	countryname varchar NOT NULL,
	CONSTRAINT airport1_pk PRIMARY KEY (abbreviation)
);

CREATE TABLE public.booking (
	booking_number int4 NOT NULL,
	price float8 NOT NULL,
	origin varchar NOT NULL,
	destination varchar NOT NULL,
	discount varchar NULL,
	CONSTRAINT booking_pk PRIMARY KEY (booking_number)
);

CREATE TABLE public.customer (
	"name" varchar NOT NULL,
	birthday date NOT NULL,
	adress varchar NOT NULL,
	email varchar NOT NULL,
	flight_miles int4 NULL,
	CONSTRAINT customer_pk PRIMARY KEY (email)
);

CREATE TABLE public.flight (
	flight_number int4 NOT NULL,
	duration int4 NOT NULL,
	"date" date NOT NULL,
	CONSTRAINT flight_pk PRIMARY KEY (flight_number)
);

CREATE TABLE public.plane (
	"number" int4 NOT NULL,
	plane_model_number int4 NOT NULL,
	CONSTRAINT plane_pk PRIMARY KEY (number)
);

CREATE TABLE public.plane_model (
	manufracturer varchar NOT NULL,
	"number" varchar NOT NULL,
	"range" float8 NOT NULL,
	seats int4 NOT NULL,
	weight_apactiy float8 NOT NULL,
	CONSTRAINT plane_model_pk PRIMARY KEY (number)
);

CREATE TABLE public.route (
	origin varchar NOT NULL,
	destination varchar NOT NULL,
	distance int4 NOT NULL,
	CONSTRAINT route_pk PRIMARY KEY (origin, destination),
	CONSTRAINT route_abbreviation FOREIGN KEY (origin) REFERENCES public.airport(abbreviation),
	CONSTRAINT route_abbreviation2 FOREIGN KEY (destination) REFERENCES public.airport(abbreviation)
);

CREATE TABLE public.seat (
	"number" int4 NOT NULL,
	"type" varchar NOT NULL,
	CONSTRAINT seat_pk PRIMARY KEY (number)
);

CREATE TABLE public.staff_member (
	"name" varchar NOT NULL,
	ssn int4 NOT NULL,
	birthday date NOT NULL,
	adress varchar NOT NULL,
	department_number int4 NOT NULL,
	CONSTRAINT staff_member_pk PRIMARY KEY (ssn)
);

CREATE TABLE public.ticket (
	ticket_number int4 NOT NULL,
	extra_food bool NOT NULL,
	"class" varchar NOT NULL,
	price float8 NOT NULL,
	"name" varchar NOT NULL,
	CONSTRAINT ticket_pk PRIMARY KEY (ticket_number)
);

