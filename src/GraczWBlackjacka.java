
import java.util.Scanner;
import java.util.*;

public class GraczWBlackjacka {

    public static String losujKarte() {
        Random r = new Random();
        String[] tab = {"2", "2", "2", "2", "3", "3", "3", "3", "4", "4", "4", "4", "5", "5", "5", "5", "6", "6", "6", "6", "7", "7", "7", "7", "8", "8", "8", "8", "9", "9", "9", "9", "10", "10", "10", "10", "J", "J", "J", "J", "Q", "Q", "Q", "Q", "K", "K", "K", "K", "A", "A", "A", "A"};

        return tab[r.nextInt(tab.length)];
    }

    public static int przydzielPkt(String s) {
        if (s.equals("A")) {
            return 11;
        } else {
            if (s.equals("J") || s.equals("Q") || s.equals("K")) {
                return 10;
            } else {
                return Integer.parseInt(s);
            }

        }
    }

    public static void menu() {

    }

    public static void graj() {
        System.out.println("Podaj wartosc stawki");
        Scanner odczyt = new Scanner(System.in);
        String wybor = odczyt.nextLine();
        double stawka = Integer.parseInt(wybor);

        System.out.println("Pobierz dwie karty (enter)");
        odczyt.nextLine();

        String karta1Gracz = losujKarte();
        String karta2Gracz = losujKarte();
        String kartyGracz = karta1Gracz + ", " + karta2Gracz;
        int sumaGracz = przydzielPkt(karta1Gracz) + przydzielPkt(karta2Gracz);
        String kolejnaKartaGracz;

        String karta1Krupier = losujKarte();
        String karta2Krupier = losujKarte();
        String kartyKrupier = karta1Krupier + ", " + karta2Krupier;
        int sumaKrupier = przydzielPkt(karta1Krupier) + przydzielPkt(karta2Krupier);
        String kolejnaKartaKrupier;

        do {
            System.out.println("\nKarty krupiera to: " + kartyKrupier);
            System.out.println("Suma kart krupiera to: " + sumaKrupier);
            System.out.println("\nTwoje karty to: " + kartyGracz);
            System.out.println("Suma twoich kart to: " + sumaGracz + " \n\n 1.Dobierz karte\n 2.Sprawdz");
            wybor = odczyt.nextLine();

            if (wybor.equals("1")) {
                kolejnaKartaGracz = losujKarte();
                kartyGracz = kartyGracz + ", " + kolejnaKartaGracz;
                sumaGracz = sumaGracz + przydzielPkt(kolejnaKartaGracz);

            }
            if (sumaKrupier < 17) {
                kolejnaKartaKrupier = losujKarte();
                kartyKrupier = kartyKrupier + ", " + kolejnaKartaKrupier;
                sumaKrupier = sumaKrupier + przydzielPkt(kolejnaKartaKrupier);
                System.out.println("Krupier dobral karte!");
              

            }
        } while (wybor.equals("1"));

        while (sumaKrupier<sumaGracz&&sumaGracz<22) {
            kolejnaKartaKrupier = losujKarte();
            kartyKrupier = kartyKrupier + ", " + kolejnaKartaKrupier;
            sumaKrupier = sumaKrupier + przydzielPkt(kolejnaKartaKrupier);
            System.out.println("Krupier dobral karte!");
        }

        System.out.println("Karty krupiera to: " + kartyKrupier);
        System.out.println("Suma kart krupiera to: " + sumaKrupier);
        System.out.println("\nTwoje karty to: " + kartyGracz);
        System.out.println("Suma twoich kart to: " + sumaGracz);

        if (sumaGracz > 21 || sumaGracz < sumaKrupier && sumaKrupier<22) {
            System.out.println("Przegrales!\n");
            Singleton.inst().zmianaStanuKasy(stawka);
        } else {
            System.out.println("Wygrales " + (stawka) + " zl! \n");
            Singleton.inst().zmianaStanuKasy(-stawka);
        }

        System.out.print("Spróbuj ponownie(enter)");
        odczyt.nextLine();
        System.out.println();
        Main menu = new Main();
        menu.menu();

    }
}
