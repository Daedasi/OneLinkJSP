
package dominio;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


public class TipoDocumento {
    
   private int idTipoDocumento;
   private String label;

    public TipoDocumento() {
    }

    public TipoDocumento(int idTipoDocumento, String label) {
        this.idTipoDocumento = idTipoDocumento;
        this.label = label;
    }

    public int getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(int idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
   
   
    
}
