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
import objects.Room;
import sample.DaoManager;
import sample.viewManager;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class RoomUIController implements Initializable {

    @FXML
    private TextField id;
    @FXML
    private ChoiceBox<Room.TypRoom> typ;
    @FXML
    private TextField size;
    @FXML
    public ListView<Room> lv_ausgabe;

    private boolean onUpdate = false;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        typ.getItems().setAll(Room.TypRoom.values());
        lv_ausgabe.getItems().setAll(DaoManager.getInstance().getListe_raum());
    }

    public void clickHardware(ActionEvent actionEvent) {
        Room room = lv_ausgabe.getSelectionModel().getSelectedItem();
        String hardwareString = "";
        for (Hardware hardware : room.getHardware()) {
            hardwareString += "" + hardware.getId() + ";" + hardware.getSeriennummer() + "\n";
        }
        new Alert(Alert.AlertType.INFORMATION,
                hardwareString).showAndWait();

    }

    public void clickSafe(ActionEvent actionEvent) {
        try {
//            System.out.println(onUpdate);
            if (onUpdate == false) {
                if (Pattern.matches("[A-Z]\\d\\d\\d", id.getText())) { //Prüfung
                    Room tmpRoom = new Room(id.getText(), typ.getSelectionModel().getSelectedItem().toString(), Integer.parseInt(size.getText()));
                    lv_ausgabe.getItems().add(tmpRoom);
                    DaoManager.getInstance().getListe_raum().add(tmpRoom);
                } else {
                    System.out.println("LAUCH");
                    new Alert(Alert.AlertType.ERROR, "ID Darf nur aus einer Buchstabe und drei Zahlen bestehen").showAndWait();

                }
                clearValues();
            } else {
                System.out.println("update");
                Room room_safed = (Room) lv_ausgabe.getSelectionModel().getSelectedItem();
                room_safed.setId(id.getText()); // zeigt id als wert an???
                room_safed.setSize(Double.parseDouble(size.getText()));
                room_safed.setTyp(typ.getValue().toString());
                lv_ausgabe.refresh();
                clearValues();
                onUpdate = false;
            }

        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Sie haben Möglicherweise ein Feld leer gelassen\nBitte m² nur Zahlen eingeben").showAndWait();
        }


    }

    public void clickCancel(ActionEvent actionEvent) {
        clearValues();
        lv_ausgabe.getSelectionModel().clearSelection();
        onUpdate = false;

    }

    public void clickDashboard(ActionEvent actionEvent) {
        viewManager.getInstance()
                .activateScene(viewManager.getInstance()
                        .getDashboardscene());
    }

    public void lv_clicked(MouseEvent mouseEvent) {
        Room room_safed = lv_ausgabe.getSelectionModel().getSelectedItem();
        id.setText(room_safed.getId());
        typ.setValue(Room.getTypRaumLoop(room_safed.getTyp()));
        size.setText(String.valueOf(room_safed.getSize()));
        onUpdate = true;
    }

    public void clearValues() {
        id.clear();
        typ.setValue(null);
        size.clear();
    }
}
