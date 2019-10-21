package co.edu.sena.dao.modelo.dao.util;

import java.sql.*;
import java.util.logging.Logger;

public class ResourceManager {
    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/daoejemplo";
    private static final String JDBC_USER = "postgres";
    private static final String JDBC_PASSWORD = "postgres";

    static final Logger logger = Logger.getLogger(ResourceManager.class.getName());

    private ResourceManager() {
    }

    public static synchronized Connection getConnection() throws SQLException {
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        } catch (SQLException e) {
            logger.info(e.getMessage());
        }

        return conexion;
    }

    /**
     * metodo que me permite cerra la conexión a la base de datos
     * @param conn objeto de connection que me genera el DriverManager
     */
    public static void close(Connection conn)
    {
        try {
            if (conn != null) conn.close();
        }catch (SQLException e) {
            logger.info(e.getMessage());
        }
    }

    /**
     * metodo me permite cerrar el PreparedStatement
     * @param stmt un objeto creado a partir de la sentencia SQL
     */
    public static void close(PreparedStatement stmt)
    {
        try {
            if (stmt != null) stmt.close();
        }catch (SQLException e){
            logger.info(e.getMessage());
        }
    }

    /**
     * método que me permite cerrar un resulset
     * @param rs objeto obtenido de la consulta
     */
    public static void close(ResultSet rs)
    {
        try {
            if (rs != null) rs.close();
        }catch (SQLException e) {
            logger.info(e.getMessage());
        }

    }
}
