# topic 12

# 10 statements for insertion.

INSERT INTO `bookingservice`.`User` (`user_id`, `first_name`, `last_name`, `password`, `email`) 
VALUES (1, 'Cole', 'Warner', 'password', '19cowarner@gmail.com');

INSERT INTO `bookingservice`.`Airlines` (`airline_id`, `airline_name`) 
VALUES (1, 'SouthWest');

INSERT INTO `bookingservice`.`Airports` (`airport_id`, `airport_name`, `airport_city`, `airport_code`, `airport_country`) 
VALUES (1, 'Los Angeles International Airport', 'Los Angeles', 'LAX', 'USA');

INSERT INTO `bookingservice`.`Airports` (`airport_id`, `airport_name`, `airport_city`, `airport_code`, `airport_country`)
VALUES (2, 'San Francisco International Airport', 'San Francisco', 'SFO', 'USA');

INSERT INTO `bookingservice`.`Flights` (`flight_id`, `airline_id`, `departure_airport_id`, `arrival_airport_id`, `departure_time`, `flight_number`, `arrival_time`) 
VALUES (1, 1, 1, 2, '2024-10-10 08:00:00', '4711', '2024-10-10 12:00:00');

INSERT INTO `bookingservice`.`Bookings` (`booking_id`, `user_id`, `flight_id`, `booking_date`, `checked_in`) 
VALUES (1, 1, 1, '2024-09-30 10:00:00', 0);

INSERT INTO `bookingservice`.`Passengers` (`passenger_id`, `booking_id`, `user_id`) 
VALUES (1, 1, 1);

INSERT INTO `bookingservice`.`Seats` (`seat_id`, `flight_id`, `seat_number`, `class`, `available`) 
VALUES (1, 1, '12A', 'economy', 1);

INSERT INTO `bookingservice`.`PassengerSeats` (`passenger_seat_id`, `passenger_id`, `seat_id`) 
VALUES (1, 1, 1);

INSERT INTO `bookingservice`.`Payments` (`payment_id`, `booking_id`, `amount`, `payment_date`) 
VALUES (1, 1, 200.00, '2024-09-30 12:00:00');

INSERT INTO `bookingservice`.`FlightPricings` (`flight_pricing_id`, `flight_id`, `price`, `class`) 
VALUES (1, 1, 300.00, 'economy');

INSERT INTO `bookingservice`.`FlightPricings` (`flight_pricing_id`, `flight_id`, `price`, `class`) 
VALUES (1, 1, 450.00, 'first');

INSERT INTO `bookingservice`.`FlightPricings` (`flight_pricing_id`, `flight_id`, `price`, `class`) 
VALUES (1, 1, 401.00, 'business');

INSERT INTO `bookingservice`.`BoardingGroup` (`boarding_group_id`, `flight_id`, `group`, `position`)
VALUES (1, 1, 'B', 30);

INSERT INTO `bookingservice`.`Luggage` (`luggage_id`, `passenger_id`, `luggage_type`)
VALUES (1, 1, 'carry-on');

# 10 statements for updating.

UPDATE `bookingservice`.`User`
SET `email` = 'cole24777@gmail.com'
WHERE `user_id` = 1;

UPDATE `bookingservice`.`User`
SET `password` = 'newpassword'
WHERE `user_id` = 1;

UPDATE `bookingservice`.`Flights`
SET `departure_time` = '2024-10-10 09:00:00'
WHERE `flight_id` = 1;

UPDATE `bookingservice`.`Flights`
SET `arrival_time` = '2024-10-10 012:30:00'
WHERE `flight_id` = 1;

UPDATE `bookingservice`.`Bookings`
SET `checked_in` = 1
WHERE `booking_id` = 1;

UPDATE `bookingservice`.`Seats`
SET `available` = 0
WHERE `seat_id` = 1;

UPDATE `bookingservice`.`Payments`
SET `amount` = 250.00
WHERE `payment_id` = 1;

UPDATE `bookingservice`.`FlightPricings`
SET `price` = 350.00
WHERE `flight_id` = 1 AND `class` = 'economy';

UPDATE `bookingservice`.`BoardingGroup`
SET `position` = 25, `group` = 'A'
WHERE `boarding_group_id` = 1;

UPDATE `bookingservice`.`Luggage`
SET `luggage_type` = 'checked'
WHERE `luggage_id` = 1;

# 10 statements for deletions.

DELETE FROM `bookingservice`.`User`
WHERE `user_id` = 1;

DELETE FROM `bookingservice`.`Airlines`
WHERE `airline_id` = 1;

DELETE FROM `bookingservice`.`Airports`
WHERE `airport_id` = 1;

DELETE FROM `bookingservice`.`Airports`
WHERE `airport_id` = 2;

DELETE FROM `bookingservice`.`Flights`
WHERE `flight_arrival_time` < '2024-10-11 12:00:00';

