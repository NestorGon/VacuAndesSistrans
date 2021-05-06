 INSERT INTO EPS (ID, REGION, VACUNAS)
 VALUES('12','TOLIMA',255);
 
 INSERT INTO EPS (ID, REGION, VACUNAS)
 VALUES('13','BOGOTA',463);
 
 INSERT INTO EPS (ID, REGION, VACUNAS)
 VALUES('14','ANTIOQUIA',637);
 
 INSERT INTO EPS (ID, REGION, VACUNAS)
 VALUES('15','ATLANTICO',354);

 INSERT INTO ROLES (ID, ROL) 
 VALUES (1, 'ADMINISTRADOR DEL PLAN DE VACUNACION');
 
INSERT INTO ROLES (ID, ROL) 
 VALUES(2,'ADMINISTRADOR DE OFICINA DE EPS REGIONAL');
 
 INSERT INTO ROLES (ID, ROL) 
 VALUES(3, 'ADMINISTRADOR DE PUNTO DE VACUNACION');
 
 INSERT INTO ROLES (ID, ROL) 
 VALUES(4, 'OPERADOR DE PUNTO DE VACUNACION');
 
 INSERT INTO ROLES (ID, ROL) 
 VALUES(5, 'CIUDADANO');
 
 INSERT INTO ROLES (ID, ROL) 
 VALUES(6, 'TALENTO HUMANO');

 INSERT INTO ESTADO (ID, DESCRIPCION)		
 VALUES(1, 'REGISTRADO');
 
 INSERT INTO ESTADO (ID, DESCRIPCION)
 VALUES(2, 'CITADO');
 
 INSERT INTO ESTADO (ID, DESCRIPCION)
 VALUES(3, 'VACUNADO DOSIS 1');
 
 INSERT INTO ESTADO (ID, DESCRIPCION)
 VALUES(4, 'VACUNADO DOSIS 2');

 INSERT INTO ETAPA (NUMERO, DESCRIPCION)
 VALUES(1, 'PERSONAS DE 80 AÑOS Y MAS');
 
 INSERT INTO ETAPA (NUMERO, DESCRIPCION)
 VALUES(2, 'PERSONAS ENTRE 60 Y 79 AÑOS');
 
 INSERT INTO ETAPA (NUMERO, DESCRIPCION)
 VALUES(3, 'PERSONAS ENTRE 16 Y 59 AÑOS CON CONDICIONES ESPECIDICADAS');
 
 INSERT INTO ETAPA (NUMERO, DESCRIPCION)
 VALUES(4, 'POBLACION PRIVADA DE LIBERTAD');
 
 INSERT INTO ETAPA (NUMERO, DESCRIPCION)
 VALUES(5, 'PERSONAS DE 16 AÑOS EN ADELANTE NO PERTENECIENTES A ETAPAS ANTERIORES');

INSERT INTO CONDICIONPRIORIZACION (DESCRIPCION, NUMERO_ETAPA)
 VALUES('80 AÑOS O MAS', 1);
 
INSERT INTO CONDICIONPRIORIZACION (DESCRIPCION, NUMERO_ETAPA)
 VALUES('60 A 79 AÑOS', 2);
 
INSERT INTO CONDICIONPRIORIZACION (DESCRIPCION, NUMERO_ETAPA)
 VALUES('ENFERMEDADES HIPERTENSIVAS', 3);
 
INSERT INTO CONDICIONPRIORIZACION (DESCRIPCION, NUMERO_ETAPA)
 VALUES('DIABETES', 3);
 
INSERT INTO CONDICIONPRIORIZACION (DESCRIPCION, NUMERO_ETAPA)
 VALUES('INSUFICIENCIA RENAL', 3);
 
INSERT INTO CONDICIONPRIORIZACION (DESCRIPCION, NUMERO_ETAPA)
 VALUES('VIH', 3);
 
INSERT INTO CONDICIONPRIORIZACION (DESCRIPCION, NUMERO_ETAPA)
 VALUES('CANCER', 3);
 
INSERT INTO CONDICIONPRIORIZACION (DESCRIPCION, NUMERO_ETAPA)
 VALUES('ASMA', 3);
 
INSERT INTO CONDICIONPRIORIZACION (DESCRIPCION, NUMERO_ETAPA)
 VALUES('PRIVACION DE LIBERTAD', 4);
 
