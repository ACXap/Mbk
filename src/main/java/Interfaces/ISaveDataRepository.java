package Interfaces;

import Data.LegalPerson;
import Data.PhysicalPerson;

import java.sql.SQLException;
import java.util.List;

public interface ISaveDataRepository {

    void AddLegalPerson(List<LegalPerson> persons) throws SQLException;

    void AddPhysicalPerson(List<PhysicalPerson> persons) throws SQLException;
}