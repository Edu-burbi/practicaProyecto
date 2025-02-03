import controlador.MazeSolver;
import controlador.MazeSolverBFS;
import controlador.MazeSolverRecursivo;
import java.util.Arrays;
import java.util.List;
import modelos.Cell;
import modelos.Maze;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        boolean[][] laberinto = {
            {true, true, true, true},
            {false, true, true, true},
            {true, true, false, false},
            {true, true, true, true}    
        };

        Maze maze = new Maze(laberinto);
        System.out.println("\n Laberinto: ");
        maze.printMaze(); 


        Cell start = new Cell(0,3 );
        Cell end = new Cell(3, 3);
        
        List<MazeSolver> soluciones  = Arrays.asList(new MazeSolverRecursivo(), new MazeSolverBFS());
        
        int opcion = 1;

        MazeSolver solver = soluciones.get(1-1);
        List<Cell> path = solver.getPath(laberinto, start, end);
        
        System.out.println("\n camino encontrado ");
        System.out.println(path);
        
    }
}

