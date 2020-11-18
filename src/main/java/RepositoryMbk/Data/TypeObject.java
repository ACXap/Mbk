package RepositoryMbk.Data;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class TypeObject {
    @JacksonXmlProperty(localName = "Идентификатор")

    public int Id;
    @JacksonXmlProperty(localName = "Наименование")
    public String Name;
}