INSERT INTO CONDICIONPRIORIZACION (DESCRIPCION, NUMERO_ETAPA)
 VALUES('16 AÑOS O MAS', 5);

 INSERT INTO PUNTO(ID, REGION, DIRECCION, APLICADAS, CAPACIDAD, ID_EPS)
 VALUES ('1', 'BOGOTA', 'CARRERA 15 #63-45', 145, 176, '13');
 
 INSERT INTO PUNTO(ID, REGION, DIRECCION, APLICADAS, CAPACIDAD, ID_EPS)
 VALUES('2', 'BOGOTA', 'CALLE 53 #45-98', 267, 300, '13');
 
 INSERT INTO PUNTO(ID, REGION, DIRECCION, APLICADAS, CAPACIDAD, ID_EPS)
 VALUES('3', 'BOGOTA', 'CALLE 1 #13-3', 232, 783, '13');
 
 INSERT INTO PUNTO(ID, REGION, DIRECCION, APLICADAS, CAPACIDAD, ID_EPS)
 VALUES('4', 'BOGOTA', 'CARRERA 13 # 123-10', 354, 784, '13');
 
 INSERT INTO PUNTO(ID, REGION, DIRECCION, APLICADAS, CAPACIDAD, ID_EPS)
 VALUES('5', 'BOGOTA', 'CARRERA 11 #53-13', 657, 987, '13');
 
 INSERT INTO PUNTO(ID, REGION, DIRECCION, APLICADAS, CAPACIDAD, ID_EPS)
 VALUES('6', 'BOGOTA', 'CALLE 45 #23-24', 987,993, '13');
 
 INSERT INTO PUNTO(ID, REGION, DIRECCION, APLICADAS, CAPACIDAD, ID_EPS)
 VALUES('7', 'BOGOTA', 'CALLE 158#52-63', 767, 847, '13');
 
 INSERT INTO PUNTO(ID, REGION, DIRECCION, APLICADAS, CAPACIDAD, ID_EPS)
 VALUES('8', 'TUNJA', 'CARRERA 23 #43-55', 735, 766, '12');
 
 INSERT INTO PUNTO(ID, REGION, DIRECCION, APLICADAS, CAPACIDAD, ID_EPS)
 VALUES('9', 'TUNJA', 'CALLE 67 #13-25', 67, 122, '12');
 
 INSERT INTO PUNTO(ID, REGION, DIRECCION, APLICADAS, CAPACIDAD, ID_EPS)
 VALUES('10', 'TUNJA', 'CARRERA 28 #25-55', 125, 254, '12');
 
 INSERT INTO PUNTO(ID, REGION, DIRECCION, APLICADAS, CAPACIDAD, ID_EPS)
 VALUES('11', 'TUNJA', 'CALLE 87 #45-98', 375, 766, '12');
 
 INSERT INTO PUNTO(ID, REGION, DIRECCION, APLICADAS, CAPACIDAD, ID_EPS)
 VALUES('12', 'TUNJA', 'CARRERA 1 #12-67', 17, 100, '12');
 
 INSERT INTO PUNTO(ID, REGION, DIRECCION, APLICADAS, CAPACIDAD, ID_EPS)
 VALUES('13', 'TUNJA', 'CALLE 32 #19-43', 873, 900, '12');
 
 INSERT INTO PUNTO(ID, REGION, DIRECCION, APLICADAS, CAPACIDAD, ID_EPS)
 VALUES('14', 'TUNJA', 'CARRERA 37 #56-49', 67, 100, '12');
 
 INSERT INTO PUNTO(ID, REGION, DIRECCION, APLICADAS, CAPACIDAD, ID_EPS)
 VALUES('15', 'ANTIOQUIA', 'CARRERA 55 #57-79', 748, 800, '14');
 
 INSERT INTO PUNTO(ID, REGION, DIRECCION, APLICADAS, CAPACIDAD, ID_EPS)
 VALUES('16', 'ANTIOQUIA', 'CALLE 37 #53-29', 687, 700, '14');
 
 INSERT INTO PUNTO(ID, REGION, DIRECCION, APLICADAS, CAPACIDAD, ID_EPS)
 VALUES('17', 'ANTIOQUIA', 'DIAGONAL 27 #46-95', 123, 140, '14');
 
 INSERT INTO PUNTO(ID, REGION, DIRECCION, APLICADAS, CAPACIDAD, ID_EPS)
 VALUES('18', 'ANTIOQUIA', 'CARRERA 64 #73-89', 54, 100, '14');
 
  INSERT INTO PUNTO(ID, REGION, DIRECCION, APLICADAS, CAPACIDAD, ID_EPS)
 VALUES('19', 'ANTIOQUIA', 'CALLE 58 #47-9', 732, 837, '14');
 
  INSERT INTO PUNTO(ID, REGION, DIRECCION, APLICADAS, CAPACIDAD, ID_EPS)
 VALUES('20', 'ANTIOQUIA', 'CARRERA 2 #3-49', 27, 100, '14');
 
 INSERT INTO PUNTO(ID, REGION, DIRECCION, APLICADAS, CAPACIDAD, ID_EPS)
 VALUES('21', 'ANTIOQUIA', 'CALLE 24 #46-38', 876, 1032, '14');
 
 INSERT INTO PUNTO(ID, REGION, DIRECCION, APLICADAS, CAPACIDAD, ID_EPS)
 VALUES('22', 'ATLANTICO', 'CARRERA 23 #54-45', 746, 984, '15');
 
 INSERT INTO PUNTO(ID, REGION, DIRECCION, APLICADAS, CAPACIDAD, ID_EPS)
 VALUES('23', 'ATLANTICO', 'DIAGONAL 74 #83-5', 132, 284, '15');
 
 INSERT INTO PUNTO(ID, REGION, DIRECCION, APLICADAS, CAPACIDAD, ID_EPS)
 VALUES('24', 'ATLANTICO', 'CALLE 23 #14-45', 45, 230, '15');
 
 INSERT INTO PUNTO(ID, REGION, DIRECCION, APLICADAS, CAPACIDAD, ID_EPS)
 VALUES('25', 'ATLANTICO', 'CARRERA 65 #76-28', 328, 464, '15');
 
 INSERT INTO PUNTO(ID, REGION, DIRECCION, APLICADAS, CAPACIDAD, ID_EPS)
 VALUES('26', 'ATLANTICO', 'CALLE 78 #43-23', 178, 284, '15');
 
 INSERT INTO PUNTO(ID, REGION, DIRECCION, APLICADAS, CAPACIDAD, ID_EPS)
 VALUES('27', 'ATLANTICO', 'CARRERA 12 #13-14', 678, 784, '15');
 
 INSERT INTO PUNTO(ID, REGION, DIRECCION, APLICADAS, CAPACIDAD, ID_EPS)
 VALUES('28', 'ATLANTICO', 'CALLE 23 #21-45', 126, 384, '15');

 INSERT INTO VACUNA (ID, PRESERVACION, APLICADA, DOSIS, TIPO)
 VALUES ('1', '-25°', 'F', 1, 'PFIZER');
 
 INSERT INTO VACUNA (ID, PRESERVACION, APLICADA, DOSIS, TIPO)
 VALUES('2', '-25°', 'F', 1, 'PFIZER');
 
 INSERT INTO VACUNA (ID, PRESERVACION, APLICADA, DOSIS, TIPO)
 VALUES('3', '-25°', 'T', 1, 'PFIZER');
 
 INSERT INTO VACUNA (ID, PRESERVACION, APLICADA, DOSIS, TIPO)
 VALUES('4', '-25°', 'F', 1, 'PFIZER');
 
 INSERT INTO VACUNA (ID, PRESERVACION, APLICADA, DOSIS, TIPO)
 VALUES('5', '-25°', 'F', 1, 'PFIZER');
 
 INSERT INTO VACUNA (ID, PRESERVACION, APLICADA, DOSIS, TIPO)
 VALUES('6', '-25°', 'F', 1, 'PFIZER');
 
 INSERT INTO VACUNA (ID, PRESERVACION, APLICADA, DOSIS, TIPO)
 VALUES('7', '-25°', 'T', 1, 'PFIZER');
 
 INSERT INTO VACUNA (ID, PRESERVACION, APLICADA, DOSIS, TIPO)
 VALUES('8', '-25°', 'T', 2, 'PFIZER');
 
 INSERT INTO VACUNA (ID, PRESERVACION, APLICADA, DOSIS, TIPO)
 VALUES('9', '-25°', 'F', 2, 'PFIZER');
 
 INSERT INTO VACUNA (ID, PRESERVACION, APLICADA, DOSIS, TIPO)
 VALUES('10', '-25°', 'T', 2, 'PFIZER');
 
 INSERT INTO VACUNA (ID, PRESERVACION, APLICADA, DOSIS, TIPO)
 VALUES('11', '-14°', 'F', 1, 'SINOVAC');
 
 INSERT INTO VACUNA (ID, PRESERVACION, APLICADA, DOSIS, TIPO)
 VALUES('12', '-14°', 'F', 1, 'SINOVAC');
 
 INSERT INTO VACUNA (ID, PRESERVACION, APLICADA, DOSIS, TIPO)
 VALUES('13', '-14°', 'F', 1, 'SINOVAC');
 
 INSERT INTO VACUNA (ID, PRESERVACION, APLICADA, DOSIS, TIPO)
 VALUES('14', '-14°', 'F', 1, 'SINOVAC');
 
 INSERT INTO VACUNA (ID, PRESERVACION, APLICADA, DOSIS, TIPO)
 VALUES('15', '-14°', 'T', 1, 'SINOVAC');
 
 INSERT INTO VACUNA (ID, PRESERVACION, APLICADA, DOSIS, TIPO)
 VALUES('16', '-14°', 'T', 2, 'SINOVAC');
 
 INSERT INTO VACUNA (ID, PRESERVACION, APLICADA, DOSIS, TIPO)
 VALUES('17', '-14°', 'T', 2, 'SINOVAC');
 
 INSERT INTO VACUNA (ID, PRESERVACION, APLICADA, DOSIS, TIPO)
 VALUES('18', '-14°', 'F', 2, 'SINOVAC');
 
 INSERT INTO VACUNA (ID, PRESERVACION, APLICADA, DOSIS, TIPO)
 VALUES('19', '-14°', 'T', 2, 'SINOVAC');
 
 INSERT INTO VACUNA (ID, PRESERVACION, APLICADA, DOSIS, TIPO)
 VALUES('20', '-14°', 'T', 2, 'SINOVAC');
 
 INSERT INTO VACUNA (ID, PRESERVACION, APLICADA, DOSIS, TIPO)
 VALUES('21', '-11°', 'F', 1, 'ASTRAZENECA');
 
 INSERT INTO VACUNA (ID, PRESERVACION, APLICADA, DOSIS, TIPO)
 VALUES('22', '-11°', 'F', 1, 'ASTRAZENECA');
 
 INSERT INTO VACUNA (ID, PRESERVACION, APLICADA, DOSIS, TIPO)
 VALUES('23', '-11°', 'T', 1, 'ASTRAZENECA');
 
 INSERT INTO VACUNA (ID, PRESERVACION, APLICADA, DOSIS, TIPO)
 VALUES('24', '-11°', 'T', 1, 'ASTRAZENECA');
 
 INSERT INTO VACUNA (ID, PRESERVACION, APLICADA, DOSIS, TIPO)
 VALUES('25', '-11°', 'F', 1, 'ASTRAZENECA');
 
 INSERT INTO VACUNA (ID, PRESERVACION, APLICADA, DOSIS, TIPO)
 VALUES('26', '-11°', 'F', 2, 'ASTRAZENECA');
 
 INSERT INTO VACUNA (ID, PRESERVACION, APLICADA, DOSIS, TIPO)
 VALUES('27', '-11°', 'T', 2, 'ASTRAZENECA');
 
 INSERT INTO VACUNA (ID, PRESERVACION, APLICADA, DOSIS, TIPO)
 VALUES('28', '-11°', 'F', 2, 'ASTRAZENECA');
 
 INSERT INTO VACUNA (ID, PRESERVACION, APLICADA, DOSIS, TIPO)
 VALUES('29', '-11°', 'T', 2, 'ASTRAZENECA');
 
 INSERT INTO VACUNA (ID, PRESERVACION, APLICADA, DOSIS, TIPO)
 VALUES('30', '-11°', 'T', 2, 'ASTRAZENECA');

