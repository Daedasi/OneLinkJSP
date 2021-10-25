package datos;

import dominio.TipoDocumento;
import dominio.Area;
import dominio.SubArea;
import dominio.EmpleadoDTO;
import dominio.Empleado;
import java.sql.*;
import java.util.*;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;



public class EmpleadoDaoJDBC {
    
// <editor-fold defaultstate="collapsed" desc="Declaración de sentencias SQL">
    private static final String SQL_SELECT_EMPLEADOS = "SELECT Empleados.idEmpleado, Empleados.Nombre, Empleados.Apellido, tiposDocumento.idTiposDocumento, tiposDocumento.label TipoDocumento, Empleados.numDoc, Areas.idAreas, Areas.label Area, SubAreas.idSubAreas, SubAreas.idAreas, SubAreas.label SubArea\n" +
                                                        "FROM Empleados\n" +
                                                        "LEFT JOIN tiposDocumento ON Empleados.idTipoDocumento=tiposDocumento.idTiposDocumento\n" +
                                                        "LEFT JOIN Areas ON Empleados.idArea=Areas.idAreas\n" +
                                                        "LEFT JOIN SubAreas ON Empleados.idSubArea = SubAreas.idSubAreas;";
    private static final String SQL_SELECT_EMPLEADOSSEARCH = "SELECT Empleados.idEmpleado, Empleados.Nombre, Empleados.Apellido, tiposDocumento.idTiposDocumento, tiposDocumento.label TipoDocumento, Empleados.numDoc, Areas.idAreas, Areas.label Area, SubAreas.idSubAreas, SubAreas.idAreas, SubAreas.label SubArea\n" +
                                                            "FROM Empleados\n" +
                                                            "LEFT JOIN tiposDocumento ON Empleados.idTipoDocumento=tiposDocumento.idTiposDocumento\n" +
                                                            "LEFT JOIN Areas ON Empleados.idArea=Areas.idAreas\n" +
                                                            "LEFT JOIN SubAreas ON Empleados.idSubArea = SubAreas.idSubAreas WHERE numDoc LIKE ? OR nombre LIKE ? ";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM Empleados WHERE idEmpleado = ?";
    private static final String SQL_INSERT = "INSERT INTO Empleados(nombre,apellido,idTipoDocumento,numDoc,idArea,idSubArea)"
            + " VALUES (?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE Empleados "
            + " SET nombre=?, apellido=?, idTipoDocumento=?, numDoc=?, idArea=?, idSubArea=? WHERE idEmpleado= ?";
    private static final String SQL_DELETE = "DELETE FROM Empleados WHERE idEmpleado=?";
    //</editor-fold>
    

    public ArrayList<EmpleadoDTO> listarEmpleados() {
        Connection conn = null;
        PreparedStatement smt = null;
        ResultSet rs = null;
        EmpleadoDTO empleado ;
        Area area;
        SubArea subArea;
        TipoDocumento tipoDoc;

        ArrayList<EmpleadoDTO> empleados = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            smt = conn.prepareStatement(SQL_SELECT_EMPLEADOS);
            rs = smt.executeQuery();
            while (rs.next()) {
                int idEmpleado = rs.getInt("idEmpleado");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int idTipoDoc= rs.getInt("idTiposDocumento");
                String tipoDocumento = rs.getString("TipoDocumento");
                String numDoc = rs.getString("numDoc");
                int idArea=rs.getInt("idAreas");
                String Area = rs.getString("Area");
                int idSubAreas=rs.getInt("idSubAreas");
                String SubArea = rs.getString("SubArea");
                
                
                area= new Area(idArea,Area);
                subArea= new SubArea(idSubAreas,idArea,SubArea);
                tipoDoc= new TipoDocumento(idTipoDoc,tipoDocumento);
                

                empleado = new EmpleadoDTO(idEmpleado, nombre, apellido,  tipoDoc, numDoc, area, subArea);
                empleados.add(empleado);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(smt);
            Conexion.close(conn);
        }

        return empleados;

    }

