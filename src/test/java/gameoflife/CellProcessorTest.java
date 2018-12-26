package gameoflife;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by Shwetha on 25-12-2018.
 */
public class CellProcessorTest {


    @Test
    public void given_Live_Cell_Surrounded_By_No_Live_Neighbour_Then_Cell_Should_Die() {
        CellBoard cellBoard = new CellBoard(1);
        CellProcessor cellProcessor = new CellProcessor(cellBoard);
        cellProcessor.tick();
        assertThat(cellBoard.isCellAlive(0, 0)).isEqualTo(false);
    }

    @Test
    public void given_Live_Cell_Surrounded_By_One_Live_Neighbour_Then_Cell_Should_Die() {
        CellBoard cellBoard = new CellBoard(2);
        CellProcessor cellProcessor = new CellProcessor(cellBoard);
        cellProcessor.tick();
        assertThat(cellBoard.isCellAlive(0, 0)).isEqualTo(false);
        assertThat(cellBoard.isCellAlive(0, 1)).isEqualTo(false);
    }

    @Test
    public void given_Live_Cell_Surrounded_By_Two_Live_Neighbour_Then_Cell_Should_Not_Die() {
        CellBoard cellBoard = new CellBoard(3);
        CellProcessor cellProcessor = new CellProcessor(cellBoard);
        cellProcessor.tick();
        assertThat(cellBoard.isCellAlive(0, 0)).isEqualTo(true);
        assertThat(cellBoard.isCellAlive(0, 1)).isEqualTo(true);
        assertThat(cellBoard.isCellAlive(1, 0)).isEqualTo(true);

    }


    @Test
    public void given_3LiveCell_And_1Dead_Cell_Surrounded_By_Exactly_3_Live_Neighbour_Then_Cell_Should_Live() {
        CellBoard cellBoard = new CellBoard(3);
        CellProcessor cellProcessor = new CellProcessor(cellBoard);
        cellProcessor.tick();
        assertThat(cellBoard.isCellAlive(1, 1)).isEqualTo(true);
    }



    @Test
    public void given_Live_Cell_Surrounded_By_More_Than_3_Live_Neighbour_Then_Cell_Should_Die_Due_To_Over_Crowded() {
        CellBoard cellBoard = new CellBoard(6);
        CellProcessor cellProcessor = new CellProcessor(cellBoard);
        cellProcessor.tick();
        assertThat(cellBoard.isCellAlive(1, 1)).isEqualTo(false);
    }
    @Test
    public void given_Dead_Cell_Surrounded_By_Exactly_3_Live_Neighbour_Then_Cell_Should_Live() {
        CellBoard cellBoard = new CellBoard(6);
        CellProcessor cellProcessor = new CellProcessor(cellBoard);
        cellProcessor.tick();
        assertThat(cellBoard.isCellAlive(2, 1)).isEqualTo(true);
    }



    @Test
    public void given_Live_Cell_Surrounded_By_3_Live_Neighbour_Then_Cell_Should_Live_For_Next_LifeCycle() {
        CellBoard cellBoard = new CellBoard(6);
        CellProcessor cellProcessor = new CellProcessor(cellBoard);
        cellProcessor.tick();
        assertThat(cellBoard.isCellAlive(0, 2)).isEqualTo(true);
    }


    @Test
    public void given_Live_Cell_Surrounded_By_2_Live_Neighbour_Then_Cell_Should_Live_For_Next_LifeCycle() {
        CellBoard cellBoard = new CellBoard(3);
        CellProcessor cellProcessor = new CellProcessor(cellBoard);
        cellProcessor.tick();
        assertThat(cellBoard.isCellAlive(0, 1)).isEqualTo(true);
        assertThat(cellBoard.isCellAlive(1, 1)).isEqualTo(true);
    }




}