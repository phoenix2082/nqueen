package nqueen;

import java.util.Arrays;

/**
 * 
 * Represent a snapshot of 'board' at a particular moment.
 * 
 * @author jr
 *
 */
public class Board {
	
	private byte rows = 0;
	private byte cols = 0;
	private byte[][] board;
	private int queenCount = 0;
	
	public byte getRows() {
		return rows;
	}

	public void setRows(byte rows) {
		this.rows = rows;
	}

	public byte getCols() {
		return cols;
	}

	public void setCols(byte cols) {
		this.cols = cols;
	}

	public Board(byte rows, byte cols) {
		
		if(rows < 1 || cols < 1) {
			throw new IllegalArgumentException("Invalid Parameters. rows and cols value must be greater than 1");
		}
		this.rows = rows;
		this.cols = cols;
		this.board = new byte[rows][cols];
	}
	
	/**
	 * Update board value at row i, column j.
	 * @param i
	 * @param j
	 * @param val
	 */
	public void setBoardPosition(int i, int j, byte val) {
		board[i][j] = val;
	}
	
	public byte getBoardPosition(int i, int j) {
		return board[i][j];
	}

	/**
	 * Increment Queen Count.
	 * Called only when square inside board is set to 1.
	 */
	public void incrementQCount() {
		queenCount++;
	}
	
	public int getQueenCount() {
		return queenCount;
	}
	
	public void setQueenCount(int qCount) {
		this.queenCount = qCount;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cols;
		result = prime * result + rows;
		result = prime * result + Arrays.deepHashCode(board);
		result = prime * result + queenCount;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Board other = (Board) obj;
		if (cols != other.cols)
			return false;
		if (rows != other.rows)
			return false;
		if (!Arrays.deepEquals(board, other.board))
			return false;
		if (queenCount != other.queenCount)
			return false;
		return true;
	}
	
	public void print() {
		for (int i = 0; i < rows; i++) {
			System.out.println();
			for (int j = 0; j < cols; j++) {
				int val = this.getBoardPosition(i, j);
				System.out.print(" | " + (val == -1 ? "." : "X"));
			}
			System.out.print(" | ");
		}
		System.out.println();
	}	

}
