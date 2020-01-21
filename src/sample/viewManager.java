package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class viewManager {
    private static viewManager viewmanager = null;

    private Scene scene_viewPrinter = null;
    private Scene scene_viewComputer = null;
    private Scene scene_viewRoom = null;
    private Scene scene_dashboard = null;
    private Pane pane_dashboard = null;
    private Pane pane_viewPrinter = null;
    private Pane pane_viewComputer = null;
    private Pane pane_viewRoom = null;

    private Stage primarystage = null;

    private viewManager()
    {
        try
        {

            this.pane_viewPrinter =
                    FXMLLoader.load(getClass()
                            .getResource("/ui/PrinterUI.fxml"));
            this.pane_viewComputer =
                    FXMLLoader.load(getClass()
                            .getResource("/ui/ComputerUI.fxml"));
            this.pane_viewRoom =
                    FXMLLoader.load(getClass()
                        .getResource("/ui/RoomUI.fxml"));
            this.pane_dashboard =
                    FXMLLoader.load(getClass()
                            .getResource("/ui/DashboardUI.fxml"));


            this.scene_viewPrinter = new Scene(pane_viewPrinter);
            this.scene_viewComputer = new Scene(pane_viewComputer);
            this.scene_viewRoom = new Scene(pane_viewRoom);
            this.scene_dashboard = new Scene(pane_dashboard);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR,
                    e.getMessage());
            alert.showAndWait();
        }
    }

    public static viewManager getInstance()
    {
        if (viewManager.viewmanager == null)
        {
            viewManager.viewmanager = new viewManager();
        }
        return viewManager.viewmanager;
    }

    /**
     * @param scene
     */
    public void activateScene(Scene scene)
    {
        this.primarystage.setScene(scene);
        this.primarystage.show();
    }

    /**
     * @param primaryStage
     */
    public void setStage(Stage primaryStage)
    {
        this.primarystage = primaryStage;
    }


    public Scene getScene_viewPrinter()
    {
        return this.scene_viewPrinter;
    }

    public Scene getScene_viewComputer()
    {
        return this.scene_viewComputer;
    }

    public Scene getDashboardscene()
    {
        return this.scene_dashboard;
    }

    public Scene getScene_viewRoom() {return this.scene_viewRoom;}

}
