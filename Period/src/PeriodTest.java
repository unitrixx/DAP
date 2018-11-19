public class PeriodTest {

    public static void main (String[] args){
        Period a = new Period(53);
        Period b = new Period(17,3);
        Period c = a.clone();

        System.out.println("getMinutes / getHours:");
        System.out.println("a: " + a.getMinutes() + " / " + a.getHours());
        System.out.println("b: " + b.getMinutes() + " / " + b.getHours());
        System.out.println("b: " + c.getMinutes() + " / " + c.getHours());

        System.out.println("");

        System.out.println("getMinorMinutes:");
        System.out.println("a: " + a.getMinorMinutes());
        System.out.println("b: " + b.getMinorMinutes());
        System.out.println("b: " + c.getMinorMinutes());

        System.out.println("");

        System.out.println("toString:");
        System.out.println("a: " + a.toString());
        System.out.println("b: " + b.toString());
        System.out.println("b: " + c.toString());
        a.change(33);
        System.out.println("a + 33: " + a.toString());
    }
}
