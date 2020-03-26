package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import objects.Person;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

public class DaoPerson {
    private static DaoPerson daoperson = null;
    private ObservableList<Person> liste_person;

    private DaoPerson() {
        this.liste_person = FXCollections.observableArrayList();
        this.loadPersons();
    }

    public ObservableList<Person> getListe_person() {
        return this.liste_person;
    }

    public static DaoPerson getInstance() {
        if (DaoPerson.daoperson == null) {
            DaoPerson.daoperson = new DaoPerson();
        }
        return daoperson;
    }

    public void addPerson(Person person) {
        try {
            if (person.getVorname() != null && person.getNachname() != null && person.getGeschlecht() != null && person.getPlz() != null && person.getOrt() != null && person.getStraße() != null && person.getHausnummer() != null && person.getTelNummer() != null && person.getEmail() != null) {
                Session session = HibernateManager.getInstance().getNewSession();
                session.beginTransaction();
                session.save(person);
                session.getTransaction().commit();
                session.close();

                this.updatePersonList(); //UPDATED DIE LISTE IM FXML
                System.out.println("Neuer Mensch wurde hinzugefügt");
            }

        } catch (Exception e) {
            System.out.println("klappt nicht");
            new Alert(Alert.AlertType.ERROR, "Ups da ist etwas schief gelaufen!\nPPerson konnte nicht hinzugefügt werden.... :(").showAndWait();
        }
    }

    public void updatePersonList() {
        try {
            this.liste_person.clear();
            Session session = HibernateManager.getInstance().getNewSession();
            session.beginTransaction();

            List allUsers;
            Query queryResult = session.createQuery("FROM Person");
            allUsers = queryResult.getResultList();
            System.out.println(allUsers.size());

            int z = allUsers.size();
            for (int i = 1; i <= z; i++) {
                Person person = session.get(Person.class, i);
                if (person != null) {
                    this.liste_person.add(person);
                } else {
                    System.out.println(i + "person ist null");
                    z++;
                }
            }
            session.getTransaction().commit();
            session.close();

            System.out.println("Liste wurde geupdated");
        } catch (Exception e) {
            System.out.println("geht nicht");
            //TODO Update catch
            System.out.println(e.getMessage());

        }
    }

    public void updatePerson(Person person) {
        try {
//            Person personDB;
            Session session = HibernateManager.getInstance().getNewSession();
            session.beginTransaction();
            session.update(person);
            session.getTransaction().commit();
            session.close();
            this.updatePersonList();
            System.out.println("Person wurde erfolgreich geupdated");
        } catch (Exception e) {
            System.out.println(("UPDATE klappt nicht"));
            new Alert(Alert.AlertType.ERROR, "Ups da ist etwas schief gelaufen!\nPPerson konnte nicht geupdatet werden.... :(").showAndWait();

            System.out.println(e);
        }
    }


    public void loeschePerson(Person person) {

        if (person.getId() != null) {
            try {

                Session session = HibernateManager.getInstance().getNewSession();
                session.beginTransaction();
                person = session.get(Person.class, person.getId());
//                System.out.printf(person.toString());
//                System.out.println("\ncan wurde gelöscht");
                session.delete(person);
                session.getTransaction().commit();
                session.close();
                this.updatePersonList();
                System.out.println("Person wurde erfolgreich gelöscht");
            } catch (Exception e) {
                System.out.println(e.getMessage());
                new Alert(Alert.AlertType.ERROR, "Ups da ist etwas schief gelaufen!\nPerson konnte nicht gelöscht werden.... :(").showAndWait();

            }
        } else {
            System.out.println("keine ID");
            //TODO keine ID beim läschen
        }
    }

    public void loadPersons() {
        try {
            this.updatePersonList();
        }
        catch(Exception e){
                System.out.println("Beispieldaten konnten nicht geladen werden");
            }
        }
    }


//Update
//DELETE
//INSERT
