package controlador;

import controlador.interfaces.MazeSolver;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import modelos.Cell;
import modelos.Maze;

public class MazeSolverRecursivo implements MazeSolver {

    @Override
    public List<Cell> getPath(Maze maze, boolean[][] grid, Cell start, Cell end){
        System.out.println("Implementación recursiva");
        List<Cell> path = new ArrayList<>();
        Set<Cell> visitadas = new HashSet<>();
        
        if (grid == null || grid.length == 0) {
            return path;
        }

        if (findPath(grid, start.row, start.col, end, path, visitadas)) {
            return path; 
        }
        return new ArrayList<>(); 
    }

    private boolean findPath(boolean[][] grid, int row, int col, Cell end, List<Cell> path, Set<Cell> visitadas) {
        // Verificar si la celda es válida
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || !grid[row][col]) {
            return false; // Fuera de límites o bloqueada
        }

        Cell cell = new Cell(row, col);
        
        // Verificar si la celda ya fue visitada
        if (visitadas.contains(cell)) {
            return false; // Ya hemos visitado esta celda
        }
        
        visitadas.add(cell);

        // Si hemos llegado al destino, agregar la celda al camino
        if (row == end.row && col == end.col) {
            path.add(cell);
            return true;
        }

        // Intentar mover en las 4 direcciones
        if (findPath(grid, row + 1, col, end, path, visitadas) ||  // Abajo
            findPath(grid, row, col + 1, end, path, visitadas) ||  // Derecha
            findPath(grid, row - 1, col, end, path, visitadas) ||  // Arriba
            findPath(grid, row, col - 1, end, path, visitadas)) {  // Izquierda
            path.add(cell);  // Agregar la celda al camino solo si la búsqueda recursiva tuvo éxito
            return true;
        }

        // Si no encontramos el camino, retrocedemos y no agregamos la celda al camino
        return false;
    }
}












































/* 

public class MazeSolverRecursivo implements MazeSolver {

    @Override
    public List<Cell> getPath(boolean[][] grid, Cell start, Cell end) {
        System.out.println("implementacion recursiva");
        List<Cell> path = new ArrayList<>();
        Set<Cell> visitadas = new HashSet<>();
           

        if (grid == null || grid.length == 0) {
            return path;
        }
        if (findPath(grid, start.row, start.col, end, path)) {
            return path;
        }
        return new ArrayList<>();
    }
    private boolean findPath(boolean[][] grid, int row, int col, Cell end, List<Cell> path, List<Cell> visitadas) {
        Cell cell = new Cell(row, col);
        if (row < 0 ||col > 0 || row >= grid.length || col >=grid[0].length || !grid[row][col]){
            return false;
        }  
        if (visitadas.contains(cell)) {
            return false;
        }
            visitadas.add(cell);
        if(row == end.row && col == end.col){
            path.add(cell);
            return true;
            
        }
            
        
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
*/