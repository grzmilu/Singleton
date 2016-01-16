
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Witamy w kasynie!");
        menu();

    }

    public static void menu() {
        System.out.println("Stan kasy kasyna: " + Singleton.inst().stanKasy());
        System.out.println("Wybierz gre:\n 1.BlackJack\n 2.Jednoreki bandyta\n 3.Wyjdz");

        Scanner odczyt = new Scanner(System.in);
        String wybor = odczyt.nextLine();
        if (wybor.equals("1")) {
            GraczWBlackjacka a = new GraczWBlackjacka();
            a.graj();

        }
        if (wybor.equals("2")) {
            GraczWJednorekiegoBandyte a = new GraczWJednorekiegoBandyte();
            a.graj();
        }
    }

}
