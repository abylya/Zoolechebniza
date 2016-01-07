package uz.fac;

import java.io.Serializable;

/**
 * Created by AB on 02.01.2016.
 */
  public class Zoo implements Serializable {
  public    String vid;
  private   String klichka;
  private boolean zdorovie;



    public boolean isZdorovie() {
        return zdorovie;
    }

    public void setZdorovie(boolean zdorovie) {
        this.zdorovie = zdorovie;
    }

    public String getKlichka() {
        return klichka;
    }

    public void setKlichka(String klichka) {
        this.klichka = klichka;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    @Override
    public String toString() {
        return "Pitomez{" +
                "Vid pitomza-'" + vid + '\'' +
                ", klichka='" + klichka + '\'' +
                ", zdorovie=" + zdorovie +
                '}'+"\n";
    }
}
