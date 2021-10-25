
package dominio;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


@RequestScoped
public class SubArea {
    
    private int idSubArea;
    private int idArea;
    private String label;

    public SubArea() {
    }

    public SubArea(int idSubArea, int idArea, String label) {
        this.idSubArea = idSubArea;
        this.idArea = idArea;
        this.label = label;
    }

    public int getIdSubArea() {
        return idSubArea;
    }

    public void setIdSubArea(int idSubArea) {
        this.idSubArea = idSubArea;
    }

    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    
    
    
}
