package datos;

import dominio.TipoDocumento;
import java.sql.*;
import java.util.*;

public class TipoDocumentoDaoJDBC {

    private static final String SQL_SELECT = "SELECT * FROM tiposDocumento";

    public List<TipoDocumento> listarDocumentos(){
        Connection conn = null;
        PreparedStatement smt = null;
        ResultSet rs = null;
        TipoDocumento tipoDoc=null;
        List<TipoDocumento> tiposDoc = new ArrayList<TipoDocumento>();
        try {
            conn = Conexion.getConnection();
            smt = conn.prepareStatement(SQL_SELECT);
            rs = smt.executeQuery();
            while (rs.next()) {
                int idTipoDoc = rs.getInt("idtiposDocumento");
                String label = rs.getString("label");
                

                tipoDoc = new TipoDocumento(idTipoDoc, label);
                tiposDoc.add(tipoDoc);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(smt);
            Conexion.close(conn);
        }

        return tiposDoc;
        
    }

}