DELETE FROM `bookingservice`.`Bookings`
WHERE `flight_id` = 1;

DELETE FROM `bookingservice`.`Passengers`
WHERE `passenger_id` = 1;

DELETE FROM `bookingservice`.`Seats`
WHERE `seat_id` = 1;

DELETE FROM `bookingservice`.`PassengerSeats`
WHERE `flight_id` = 1;

DELETE FROM `bookingservice`.`FlightPricings`
WHERE `flight_pricing_id` = 1;

# 5 alter table.

ALTER TABLE `bookingservice`.`User`
ADD COLUMN `phone_number` VARCHAR(45) NULL AFTER `email`;

ALTER TABLE `bookingservice`.`User`
MODIFY COLUMN 'phone_number' VARCHAR(45) NOT NULL;

ALTER TABLE `bookingservice`.`User`
DROP COLUMN 'phone_number';

ALTER TABLE `bookingservice`.`bookingservice`.`Airports`
ADD COLUMN `airport_state` VARCHAR(45) NULL AFTER `airport_city`;

ALTER TABLE `bookingservice`.`bookingservice`.`Airports`
MODIFY COLUMN 'airport_state' VARCHAR(45) NOT NULL;

ALTER TABLE `bookingservice`.`bookingservice`.`Airports`
DROP COLUMN 'airport_state';

# 1 big statement to join all tables in the database.

SELECT 
    U.user_id,
    U.first_name,
    U.last_name,
    U.email,
    B.booking_id,
    B.booking_date,
    B.checked_in,
    F.flight_id,
    F.flight_number,
    F.departure_time,
    F.arrival_time,
    A.airline_name,
    AP1.airport_name AS departure_airport,
    AP2.airport_name AS arrival_airport,
    S.seat_number,
    S.class AS seat_class,
    P.passenger_id,
    L.luggage_type,
    PAY.amount AS payment_amount,
    PAY.payment_date
FROM 
    bookingservice.User U
JOIN 
    bookingservice.Bookings B ON U.user_id = B.user_id
JOIN 
    bookingservice.Flights F ON B.flight_id = F.flight_id
JOIN 
    bookingservice.Airlines A ON F.airline_id = A.airline_id
JOIN 
    bookingservice.Airports AP1 ON F.departure_airport_id = AP1.airport_id
JOIN 
    bookingservice.Airports AP2 ON F.arrival_airport_id = AP2.airport_id
JOIN 
    bookingservice.Passengers P ON B.booking_id = P.booking_id
JOIN 
    bookingservice.PassengerSeats PS ON P.passenger_id = PS.passenger_id
JOIN 
    bookingservice.Seats S ON PS.seat_id = S.seat_id
JOIN 
    bookingservice.Payments PAY ON B.booking_id = PAY.booking_id
LEFT JOIN 
    bookingservice.Luggage L ON P.passenger_id = L.passenger_id 
ORDER BY 
    B.booking_date, U.user_id;

# 5 statements with left, right, inner, outer joins.

-- Left Join
SELECT 
    U.user_id,
    U.first_name,
    U.last_name,
    B.booking_id,
    B.booking_date
FROM 
    bookingservice.User U
LEFT JOIN 
    bookingservice.Bookings B ON U.user_id = B.user_id;

-- Right Join
SELECT 
    B.booking_id,
    U.first_name,
    U.last_name
FROM 
    bookingservice.Bookings B
RIGHT JOIN 
    bookingservice.User U ON B.user_id = U.user_id;

-- Inner Join

SELECT 
    P.passenger_id,
    B.booking_id,
    F.flight_number
FROM 
    bookingservice.Passengers P
INNER JOIN 
    bookingservice.Bookings B ON P.booking_id = B.booking_id
INNER JOIN 
    bookingservice.Flights F ON B.flight_id = F.flight_id;

-- Outer Join

SELECT 
    U.user_id,
    U.first_name,
    B.booking_id,
    B.booking_date
FROM 
    bookingservice.User U
LEFT JOIN 
    bookingservice.Bookings B ON U.user_id = B.user_id

UNION

SELECT 
    U.user_id,
    U.first_name,
    B.booking_id,
    B.booking_date
FROM 
    bookingservice.User U
RIGHT JOIN 
    bookingservice.Bookings B ON U.user_id = B.user_id;

-- Cross Join

SELECT 
    U.first_name,
    F.flight_number
FROM 
    bookingservice.User U
CROSS JOIN 
    bookingservice.Flights F;

# 7 statements with aggregate functions and group by and without having.

-- Count total users
SELECT 
    COUNT(*) AS total_users
FROM 
    bookingservice.User;

-- Count total bookings
SELECT 
    U.user_id,
    U.first_name,
    COUNT(B.booking_id) AS total_bookings
