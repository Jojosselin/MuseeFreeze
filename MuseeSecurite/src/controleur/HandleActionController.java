package controleur;

import java.io.IOException;

import dao.AlertesDAO;
import dao.ElementDeSecuriteDAO;
import dao.InfoTelephoneDAO;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import securite.Alertes;
import securite.ElementDeSecurite;
import securite.InfoTelephone;

public class HandleActionController {
	
	private static HandleActionController instance = null;
    
    public static HandleActionController getInstance() {
        if (instance == null) {
            instance = new HandleActionController();
        }
        return instance;
    }
    private HandleActionController() {
       super();
    }
	
	
    //BOUTON AJOUTER 
    
    public void AjouterElemTableau(String objet) {
        try {
        	FXMLLoader fxmlLoader = new FXMLLoader();
        	if(objet == ElementDeControle.CAMERA.getType()) {
                // Charge le fichier FXML
                fxmlLoader = new FXMLLoader(getClass().getResource(ListIhm.IHMCAMERAAJOUTER.getUrl()));
        	}
        	else if(objet == ElementDeControle.CAPTEUR.getType()) {
                fxmlLoader = new FXMLLoader(getClass().getResource(ListIhm.IHMCAPTEURAJOUTER.getUrl()));
        	}
        	else if(objet == ElementDeControle.TELEPHONE.getType()) {
                fxmlLoader = new FXMLLoader(getClass().getResource(ListIhm.IHMTELEPHONEAJOUTER.getUrl()));
        	}
        	else if(objet == ElementDeControle.ALERTES.getType()) {
                fxmlLoader = new FXMLLoader(getClass().getResource(ListIhm.IHMALERTESAJOUTER.getUrl()));
        	}

            Parent root = fxmlLoader.load();
            // Cr�e une nouvelle sc�ne et une nouvelle fen�tre (stage)
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Ajouter un �l�ment");

            // Affiche la nouvelle fen�tre
            stage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    //BOUTON MODIFIER 
    
    public void ModifierElemDeSecurite(TableView<ElementDeSecurite> view, String objet) {
        ElementDeSecurite selectedItem = view.getSelectionModel().getSelectedItem();
        
        if (selectedItem != null) {
            	try {
                   	FXMLLoader fxmlLoader = new FXMLLoader();
                	if(objet == ElementDeControle.CAMERA.getType()) {
                        // Charge le fichier FXML
                        fxmlLoader = new FXMLLoader(getClass().getResource(ListIhm.IHMCAMERAMODIFIER.getUrl()));
                	}
                	else if(objet == ElementDeControle.CAPTEUR.getType()) {
                        fxmlLoader = new FXMLLoader(getClass().getResource(ListIhm.IHMCAPTEURAJOUTER.getUrl()));
                	}
        	        Parent root = fxmlLoader.load();
        	        Stage stage = new Stage();
        	        stage.initModality(Modality.APPLICATION_MODAL);
        	        stage.setTitle("Modifier  un �l�ment");
        	        stage.setScene(new Scene(root));
                	if(objet == ElementDeControle.CAMERA.getType()) {
                        // Charge le fichier FXML
                		((ModifierCameraController) fxmlLoader.getController()).openWindow(selectedItem);
                	}
                	else if(objet == ElementDeControle.CAPTEUR.getType()) {
                		((ModifierCapteurController) fxmlLoader.getController()).openWindow(selectedItem);
                	}
        	        stage.showAndWait();
        	        //this.initializeZoneTableViewCamera();
            	}catch(Exception e) {
            		e.printStackTrace();
            	}
       } else {
            // Afficher une alerte si aucune ligne n'est s�lectionn�e
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Aucune s�lection");
            alert.setHeaderText("Aucun �l�ment s�lectionn�");
            alert.setContentText("Veuillez s�lectionner un �l�ment dans le tableau.");
            alert.showAndWait();
        }
    }
    
    public void ModifierAlertes(TableView<Alertes> view) {
        Alertes selectedItem = view.getSelectionModel().getSelectedItem();
        
        if (selectedItem != null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource(ListIhm.IHMALERTESMODIFIER.getUrl()));
                Parent root = loader.load();
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setTitle("Modifier Alertes");
                stage.setScene(new Scene(root));
                ((ModifierAlertesController) loader.getController()).openWindow(selectedItem);
                stage.showAndWait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // Afficher une alerte si aucune ligne n'est s�lectionn�e
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Aucune s�lection");
            alert.setHeaderText("Aucun �l�ment s�lectionn�");
            alert.setContentText("Veuillez s�lectionner un �l�ment dans le tableau.");
            alert.showAndWait();
        }
    }

    
     
    public void ModifierTelephone(TableView<InfoTelephone> view) {
    	InfoTelephone selectedItem = view.getSelectionModel().getSelectedItem();
        
        if (selectedItem != null) {
        	try {
       	        FXMLLoader loader = new FXMLLoader(getClass().getResource(ListIhm.IHMTELEPHONEMODIFIER.getUrl()));
    	        Parent root = loader.load();
    	        Stage stage = new Stage();
    	        stage.initModality(Modality.APPLICATION_MODAL);
    	        stage.setTitle("Modifier Telephone");
    	        stage.setScene(new Scene(root));
        		((ModifierTelephoneController) loader.getController()).openWindow(selectedItem);
    	        stage.showAndWait();
        	}catch(Exception e) {
        		e.printStackTrace();
        	}
       } else {
            // Afficher une alerte si aucune ligne n'est s�lectionn�e
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Aucune s�lection");
            alert.setHeaderText("Aucun �l�ment s�lectionn�");
            alert.setContentText("Veuillez s�lectionner un �l�ment dans le tableau.");
            alert.showAndWait();
        }
    }
    
    //SUPPRIMER LES ELEMENTS DU TABLEAU
    
    
    
    public void DeleteElem(TableView<ElementDeSecurite> view) {
        ElementDeSecurite selectedItem = view.getSelectionModel().getSelectedItem();
        
        if (selectedItem != null) {
        	view.getItems().remove(selectedItem);
            ElementDeSecuriteDAO.getInstance().delete(selectedItem);
        } else {
            // Afficher une alerte si aucune ligne n'est s�lectionn�e
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Aucune s�lection");
            alert.setHeaderText("Aucun �l�ment s�lectionn�");
            alert.setContentText("Veuillez s�lectionner un �l�ment dans le tableau.");
            alert.showAndWait();
        }
    }
    
    public void DeleteAlertes(TableView<Alertes> view) {
        Alertes selectedItem = view.getSelectionModel().getSelectedItem();
        
        if (selectedItem != null) {
        	view.getItems().remove(selectedItem);
            AlertesDAO.getInstance().delete(selectedItem);
        } else {
            // Afficher une alerte si aucune ligne n'est s�lectionn�e
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Aucune s�lection");
            alert.setHeaderText("Aucun �l�ment s�lectionn�");
            alert.setContentText("Veuillez s�lectionner un �l�ment dans le tableau.");
            alert.showAndWait();
        }
    }
    
    public void DeleteElemInfoTelephone(TableView<InfoTelephone> view) {
        InfoTelephone selectedItem = view.getSelectionModel().getSelectedItem();
        
        if (selectedItem != null) {
        	view.getItems().remove(selectedItem);
            InfoTelephoneDAO.getInstance().delete(selectedItem);
        } else {
            // Afficher une alerte si aucune ligne n'est s�lectionn�e
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Aucune s�lection");
            alert.setHeaderText("Aucun �l�ment s�lectionn�");
            alert.setContentText("Veuillez s�lectionner un �l�ment dans le tableau.");
            alert.showAndWait();
        }
    }
    
	public void AddTelephoneAction(TextField nomTelephone, TextField numeroTelephone, Button enregistrerTelephone) {
	    String nom = nomTelephone.getText();
	    String numero = numeroTelephone.getText();
	    
	    if (nom.isEmpty() || numero.isEmpty()) {
	        // Afficher une alerte si les champs ne sont pas remplis correctement
	        Alert alert = new Alert(AlertType.WARNING);
	        alert.setTitle("Informations manquantes");
	        alert.setHeaderText("Tous les champs doivent �tre remplis");
	        alert.setContentText("Veuillez renseigner le nom, le num�ro de t�l�phone.");
	        alert.showAndWait();
	    } else {
	        InfoTelephone newElement = new InfoTelephone(0, nom, numero);
	        InfoTelephoneDAO.getInstance().create(newElement);
	        Stage stage = (Stage) enregistrerTelephone.getScene().getWindow();
	        stage.close();
	    }
	}
	
	public void handleAddElementDeSecuriteAction(TextField nomObjet, ComboBox<String> salleComboBox, Label type, ComboBox<String> serveurComboBox, CheckBox etatObjet, Button enregistrer) {
	    String nom = nomObjet.getText();
	    String emplacement = salleComboBox.getValue();
	    String modele = type.getText();
	    String serveur = serveurComboBox.getValue();
	    Boolean etat = etatObjet.isSelected();
	    
	    if (nom.isEmpty() || emplacement == null || modele.isEmpty() || serveur == null || etat == null) {
	        // Afficher une alerte si les champs ne sont pas remplis correctement
	        Alert alert = new Alert(AlertType.WARNING);
	        alert.setTitle("Informations manquantes");
	        alert.setHeaderText("Tous les champs doivent �tre remplis");
	        alert.setContentText("Veuillez renseigner le nom, la condition, la valeur et l'etat.");
	        alert.showAndWait();
	    } else {
	        ElementDeSecurite newElement = new ElementDeSecurite(0, nom, modele, emplacement, serveur, etat);
	        ElementDeSecuriteDAO.getInstance().create(newElement);
	        Stage stage = (Stage) enregistrer.getScene().getWindow();
	        stage.close();
	    }
	}
	
	public void handleAddAlertes(Label nomObjet, ComboBox<String> conditionComboBox, TextField valeurAlertes,CheckBox etatObjet, Button enregistrer) {
	    String nom = nomObjet.getText();
	    String condition = conditionComboBox.getValue();
	    String valeur = valeurAlertes.getText();
	    Boolean etat = etatObjet.isSelected();
	    
	    if (nom.isEmpty() || condition == null || valeur == null || etat == null) {
	        // Afficher une alerte si les champs ne sont pas remplis correctement
	        Alert alert = new Alert(AlertType.WARNING);
	        alert.setTitle("Informations manquantes");
	        alert.setHeaderText("Tous les champs doivent �tre remplis");
	        alert.setContentText("Veuillez renseigner le nom, l'emplacement et le mod�le du capteur.");
	        alert.showAndWait();
	    } else {
	        Alertes newElement = new Alertes(0, nom, condition, valeur, etat);
	        AlertesDAO.getInstance().create(newElement);
	        Stage stage = (Stage) enregistrer.getScene().getWindow();
	        stage.close();
	    }
	}
	
	public void UpdateElementDeSecurite(TextField nomElementDeSecurite, ComboBox<String> emplacementElementDeSecurite, ComboBox<String> modeleElementDeSecurite, ComboBox<String> serveurElementDeSecurite,CheckBox etatElementDeSecurite, Label idElementDeSecurite, Button enregistrerElementDeSecurite) {
	    String nom = nomElementDeSecurite.getText();
	    String emplacement = emplacementElementDeSecurite.getValue();
	    String modele = modeleElementDeSecurite.getValue();
	    String serveur = serveurElementDeSecurite.getValue();
	    Boolean etat = etatElementDeSecurite.isSelected();
	    int id = Integer.parseInt(idElementDeSecurite.getText());
	    
	    if (nom.isEmpty() || emplacement == null || modele == null || serveur == null || etat == null) {
	        // Afficher une alerte si les champs ne sont pas remplis correctement
	        Alert alert = new Alert(AlertType.WARNING);
	        alert.setTitle("Informations manquantes");
	        alert.setHeaderText("Tous les champs doivent �tre remplis");
	        alert.setContentText("Veuillez renseigner le nom, l'emplacement, le modele et l'�tat de l'Element de securite.");
	        alert.showAndWait();
	    } else {
	    	
	        ElementDeSecurite existingElement = ElementDeSecuriteDAO.getInstance().read(id);

	        // Modifier les attributs de l'objet ElementDeSecurite
	        existingElement.setNom(nom);
	        existingElement.setModele(modele);
	        existingElement.setEmplacement(emplacement);
	        existingElement.setServeur(serveur);
	        existingElement.setEtat(etat);
	    	

	        ElementDeSecuriteDAO.getInstance().update(existingElement);
	        Stage stage = (Stage) enregistrerElementDeSecurite.getScene().getWindow();
	        stage.close();

	    }
	}
   
	public void UpdateAlertes(Label nomCapteur, ComboBox<String> conditionComboBox, TextField valeurAlertes, CheckBox etatAlertes, Label idAlertes, Button enregistrerAlertes) {
	    String nom = nomCapteur.getText();
	    String condition = conditionComboBox.getValue();
	    String valeur = valeurAlertes.getText();
	    Boolean etat = etatAlertes.isSelected();
	    int id = Integer.parseInt(idAlertes.getText());
	    
	    if (nom.isEmpty() || condition == null || valeur.isEmpty() || etat == null) {
	        // Afficher une alerte si les champs ne sont pas remplis correctement
	        Alert alert = new Alert(AlertType.WARNING);
	        alert.setTitle("Informations manquantes");
	        alert.setHeaderText("Tous les champs doivent �tre remplis");
	        alert.setContentText("Veuillez renseigner le nom, la condition, la valeur et l'�tat de l'Alerte.");
	        alert.showAndWait();
	    } else {
	        Alertes existingAlerte = AlertesDAO.getInstance().read(id);

	        // Modifier les attributs de l'objet Alertes
	        existingAlerte.setNom(nom);
	        existingAlerte.setCondition(condition);
	        existingAlerte.setValeur(valeur);
	        existingAlerte.setEtat(etat);

	        AlertesDAO.getInstance().update(existingAlerte);
	        Stage stage = (Stage) enregistrerAlertes.getScene().getWindow();
	        stage.close();
	    }
	}

	
	public void UpdateTelephoneInfo(TextField nomTelephone, TextField numeroTelephone, Label idTelephone, Button enregistrerTelephone) {
	    String nom = nomTelephone.getText();
	    String numero = numeroTelephone.getText();
	    int id = Integer.parseInt(idTelephone.getText());
	    
	    if (nom.isEmpty() || numero.isEmpty()) {
	        // Afficher une alerte si les champs ne sont pas remplis correctement
	        Alert alert = new Alert(AlertType.WARNING);
	        alert.setTitle("Informations manquantes");
	        alert.setHeaderText("Tous les champs doivent �tre remplis");
	        alert.setContentText("Veuillez renseigner le nom et le num�ro de t�l�phone.");
	        alert.showAndWait();
	    } else {
	    	
	        InfoTelephone existingElement = InfoTelephoneDAO.getInstance().read(id);

	        // Modifier les attributs de l'objet ElementDeSecurite
	        existingElement.setNom(nom);
	        existingElement.setNumerotelephone(numero);
	    	

	        InfoTelephoneDAO.getInstance().update(existingElement);
	        Stage stage = (Stage) enregistrerTelephone.getScene().getWindow();
	        stage.close();
	    }
	}

}