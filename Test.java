package uz.fac;
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by AB on 04.01.2016.
 */
public class Test {


    public static void fail() {
        KlientEndZoo k = new KlientEndZoo(1);
        KlientEndZoo j = new KlientEndZoo(1);
        KlientEndZoo h = new KlientEndZoo(2);
        KlientEndZoo n = new KlientEndZoo(2);
        ZooBoiniza b = new ZooBoiniza();


        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("newfile.txt"))) {

            k.pitom[0].setKlichka("rex");
            k.pitom[0].setVid("dog");
            k.setKolichPitom(1);
            k.setNaim("imya");
            k.setNombr(1);
            j.pitom[0].setKlichka("tyzik");
            j.pitom[0].setVid("dog");
            j.setKolichPitom(1);
            j.setNaim("imya2");
            j.setNombr(2);
            h.pitom[0].setKlichka("bob");
            h.pitom[0].setVid("dog");
            h.setKolichPitom(2);
            h.setNaim("imya3");
            h.setNombr(3);
            h.pitom[1].setKlichka("kic");
            h.pitom[1].setVid("cat");
            n.setNaim("imya4");
            n.setNombr(4);
            n.setKolichPitom(1);
            n.pitom[0].setVid("zebra");
            n.pitom[0].setKlichka("be-be");
            b.cpicok[0] = k;
            b.cpicok[1] = j;
            b.cpicok[2] = h;
            b.cpicok[3]=n;

            oos.writeObject(b);

        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }

        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("newfile.txt"))) {
            ZooBoiniza v;
            v = (ZooBoiniza) is.readObject();
            System.out.println(v.toString());


        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void testPoick() {
        ZooBoiniza v = new ZooBoiniza();
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("newfile.txt"))) {

            v = (ZooBoiniza) is.readObject();

            System.out.println(v.toString());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Vedite imya i klichky pitomza");
        String a;
        String b;
        a = sc.next();
        b = sc.next();

        for (int i = 0; v.cpicok[i]!=null; i++) {

            if (v.cpicok[i].getNaim().equals(a)) {

                KlientEndZoo d = v.cpicok[i];
                for (int j = 0; j < d.pitom.length; j++) {
                    if (d.pitom[j].getKlichka().equals(b)) {
                        System.out.println(d.toString());
                         return;
                    }
                }
            }

        }
        System.out.println("No klient");
    }



    static void testVipicat(){
        ZooBoiniza v = new ZooBoiniza();
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("newfile.txt"))) {

            v = (ZooBoiniza) is.readObject();

            System.out.println(v.toString());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Vedite nomer vipicyemogo");
        int a=sc.nextInt();

        for(int i=0;v.cpicok[i]!=null&&v.cpicok.length>i;i++){
            if(a==v.cpicok.length){
                v.cpicok[a-1]=null;
                System.out.println(v.toString());return;
            }

            if(v.cpicok[i].getNombr()==a){
                v.cpicok[i]=null;

                for(int j=i+1;v.cpicok[j]!=null&&v.cpicok.length>j;j++){
                    v.cpicok[j-1]=v.cpicok[j];
                    v.cpicok[j]=null;
                    v.cpicok[j-1].setNombr(j);
                    if(j+1==v.cpicok.length){
                       break;
                    }

                }System.out.println(v.toString());return;
            }

        }  System.out.println("Net takogo nomera"); System.out.println(v.toString());

    }
}