INSERT INTO ASIGNADA(ID_EPS, ID_PUNTO, ID_VACUNA)
 VALUES ('13','1','1');
 
 INSERT INTO ASIGNADA(ID_EPS, ID_PUNTO, ID_VACUNA)
 VALUES('13','2','2');
 
 INSERT INTO ASIGNADA(ID_EPS, ID_PUNTO, ID_VACUNA)
 VALUES('13','1','3');
 
 INSERT INTO ASIGNADA(ID_EPS, ID_PUNTO, ID_VACUNA)
 VALUES('13','5','4');
 
 INSERT INTO ASIGNADA(ID_EPS, ID_PUNTO, ID_VACUNA)
 VALUES('13','7','5');
 
 INSERT INTO ASIGNADA(ID_EPS, ID_PUNTO, ID_VACUNA)
 VALUES('13','2','6');
 
 INSERT INTO ASIGNADA(ID_EPS, ID_PUNTO, ID_VACUNA)
 VALUES('13','3','7');
 
 INSERT INTO ASIGNADA(ID_EPS, ID_PUNTO, ID_VACUNA)
 VALUES('13','6','8');
 
 INSERT INTO ASIGNADA(ID_EPS, ID_PUNTO, ID_VACUNA)
 VALUES('12','9','9');
 
 INSERT INTO ASIGNADA(ID_EPS, ID_PUNTO, ID_VACUNA)
 VALUES('12','10','10');
 
 INSERT INTO ASIGNADA(ID_EPS, ID_PUNTO, ID_VACUNA)
 VALUES('12','12','11');
 
 INSERT INTO ASIGNADA(ID_EPS, ID_PUNTO, ID_VACUNA)
 VALUES('12','11','12');
 
 INSERT INTO ASIGNADA(ID_EPS, ID_PUNTO, ID_VACUNA)
 VALUES('12','11','13');
 
 INSERT INTO ASIGNADA(ID_EPS, ID_PUNTO, ID_VACUNA)
 VALUES('12','13','14');
 
 INSERT INTO ASIGNADA(ID_EPS, ID_PUNTO, ID_VACUNA)
 VALUES('14','15','15');
 
 INSERT INTO ASIGNADA(ID_EPS, ID_PUNTO, ID_VACUNA)
 VALUES('14','16','16');
 
 INSERT INTO ASIGNADA(ID_EPS, ID_PUNTO, ID_VACUNA)
 VALUES('14','19','17');
 
 INSERT INTO ASIGNADA(ID_EPS, ID_PUNTO, ID_VACUNA)
 VALUES('14','21','18');
 
 INSERT INTO ASIGNADA(ID_EPS, ID_PUNTO, ID_VACUNA)
 VALUES('14','20','19');
 
 INSERT INTO ASIGNADA(ID_EPS, ID_PUNTO, ID_VACUNA)
 VALUES('14','16','20');
 
 INSERT INTO ASIGNADA(ID_EPS, ID_PUNTO, ID_VACUNA)
 VALUES('14','17','21');
 
 INSERT INTO ASIGNADA(ID_EPS, ID_PUNTO, ID_VACUNA)
 VALUES('14','18','22');
 
 INSERT INTO ASIGNADA(ID_EPS, ID_PUNTO, ID_VACUNA)
 VALUES('15','22','23');
 
 INSERT INTO ASIGNADA(ID_EPS, ID_PUNTO, ID_VACUNA)
 VALUES('15','23','24');
 
 INSERT INTO ASIGNADA(ID_EPS, ID_PUNTO, ID_VACUNA)
 VALUES('15','26','25');
 
 INSERT INTO ASIGNADA(ID_EPS, ID_PUNTO, ID_VACUNA)
 VALUES('15','28','26');
 
 INSERT INTO ASIGNADA(ID_EPS, ID_PUNTO, ID_VACUNA)
 VALUES('15','22','27');
 
 INSERT INTO ASIGNADA(ID_EPS, ID_PUNTO, ID_VACUNA)
 VALUES('15','24','28');
 
 INSERT INTO ASIGNADA(ID_EPS, ID_PUNTO, ID_VACUNA)
 VALUES('15','27','29');
 
 INSERT INTO ASIGNADA(ID_EPS, ID_PUNTO, ID_VACUNA)
 VALUES('15','28','30');

 INSERT INTO CIUDADANO (DOCUMENTO, NOMBRE, NACIMIENTO, HABILITADO, ID_ESTADO, ID_EPS, NUMERO_ETAPA)
 VALUES ('7364899', 'MARIA ZAPATA', TO_DATE('12-01-1965', 'DD-MM-YYYY'), 'T',1, '12',3);
 
 INSERT INTO CIUDADANO (DOCUMENTO, NOMBRE, NACIMIENTO, HABILITADO, ID_ESTADO, ID_EPS, NUMERO_ETAPA)
 VALUES('17263564', 'JUAN MOLINA', TO_DATE('15-12-1955', 'DD-MM-YYYY'), 'T',2, '13',2);
 
 INSERT INTO CIUDADANO (DOCUMENTO, NOMBRE, NACIMIENTO, HABILITADO, ID_ESTADO, ID_EPS, NUMERO_ETAPA)
 VALUES('1000763987', 'LUCIANA GARCIA', TO_DATE('3-04-2004', 'DD-MM-YYYY'), 'F',1, '14',5);
 
 INSERT INTO CIUDADANO (DOCUMENTO, NOMBRE, NACIMIENTO, HABILITADO, ID_ESTADO, ID_EPS, NUMERO_ETAPA)
 VALUES('43746567', 'OLGA MARTINEZ', TO_DATE('27-10-1940', 'DD-MM-YYYY'), 'T',3, '15',1);
 
 INSERT INTO CIUDADANO (DOCUMENTO, NOMBRE, NACIMIENTO, HABILITADO, ID_ESTADO, ID_EPS, NUMERO_ETAPA)
 VALUES('6376157', 'CARLOS RODRIGUEZ', TO_DATE('4-06-1985', 'DD-MM-YYYY'), 'T',1, '14',4);
 
 INSERT INTO CIUDADANO (DOCUMENTO, NOMBRE, NACIMIENTO, HABILITADO, ID_ESTADO, ID_EPS, NUMERO_ETAPA)
 VALUES('17639876', 'NIDIA RESTREPO', TO_DATE('3-11-1974', 'DD-MM-YYYY'), 'T',1, '12',4);
 
 INSERT INTO CIUDADANO (DOCUMENTO, NOMBRE, NACIMIENTO, HABILITADO, ID_ESTADO, ID_EPS, NUMERO_ETAPA)
 VALUES('84678453', 'NICOLAS MORA', TO_DATE('15-02-1975', 'DD-MM-YYYY'), 'T',2, '13',3);
 
 INSERT INTO CIUDADANO (DOCUMENTO, NOMBRE, NACIMIENTO, HABILITADO, ID_ESTADO, ID_EPS, NUMERO_ETAPA)
 VALUES('38761898', 'BEATRIZ PINZON', TO_DATE('5-09-1976', 'DD-MM-YYYY'), 'T',2, '13',3);
 
 INSERT INTO CIUDADANO (DOCUMENTO, NOMBRE, NACIMIENTO, HABILITADO, ID_ESTADO, ID_EPS, NUMERO_ETAPA)
 VALUES('191276456', 'MARTINA MONTOYA', TO_DATE( '7-04-2001', 'DD-MM-YYYY'),'T',1, '15',5);
 
 INSERT INTO CIUDADANO (DOCUMENTO, NOMBRE, NACIMIENTO, HABILITADO, ID_ESTADO, ID_EPS, NUMERO_ETAPA)
 VALUES('62783654', 'GONZALO GONZALEZ', TO_DATE( '30-03-1932', 'DD-MM-YYYY'),'T',4, '12',1);

 INSERT INTO CIUDADANO (DOCUMENTO, NOMBRE, NACIMIENTO, HABILITADO, ID_ESTADO, ID_EPS, NUMERO_ETAPA)
 VALUES ('7483748', 'JUAN PEREZ', TO_DATE('01-11-1947', 'DD-MM-YYYY'), 'T',1, '12',2);

 INSERT INTO CIUDADANO (DOCUMENTO, NOMBRE, NACIMIENTO, HABILITADO, ID_ESTADO, ID_EPS, NUMERO_ETAPA)
 VALUES ('5364849', 'OLGA GARCIA', TO_DATE('01-06-1965', 'DD-MM-YYYY'), 'T',1, '14',3);

 INSERT INTO CIUDADANO (DOCUMENTO, NOMBRE, NACIMIENTO, HABILITADO, ID_ESTADO, ID_EPS, NUMERO_ETAPA)
 VALUES ('84920230', 'LUISA GODOY', TO_DATE('25-07-2000', 'DD-MM-YYYY'), 'T',1, '13',5);

 INSERT INTO CIUDADANO (DOCUMENTO, NOMBRE, NACIMIENTO, HABILITADO, ID_ESTADO, ID_EPS, NUMERO_ETAPA)
 VALUES ('85943930', 'GIOVANNA BARROS', TO_DATE('26-04-1985', 'DD-MM-YYYY'), 'T',1, '13',3);

 INSERT INTO CIUDADANO (DOCUMENTO, NOMBRE, NACIMIENTO, HABILITADO, ID_ESTADO, ID_EPS, NUMERO_ETAPA)
 VALUES ('64837384', 'JAIME RUIZ', TO_DATE('15-07-1965', 'DD-MM-YYYY'), 'T',1, '12',3);

 INSERT INTO CIUDADANO (DOCUMENTO, NOMBRE, NACIMIENTO, HABILITADO, ID_ESTADO, ID_EPS, NUMERO_ETAPA)
 VALUES ('93847584', 'OLGA DEL CORRAL', TO_DATE('15-07-1945', 'DD-MM-YYYY'), 'T',3, '12',1);

 INSERT INTO CIUDADANO (DOCUMENTO, NOMBRE, NACIMIENTO, HABILITADO, ID_ESTADO, ID_EPS, NUMERO_ETAPA)
 VALUES ('2637465', 'GUSTAVO REYES', TO_DATE('18-09-1935', 'DD-MM-YYYY'), 'T',3, '13',1);

 INSERT INTO CIUDADANO (DOCUMENTO, NOMBRE, NACIMIENTO, HABILITADO, ID_ESTADO, ID_EPS, NUMERO_ETAPA)
 VALUES ('73849475', 'HECTOR GUITIERREZ', TO_DATE('24-11-1932', 'DD-MM-YYYY'), 'T',3, '14',1);

 INSERT INTO CIUDADANO (DOCUMENTO, NOMBRE, NACIMIENTO, HABILITADO, ID_ESTADO, ID_EPS, NUMERO_ETAPA)
 VALUES ('6373884', 'JUAN GUITIERREZ', TO_DATE('24-12-1932', 'DD-MM-YYYY'), 'T',4, '12',1);

 INSERT INTO CIUDADANO (DOCUMENTO, NOMBRE, NACIMIENTO, HABILITADO, ID_ESTADO, ID_EPS, NUMERO_ETAPA)
 VALUES ('73873848', 'JUANA GUITIERREZ', TO_DATE('28-01-1933', 'DD-MM-YYYY'), 'T',3, '12',1);

 INSERT INTO CIUDADANO (DOCUMENTO, NOMBRE, NACIMIENTO, HABILITADO, ID_ESTADO, ID_EPS, NUMERO_ETAPA)
 VALUES ('63536444', 'MARTIN MARTINEZ', TO_DATE('24-03-1934', 'DD-MM-YYYY'), 'T',4, '12',1);

 INSERT INTO CIUDADANO (DOCUMENTO, NOMBRE, NACIMIENTO, HABILITADO, ID_ESTADO, ID_EPS, NUMERO_ETAPA)
 VALUES ('9329485', 'JUANA MARTINEZ', TO_DATE('22-11-1929', 'DD-MM-YYYY'), 'T',3, '12',1);

 INSERT INTO CIUDADANO (DOCUMENTO, NOMBRE, NACIMIENTO, HABILITADO, ID_ESTADO, ID_EPS, NUMERO_ETAPA)
 VALUES ('2838344', 'LUCIA MARTINEZ', TO_DATE('02-02-1930', 'DD-MM-YYYY'), 'T',3, '12',1);

 INSERT INTO CIUDADANO (DOCUMENTO, NOMBRE, NACIMIENTO, HABILITADO, ID_ESTADO, ID_EPS, NUMERO_ETAPA)
 VALUES ('6282903', 'PEDRO MARTINEZ', TO_DATE('15-12-1924', 'DD-MM-YYYY'), 'T',3, '12',1);

 INSERT INTO CIUDADANO (DOCUMENTO, NOMBRE, NACIMIENTO, HABILITADO, ID_ESTADO, ID_EPS, NUMERO_ETAPA)
 VALUES ('8273748', 'HECTOR GARCIA', TO_DATE('24-09-1930', 'DD-MM-YYYY'), 'T',4, '12',1);

 INSERT INTO CIUDADANO (DOCUMENTO, NOMBRE, NACIMIENTO, HABILITADO, ID_ESTADO, ID_EPS, NUMERO_ETAPA)
 VALUES ('7393494', 'JUAN GUITIERREZ', TO_DATE('24-12-1932', 'DD-MM-YYYY'), 'T',4, '12',1);

 INSERT INTO CIUDADANO (DOCUMENTO, NOMBRE, NACIMIENTO, HABILITADO, ID_ESTADO, ID_EPS, NUMERO_ETAPA)
 VALUES ('46263737', 'MARIA GARCIA', TO_DATE('25-01-1943', 'DD-MM-YYYY'), 'T',3, '13',1);

 INSERT INTO CIUDADANO (DOCUMENTO, NOMBRE, NACIMIENTO, HABILITADO, ID_ESTADO, ID_EPS, NUMERO_ETAPA)
 VALUES ('9283847', 'PEDRO GARCIA', TO_DATE('04-03-1934', 'DD-MM-YYYY'), 'T',3, '13',1);

 INSERT INTO CIUDADANO (DOCUMENTO, NOMBRE, NACIMIENTO, HABILITADO, ID_ESTADO, ID_EPS, NUMERO_ETAPA)
 VALUES ('82673644', 'PEDRO ROSAS', TO_DATE('22-11-1929', 'DD-MM-YYYY'), 'T',3, '13',1);

 INSERT INTO CIUDADANO (DOCUMENTO, NOMBRE, NACIMIENTO, HABILITADO, ID_ESTADO, ID_EPS, NUMERO_ETAPA)
 VALUES ('16373478', 'JUAN ROSAS', TO_DATE('02-02-1920', 'DD-MM-YYYY'), 'T',4, '13',1);

 INSERT INTO CIUDADANO (DOCUMENTO, NOMBRE, NACIMIENTO, HABILITADO, ID_ESTADO, ID_EPS, NUMERO_ETAPA)
 VALUES ('817382983', 'CARLOS ROSAS', TO_DATE('15-02-1924', 'DD-MM-YYYY'), 'T',3, '13',1);

 INSERT INTO CIUDADANO (DOCUMENTO, NOMBRE, NACIMIENTO, HABILITADO, ID_ESTADO, ID_EPS, NUMERO_ETAPA)
 VALUES ('9273764', 'LUIS GARCIA', TO_DATE('24-09-1930', 'DD-MM-YYYY'), 'T',3, '13',1);

