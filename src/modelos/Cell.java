package modelos;

import java.util.Objects;

public class Cell {
    
    public int row;
    public int col;

    public Cell(int row,int col) {
        this.col= col;
        this.row = row;

    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) 
        return true;
        if (obj == null || getClass() != obj.getClass()) 
        return false;
        Cell cell = (Cell) obj;
        return row == cell.row && col == cell.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }

    @Override
    public String toString() {
        return "[" + row + "," + col + "]";
    }
}