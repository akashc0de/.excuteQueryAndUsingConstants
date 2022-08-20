package MyFirstProject.com;

import java.sql.*;

public class akash {
    public static final String DB_NAME="testjava.db";
    public static final String CONNECTION_STRING="jdbc:sqlite:C:\\Users\\asus\\Downloads\\sqlite-tools-win32-x86-3390200\\sqlite-tools-win32-x86-3390200\\"+DB_NAME;
    public static final String  TABLE_CONTACTS =" contacts ";
    public static final String COLUMN_NAME="name";
    public static final String COLUMN_PHONE="phone";
    public static final String COLUMN_EMAIL="email";

    public static void main(String[] args) {
        Statement statement;
        try {
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            statement = conn.createStatement();

            statement.execute("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
            statement.execute("CREATE table IF NOT EXISTS " + TABLE_CONTACTS + "(" + COLUMN_NAME + " text," +
                    COLUMN_PHONE + " integer," +
                    COLUMN_EMAIL + " text" +
                    ")");

            insertContact(statement,"Akash",7667476,"akash@gmail.com");
            insertContact(statement,"god",655344,"god@gmail.com");
            insertContact(statement,"tom",54554,"tom@gmail.com");
            insertContact(statement,"white wolf",65654678,"whitewolf@gmail.com");





            statement.execute("UPDATE " + TABLE_CONTACTS + " SET " +
                    COLUMN_PHONE + "=545645" +
                    " WHERE " + COLUMN_NAME + "='god'");


            statement.execute(" DELETE FROM " + TABLE_CONTACTS +
                    " WHERE " + COLUMN_NAME + "='tom'");
            ResultSet result = statement.executeQuery("SELECT * FROM" + TABLE_CONTACTS);
            while (result.next()) {
                System.out.println(result.getString(COLUMN_NAME) + " " +
                        result.getInt(COLUMN_PHONE) + " " +
                        result.getString(COLUMN_EMAIL));
            }
            result.close();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Something wrong" + e.getMessage());
            e.printStackTrace();
        }
    }
        private static void insertContact (Statement statement, String name,int phone,String email) throws SQLException{
            statement.execute("INSERT INTO " + TABLE_CONTACTS +
                    "(" + COLUMN_NAME + ", " +
                    COLUMN_PHONE + ", " +
                    COLUMN_EMAIL +
                    " ) " +
                    "VALUES('"+ name + "'," +phone+",'"+email+"')");


        }


    }























