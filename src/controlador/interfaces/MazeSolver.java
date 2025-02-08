package controlador.interfaces;

import java.util.List;
import modelos.Cell;
import modelos.Maze;

public interface MazeSolver {

    public List<Cell> getPath(Maze maze, boolean[][] grid, Cell start, Cell end);

}
