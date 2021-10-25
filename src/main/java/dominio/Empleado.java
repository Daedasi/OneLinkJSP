
package dominio;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


@RequestScoped
public class Empleado {
    private int idEmpleado;
    private String nombre;
    private String apellido;
    private int tipoDocumento;
    private String documento;
    private int area;
    private int subarea;
    

    public Empleado() {
    }

    public Empleado(String nombre, String apellido, int tipoDocumento, String documento, int area, int subarea) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoDocumento = tipoDocumento;
        this.documento = documento;
        this.area = area;
        this.subarea = subarea;
    }

    public Empleado(int idEmpleado, String nombre, String apellido, int tipoDocumento, String documento, int area, int subarea) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoDocumento = tipoDocumento;
        this.documento = documento;
        this.area = area;
        this.subarea = subarea;
    }

    public Empleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(int tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getSubarea() {
        return subarea;
    }

    public void setSubarea(int subarea) {
        this.subarea = subarea;
    }

    @Override
    public String toString() {
        return "Empleado{" + "idEmpleado=" + idEmpleado + ", nombre=" + nombre + ", apellido=" + apellido + ", tipoDocumento=" + tipoDocumento + ", documento=" + documento + ", area=" + area + ", subarea=" + subarea + '}';
    }
    
    
    

  
    
}
