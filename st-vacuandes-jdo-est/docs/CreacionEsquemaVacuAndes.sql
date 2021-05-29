CREATE SEQUENCE VACUANDES_SEQUENCE;

CREATE TABLE EPS
(ID VARCHAR2(255),
 REGION VARCHAR2(255) NOT NULL,
 VACUNAS NUMBER NOT NULL,
 CAPACIDADVACUNAS NUMBER NOT NULL,
 CONSTRAINT PK_EPS PRIMARY KEY (ID),
 CONSTRAINT CK_EPS_ID CHECK (ID <> ''),
 CONSTRAINT CK_EPS_REGION CHECK (REGION <> ''),
 CONSTRAINT CK_EPS_VACUNAS CHECK (VACUNAS >= 0),
 CONSTRAINT CK_EPS_CAPACIDADVACUNAS CHECK (CAPACIDADVACUNAS >= 0));
 
CREATE TABLE ROLES
(ID NUMBER(10),
 ROL VARCHAR2(255) NOT NULL,
 CONSTRAINT PK_ROLES PRIMARY KEY (ID),
 CONSTRAINT CK_ROLES_ID CHECK (ID > -1),
 CONSTRAINT CK_ROLES_ROL CHECK (ROL <> ''));
 
CREATE TABLE ESTADO
(ID NUMBER(2),
 DESCRIPCION VARCHAR2(255) NOT NULL,
 CONSTRAINT PK_ESTADO PRIMARY KEY (ID),
 CONSTRAINT CK_ESTADO_ID CHECK (ID > -1),
 CONSTRAINT CK_ESTADO_DESCRIPCION CHECK (DESCRIPCION <> ''));
 
CREATE TABLE ETAPA
(NUMERO NUMBER(2),
 DESCRIPCION VARCHAR2(255) NOT NULL,
 CONSTRAINT PK_ETAPA PRIMARY KEY (NUMERO),
 CONSTRAINT CK_ETAPA_NUMERO CHECK (NUMERO BETWEEN 0 AND 6),
 CONSTRAINT CK_ETAPA_DESCRIPCION CHECK (DESCRIPCION <> ''));
 
CREATE TABLE CONDICIONPRIORIZACION
(DESCRIPCION VARCHAR2(255),
 NUMERO_ETAPA NUMBER(2) NOT NULL,
 CONSTRAINT PK_CONDICIONPRIORIZACION PRIMARY KEY (DESCRIPCION),
 CONSTRAINT FK_CONDICIONPRIORIZACION_NUMERO_ETAPA FOREIGN KEY (NUMERO_ETAPA) REFERENCES ETAPA(NUMERO),
 CONSTRAINT CK_CONDICIONPRIORIZACION_DESCRIPCION CHECK (DESCRIPCION <> ''));
 
CREATE TABLE PUNTO
(ID VARCHAR2(255),
 REGION VARCHAR2(255) NOT NULL,
 DIRECCION VARCHAR2(255) NOT NULL,
 APLICADAS NUMBER NOT NULL,
 CAPACIDAD NUMBER NOT NULL,
 ID_EPS VARCHAR2(255),
 CAPACIDADVACUNAS NUMBER NOT NULL,
 VACUNAS NUMBER NOT NULL,
 HABILITADO VARCHAR2(1) NOT NULL,
 CONSTRAINT PK_PUNTO PRIMARY KEY (ID),
 CONSTRAINT FK_PUNTO_EPS FOREIGN KEY (ID_EPS) REFERENCES EPS(ID),
 CONSTRAINT CK_PUNTO_ID CHECK (ID <> ''),
 CONSTRAINT CK_PUNTO_REGION CHECK (REGION <> ''),
 CONSTRAINT CK_PUNTO_DIRECCION CHECK (DIRECCION <> ''),
 CONSTRAINT CK_PUNTO_APLICADAS CHECK (APLICADAS >= 0),
 CONSTRAINT CK_PUNTO_CAPACIDAD CHECK (CAPACIDAD > 0),
 CONSTRAINT CK_PUNTO_CAPACIDADVACUNAS CHECK (CAPACIDADVACUNAS >= 0),
 CONSTRAINT CK_PUNTO_VACUNAS CHECK (VACUNAS >= 0),
 CONSTRAINT CK_PUNTO_HABILITADO CHECK (HABILITADO IN ('T','F')));
 
