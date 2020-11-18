import Data.LegalPerson;
import Data.Person;
import Data.PhysicalPerson;
import Db.DataSaveRepositoryDb;
import RepositoryMbk.Data.MbkResponse;
import RepositoryMbk.RepositoryFile;
import Service.PropertyService;

import java.util.ArrayList;
import java.util.List;


public class Program {
    public static void main(String[] args) throws Exception {

        PropertyService.Initialization();
        Person.SEPARATOR = PropertyService.DbSeparator;

        RepositoryFile rf = new RepositoryFile(PropertyService.PathTempFile);
        MbkResponse mbkResponse = rf.GetResponse("temp/" + "mbk.xml");

        List<PhysicalPerson> physicalPersons = new ArrayList<>();
        List<LegalPerson> legalPerson = new ArrayList<>();

        mbkResponse.Mbk.forEach(d->{
            physicalPersons.addAll(PhysicalPerson.ConvertSubjectToPhysicalPerson(d.CollectionSubject, d.Date));
            legalPerson.addAll(LegalPerson.ConvertSubjectToLegalPerson(d.CollectionSubject, d.Date));
        });


        DataSaveRepositoryDb db = new DataSaveRepositoryDb(PropertyService.DbConnectProperty);

      db.AddLegalPerson(legalPerson);
      db.AddPhysicalPerson(physicalPersons);

    }
}