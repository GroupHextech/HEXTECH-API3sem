-- CREATE DATABASE
CREATE DATABASE ioweather
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

-- CREATE TABLES
-- Table: CHUVARADIA
CREATE TABLE CHUVARADIA (
    ID_CHRAD int  NOT NULL,
    CHUVA decimal(5,1)  NOT NULL,
    RADIACAO_GL decimal(10,1)  NOT NULL,
    CONSTRAINT PK_CHUVARADIA_IDCHRAD PRIMARY KEY (ID_CHRAD)
);

-- Table: DATAHORA
CREATE TABLE DATAHORA (
    ID_DTHR int  NOT NULL,
    DATA date  NOT NULL,
    HORA time  NOT NULL,
    CONSTRAINT PK_DATAHORA_IDDTHR PRIMARY KEY (ID_DTHR)
);

-- Table: ESTACAO
CREATE TABLE ESTACAO (
	ID_ESTACAO int NOT NULL,
    ESTACAOWMO varchar(10)  NOT NULL,
    NOME_ESTACAO varchar(50)  NOT NULL,
    LATITUDE decimal(11,8)  NOT NULL,
    LONGITUDE decimal(11,8)  NOT NULL,
    ALTITUDE decimal(10,2)  NOT NULL,
    ID_ESTADO_ESTACAO int  NOT NULL,
    DATA_FUNDACAO date  NOT NULL,
    CONSTRAINT PK_ESTACAO_ESTACAOWMO PRIMARY KEY (ESTACAO_WMO)
);

-- Table: ESTADO
CREATE TABLE ESTADO (
    ID_ESTADO int  NOT NULL,
    NOME_ESTADO varchar(50)  NOT NULL,
    SIGLA_ESTADO varchar(2)  NOT NULL,
    ID_REGIAO_ESTADO int  NOT NULL,
    CONSTRAINT PK_ESTADO_IDESTADO PRIMARY KEY (ID_ESTADO)
);

-- Table: PRESSAOATM
CREATE TABLE PRESSAOATM (
    ID_PRESSATM int  NOT NULL,
    PRESSAO_ATMESTACAO decimal(5,1)  NOT NULL,
    PRESSAO_ATMMAX decimal(5,1)  NOT NULL,
    PRESSAO_ATMMIN decimal(5,1)  NOT NULL,
    CONSTRAINT PK_PRESSAOATM_IDPRESSAOATM PRIMARY KEY (ID_PRESSATM)
);

-- Table: REGIAO
CREATE TABLE REGIAO (
    ID_REGIAO int  NOT NULL,
    NOME_REGIAO varchar(50)  NOT NULL,
    SIGLA_REGIAO varchar(2)  NOT NULL,
    CONSTRAINT PK_REGIAO_IDREGIAO PRIMARY KEY (ID_REGIAO)
);

-- Table: REGISTRO
CREATE TABLE REGISTRO (
    ID_REGISTRO int  NOT NULL,
    ID_REG_ESTACAO varchar(10)  NOT NULL,
    ID_REG_DTHR int  NOT NULL,
    ID_REG_CHUVA int  NOT NULL,
    ID_REG_TEMPAR int  NOT NULL,
    ID_REG_TEMPORV int  NOT NULL,
    ID_REG_PRESATM int  NOT NULL,
    ID_REG_VENTO int  NOT NULL,
    ID_REG_UMIDADE int  NOT NULL,
    CONSTRAINT PK_REGISTRO_IDREGISTRO PRIMARY KEY (ID_REGISTRO)
);

-- Table: TEMPAR
CREATE TABLE TEMPAR (
    ID_TEMPAR int  NOT NULL,
    TEMP_ARBULBOSECO decimal(5,1)  NOT NULL,
    TEMP_ARMAX decimal(5,1)  NOT NULL,
    TEMP_ARMIN decimal(5,1)  NOT NULL,
    CONSTRAINT PK_TEMPAR_IDTEMPAR PRIMARY KEY (ID_TEMPAR)
);

-- Table: TEMPORVALHO
CREATE TABLE TEMPORVALHO (
    ID_TEMPORV int  NOT NULL,
    TEMP_ORVPONTO decimal(5,1)  NOT NULL,
    TEMP_ORVALHOMAX decimal(5,1)  NOT NULL,
    TEMP_ORVALHOMIN decimal(5,1)  NOT NULL,
    CONSTRAINT PK_TEMPORVALHO_IDTEMPORV PRIMARY KEY (ID_TEMPORV)
);