INSERT INTO CIUDADANO (DOCUMENTO, NOMBRE, NACIMIENTO, HABILITADO, ID_ESTADO, ID_EPS, NUMERO_ETAPA)
 VALUES ('8127374', 'JUANA GARCIA', TO_DATE('25-01-1943', 'DD-MM-YYYY'), 'T',4, '14',1);

 INSERT INTO CIUDADANO (DOCUMENTO, NOMBRE, NACIMIENTO, HABILITADO, ID_ESTADO, ID_EPS, NUMERO_ETAPA)
 VALUES ('7283893', 'LUZ GARCIA', TO_DATE('04-12-1934', 'DD-MM-YYYY'), 'T',3, '14',1);

 INSERT INTO CIUDADANO (DOCUMENTO, NOMBRE, NACIMIENTO, HABILITADO, ID_ESTADO, ID_EPS, NUMERO_ETAPA)
 VALUES ('1038384', 'PEDRO GONZALEZ', TO_DATE('21-11-1939', 'DD-MM-YYYY'), 'T',3, '14',1);

 INSERT INTO CIUDADANO (DOCUMENTO, NOMBRE, NACIMIENTO, HABILITADO, ID_ESTADO, ID_EPS, NUMERO_ETAPA)
 VALUES ('82734774', 'PEDRO ROSA', TO_DATE('02-12-1920', 'DD-MM-YYYY'), 'T',4, '14',1);

 INSERT INTO CIUDADANO (DOCUMENTO, NOMBRE, NACIMIENTO, HABILITADO, ID_ESTADO, ID_EPS, NUMERO_ETAPA)
 VALUES ('928374', 'CARLOS GONZALEZ', TO_DATE('15-02-1924', 'DD-MM-YYYY'), 'T',3, '14',1);

 INSERT INTO CIUDADANO (DOCUMENTO, NOMBRE, NACIMIENTO, HABILITADO, ID_ESTADO, ID_EPS, NUMERO_ETAPA)
 VALUES ('627374', 'LUIS GONZALEZ', TO_DATE('24-09-1930', 'DD-MM-YYYY'), 'T',3, '14',1);

