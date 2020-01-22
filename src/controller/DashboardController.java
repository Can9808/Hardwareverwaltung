package controller;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import sample.viewManager;

public class DashboardController {
    public Button ButtonDruckerverwaltung;
    public Button ButtonRechnerverwaltung;

    public void clickedDruckerverwaltung(MouseEvent mouseEvent) {
        viewManager.getInstance()
                .activateScene(viewManager.getInstance()
                        .getScene_viewPrinter());
    }

    public void clickedRechnerButton(MouseEvent mouseEvent) {
        viewManager.getInstance()
                .activateScene(viewManager.getInstance()
                        .getScene_viewComputer());

    }

    public void clickedRaumButton(MouseEvent mouseEvent) {
        viewManager.getInstance()
                .activateScene(viewManager.getInstance()
                        .getScene_viewRoom());
    }
}
