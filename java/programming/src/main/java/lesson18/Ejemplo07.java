package lesson18;

import java.sql.*;
import java.util.Properties;

public class Ejemplo07 {
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

            sentencia = conexion.prepareStatement("INSERT INTO public.tipo_documento(" +
                    "sigla, nombre_documento, estado)\n" +
                    "VALUES (?, ?, ?);");
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
