package fr.wcs.blablacrade;

import java.util.Date;

/**
 * Created by wilder on 13/09/17.
 */

public class TripResultModel {

    public Date getDepare() {
        return depare;
    }

    public int getPri() {
        return pri;
    }
    private String prénom;
    private int pri;

    public TripResultModel(String prénom, Date depare, int pri) {
        this.prénom = prénom;this.depare = depare;this.pri = pri;
    }
    private Date depare;

    public String getPrénom() {return prénom;}
}
