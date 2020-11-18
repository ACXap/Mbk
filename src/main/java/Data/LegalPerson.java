package Data;

import RepositoryMbk.Data.Subject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class LegalPerson extends Person {

    public LegalPerson(Subject person, Date dateDecision) {
        super(person, dateDecision);

        Inn  = person.Ul.Inn;
        Ogrn = person.Ul.Ogrn;
        DateRegistr = person.Ul.DateRegistr;
        PlaceRegistr = person.Ul.PlaceRegistr;
    }

    public static List<LegalPerson> ConvertSubjectToLegalPerson(List<Subject> person, Date dateDecision) {
        return person.parallelStream().filter(p -> p.Ul != null).map(p -> new LegalPerson(p, dateDecision)).collect(Collectors.toList());
    }

    public String Inn;
    public String Ogrn;
    public Date DateRegistr;
    public String PlaceRegistr;

    @Override
    protected String GetAllName(Subject person) {
        List<String> names = new ArrayList<>();
        RepositoryMbk.Data.LegalPerson ul = person.Ul;

        names.add(ul.Name);

        if (!ul.NamLat.equals(ul.Name)) {
            names.add(ul.NamLat);
        }

        if (ul.ListOtherName != null && !ul.ListOtherName.isEmpty()) {
            names.addAll(ul.ListOtherName.stream().filter(p -> p.Name != null && !p.Name.isEmpty()).map(p -> p.Name).distinct().collect(Collectors.toList()));
        }

        return names.stream().distinct().collect(Collectors.joining(SEPARATOR));
    }
}