
DROP TABLE IF EXISTS Users;
CREATE TABLE Users (
    userId  INTEGER       NOT NULL
                          PRIMARY KEY AUTOINCREMENT
                          UNIQUE,
                          
    name    VARCHAR (50)  NOT NULL,
						UNIQUE,
						
    address VARCHAR (255) NULL
);
DROP TABLE IF EXISTS Accounts;
CREATE TABLE Accounts (
    accountId INTEGER      PRIMARY KEY AUTOINCREMENT
                           UNIQUE
                           NOT NULL,
                           
    userId    INTEGER (10) REFERENCES Users (userId) 
                           NOT NULL,
    balance   INTEGER (15) NOT NULL,
    currency  VARCHAR (10) NOT NULL
);
DROP TABLE IF EXISTS Transactions;
CREATE TABLE Transactions (
    transactionId INTEGER      PRIMARY KEY AUTOINCREMENT
                               UNIQUE
                               NOT NULL,
    amount        INTEGER (15) NOT NULL,
    accountId     INTEGER (10) REFERENCES Accounts (accountId) 
);


