package objects;

import java.util.ArrayList;

public class Room {

    private String id ;
    private String typ;
    private double size;
    private ArrayList<Hardware> hardware = new ArrayList<>();

    public ArrayList<Hardware> getHardware() {
        return hardware;
    }

    public void addHardware(Hardware hardware) {
        this.hardware.add(hardware);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public Room(String id, String typ, double size) {
        this.id = id;
        this.typ = typ;
        this.size = size;
    }

    @Override
    public String toString() {
        return "ID: " + this.id + ";" + this.typ + ";"
                + this.size + ";";
    }

    public enum TypRoom {
        WERT1("Klassenraum"),
        WERT2("IT Fachraum"),
        WERT3("ET Fachraum"),
        WERT4("CH Labor"),
        WERT5("Serviceraum"),
        WERT6("Lehrervorbereitungsraum"),
        WERT7("Büro"),
        WERT8("Sonstiges");


        private String value;

        TypRoom(String value) {
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


    public static TypRoom getTypRaumLoop(String ty) {
        for (TypRoom tmpTypRoom : TypRoom.values()) {
            if (ty == tmpTypRoom.value) {
                return tmpTypRoom;
            }
        }
        return null;
    }
}
