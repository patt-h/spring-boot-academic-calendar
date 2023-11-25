INSERT INTO `users`
VALUES
('admin', '{noop}admin', 1),
('pathuc', '{noop}test123', 1);

INSERT INTO `authorities`
VALUES
('admin', 'ROLE_ADMIN'),
('pathuc', 'ROLE_EMPLOYEE');
