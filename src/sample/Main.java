package sample;

import hardware.Printer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.time.LocalDate;

public class Main extends Application {


    public static void main(String[] args) {
        launch(args);

    }
@Override
    public void start(Stage primaryStage) throws Exception {
//        Printer Dieter = new Printer("S001", "HP DeskJet 2630", "HP", "ok", 12, LocalDate.parse("2018-11-11"), "Tintenstrahldrucker", true, "A4");
//        String lieferdatumx = Dieter.getLieferdatum().toString();
//        String garantieendex = Dieter.berechneGarantieende().toString();
//        Alert alert = new Alert(Alert.AlertType.INFORMATION,
//                "Lieferdatum: " +lieferdatumx +"\nGarantieende: "+garantieendex);
//        alert.showAndWait();
//        Dieter.drucken(150);
//        Dieter.drucken(100);
//        Dieter.wechseleBetriebsmittel(2000);
//        Dieter.drucken(1000);
//        Alert alert2 = new Alert(Alert.AlertType.INFORMATION,
//                Dieter.toString());
//        alert2.showAndWait();


//        Parent root = FXMLLoader.load(getClass().getResource("/UI/PrinterUI.fxml"));
////
////        Scene scene = new Scene(root);
////        primaryStage.setScene(scene);
////        primaryStage.setTitle("Druckerverwaltung 01");
////        primaryStage.setResizable(false);
////        primaryStage.show();

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