INSERT INTO CIUDADANO (DOCUMENTO, NOMBRE, NACIMIENTO, HABILITADO, ID_ESTADO, ID_EPS, NUMERO_ETAPA)
 VALUES ('536373', 'CAMILA GOMEZ', TO_DATE('25-01-1943', 'DD-MM-YYYY'), 'T',4, '15',1);

 INSERT INTO CIUDADANO (DOCUMENTO, NOMBRE, NACIMIENTO, HABILITADO, ID_ESTADO, ID_EPS, NUMERO_ETAPA)
 VALUES ('1536373', 'OLGA RAMIREZ', TO_DATE('14-12-1935', 'DD-MM-YYYY'), 'T',3, '15',1);

 INSERT INTO CIUDADANO (DOCUMENTO, NOMBRE, NACIMIENTO, HABILITADO, ID_ESTADO, ID_EPS, NUMERO_ETAPA)
 VALUES ('82173746', 'BEATRIZ GONZALEZ', TO_DATE('21-12-1939', 'DD-MM-YYYY'), 'T',4, '15',1);

 INSERT INTO CIUDADANO (DOCUMENTO, NOMBRE, NACIMIENTO, HABILITADO, ID_ESTADO, ID_EPS, NUMERO_ETAPA)
 VALUES ('3647272', 'ESTHER REYES', TO_DATE('12-12-1932', 'DD-MM-YYYY'), 'T',3, '15',1);

 INSERT INTO CIUDADANO (DOCUMENTO, NOMBRE, NACIMIENTO, HABILITADO, ID_ESTADO, ID_EPS, NUMERO_ETAPA)
 VALUES ('183848', 'MARIA GONZALEZ', TO_DATE('15-02-1924', 'DD-MM-YYYY'), 'T',3, '15',1);

 INSERT INTO CIUDADANO (DOCUMENTO, NOMBRE, NACIMIENTO, HABILITADO, ID_ESTADO, ID_EPS, NUMERO_ETAPA)
 VALUES ('928384', 'SANDRA GONZALEZ', TO_DATE('24-09-1920', 'DD-MM-YYYY'), 'T',4, '15',1);

 INSERT INTO VACUNACION (DOCUMENTO_CIUDADANO, ID_EPS, ID_PUNTO)
 VALUES ('7364899', '12', '8');
 
 INSERT INTO VACUNACION (DOCUMENTO_CIUDADANO, ID_EPS, ID_PUNTO)
 VALUES('17263564', '13', '1');
 
 INSERT INTO VACUNACION (DOCUMENTO_CIUDADANO, ID_EPS, ID_PUNTO)
 VALUES('1000763987', '14', '19');
 
 INSERT INTO VACUNACION (DOCUMENTO_CIUDADANO, ID_EPS, ID_PUNTO)
 VALUES ('6376157', '14', '20');
 
 INSERT INTO VACUNACION (DOCUMENTO_CIUDADANO, ID_EPS, ID_PUNTO)
 VALUES('17639876', '12', '10');
 
