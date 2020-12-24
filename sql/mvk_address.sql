-- Drop table

-- DROP TABLE cdi.mvk_address;

CREATE TABLE cdi.mvk_address (
	id serial NOT NULL, -- Идентификатор записи адреса
	list_id int4 NOT NULL, -- Идентификатор записи лица из источника
	type_id int4 NULL, -- Идентификатор типа адреса
	text_address varchar NULL, -- Текст адреса
	country_id varchar NULL, -- Идентификатор страны
	okato varchar NULL, -- ОКАТО
	"index" varchar NULL, -- ИНДЕКС
	address_type varchar NULL, -- Тип адреса
	person_id int4 NULL, -- Идентификатор записи лица
	addr_actual_date date NULL DEFAULT CURRENT_DATE, -- Дата создания записи в MDS
	country_name varchar NULL, -- Наименование страны
	CONSTRAINT mvk_address_pk PRIMARY KEY (id)
);
COMMENT ON TABLE cdi.mvk_address IS 'Таблица адресов';

-- Column comments

COMMENT ON COLUMN cdi.mvk_address.id IS 'Идентификатор записи адреса';
COMMENT ON COLUMN cdi.mvk_address.list_id IS 'Идентификатор записи лица из источника';
COMMENT ON COLUMN cdi.mvk_address.type_id IS 'Идентификатор типа адреса';
COMMENT ON COLUMN cdi.mvk_address.text_address IS 'Текст адреса';
COMMENT ON COLUMN cdi.mvk_address.country_id IS 'Идентификатор страны';
COMMENT ON COLUMN cdi.mvk_address.okato IS 'ОКАТО';
COMMENT ON COLUMN cdi.mvk_address."index" IS 'ИНДЕКС';
COMMENT ON COLUMN cdi.mvk_address.address_type IS 'Тип адреса';
COMMENT ON COLUMN cdi.mvk_address.person_id IS 'Идентификатор записи лица';
COMMENT ON COLUMN cdi.mvk_address.addr_actual_date IS 'Дата создания записи в MDS';
COMMENT ON COLUMN cdi.mvk_address.country_name IS 'Наименование страны';