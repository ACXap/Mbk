-- Drop table

-- DROP TABLE cdi.mvk_physical;

CREATE TABLE cdi.mvk_physical (
	id int4 NOT NULL DEFAULT nextval('cdi.mvk_common_id_seq'::regclass), -- Идентификатор записи физ. лица
	list_id int4 NULL, -- Идентификатор записи физ.лица из источника
	all_names varchar NULL, -- Все имена
	all_birthdates varchar NULL, -- Все даты рождения
	all_birthplaces varchar NULL, -- Все места рождения
	inn varchar NULL, -- ИНН
	date_decision date NULL, -- Дата решения
	text_decision varchar NULL, -- Текст решения
	note varchar NULL, -- Примечание
	changedate date NULL DEFAULT CURRENT_DATE -- Дата создания записи в MDS
);
COMMENT ON TABLE cdi.mvk_physical IS 'Таблица физических лиц
Стоп-лист Межведомственной комиссии РосФинМонторинга';

-- Column comments

COMMENT ON COLUMN cdi.mvk_physical.id IS 'Идентификатор записи физ. лица';
COMMENT ON COLUMN cdi.mvk_physical.list_id IS 'Идентификатор записи физ.лица из источника';
COMMENT ON COLUMN cdi.mvk_physical.all_names IS 'Все имена';
COMMENT ON COLUMN cdi.mvk_physical.all_birthdates IS 'Все даты рождения';
COMMENT ON COLUMN cdi.mvk_physical.all_birthplaces IS 'Все места рождения';
COMMENT ON COLUMN cdi.mvk_physical.inn IS 'ИНН';
COMMENT ON COLUMN cdi.mvk_physical.date_decision IS 'Дата решения';
COMMENT ON COLUMN cdi.mvk_physical.text_decision IS 'Текст решения';
COMMENT ON COLUMN cdi.mvk_physical.note IS 'Примечание';
COMMENT ON COLUMN cdi.mvk_physical.changedate IS 'Дата создания записи в MDS';
