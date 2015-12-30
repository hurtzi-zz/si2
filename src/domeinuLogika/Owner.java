package domeinuLogika;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Owner {
    private String izena;
    private String abizena;
    private String nan;
    private int telefonoa;
    private int kontua;
    private String mota;

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

    @Id
    @Column(name = "NAN")
    public String getNan() {
        return nan;
    }

    public void setNan(String nan) {
        this.nan = nan;
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
    @Column(name = "Kontua")
    public int getKontua() {
        return kontua;
    }

    public void setKontua(int kontua) {
        this.kontua = kontua;
    }

    @Basic
    @Column(name = "Mota")
    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Owner owner = (Owner) o;

        if (telefonoa != owner.telefonoa) return false;
        if (kontua != owner.kontua) return false;
        if (izena != null ? !izena.equals(owner.izena) : owner.izena != null) return false;
        if (abizena != null ? !abizena.equals(owner.abizena) : owner.abizena != null) return false;
        if (nan != null ? !nan.equals(owner.nan) : owner.nan != null) return false;
        if (mota != null ? !mota.equals(owner.mota) : owner.mota != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = izena != null ? izena.hashCode() : 0;
        result = 31 * result + (abizena != null ? abizena.hashCode() : 0);
        result = 31 * result + (nan != null ? nan.hashCode() : 0);
        result = 31 * result + telefonoa;
        result = 31 * result + kontua;
        result = 31 * result + (mota != null ? mota.hashCode() : 0);
        return result;
    }
}
