CREATE TABLE IF NOT EXISTS books (
    isbn VARCHAR(20) PRIMARY KEY,
    title VARCHAR(120) NOT NULL,
    author_name VARCHAR(120) NOT NULL,
    editorial_name VARCHAR(120) NOT NULL
);