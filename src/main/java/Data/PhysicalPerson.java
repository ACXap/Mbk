package Data;

import RepositoryMvk.Data.Subject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class PhysicalPerson extends Person {

    public PhysicalPerson(Subject person, Date dateDecision) {
        super(person, dateDecision);

        AllBirthday = GetAllBirthday(person.Fl);
        Documents = person.Fl.listDocuments;
        AllBirthPlace = GetAllBirthPlace(person.Fl);
        Inn = person.Fl.Inn;
    }

    public static List<PhysicalPerson> ConvertSubjectToPhysicalPerson(List<Subject> person, Date dateDecision) {
        return person.parallelStream().filter(p -> p.Fl != null).map(p -> new PhysicalPerson(p, dateDecision)).collect(Collectors.toList());
    }

    public final String AllBirthday;
    public final String AllBirthPlace;
    public final String Inn;
    public final List<RepositoryMvk.Data.PhysicalPerson.Documents> Documents;

    @Override
    protected String GetAllName(Subject person) {
        List<String> names = new ArrayList<>();
        RepositoryMvk.Data.PhysicalPerson fl = person.Fl;

        names.add(fl.Fio);

        if (!fl.FioLat.equals(fl.Fio)) {
            names.add(fl.FioLat);
        }

        if (fl.ListOtherName != null && !fl.ListOtherName.isEmpty()) {
            names.addAll(fl.ListOtherName.stream().filter(p -> p.Fio != null && !p.Fio.isEmpty()).map(p -> p.Fio).distinct().collect(Collectors.toList()));
        }

        return names.stream().distinct().collect(Collectors.joining(SEPARATOR));
    }

    private String GetAllBirthday(RepositoryMvk.Data.PhysicalPerson fl) {
        List<String> birthdays = new ArrayList<>();

        if (fl.Birthday != null) {
            birthdays.add(fl.Birthday);

            if (!fl.Birthday.equals(fl.BirthYear)) {
                birthdays.add(fl.BirthYear);
            }
        }

        if (fl.ListOtherName != null && !fl.ListOtherName.isEmpty()) {
            birthdays.addAll(fl.ListOtherName.stream().filter(p -> p.Birthday != null && !p.Birthday.isEmpty()).map(p -> p.Birthday).distinct().collect(Collectors.toList()));
            birthdays.addAll(fl.ListOtherName.stream().filter(p -> p.BirthYear != null && !p.BirthYear.isEmpty()).map(p -> p.BirthYear).distinct().collect(Collectors.toList()));
        }

        if (birthdays.size() > 0) return birthdays.stream().distinct().collect(Collectors.joining(SEPARATOR));
        return null;
    }

    private String GetAllBirthPlace(RepositoryMvk.Data.PhysicalPerson fl) {
        List<String> birthPlace = new ArrayList<>();

        if (fl.BirthPlace != null && !fl.BirthPlace.isEmpty()) {
            birthPlace.add(fl.BirthPlace);
        }

        if (fl.ListOtherName != null && !fl.ListOtherName.isEmpty()) {
            birthPlace.addAll(fl.ListOtherName.stream().filter(p -> p.BirthPlace != null && !p.BirthPlace.isEmpty()).map(p -> p.BirthPlace).distinct().collect(Collectors.toList()));
        }

        if (birthPlace.size() > 0) return birthPlace.stream().distinct().collect(Collectors.joining(SEPARATOR));
        return null;
    }
}