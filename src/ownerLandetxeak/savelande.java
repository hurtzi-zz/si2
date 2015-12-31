package ownerLandetxeak;

import domeinuLogika.Erabiltzailea;
import domeinuLogika.Landetxea;
import saioa.saioa;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.List;
import java.util.Random;

@ManagedBean
@SessionScoped
public class savelande implements Serializable {

    private int id;
    private String izena;
    private String herria;
    private String kalea;
    private String bezeroa;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public String getHerria() {
        return herria;
    }

    public void setHerria(String herria) {
        this.herria = herria;
    }

    public String getKalea() {
        return kalea;
    }

    public void setKalea(String kalea) {
        this.kalea = kalea;
    }

    public String getJabea() {
        return bezeroa;
    }

    public void setOwner(String bezeroa) {
        this.bezeroa = bezeroa;
    }


    public String landetxeaSortu() {
        Random rand = new Random();
        this.id = rand.nextInt(9999);

        FacesMessage message;
        try {
            //konprobatu aldez aurretik exisititzen dan.
            //boolean a = hibernateDatuBasea.datuBasea.instantzia().existitzeDa(id);
            boolean a = false;

            //Ez badago, erregistroa sortu.
            if (a==false) {
                Landetxea n = new Landetxea();
                n.setIzena(izena);
                n.setHerria(herria);
                n.setHelbidea(kalea);
                n.setOwner(saioa.logeatutakoIzena());
                n.setZenbakia(id);

                System.out.println("Landetxea: "+n.getIzena());

                hibernateDatuBasea.datuBasea.instantzia().gorde(n);
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "ERREGISTRO ZUZENA", "Landetxea zuzen gorde da.");
                FacesContext.getCurrentInstance().addMessage(null, message);
            } else {

                message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERREGISTRO OKERRA", "Landetxea dagoeneko db-an dago.");
                FacesContext.getCurrentInstance().addMessage(null, message);

                return "savelande";

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "panela";

    }

}
