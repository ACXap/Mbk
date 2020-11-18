package Db;

import Data.DbConnectProperty;
import Data.LegalPerson;
import Data.Person;
import Data.PhysicalPerson;
import Interfaces.ISaveDataRepository;
import RepositoryMbk.Data.Address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class DataSaveRepositoryDb implements ISaveDataRepository {

    public DataSaveRepositoryDb(DbConnectProperty dbConnectProperty) throws Exception {
        _dbConnectProperty = dbConnectProperty;
        _queryGenerator = _dbConnectProperty.GetQueryGenerator();
    }

    //region PrivateField
    protected final QueryGenerator _queryGenerator;
    protected final DbConnectProperty _dbConnectProperty;
    //endregion PrivateField

    @Override
    public void AddLegalPerson(List<LegalPerson> persons) throws SQLException {
        Connection con = _dbConnectProperty.GetConnection();

        try {
            con.setAutoCommit(false);

            AddLegal(persons, con);
            AddAddress(persons, con);

            con.commit();
        } catch (SQLException sex) {
            con.rollback();
            con.close();
            throw sex;
        } finally {
            con.close();
        }
    }

    @Override
    public void AddPhysicalPerson(List<PhysicalPerson> persons) throws SQLException {
        Connection con = _dbConnectProperty.GetConnection();

        try {
            con.setAutoCommit(false);

            AddPhysical(persons, con);
            AddPhysicalDocument(persons, con);
            AddAddress(persons, con);

            con.commit();
        } catch (SQLException sex) {
            con.rollback();
            con.close();
            throw sex;
        } finally {
            con.close();
        }
    }

    private void AddPhysicalDocument(List<PhysicalPerson> persons, Connection con) throws SQLException {
        String query = _queryGenerator.GetQueryInsertPhysicalDocuments();

        try (PreparedStatement ps = con.prepareStatement(query)) {

            for (PhysicalPerson p : persons) {
                if (p.Documents == null || p.Documents.isEmpty()) continue;

                for (RepositoryMbk.Data.PhysicalPerson.Documents d : p.Documents) {
                    int parameterIndex = 1;

                    ps.setInt(parameterIndex++, p.Id);
                    ps.setInt(parameterIndex++, d.TypeDocuments.Id);
                    ps.setString(parameterIndex++, d.Series);
                    ps.setString(parameterIndex++, d.Number);
                    ps.setString(parameterIndex++, d.Organ);
                    ps.setObject(parameterIndex, GetSqlDate(d.Date));

                    ps.addBatch();
                }
            }

            ps.executeBatch();
        }
    }

    private void AddPhysical(List<PhysicalPerson> persons, Connection con) throws SQLException {
        String query = _queryGenerator.GetQueryInsertPhysical();

        try (PreparedStatement ps = con.prepareStatement(query)) {

            for (PhysicalPerson p : persons) {

                int parameterIndex = 1;
                ps.setInt(parameterIndex++, p.Id);
                ps.setString(parameterIndex++, p.AllName);
                ps.setString(parameterIndex++, p.AllBirthday);
                ps.setString(parameterIndex++, p.AllBirthPlace);
                ps.setString(parameterIndex++, p.Inn);
                ps.setObject(parameterIndex++, GetSqlDate(p.DateDecision));
                ps.setString(parameterIndex++, p.TextDecision);
                ps.setString(parameterIndex, p.Note);

                ps.addBatch();
            }
            ps.executeBatch();
        }
    }

    private void AddLegal(List<LegalPerson> persons, Connection con) throws SQLException {
        String query = _queryGenerator.GetQueryInsertLegal();

        try (PreparedStatement ps = con.prepareStatement(query)) {
            for (LegalPerson p : persons) {

                int parameterIndex = 1;
                ps.setInt(parameterIndex++, p.Id);
                ps.setString(parameterIndex++, p.AllName);
                ps.setString(parameterIndex++, p.Inn);
                ps.setString(parameterIndex++, p.Ogrn);
                ps.setObject(parameterIndex++, GetSqlDate(p.DateRegistr));
                ps.setString(parameterIndex++, p.PlaceRegistr);
                ps.setObject(parameterIndex++, GetSqlDate(p.DateDecision));
                ps.setString(parameterIndex++, p.TextDecision);
                ps.setString(parameterIndex, p.Note);

                ps.addBatch();
            }
            ps.executeBatch();
        }
    }

    private <T extends Person> void AddAddress(List<T> persons, Connection con) throws SQLException {
        String query = _queryGenerator.GetQueryInsertAddress();

        try (PreparedStatement ps = con.prepareStatement(query)) {

            for (Person p : persons) {
                if (p.ListAddress == null || p.ListAddress.isEmpty()) continue;

                for (Address a : p.ListAddress) {
                    int parameterIndex = 1;

                    ps.setInt(parameterIndex++, p.Id);
                    ps.setInt(parameterIndex++, a.TypeAddress.Id);
                    ps.setString(parameterIndex++, a.TextAddress);
                    ps.setObject(parameterIndex++, GetCountryCode(a.Country));
                    ps.setString(parameterIndex++, a.Okato);
                    ps.setString(parameterIndex++, a.Index);

                    ps.addBatch();
                }
            }

            ps.executeBatch();
        }
    }

    private Object GetCountryCode(Address.Country country) {
        if (country == null) return null;

        return country.Code;
    }

    private Object GetSqlDate(Date date) {
        if (date != null) {
            return new java.sql.Date(date.getTime());
        }

        return null;
    }
}