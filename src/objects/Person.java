package objects;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.*;


@Entity
@Table(name="t_person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="firstname")
    private String vorname;
    @Column(name="lastname")
    private String nachname;
    @Column(name="gender")
    private String geschlecht;
    @Column(name="postcode")
    private String plz;
    @Column(name="city")
    private String ort;
    @Column(name="street")
    private String straße;
    @Column(name="streetnumber")
    private String hausnummer;
    @Column(name="phone")
    private String telNummer;
    @Column(name="email")
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

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
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

    public String getHausnummer() {
        return hausnummer;
    }

    public void setHausnummer(String hausnummer) {
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

    public Person() {

    }

    public Person(int id, String vorname, String nachname, String geschlecht, String plz, String ort, String straße, String hausnummer, String telNummer, String email) {
        this(vorname, nachname, geschlecht, plz, ort, straße, hausnummer, telNummer, email);
        this.setId(id);
    }

    public Person(String vorname, String nachname, String geschlecht, String plz, String ort, String straße, String hausnummer, String telNummer, String email) {
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
                ";" + this.ort + ";" + this.straße + ";" +
                this.hausnummer.toString() + ";" + this.telNummer + ";" + this.email + ";";
    }

    public static Geschlecht getGeschlechtLoop(String ty) {
        for (Geschlecht tmpGeschlecht : Geschlecht.values()) {
            if (ty.equals(tmpGeschlecht.value)) {
                return tmpGeschlecht;
            }
        }
        return null;
    }


}
