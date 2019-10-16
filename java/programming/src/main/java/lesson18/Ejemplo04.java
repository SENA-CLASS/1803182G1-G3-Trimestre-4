package lesson18;

import java.sql.*;
import java.util.Properties;

public class Ejemplo04 {
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


            int resultado = sentencia.executeUpdate("INSERT INTO public.tipo_documento(\n" +
                    "\tsigla, nombre_documento, estado)\n" +
                    "\tVALUES ('RC', 'Registro civil', 'activo');");
            System.out.println(resultado);
           if(resultado>0){
               System.out.println("se inserto");
           }else{
               System.out.println("no se inserto");
           }


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
