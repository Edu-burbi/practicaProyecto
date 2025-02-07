package controlador;

import java.util.List;
import modelos.Cell;
import modelos.Maze;
public interface MazeSolver {
    List<Cell> getPath(Maze maze, Cell start, Cell end);
}
