CREATE TABLE cars (
    car_id INTEGER PRIMARY KEY auto_increment,
    car_number VARCHAR(9) NOT NULL UNIQUE,
    car_type VARCHAR(32),
    registration_certificate VARCHAR(16),
    car_model VARCHAR(32)
);

CREATE TABLE parking_spaces (
    parking_space_id INTEGER PRIMARY KEY,
    occupied BOOLEAN DEFAULT 0
);

CREATE TABLE bookings (
    booking_id INTEGER PRIMARY KEY auto_increment,
    car_id INTEGER,
    parking_space_id INTEGER,
    start_time TIMESTAMP,
    end_time TIMESTAMP,
    total_price DECIMAL(10,2),
    FOREIGN KEY (car_id) REFERENCES cars(car_id),
    FOREIGN KEY (parking_space_id) REFERENCES parking_spaces(parking_space_id)
);
