--------------------------------------------------------
-- Archivo creado  - domingo-octubre-06-2019   
--------------------------------------------------------
DROP TABLE "PDT"."REVISA" CASCADE CONSTRAINTS;
DROP TABLE "PDT"."CARACTERISTICAS" cascade constraints;
DROP TABLE "PDT"."DEPARTAMENTO" cascade constraints;
DROP TABLE "PDT"."DETALLE" cascade constraints;
DROP TABLE "PDT"."ESTADO_OBSERV" cascade constraints;
DROP TABLE "PDT"."FENOMENO" cascade constraints;
DROP TABLE "PDT"."LOCALIDAD" cascade constraints;
DROP TABLE "PDT"."OBSERVACIONES" cascade constraints;
DROP TABLE "PDT"."TELEFONO" cascade constraints;
DROP TABLE "PDT"."TIPOSUSUARIOS" cascade constraints;
DROP TABLE "PDT"."USUARIO" cascade constraints;
DROP TABLE "PDT"."ZONA" cascade constraints;
DROP SEQUENCE "PDT"."SEQ_CARACTERISTICASID";
DROP SEQUENCE "PDT"."SEQ_GEOLOCALIZACIONID";
DROP SEQUENCE "PDT"."SEQ_OBSERVACIONID";
DROP SEQUENCE "PDT"."SEQ_USUARIOID";
DROP SEQUENCE "PDT"."SEQ_CODIGOFENOMENO";
DROP SEQUENCE "PDT"."SEQ_IDLOCALIDADID";
DROP SEQUENCE "PDT"."SEQ_IDZONA";
DROP SEQUENCE "PDT"."SEQ_IDDEPARTAMENTO";
DROP SEQUENCE "PDT"."hibernate_sequence";


PURGE RECYCLEBIN;
--------------------------------------------------------
--  DDL for Sequence CARACTERISTICASID
--------------------------------------------------------

   CREATE SEQUENCE  "PDT"."SEQ_CARACTERISTICASID"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence GEOLOCALIZACIONID
--------------------------------------------------------

   CREATE SEQUENCE  "PDT"."SEQ_GEOLOCALIZACIONID"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence OBSERVACIONID
--------------------------------------------------------

   CREATE SEQUENCE  "PDT"."SEQ_OBSERVACIONID"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence USUARIOID
--------------------------------------------------------

   CREATE SEQUENCE  "PDT"."SEQ_USUARIOID"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
-- Secuencia Fenomneo
--------------------------------------------------------
	CREATE SEQUENCE "PDT"."SEQ_CODIGOFENOMENO"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
	
------	----------------------------------------------------
	--SECUENCIA LOCALIDAD
---	--------------------------------------------------------
	
	CREATE SEQUENCE "PDT"."SEQ_IDLOCALIDADID"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

---------------------------------------------------------------
-- SECUENCIA ZONA
---------------------------------------------------------------
CREATE SEQUENCE "PDT"."SEQ_IDZONA"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

---------------------------------------------------------------
-- SECUENCIA DEPARTAMENTO
----------------------------------------------------------------
CREATE SEQUENCE "PDT"."SEQ_IDDEPARTAMENTO"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;





--------------------------------------------------------
-- TABLA REVISA RELACION DE EXPERTO CON OBSERVACION.
--------------------------------------------------------

CREATE TABLE "PDT"."REVISA"
(
	"ID_USUARIO" NUMBER(10),
	"ID_OBSERVACION" NUMBER(10),
	"FIABILIDAD" VARCHAR(50) not null,
	"FECHAYHORA" DATE,
	"COMENTARIOS" VARCHAR(100)
	
);

ALTER TABLE PDT.REVISA ADD CONSTRAINT PK_REVISA PRIMARY KEY (ID_OBSERVACION,ID_USUARIO,FECHAYHORA);