    public List<EmpleadoDTO> buscarEmpleados(String parametro) {
        Connection conn = null;
        PreparedStatement smt = null;
        ResultSet rs = null;
        EmpleadoDTO empleado;
        Area area;
        SubArea subArea;
        TipoDocumento tipoDoc;

        List<EmpleadoDTO> empleados = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            smt = conn.prepareStatement(SQL_SELECT_EMPLEADOSSEARCH);
            smt.setString(1, parametro);
            smt.setString(2, parametro);
            rs = smt.executeQuery();
            while (rs.next()) {
                int idEmpleado = rs.getInt("idEmpleado");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int idTipoDoc= rs.getInt("idTiposDocumento");
                String tipoDocumento = rs.getString("TipoDocumento");
                String numDoc = rs.getString("numDoc");
                int idArea=rs.getInt("idAreas");
                String Area = rs.getString("Area");
                int idSubAreas=rs.getInt("idSubAreas");
                String SubArea = rs.getString("SubArea");
                
                
                area= new Area(idArea,Area);
                subArea= new SubArea(idSubAreas,idArea,SubArea);
                tipoDoc= new TipoDocumento(idTipoDoc,tipoDocumento);
                

                empleado = new EmpleadoDTO(idEmpleado, nombre, apellido, tipoDoc, numDoc, area, subArea);
                empleados.add(empleado);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(smt);
            Conexion.close(conn);
        }

        return empleados;

    }

    public Empleado encontrar(Empleado empleado) {
        Connection conn = null;
        PreparedStatement smt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            smt = conn.prepareStatement(SQL_SELECT_BY_ID);
            smt.setInt(1, empleado.getIdEmpleado());
            rs = smt.executeQuery();
            rs.next();

            int idEmpleado = rs.getInt("idEmpleado");
            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellido");
            int tipoDocumento = rs.getInt("idTipoDocumento");
            String numDoc = rs.getString("numDoc");
            int idArea = rs.getInt("idArea");
            int idSubArea = rs.getInt("idSubArea");

            empleado.setIdEmpleado(idEmpleado);
            empleado.setNombre(nombre);
            empleado.setApellido(apellido);
            empleado.setTipoDocumento(tipoDocumento);
            empleado.setDocumento(numDoc);
            empleado.setArea(idArea);
            empleado.setSubarea(idSubArea);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(smt);
            Conexion.close(conn);
        }

        return empleado;

    }

    public int insertar(Empleado empleado) {
        Connection conn = null;
        PreparedStatement smt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            smt = conn.prepareStatement(SQL_INSERT);
            smt.setString(1, empleado.getNombre());
            smt.setString(2, empleado.getApellido());
            smt.setInt(3, empleado.getTipoDocumento());
            smt.setString(4, empleado.getDocumento());
            smt.setInt(5, empleado.getArea());
            smt.setInt(6, empleado.getSubarea());

            rows = smt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(smt);
            Conexion.close(conn);
        }
        return rows;

    }

    public int actualizar(Empleado empleado) {
        Connection conn = null;
        PreparedStatement smt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            smt = conn.prepareStatement(SQL_UPDATE);
            smt.setString(1, empleado.getNombre());
            smt.setString(2, empleado.getApellido());
            smt.setInt(3, empleado.getTipoDocumento());
            smt.setString(4, empleado.getDocumento());
            smt.setInt(5, empleado.getArea());
            smt.setInt(6, empleado.getSubarea());
            smt.setInt(7, empleado.getIdEmpleado());

            rows = smt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(smt);
            Conexion.close(conn);
        }
        return rows;

    }

    public int eliminar(Empleado empleado) {
        Connection conn = null;
        PreparedStatement smt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            smt = conn.prepareStatement(SQL_DELETE);
            smt.setInt(1, empleado.getIdEmpleado());

            rows = smt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(smt);
            Conexion.close(conn);
        }
        return rows;

    }

}
