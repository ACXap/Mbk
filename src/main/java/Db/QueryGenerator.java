package Db;


public class QueryGenerator  {

    public QueryGenerator(String schema) {
        TABLE_LEGAL = schema + "mbk_legal";
        TABLE_PHYSICAL = schema + "mbk_physical";
        TABLE_PHYSICAL_DOCUMENT = schema + "mbk_physical_document";
        TABLE_ADDRESS = schema + "mbk_address";
    }

    //region PrivateField
    private final String TABLE_LEGAL;
    private final String TABLE_PHYSICAL;
    private final String TABLE_PHYSICAL_DOCUMENT;
    private final String TABLE_ADDRESS;

    private final String INSERT_INTO = "INSERT INTO ";
    //endregion PrivateField

    public String GetQueryInsertLegal() {
        return INSERT_INTO + TABLE_LEGAL
                + " (list_id,all_names,inn,ogrn,date_registration,place_registration,date_decision,text_decision,note)"
                + " VALUES(?,?,?,?,?,?,?,?,?);";
    }

    public String GetQueryInsertPhysical() {
        return INSERT_INTO + TABLE_PHYSICAL
                + " (list_id,all_names,all_birthdates,all_birthplaces,inn,date_decision,text_decision,note)"
                + " VALUES(?,?,?,?,?,?,?,?);";
    }

    public String GetQueryInsertPhysicalDocuments() {
        return INSERT_INTO + TABLE_PHYSICAL_DOCUMENT
                + " (list_id,type_id,serial,number,organ,date_issue,document_type, person_id)"
                + " VALUES(?,?,?,?,?,?,?,?);";
    }

    public String GetQueryInsertAddress() {
        return INSERT_INTO + TABLE_ADDRESS
                + " (list_id,type_id,text_address,country_id,okato,index,address_type, person_id)"
                + " VALUES(?,?,?,?,?,?,?,?);";
    }
}