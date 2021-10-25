package datos;

import dominio.SubArea;
import java.sql.*;
import java.util.*;

public class SubAreaDaoJDBC {

    private static final String SQL_SELECT = "SELECT * FROM SubAreas ";

    public List<SubArea> listarSubAreas() {
        Connection conn = null;
        PreparedStatement smt = null;
        ResultSet rs = null;
        SubArea subArea;
        List<SubArea> subAreas = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            smt = conn.prepareStatement(SQL_SELECT);
            rs = smt.executeQuery();
            while (rs.next()) {
                int idSubAreas = rs.getInt("idSubAreas");
                int idAreas = rs.getInt("idAreas");
                String label = rs.getString("label");

                subArea = new SubArea(idSubAreas, idAreas, label);
                subAreas.add(subArea);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(smt);
            Conexion.close(conn);
        }

        return subAreas;

    }

}
