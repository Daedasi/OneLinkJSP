/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 *
 * @author josep
 */
public class TipoDocumentoDTO extends TipoDocumento{

    private boolean isSelected;
    
    public TipoDocumentoDTO(boolean isSelected) {
        this.isSelected = isSelected;
    }

    public TipoDocumentoDTO(boolean isSelected, int idTipoDocumento, String label) {
        super(idTipoDocumento, label);
        this.isSelected = isSelected;
    }

    public TipoDocumentoDTO() {
        this.isSelected=false;
    }

    public TipoDocumentoDTO(int idTipoDocumento, String label) {
        super(idTipoDocumento, label);
    }
    
    
    
    

    public boolean isIsSelected() {
        return isSelected;
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }
    
}
