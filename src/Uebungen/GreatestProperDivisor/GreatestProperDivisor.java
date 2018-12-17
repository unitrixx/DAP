package Uebungen.GreatestProperDivisor;

public class GreatestProperDivisor {
    public static boolean[] SiebDesEratosthenes(){
        boolean[] a = new boolean[1000];
        a[0] = false;
        a[1] = false;
        for (int i = 2; i< a.length; i++){
            a[i] = true;
        }
        int z = 0;
        while (z<a.length){
            if (a[z]){
                for (int i = 2; i*z<a.length; i++){
                    a[i*z] = false;
                }
                z++;
            }
            else z++;
        }
        a[1] = true;
        return a;
    }
    public static int greatestProperDivisor (int n){
        int result = 1;
        boolean[] b = SiebDesEratosthenes();
        for (int i = 2; i < b.length; i++){
            if (b[i] && (i<n || n<-i)){
                if (n % i == 0 && n !=i){
                    result = n / i;
                    i= b.length;
                }
            }
        }
        return result;
    }
    public static void main (String[] args){
        int n = 333;
        System.out.println("Der größte echte Teiler der Zahl " + n + " ist " + greatestProperDivisor(n) + ".");
    }
}