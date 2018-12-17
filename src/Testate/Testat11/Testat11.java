package Testate.Testat11;

public class Testat11 {

    public static void main (String[] args){
        System.out.println("Das Maximum von 1, 2, 3 ist: " + determineMaximum(1,2,3));
        System.out.println("Die Summe aller Zahlen zwischen 5 und 11 ist: " + interval(5,11));
        System.out.println("Die Zahlen 3, 4, 5 sind ein Pytha-Tripel: " + isPythaTriple(3,4,5));
        System.out.println("Die Zahlen 6, 4, 5 sind kein Pytha-Tripel: " + isPythaTriple(6,4,5));
        System.out.println("Die Quersumme von 43 ist " + digitSumToString(43) + ". Die Quersumme von 99 ist " + digitSumToString(99));
        System.out.println("12 ist eine Hashard-Zahl: " + isHarshad(12));
        showSawTeeth(5,3);
    }

    public static int determineMaximum(int a, int b, int c){
        int max = a;
        if (max < b) max = b;
        if (max < c) max = c;
        return max;
    }

    public static int interval(int a, int b){
        int inf = a;
        int sup = b;
        int sum = 0;
        inf = inf > b? b : inf;
        sup = sup < a? a : sup;
        for (int i = inf; i <= sup; i++){
            sum += i;
        }
        return sum;
    }

    public static boolean isPythaTriple(int a, int b, int c){
        if (determineMaximum(a,b,c) == a)
            return a*a == (b*b + c*c);
        else if (determineMaximum(a,b,c) == b)
            return b*b == (a*a + c*c);
        else return c*c == (a*a + b*b);
    }

    public static int digitSum(int a){
        a = Math.abs(a);
        int sum = 0;
        while (a != 0){
            sum += a%10;
            a = a/10;
        }
        return sum;
    }

    public static String digitToString(int a){
        String[] digit = {"null", "eins", "zwei", "drei", "vier", "fünf", "sechs", "sieben", "acht", "neun"};
        return digit[a];
    }

    public static String intToString(int a){
        String result = "";
        if (a < 0){
            result += "minus-";
            a = -a;
        }
        int dim = 1000000;
        while (a/dim == 0){
            dim /= 10;
        }
        while (dim >= 10){
            result = result + digitToString(a/dim) + "-";
            a = a % dim;
            dim /= 10;
        }
        result += digitToString(a);
        return result;
    }

    public static String digitSumToString(int a){
        return intToString(digitSum(a));
    }

    public static boolean isHarshad(int a){
        return a % digitSum(a) == 0;
    }

    public void computeHarshad(int n){
        for (int i = 1; i <= n; i++){
            if (isHarshad(i))
                System.out.println(i);
        }
    }

    public static double computeEuler(int n){
        double e = 1;
        int fac = 1;
        for (int i = 1; i < n; i++){
            fac = fac * i;
            e += (1 / fac);
        }
        return e;
    }

    public static void showSawTeeth(int n, int h){
        int x = h-1;
        int hi = h;
        while (hi > 0){
            for (int i = n; i > 0; i--){
                for (int j = 1; j < hi; j++){
                    System.out.print(" ");
                }
                for (int z = h; z > x; z--){
                    System.out.print("/");
                }
            }
            System.out.print("\n");
            hi--;
            x -= 1;
        }
    }

}
