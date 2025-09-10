CREATE USER EcommerceApplicationDBUser;

CREATE DATABASE productservicesept25db;
GRANT ALL privileges ON productservicesept25db.* to 'EcommerceApplicationDBUser';
FLUSH PRIVILEGES;


CREATE DATABASE userservicesept25db;
GRANT ALL privileges ON userservicesept25db.* to 'EcommerceApplicationDBUser';
FLUSH PRIVILEGES;