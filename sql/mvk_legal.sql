-- Drop table

-- DROP TABLE cdi.mvk_legal;

CREATE TABLE cdi.mvk_legal (
	id int4 NOT NULL DEFAULT nextval('cdi.mvk_common_id_seq'::regclass), -- Идентификатор записи юр. лица
	list_id int4 NULL, -- Идентификатор записи юр. лица из источника
	all_names varchar NULL, -- Все названия
	inn varchar NULL, -- ИНН
	ogrn varchar NULL, -- ОГРН
	date_registration date NULL, -- Дата регистрации
	place_registration varchar NULL, -- Место регистрации
	date_decision date NULL, -- Дата решения
	text_decision varchar NULL, -- Текст решения
	note varchar NULL, -- Примечание
	changedate date NULL DEFAULT CURRENT_DATE -- Дата создания записи в MDS
);
COMMENT ON TABLE cdi.mvk_legal IS 'Таблица юридических лиц
Стоп-лист Межведомственной комиссии РосФинМонторинга';

-- Column comments

COMMENT ON COLUMN cdi.mvk_legal.id IS 'Идентификатор записи юр. лица';
COMMENT ON COLUMN cdi.mvk_legal.list_id IS 'Идентификатор записи юр. лица из источника';
COMMENT ON COLUMN cdi.mvk_legal.all_names IS 'Все названия';
COMMENT ON COLUMN cdi.mvk_legal.inn IS 'ИНН';
COMMENT ON COLUMN cdi.mvk_legal.ogrn IS 'ОГРН';
COMMENT ON COLUMN cdi.mvk_legal.date_registration IS 'Дата регистрации';
COMMENT ON COLUMN cdi.mvk_legal.place_registration IS 'Место регистрации';
COMMENT ON COLUMN cdi.mvk_legal.date_decision IS 'Дата решения';
COMMENT ON COLUMN cdi.mvk_legal.text_decision IS 'Текст решения';
COMMENT ON COLUMN cdi.mvk_legal.note IS 'Примечание';
COMMENT ON COLUMN cdi.mvk_legal.changedate IS 'Дата создания записи в MDS';
