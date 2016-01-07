package uz.fac;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Vector;

/**
 * Created by AB on 01.01.2016.
 */
public class KlientEndZoo implements Serializable {
    private String naim;
    private int nomber;
    private int kolichPitom;
     public Zoo[]pitom;

    public KlientEndZoo(int a) {
        this.kolichPitom=a;
        this.pitom=new Zoo[kolichPitom];
        for (int i=0;i<kolichPitom;i++)
        {
            this.pitom[i]=new Zoo ();
        }
    }

    public String getNaim() {
        return naim;
    }

    public void setNaim(String naim) {
        this.naim = naim;
    }

    public int getNombr() {
        return nomber;
    }

    public void setNombr(int nombrPasport) {
        this.nomber = nombrPasport;
    }

    public Zoo[] getPitom() {
        return pitom;
    }

    public void setPitom(Zoo[] pitom) {
        this.pitom = pitom;
    }

    public int getKolichPitom() {
        return kolichPitom;
    }

    public void setKolichPitom(int kolichPitom) {
        this.kolichPitom = kolichPitom;
    }

    @Override
    public String toString() {

        return "Klient{" +
                "naim='" + naim + '\'' +
                ", nomber=" + nomber +
                ", kolichPitom=" + kolichPitom +"},"
                 +Arrays.toString(pitom) +
                '}';
    }


}
