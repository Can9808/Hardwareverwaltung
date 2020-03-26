package sample;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import objects.Person;
import org.hibernate.HibernateError;
import org.hibernate.Session;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws DBconException {


        try {
            HibernateManager.getInstance().setDbname("hardwareverwaltung_06");
            HibernateManager.getInstance().addAnnotatedClass(Person.class);
            HibernateManager.getInstance().buildSessionFactory();

            System.out.println("Verbindung ist erfolgreich");
        } catch (DBconException e) {
            System.out.println(e.getMessage());
            System.out.println("Error in der Datenbank Verbindung!");
            new Alert(Alert.AlertType.ERROR, "Die Datenbank Verbindung konnte nicht hergestellt werden.\n Überprüfen Sie die Datenbank verbindung!").showAndWait();

        }

        viewManager.getInstance()
                .setStage(primaryStage);

        primaryStage.setTitle("Dashboard");
        primaryStage.setResizable(false);
        primaryStage.setX(500);
        primaryStage.setY(100);

        viewManager.getInstance()
                .activateScene(viewManager.getInstance()
                        .getDashboardscene());


    }

}