INSERT INTO VACUNACION (DOCUMENTO_CIUDADANO, ID_EPS, ID_PUNTO)
 VALUES('84678453', '13', '2');
 
 INSERT INTO VACUNACION (DOCUMENTO_CIUDADANO, ID_EPS, ID_PUNTO)
 VALUES('38761898', '13', '7');
 
 INSERT INTO VACUNACION (DOCUMENTO_CIUDADANO, ID_EPS, ID_PUNTO)
 VALUES('191276456', '15', '28');
 
 INSERT INTO VACUNACION (DOCUMENTO_CIUDADANO, ID_EPS, ID_PUNTO)
 VALUES('62783654', '12', '13');

INSERT INTO PRIORIZACION (DOCUMENTO_CIUDADANO, DESCRIPCION_CONDPRIOR)
 VALUES ('7364899', '16 AÑOS O MAS');
 
 INSERT INTO PRIORIZACION (DOCUMENTO_CIUDADANO, DESCRIPCION_CONDPRIOR)
 VALUES('17263564', '60 A 79 AÑOS');
 
 INSERT INTO PRIORIZACION (DOCUMENTO_CIUDADANO, DESCRIPCION_CONDPRIOR)
 VALUES ('17263564', 'ASMA');
 
 INSERT INTO PRIORIZACION (DOCUMENTO_CIUDADANO, DESCRIPCION_CONDPRIOR)
 VALUES('1000763987', '16 AÑOS O MAS');
 
 INSERT INTO PRIORIZACION (DOCUMENTO_CIUDADANO, DESCRIPCION_CONDPRIOR)
 VALUES('43746567', '80 AÑOS O MAS');
 
 INSERT INTO PRIORIZACION (DOCUMENTO_CIUDADANO, DESCRIPCION_CONDPRIOR)
 VALUES('43746567', 'DIABETES');
 
 INSERT INTO PRIORIZACION (DOCUMENTO_CIUDADANO, DESCRIPCION_CONDPRIOR)
 VALUES('6376157', '16 AÑOS O MAS');
 
 INSERT INTO PRIORIZACION (DOCUMENTO_CIUDADANO, DESCRIPCION_CONDPRIOR)
 VALUES('6376157', 'PRIVACION DE LIBERTAD');
 
 INSERT INTO PRIORIZACION (DOCUMENTO_CIUDADANO, DESCRIPCION_CONDPRIOR)
 VALUES('17639876', '16 AÑOS O MAS');
 
 INSERT INTO PRIORIZACION (DOCUMENTO_CIUDADANO, DESCRIPCION_CONDPRIOR)
 VALUES('17639876', 'PRIVACION DE LIBERTAD');
 
 INSERT INTO PRIORIZACION (DOCUMENTO_CIUDADANO, DESCRIPCION_CONDPRIOR)
 VALUES('84678453', '16 AÑOS O MAS');
 
 INSERT INTO PRIORIZACION (DOCUMENTO_CIUDADANO, DESCRIPCION_CONDPRIOR)
 VALUES('84678453', 'ASMA');
 
 INSERT INTO PRIORIZACION (DOCUMENTO_CIUDADANO, DESCRIPCION_CONDPRIOR)
 VALUES('38761898', '16 AÑOS O MAS');
 
 INSERT INTO PRIORIZACION (DOCUMENTO_CIUDADANO, DESCRIPCION_CONDPRIOR)
 VALUES('38761898', 'ASMA');
 
 INSERT INTO PRIORIZACION (DOCUMENTO_CIUDADANO, DESCRIPCION_CONDPRIOR)
 VALUES('191276456', '16 AÑOS O MAS');
 
 INSERT INTO PRIORIZACION (DOCUMENTO_CIUDADANO, DESCRIPCION_CONDPRIOR)
 VALUES('62783654', '80 AÑOS O MAS');

 INSERT INTO INFOUSUARIO (LOGIN, CLAVE, TRABAJO, ID_ROLES, ID_PUNTO)
 VALUES ('JPEREZ', 'CONTRA1', 'ADMIN PUNTO DE VACUNACION', 3, '15');
 
 INSERT INTO INFOUSUARIO (LOGIN, CLAVE, TRABAJO, ID_ROLES, ID_PUNTO)
 VALUES ('OGARCIA', 'CONTRA2', 'ADMIN DE OFICINA EPS', 2, '1');
 
 INSERT INTO INFOUSUARIO (LOGIN, CLAVE, TRABAJO, ID_ROLES, ID_PUNTO)
 VALUES('LGODOY', 'CONTRA3', 'ENFERMERA', 6, '20');
 
 INSERT INTO INFOUSUARIO (LOGIN, CLAVE, TRABAJO, ID_ROLES, ID_PUNTO)
 VALUES('GBARROS', 'CONTRA4', 'DOCTORA', 6, '2');
 
 INSERT INTO INFOUSUARIO (LOGIN, CLAVE, TRABAJO, ID_ROLES, ID_PUNTO)
 VALUES('FHERNANDEZ', 'CONTRA5', 'OPERADOR PUNTO DE VACUNACION', 4, '3');
 
 INSERT INTO INFOUSUARIO (LOGIN, CLAVE, TRABAJO, ID_ROLES, ID_PUNTO)
 VALUES ('BPINZON', 'CONTRA6', 'CIUDADANA', 5, '7');
 
 INSERT INTO INFOUSUARIO (LOGIN, CLAVE, TRABAJO, ID_ROLES, ID_PUNTO)
 VALUES('NMORA', 'CONTRA7', 'CIUDADANO', 5, '2');
 
 INSERT INTO INFOUSUARIO (LOGIN, CLAVE, TRABAJO, ID_ROLES, ID_PUNTO)
 VALUES('GGONZALEZ', 'CONTRA8', 'CIUDADANO', 5, '13');
 
