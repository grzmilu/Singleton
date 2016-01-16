
import java.util.Scanner;
import java.util.*;

public class GraczWJednorekiegoBandyte {

    public static void graj() {
        System.out.println("Podaj wartosc kazdorazowej stawki");
        Scanner odczyt = new Scanner(System.in);
        String wybor = odczyt.nextLine();
        int stawka = Integer.parseInt(wybor);
        Random r = new Random();
        int[] tab = new int[3];
        int nagroda = 0;
        do {
            System.out.println(" 1.Losuj\n 2.Zmien stawke\n 3.Wroc");
            wybor = odczyt.nextLine();
            if (wybor.equals("1")) {
                tab[0] = r.nextInt(7) + 1;
                tab[1] = r.nextInt(7) + 1;
                tab[2] = r.nextInt(7) + 1;
                System.out.println(tab[0] + " | " + tab[1] + " | " + tab[2]);

                if (tab[0] == tab[1] && tab[0] == tab[2]) {

                    System.out.println("Wygrales " + (3 * tab[0] * stawka) + " zl! \n");
                    Singleton.inst().zmianaStanuKasy(-2 * tab[0] * stawka);
                    nagroda = nagroda + 2 * tab[0] * stawka;
                } else {

                    System.out.println("Przegrales!");
                    Singleton.inst().zmianaStanuKasy(stawka);
                    nagroda = nagroda - stawka;

                }
                System.out.println("Zarobiles lacznie: " + nagroda);
                
            }
            if (wybor.equals("2")) {
                System.out.println("Podaj wartosc kazdorazowej stawki");

                String wybor2 = odczyt.nextLine();
                stawka = Integer.parseInt(wybor2);
            }
        } while (wybor.equals("1") || wybor.equals("2"));
        Main b = new Main();
        b.menu();

    }
}
