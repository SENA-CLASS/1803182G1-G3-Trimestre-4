package lesson18;

import java.sql.*;
import java.util.Properties;

public class Ejemplo08 {
    public static void main(String[] args) {
        String urlPosgres = "jdbc:postgresql://localhost:5432/sena_ceet_natual";
        Connection conexion=null;
        Properties info = new Properties();
        info.setProperty("user","postgres");
        info.setProperty("password","postgres");

        PreparedStatement sentencia =null;
        ResultSet resultado=null;
        try {
            conexion = DriverManager.getConnection(urlPosgres,info);
            System.out.println("se extablecio la conexión");

            sentencia = conexion.prepareCall("call pa_libros_aumentar10");// esto se usa para llamar procedimientos motor
            sentencia.setString(1,"NIT");
            sentencia.setString(2,"numero");
            sentencia.setString(3,"activo");


            int modificado = sentencia.executeUpdate();
            System.out.println(modificado);

            System.out.println("se hizo la consulta");

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(resultado!=null){
                try {
                    resultado.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(sentencia!=null){
                try {
                    sentencia.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conexion!=null){
                try {
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
