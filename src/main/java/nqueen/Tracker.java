package nqueen;

/**
 * 
 * @author jr
 *
 */
public class Tracker {
	
	private int row;
	
	private int col;

	public Tracker(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	@Override
	public String toString() {
		return "Tracker [row=" + row + ", col=" + col + "]";
	}
	
}
