package nqueen;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BoardUtils {
	
	public static final byte EMPTY = 0;
	public static final byte QUEEN = 1;
	public static final byte BLOCKED = -1;
	
	static Set<Board> answers = new HashSet<Board>();
	
	/**
	 * This method recursively, process row and column. Put a Queen at available
	 * square. Mark all the squares as not available as per Queen's position. Find
	 * Remaining available squares. Repeat until on more empty squares left.
	 * 
	 * @param row
	 * @param col
	 * @param board
	 */
	static void processPosition(int row, int col, Board board) {
		putMarks(row, col, board);
		blockPosition(row, col, board);

		List<Tracker> trackers = availablePositions(board);

		if (trackers.isEmpty()) {
			// Save only those boards, which has N number of Queens for N x N board.
			// Ignore duplicates, found due to the fact that Chess board is symmetrical.
			if (board.getQueenCount() == board.getRows()) {
				answers.add(board);
			}
		} else {
			for (Tracker tk : trackers) {
				Board nBoard = copyBoard(board);
				processPosition(tk.getRow(), tk.getCol(), nBoard);
			}
		}
	}
	
	/**
	 * Find all the squares available for placing Queen.
	 * 
	 * @param board
	 * @return
	 */
	private static List<Tracker> availablePositions(Board board) {
		List<Tracker> availablePositions = new ArrayList<Tracker>();
		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getCols(); j++) {
				if (board.getBoardPosition(i, j) == EMPTY) {
					Tracker t = new Tracker(i, j);
					availablePositions.add(t);
				}
			}
		}

		return availablePositions;
	}

	/**
	 * Reset board to empty state.
	 * 
	 * @param board
	 */
	static void resetBoard(Board board) {
		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getCols(); j++) {
				board.setBoardPosition(i, j, EMPTY);
			}
		}
	}

	/**
	 * Place a Queen at index given by row and column.
	 * 
	 * @param row
	 * @param column
	 * @param board
	 * @thboard.getRows() IllegalArgumentException
	 */
	private static void putMarks(int row, int column, Board board) {
		if (row < 0 || row >= board.getRows() && (column < 0 || column >= board.getCols()))
			throw new IllegalArgumentException("Invalid position.");

		if (board.getBoardPosition(row, column) != EMPTY)
			throw new IllegalArgumentException("Position occupied.");

		board.setBoardPosition(row, column, QUEEN);
		board.incrementQCount();
	}

	/**
	 * Given a row i and column j index in a 'board', mark all the squares in row,
	 * column and all possible four diagonal direction 'BLOCKED'.
	 * 
	 * @param row
	 * @param column
	 * @param board
	 */
	private static void blockPosition(int row, int column, Board board) {

		if (row < 0 || row > board.getRows() && (column < 0 || column > board.getCols()))
			throw new IllegalArgumentException("Invalid position.");

		// Mark all position in row as BLOCKED.
		for (int count = 0; count < board.getCols(); count++) {
			if (board.getBoardPosition(row, count) != QUEEN) {
				board.setBoardPosition(row, count, BLOCKED);
			}
		}

		// Mark all position in COLUMN as not BLOCKED.
		for (int count = 0; count < board.getCols(); count++) {
			if (board.getBoardPosition(count, column) != QUEEN) {
				board.setBoardPosition(count, column, BLOCKED);
			}
		}

		// Mark squares blocked in 'Top Left Corner' diagonal direction.
		int i = row;
		int j = column;

		while (i >= 0 && j >= 0) {
			if (board.getBoardPosition(i, j) == EMPTY) {
				board.setBoardPosition(i, j, BLOCKED);
			}
			i--;
			j--;
		}

		// Reset and then mark squares blocked in 'Top Right Corner' diagonal direction.
		i = row;
		j = column;

		while (i >= 0 && j < board.getCols()) {

			if (board.getBoardPosition(i, j) == EMPTY) {
				board.setBoardPosition(i, j, BLOCKED);
			}
			i--;
			j++;
		}

		// Reset and then mark squares blocked in 'Bottom Left Corner' diagonal
		// direction.
		i = row;
		j = column;

		while (i < board.getRows() && j >= 0) {
			if (board.getBoardPosition(i, j) == EMPTY) {
				board.setBoardPosition(i, j, BLOCKED);
			}
			i++;
			j--;
		}

		// Reset and then mark squares blocked in 'Bottom Right Corner' diagonal
		// direction.
		i = row;
		j = column;

		while (i < board.getRows() && j < board.getCols()) {
			if (board.getBoardPosition(i, j) == EMPTY) {
				board.setBoardPosition(i, j, BLOCKED);
			}
			i++;
			j++;
		}

	}
	
	/**
	 * Create a new board.
	 * 
	 * @param board
	 * @return
	 */
	private static Board copyBoard(Board board) {
		Board nBoard = new Board(board.getRows(), board.getCols());

		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getRows(); j++) {
				nBoard.setBoardPosition(i, j, board.getBoardPosition(i, j));
			}
		}
		nBoard.setQueenCount(board.getQueenCount());

		return nBoard;
	}


}
