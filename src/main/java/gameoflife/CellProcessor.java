package gameoflife;

/**
 * Created by Shwetha on 25-12-2018.
 */
public class CellProcessor {

    private final CellBoard cellBoard;

    public CellProcessor(CellBoard cellBoard) {

        this.cellBoard = cellBoard;
    }

    public void tick() {
        processCellLife();
    }

    private void processCellLife() {
        int gridSize = cellBoard.getGridSize();
        int transformedCellGrid[][] = cellBoard.getCellGrid();
        CellStatusRetriever cellStatus = new CellStatusRetriever(cellBoard);
        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                cellStatus.getCellStatus(row, col);
                if (cellBoard.isCellAlive(row, col)) {
                    if (cellStatus.getLiveCellCount() < 2) {
                        makeCellDead(transformedCellGrid, row, col);
                    } else if (cellStatus.getLiveCellCount() > 3) {
                        makeCellDead(transformedCellGrid, row, col);
                    }
                } else {
                    if (cellStatus.getLiveCellCount() == 3) {
                        makeCellLive(transformedCellGrid, row, col);
                    }
                }
            }
        }
        cellBoard.setCellGrid(transformedCellGrid);
    }

    private void makeCellLive(int[][] transformedCellGrid, int row, int col) {
        transformedCellGrid[row][col] = 1;
    }

    private void makeCellDead(int[][] transformedCellGrid, int row, int col) {
        transformedCellGrid[row][col] = 0; //make cell dead
    }


}
