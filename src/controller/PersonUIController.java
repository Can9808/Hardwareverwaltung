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
import objects.Person;
import sample.DaoManager;
import sample.viewManager;

import java.net.URL;
import java.util.ResourceBundle;

public class PersonUIController implements Initializable {
    @FXML
    public ListView<Person> lv_ausgabe;
    @FXML
    public TextField id;
    @FXML
    public TextField vorname;
    @FXML
    public TextField nachname;
    @FXML
    public ChoiceBox<Person.Geschlecht> geschlecht;
    @FXML
    public TextField postleitzahl;
    @FXML
    public TextField ort;
    @FXML
    public TextField straße;
    @FXML
    public TextField hausnummer;
    @FXML
    public TextField telefonnummer;
    @FXML
    public TextField email;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        geschlecht.getItems().setAll(Person.Geschlecht.values()); // weißt enum zur choiceBox zu
    }

    public void clickSafe(ActionEvent actionEvent) {
        //Person tmpPerson = new Person("Can", "Boruk", "Männlich", 40231, "Düsseldorf", "Am Karlshof", 1, "01621867639", "IchHabeKeineEMial@google.com");
        //lv_ausgabe.getItems().add(tmpPerson);
        try {
            if (id.getText().isEmpty()) { //Prüfung ob id empty -> neuanlage || != -> update
                System.out.println("neuanlage");
                Person tmpPerson = new Person(vorname.getText(), nachname.getText(), geschlecht.getSelectionModel().getSelectedItem().toString(), Integer.parseInt(postleitzahl.getText()), ort.getText(), straße.getText(), Integer.parseInt(hausnummer.getText()), telefonnummer.getText(), email.getText());
                lv_ausgabe.getItems().add(tmpPerson);
//            DaoManager.getInstance().getListe_Person().add(tmpPerson); //TODO ID? DAOMANAGER SPEICHERN?
            } else {
                System.out.println("UPDATE");
                Person person_safed = (Person) lv_ausgabe.getSelectionModel().getSelectedItem();
                person_safed.setVorname(vorname.getText());
                person_safed.setNachname(nachname.getText());
                person_safed.setGeschlecht(geschlecht.getValue().toString());
                person_safed.setPlz(Integer.parseInt(postleitzahl.getText()));
                person_safed.setOrt(ort.getText());
                person_safed.setStraße(straße.getText());
                person_safed.setHausnummer(Integer.parseInt(hausnummer.getText()));
                person_safed.setTelNummer(telefonnummer.getText());
                person_safed.setEmail(email.getText());
            }
            clearValues();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Sie haben Möglicherweise ein Feld leer gelassen\nBitte nur Zahlen bei Ram/SSD/HDD eingeben").showAndWait();

        }
    }

    public void clickDelete(ActionEvent actionEvent) {

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
        Person person_safed = (Person) lv_ausgabe.getSelectionModel().getSelectedItem();
//        id.setText(person_safed.getId().toString()); //TODO ID nicht ausgefüllt?
        vorname.setText(person_safed.getVorname());
        nachname.setText(person_safed.getNachname());
        geschlecht.setValue(Person.getGeschlechtLoop(person_safed.getGeschlecht()));
        postleitzahl.setText(person_safed.getPlz().toString());
        ort.setText(person_safed.getOrt());
        straße.setText(person_safed.getStraße());
        hausnummer.setText(person_safed.getHausnummer().toString());
        telefonnummer.setText(person_safed.getTelNummer());
        email.setText(person_safed.getEmail());
    }

    public void clearValues() {
        id.clear();
        vorname.clear();
        nachname.clear();
        geschlecht.setValue(null);
        postleitzahl.clear();
        ort.clear();
        straße.clear();
        hausnummer.clear();
        telefonnummer.clear();
        email.clear();
    }

}
