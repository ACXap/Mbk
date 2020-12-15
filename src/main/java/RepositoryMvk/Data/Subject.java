package RepositoryMvk.Data;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

public class Subject {

    @JacksonXmlProperty(localName = "ИдСубъекта")
    public int Id;

    @JacksonXmlProperty(localName = "ТипСубъекта")
    public TypeObject TypeSubject;

    @JacksonXmlProperty(localName = "ФЛ")
    public PhysicalPerson Fl;

    @JacksonXmlProperty(localName = "ЮЛ")
    public LegalPerson Ul;

    @JacksonXmlProperty(localName = "СписокАдресов")
    public List<Address> ListAddress;

    @JacksonXmlProperty(localName = "РешениеПоСубъекту")
    public String TextDecision;

    @JacksonXmlProperty(localName = "Примечание")
    public String Note;
}