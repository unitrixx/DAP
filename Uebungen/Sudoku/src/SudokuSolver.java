public class SudokuSolver {

    public boolean isSolvable(Sudoku sudoku){
        return isSolvable(sudoku, 0, 0);
    }

    public boolean isSolvable(Sudoku sudoku, int i, int j){
        if (i >= 9 && j >= 9)
            return false;
        if (sudoku.isWritable(i, j)){

        }
        if (!sudoku.isWritable(i,j)){
            return isSolvable(sudoku,i+1, j) || isSolvable(sudoku, i, j+1);
        }
        if (i == 8 && j == 8){
            boolean result = false;
            for (int k = 1; k <= 9; k++){
                result = conflictAt(sudoku, i, j, k);
            }
            return result;
        }
    }

    public boolean conflictAt(Sudoku sudoku, int i, int j, int value){
        if (value > 9 || value < 1)
            return false;
        if (!sudoku.isWritable(i, j))
            return false;
        for (int b = 0; b < 9; b++){
            if (sudoku.getValue(i, b) == value)
                return false;
        }
        for (int a = 0; a < 9; a++){
            if (sudoku.getValue(a, j) == value)
                return false;
        }
        for (int r = i- i%3; r <= i - i%3 + 2; r++){
            for (int c = j - j%3; c <= j - j%3 + 2; c++){
                if (sudoku.getValue(r, c) == value)
                    return false;
            }
        }
        return true;
    }
}
