-- 1. Create the cats table
CREATE TABLE IF NOT EXISTS cats (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    breed VARCHAR(100) NOT NULL,
    age INTEGER NOT NULL,
    url VARCHAR(255) DEFAULT NULL
);

-- 2. Insert seed cats
INSERT INTO cats (name, breed, age, url)
VALUES 
    ('Whiskers', 'Siamese', 2, 'https://upload.wikimedia.org/wikipedia/commons/2/25/Siam_lilacpoint.jpg'),
    ('Mittens', 'Maine Coon', 4, 'https://sagetap-static.s3.us-east-1.amazonaws.com/miles.jpg'),
    ('Ghost', 'British Shorthair', 3, 'https://sagetap-static.s3.us-east-1.amazonaws.com/ghost.png');
