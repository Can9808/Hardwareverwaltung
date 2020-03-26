package objects;

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

    public static int getAnzahl() {
        return anzahl;
    }

    public String getTechnologie() {
        return technologie;
    }

    public boolean isFarbdruckfunktion() {
        return farbdruckfunktion;
    }

    public String getPapierformatmax() {
        return papierformatmax;
    }

    public int getDruckseitengesamt() {
        return druckseitengesamt;
    }

    public int getRestkapazitaet() {
        return restkapazitaet;
    }

    public int getKapazitaetbetriebsmittel() {
        return kapazitaetbetriebsmittel;
    }

    public static void setAnzahl(int anzahl) {
        Printer.anzahl = anzahl;
    }

    public void setTechnologie(String technologie) {
        this.technologie = technologie;
    }

    public void setFarbdruckfunktion(boolean farbdruckfunktion) {
        this.farbdruckfunktion = farbdruckfunktion;
    }

    public void setPapierformatmax(String papierformatmax) {
        this.papierformatmax = papierformatmax;
    }

    public void setDruckseitengesamt(int druckseitengesamt) {
        this.druckseitengesamt = druckseitengesamt;
    }

    public void setRestkapazitaet(int restkapazitaet) {
        this.restkapazitaet = restkapazitaet;
    }

    public void setKapazitaetbetriebsmittel(int kapazitaetbetriebsmittel) {
        this.kapazitaetbetriebsmittel = kapazitaetbetriebsmittel;
    }

    public Printer(String seriennummer, String modell, String hersteller, String status, int herstellergarantie, LocalDate lieferdatum, String technologie, boolean farbdruckfunktion, String papierfromatmax, Room room) {
        super(room);
        anzahl++;
        this.id = anzahl;
        this.seriennummer = seriennummer;
        this.modell = modell;
        this.hersteller = hersteller;
        this.status = status;
        this.herstellergarantie = herstellergarantie;
        this.lieferdatum = lieferdatum;
        this.technologie = technologie;
        this.farbdruckfunktion = farbdruckfunktion;
        this.papierformatmax = papierfromatmax;
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
                new Alert(Alert.AlertType.ERROR, "Es konnten nur " + this.restkapazitaet + " Seiten erfolgreich gedruckt werden!\nBitte wechseln Sie das Betriebsmittel!").showAndWait();
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

    public enum PapFormat {
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

    public static Printer.Technik getTechnologieSchleife(String ty) {
        for (Printer.Technik tmpTechnik : Printer.Technik.values()) {
            if (ty == tmpTechnik.value) {
                return tmpTechnik;
            }
        }
        return null;
    }

    public static Printer.PapFormat getPapFormatSchleife(String ty) {
        for (Printer.PapFormat tmpPapFormat : Printer.PapFormat.values()) {
            if (ty == tmpPapFormat.value) {
                return tmpPapFormat;
            }
        }
        return null;
    }
}



