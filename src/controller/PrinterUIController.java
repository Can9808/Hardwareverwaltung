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
import java.time.LocalDate;
import java.util.Collection;
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
        room.getItems().setAll(DaoManager.getInstance().getListe_raum());

        lv_ausgabe.getItems().setAll(DaoManager.getInstance().getListe_drucker());
    }


    public void lv_clicked() {
        Printer printer_safed = (Printer) lv_ausgabe.getSelectionModel().getSelectedItem();
        super.lv_clickedHardware(printer_safed); //Methode aus HardwareController wird aufgerufen und pc_safed übergeben
//TODO anpassen
//        cpu.setText(printer_safed.getCpu());
//        ram.setText(""+pc_safed.getArbeitspeicher());
//        betriebssystem.setText(pc_safed.getBetriebssystem());
//        typ.setValue(Computer.getTyp(pc_safed.getTyp()));
//        grafikkarte.setText(pc_safed.getGrafikkarte());
//        hdd.setText(""+pc_safed.getFestplatte_hdd());
//        ssd.setText(""+pc_safed.getFestplatte_ssd());
    }

    public void clickCancel(ActionEvent actionEvent) {
        clearValues();
    }

    public void clickSafe(ActionEvent actionEvent) {
        try {
            lv_ausgabe.getItems().add(new Printer(seriennummer.getText(), modell.getText(), hersteller.getText(), status.getSelectionModel().getSelectedItem().toString(), Integer.parseInt(herstellergarantie.getText()), lieferdatum.getValue(), technologie.getSelectionModel().getSelectedItem().toString(), farbdruckfunktion.isSelected(), papierformat.getSelectionModel().getSelectedItem().toString(), room.getSelectionModel().getSelectedItem()));
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

    public void clearValues() { //TODO in Hardware?
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
