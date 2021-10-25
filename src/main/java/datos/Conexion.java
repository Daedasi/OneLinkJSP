package datos;

import java.sql.*;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;



public class Conexion {
    
    
    
    private static BasicDataSource dataSource;

    public static Connection getConnection() throws SQLException {
        //if (System.getenv("RDS_HOSTNAME") != null) {
        
        
            
            String hostname = "aa1lw6gd5taxb4n.cygtineygps3.us-east-1.rds.amazonaws.com";
            String userName = "daedas";
            String password = "pegostioso";
            String port="3306";
            String dbName="mydb";
            
            if (dataSource==null){
            dataSource = new BasicDataSource();
            dataSource.setUrl("jdbc:mysql://aa1lw6gd5taxb4n.cygtineygps3.us-east-1.rds.amazonaws.com:3306/mydb?useSSL=false&useTimezone=true&serverTimezone=UTC&zeroDateTimeBehavior=CONVERT_TO_NULL&allowPublicKeyRetrieval=true");
            dataSource.setUsername("daedas");
            dataSource.setPassword("pegostioso");
            
            
        }
            
            //String dbName = System.getenv("RDS_DB_NAME");
            //String userName = System.getenv("RDS_USERNAME");
            //String password = System.getenv("RDS_PASSWORD");
            //String hostname = System.getenv("RDS_HOSTNAME");
            //String port = System.getenv("RDS_PORT");
            
            String jdbcUrl = "jdbc:mysql://" + hostname + ":" + port + "/" + dbName + "?user=" + userName + "&password=" + password;
            Connection con = dataSource.getConnection();
            return con;

        //}
        //return null;
    }

    public static void close(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void close(PreparedStatement ps) {
        try {
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void close(Connection con) {
        try {
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

    }

}
