package RepositoryMvk.Data;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.Date;
import java.util.List;

public class PhysicalPerson {

    @JacksonXmlProperty(localName = "ФИО")
    public String Fio;

    @JacksonXmlProperty(localName = "Фамилия")
    public String Surname;

    @JacksonXmlProperty(localName = "Имя")
    public String Name;

    @JacksonXmlProperty(localName = "Отчество")
    public String Patronymic;

    @JacksonXmlProperty(localName = "ФИОЛат")
    public String FioLat;

    @JacksonXmlProperty(localName = "ДатаРождения")
    public String Birthday;

    @JacksonXmlProperty(localName = "ГодРождения")
    public String BirthYear;

    @JacksonXmlProperty(localName = "МестоРождения")
    public String BirthPlace;

    @JacksonXmlProperty(localName = "ИНН")
    public String Inn;

    @JacksonXmlProperty(localName = "СписокДокументов")
    public List<Documents> listDocuments;

    @JacksonXmlProperty(localName = "СписокДрНаименований")
    public List<OtherName> ListOtherName;

    public static class OtherName{
        @JacksonXmlProperty(localName = "ФИО")
        public String Fio;

        @JacksonXmlProperty(localName = "ДатаРождения")
        public String Birthday;

        @JacksonXmlProperty(localName = "ГодРождения")
        public String BirthYear;

        @JacksonXmlProperty(localName = "МестоРождения")
        public String BirthPlace;
    }

    public static class Documents {

        @JacksonXmlProperty(localName = "ТипДокумента")
        public TypeObject TypeDocuments;

        @JacksonXmlProperty(localName = "Серия")
        public String Series;

        @JacksonXmlProperty(localName = "Номер")
        public String Number;

        @JacksonXmlProperty(localName = "ОрганВыдачи")
        public String Organ;

        @JacksonXmlProperty(localName = "ДатаВыдачи")
        public Date Date;
    }
}