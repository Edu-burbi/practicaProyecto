package modelos;

import java.util.Arrays;
import java.util.List;

public class Maze {

    private boolean[][] grid;
    private int size;

    public Maze(int size) {
        this.size = size;
        grid = new boolean[size][size];
        
        for (int i = 0; i < size; i++) {
                Arrays.fill(grid[i], true);
        }
    }
    public Maze(boolean[][]predefinedGrid){
        this.size = predefinedGrid.length;
        this.grid = predefinedGrid;


    }
    public boolean [][] getGrid(){
            return grid;
    }
    public void printMaze(){
        for (boolean[] row:grid) {
            for (boolean celda : row) {
                System.out.print(celda? " - " : " * ");
            }
            System.out.println();
        }
    }
    public void printMazeSolver(List<Cell> path) {
        for (int j = 0; j < grid.length; j++) {
            for (int k = 0; k < grid[j].length; k++) {
                boolean celda = grid[j][k];
    
                if (isInPath(j, k, path)) {
                    if (path.indexOf(new Cell(j, k)) < path.size() - 1) {
                        System.out.print(" - ");  
                    } else {
                        System.out.print(" > ");  
                    }
                } else if (celda) {
                    System.out.print(" - ");  
                } else {
                    System.out.print(" * ");  
                }
            }
            System.out.println();
        }
    }
    
    private boolean isInPath(int row, int col, List<Cell> path) {
        for (Cell cell : path) {
            if (cell.row == row && cell.col == col) {
                return true; 
            }
        }
        return false; 
    }
 
}    