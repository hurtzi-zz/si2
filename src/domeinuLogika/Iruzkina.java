package domeinuLogika;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Iruzkina {
    private int iruzkinId;
    private String testua;
    private double puntuazioa;
    private int landetxeZbkia;

    @Id
    @Column(name = "IruzkinID")
    public int getIruzkinId() {
        return iruzkinId;
    }

    public void setIruzkinId(int iruzkinId) {
        this.iruzkinId = iruzkinId;
    }

    @Basic
    @Column(name = "Testua")
    public String getTestua() {
        return testua;
    }

    public void setTestua(String testua) {
        this.testua = testua;
    }

    @Basic
    @Column(name = "Puntuazioa")
    public double getPuntuazioa() {
        return puntuazioa;
    }

    public void setPuntuazioa(double puntuazioa) {
        this.puntuazioa = puntuazioa;
    }

    @Basic
    @Column(name = "landetxeZbkia")
    public int getLandetxeZbkia() {
        return landetxeZbkia;
    }

    public void setLandetxeZbkia(int landetxeZbkia) {
        this.landetxeZbkia = landetxeZbkia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Iruzkina iruzkina = (Iruzkina) o;

        if (iruzkinId != iruzkina.iruzkinId) return false;
        if (Double.compare(iruzkina.puntuazioa, puntuazioa) != 0) return false;
        if (landetxeZbkia != iruzkina.landetxeZbkia) return false;
        if (testua != null ? !testua.equals(iruzkina.testua) : iruzkina.testua != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = iruzkinId;
        result = 31 * result + (testua != null ? testua.hashCode() : 0);
        temp = Double.doubleToLongBits(puntuazioa);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + landetxeZbkia;
        return result;
    }
}
