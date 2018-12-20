package Uebungen.Iterator2DInt;

public class Iterator {

    int r;
    int c;
    int[][] arr;

    int rOffset;
    int cOffset;

    public Iterator(int[][] n){
        r = 0;
        c = 0;
        arr = n;
        rOffset = 1;
        cOffset = 1;
    }

    public Iterator(int[][] n, int rO, int cO){
        r = 0;
        c = 0;
        arr = n;
        rOffset = rO;
        cOffset = cO;
    }

    public boolean hasNext(){
        return r < arr.length && c < arr[r].length;
    }

    public int next(){
        if (hasNext()){
            int ret = arr[r][c];
            c += cOffset;
            if (!(c < arr[r].length)) {
                c = 0;
                r += rOffset;
            }
            return ret;
        }
        else {
            throw new IndexOutOfBoundsException();
        }
    }
}