--------------------------------------------------------
--  DDL for Table CARACTERISTICAS
--------------------------------------------------------

  CREATE TABLE "PDT"."CARACTERISTICAS" 
   (	"ID_CARACT" NUMBER(10,0), 
	"CODIGO_FEN" NUMBER(10,0), 
	"NOMBRE" VARCHAR2(50 BYTE), 
	"ETIQUETA" VARCHAR2(50 BYTE), 
	"TIPODATO" VARCHAR2(50 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table DEPARTAMENTO
--------------------------------------------------------

  CREATE TABLE "PDT"."DEPARTAMENTO" 
   (	"ID_DEPARTAMENTO" NUMBER(10,0), 
	"NOMBRE_DEP" VARCHAR2(40 BYTE), 
	"ID_ZONA" NUMBER(10,0)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table DETALLE
--------------------------------------------------------

  CREATE TABLE "PDT"."DETALLE" 
   (	"ID_CARACT" NUMBER(10,0), 
	"ID_OBSERVACION" NUMBER(10,0), 
	"FECHORA" DATE, 
	"VALORNUM" NUMBER(10,0), 
	"VALORTEXTO" VARCHAR2(40 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table ESTADO_OBSERV
--------------------------------------------------------

  CREATE TABLE "PDT"."ESTADO_OBSERV" 
   (	"ID_ESTADO" NUMBER(10,0), 
	"NOMBRE" VARCHAR2(50 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table FENOMENO
--------------------------------------------------------

  CREATE TABLE "PDT"."FENOMENO" 
   (	
   "CODIGO_FEN" NUMBER(10,0), 
   "CODIGO" VARCHAR2(40 BYTE),
	"NOMBRE_FEN" VARCHAR2(40 BYTE), 
	"DESCRIPCION" VARCHAR2(100 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table LOCALIDAD
--------------------------------------------------------

  CREATE TABLE "PDT"."LOCALIDAD" 
   (	"ID_LOCALIDAD" NUMBER(10,0), 
	"ID_DEPARTAMENTO" NUMBER(10,0), 
	"NOMBRE_LOC" VARCHAR2(40 BYTE), 
	"LATITUD" FLOAT(50), 
	"LONGITUD" FLOAT(50), 
	"ALTITUD" FLOAT(50)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table OBSERVACIONES
--------------------------------------------------------

  CREATE TABLE "PDT"."OBSERVACIONES" 
   (	"ID_OBSERVACION" NUMBER(10,0), 
	"ID_USUARIO" NUMBER(10,0), 
	"CODIGO_FEN" NUMBER(10,0), 
	"ID_LOCALIDAD" NUMBER(10,0), 
	"DESCRIPCION" VARCHAR2(50 BYTE), 
	"IMAGEN" BLOB, 
	"LATITUD" FLOAT(50), 
	"LONGITUD" FLOAT(50), 
	"ALTITUD" FLOAT(50), 
	"ID_ESTADO" NUMBER(10,0), 
	"FECHAHORA" DATE
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" 
 LOB ("IMAGEN") STORE AS (
  TABLESPACE "USERS" ENABLE STORAGE IN ROW CHUNK 8192 PCTVERSION 10
  NOCACHE LOGGING 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)) ;
--------------------------------------------------------
--  DDL for Table TELEFONO
--------------------------------------------------------

  CREATE TABLE "PDT"."TELEFONO" 
   (	"ID_TEL" NUMBER(10,0), 
	"NUMERO" VARCHAR2(20 BYTE), 
	"CODIGO_FEN" NUMBER(10,0)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table TIPOSUSUARIOS
--------------------------------------------------------

  CREATE TABLE "PDT"."TIPOSUSUARIOS" 
   (	"ID_TIPO" NUMBER(10,0), 
	"NOMBRE" VARCHAR2(50 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table USUARIO
--------------------------------------------------------

  CREATE TABLE "PDT"."USUARIO" 
   (	"ID_USUARIO" NUMBER(10,0), 
	"ID_TIPO" NUMBER(10,0), 
	"PASS" VARCHAR2(50 	 BYTE), 
	"USUARIO" VARCHAR2(80 BYTE), 
	"NOMBRE" VARCHAR2(50 BYTE), 
	"APELLIDO" VARCHAR2(50 BYTE), 
	"ESTADO" VARCHAR2(50 BYTE), 
	"TIPODOC" VARCHAR2(50 BYTE), 
	"NUMERODOC" VARCHAR2(50 BYTE), 
	"DIRECCION" VARCHAR2(50 BYTE), 
	"MAIL" VARCHAR2(100 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table ZONA
--------------------------------------------------------

  CREATE TABLE "PDT"."ZONA" 
   (	"ID_ZONA" NUMBER(10,0), 
	"NOMBRE_ZONA" VARCHAR2(40 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into PDT.CARACTERISTICAS
SET DEFINE OFF;
REM INSERTING into PDT.DEPARTAMENTO
SET DEFINE OFF;
REM INSERTING into PDT.DETALLE
SET DEFINE OFF;
REM INSERTING into PDT.ESTADO_OBSERV
SET DEFINE OFF;
REM INSERTING into PDT.FENOMENO
SET DEFINE OFF;
REM INSERTING into PDT.LOCALIDAD
SET DEFINE OFF;
REM INSERTING into PDT.OBSERVACIONES
SET DEFINE OFF;
REM INSERTING into PDT.TELEFONO
SET DEFINE OFF;
REM INSERTING into PDT.TIPOSUSUARIOS
SET DEFINE OFF;
REM INSERTING into PDT.USUARIO
SET DEFINE OFF;
REM INSERTING into PDT.ZONA
SET DEFINE OFF;
--------------------------------------------------------
--  DDL for Index PK_TELEFONO
--------------------------------------------------------

  CREATE UNIQUE INDEX "PDT"."PK_TELEFONO" ON "PDT"."TELEFONO" ("ID_TEL") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_LOCALIDAD
--------------------------------------------------------

  CREATE UNIQUE INDEX "PDT"."PK_LOCALIDAD" ON "PDT"."LOCALIDAD" ("ID_LOCALIDAD") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_CODIGOFEN
--------------------------------------------------------

  CREATE UNIQUE INDEX "PDT"."PK_CODIGOFEN" ON "PDT"."FENOMENO" ("CODIGO_FEN") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_USUARIO
--------------------------------------------------------

  CREATE UNIQUE INDEX "PDT"."PK_USUARIO" ON "PDT"."USUARIO" ("ID_USUARIO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_ZONA
--------------------------------------------------------

  CREATE UNIQUE INDEX "PDT"."PK_ZONA" ON "PDT"."ZONA" ("ID_ZONA") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index UK_ESTADO
--------------------------------------------------------

  CREATE UNIQUE INDEX "PDT"."UK_ESTADO" ON "PDT"."ESTADO_OBSERV" ("NOMBRE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_CARCOBSERV
--------------------------------------------------------

  CREATE UNIQUE INDEX "PDT"."PK_CARCOBSERV" ON "PDT"."DETALLE" ("ID_CARACT", "ID_OBSERVACION") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_TIPOUSU
--------------------------------------------------------

  CREATE UNIQUE INDEX "PDT"."PK_TIPOUSU" ON "PDT"."TIPOSUSUARIOS" ("ID_TIPO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_IDCARACTERISTICA
--------------------------------------------------------

  CREATE UNIQUE INDEX "PDT"."PK_IDCARACTERISTICA" ON "PDT"."CARACTERISTICAS" ("ID_CARACT") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index UK_NOMBRE
--------------------------------------------------------

  CREATE UNIQUE INDEX "PDT"."UK_NOMBRE" ON "PDT"."TIPOSUSUARIOS" ("NOMBRE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_DEPARTAMENTO
--------------------------------------------------------

  CREATE UNIQUE INDEX "PDT"."PK_DEPARTAMENTO" ON "PDT"."DEPARTAMENTO" ("ID_DEPARTAMENTO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index UK_NOMB_REFEN
--------------------------------------------------------

  CREATE UNIQUE INDEX "PDT"."UK_NOMB_REFEN" ON "PDT"."FENOMENO" ("NOMBRE_FEN") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_IDOBSERVACION
--------------------------------------------------------

  CREATE UNIQUE INDEX "PDT"."PK_IDOBSERVACION" ON "PDT"."OBSERVACIONES" ("ID_OBSERVACION") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_EST_OBS
--------------------------------------------------------

  CREATE UNIQUE INDEX "PDT"."PK_EST_OBS" ON "PDT"."ESTADO_OBSERV" ("ID_ESTADO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index UK_NOMBRE_DEP
--------------------------------------------------------

  CREATE UNIQUE INDEX "PDT"."UK_NOMBRE_DEP" ON "PDT"."DEPARTAMENTO" ("NOMBRE_DEP") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table TELEFONO
--------------------------------------------------------

  ALTER TABLE "PDT"."TELEFONO" ADD CONSTRAINT "PK_TELEFONO" PRIMARY KEY ("ID_TEL")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
 
  ALTER TABLE "PDT"."TELEFONO" MODIFY ("ID_TEL" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table DEPARTAMENTO
--------------------------------------------------------

  ALTER TABLE "PDT"."DEPARTAMENTO" ADD CONSTRAINT "PK_DEPARTAMENTO" PRIMARY KEY ("ID_DEPARTAMENTO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
 
  ALTER TABLE "PDT"."DEPARTAMENTO" MODIFY ("ID_DEPARTAMENTO" NOT NULL ENABLE);
 
  ALTER TABLE "PDT"."DEPARTAMENTO" MODIFY ("NOMBRE_DEP" NOT NULL ENABLE);
 
  ALTER TABLE "PDT"."DEPARTAMENTO" ADD CONSTRAINT "UK_NOMBRE_DEP" UNIQUE ("NOMBRE_DEP")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table DETALLE
--------------------------------------------------------

  ALTER TABLE "PDT"."DETALLE" ADD CONSTRAINT "PK_CARCOBSERV" PRIMARY KEY ("ID_CARACT", "ID_OBSERVACION","FECHORA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
 
  ALTER TABLE "PDT"."DETALLE" MODIFY ("ID_CARACT" NOT NULL ENABLE);
 
  ALTER TABLE "PDT"."DETALLE" MODIFY ("ID_OBSERVACION" NOT NULL ENABLE);
 
  ALTER TABLE "PDT"."DETALLE" MODIFY ("VALORNUM" NOT NULL ENABLE);
 
  ALTER TABLE "PDT"."DETALLE" MODIFY ("VALORTEXTO" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table TIPOSUSUARIOS
--------------------------------------------------------

  ALTER TABLE "PDT"."TIPOSUSUARIOS" ADD CONSTRAINT "PK_TIPOUSU" PRIMARY KEY ("ID_TIPO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
 
  ALTER TABLE "PDT"."TIPOSUSUARIOS" MODIFY ("NOMBRE" NOT NULL ENABLE);
 
  ALTER TABLE "PDT"."TIPOSUSUARIOS" ADD CONSTRAINT "UK_NOMBRE" UNIQUE ("NOMBRE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table USUARIO
--------------------------------------------------------

  ALTER TABLE "PDT"."USUARIO" ADD CONSTRAINT "MAIL_CHECK" CHECK (MAIL LIKE '%@%._%') ENABLE;
 
  ALTER TABLE "PDT"."USUARIO" ADD CONSTRAINT "PK_USUARIO" PRIMARY KEY ("ID_USUARIO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
 
  ALTER TABLE "PDT"."USUARIO" MODIFY ("PASS" NOT NULL ENABLE);
 
  ALTER TABLE "PDT"."USUARIO" MODIFY ("USUARIO" NOT NULL ENABLE);
 
  
 
  ALTER TABLE "PDT"."USUARIO" MODIFY ("NOMBRE" NOT NULL ENABLE);
 
  ALTER TABLE "PDT"."USUARIO" MODIFY ("APELLIDO" NOT NULL ENABLE);
 
  ALTER TABLE "PDT"."USUARIO" MODIFY ("TIPODOC" NOT NULL ENABLE);
 
  ALTER TABLE "PDT"."USUARIO" MODIFY ("NUMERODOC" NOT NULL ENABLE);
 
  ALTER TABLE "PDT"."USUARIO" MODIFY ("DIRECCION" NOT NULL ENABLE);
 
  ALTER TABLE "PDT"."USUARIO" ADD CONSTRAINT "TIPODOC_CHECK" CHECK (TIPODOC ='CI' or TIPODOC = 'PASAPORTE' or TIPODOC='CARTA DE CIUDADANIA' or  TIPODOC='OTROS') ENABLE;
--------------------------------------------------------
--  Constraints for Table ZONA
--------------------------------------------------------

  ALTER TABLE "PDT"."ZONA" ADD CONSTRAINT "PK_ZONA" PRIMARY KEY ("ID_ZONA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
 
  ALTER TABLE "PDT"."ZONA" MODIFY ("ID_ZONA" NOT NULL ENABLE);
 
  ALTER TABLE "PDT"."ZONA" MODIFY ("NOMBRE_ZONA" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table CARACTERISTICAS
--------------------------------------------------------

  ALTER TABLE "PDT"."CARACTERISTICAS" ADD CONSTRAINT "PK_IDCARACTERISTICA" PRIMARY KEY ("ID_CARACT")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
 
  ALTER TABLE "PDT"."CARACTERISTICAS" MODIFY ("NOMBRE" NOT NULL ENABLE);
 
  ALTER TABLE "PDT"."CARACTERISTICAS" MODIFY ("ETIQUETA" NOT NULL ENABLE);
 
  ALTER TABLE "PDT"."CARACTERISTICAS" MODIFY ("TIPODATO" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table ESTADO_OBSERV
--------------------------------------------------------

  ALTER TABLE "PDT"."ESTADO_OBSERV" ADD CONSTRAINT "PK_EST_OBS" PRIMARY KEY ("ID_ESTADO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
 
  ALTER TABLE "PDT"."ESTADO_OBSERV" MODIFY ("NOMBRE" NOT NULL ENABLE);
 
  ALTER TABLE "PDT"."ESTADO_OBSERV" ADD CONSTRAINT "UK_ESTADO" UNIQUE ("NOMBRE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table OBSERVACIONES
--------------------------------------------------------

  ALTER TABLE "PDT"."OBSERVACIONES" ADD CONSTRAINT "PK_IDOBSERVACION" PRIMARY KEY ("ID_OBSERVACION")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
 
  ALTER TABLE "PDT"."OBSERVACIONES" MODIFY ("DESCRIPCION" NOT NULL ENABLE);
 
  ALTER TABLE "PDT"."OBSERVACIONES" MODIFY ("LATITUD" NOT NULL ENABLE);
 
  ALTER TABLE "PDT"."OBSERVACIONES" MODIFY ("LONGITUD" NOT NULL ENABLE);
 
  ALTER TABLE "PDT"."OBSERVACIONES" MODIFY ("ALTITUD" NOT NULL ENABLE);
 
  ALTER TABLE "PDT"."OBSERVACIONES" MODIFY ("ID_ESTADO" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table FENOMENO
--------------------------------------------------------

  ALTER TABLE "PDT"."FENOMENO" ADD CONSTRAINT "PK_CODIGOFEN" PRIMARY KEY ("CODIGO_FEN")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
 
  ALTER TABLE "PDT"."FENOMENO" MODIFY ("CODIGO_FEN" NOT NULL ENABLE);
  
  ALTER TABLE "PDT"."FENOMENO" MODIFY ("CODIGO" NOT NULL ENABLE);
 
  ALTER TABLE "PDT"."FENOMENO" MODIFY ("NOMBRE_FEN" NOT NULL ENABLE);
 
  ALTER TABLE "PDT"."FENOMENO" MODIFY ("DESCRIPCION" NOT NULL ENABLE);
 
  ALTER TABLE "PDT"."FENOMENO" ADD CONSTRAINT "UK_NOMB_REFEN" UNIQUE ("NOMBRE_FEN")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table LOCALIDAD
--------------------------------------------------------

  ALTER TABLE "PDT"."LOCALIDAD" ADD CONSTRAINT "PK_LOCALIDAD" PRIMARY KEY ("ID_LOCALIDAD")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
 
  ALTER TABLE "PDT"."LOCALIDAD" MODIFY ("ID_LOCALIDAD" NOT NULL ENABLE);
 
  ALTER TABLE "PDT"."LOCALIDAD" MODIFY ("NOMBRE_LOC" NOT NULL ENABLE);
 
  ALTER TABLE "PDT"."LOCALIDAD" MODIFY ("LATITUD" NOT NULL ENABLE);
 
  ALTER TABLE "PDT"."LOCALIDAD" MODIFY ("LONGITUD" NOT NULL ENABLE);
 
  ALTER TABLE "PDT"."LOCALIDAD" MODIFY ("ALTITUD" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table CARACTERISTICAS
--------------------------------------------------------

  ALTER TABLE "PDT"."CARACTERISTICAS" ADD CONSTRAINT "FK_CARAC_FENOMENO" FOREIGN KEY ("CODIGO_FEN")
	  REFERENCES "PDT"."FENOMENO" ("CODIGO_FEN") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table DEPARTAMENTO
--------------------------------------------------------

  ALTER TABLE "PDT"."DEPARTAMENTO" ADD CONSTRAINT "FK_IDZONA" FOREIGN KEY ("ID_ZONA")
	  REFERENCES "PDT"."ZONA" ("ID_ZONA") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table DETALLE
--------------------------------------------------------

  ALTER TABLE "PDT"."DETALLE" ADD CONSTRAINT "FK_CARAC_DETALLE" FOREIGN KEY ("ID_CARACT")
	  REFERENCES "PDT"."CARACTERISTICAS" ("ID_CARACT") ENABLE;
 
  ALTER TABLE "PDT"."DETALLE" ADD CONSTRAINT "FK_OBSERVACION_DETALLE" FOREIGN KEY ("ID_OBSERVACION")
	  REFERENCES "PDT"."OBSERVACIONES" ("ID_OBSERVACION") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table R
--------------------------------------------------------
ALTER TABLE "PDT"."REVISA" ADD CONSTRAINT "FK_EX_REV_" FOREIGN KEY ("ID_USUARIO")
	  REFERENCES "PDT"."USUARIO" ("ID_USUARIO") ENABLE;
 
ALTER TABLE "PDT"."REVISA" ADD CONSTRAINT "FK_REV_OBS" FOREIGN KEY ("ID_OBSERVACION")
	  REFERENCES "PDT"."OBSERVACIONES" ("ID_OBSERVACION") ENABLE;



--------------------------------------------------------

--  Ref Constraints for Table LOCALIDAD
--------------------------------------------------------

  ALTER TABLE "PDT"."LOCALIDAD" ADD CONSTRAINT "FK_LOCA_DPTO" FOREIGN KEY ("ID_DEPARTAMENTO")
	  REFERENCES "PDT"."DEPARTAMENTO" ("ID_DEPARTAMENTO") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table OBSERVACIONES
--------------------------------------------------------

  ALTER TABLE "PDT"."OBSERVACIONES" ADD CONSTRAINT "FK_ESTADO_OBS" FOREIGN KEY ("ID_ESTADO")
	  REFERENCES "PDT"."ESTADO_OBSERV" ("ID_ESTADO") ENABLE;
 
  ALTER TABLE "PDT"."OBSERVACIONES" ADD CONSTRAINT "FK_LOCALOBSERV" FOREIGN KEY ("ID_LOCALIDAD")
	  REFERENCES "PDT"."LOCALIDAD" ("ID_LOCALIDAD") ENABLE;
 
  ALTER TABLE "PDT"."OBSERVACIONES" ADD CONSTRAINT "FK_OBSFENOMENO" FOREIGN KEY ("CODIGO_FEN")
	  REFERENCES "PDT"."FENOMENO" ("CODIGO_FEN") ENABLE;
 
  ALTER TABLE "PDT"."OBSERVACIONES" ADD CONSTRAINT "FK_USU_OBSERVACION" FOREIGN KEY ("ID_USUARIO")
	  REFERENCES "PDT"."USUARIO" ("ID_USUARIO") ENABLE;
	  

--------------------------------------------------------
--  Ref Constraints for Table TELEFONO
--------------------------------------------------------

  ALTER TABLE "PDT"."TELEFONO" ADD CONSTRAINT "FK_TEL_FENOMENO" FOREIGN KEY ("CODIGO_FEN")
	  REFERENCES "PDT"."FENOMENO" ("CODIGO_FEN") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table USUARIO
--------------------------------------------------------

  ALTER TABLE "PDT"."USUARIO" ADD CONSTRAINT "FK_USU_TIPO" FOREIGN KEY ("ID_TIPO")
	  REFERENCES "PDT"."TIPOSUSUARIOS" ("ID_TIPO") ENABLE;
--------------------------------------------------------
--  DDL for Trigger TRIOBSERVACION
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "PDT"."TRIOBSERVACION" BEFORE INSERT ON PDT.OBSERVACIONES   FOR EACH ROW 
BEGIN SELECT SEQ_OBSERVACIONID.NEXTVAL INTO :new.ID_OBSERVACION FROM DUAL;  
 END;
 
/
ALTER TRIGGER "PDT"."TRIOBSERVACION" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TRIUSUARIOID
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "PDT"."TRIUSUARIOID" BEFORE INSERT ON PDT.USUARIO   FOR EACH ROW 
BEGIN SELECT SEQ_USUARIOID.NEXTVAL INTO :new.ID_USUARIO FROM DUAL; 
END;
/
ALTER TRIGGER "PDT"."TRIUSUARIOID" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TTRICARACTERISTICAS
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "PDT"."TTRICARACTERISTICAS" BEFORE INSERT ON PDT.CARACTERISTICAS   FOR EACH ROW 
BEGIN SELECT SEQ_CARACTERISTICASID.NEXTVAL INTO :new.ID_CARACT FROM DUAL;
 END;
/
ALTER TRIGGER "PDT"."TTRICARACTERISTICAS" ENABLE;



--------------------------------------------------------
--  DDL for Trigger TRIFENOMENO
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "PDT"."TRIFENOMENO" BEFORE INSERT ON PDT.FENOMENO   FOR EACH ROW 
BEGIN SELECT SEQ_CODIGOFENOMENO.NEXTVAL INTO :new.CODIGO_FEN FROM DUAL;
 END;
/
ALTER TRIGGER "PDT"."TRIFENOMENO" ENABLE;


--------------------------------------------------------
--  DDL for Trigger TRIZONA
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "PDT"."TRIZONA" BEFORE INSERT ON PDT.ZONA   FOR EACH ROW 
BEGIN SELECT SEQ_IDZONA.NEXTVAL INTO :new.ID_ZONA FROM DUAL;
 END;
/
ALTER TRIGGER "PDT"."TRIZONA" ENABLE;


--------------------------------------------------------
--  DDL for Trigger TRILOCALIDAD
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "PDT"."TRILOCALIDAD" BEFORE INSERT ON PDT.LOCALIDAD   FOR EACH ROW 
BEGIN SELECT SEQ_IDLOCALIDADID.NEXTVAL INTO :new.ID_LOCALIDAD FROM DUAL;
 END;
/
ALTER TRIGGER "PDT"."TRILOCALIDAD" ENABLE;


--------------------------------------------------------
--  DDL for Trigger TRIDEPARTAMENTO
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "PDT"."TRIDEPARTAMENTO" BEFORE INSERT ON PDT.DEPARTAMENTO   FOR EACH ROW 
BEGIN SELECT SEQ_IDDEPARTAMENTO.NEXTVAL INTO :new.ID_DEPARTAMENTO FROM DUAL;
 END;
/
ALTER TRIGGER "PDT"."TRILOCALIDAD" ENABLE;


CREATE SEQUENCE "PDT"."hibernate_sequence";


