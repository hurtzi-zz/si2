package domeinuLogika;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Baliabidea {
    private int balibideId;
    private String helbidea;
    private double prezioa;
    private String webgunea;
    private String deskripzioa;

    @Id
    @Column(name = "BalibideID")
    public int getBalibideId() {
        return balibideId;
    }

    public void setBalibideId(int balibideId) {
        this.balibideId = balibideId;
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
    @Column(name = "Prezioa")
    public double getPrezioa() {
        return prezioa;
    }

    public void setPrezioa(double prezioa) {
        this.prezioa = prezioa;
    }

    @Basic
    @Column(name = "Webgunea")
    public String getWebgunea() {
        return webgunea;
    }

    public void setWebgunea(String webgunea) {
        this.webgunea = webgunea;
    }

    @Basic
    @Column(name = "Deskripzioa")
    public String getDeskripzioa() {
        return deskripzioa;
    }

    public void setDeskripzioa(String deskripzioa) {
        this.deskripzioa = deskripzioa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Baliabidea that = (Baliabidea) o;

        if (balibideId != that.balibideId) return false;
        if (Double.compare(that.prezioa, prezioa) != 0) return false;
        if (helbidea != null ? !helbidea.equals(that.helbidea) : that.helbidea != null) return false;
        if (webgunea != null ? !webgunea.equals(that.webgunea) : that.webgunea != null) return false;
        if (deskripzioa != null ? !deskripzioa.equals(that.deskripzioa) : that.deskripzioa != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = balibideId;
        result = 31 * result + (helbidea != null ? helbidea.hashCode() : 0);
        temp = Double.doubleToLongBits(prezioa);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (webgunea != null ? webgunea.hashCode() : 0);
        result = 31 * result + (deskripzioa != null ? deskripzioa.hashCode() : 0);
        return result;
    }
}
