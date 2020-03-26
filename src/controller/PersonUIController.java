package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import objects.Person;
import objects.Room;
import sample.DaoManager;
import sample.DaoPerson;
import sample.viewManager;

import java.net.URL;
import java.sql.SQLOutput;
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

        this.lv_ausgabe.setItems(DaoPerson.getInstance().getListe_person());
        try{
            DaoPerson.getInstance().loadPersons();
        }catch(Exception e){
            System.out.println("initialize geht nicht von person");
        }
    }

    private Person getPerson() {
        Person person = new Person();
        try{

            if (this.id.getLength() > 0) {

                person.setId(Integer.parseInt(this.id.getText()));

            }
            person.setVorname(this.vorname.getText());
            person.setNachname(this.nachname.getText());
            person.setGeschlecht(this.geschlecht.getValue().toString());
            person.setPlz(this.postleitzahl.getText());
            person.setOrt(this.ort.getText());
            person.setStraße(this.straße.getText());
            person.setHausnummer(this.hausnummer.getText());
            person.setTelNummer(this.telefonnummer.getText());
            person.setEmail(this.email.getText());

        }catch(Exception e){
            System.out.println("Error getPerson");
            System.out.println(e.getMessage());
        }
        return person;
    }
    public void clickSafe(ActionEvent actionEvent) {
        try{
            Person person = this.getPerson();
            System.out.println(person.getId());
        if(person.getId() == null){
                DaoPerson.getInstance().addPerson(person);
                System.out.println("Neuanlage");
            } else {
                DaoPerson.getInstance().updatePerson(person);
                System.out.println("UPDATE");
                          }

        }catch(Exception e){
            System.out.println("save geht nicht");
            System.out.println(e.getMessage());
        }
    }

    public void clickDelete(ActionEvent actionEvent) {
        try {

            Person person = this.getPerson();

            DaoPerson.getInstance().loeschePerson(person);

            this.clearValues();
        } catch (Exception e) {
//            //TODO CAtch delete
            System.out.println("Delete klappt nicht");
            System.out.println(e.getMessage());
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
        Person person_safed = (Person) lv_ausgabe.getSelectionModel().getSelectedItem();
        id.setText(String.valueOf(person_safed.getId()));
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

    public void clickDataCreate(ActionEvent actionEvent) {
        Person can = new Person("Can", "Müller", "Männlich", "40227", "Ddorf", "Lauchstraße ", "1", "0123893404", "ichhabekeineemail@gmx.com");

        DaoPerson.getInstance().addPerson(can);
    }
}
