package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import objects.Computer;
import objects.Hardware;
import objects.Printer;
import objects.Room;
import sample.DaoManager;
import sample.viewManager;

import java.net.URL;
import java.util.ResourceBundle;

public class RoomUIController implements Initializable {

    @FXML
    private TextField id;
    @FXML
    private ChoiceBox<Room.Typ> typ;
    @FXML
    private TextField size;
    @FXML
    public ListView<Room> lv_ausgabe;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        typ.getItems().setAll(Room.Typ.values());
        lv_ausgabe.getItems().setAll(DaoManager.getInstance().getListe_raum());
    }

    public void clickHardware(ActionEvent actionEvent) {
        Room room = lv_ausgabe.getSelectionModel().getSelectedItem();
        String hardwareString = "";
        for(Hardware hardware : room.getHardware()){
            hardwareString += ""+hardware.getId() +";"+ hardware.getSeriennummer()+ "\n";
        }
        new Alert(Alert.AlertType.INFORMATION,
                hardwareString).showAndWait();

    }

    public void clickSafe(ActionEvent actionEvent) { //TODO ID darf niht alles sein
        try{
            lv_ausgabe.getItems().add(new Room(id.getText(), typ.getSelectionModel().getSelectedItem().toString(), Integer.parseInt(size.getText())));
            clearValues();
        }catch(Exception e){
            Alert Test = new Alert(Alert.AlertType.ERROR, "Sie haben Möglicherweise ein Feld leer gelassen\nBitte m² nur Zahlen eingeben");
            Test.showAndWait();
        }


    }

    public void clickCancel(ActionEvent actionEvent) {
        clearValues();

    }

    public void clickDashboard(ActionEvent actionEvent) {
        viewManager.getInstance()
                .activateScene(viewManager.getInstance()
                        .getDashboardscene());
    }

    public void lv_clicked(MouseEvent mouseEvent) {
        Room room_safed = lv_ausgabe.getSelectionModel().getSelectedItem();
        //TODO oben laden
    }
    public void clearValues(){
        id.clear();
        typ.setValue(null);
        size.clear();
    }
}
