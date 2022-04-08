create table phone_book(
                           id serial PRIMARY KEY,
                           name varchar NOT NULL,
                           number varchar NOT NULL
);

INSERT INTO phone_book values (DEFAULT,'Alex', '+79638521456'),
                              (DEFAULT,'Pavel', '+79638521123'),
                              (DEFAULT,'Emiliya', '+79638521321');