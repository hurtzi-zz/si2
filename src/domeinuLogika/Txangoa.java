package domeinuLogika;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Txangoa {
    private int txangoId;
    private String nondik;
    private String nora;
    private int plazaKop;
    private Date noiz;

    @Id
    @Column(name = "TxangoID")
    public int getTxangoId() {
        return txangoId;
    }

    public void setTxangoId(int txangoId) {
        this.txangoId = txangoId;
    }

    @Basic
    @Column(name = "Nondik")
    public String getNondik() {
        return nondik;
    }

    public void setNondik(String nondik) {
        this.nondik = nondik;
    }

    @Basic
    @Column(name = "Nora")
    public String getNora() {
        return nora;
    }

    public void setNora(String nora) {
        this.nora = nora;
    }

    @Basic
    @Column(name = "PlazaKop")
    public int getPlazaKop() {
        return plazaKop;
    }

    public void setPlazaKop(int plazaKop) {
        this.plazaKop = plazaKop;
    }

    @Basic
    @Column(name = "Noiz")
    public Date getNoiz() {
        return noiz;
    }

    public void setNoiz(Date noiz) {
        this.noiz = noiz;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Txangoa txangoa = (Txangoa) o;

        if (txangoId != txangoa.txangoId) return false;
        if (plazaKop != txangoa.plazaKop) return false;
        if (nondik != null ? !nondik.equals(txangoa.nondik) : txangoa.nondik != null) return false;
        if (nora != null ? !nora.equals(txangoa.nora) : txangoa.nora != null) return false;
        if (noiz != null ? !noiz.equals(txangoa.noiz) : txangoa.noiz != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = txangoId;
        result = 31 * result + (nondik != null ? nondik.hashCode() : 0);
        result = 31 * result + (nora != null ? nora.hashCode() : 0);
        result = 31 * result + plazaKop;
        result = 31 * result + (noiz != null ? noiz.hashCode() : 0);
        return result;
    }
}
