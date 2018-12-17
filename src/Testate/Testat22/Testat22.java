package Testate.Testat22;

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
        if (n > 0){
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

    public static boolean isSorted(int[] arr, int i){
        if (arr[i-1] <= arr[i]){
            if (i == 1)
                return true;
            else return isSorted(arr, i-1);
        }
        return false;
    }

    public static int countPositives(int[] arr, int d, int t){
        if (d <= t){
            return arr[d] > 0? countPositives(arr, d+1, t) + 1 : countPositives(arr, d+1, t);
        }
        else return 0;
    }

    public static boolean contentCheck(char[] arr1, char[] arr2, int i){
        if (i > 0){
            return arr1[i] == arr2[i] && contentCheck(arr1, arr2, i-1);
        }
        else
            return arr1[i] == arr2[i];
    }

    public static boolean palindromCheck(char[] arr, int i){
        if (i < arr.length/2){
            return arr[i] == arr[arr.length-1-i] && palindromCheck(arr, i+1);
        }
        else return true;
    }

    public static int getIndex(int[] arr, int i, int x){
        if (i < 0 || i >= arr.length)
            return -1;
        return arr[i] == x ? i : getIndex(arr, i-1, x);
    }
}
