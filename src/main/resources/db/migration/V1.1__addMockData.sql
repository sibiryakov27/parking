INSERT INTO cars(car_id, car_number, car_type, car_model) VALUES
    (1, 'A123AA111', 'PASSENGER', 'skoda'),
    (2, 'B321BB222', 'MOTORCYCLE', 'suzuki');

INSERT INTO parking_spaces VALUES
    (1, FALSE),
    (2, TRUE),
    (3, TRUE);

INSERT INTO bookings VALUES
    (1, 1, 1, TIMESTAMP '2022-09-20 19:00:00',
    TIMESTAMP '2022-09-30 21:00:00', 550.50),
    (2, 2, 2, TIMESTAMP '2022-09-22 21:59:34',
    TIMESTAMP '2022-10-01 23:00:00', 250.50),
    (3, 1, 2, TIMESTAMP '2022-10-02 10:00:00',
    TIMESTAMP '2022-10-20 00:00:00', 1000.00),
    (4, 2, 2, TIMESTAMP '2022-10-02 10:00:00',
    TIMESTAMP '2022-10-20 00:00:00', 1000.00);
