package ihm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SecuriteGUI extends Application {

	    @Override
	    public void start(Stage primaryStage) throws Exception{
	        // Chargement de l'interface graphique � partir du fichier FXML
	        Parent root = FXMLLoader.load(getClass().getResource("plan.fxml"));

	        // Cr�ation d'une sc�ne � partir de l'interface graphique
	        Scene scene = new Scene(root, 650, 450);

	        // Ajout de la sc�ne � la fen�tre et affichage de la fen�tre
	        primaryStage.setTitle("Securit� du Mus�e");
	        primaryStage.setScene(scene);
	        primaryStage.show();
	    }
	    
	    public SecuriteGUI() {
	    	super();
	    }


	    public static void main(String[] args) {
	        launch(args);
	    }
	}