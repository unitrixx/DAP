public class Testat22 {

    public static int digitSum (int n){
        if (n/10 > 0){
            return digitSum(n/10) + n%10;
        }
        return n;
    }

    public static double harm(int n){
        if (n > 1){
            return (1/n) + harm(n-1);
        }
        return 1;
    }

    public static double power(int a, int n){
        if (n > 0)
            return a * power(a, n-1);
        else if (n < 0)
            return 1/a * power(a, n+1);
        else return 1;
    }

    public static double powerPlus(int a, int n){
        if (n < 0){
            if (n%2 == 0){
                return powerPlus(a, n/2) * powerPlus(a, n/2);
            }
            else return powerPlus(a, (n-1)/2) * powerPlus(a, (n-1)/2) * a;
        }
        else if (n < 0){
            if (n%2 == 0){
                return 1/powerPlus(a, n/2) * 1/powerPlus(a, n/2);
            }
            else return 1/powerPlus(a, (n+1)/2) * 1/powerPlus(a, (n+1)/2) * 1/a;
        }
        else return 1;
    }

    public static String binaryCode(int i){
        if (i > 0){
            return binaryCode(i/2) + i%2;
        }
        return "";
    }

    public static int maximum(int[] arr, int i){
        if(i==0)
            return arr[i];
        int recMax = maximum(arr, i-1);
        return arr[i]> recMax ? arr[i]:recMax;
    }
}
