package controller;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import sample.DaoManager;
import sample.DaoPerson;
import sample.viewManager;

import java.util.concurrent.ExecutionException;

public class DashboardController {
    public Button ButtonDruckerverwaltung;
    public Button ButtonRechnerverwaltung;
    public Button ButtonRaum;
    public Button ButtonCreateDatabase;

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

    public void clickedPersButton(MouseEvent mouseEvent) {
        DaoPerson.getInstance().updatePersonList();
        viewManager.getInstance()
                .activateScene(viewManager.getInstance().getScene_viewPerson());
    }
}
