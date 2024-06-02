package controleur;


public enum ListIhm {
	IHMTELEPHONEAJOUTER("/ihm/AjouterTelephone.fxml"),
	IHMTELEPHONEMODIFIER("/ihm/ModifierTelephone.fxml"),
	IHMCAMERAAJOUTER("/ihm/AjouterCamera.fxml"),
	IHMALERTESAJOUTER("/ihm/AjouterAlertes.fxml"),
	IHMCAMERAMODIFIER("/ihm/ModifierCamera.fxml"),
	IHMCAPTEURAJOUTER("/ihm/AjouterCapteur.fxml"),
	IHMCAPTEURMODIFIER("/ihm/ModifierCapteur.fxml"),
	IHMALERTESMODIFIER("/ihm/ModifierAlertes.fxml");
	
	
	private String url;


	private ListIhm(String url) {
	    this.url = url;
	}

	public String getUrl() {
		return url;
	}
}