package RepositoryMbk.Data;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.Date;
import java.util.List;

public class Decision {

    @JacksonXmlProperty(localName = "ТипРешения")
    public TypeObject TypeDecision;

    @JacksonXmlProperty(localName = "НомерРешения")
    public String Number;

    @JacksonXmlProperty(localName = "ДатаРешения")
    public Date Date;

    @JacksonXmlProperty(localName = "Орган")
    public String Organ;

    @JacksonXmlProperty(localName = "ВидРешения")
    public TypeObject ViewDecision;

    @JacksonXmlElementWrapper(localName = "СписокСубъектов")
    @JacksonXmlProperty(localName = "Субъект")
    public List<Subject> CollectionSubject;
}