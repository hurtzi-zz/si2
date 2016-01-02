package domeinuLogika;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Oferta {
    private int landetxea;
    private java.sql.Date hasData;
    private java.sql.Date amaiData;
    private double prezioa;
    private int ofertaId;

    @Basic
    @Column(name = "Landetxea")
    public int getLandetxea() {
        return landetxea;
    }

    public void setLandetxea(int landetxea) {
        this.landetxea = landetxea;
    }

    @Basic
    @Column(name = "HasData")
    public java.sql.Date getHasData() {
        return hasData;
    }

    public void setHasData(java.sql.Date hasData) {
        this.hasData = hasData;

    }

    @Basic
    @Column(name = "AmaiData")
    public java.sql.Date getAmaiData() {
        return amaiData;
    }

    public void setAmaiData(java.sql.Date amaiData) {
        this.amaiData = amaiData;
    }

    @Basic
    @Column(name = "Prezioa")
    public double getPrezioa() {
        return prezioa;
    }

    public void setPrezioa(double prezioa) {
        this.prezioa = prezioa;
    }

    @Id
    @Column(name = "OfertaID")
    public int getOfertaId() {
        return ofertaId;
    }

    public void setOfertaId(int ofertaId) {
        this.ofertaId = ofertaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Oferta oferta = (Oferta) o;

        if (landetxea != oferta.landetxea) return false;
        if (Double.compare(oferta.prezioa, prezioa) != 0) return false;
        if (ofertaId != oferta.ofertaId) return false;
        if (hasData != null ? !hasData.equals(oferta.hasData) : oferta.hasData != null) return false;
        if (amaiData != null ? !amaiData.equals(oferta.amaiData) : oferta.amaiData != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = landetxea;
        result = 31 * result + (hasData != null ? hasData.hashCode() : 0);
        result = 31 * result + (amaiData != null ? amaiData.hashCode() : 0);
        temp = Double.doubleToLongBits(prezioa);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + ofertaId;
        return result;
    }



}
