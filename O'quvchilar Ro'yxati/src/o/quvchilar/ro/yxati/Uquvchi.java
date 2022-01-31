package o.quvchilar.ro.yxati;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Uquvchi {

    private SimpleIntegerProperty id;
    private SimpleStringProperty ismi;
    private SimpleStringProperty fam;
    private SimpleStringProperty sharifi;
    private SimpleStringProperty manzil;
    private SimpleStringProperty tel;
    private SimpleStringProperty tugkun;
    private SimpleStringProperty jinsi;

    public Uquvchi(Integer idadres, String ism, String famm, String sharif, String mad, String tugkun, String telnom) {
        id = new SimpleIntegerProperty(idadres);
        ismi = new SimpleStringProperty(ism);
        fam = new SimpleStringProperty(famm);
        sharifi = new SimpleStringProperty(sharif);
        manzil = new SimpleStringProperty(mad);
        tel = new SimpleStringProperty(telnom);
        this.tugkun = new SimpleStringProperty(tugkun);
        if (famm.endsWith("a")) {
            jinsi = new SimpleStringProperty("ayol");
        } else {
            jinsi = new SimpleStringProperty("erkak");
        }
    }

    public String getTugkun() {
        return tugkun.get();
    }

    public void setTugkun(String tugkun1) {
        tugkun.set(tugkun1);
    }

    public String getJinsi() {
        return jinsi.get();
    }

    public void setJinsi(String jins) {
        jinsi.set(jins);
    }

    public String getTel() {
        return tel.get();
    }

    public void setTel(String telnomer) {
        tel.set(telnomer);
    }

    public String getManzil() {
        return manzil.get();
    }

    public void setManzil(String addr) {
        manzil.set(addr);
    }

    public String getSharifi() {
        return sharifi.get();
    }

    public void setSharifi(String sharif) {
        sharifi.set(sharif);
    }

    public Integer getId() {
        return id.get();
    }

    public void setId(Integer idadr) {
        id.set(idadr);
    }

    public String getIsmi() {
        return ismi.get();
    }

    public void setIsmi(String ism) {
        ismi.set(ism);
    }

    public String getFam() {
        return fam.get();
    }

    public void setFam(String famm) {
        fam.set(famm);
    }

    @Override
    public String toString() {
        return String.format("Ism: %s\nFam: %s\nOtasining ismi: %s\nManzili: %s\nTel:%s\nTug'ilgan kuni: %s"
                + "\n", getIsmi(), getFam(), getSharifi(), getManzil(), getTel(), getTugkun());
    }
}
