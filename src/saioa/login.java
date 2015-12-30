package saioa;

import domeinuLogika.Erabiltzailea;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@SessionScoped
public class login implements Serializable {

    private String nanzbkia;

    private String password;

    private String username;

    private String surname;

    private Integer phone;
    public String getNanzbkia() {
        return nanzbkia;
    }

    public String getUsername() {
        return username;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setNanzbkia(String nanzbkia) {
        this.nanzbkia = nanzbkia;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String loginEgin() {
        FacesMessage message;

        try {

            List a = hibernateDatuBasea.datuBasea.instantzia().loginEgin(nanzbkia, password);

            if (a.size() > 0) {
                HttpSession session = saioa.getSession();
                Erabiltzailea erab = (Erabiltzailea) a.get(0);
                session.setAttribute("erabiltzaileIzena", erab.getIzena());
                session.setAttribute("erabiltzaileMota", erab.getMota());

                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ongietorria!", a.toString());
                FacesContext.getCurrentInstance().addMessage(null, message);
                return "panela";

            } else {

                message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "DATU OKERRAK", "Erabiltzaie edo pasahitz okerrak.");
                FacesContext.getCurrentInstance().addMessage(null, message);

                return "index";

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        //message = new FacesMessage(FacesMessage.SEVERITY_WARN, "DATU OKERRAK", "Erabiltzaie edo pasahitz okerrak.");
        //FacesContext.getCurrentInstance().addMessage(null, message);
        return "index";

    }

    public String logout() {
        HttpSession session = saioa.getSession();
        session.invalidate();
        return "index";
    }

    public String SignIn() {
        FacesMessage message;

        try {
            //konprobatu aldez aurretik exisititzen dan.
            boolean a = hibernateDatuBasea.datuBasea.instantzia().existitzeDa(nanzbkia);
            //Ez badago, erregistroa sortu.
            if (a==false) {
                Erabiltzailea n = new Erabiltzailea();
                n.setNan(nanzbkia);
                n.setPasahitza(password);
                n.setIzena(username);
                n.setAbizena(surname);
                n.setTelefonoa(phone);

                hibernateDatuBasea.datuBasea.instantzia().gorde(n);
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "ERREGISTRO ZUZENA", "Erabiltzaiea zuzen erregistratu da.");
                FacesContext.getCurrentInstance().addMessage(null, message);
            } else {

                message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERREGISTRO OKERRA", "Erabiltzailea dagoeneko db-an dago.");
                FacesContext.getCurrentInstance().addMessage(null, message);

                return "index";

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "index";

    }

}
