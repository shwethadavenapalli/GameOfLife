package gameoflife;

/**
 * Created by Shwetha on 25-12-2018.
 */
public class CellStatusRetriever {
    private final CellBoard cellBoard;
    private int liveCellCount;
    private int deadCellCount;

    public CellStatusRetriever(CellBoard cellBoard) {
        this.cellBoard = cellBoard;
    }
    public CellStatusRetriever getCellStatus(int row, int col) {
        int liveCellCount = 0;
        int deadCellCount = 0;

        //Getting 8 neighbour cell status
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {

                int cellXPos = row + x;
                int cellYPos = col + y;
                if (cellXPos == row && cellYPos == col) {
                    continue;
                }
                if (isValidCell(cellXPos, cellYPos)) {
                    if (cellBoard.isCellAlive(cellXPos, cellYPos)) {
                        liveCellCount++;
                    } else {
                        deadCellCount++;
                    }
                }
            }
        }

        this.liveCellCount = liveCellCount;
        this.deadCellCount = deadCellCount;
        return this;
    }

    public boolean isValidCell(int row, int col) {
        return (row >= 0 && row < cellBoard.getGridSize() && col >= 0 && col < cellBoard.getGridSize());
    }

    public int getLiveCellCount() {
        return liveCellCount;
    }


    public int getDeadCellCount() {
        return deadCellCount;
    }

}
