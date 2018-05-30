CREATE TABLE PERSONAS (
	ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	LOGIN VARCHAR(24) NOT NULL,
	PASSWORD VARCHAR(24) NOT NULL,
	NOMBRE VARCHAR(26),
	APELLIDO VARCHAR(26),
	EDAD INTEGER NOT NULL,
	ALTURA DOUBLE
)