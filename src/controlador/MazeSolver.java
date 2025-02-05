package controlador;

import java.util.List;
import modelos.Cell;
import modelos.Maze;
public interface MazeSolver {
    // Cambiar la firma para que reciba el objeto Maze en lugar de boolean[][]
    List<Cell> getPath(Maze maze, Cell start, Cell end); 
}
