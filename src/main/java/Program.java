import Data.LegalPerson;
import Data.Person;
import Data.PhysicalPerson;
import Db.DataSaveRepositoryDb;
import Interfaces.IRepositoryMvk;
import RepositoryMvk.Data.MvkResponse;
import RepositoryMvk.FactoryRepository;
import RepositoryMvk.RepositoryFile;
import Service.PropertyService;

import java.util.ArrayList;
import java.util.List;


public class Program {
    public static void main(String[] args) throws Exception {

        PropertyService.Initialization();
        Person.SEPARATOR = PropertyService.DbSeparator;

        IRepositoryMvk rf = new FactoryRepository().GetRepository(args);
        MvkResponse mvkResponse = rf.GetResponse();

        List<PhysicalPerson> physicalPersons = new ArrayList<>();
        List<LegalPerson> legalPerson = new ArrayList<>();

        mvkResponse.Mbk.forEach(d -> {
            physicalPersons.addAll(PhysicalPerson.ConvertSubjectToPhysicalPerson(d.CollectionSubject, d.Date));
            legalPerson.addAll(LegalPerson.ConvertSubjectToLegalPerson(d.CollectionSubject, d.Date));
        });

        DataSaveRepositoryDb db = new DataSaveRepositoryDb(PropertyService.DbConnectProperty);

        db.DeleteData();
        db.AddLegalPerson(legalPerson);
        db.AddPhysicalPerson(physicalPersons);
    }
}