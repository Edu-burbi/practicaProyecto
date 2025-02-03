package modelos;

public class Cell {
    
    public int row;
    public int col;

    public Cell(int row,int col) {
        this.col= col;
        this.row = row;

    }

    @Override
    public String toString() {
        return "[" + row + "," + col + "]";
    }
}
