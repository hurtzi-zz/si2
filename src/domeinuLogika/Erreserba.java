package domeinuLogika;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Erreserba {
    private int erreserbaId;
    private String client;
    private int ofertaId;
    private Date data;

    @Id
    @Column(name = "ErreserbaID")
    public int getErreserbaId() {
        return erreserbaId;
    }

    public void setErreserbaId(int erreserbaId) {
        this.erreserbaId = erreserbaId;
    }

    @Basic
    @Column(name = "Erabiltzailea")
    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    @Basic
    @Column(name = "OfertaID")
    public int getOfertaId() {
        return ofertaId;
    }

    public void setOfertaId(int ofertaId) {
        this.ofertaId = ofertaId;
    }

    @Basic
    @Column(name = "Data")
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Erreserba erreserba = (Erreserba) o;

        if (erreserbaId != erreserba.erreserbaId) return false;
        if (ofertaId != erreserba.ofertaId) return false;
        if (client != null ? !client.equals(erreserba.client) : erreserba.client != null) return false;
        if (data != null ? !data.equals(erreserba.data) : erreserba.data != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = erreserbaId;
        result = 31 * result + (client != null ? client.hashCode() : 0);
        result = 31 * result + ofertaId;
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }
}
