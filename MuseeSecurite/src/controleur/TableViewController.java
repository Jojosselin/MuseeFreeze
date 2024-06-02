package controleur;

import java.util.List;
import java.util.stream.Collectors;

import dao.AlertesDAO;
import dao.ElementDeSecuriteDAO;
import dao.InfoTelephoneDAO;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import securite.Alertes;
import securite.ElementDeSecurite;
import securite.InfoTelephone;

public class TableViewController {
	private static TableViewController instance = null;
    
    public static TableViewController getInstance() {
        if (instance == null) {
            instance = new TableViewController();
        }
        return instance;
    }
    private TableViewController() {
       super();
    }
    
    public void initializeZoneTableViewElementDeSecurite(String filter, TableView<ElementDeSecurite> view, TableColumn<ElementDeSecurite, String> idColumn, TableColumn<ElementDeSecurite, String> nomColumn,TableColumn<ElementDeSecurite, String> modeleColumn, TableColumn<ElementDeSecurite, String> emplacementColumn, TableColumn<ElementDeSecurite, String> serveurColumn,TableColumn<ElementDeSecurite, String> etatColumn) {
        List<ElementDeSecurite> allElements = ElementDeSecuriteDAO.getInstance().readAll();
        List<ElementDeSecurite> filteredElements = allElements.stream()
                .filter(element -> element.getModele().startsWith(filter))
                .collect(Collectors.toList());

        view.getItems().setAll(filteredElements);
        idColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()+""));
        nomColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNom()+""));
        modeleColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getModele()+""));
        emplacementColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmplacement()+""));
        serveurColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getServeur()+""));
        etatColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEtat()+""));
    }
    
    public void initializeZoneTableViewTelephone(TableView<InfoTelephone> view, TableColumn<InfoTelephone, String> nomColumn, TableColumn<InfoTelephone, String> numeroColumn) {
        view.getItems().setAll(InfoTelephoneDAO.getInstance().readAll());
        nomColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNom()+""));
        numeroColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNumerotelephone()+""));
    }
    
    public void initializeZoneTableViewAlertes(TableView<Alertes> view, TableColumn<Alertes, String> nomColumn, TableColumn<Alertes, String> conditionColumn,  TableColumn<Alertes, String> valeurColumn,  TableColumn<Alertes, String> etatColumn) {
        view.getItems().setAll(AlertesDAO.getInstance().readAll());
        nomColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNom()+""));
        conditionColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCondition()+""));
        valeurColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getValeur()+""));
        etatColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEtat()+""));
    }
}