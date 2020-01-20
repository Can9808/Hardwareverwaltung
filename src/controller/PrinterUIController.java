package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import hardware.Printer;
import sample.viewManager;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class PrinterUIController extends HardwareController implements Initializable {

    @FXML
    public ListView<Printer> lv_ausgabe;
    @FXML
    private CheckBox farbdruckfunktion;

    @FXML
    private ChoiceBox<Printer.Technik> technologie;


    @FXML
    private ChoiceBox<Printer.PapFormat> papierformat;

    @FXML
    private TextField druckseitengesamt;

    @FXML
    private TextField restkapazitaet;

    @FXML
    private TextField kapazitaetbetriebsmittel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        status.getItems().setAll(Printer.Status.values()); // weißt enum zur choiceBox zu
        technologie.getItems().setAll(Printer.Technik.values());
        papierformat.getItems().setAll(Printer.PapFormat.values());
        loadHardware();
    }

    public void loadHardware() {
        lv_ausgabe.getItems().add(new Printer("S001", "HP DeskJet 2630", "HP", "Ok", 12, LocalDate.parse("2018-11-11"), "Tintenstrahldrucker", true, "A4"));
        lv_ausgabe.getItems().add(new Printer("S002", "Samsung XPRESS C480FW", "Samsung", "Defekt", 24, LocalDate.parse("2019-09-03"), "Farblaserdrucker", true, "A3"));
        lv_ausgabe.getItems().add(new Printer("S003", "Brother MFC-J6930DW", "Brother", "In Reperatur", 36, LocalDate.parse("2019-09-03"), "Farbtintenstrahldrucker", true, "A3"));
    }

    public void lv_clicked() {
        Printer printer_safed = lv_ausgabe.getSelectionModel().getSelectedItem();
    }

    public void clickCancel(ActionEvent actionEvent) {
        clearValues();
    }

    public void clickSafe(ActionEvent actionEvent) {
        try {
            lv_ausgabe.getItems().add(new Printer(seriennummer.getText(), modell.getText(), hersteller.getText(), status.getSelectionModel().getSelectedItem().toString(), Integer.parseInt(herstellergarantie.getText()), lieferdatum.getValue(), technologie.getSelectionModel().getSelectedItem().toString(), farbdruckfunktion.isSelected(), papierformat.getSelectionModel().getSelectedItem().toString()));
        }catch (Exception e) {
            Alert Test = new Alert(Alert.AlertType.ERROR, "Sie haben Möglicherweise ein Feld leer gelassen\nBitte nur Zahlen bei Ram/SSD/HDD eingeben");
            Test.showAndWait();
        }
        clearValues();
    }

    public void clickDashboard(ActionEvent actionEvent) {
        viewManager.getInstance()
                .activateScene(viewManager.getInstance()
                        .getDashboardscene());
    }

    public void clearValues() {
        seriennummer.clear();
        modell.clear();
        hersteller.clear();
        status.setValue(null);
        herstellergarantie.clear();
        lieferdatum.setValue(null);
        technologie.setValue(null);
        farbdruckfunktion.setSelected(false);
        papierformat.getItems().clear();
    }

}