FROM 
    bookingservice.User U
LEFT JOIN 
    bookingservice.Bookings B ON U.user_id = B.user_id
GROUP BY 
    U.user_id, U.first_name;

-- find average price of flight seats
SELECT 
    class,
    AVG(price) AS average_price
FROM 
    bookingservice.FlightPricings
GROUP BY 
    class;

-- find total number of flights per airline
SELECT 
    A.airline_name,
    COUNT(F.flight_id) AS total_flights
FROM 
    bookingservice.Airlines A
LEFT JOIN 
    bookingservice.Flights F ON A.airline_id = F.airline_id
GROUP BY 
    A.airline_id, A.airline_name;

-- find total number of luggage per type
SELECT 
    luggage_type,
    COUNT(*) AS total_luggage
FROM 
    bookingservice.Luggage
GROUP BY 
    luggage_type;

-- find max and min available seats per class
SELECT 
    class,
    MAX(available) AS max_available,
    MIN(available) AS min_available
FROM 
    bookingservice.Seats
GROUP BY 
    class;

# 7 statements with aggregate functions and group by and with having.

-- users with more than 1 booking
SELECT 
    U.user_id,
    U.first_name,
    COUNT(B.booking_id) AS total_bookings
FROM 
    bookingservice.User U
LEFT JOIN 
    bookingservice.Bookings B ON U.user_id = B.user_id
GROUP BY 
    U.user_id, U.first_name
HAVING 
    COUNT(B.booking_id) > 1;

-- flights with more than 100 passengers
SELECT 
    F.flight_id,
    F.flight_number,
    COUNT(P.passenger_id) AS total_passengers
FROM
    bookingservice.Flights F
LEFT JOIN
    bookingservice.Bookings B ON F.flight_id = B.flight_id
LEFT JOIN
    bookingservice.Passengers P ON B.booking_id = P.booking_id
GROUP BY
    F.flight_id, F.flight_number
HAVING
    COUNT(P.passenger_id) > 100;

-- avg price of flight seats greater than 300
SELECT 
    class,
    AVG(price) AS average_price
FROM 
    bookingservice.FlightPricings
GROUP BY 
    class
HAVING 
    AVG(price) > 300;

-- users with a google email

SELECT 
    U.user_id,
    U.first_name,
    COUNT(B.booking_id) AS total_bookings
FROM 
    bookingservice.User U
LEFT JOIN 
    bookingservice.Bookings B ON U.user_id = B.user_id
WHERE 
    U.email LIKE '%@gmail.com'
GROUP BY 
    U.user_id, U.first_name
HAVING 
    COUNT(B.booking_id) > 0;

-- total payments greater than 500
SELECT 
    U.user_id,
    U.first_name,
    SUM(P.amount) AS total_payments
FROM 
    bookingservice.User U
LEFT JOIN 
    bookingservice.Bookings B ON U.user_id = B.user_id
LEFT JOIN 
    bookingservice.Payments P ON B.booking_id = P.booking_id
GROUP BY 
    U.user_id, U.first_name
HAVING 
    SUM(P.amount) > 500;

# Questions

# 1. How are CRUD operations represented in SQL?
CRUD operations are represented in SQL as follows:
- Create: INSERT INTO table_name (column1, column2, column3, ...) VALUES (value1, value2, value3, ...);
- Read: SELECT column1, column2, ... FROM table_name WHERE condition;
- Update: UPDATE table_name SET column1 = value1, column2 = value2, ... WHERE condition;
- Delete: DELETE FROM table_name WHERE condition;
# 2. What are the differences between 6 Joins?
- Inner Join: Returns rows when there is a match in both tables.
- Left Join: Returns all rows from the left table, and the matched rows from the right table.
- Right Join: Returns all rows from the right table, and the matched rows from the left table.
- Full Join: Returns rows when there is a match in one of the tables.
- Cross Join: Returns the Cartesian product of the two tables.
- Self Join: Joins a table with itself.
# 3. When Left and Right joins will return the same result set and when result set will be diffrerent?
Left and Right joins will return the same result set when the tables are symmetrical, and the join condition is the same. The result set will be different when the tables are not symmetrical, and the join condition is different.
# 4. What is agregate functions?
Aggregate functions are functions that operate on a set of values and return a single value. Examples of aggregate functions include COUNT, SUM, AVG, MIN, and MAX.
# 5. What is Group By?
The GROUP BY clause is used to group rows that have the same values into summary rows. It is often used with aggregate functions to perform calculations on grouped rows.
# 6. What is Having?
The HAVING clause is used to filter groups of rows that have the same values after the GROUP BY clause has been applied. It is often used with aggregate functions to filter groups based on a condition.
# 7. What is Union?
The UNION operator is used to combine the result sets of two or more SELECT statements into a single result set. It removes duplicate rows by default.