-- Table: UMIDADE
CREATE TABLE UMIDADE (
    ID_UMIDADE int  NOT NULL,
    UMIDA_RELAR int  NOT NULL,
    UMIDADEMAX int  NOT NULL,
    UMIDADEMIN int  NOT NULL,
    CONSTRAINT PK_UMIDADE_IDUMIDADE PRIMARY KEY (ID_UMIDADE)
);

-- Table: VENTO
CREATE TABLE VENTO (
    ID_VENTO int  NOT NULL,
    VENTO_DIRECAOGRHR int  NOT NULL,
    VENTO_RAJMAX decimal(5,1)  NOT NULL,
    VENTO_VELOHR decimal(5,1)  NOT NULL,
    CONSTRAINT PK_VENTO_IDVENTO PRIMARY KEY (ID_VENTO)
);

-- FOREIGN KEYS
-- Reference: ESTACAO_ESTADO (table: ESTACAO)
ALTER TABLE ESTACAO ADD CONSTRAINT ESTACAO_ESTADO
    FOREIGN KEY (ID_ESTADO_ESTACAO)
    REFERENCES ESTADO (ID_ESTADO)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: ESTADO_REGIAO (table: ESTADO)
ALTER TABLE ESTADO ADD CONSTRAINT ESTADO_REGIAO
    FOREIGN KEY (ID_REGIAO_ESTADO)
    REFERENCES REGIAO (ID_REGIAO)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: REGISTRO_CHUVARADIA (table: REGISTRO)
ALTER TABLE REGISTRO ADD CONSTRAINT REGISTRO_CHUVARADIA
    FOREIGN KEY (ID_REG_CHUVA)
    REFERENCES CHUVARADIA (ID_CHRAD)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: REGISTRO_DATAHORA (table: REGISTRO)
ALTER TABLE REGISTRO ADD CONSTRAINT REGISTRO_DATAHORA
    FOREIGN KEY (ID_REG_DTHR)
    REFERENCES DATAHORA (ID_DTHR)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: REGISTRO_ESTACAO (table: REGISTRO)
ALTER TABLE REGISTRO ADD CONSTRAINT REGISTRO_ESTACAO
    FOREIGN KEY (ID_REG_ESTACAO)
    REFERENCES ESTACAO (ESTACAO_WMO)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: REGISTRO_PRESSAOATM (table: REGISTRO)
ALTER TABLE REGISTRO ADD CONSTRAINT REGISTRO_PRESSAOATM
    FOREIGN KEY (ID_REG_PRESATM)
    REFERENCES PRESSAOATM (ID_PRESSATM)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: REGISTRO_TEMPAR (table: REGISTRO)
ALTER TABLE REGISTRO ADD CONSTRAINT REGISTRO_TEMPAR
    FOREIGN KEY (ID_REG_TEMPAR)
    REFERENCES TEMPAR (ID_TEMPAR)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: REGISTRO_TEMPORVALHO (table: REGISTRO)
ALTER TABLE REGISTRO ADD CONSTRAINT REGISTRO_TEMPORVALHO
    FOREIGN KEY (ID_REG_TEMPORV)
    REFERENCES TEMPORVALHO (ID_TEMPORV)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: REGISTRO_UMIDADE (table: REGISTRO)
ALTER TABLE REGISTRO ADD CONSTRAINT REGISTRO_UMIDADE
    FOREIGN KEY (ID_REG_UMIDADE)
    REFERENCES UMIDADE (ID_UMIDADE)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: REGISTRO_VENTO (table: REGISTRO)
ALTER TABLE REGISTRO ADD CONSTRAINT REGISTRO_VENTO
    FOREIGN KEY (ID_REG_VENTO)
    REFERENCES VENTO (ID_VENTO)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- SEQUENCES
-- Sequence: CHUVARADIA_IDCHRAD_seq
CREATE SEQUENCE CHUVARADIA_IDCHRAD_seq
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      START WITH 1
      NO CYCLE
;
ALTER TABLE CHUVARADIA ALTER COLUMN ID_CHRAD SET DEFAULT NEXTVAL('CHUVARADIA_IDCHRAD_seq'::regclass);

-- Sequence: DATAHORA_IDDTHR_seq
CREATE SEQUENCE DATAHORA_IDDTHR_seq
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      START WITH 1
      NO CYCLE
;
ALTER TABLE DATAHORA ALTER COLUMN ID_DTHR SET DEFAULT NEXTVAL('DATAHORA_IDDTHR_seq'::regclass);

-- Sequence: ESTACAO_IDESTACAO_seq
CREATE SEQUENCE ESTACAO_IDESTACAO_seq
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      START WITH 1
      NO CYCLE
