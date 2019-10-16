package lesson18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Ejemplo05 {
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
            String tipoDocumento = "RM";
            String nombreDocumento = "Registro Mercantil";
            String estado = "activo";

            boolean resultado = sentencia.execute("INSERT INTO public.tipo_documento(\n" +
                    "\tsigla, nombre_documento, estado)\n" +
                    "\tVALUES ('"+tipoDocumento+"', '"+nombreDocumento+"', '"+estado+"');");
            System.out.println(resultado);



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
