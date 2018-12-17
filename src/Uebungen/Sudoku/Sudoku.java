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
}
