import controlador.MazeSolver;
import controlador.MazeSolverBFS;
import controlador.MazeSolverDFS;
import controlador.MazeSolverDP;
import controlador.MazeSolverRecursivo;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import modelos.Cell;
import modelos.Maze;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        // Aquí defines tu laberinto como boolean[][]
        boolean[][] laberinto = {
            {true, true, true, true},
            {false, true, true, true},
            {true, true, false, false},
            {true, true, true, true}    
        };
        // Creas un objeto Maze pasando el laberinto
        Maze maze = new Maze(laberinto);
        System.out.println("\nLaberinto: ");
        maze.printMaze(); 
        
        // Definir el punto de inicio y fin
        Cell start = new Cell(0, 0);
        Cell end = new Cell(3, 3);
        
        // Lista de algoritmos disponibles
        List<MazeSolver> soluciones = Arrays.asList(
            new MazeSolverRecursivo(),
            new MazeSolverBFS(),
            new MazeSolverDP(),
            new MazeSolverDFS()
        );

        Scanner scanner = new Scanner(System.in);
        System.out.println("*******************************************************");
        System.out.println("\nSeleccione un algoritmo para resolver el laberinto:");
        System.out.println("1. Recursivo");
        System.out.println("2. BFS ");
        System.out.println("3. DP ");
        System.out.println("4. DFS..");

        int opcion = scanner.nextInt();
        if (opcion < 1 || opcion > 4) {
            System.out.println("Opción fuera de rango...");
            scanner.close();
            return;
        }

        // Seleccionamos el solver según la opción del usuario
        MazeSolver solver = soluciones.get(opcion - 1);

        // Ahora pasamos el objeto maze al método getPath
        List<Cell> path = solver.getPath(maze, start, end);

        System.out.println("\nCamino encontrado usando " + solver.getClass().getSimpleName() + ":");
        if (path.isEmpty()) {
            System.out.println("No hay camino");
        } else {
            for (Cell cell : path) {
                System.out.println(cell);
            }
        }

        // Imprimimos el laberinto con el camino encontrado
        Maze maze2 = new Maze(laberinto);
        System.out.println("\nLaberinto con el camino encontrado: ");
        maze2.printMazeSolver(path); 

        scanner.close();  
    }
}
