package lesson18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ejemplo01 {
    public static void main(String[] args) {

        String urlMysql = "jdbc:mysql://localhost:4306/ceet_natural";
        String urlPosgres = "jdbc:postgresql://localhost:5432/sena_ceet_natual";

        Connection conexion=null;
        Connection conexion2=null;
        try {
            //java.lang.Class.forName("com.mysql.jdbc.Driver");// a partir de jdbc 4 ya no se pone
            conexion = DriverManager.getConnection(urlMysql,"root", "123456789");
            conexion = DriverManager.getConnection(urlPosgres,"postgres", "postgres");
            System.out.println("se extablecio la conexión");


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(conexion!=null){
                try {
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conexion2!=null){
                try {
                    conexion2.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
