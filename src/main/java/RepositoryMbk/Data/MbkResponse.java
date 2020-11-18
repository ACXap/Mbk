package RepositoryMbk.Data;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.Date;
import java.util.List;

public class MbkResponse {

    @JacksonXmlProperty(localName = "ВерсияФормата")
    public String Version;

    @JacksonXmlProperty(localName = "ДатаСписка")
    public Date CurrentDate;

    @JacksonXmlProperty(localName = "ДатаПредыдущегоСписка")
    public Date PreviousDate;

    @JacksonXmlElementWrapper(localName = "СписокАктуальныхРешений")
    @JacksonXmlProperty(localName = "Решение")
    public List<Decision> Mbk;
}