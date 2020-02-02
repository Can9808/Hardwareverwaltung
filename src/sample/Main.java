package sample;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //TODO Datenbank con öffnen
        try {
            DaoManager.getInstance().openDBconnection();
            DaoManager.getInstance().DBCommandAusführen();
            DaoManager.getInstance().closeDBconnection();
        }catch(DBconException E) {
            System.out.println(E.getMessage());

//            Error fenster
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
        //TODO Datenbank con schließen
//        stmt.close();
//        con.close();
    }

}