INSERT INTO INFOUSUARIO (LOGIN, CLAVE, TRABAJO, ID_ROLES, ID_PUNTO)
 VALUES('JRUIZ', 'CONTRA9', 'ADMINISTRADOR DEL PLAN DE VACUNACION', 1, '1');

INSERT INTO USUARIO (DOCUMENTO_CIUDADANO, LOGIN_INFOUSUARIO)
VALUES ('7483748', 'JPEREZ');

INSERT INTO USUARIO (DOCUMENTO_CIUDADANO, LOGIN_INFOUSUARIO)
VALUES ('5364849', 'OGARCIA');

INSERT INTO USUARIO (DOCUMENTO_CIUDADANO, LOGIN_INFOUSUARIO)
VALUES('84920230', 'LGODOY');

INSERT INTO USUARIO (DOCUMENTO_CIUDADANO, LOGIN_INFOUSUARIO)
VALUES('85943930', 'GBARROS');

INSERT INTO USUARIO (DOCUMENTO_CIUDADANO, LOGIN_INFOUSUARIO)
VALUES('38761898', 'BPINZON');

INSERT INTO USUARIO (DOCUMENTO_CIUDADANO, LOGIN_INFOUSUARIO)
VALUES('84678453', 'NMORA');

INSERT INTO USUARIO (DOCUMENTO_CIUDADANO, LOGIN_INFOUSUARIO)
VALUES('62783654', 'GGONZALEZ');

INSERT INTO USUARIO (DOCUMENTO_CIUDADANO, LOGIN_INFOUSUARIO)
VALUES ('64837384', 'JRUIZ');

 INSERT INTO CITA (FECHAHORA, FINALIZADA, DOCUMENTO_CIUDADANO, ID_PUNTO)
 VALUES (TO_DATE('12-08-2021 17:30', 'DD-MM-YYYY HH24:MI'), 'F', '7364899', '8');
 
INSERT INTO CITA (FECHAHORA, FINALIZADA, DOCUMENTO_CIUDADANO, ID_PUNTO)
 VALUES(TO_DATE('10-05-2021 8:20','DD-MM-YYYY HH24:MI'), 'F', '17263564', '1');
 
INSERT INTO CITA (FECHAHORA, FINALIZADA, DOCUMENTO_CIUDADANO, ID_PUNTO)
 VALUES(TO_DATE('11-02-2023 10:15', 'DD-MM-YYYY HH24:MI'), 'F', '1000763987', '19');
 
INSERT INTO CITA (FECHAHORA, FINALIZADA, DOCUMENTO_CIUDADANO, ID_PUNTO)
 VALUES(TO_DATE('11-02-2021 15:45', 'DD-MM-YYYY HH24:MI'), 'T', '43746567', '23');
 
INSERT INTO CITA (FECHAHORA, FINALIZADA, DOCUMENTO_CIUDADANO, ID_PUNTO)
 VALUES(TO_DATE('11-04-2021 16:30', 'DD-MM-YYYY HH24:MI'), 'F', '17639876', '11');
 
INSERT INTO CITA (FECHAHORA, FINALIZADA, DOCUMENTO_CIUDADANO, ID_PUNTO)
 VALUES(TO_DATE('30-05-2022 13:30', 'DD-MM-YYYY HH24:MI'), 'F', '6376157', '20');

INSERT INTO CITA (FECHAHORA, FINALIZADA, DOCUMENTO_CIUDADANO, ID_PUNTO)
 VALUES(TO_DATE('30-03-2021 12:30', 'DD-MM-YYYY HH24:MI'), 'T', '93847584', '8');

INSERT INTO CITA (FECHAHORA, FINALIZADA, DOCUMENTO_CIUDADANO, ID_PUNTO)
 VALUES(TO_DATE('12-03-2021 15:30', 'DD-MM-YYYY HH24:MI'), 'T', '2637465', '2');

INSERT INTO CITA (FECHAHORA, FINALIZADA, DOCUMENTO_CIUDADANO, ID_PUNTO)
 VALUES(TO_DATE('17-03-2021 11:30', 'DD-MM-YYYY HH24:MI'), 'T', '73849475', '20');

INSERT INTO CITA (FECHAHORA, FINALIZADA, DOCUMENTO_CIUDADANO, ID_PUNTO)
 VALUES(TO_DATE('15-03-2021 08:30', 'DD-MM-YYYY HH24:MI'), 'T', '6373884', '14');

INSERT INTO CITA (FECHAHORA, FINALIZADA, DOCUMENTO_CIUDADANO, ID_PUNTO)
 VALUES(TO_DATE('18-03-2021 07:30', 'DD-MM-YYYY HH24:MI'), 'T', '73873848', '14');

