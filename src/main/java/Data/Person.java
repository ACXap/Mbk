package Data;

import RepositoryMbk.Data.Address;
import RepositoryMbk.Data.Subject;

import java.util.Date;
import java.util.List;

public abstract class Person {
    public static String SEPARATOR = ",";

    public Person(Subject person, Date dateDecision) {
        Id = person.Id;
        ListAddress = person.ListAddress;
        DateDecision = dateDecision;
        TextDecision = person.TextDecision;
        Note = person.Note;
        AllName = GetAllName(person);
    }

    public int Id;
    public List<Address> ListAddress;
    public Date DateDecision;
    public String TextDecision;
    public String Note;
    public String AllName;

    protected abstract String GetAllName(Subject person);
}