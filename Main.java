package uz.fac;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
           ZooBoiniza boiniza=new ZooBoiniza();
        File file=new File("filecpicok.txt"); //создаем фаил для памяти
        if (file.length()!=0){
            //если в файле чтото есть производим инецыализацыю нашей лечебницы
            try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("filecpicok.txt"))) {

                boiniza = (ZooBoiniza) is.readObject();

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        boolean per=true;
        do {
            Minu.minu();
       try {
           Scanner scanner = new Scanner(System.in);
           String s = scanner.next();
           if (Integer.valueOf(s) > 0 && Integer.valueOf(s) < 7) {
               switch (s) {
                   case "1":
                       boiniza.zapicVcpicok(boiniza.cpicok);
                       break;
                   case "2":
                       boiniza.poick(boiniza.cpicok);
                       break;
                   case "3":
                       boiniza.lechit(boiniza.cpicok);
                       break;
                   case "4":
                       boiniza.vipicatIZcpicka(boiniza.cpicok);
                       break;
                   case "5":
                       boiniza.info(boiniza.cpicok);
                       break;
                   case "6":
                       boiniza.zapicatVfail(boiniza);
                       per = false;
                       break;
               }
           } else {
               System.out.println("Неправильный ввод");
           }
       }catch (NumberFormatException e){
           System.out.println("Неправильный ввод");
       }

        }while (per);

    }


        }







