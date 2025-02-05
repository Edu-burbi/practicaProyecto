package controlador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import modelos.Cell;
import modelos.Maze;

public class MazeSolverDP implements MazeSolver {
    
    // Declaramos las variables que faltan
    private Map<Cell, Boolean> memoria = new HashMap<>();
    private Set<Cell> visitadas = new HashSet<>();

    @Override
    public List<Cell> getPath(Maze maze, Cell start, Cell end) {
        List<Cell> path = new ArrayList<>();
        boolean[][] grid = maze.getGrid();  // Obtener el grid del laberinto

        if (grid == null || grid.length == 0) {
            return path; 
        }
        
        // Llamamos a la función para encontrar el camino
        if (findPath(grid, start.row, start.col, end, path)) {
            return path; 
        }
        
        return new ArrayList<>();
    }

    private boolean findPath(boolean[][] grid, int row, int col, Cell end, List<Cell> path) {
        Cell cell = new Cell(row, col);

        // Verificamos si la celda está fuera de los límites o no es válida
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || !grid[row][col] || visitadas.contains(cell)) {
            return false;
        }

        // Si llegamos al final, agregamos la celda al camino
        if (cell.equals(end)) {
            path.add(cell);
            return true;
        }

        // Marcamos la celda como visitada
        visitadas.add(cell);

        // Intentamos movernos a todas las direcciones (abajo, arriba, izquierda, derecha)
        if (findPath(grid, row + 1, col, end, path) || 
            findPath(grid, row - 1, col, end, path) || 
            findPath(grid, row, col - 1, end, path) || 
            findPath(grid, row, col + 1, end, path)) {
            path.add(cell);
            memoria.put(cell, true);  // Marcamos esta celda en memoria como parte del camino
            return true;
        }

        memoria.put(cell, false);  // Si no encontramos un camino, marcamos la celda en memoria como no válida
        return false;
    }
}
