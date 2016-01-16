
public class Singleton {

    private static Singleton inst;

    public Singleton() {

    }

    public static Singleton inst() {
        if (inst == null) {
            inst = new Singleton();
        }
        return inst;
    }
    private double pieniadze = 1000;

    public Double stanKasy() {
        return pieniadze;
    }

    public void zmianaStanuKasy(double x) {
        pieniadze = pieniadze + x;
    }
}
