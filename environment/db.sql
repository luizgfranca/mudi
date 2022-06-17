/*DROP TABLE request;*/
/*DROP TABLE users;*/


CREATE TABLE users (
  username VARCHAR(255) PRIMARY KEY,
  password VARCHAR(255),
  enabled BOOLEAN
);

CREATE TABLE request (
	id INTEGER PRIMARY KEY,
    name VARCHAR(255),
    value DECIMAL,
  	status VARCHAR(50),
    deliverDate TIMESTAMP,
    productUrl VARCHAR(255),
    imgUrl VARCHAR(255),
    description VARCHAR(255),
  	username VARCHAR(255) REFERENCES users(username)
);







