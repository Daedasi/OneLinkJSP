
package dominio;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


@RequestScoped
public class EmpleadoDTO {
    
    private int idEmpleado;
    private String nombre;
    private String apellido;
    private TipoDocumento tipoDocumento;
    private String documento;
    private Area area;
    private SubArea subArea;
    

    public EmpleadoDTO() {
    }




    public EmpleadoDTO(int idEmpleado, String nombre, String apellido, TipoDocumento tipoDocumento, String Documento, Area area, SubArea subarea) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoDocumento = tipoDocumento;
        this.documento = Documento;
        this.area = area;
        this.subArea = subarea;
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
    
        public String getDocumento() {
        return documento;
    }

    public void setDocumento(String Documento) {
        this.documento = Documento;
    }


    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }


    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public SubArea getSubArea() {
        return subArea;
    }

    public void setSubArea(SubArea subarea) {
        this.subArea = subarea;
    }
    
    

}
