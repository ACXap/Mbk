-- Drop table

-- DROP TABLE cdi.mvk_physical_document;

CREATE TABLE cdi.mvk_physical_document (
	id serial NOT NULL, -- Идентификатор записи документа физ. лица
	list_id int4 NOT NULL, -- Идентификатор записи физ. лица из источника
	type_id int4 NULL, -- Идентификатор типа документа
	"serial" varchar NULL, -- Серийнй номер документа
	"number" varchar NULL, -- Номер документа
	organ varchar NULL, -- Орган выдавший документ
	date_issue date NULL, -- Дата выдачи документа
	document_type varchar NULL, -- Тип документа
	person_id int4 NULL, -- Идентификатор записи физ. лица
	doc_actual_date date NULL DEFAULT CURRENT_DATE -- Дата создания записи в MDS
);
COMMENT ON TABLE cdi.mvk_physical_document IS 'Таблица документов физических лиц';

-- Column comments

COMMENT ON COLUMN cdi.mvk_physical_document.id IS 'Идентификатор записи документа физ. лица';
COMMENT ON COLUMN cdi.mvk_physical_document.list_id IS 'Идентификатор записи физ. лица из источника';
COMMENT ON COLUMN cdi.mvk_physical_document.type_id IS 'Идентификатор типа документа';
COMMENT ON COLUMN cdi.mvk_physical_document."serial" IS 'Серийнй номер документа';
COMMENT ON COLUMN cdi.mvk_physical_document."number" IS 'Номер документа';
COMMENT ON COLUMN cdi.mvk_physical_document.organ IS 'Орган выдавший документ';
COMMENT ON COLUMN cdi.mvk_physical_document.date_issue IS 'Дата выдачи документа';
COMMENT ON COLUMN cdi.mvk_physical_document.document_type IS 'Тип документа';
COMMENT ON COLUMN cdi.mvk_physical_document.person_id IS 'Идентификатор записи физ. лица';
COMMENT ON COLUMN cdi.mvk_physical_document.doc_actual_date IS 'Дата создания записи в MDS';