;	
ALTER TABLE ESTACAO ALTER COLUMN ID_ESTACAO SET DEFAULT NEXTVAL('ESTACAO_IDESTACAO_seq'::regclass);

-- Sequence: ESTADO_IDESTADO_seq
CREATE SEQUENCE ESTADO_IDESTADO_seq
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      START WITH 1
      NO CYCLE
;
ALTER TABLE ESTADO ALTER COLUMN ID_ESTADO SET DEFAULT NEXTVAL('ESTADO_IDESTADO_seq'::regclass);

-- Sequence: PRESSAOATM_IDPRESSATM_seq
CREATE SEQUENCE PRESSAOATM_IDPRESSATM_seq
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      START WITH 1
      NO CYCLE
;
ALTER TABLE PRESSAOATM ALTER COLUMN ID_PRESSATM SET DEFAULT NEXTVAL('PRESSAOATM_IDPRESSATM_seq'::regclass);

-- Sequence: REGIAO_IDREGIAO_seq
CREATE SEQUENCE REGIAO_IDREGIAO_seq
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      START WITH 1
      NO CYCLE
;
ALTER TABLE REGIAO ALTER COLUMN ID_REGIAO SET DEFAULT NEXTVAL('REGIAO_IDREGIAO_seq'::regclass);

-- Sequence: REGISTRO_IDREGISTRO_seq
CREATE SEQUENCE REGISTRO_IDREGISTRO_seq
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      START WITH 1
      NO CYCLE
;
ALTER TABLE REGISTRO ALTER COLUMN ID_REGISTRO SET DEFAULT NEXTVAL('REGISTRO_IDREGISTRO_seq'::regclass);

-- Sequence: TEMPAR_IDTEMPAR_seq
CREATE SEQUENCE TEMPAR_IDTEMPAR_seq
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      START WITH 1
      NO CYCLE
;
ALTER TABLE TEMPAR ALTER COLUMN ID_TEMPAR SET DEFAULT NEXTVAL('TEMPAR_IDTEMPAR_seq'::regclass);

-- Sequence: TEMPORVALHO_IDTEMPORV_seq
CREATE SEQUENCE TEMPORVALHO_IDTEMPORV_seq
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      START WITH 1
      NO CYCLE
;
ALTER TABLE TEMPORVALHO ALTER COLUMN ID_TEMPORV SET DEFAULT NEXTVAL('TEMPORVALHO_IDTEMPORV_seq'::regclass);

-- Sequence: UMIDADE_IDUMIDADE_seq
CREATE SEQUENCE UMIDADE_IDUMIDADE_seq
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      START WITH 1
      NO CYCLE
;
ALTER TABLE UMIDADE ALTER COLUMN ID_UMIDADE SET DEFAULT NEXTVAL('UMIDADE_IDUMIDADE_seq'::regclass);

-- Sequence: VENTO_IDVENTO_seq
CREATE SEQUENCE VENTO_IDVENTO_seq
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      START WITH 1
      NO CYCLE
;
ALTER TABLE VENTO ALTER COLUMN ID_VENTO SET DEFAULT NEXTVAL('VENTO_IDVENTO_seq'::regclass);

-- INSERTS DATABASE INICIAL
INSERT INTO regiao (nome_regiao,sigla_regiao)
VALUES 	('NORTE','N'),
		('NORDESTE','NE'),
		('NOROESTE','NO'),
		('CENTRO-OESTE','CO'),
		('LESTE','L'),
		('OESTE','O'),
		('SUL','S'),
		('SUDESTE','SU'),
		('SUDOESTE','SO');

INSERT INTO estado (nome_estado,sigla_estado,id_regiao_estado) 
VALUES	('Acre','AC',1),
		('Amapá','AP',1),
		('Amazonas','AM',1),
		('Pará','PA',1),
		('Rondônia','RO',1),
		('Roraima','RR',1),
		('Tocantins','TO',1),
		('Alagoas','AL',2),
		('Bahia','BA',2),
		('Ceará','CE',2),
		('Maranhão','MA',2),
		('Paraíba','PB',2),
		('Pernambuco','PE',2),
		('Piauí','PI',2),
		('Rio Grande do Norte','RN',2),
		('Sergipe','SE',2),
		('Distrito Federal','DF',4),
		('Goiás','GO',4),
		('Mato Grosso','MT',4),
		('Mato Grosso do Sul','MS',4),
		('Paraná','PR',7),
		('Rio Grande do sul','RS',7),
		('Santa Catarina','SC',7),
		('Espírito Santo','ES',8),
		('Minas Gerais','MG',8),
		('Rio de Janeiro','RJ',8),
		('São Paulo','SP',8);




-- End of file.
