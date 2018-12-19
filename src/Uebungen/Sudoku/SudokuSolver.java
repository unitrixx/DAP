public class SudokuSolver {

    public boolean isSolvable(Sudoku sudoku){
        return isSolvable(sudoku, 0, 0);
    }

    public boolean isSolvable(Sudoku sudoku, int i, int j){
        if (i == 9 && j == 0)
            return true;
        if (sudoku.isWritable(i, j)){
            for(int n = 1; n <= 9; n++)
            {
                if(conflictAt(sudoku,i,j,n))
                    continue;
                sudoku.setValue(i,j,n);
                if (j != 8)
                {
                    if (isSolvable(sudoku, i, j + 1))
                        return true;
                }
                else {
                    if(isSolvable(sudoku, i+1, 0))
                        return true;
                }
                sudoku.setValue(i,j,0);
            }
            return false;
        }
        else{
            if(j != 8)
                return isSolvable(sudoku, i,j+1);
            return isSolvable(sudoku, i+1, 0);
        }
    }

    public boolean conflictAt(Sudoku sudoku, int i, int j, int value){
        if (value > 9 || value < 1)
            return true;
        if (!sudoku.isWritable(i, j))
            return true;
        for (int b = 0; b < 9; b++){
            if (sudoku.getValue(i, b) == value)
                return true;
        }
        for (int a = 0; a < 9; a++){
            if (sudoku.getValue(a, j) == value)
                return true;
        }

        int blockI = i - i%3;
        int blockJ = j - j%3;

        for(int a = 0; a < 3 ; a++)
        {
            for(int b = 0; b < 3; b++)
            {
                if(sudoku.getValue(blockI + a,blockJ + b) == value)
                    return true;
            }
        }

//        for (int r = i- i%3; r <= i - i%3 + 2; r++){
//            for (int c = j - j%3; c <= j - j%3 + 2; c++){
//                if (sudoku.getValue(r, c) == value)
//                    return true;
//            }
//        }
        return false;
    }
}