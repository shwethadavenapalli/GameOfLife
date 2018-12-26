package com.gameoflife;

import gameoflife.CellBoard;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by Shwetha on 25-12-2018.
 */
public class CellBoardTest {

    @Test
    public void should_initialize_Game_Of_Life_Cell_Board() {
        CellBoard cellBoard = new CellBoard(1);
        assertThat(cellBoard.getLiveCellCount()).isEqualTo(1);
        assertThat(cellBoard.getDeadCellCount()).isEqualTo(0);
    }

    @Test
    public void should_initialize_Game_Of_Life_Cell_Board_With_5_Live_Cell() {
        CellBoard cellBoard = new CellBoard(5);
        assertThat(cellBoard.getLiveCellCount()).isEqualTo(5);
        assertThat(cellBoard.getDeadCellCount()).isEqualTo(4);
    }

    @Test
    public void givenRowAndCol_Value_Return_Cell_Contents() {
        CellBoard cellBoard = new CellBoard(2);
        assertThat(cellBoard.isCellAlive(0,0)).isEqualTo(true);
        assertThat(cellBoard.isCellAlive(0,1)).isEqualTo(true);
        assertThat(cellBoard.isCellAlive(1,0)).isEqualTo(false);
        assertThat(cellBoard.isCellAlive(1,1)).isEqualTo(false);
    }




}
