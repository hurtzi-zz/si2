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
public class ownofertak implements Serializable {

    private int landetxea;
    private Date hasdata;
    private Date amaidata;
    private float prezioa;
    private int id;
    private String aukeratutakoland;
    private String bezeroa;
    private int aukeratutakoofer;
    private Date aukeratutakooferhasi;
    private Date aukeratutakooferbuk;
    private double aukeratutakooferprezioa;


    public int getLandetxea() {
        return landetxea;
    }

    public void setLandetxea(int landetxea) {
        this.landetxea = landetxea;
    }

    public Date getHasdata() {
        return hasdata;
    }

    public void setHasdata(Date hasdata) {
        this.hasdata = hasdata;
    }

    public Date getAmaidata() {
        return amaidata;
    }

    public void setAmaiData(Date amaidata) {
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

    public String getAukeratutakoland() {
        return aukeratutakoland;
    }

    public void setAukeratutakoland(String aukeratutakoland) {
        this.aukeratutakoland = aukeratutakoland;
    }

    public String getJabea() {
        return bezeroa;
    }

    public void setOwner(String bezeroa) {
        this.bezeroa = bezeroa;
    }

    public void setAmaidata(Date amaidata) {
        this.amaidata = amaidata;
    }

    public int getAukeratutakoofer() {
        return aukeratutakoofer;
    }

    public void setAukeratutakoofer(int aukeratutakoofer) {
        this.aukeratutakoofer = aukeratutakoofer;
    }

    public Date getAukeratutakooferhasi() {
        return aukeratutakooferhasi;
    }

    public void setAukeratutakooferhasi(Date aukeratutakooferhasi) {
        this.aukeratutakooferhasi = aukeratutakooferhasi;
    }

    public Date getAukeratutakooferbuk() {
        return aukeratutakooferbuk;
    }

    public void setAukeratutakooferbuk(Date aukeratutakooferbuk) {
        this.aukeratutakooferbuk = aukeratutakooferbuk;
    }

    public double getAukeratutakooferprezioa() {
        return aukeratutakooferprezioa;
    }

    public void setAukeratutakooferprezioa(double aukeratutakooferprezioa) {
        this.aukeratutakooferprezioa = aukeratutakooferprezioa;
    }

    public Landetxea lortuIdLandetxe(String owner, String izena){
        try {
            return hibernateDatuBasea.datuBasea.instantzia().lortuLandetxe(owner,izena);
        } catch (Exception ex) {
            Logger.getLogger(ownofertak.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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
                Landetxea land =lortuIdLandetxe(saioa.logeatutakoIzena(),aukeratutakoland);
                int landId = land.getZenbakia();
                n.setLandetxea(landId);

                Date datahasi= hasdata;
                //Date hasData2= StringToDate(datahasi);
                java.sql.Date hasData3 = new java.sql.Date( datahasi.getTime() );
                n.setHasData(hasData3);

                Date dataamai= amaidata;
                //Date amaiData2= StringToDate(dataamai);
                java.sql.Date amaiData3 = new java.sql.Date( dataamai.getTime() );
                n.setAmaiData(amaiData3);


                n.setPrezioa(prezioa);
                n.setOfertaId(id);

                hibernateDatuBasea.datuBasea.instantzia().gorde(n);
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "ERREGISTRO ZUZENA", "Oferta zuzen gorde da.");
                FacesContext.getCurrentInstance().addMessage(null, message);
            } else {

                message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERREGISTRO OKERRA", "Oferta dagoeneko db-an dago.");
                FacesContext.getCurrentInstance().addMessage(null, message);

                return "ownofertak";

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "panela";

    }

    public List lortuOfertak(String izena){
        try {
            Landetxea land =lortuIdLandetxe(saioa.logeatutakoIzena(),izena);
            int landId = land.getZenbakia();
            return hibernateDatuBasea.datuBasea.instantzia().lortuOfertak(landId);
        } catch (Exception ex) {
            Logger.getLogger(ownofertak.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void deleteofer(){
        FacesMessage message;
        try{
            hibernateDatuBasea.datuBasea.instantzia().deleteofer(aukeratutakoofer);
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "ALDAKETA ZUZENA", "Oferta zuzen ezabatu da.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }catch (Exception ex) {
            Logger.getLogger(ownofertak.class.getName()).log(Level.SEVERE, null, ex);
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "ALDAKETA OKERRA", "Oferta ez da zuzen ezabatu.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public void setaukera(){
        try{
            // aukeratutakoofer;
            Oferta aukeratutakoa= hibernateDatuBasea.datuBasea.instantzia().lortuofer(aukeratutakoofer);
            setAukeratutakooferhasi(aukeratutakoa.getHasData());
            setAukeratutakooferbuk(aukeratutakoa.getAmaiData());
            setAukeratutakooferprezioa(aukeratutakoa.getPrezioa());
        }catch (Exception ex) {
            Logger.getLogger(ownofertak.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void editofer(){
        FacesMessage message;
        try{
            hibernateDatuBasea.datuBasea.instantzia().deleteofer(aukeratutakoofer);
            ofertaSortu();
        }catch (Exception ex) {
            Logger.getLogger(ownofertak.class.getName()).log(Level.SEVERE, null, ex);
        }
    }




}
