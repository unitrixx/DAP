public class CountPairs {
    public static int countPairs (int[] arr){
        int count = 0;
        for (int i = 1; i < arr.length; i++){
            if (arr[i-1] == arr[i]){
                count++;
                i++;
            }
        }
        return count;
    }
    public static void main (String[] args){
        int[] arr = {1,1,3,1,4,4,5,2,2,2,6,2,7,7,7,7};
        System.out.println("Das gegebene Array enhält " + countPairs(arr) + " Paare.");
    }
}
