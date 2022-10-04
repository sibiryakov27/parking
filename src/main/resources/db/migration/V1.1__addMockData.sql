INSERT INTO cars(car_number, car_type, car_model) VALUES
    ('A123AA111', 'PASSENGER', 'skoda'),
    ('B321BB222', 'MOTORCYCLE', 'suzuki');

INSERT INTO parking_spaces VALUES
    (1, FALSE),
    (2, TRUE),
    (3, TRUE);

INSERT INTO bookings(car_id, parking_space_id, start_time, end_time, total_price) VALUES
    (1, 1, TIMESTAMP '2022-09-20 19:00:00',
    TIMESTAMP '2022-09-30 21:00:00', 550.50),
    (2, 2, TIMESTAMP '2022-09-22 21:59:34',
    TIMESTAMP '2022-10-01 23:00:00', 250.50),
    (1, 2, TIMESTAMP '2022-10-02 10:00:00',
    TIMESTAMP '2022-10-20 00:00:00', 1000.00),
    (2, 2, TIMESTAMP '2022-10-02 10:00:00',
    TIMESTAMP '2022-10-20 00:00:00', 1000.00);
