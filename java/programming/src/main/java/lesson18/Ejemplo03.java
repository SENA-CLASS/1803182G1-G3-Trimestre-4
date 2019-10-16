package lesson18;

import java.sql.*;
import java.util.Properties;

public class Ejemplo03 {
    public static void main(String[] args) {
        String urlPosgres = "jdbc:postgresql://localhost:5432/sena_ceet_natual";
        Connection conexion=null;
        Properties info = new Properties();
        info.setProperty("user","postgres");
        info.setProperty("password","postgres");
        try {
            conexion = DriverManager.getConnection(urlPosgres,info);
            System.out.println("se extablecio la conexión");

            Statement sentencia = conexion.createStatement();// malooooooooooooooooooooo por sqlinyection


            boolean resultado = sentencia.execute("select * from public.tipo_documento td where td.sigla = 'CC';");

            System.out.println(resultado);

            System.out.println("se hizo la consulta");

            sentencia.close();

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
        }

    }
}