CREATE TABLE VACUNA
(ID VARCHAR2(255),
 PRESERVACION VARCHAR2(255) NOT NULL,
 APLICADA VARCHAR2(1) NOT NULL,
 DOSIS NUMBER NOT NULL,
 TIPO VARCHAR2(255) NOT NULL,
 LLEGADA DATE,
 FECHAAPLICADA DATE,
 CONSTRAINT PK_VACUNA PRIMARY KEY (ID),
 CONSTRAINT CK_VACUNA_ID CHECK (ID <> ''),
 CONSTRAINT CK_VACUNA_PRESERVACION CHECK (PRESERVACION <> ''),
 CONSTRAINT CK_VACUNA_APLICADA CHECK (APLICADA IN ('T','F')),
 CONSTRAINT CK_VACUNA_DOSIS CHECK (DOSIS > 0),
 CONSTRAINT CK_VACUNA_TIPO CHECK (TIPO <> ''),
 CONSTRAINT CK_VACUNA_LLEGADA CHECK (LLEGADA > '31-DEC-2020')
 CONSTRAINT CK_VACUNA_FECHAAPLICADA CHECK (FECHAAPLICADA > LLEGADA));
 
CREATE TABLE ASIGNADA
(ID_EPS VARCHAR2(255),
 ID_PUNTO VARCHAR2(255),
 ID_VACUNA VARCHAR2(255),
 CONSTRAINT PK_ASIGNADA PRIMARY KEY (ID_PUNTO, ID_VACUNA),
 CONSTRAINT FK_ASIGNADA_ID_EPS FOREIGN KEY (ID_EPS) REFERENCES EPS(ID),
 CONSTRAINT FK_ASIGNADA_ID_PUNTO FOREIGN KEY (ID_PUNTO) REFERENCES PUNTO(ID),
 CONSTRAINT FK_ASIGNADA_ID_VACUNA FOREIGN KEY (ID_VACUNA) REFERENCES VACUNA(ID));

CREATE TABLE CIUDADANO
(DOCUMENTO VARCHAR2(255),
 NOMBRE VARCHAR2(255) NOT NULL,
 NACIMIENTO DATE NOT NULL,
 HABILITADO VARCHAR2(1) NOT NULL,
 ID_ESTADO NUMBER(2) NOT NULL,
 ID_EPS VARCHAR2(255) NOT NULL,
 NUMERO_ETAPA NUMBER(2) NOT NULL,
 SEXO VARCHAR2(255) NOT NULL,
 CONSTRAINT PK_CIUDADANO PRIMARY KEY (DOCUMENTO),
 CONSTRAINT FK_CIUDADANO_ID_ESTADO FOREIGN KEY (ID_ESTADO) REFERENCES ESTADO(ID),
 CONSTRAINT FK_CIUDADANO_ID_EPS FOREIGN KEY (ID_EPS) REFERENCES EPS(ID),
 CONSTRAINT FK_CIUDADANO_NUMERO_ETAPA FOREIGN KEY (NUMERO_ETAPA) REFERENCES ETAPA(NUMERO),
 CONSTRAINT CK_CIUDADANO_NACIMIENTO CHECK (NACIMIENTO > '01-JAN-1900'),
 CONSTRAINT CK_CIUDADANO_HABILITADO CHECK (HABILITADO IN ('T','F')));
 
CREATE TABLE VACUNACION
(DOCUMENTO_CIUDADANO VARCHAR2(255),
 ID_EPS VARCHAR2(255),
 ID_PUNTO VARCHAR2(255) NOT NULL,
 CONSTRAINT PK_VACUNACION PRIMARY KEY (DOCUMENTO_CIUDADANO, ID_EPS),
 CONSTRAINT FK_VACUNACION_DOCUMENTO_CIUDADANO FOREIGN KEY (DOCUMENTO_CIUDADANO) REFERENCES CIUDADANO(DOCUMENTO),
 CONSTRAINT FK_VACUNACION_ID_EPS FOREIGN KEY (ID_EPS) REFERENCES EPS(ID),
 CONSTRAINT FK_VACUNACION_ID_PUNTO FOREIGN KEY (ID_PUNTO) REFERENCES PUNTO(ID));

