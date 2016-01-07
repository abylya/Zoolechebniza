package uz.fac;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by AB on 01.01.2016.
 */
public  class ZooBoiniza implements Lechebniza,Serializable{
    KlientEndZoo[]cpicok=new KlientEndZoo[10];




    public void lechit(KlientEndZoo[]c) {
        System.out.println(Arrays.toString(c));

        System.out.println("Vedite nomer pazeenta");
        Scanner sc = new Scanner(System.in);
        int b = sc.nextInt();
        for (int i = 0; i < c.length; i++) {
            if (b >= c.length || b <= 0) {
                System.out.println("net takogo pazienta");
                return;
            }
            if (c[i].getNombr() == b) {
                int a = (int) (Math.random() * 2) + 1;

                for (int j = 0; j < c[i].pitom.length; j++) {
                    boolean d = (a == 1) ? true : false;
                    c[i].pitom[j].setZdorovie(d);
                    if (c[i].pitom[j].isZdorovie() == true) {
                        System.out.println("Vash pitomez zdorov");
                    } else System.out.println("Ymer- bydet xoroshee milo");

                }
                c[i] = null;
                //сортируем массив

                for (int j = i + 1; c[j] != null && c.length > j; j++) {
                    c[j - 1] = c[j];
                    c[j] = null;
                    c[j - 1].setNombr(j);
                    if (j + 1 == c.length) {
                        break;
                    }
                } return;
            }

        }
    }


    public void zapicVcpicok(KlientEndZoo[]c){
        boolean b=true;
        Scanner sc=new Scanner(System.in);
         do{
             int ch=0;
                for (int i=0;i<c.length;i++) {
                    if(c[i]==null) {
                        boolean z=true;
                         do {
                           try {
                               System.out.println("Zapicat kolichectvo pitomzev ne bolshe 5");

                               String st = sc.next();

                               if (Integer.valueOf(st) > 0 && Integer.valueOf(st) <= (c.length - 5)) {//length-5_ limit pitomzev
                                   ch = Integer.valueOf(st);
                                   z = false;

                               } else {
                                   System.out.println("Nepravilnii vvod");
                               }
                           }catch (NumberFormatException e){
                               System.out.println("Неправильный ввод");
                           }
                         }while (z);
                        KlientEndZoo k = new KlientEndZoo(ch);
                            System.out.println("Zapicat imya klienta");
                            String s;
                            k.setNaim(s = sc.next());
                            k.setNombr(i + 1);

                            for (int j = 0; j < k.pitom.length; j++) {
                                System.out.println("Zapicat vid " + (j + 1) + " pitomza");
                                k.pitom[j].setVid(sc.next());
                                System.out.println("Zapicat klichky " + (j + 1) + " pitomza");
                                k.pitom[j].setKlichka(sc.next());
                            }
                            c[i] = k;
                             k=null;


                        if(i+1==c.length){
                            System.out.println("Cpicok poln");
                           b=false;return;
                        }
                        System.out.println("Zakonchit zapic 'X', prodolzhit 'Z'");

                        String v=sc.next();
                        if(v.equals("X")||v.equals("x")) {
                          b=false;return;
                        }
                    }
                }

         }while (b);
    }
    public void vipicatIZcpicka(KlientEndZoo[]c){
        System.out.println(Arrays.toString(c));
        if(c[0]==null){
            System.out.println("Cpicok pyct");return;
        }

        Scanner sc=new Scanner(System.in);
        boolean b=true;
       int a=0;

        do {
          try{  System.out.println("Vedite nomer vipicyemogo");
            String st = sc.next();

            if (Integer.valueOf(st) > 0 && Integer.valueOf(st) <= c.length) {
                a = Integer.valueOf(st);
                b = false;

            } else {
                System.out.println("Неправильный ввод" + a);
            }
        }catch (NumberFormatException e){
                System.out.println("Неправильный ввод");
            }
        }while (b);

        if (a == c.length) {
            c[a - 1] = null;
            System.out.println(Arrays.toString(c));
            return;
        }

        for(int i=0;c[i]!=null&&c.length>i;i++){

            if(c[i].getNombr()==a){
                c[i]=null;
                for(int j=i+1;c[j]!=null&&c.length>j;j++){
                    c[j-1]=c[j];
                    c[j]=null;
                    c[j-1].setNombr(j);
                    if(j+1==c.length){
                        break;
                    }
                }System.out.println(Arrays.toString(c));return;
            }

        }
        System.out.println("Net takogo nomera");

     }


    public void info(KlientEndZoo[]a){

        System.out.println(Arrays.toString(a));
    }


    public void poick(KlientEndZoo[]c){
        System.out.println(Arrays.toString(c));
        Scanner sc=new Scanner(System.in);
       System.out.println("Vedite imya i klichky pitomza");
        String a;
        String b;
        a=sc.next();
        b=sc.next();
        for (int i=0;c[i]!=null||c.length<i;i++){

            if(c[i].getNaim().equals(a)){

                KlientEndZoo d=c[i];
               for (int j=0;j<d.pitom.length;j++){
                   if(d.pitom[j].getKlichka().equals(b)){
                       System.out.println(d.toString());
                      return;
                   }
               }
            }

        } System.out.println("No klient");
    }

    public void zapicatVfail(ZooBoiniza z){

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("filecpicok.txt"))) {


            oos.writeObject(z);

        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
    }

    @Override
    public String toString() {
        return "ZooBoiniza cpicok " + Arrays.toString(cpicok) +
                '}';

    }
}
