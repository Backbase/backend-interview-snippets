CREATE TABLE account_type (
  id INT,
  name VARCHAR(255) NOT NULL,
  CONSTRAINT pk_account_type PRIMARY KEY (id)
);

CREATE TABLE account (
  id INT AUTO_INCREMENT,
  type_id INT NOT NULL,
  name VARCHAR(255) NOT NULL,
  closed BIT NOT NULL,
  CONSTRAINT pk_account PRIMARY KEY (id)
);
