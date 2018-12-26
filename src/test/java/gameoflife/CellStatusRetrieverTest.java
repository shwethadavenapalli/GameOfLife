package gameoflife;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Shwetha on 26-12-2018.
 */
public class CellStatusRetrieverTest {

    @Test
    public void givenInvalidDimensionValue_Then_Should_Return_False() {
        CellBoard cellBoard = new CellBoard(2);
        CellStatusRetriever cellStatus = new CellStatusRetriever(cellBoard);
        assertThat(cellStatus.isValidCell(-1, 0)).isEqualTo(false);
        assertThat(cellStatus.isValidCell(0, -1)).isEqualTo(false);
        assertThat(cellStatus.isValidCell(2, 0)).isEqualTo(false);
        assertThat(cellStatus.isValidCell(0, 2)).isEqualTo(false);
        assertThat(cellStatus.isValidCell(3, 1)).isEqualTo(false);
    }


    @Test
    public void givenCellPosition_ShouldReturn_CellStatus() {
        CellBoard cellBoard = new CellBoard(2);
        CellStatusRetriever cellStatus = new CellStatusRetriever(cellBoard);
         cellStatus= cellStatus.getCellStatus(0,0);
        assertThat(cellStatus).isNotNull();
        assertThat(cellStatus.getDeadCellCount()).isEqualTo(2);
        assertThat(cellStatus.getLiveCellCount()).isEqualTo(1);

        cellStatus= cellStatus.getCellStatus(0,1);
        assertThat(cellStatus).isNotNull();
        assertThat(cellStatus.getDeadCellCount()).isEqualTo(2);
        assertThat(cellStatus.getLiveCellCount()).isEqualTo(1);

        cellStatus= cellStatus.getCellStatus(1,0);
        assertThat(cellStatus).isNotNull();
        assertThat(cellStatus.getDeadCellCount()).isEqualTo(1);
        assertThat(cellStatus.getLiveCellCount()).isEqualTo(2);

        cellStatus= cellStatus.getCellStatus(1,1);
        assertThat(cellStatus).isNotNull();
        assertThat(cellStatus.getDeadCellCount()).isEqualTo(1);
        assertThat(cellStatus.getLiveCellCount()).isEqualTo(2);
    }

    @Test
    public void givenCellPosition_When6LiveCells_r_There_ShouldReturn_CellStatus() {
        CellBoard cellBoard = new CellBoard(6);
        CellStatusRetriever cellStatus = new CellStatusRetriever(cellBoard);
         cellStatus= cellStatus.getCellStatus(0,0);
        assertThat(cellStatus).isNotNull();
        assertThat(cellStatus.getLiveCellCount()).isEqualTo(3);
        assertThat(cellStatus.getDeadCellCount()).isEqualTo(0);

        cellStatus= cellStatus.getCellStatus(0,1);
        assertThat(cellStatus).isNotNull();
        assertThat(cellStatus.getLiveCellCount()).isEqualTo(5);
        assertThat(cellStatus.getDeadCellCount()).isEqualTo(0);

        cellStatus= cellStatus.getCellStatus(0,2);
        assertThat(cellStatus).isNotNull();
        assertThat(cellStatus.getLiveCellCount()).isEqualTo(3);
        assertThat(cellStatus.getDeadCellCount()).isEqualTo(0);

        cellStatus= cellStatus.getCellStatus(1,0);
        assertThat(cellStatus).isNotNull();
        assertThat(cellStatus.getLiveCellCount()).isEqualTo(3);
        assertThat(cellStatus.getDeadCellCount()).isEqualTo(2);

        cellStatus= cellStatus.getCellStatus(1,1);
        assertThat(cellStatus).isNotNull();
        assertThat(cellStatus.getLiveCellCount()).isEqualTo(5);
        assertThat(cellStatus.getDeadCellCount()).isEqualTo(3);

        cellStatus= cellStatus.getCellStatus(1,2);
        assertThat(cellStatus).isNotNull();
        assertThat(cellStatus.getLiveCellCount()).isEqualTo(3);
        assertThat(cellStatus.getDeadCellCount()).isEqualTo(2);

        cellStatus= cellStatus.getCellStatus(2,0);
        assertThat(cellStatus).isNotNull();
        assertThat(cellStatus.getLiveCellCount()).isEqualTo(2);
        assertThat(cellStatus.getDeadCellCount()).isEqualTo(1);
    }

}