package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import objects.Computer;
import objects.Hardware;
import objects.Printer;
import objects.Room;
import sample.DaoManager;
import sample.viewManager;

import java.net.URL;
import java.util.ResourceBundle;

public class PrinterUIController extends HardwareController implements Initializable {

    @FXML
    public ListView<Hardware> lv_ausgabe;
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
    @FXML
    private ChoiceBox<Room> room;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        status.getItems().setAll(Printer.Status.values()); // weißt enum zur choiceBox zu
        technologie.getItems().setAll(Printer.Technik.values());
        papierformat.getItems().setAll(Printer.PapFormat.values());
        room.setItems(DaoManager.getInstance().getListe_raum());
        lv_ausgabe.getItems().setAll(DaoManager.getInstance().getListe_drucker());
    }


    public void lv_clicked() {
        Printer printer_safed = (Printer) lv_ausgabe.getSelectionModel().getSelectedItem();
        super.lv_clickedHardware(printer_safed); //Methode aus HardwareController wird aufgerufen und pc_safed übergeben

        farbdruckfunktion.setSelected(printer_safed.isFarbdruckfunktion());
        technologie.setValue(Printer.getTechnologieSchleife(printer_safed.getTechnologie()));
        papierformat.setValue(Printer.getPapFormatSchleife(printer_safed.getPapierformatmax()));
        druckseitengesamt.setText("" + printer_safed.getDruckseitengesamt());
        restkapazitaet.setText("" + printer_safed.getRestkapazitaet());
        kapazitaetbetriebsmittel.setText("" + printer_safed.getRestkapazitaet());
        room.setValue(printer_safed.getRoom());

    }

    public void clickCancel(ActionEvent actionEvent) {
        clearValues();
        lv_ausgabe.getSelectionModel().clearSelection();

    }

    public void clickSafe(ActionEvent actionEvent) {
        try {
            if (id.getText().isEmpty()) { //Neuanlage
                Printer printerTmp = new Printer(seriennummer.getText(), modell.getText(), hersteller.getText(), status.getSelectionModel().getSelectedItem().toString(), Integer.parseInt(herstellergarantie.getText()), lieferdatum.getValue(), technologie.getSelectionModel().getSelectedItem().toString(), farbdruckfunktion.isSelected(), papierformat.getSelectionModel().getSelectedItem().toString(), room.getSelectionModel().getSelectedItem());
                lv_ausgabe.getItems().add(printerTmp);
                DaoManager.getInstance().getListe_drucker().add(printerTmp);
            } else { //Update
                Printer printer_safed = (Printer) lv_ausgabe.getSelectionModel().getSelectedItem();
                super.lv_clickedSafe(printer_safed);

                printer_safed.setFarbdruckfunktion(farbdruckfunktion.isSelected());
                printer_safed.setTechnologie(technologie.getValue().toString());
                printer_safed.setPapierformatmax(papierformat.getValue().toString());
                printer_safed.setDruckseitengesamt(Integer.parseInt(druckseitengesamt.getText()));
                printer_safed.setRestkapazitaet(Integer.parseInt(restkapazitaet.getText()));
                printer_safed.setKapazitaetbetriebsmittel(Integer.parseInt(kapazitaetbetriebsmittel.getText()));
                printer_safed.setRoom(room.getValue());
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Sie haben Möglicherweise ein Feld leer gelassen\nBitte nur Zahlen bei Ram/SSD/HDD eingeben").showAndWait();

        }
        lv_ausgabe.refresh();
        clearValues();
    }

    public void clickDashboard(ActionEvent actionEvent) {
        viewManager.getInstance()
                .activateScene(viewManager.getInstance()
                        .getDashboardscene());
    }

    public void clearValues() {
        id.clear();
        seriennummer.clear();
        modell.clear();
        hersteller.clear();
        status.setValue(null);
        herstellergarantie.clear();
        lieferdatum.setValue(null);
        technologie.setValue(null);
        farbdruckfunktion.setSelected(false);
        papierformat.setValue(null);
        druckseitengesamt.clear();
        restkapazitaet.clear();
        kapazitaetbetriebsmittel.clear();
        room.setValue(null);
    }


}
