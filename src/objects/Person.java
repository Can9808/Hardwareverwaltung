package objects;

public class Person {
    private Integer id;
    private String vorname;
    private String nachname;
    private String geschlecht;
    private Integer plz;
    private String ort;
    private String straße;
    private Integer hausnummer;
    private String telNummer;
    private String email;

    //<editor-fold desc="Getter/Setter">
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getGeschlecht() {
        return geschlecht;
    }

    public void setGeschlecht(String geschlecht) {
        this.geschlecht = geschlecht;
    }

    public Integer getPlz() {
        return plz;
    }

    public void setPlz(Integer plz) {
        this.plz = plz;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getStraße() {
        return straße;
    }

    public void setStraße(String straße) {
        this.straße = straße;
    }

    public Integer getHausnummer() {
        return hausnummer;
    }

    public void setHausnummer(Integer hausnummer) {
        this.hausnummer = hausnummer;
    }

    public String getTelNummer() {
        return telNummer;
    }

    public void setTelNummer(String telNummer) {
        this.telNummer = telNummer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    //</editor-fold>



    public Person(String vorname, String nachname, String geschlecht, Integer plz, String ort, String straße, Integer hausnummer, String telNummer, String email){
        this.vorname = vorname;
        this.nachname = nachname;
        this.geschlecht = geschlecht;
        this.plz = plz;
        this.ort = ort;
        this.straße = straße;
        this.hausnummer = hausnummer;
        this.telNummer = telNummer;
        this.email = email;
    }

    public enum Geschlecht {
        M("Männlich"),
        W("Weiblich"),
        D("Diverse");

        private String value;

        Geschlecht(String value) {
            this.value = value;
        }

        public String getGeschlecht() {
            return value;
        }

        @Override
        public String toString() {
            return this.value;
        }
    }
    public String toString() {
        return this.id + ";" + this.vorname + ";"
                + this.nachname + ";" + this.geschlecht + ";" + this.plz.toString() +
                ";" + this.ort + ";" + this.straße+ ";" +
                this.hausnummer.toString() + ";" + this.telNummer + ";" + this.email + ";" ;
    }
    public static Person.Geschlecht getGeschlechtLoop(String ty) {
        for (Person.Geschlecht tmpGeschlecht : Person.Geschlecht.values()) {
            if (ty == tmpGeschlecht.value) {
                return tmpGeschlecht;
            }
        }
        return null;
    }
}
