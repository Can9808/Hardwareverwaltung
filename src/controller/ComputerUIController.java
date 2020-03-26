package controller;

import objects.Computer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import objects.Hardware;
import objects.Room;
import sample.DaoManager;
import sample.viewManager;

import java.net.URL;
import java.util.ResourceBundle;

public class ComputerUIController extends HardwareController implements Initializable {

    //<editor-fold desc="FXML Atributes">
    @FXML
    public ListView<Hardware> lv_ausgabe;

    @FXML
    private TextField cpu;
    @FXML
    private TextField ram;
    @FXML
    private TextField betriebssystem;
    @FXML
    private ChoiceBox<Computer.Typ> typ;
    @FXML
    private TextField grafikkarte;
    @FXML
    private TextField ssd;
    @FXML
    private TextField hdd;
    @FXML
    private ChoiceBox<Room> room;


    //</editor-fold>

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        status.getItems().setAll(Computer.Status.values()); // weißt enum zur choiceBox zu
        typ.getItems().setAll(Computer.Typ.values());

        room.setItems(DaoManager.getInstance().getListe_raum());

        lv_ausgabe.getItems().setAll(DaoManager.getInstance().getListe_rechner());


    }

    public void lv_clicked() {

        Computer pc_safed = (Computer) lv_ausgabe.getSelectionModel().getSelectedItem(); //wird geholt und in pc_safed gespeichert

        super.lv_clickedHardware(pc_safed); //Methode aus HardwareController wird aufgerufen und pc_safed übergeben
        cpu.setText(pc_safed.getCpu());
        ram.setText("" + pc_safed.getArbeitspeicher());
        betriebssystem.setText(pc_safed.getBetriebssystem());
        typ.setValue(Computer.getTypLoop(pc_safed.getTyp()));
        grafikkarte.setText(pc_safed.getGrafikkarte());
        hdd.setText("" + pc_safed.getFestplatte_hdd());
        ssd.setText("" + pc_safed.getFestplatte_ssd());
        room.setValue(pc_safed.getRoom());

    }

    public void clickSafe(ActionEvent actionEvent) {
        try {
            if (id.getText().isEmpty()) { //Prüfung ob id empty -> neuanlage || != -> update
//                System.out.printf(id.getText());
                 System.out.println("Neuanlagae");
                Computer tmpComputer = new Computer(seriennummer.getText(), modell.getText(), hersteller.getText(), status.getSelectionModel().getSelectedItem().toString(), Integer.parseInt(herstellergarantie.getText()), lieferdatum.getValue(), cpu.getText(), Integer.parseInt(ram.getText()), betriebssystem.getText(), typ.getSelectionModel().getSelectedItem().toString(), grafikkarte.getText(), Integer.parseInt(hdd.getText()), Integer.parseInt(ssd.getText()), room.getSelectionModel().getSelectedItem());
                lv_ausgabe.getItems().add(tmpComputer);
                DaoManager.getInstance().getListe_rechner().add(tmpComputer);
            } else {
                Computer pc_safed = (Computer) lv_ausgabe.getSelectionModel().getSelectedItem();
                //System.out.println("vorhanden");
//                 System.out.println(id.getText());
                super.lv_clickedSafe(pc_safed);
                pc_safed.setCpu(cpu.getText());
                pc_safed.setArbeitspeicher(Integer.parseInt(ram.getText()));
                pc_safed.setBetriebssystem(betriebssystem.getText());
                pc_safed.setTyp(typ.getValue().toString());
                pc_safed.setGrafikkarte(grafikkarte.getText());
                pc_safed.setFestplatte_hdd(Integer.parseInt(hdd.getText()));
                pc_safed.setFestplatte_ssd(Integer.parseInt(ssd.getText()));

                pc_safed.setRoom(room.getValue());
                lv_ausgabe.refresh();
            }
            clearValues();

        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Sie haben Möglicherweise ein Feld leer gelassen\nBitte nur Zahlen bei Ram/SSD/HDD eingeben").showAndWait();

        }
    }

    public void clickCancel(ActionEvent actionEvent) {
        clearValues();
        lv_ausgabe.getSelectionModel().clearSelection();

    }

    @FXML
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
        cpu.clear();
        ram.clear();
        betriebssystem.clear();
        typ.setValue(null);
        grafikkarte.clear();
        hdd.clear();
        ssd.clear();
        room.setValue(null);
    }
}

