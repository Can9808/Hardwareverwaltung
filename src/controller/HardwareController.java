package controller;

import objects.Computer;
import objects.Hardware;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public abstract class HardwareController {

    @FXML
    protected ListView<Computer> lv_ausgabe;

    @FXML
    protected TextField id;

    @FXML
    protected TextField seriennummer;

    @FXML
    protected TextField modell;

    @FXML
    protected TextField hersteller;

    @FXML
    protected ChoiceBox<Computer.Status> status;

    @FXML
    protected TextField herstellergarantie;

    @FXML
    protected DatePicker lieferdatum;


    public void lv_clickedHardware(Hardware info_Safed) {
        id.setText("" + info_Safed.getId());
        seriennummer.setText(info_Safed.getSeriennummer());
        modell.setText(info_Safed.getModell());
        hersteller.setText(info_Safed.getHersteller());
        status.setValue(Hardware.getStatus(info_Safed.getStatusString()));
        herstellergarantie.setText("" + info_Safed.getHerstellergarantie());
        lieferdatum.setValue(info_Safed.getLieferdatum());
    }

    public void lv_clickedSafe(Hardware info_Safed) {
        info_Safed.setSeriennummer(seriennummer.getText());
        info_Safed.setModell(modell.getText());
        info_Safed.setHersteller(hersteller.getText());
        info_Safed.setStatus(status.getValue().toString());
        info_Safed.setHerstellergarantie(Integer.parseInt(herstellergarantie.getText()));
        info_Safed.setLieferdatum(lieferdatum.getValue());
    }

}