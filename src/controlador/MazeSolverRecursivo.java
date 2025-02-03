package controlador;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import modelos.Cell;

public class MazeSolverRecursivo implements MazeSolver {

    @Override
    public List<Cell> getPath(boolean[][] grid, Cell start, Cell end) {
        System.out.println("implementacion recursiva");
        List<Cell> path = new ArrayList<>();
        Set<Cell> visitadas = new HashSet<>();
        
//falta completar en esta parte



        if (grid == null || grid.length == 0) {
            return path;
        }
        if (findPath(grid, start.row, start.col, end, path)) {
            return path;
        }
        return new ArrayList<>();
    }
    private boolean findPath(boolean[][] grid, int row, int col, Cell end, List<Cell> path) {
        if (row >= grid.length || col >= grid[0].length || !grid[row][col]) {
            return false;
        }
        Cell cell = new Cell(row, col);
        if (row == end.row && col == end.col) {
            path.add(cell);
            return true;
        }
        if (findPath(grid, row + 1, col, end, path)) {
            path.add(cell);
            return true;
        }
        if (findPath(grid, row, col + 1, end, path)) {
            path.add(cell);
            return true;
        }
        return false;
    }

}
