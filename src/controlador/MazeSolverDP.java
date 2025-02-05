package controlador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import modelos.Cell;

public class MazeSolverDP implements MazeSolver {
    private Map<Cell, Boolean> memoria = new HashMap<>();
    private Set<Cell> visitadas = new HashSet<>(); // Set igual que el recursivo

    @Override
    public List<Cell> getPath(boolean[][] grid, Cell start, Cell end) {
        List<Cell> path = new ArrayList<>();
        if (grid == null || grid.length == 0) {
            return path; 
        }
        if (findPath(grid, start.row, start.col, end, path)) {
            return path; 
        }
        return new ArrayList<>();
    }

    private boolean findPath(boolean[][] grid, int row, int col, Cell end, List<Cell> path) {
        Cell cell = new Cell(row, col);
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || !grid[row][col] || visitadas.contains(cell)) {
            return false;
        }
        if (cell.equals(end)) {
            path.add(cell);
            return true;
        }
        visitadas.add(cell);

        if (findPath(grid, row + 1, col, end, path) || // Abajo
            findPath(grid, row - 1, col, end, path) || // Arriba
            findPath(grid, row, col - 1, end, path) || // Izquierda
            findPath(grid, row, col + 1, end, path)) { // Derecha
            path.add(cell);
            memoria.put(cell, true); 
            return true;
        }
        memoria.put(cell, false);
        return false;
    }
}
