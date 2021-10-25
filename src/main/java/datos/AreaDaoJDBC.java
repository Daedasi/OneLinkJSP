
package datos;

import dominio.Area;
import java.sql.*;
import java.util.*;


public class AreaDaoJDBC {
        private static final String SQL_SELECT = "SELECT * FROM Areas";
    
       public List<Area> listarAreas(){
        Connection conn = null;
        PreparedStatement smt = null;
        ResultSet rs = null;
        Area area;
        List<Area> areas = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            smt = conn.prepareStatement(SQL_SELECT);
            rs = smt.executeQuery();
            while (rs.next()) {
                int idAreas = rs.getInt("idAreas");
                String label = rs.getString("label");
                

                area = new Area(idAreas, label);
                areas.add(area);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(smt);
            Conexion.close(conn);
        }

        return areas;
        
    }

    
}
