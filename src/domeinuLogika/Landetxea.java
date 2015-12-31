package domeinuLogika;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Landetxea {
    private String owner;
    private String herria;
    private String helbidea;
    private String izena;
    private int zenbakia;

    @Basic
    @Column(name = "Owner")
    public String getOwner() {
        return owner;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Basic
    @Column(name = "herria")
    public String getHerria() {
        return herria;
    }
    public void setHerria(String herria) {
        this.herria = herria;
    }

    @Basic
    @Column(name = "Helbidea")
    public String getHelbidea() {
        return helbidea;
    }

    public void setHelbidea(String helbidea) {
        this.helbidea = helbidea;
    }

    @Basic
    @Column(name = "izena")
    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    @Id
    @Column(name = "Zenbakia")
    public int getZenbakia() {
        return zenbakia;
    }

    public void setZenbakia(int zenbakia) {
        this.zenbakia = zenbakia;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Landetxea landetxea = (Landetxea) o;

        if (zenbakia != landetxea.zenbakia) return false;
        if (owner != null ? !owner.equals(landetxea.owner) : landetxea.owner != null) return false;
        if (helbidea != null ? !helbidea.equals(landetxea.helbidea) : landetxea.helbidea != null) return false;
        if (izena != null ? !izena.equals(landetxea.izena) : landetxea.izena != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = owner != null ? owner.hashCode() : 0;
        result = 31 * result + (helbidea != null ? helbidea.hashCode() : 0);
        result = 31 * result + (izena != null ? izena.hashCode() : 0);
        result = 31 * result + zenbakia;
        return result;
    }


}
