package ownOfertak;

import domeinuLogika.Landetxea;
import domeinuLogika.Oferta;
import saioa.saioa;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

@ManagedBean
@SessionScoped
public class saveofertak implements Serializable {

    private int landetxea;
    private String hasdata;
    private String amaidata;
    private float prezioa;
    private int id;

    public int getLandetxea() {
        return landetxea;
    }

    public void setLandetxea(int landetxea) {
        this.landetxea = landetxea;
    }

    public String getHasdata() {
        return hasdata;
    }

    public void setHasData(String hasdata) {
        this.hasdata = hasdata;
    }

    public String getAmaidata() {
        return amaidata;
    }

    public void setAmaiData(String amaidata) {
        this.amaidata = amaidata;
    }

    public float getPrezioa() {
        return prezioa;
    }

    public void setPrezioa(float prezioa) {
        this.prezioa = prezioa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date StringToDate (String strFecha){

        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy/MM/dd");
        Date fecha = null;
        try {

            fecha = formatoDelTexto.parse(strFecha);

        } catch (ParseException ex) {

            ex.printStackTrace();

        }

        return fecha;

    }

    public String ofertaSortu() {
        Random rand = new Random();
        this.id = rand.nextInt(9999);

        FacesMessage message;
        try {
            //konprobatu aldez aurretik exisititzen dan.
            //boolean a = hibernateDatuBasea.datuBasea.instantzia().existitzeDa(id);
            boolean a = false;

            //Ez badago, erregistroa sortu.
            if (a==false) {
                Oferta n = new Oferta();
                n.setLandetxea(landetxea);

                Date hasData2= StringToDate(hasdata);
                java.sql.Date hasData3 = new java.sql.Date( hasData2.getTime() );
                n.setHasData(hasData3);

                Date amaiData2= StringToDate(amaidata);
                java.sql.Date amaiData3 = new java.sql.Date( amaiData2.getTime() );
                n.setAmaiData(amaiData3);

                n.setPrezioa(prezioa);
                n.setOfertaId(id);

                hibernateDatuBasea.datuBasea.instantzia().gorde(n);
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "ERREGISTRO ZUZENA", "Oferta zuzen gorde da.");
                FacesContext.getCurrentInstance().addMessage(null, message);
            } else {

                message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERREGISTRO OKERRA", "Oferta dagoeneko db-an dago.");
                FacesContext.getCurrentInstance().addMessage(null, message);

                return "ownerlandetxeak";

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "panela";

    }

}
