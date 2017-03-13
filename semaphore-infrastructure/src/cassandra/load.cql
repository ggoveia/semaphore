CREATE KEYSPACE SemaphoreKeySpace WITH REPLICATION = {'class':'SimpleStrategy', 'replication_factor':1};

USE SemaphoreKeySpace;

CREATE TABLE Semaphore (
	id UUID PRIMARY KEY,
	activedLight TEXT
);