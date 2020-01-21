package objects;

import java.time.LocalDate;

public class Computer extends Hardware {
    private static int anzahl = 0;
    private String cpu;
    private int arbeitspeicher;
    private String betriebssystem;
    private String typ;
    private String grafikkarte;
    private Integer festplatte_ssd;
    private Integer festplatte_hdd;

    public static int getAnzahl() {
        return anzahl;
    }
    public String getCpu() {
        return cpu;
    }
    public int getArbeitspeicher() {
        return arbeitspeicher;
    }
    public String getBetriebssystem() {
        return betriebssystem;
    }
    public String getTyp() {
        return typ;
    }
    public String getGrafikkarte() {
        return grafikkarte;
    }
    public Integer getFestplatte_ssd() {
        return festplatte_ssd;
    }
    public Integer getFestplatte_hdd() {
        return festplatte_hdd;
    }

    public static void setAnzahl(int anzahl) {
        Computer.anzahl = anzahl;
    }
    public void setCpu(String cpu) {
        this.cpu = cpu;
    }
    public void setArbeitspeicher(int arbeitspeicher) {
        this.arbeitspeicher = arbeitspeicher;
    }
    public void setBetriebssystem(String betriebssystem) {
        this.betriebssystem = betriebssystem;
    }
    public void setTyp(String typ) {
        this.typ = typ;
    }
    public void setGrafikkarte(String grafikkarte) {
        this.grafikkarte = grafikkarte;
    }
    public void setFestplatte_ssd(Integer festplatte_ssd) {
        this.festplatte_ssd = festplatte_ssd;
    }
    public void setFestplatte_hdd(Integer festplatte_hdd) {
        this.festplatte_hdd = festplatte_hdd;
    }


    public Computer(String seriennummer, String modell, String hersteller, String status, int herstellergarantie, LocalDate lieferdatum, String cpu, int arbeitspeicher, String betriebssystem, String typ, String grafikkarte, Integer festplatte_ssd, Integer festplatte_hdd, Room room) {
//        this();
        super(room);
        anzahl++;
        this.id = anzahl;
        this.seriennummer = seriennummer;
        this.modell = modell;
        this.hersteller = hersteller;
        this.status = status;
        this.herstellergarantie = herstellergarantie;
        this.lieferdatum = lieferdatum;
        this.cpu = cpu;
        this.arbeitspeicher = arbeitspeicher;
        this.betriebssystem = betriebssystem;
        this.typ = typ;
        this.grafikkarte = grafikkarte;
        this.festplatte_hdd = festplatte_hdd;
        this.festplatte_ssd = festplatte_ssd;



    }

    @Override
    public String toString() {
        return "ID: " + this.id + ";" + this.seriennummer + ";"
                + this.modell + ";" + this.hersteller + ";" + this.status +
                ";" + this.herstellergarantie + ";" + this.lieferdatum.toString() + ";" +
                this.cpu + ";" + this.arbeitspeicher + ";" + this.betriebssystem + ";" +
                this.typ + ";" + this.grafikkarte + ";" + this.festplatte_ssd + ";" + this.festplatte_hdd;
    }

    public enum Typ {
        WERT1("Gaming-PC"),
        WERT2("Multimedia-PC"),
        WERT3("Office-PC");

        private String value;

        Typ(String value) {
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
    public static Typ getTyp(String ty){
        for(Typ tmpTyp : Typ.values()){
            if(ty == tmpTyp.value){
                return tmpTyp;
            }
        }
        return null;
    }


}
