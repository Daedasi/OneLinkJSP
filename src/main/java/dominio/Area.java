
package dominio;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


@RequestScoped
public class Area {
    private int idArea;
    private String label;

    public Area() {
    }

    public Area(int idArea, String label) {
        this.idArea = idArea;
        this.label = label;
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
