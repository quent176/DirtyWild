package fr.wcs.blablacrade;

import java.util.Date;

public class TripResultModel {

    private String prenom;
    private int prix;
    private Date date;

    public TripResultModel(String prenom, Date date, int prix) {
        this.prenom = prenom;
        this.date = date;
        this.prix = prix;
    }

    public String getPrenom() {
        return prenom;
    }

    public Date getDate() {
        return date;
    }

    public int getPrix() {
        return prix;
    }
}
