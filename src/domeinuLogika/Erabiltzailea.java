package domeinuLogika;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Erabiltzailea {
    private String nan;
    private String izena;
    private String abizena;
    private String pasahitza;
    private int telefonoa;
    private int mota;
    private int kontu_zbkia;

    @Id
    @Column(name = "NAN")
    public String getNan() {
        return nan;
    }

    public void setNan(String nan) {
        this.nan = nan;
    }

    @Basic
    @Column(name = "Izena")
    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    @Basic
    @Column(name = "Abizena")
    public String getAbizena() {
        return abizena;
    }

    public void setAbizena(String abizena) {
        this.abizena = abizena;
    }


    @Basic
    @Column(name = "Pasahitza")
    public String getPasahitza() {
        return pasahitza;
    }

    public void setPasahitza(String pasahitza) {
        this.pasahitza = pasahitza;
    }

    @Basic
    @Column(name = "Telefonoa")
    public int getTelefonoa() {
        return telefonoa;
    }

    public void setTelefonoa(int telefonoa) {
        this.telefonoa = telefonoa;
    }
    @Basic
    @Column(name = "Mota")
    public int getMota() {
        return mota;
    }

    public void setMota(int mota) {
        this.mota = mota;
    }



    @Basic
    @Column(name = "Kontu_zbkia")
    public int getKontu_zbkia() {
        return kontu_zbkia;
    }

    public void setKontu_zbkia(int kontu_zbkia) {
        this.kontu_zbkia = kontu_zbkia;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Erabiltzailea client = (Erabiltzailea) o;

        if (telefonoa != client.telefonoa) return false;
        if (nan != null ? !nan.equals(client.nan) : client.nan != null) return false;
        if (izena != null ? !izena.equals(client.izena) : client.izena != null) return false;
        if (abizena != null ? !abizena.equals(client.abizena) : client.abizena != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nan != null ? nan.hashCode() : 0;
        result = 31 * result + (izena != null ? izena.hashCode() : 0);
        result = 31 * result + (abizena != null ? abizena.hashCode() : 0);
        result = 31 * result + telefonoa;
        return result;
    }


    @Override
    public String toString() {
        return izena;
    }
}
