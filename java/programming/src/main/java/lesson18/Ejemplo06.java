package lesson18;

import java.sql.*;
import java.util.Properties;

public class Ejemplo06 {
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

            sentencia = conexion.prepareStatement("select * from public.tipo_documento td where td.sigla = ?;");
            sentencia.setString(1,"CC");


            resultado = sentencia.executeQuery();

            while (resultado.next()){
                String sigla = resultado.getString("sigla");
                String nombreDocumento = resultado.getString("nombre_documento");
                String estado = resultado.getString("estado");
                System.out.println(sigla);
                System.out.println(nombreDocumento);
                System.out.println(estado);
            }

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