INSERT INTO CITA (FECHAHORA, FINALIZADA, DOCUMENTO_CIUDADANO, ID_PUNTO)
 VALUES(TO_DATE('20-03-2021 06:30', 'DD-MM-YYYY HH24:MI'), 'T', '63536444', '11');

INSERT INTO CITA (FECHAHORA, FINALIZADA, DOCUMENTO_CIUDADANO, ID_PUNTO)
 VALUES(TO_DATE('21-03-2021 06:30', 'DD-MM-YYYY HH24:MI'), 'T', '9329485', '12');

INSERT INTO CITA (FECHAHORA, FINALIZADA, DOCUMENTO_CIUDADANO, ID_PUNTO)
 VALUES(TO_DATE('12-03-2021 12:30', 'DD-MM-YYYY HH24:MI'), 'T', '2838344', '13');

INSERT INTO CITA (FECHAHORA, FINALIZADA, DOCUMENTO_CIUDADANO, ID_PUNTO)
 VALUES(TO_DATE('13-03-2021 12:30', 'DD-MM-YYYY HH24:MI'), 'T', '6282903', '9');

INSERT INTO CITA (FECHAHORA, FINALIZADA, DOCUMENTO_CIUDADANO, ID_PUNTO)
 VALUES(TO_DATE('14-03-2021 14:30', 'DD-MM-YYYY HH24:MI'), 'T', '8273748', '8');

INSERT INTO CITA (FECHAHORA, FINALIZADA, DOCUMENTO_CIUDADANO, ID_PUNTO)
 VALUES(TO_DATE('16-03-2021 18:30', 'DD-MM-YYYY HH24:MI'), 'T', '7393494', '10');

INSERT INTO CITA (FECHAHORA, FINALIZADA, DOCUMENTO_CIUDADANO, ID_PUNTO)
 VALUES(TO_DATE('15-03-2021 15:30', 'DD-MM-YYYY HH24:MI'), 'T', '73873848', '1');

INSERT INTO CITA (FECHAHORA, FINALIZADA, DOCUMENTO_CIUDADANO, ID_PUNTO)
 VALUES(TO_DATE('20-03-2021 13:30', 'DD-MM-YYYY HH24:MI'), 'T', '9283847', '6');

INSERT INTO CITA (FECHAHORA, FINALIZADA, DOCUMENTO_CIUDADANO, ID_PUNTO)
 VALUES(TO_DATE('26-03-2021 12:30', 'DD-MM-YYYY HH24:MI'), 'T', '82673644', '7');

INSERT INTO CITA (FECHAHORA, FINALIZADA, DOCUMENTO_CIUDADANO, ID_PUNTO)
 VALUES(TO_DATE('21-03-2021 18:30', 'DD-MM-YYYY HH24:MI'), 'T', '16373478', '5');

INSERT INTO CITA (FECHAHORA, FINALIZADA, DOCUMENTO_CIUDADANO, ID_PUNTO)
 VALUES(TO_DATE('29-03-2021 18:30', 'DD-MM-YYYY HH24:MI'), 'T', '817382983', '2');

INSERT INTO CITA (FECHAHORA, FINALIZADA, DOCUMENTO_CIUDADANO, ID_PUNTO)
 VALUES(TO_DATE('30-03-2021 19:30', 'DD-MM-YYYY HH24:MI'), 'T', '9273764', '3');

INSERT INTO CITA (FECHAHORA, FINALIZADA, DOCUMENTO_CIUDADANO, ID_PUNTO)
 VALUES(TO_DATE('20-03-2021 11:30', 'DD-MM-YYYY HH24:MI'), 'T', '8127374', '15');

INSERT INTO CITA (FECHAHORA, FINALIZADA, DOCUMENTO_CIUDADANO, ID_PUNTO)
 VALUES(TO_DATE('23-02-2021 11:30', 'DD-MM-YYYY HH24:MI'), 'T', '7283893', '16');

INSERT INTO CITA (FECHAHORA, FINALIZADA, DOCUMENTO_CIUDADANO, ID_PUNTO)
 VALUES(TO_DATE('24-02-2021 12:30', 'DD-MM-YYYY HH24:MI'), 'T', '1038384', '17');

INSERT INTO CITA (FECHAHORA, FINALIZADA, DOCUMENTO_CIUDADANO, ID_PUNTO)
 VALUES(TO_DATE('27-02-2021 17:30', 'DD-MM-YYYY HH24:MI'), 'T', '9283847', '18');

INSERT INTO CITA (FECHAHORA, FINALIZADA, DOCUMENTO_CIUDADANO, ID_PUNTO)
 VALUES(TO_DATE('21-02-2021 17:30', 'DD-MM-YYYY HH24:MI'), 'T', '928374', '19');


INSERT INTO CITA (FECHAHORA, FINALIZADA, DOCUMENTO_CIUDADANO, ID_PUNTO)
 VALUES(TO_DATE('11-02-2021 12:30', 'DD-MM-YYYY HH24:MI'), 'T', '627374', '20');
 
INSERT INTO CITA (FECHAHORA, FINALIZADA, DOCUMENTO_CIUDADANO, ID_PUNTO)
 VALUES(TO_DATE('10-02-2021 14:30', 'DD-MM-YYYY HH24:MI'), 'T', '536373', '22');

INSERT INTO CITA (FECHAHORA, FINALIZADA, DOCUMENTO_CIUDADANO, ID_PUNTO)
 VALUES(TO_DATE('13-02-2021 18:30', 'DD-MM-YYYY HH24:MI'), 'T', '1536373', '23');

INSERT INTO CITA (FECHAHORA, FINALIZADA, DOCUMENTO_CIUDADANO, ID_PUNTO)
 VALUES(TO_DATE('19-04-2021 1:30', 'DD-MM-YYYY HH24:MI'), 'F', '82173746', '24');

INSERT INTO CITA (FECHAHORA, FINALIZADA, DOCUMENTO_CIUDADANO, ID_PUNTO)
 VALUES(TO_DATE('09-02-2021 12:30', 'DD-MM-YYYY HH24:MI'), 'T', '3647272', '26');

INSERT INTO CITA (FECHAHORA, FINALIZADA, DOCUMENTO_CIUDADANO, ID_PUNTO)
 VALUES(TO_DATE('04-02-2021 17:30', 'DD-MM-YYYY HH24:MI'), 'T', '183848', '27');

INSERT INTO CITA (FECHAHORA, FINALIZADA, DOCUMENTO_CIUDADANO, ID_PUNTO)
 VALUES(TO_DATE('04-03-2021 17:30', 'DD-MM-YYYY HH24:MI'), 'T', '928384', '25');

UPDATE CIUDADANO SET ID_ESTADO = 2 WHERE DOCUMENTO = '7364899';

UPDATE CIUDADANO SET ID_ESTADO = 3 WHERE DOCUMENTO = '84678453';

UPDATE CIUDADANO SET ID_ESTADO = 2 WHERE DOCUMENTO = '191276456';

COMMIT;