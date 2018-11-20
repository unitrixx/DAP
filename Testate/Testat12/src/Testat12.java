public class Testat12 {

    public static int countNegatives(int[] n){
        int count = 0;
        for (int a : n){
            if (a < 0)
                count++;
        }
        return count;
    }

    public static int sumUpNegatives(int[] n){
        int sum = 0;
        for (int a : n){
            if (a < 0)
                sum += a;
        }
        return sum;
    }

    public static int maximum(int[] n){
        int max = n[0];
        for (int a : n){
            if (max < a)
                max = a;
        }
        return max;
    }

    public static int countMaximum(int[] n){
        int max = maximum(n);
        int count = 0;
        for (int a : n){
            if (a == max)
                count++;
        }
        return count;
    }

    public static boolean isSorted(int[] n){
        boolean sorted = true;
        for (int i = 1; i < n.length; i++){
            if (n[i-1] > n[i])
                sorted = false;
        }
        return sorted;
    }

    public static boolean checkArray(int[] n){
        boolean isPal = true;
        for (int i = 0; i <= n.length/2; i++){
            if (n[i] != n[i-1-i])
                isPal = false;
        }
        return isPal;
    }

    public static int[] increaseArray(int[] n, int v){
        for (int a : n){
            a += v;
        }
        return n;
    }

    public static int[] doubleIfContainsPositive(int[] n){
        boolean contains = false;
        for (int a : n){
            if (a > 0){
                contains = true;
                break;
            }
        }
        if (contains){
            for (int a : n){
                a *= 2;
            }
        }
        return n;
    }

    public static String toString(int[] n){
        String str = "";
        str += n[0];
        for (int i = 1; i < n.length;i++){
            str += n[i];
        }
        return str;
    }

    public static int[] copyStartingValues(int[] n){
        int[] first = new int[3];
        first[0] = n[0];
        first[1] = n[1];
        if (n.length >= 3)
            first[2] = n[2];
        return first;
    }

    public static int[] selectNegatives(int[] n){
        int[] neg = new int[countNegatives(n)];
        int index = 0;
        for (int a : n){
            if (a < 0){
                neg[index] = a;
                index++;
            }
        }
        return neg;
    }

    public static int[] copyAndInvert(int[] n){
        int[] invers = new int[n.length];
        for (int i = n.length; i > 0; i--){
            invers[n.length-i] = n[i];
        }
        return invers;
    }

    public static int[] addArrays(int[] n, int[] m){
        int[] sum = new int[n.length];
        if (n.length == m.length){
            for (int i = 0; i < n.length; i++){
                sum[i] = n[i] + m[i];
            }
        }
        return sum;
    }

    public static int countSequences(int[] n){
        int count = 0;
        for (int i = 0; i < n.length; i++){
            if (i == 0 || n[i-1] == 0)
                count++;
        }
        return count;
    }

    public static boolean twoTimes(int[] n){
        if (n.length % 2 != 0)
            return false;
        boolean result = false;
        int i = 0;
        while (i < n.length){
            int z = n[i];
            int count = 0;
            for (int j = 0; j < n.length; j++){
                if (j != i && z == n[j])
                    count++;
            }
            if (count == 2)
                result = true;
            i++;
        }
        return result;
    }

}
