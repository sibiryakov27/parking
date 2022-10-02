INSERT INTO car_types VALUES
    (1, 'passenger car'),
    (2, 'cargo'),
    (3, 'bus'),
    (4, 'motorcycle');

INSERT INTO cars(car_number, car_type_id, car_model) VALUES
    ('A123AA111', 1, 'skoda'),
    ('B321BB222', 4, 'suzuki');

INSERT INTO parking_spaces VALUES
    (1, 39.00, 5, 2),
    (2, 29.00, 4, 0);

INSERT INTO bookings VALUES
    (1, 'A123AA111', 1, TIMESTAMP '2022-09-30 19:55:59',
    TIMESTAMP '2022-09-30 21:33:23', 55.50),
    (2, 'B321BB222', 2, TIMESTAMP '2022-10-01 21:59:34',
    TIMESTAMP '2022-10-01 23:31:54', 75.50),
    (3, 'A123AA111', 2, TIMESTAMP '2022-10-02 14:23:52',
    TIMESTAMP '2022-10-02 21:23:43', 304.24);
