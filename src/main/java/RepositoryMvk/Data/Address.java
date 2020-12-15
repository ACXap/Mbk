package RepositoryMvk.Data;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Address {

    @JacksonXmlProperty(localName = "ТипАдреса")
    public TypeObject TypeAddress;

    @JacksonXmlProperty(localName = "ТекстАдреса")
    public String TextAddress;

    @JacksonXmlProperty(localName = "Страна")
    public Country Country;

    @JacksonXmlProperty(localName = "ОКАТО")
    public String Okato;

    @JacksonXmlProperty(localName = "Индекс")
    public String Index;

    public static class Country{

        @JacksonXmlProperty(localName = "Код")
        public String Code;

        @JacksonXmlProperty(localName = "Наименование")
        public String Name;
    }
}
