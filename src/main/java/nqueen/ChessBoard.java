package nqueen;

import java.util.List;

/**
 * N Queen Problem.
 * 
 * Given a N x N board, how to arrange N queens, so that their paths do not
 * crosses each other.
 * 
 * @author jr
 */
public class ChessBoard {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		if (args.length < 1) {
			System.out.println("Please enter size of board.");
			System.out.println("Usage: java -jar build/libs/nqueen.jar N y/n p");
			System.exit(0);
		}

		byte boardSize = Byte.parseByte(args[0]);

		byte rows = boardSize;
		byte cols = boardSize;

		if (args.length > 1) {

			String single = args[1];

			if ("y".equalsIgnoreCase(single)) {
				
				//Generate s single solution, print and exit.
				List<Integer> positions = SingleSolutionForNQueen.findOne(boardSize);
				
				System.out.println("First Solution: " + positions);
				
				if (args.length > 2) {
					String printBoard = args[2];
					
					if ("p".equalsIgnoreCase(printBoard)) {
						SingleSolutionForNQueen.printBoard(boardSize, positions);
					}
				}
				
			} else if("n".equalsIgnoreCase(single)) {

				// Find all possible boards
				for (int i = 0; i < rows; i++) {
					for (int j = 0; j < cols; j++) {
						Board board = new Board(rows, cols);
						BoardUtils.processPosition(i, j, board);
						BoardUtils.resetBoard(board);
					}
				}

				System.out.println("Total Board Found: " + BoardUtils.answers.size());

				if (args.length > 2) {
					String printBoard = args[2];

					if ("p".equalsIgnoreCase(printBoard)) {
						for (Board b : BoardUtils.answers) {
							b.print();
						}
					}
				}

			} else {
				System.out.println("Invalid input argument.");
			}
		}

	}

}
