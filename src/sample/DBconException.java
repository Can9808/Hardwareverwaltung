package sample;

public class DBconException extends Exception {
    public DBconException(String message) {
        super(message);
    }
}
//public static String checkDBCon() throws DBconException{
//        if(){
//            throw new DBconException("Die Datenbank verbindung klappt nicht");
//        }
//        return null;
//}

