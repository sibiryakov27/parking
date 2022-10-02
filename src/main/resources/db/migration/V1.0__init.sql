CREATE TABLE car_types (
    car_type_id INTEGER PRIMARY KEY,
    car_type VARCHAR(64)
);

CREATE TABLE cars (
    car_number VARCHAR(9) PRIMARY KEY,
    car_type_id INTEGER,
    registration_certificate VARCHAR(16),
    car_model VARCHAR(32),
    FOREIGN KEY (car_type_id) REFERENCES car_types(car_type_id)
);

CREATE TABLE parking_spaces (
    parking_space_id INTEGER PRIMARY KEY,
    price_per_hour DECIMAL(5,2),
    places_in_total INTEGER,
    places_for_disabled INTEGER
);

CREATE TABLE bookings (
    booking_id INTEGER PRIMARY KEY,
    car_number VARCHAR(9),
    parking_space_id INTEGER,
    start_time TIMESTAMP,
    end_time TIMESTAMP,
    total_price DECIMAL(10,2),
    FOREIGN KEY (car_number) REFERENCES cars(car_number),
    FOREIGN KEY (parking_space_id) REFERENCES parking_spaces(parking_space_id)
);
