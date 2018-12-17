public class BinarySearch {

    public static boolean binarySearchIterativ(int[] sorted, int candidate){
        int c = 2;
        int i = sorted.length/c;
        boolean result = false;
        while (i >= 0 && i < sorted.length){
            if (candidate < sorted[i]) {
                c *= 2;
                i -= sorted.length/c;
            }
            else if (candidate > sorted[i]){
                c *= 2;
                i += sorted.length/c;
            }
            else if (candidate == sorted[i]) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static boolean binarySearchRecursive(int[] sorted, int candidate){
        if (candidate == sorted[sorted.length/2])
            return true;
        else if (candidate < sorted[sorted.length/2]){
            int[] next = new int[sorted.length];
            for (int i = 0; i < sorted.length/2-1; i++){
                next[i] = sorted[i];
            }
            return binarySearchRecursive(next, candidate);
        }
        else {
            int[] next = new int[sorted.length/2];
            for (int n = sorted.length/2+1; n < sorted.length; n++){
                next[n] = sorted[n];
            }
            return binarySearchRecursive(next, candidate);
        }
    }
}