CREATE TABLE PRIORIZACION
(DOCUMENTO_CIUDADANO VARCHAR2(255),
 DESCRIPCION_CONDPRIOR VARCHAR2(255),
 CONSTRAINT PK_PRIORIZACION PRIMARY KEY (DOCUMENTO_CIUDADANO, DESCRIPCION_CONDPRIOR),
 CONSTRAINT FK_PRIORIZACION_DOCUMENTO_CIUDADANO FOREIGN KEY (DOCUMENTO_CIUDADANO) REFERENCES CIUDADANO(DOCUMENTO),
 CONSTRAINT FK_PRIORIZACION_DESCRIPCION_CONDPRIOR FOREIGN KEY (DESCRIPCION_CONDPRIOR) REFERENCES CONDICIONPRIORIZACION(DESCRIPCION));
 
CREATE TABLE INFOUSUARIO
(LOGIN VARCHAR2(255),
 CLAVE VARCHAR2(255),
 TRABAJO VARCHAR2(255),
 ID_ROLES NUMBER(10) NOT NULL,
 ID_PUNTO VARCHAR2(255) NOT NULL,
 CONSTRAINT PK_INFOUSUARIO PRIMARY KEY (LOGIN),
 CONSTRAINT FK_INFOUSUSARIO_ID_ROLES FOREIGN KEY (ID_ROLES) REFERENCES ROLES(ID),
 CONSTRAINT FK_INFOUSUSARIO_ID_PUNTO FOREIGN KEY (ID_PUNTO) REFERENCES PUNTO(ID));
 
CREATE TABLE USUARIO
(DOCUMENTO_CIUDADANO VARCHAR2(255),
 LOGIN_INFOUSUARIO VARCHAR2(255),
 CONSTRAINT PK_USUARIO PRIMARY KEY (DOCUMENTO_CIUDADANO),
 CONSTRAINT FK_USUARIO_DOCUMENTO FOREIGN KEY (DOCUMENTO_CIUDADANO) REFERENCES CIUDADANO(DOCUMENTO),
 CONSTRAINT FK_USUARIO_LOGIN_INFOUSUARIO FOREIGN KEY (LOGIN_INFOUSUARIO) REFERENCES INFOUSUARIO(LOGIN),
 CONSTRAINT CK_USUARIO_LOGIN_INFOUSUARIO CHECK (LOGIN_INFOUSUARIO <> ''));

CREATE TABLE CITA
(FECHAHORA DATE,
 FINALIZADA VARCHAR2(1) NOT NULL,
 DOCUMENTO_CIUDADANO VARCHAR2(255) NOT NULL,
 ID_PUNTO VARCHAR2(255),
 CONSTRAINT PK_CITA PRIMARY KEY (FECHAHORA, DOCUMENTO_CIUDADANO),
 CONSTRAINT FK_CITA_DOCUMENTO_CIUDADANO FOREIGN KEY (DOCUMENTO_CIUDADANO) REFERENCES CIUDADANO(DOCUMENTO),
 CONSTRAINT FK_CITA_ID_PUNTO FOREIGN KEY (ID_PUNTO) REFERENCES PUNTO(ID),
 CONSTRAINT CK_CITA_FECHAHORA CHECK (FECHAHORA > '31-DEC-2020'),
 CONSTRAINT CK_CITA_FINALIZADA CHECK (FINALIZADA IN ('T','F', 'C')));
 
CREATE TABLE ATENCION
(DESCRIPCION_CONDPRIOR VARCHAR2(255),
 ID_PUNTO VARCHAR2(255),
 CONSTRAINT PK_ATENCION PRIMARY KEY (DESCRIPCION_CONDPRIOR, ID_PUNTO),
 CONSTRAINT FK_ATENCION_DESCRIPCION_CONDPRIOR FOREIGN KEY (DESCRIPCION_CONDPRIOR) REFERENCES CONDICIONPRIORIZACION(DESCRIPCION),
 CONSTRAINT FK_ATENCION_ID_PUNTO FOREIGN KEY (ID_PUNTO) REFERENCES PUNTO(ID));
 
CREATE TABLE VACUANDES
(NUMERO_ETAPA NUMBER(2),
 CONSTRAINT PK_VACUANDES PRIMARY KEY (NUMERO_ETAPA),
 CONSTRAINT FK_NUMERO_ETAPA FOREIGN KEY (NUMERO_ETAPA) REFERENCES ETAPA(NUMERO));
 
COMMIT;