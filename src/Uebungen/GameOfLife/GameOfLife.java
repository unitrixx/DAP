package Uebungen.GameOfLife;

public class GameOfLife {

    private boolean[][] cells;

    public GameOfLife(int w, int h){
        cells = new boolean[h+2][w+2];
        generate();
    }

    private void generate(){
        for (int i = 0; i< cells.length; i++){
            if (i == cells.length-1 || i == 0) {
                for (boolean b : cells[i])
                    b = false;
            }
            else {
                for (int j = 0; j < cells[i].length; j++) {
                    if (j == 0 || j == cells[i].length-1)
                        cells[i][j] = false;
                    else
                    cells[i][j] = Math.random() < 0.5;
                }
            }
        }
    }

    public boolean nextState(int i, int j){
        boolean nextState = false;
        if (cells[i][j]){
            int count = count(i,j)-1;
            if (count == 2 || count == 3){
                nextState = true;
            }
        }
        else{
            int count = count(i,j);
            if (count == 3)
                nextState = true;
        }
        return nextState;
    }

    private int count(int i, int j){
        int counter = 0;
            for (int r = i - 1; r <= i + 1; r++) {
                for (int c = j - 1; c <= j + 1; c++) {
                    if (cells[r][c]) {
                        counter++;
                    }
                }
            }
        return counter;
    }

    public void nextGeneration(){
        boolean[][] next = new boolean[cells.length][cells[0].length];
        for(int i = 1; i < cells.length-1; i++){
            for (int j = 1; j < cells[i].length-1; j++)
                next[i][j] = nextState(i,j);
        }
        cells = next;
    }

    public void futureGeneration( int n ){
        for (int i = 1; i <= n; i++)
            nextGeneration();
    }

    public void show(){
        for (int i = 0; i < cells[0].length; i++){
            if (i == 0)
                System.out.print("+");
            else if (i == cells[0].length-1)
                System.out.println("+");
            else
                System.out.print("-");
        }
        for (int i = 1; i < cells.length-1; i++){
            System.out.print("|");
            for (int j = 1; j < cells[i].length-1; j++){
                if (cells[i][j]){
                    System.out.print("X");
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println("|");
        }
        for (int i = 0; i < cells[0].length; i++){
            if (i == 0)
                System.out.print("+");
            else if (i == cells[0].length-1)
                System.out.println("+");
            else
                System.out.print("-");
        }
    }

    public void run(int n){
        show();
        for (int i = 1; i <= n; i++){
            nextGeneration();
            show();
        }
    }
}
