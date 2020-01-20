package hardware;

import javafx.scene.control.Alert;

import java.time.LocalDate;

public class Printer extends Hardware {
    private static int anzahl = 0;
    private String technologie;
    private boolean farbdruckfunktion;
    private String papierformatmax;
    private int druckseitengesamt;
    private int restkapazitaet = 200;
    private int kapazitaetbetriebsmittel = 200;

    public Printer() {
        anzahl++;
        this.id = anzahl;

    }

    public Printer(String seriennummer, String modell, String hersteller, String status, int herstellergarantie, LocalDate lieferdatum, String technologie, boolean farbdruckfunktion, String papierfromatmax) {
        this();
        this.seriennummer = seriennummer;
        this.modell = modell;
        this.hersteller = hersteller;
        this.status = status;
        this.herstellergarantie = herstellergarantie;
        this.lieferdatum = lieferdatum;
        this.technologie = technologie;
        this.farbdruckfunktion = farbdruckfunktion;
        this.papierformatmax = papierformatmax;
    }

    @Override
    public String toString() {
        return "ID: " + this.id + ";" + this.seriennummer + ";"
                + this.modell + ";" + this.hersteller + ";" + this.status +
                ";" + this.herstellergarantie + ";" + this.lieferdatum.toString() +
                ";" + this.technologie + "," + this.farbdruckfunktion +
                ";" + this.papierformatmax + ";" + this.druckseitengesamt +
                ";" + this.restkapazitaet + ";" + this.kapazitaetbetriebsmittel + ";";
    }

    public void wechseleBetriebsmittel(int kapazitaet) {
        if (kapazitaet <= 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR,
                    "Fehler");
            alert.showAndWait();
        } else {
            this.restkapazitaet = kapazitaet;
            this.kapazitaetbetriebsmittel = kapazitaet;
        }
    }

    public void drucken(int anzahlseiten) {
        if (anzahlseiten > 0) {
            if (anzahlseiten < restkapazitaet) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION,
                        anzahlseiten + " Seiten erfolgreich gedruckt");
                alert.showAndWait();
                druckseitengesamt += anzahlseiten;
                restkapazitaet -= anzahlseiten;
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING,
                        "Es konnten nur " + this.restkapazitaet + " Seiten erfolgreich gedruckt werden!\nBitte wechseln Sie das Betriebsmittel!");
                alert.showAndWait();
                restkapazitaet = 0;
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION,
                    "Fehler");
            alert.showAndWait();
        }
    }

    public enum Technik {
        WERT1("Farbtintenstrahldrucker"),
        WERT2("Tintenstrahldrucker"),
        WERT3("Farblaserdrucker"),
        WERT4("Laserdrucker");

        private String value;

        Technik(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return this.value;
        }
        }
        public enum PapFormat{
            A3("A3"),
            A4("A4");

            private String value;

            PapFormat(String value) {
                this.value = value;
            }

            public String getValue() {
                return value;
            }

            @Override
            public String toString() {
                return this.value;
            }
        }
}



