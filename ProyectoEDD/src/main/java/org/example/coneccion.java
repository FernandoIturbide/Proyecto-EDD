package org.example;
import java.sql.*;

public class coneccion {
    public static void main(String[] args) {
        String DB_URL="jdbc:sqlite:Precios.db";
        Connection coneccin=null;
        try {
            Class.forName("org.sqlite.JDBC");
            coneccin= DriverManager.getConnection(DB_URL);
            Statement statement=coneccin.createStatement();
            ResultSet rst = statement.executeQuery("SELECT * FROM Productos;");
            while (rst.next()){
                System.out.println(rst.getString(1)+" "+rst.getString(2)+" "+rst.getString(3));

            }
            coneccin.close();
        }catch (ClassNotFoundException cne){
            cne.printStackTrace();
        }catch (SQLException sqle){
            sqle.printStackTrace();
        }

    }
}
