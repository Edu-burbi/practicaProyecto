package controlador;

import java.util.List; 

import modelos.Cell;

public interface MazeSolver {
    List<Cell> getPath(boolean[][] grid, Cell start, Cell end); 
}
