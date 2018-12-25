package Uebungen.Sudoku;

import java.util.Iterator;

public class Sudoku {

    private int[][] values;
    private boolean[][] writable;

    public Sudoku(int[][] vals){
        writable = new boolean[9][9];
        values = vals;
        for (int n = 0; n < 9; n++){
            for (int b = 0; b < 9; b++){
                if (values[n][b] > 0)
                    writable[n][b] = false;
                else {
                    writable[n][b] = true;
                }
            }
        }
    }

    public void setValue(int i, int j, int value){
        if (writable[i][j])
            values[i][j] = value;
    }

    public int getValue(int i, int j){
        return values[i][j];
    }

    public boolean isWritable(int i, int j){
        return writable[i][j];
    }

    public void show (){
        for ( int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                System.out.print(values[i][j]);
            }
            System.out.println("\n");
        }
    }

    public Iterator<Integer> rowIterator(int r, int c){
        return new SameRowIterator(r, c);
    }

    public Iterator<Integer> columnIterator(int r, int c){
        return new SameColumnIterator(r, c);
    }

    public Iterator<Integer> boxIterator(int r, int c){
        return new SameBoxIterator(r, c);
    }

    private class SameRowIterator implements Iterator<Integer>{
        int r;
        int c;

        public SameRowIterator(int i, int j){
            r = i;
            c = 0;
        }

        public boolean hasNext(){
            return r < 9 && c < 9;
        }

        public Integer next(){
            if (hasNext()){
                c++;
                return values[r][c-1];
            }
            else throw new IndexOutOfBoundsException();
        }
    }

    private class SameColumnIterator implements Iterator<Integer>{

        int r;
        int c;

        public SameColumnIterator(int x, int y){
            r = 0;
            c = y;
        }


        public boolean hasNext(){
            return c < 9 && r < 9;
        }

        public Integer next(){
            if (hasNext()){
                r++;
                return values[r-1][c];
            }
            else throw new IndexOutOfBoundsException();
        }
    }

    private class SameBoxIterator implements Iterator<Integer>{

        int r;
        int c;

        public SameBoxIterator(int x, int y){
            r = x - x%3;
            c = y - y%3;
        }

        public boolean hasNext(){
            return r%3 != 0;
        }

        public Integer next(){
            if (hasNext()){
                int ret = values[r][c];
                c++;
                if (c%3 == 0){
                    c -= 3;
                    r++;
                }
                return ret;
            }
            else throw new IndexOutOfBoundsException();
        }
    }
}
