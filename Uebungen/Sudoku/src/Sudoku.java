public class Sudoku {

    private int[][] values;
    private boolean[][] writable;

    public Sudoku(int[][] vals){
        values = vals;
        for (int n = 0; n < values.length; n++){
            for (int b = 0; b < values[n].length; b++){
                if (b > 0)
                    writable[n][b] = false;
                else {
                    writable[n][b] = true;
                    values[n][b] = 0;
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
}
