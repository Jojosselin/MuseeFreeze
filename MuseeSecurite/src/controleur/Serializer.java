package controleur;
import java.io.Serializable;

// Cette classe permets de s�rialiser les informations.
public class Serializer implements Serializable {
    private static final long serialVersionUID = 1L;

    private String imagePath;
    private String tabTitle;

    public Serializer(String imagePath, String tabTitle) {
        this.imagePath = imagePath;
        this.tabTitle = tabTitle;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getTabTitle() {
        return tabTitle;
    }
}
