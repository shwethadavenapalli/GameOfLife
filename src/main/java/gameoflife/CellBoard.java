package gameoflife;

/**
 * Created by Shwetha on 25-12-2018.
 */
public class CellBoard {

    private final int numberOfLiveCells;
    private final int numberOfDeadCells;
    private final int gridSize;

    private int[][] cellGrid;

    public CellBoard(int numberOfLiveCells) {

        this.numberOfLiveCells = numberOfLiveCells;
        this.gridSize = getBoardSizeToAccumulateLiveCells(numberOfLiveCells);
        this.numberOfDeadCells = (gridSize * gridSize) - numberOfLiveCells;
        cellGrid = new int[gridSize][gridSize];
        initializeCellGrid(gridSize, numberOfLiveCells);
    }

    private void initializeCellGrid(int gridSize, int numberOfLiveCells) {
        int initialCellCountInitializedWithLiveCells = 0;
        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                if (initialCellCountInitializedWithLiveCells != numberOfLiveCells) {
                    cellGrid[row][col] = 1;
                    initialCellCountInitializedWithLiveCells++;
                } else {
                    break;
                }
            }
        }
    }

    private int getBoardSizeToAccumulateLiveCells(int numberOfLiveCells) {
        if (numberOfLiveCells == 1) return 1;
        return (int) Math.floor(Math.sqrt(numberOfLiveCells)) + 1;

    }


    public int getLiveCellCount() {
        return numberOfLiveCells;
    }

    public int getDeadCellCount() {
        return numberOfDeadCells;
    }

    public boolean isCellAlive(int rowNum, int colNum) {
        return cellGrid[rowNum][colNum] == 1;
    }


    public int getGridSize() {
        return gridSize;
    }


    public void setCellGrid(int[][] grid) {
        this.cellGrid = grid;
    }

    public int[][] getCellGrid() {

        int current[][] = new int[gridSize][gridSize];
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                current[i][j] = cellGrid[i][j];
            }
        }
        return current;
    }
}