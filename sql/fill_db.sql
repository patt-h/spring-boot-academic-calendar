INSERT INTO `users`
VALUES
('admin', '{noop}admin', 1),
('pathuc', '{noop}test123', 1),
('kampod', '{noop}test123', 1);

INSERT INTO `authorities`
VALUES
('admin', 'ROLE_ADMIN'),
('pathuc', 'ROLE_EMPLOYEE'),
('kampod', 'ROLE_EMPLOYEE');

INSERT INTO `names`
VALUES
('admin', 'admin', 'admin'),
('pathuc', 'Patryk', 'Huchla'),
('kampod', 'Kamil', 'Podobinski');