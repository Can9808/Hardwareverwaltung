package objects;

import java.time.LocalDate;

public abstract class Hardware {
    protected int id;
    protected String seriennummer;
    protected String modell;
    protected String hersteller;
    protected String status = "ok";
    protected int herstellergarantie;
    protected LocalDate lieferdatum;
    protected Room room;

    public Hardware(Room room){
        this.room = room;
      this.room.addHardware(this);
    }

    public int getId() {
        return id;
    }
    public String getSeriennummer() {
        return seriennummer;
    }
    public String getModell() {
        return modell;
    }
    public String getHersteller() {
        return hersteller;
    }
    public String getStatusString() {
        return status;
    }
    public int getHerstellergarantie() {
        return herstellergarantie;
    }
    public LocalDate getLieferdatum() {
        return lieferdatum;
    }
    public LocalDate berechneGarantieende() {
        return this.lieferdatum.plusMonths(this.herstellergarantie);
    }
    public Room getRoom() {
        return room;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setSeriennummer(String seriennummer) {
        this.seriennummer = seriennummer;
    }
    public void setModell(String modell) {
        this.modell = modell;
    }
    public void setHersteller(String hersteller) {
        this.hersteller = hersteller;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setHerstellergarantie(int herstellergarantie) {
        this.herstellergarantie = herstellergarantie;
    }
    public void setLieferdatum(LocalDate lieferdatum) {
        this.lieferdatum = lieferdatum;
    }
    public void setRoom(Room room) {
        this.room = room;
    }

    public enum Status {
        OK("Ok"),
        INREP("In Reperatur"),
        DEFEKT("Defekt");

        private String value;

        Status(String value) {
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
    public static Status getStatus(String sta){
    for(Status tmpStatus : Status.values()){ // für TMPSTATUS in Status.values
        if(sta == tmpStatus.value){ //Wenn sta = tmpStatus dann wurde gefunden
            return tmpStatus;
        }
    }
    return null;
}

}
