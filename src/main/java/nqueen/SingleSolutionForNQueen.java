package nqueen;

import java.util.ArrayList;
import java.util.List;

/**
 * For a N x N Chess Board, generate list of position so that N queens can be
 * placed without any queen threatening other.
 * 
 * @author jr
 */
public class SingleSolutionForNQueen {

	public static List<Integer> findOne(int boardSize) {

		List<Integer> positions = generatePositions(boardSize);
		List<Integer> evenList = new ArrayList<Integer>();
		List<Integer> oddList = new ArrayList<Integer>();
		List<Integer> answers = new ArrayList<Integer>(positions.size());

		if (boardSize % 6 != 2 && boardSize % 6 != 3) {

			// If the remainder from dividing board size by 6 is not 2 or 3,
			// then the list is simply all even numbers followed by all odd numbers not
			// greater than n.
			for (int i : positions) {
				if (i % 2 == 0) {
					evenList.add(i);
				} else {
					oddList.add(i);
				}
			}

			answers.addAll(evenList);
			answers.addAll(oddList);

		} else if (boardSize % 6 == 2) {

			for (int i : positions) {
				if (i % 2 == 0) {
					evenList.add(i);
				} else {
					oddList.add(i);
				}
			}

			int temp = oddList.get(0);
			oddList.set(0, oddList.get(1));
			oddList.set(1, temp);

			temp = oddList.remove(2);
			oddList.add(temp);

			answers.addAll(evenList);
			answers.addAll(oddList);

		} else if (boardSize % 6 == 3) {

			for (int i : positions) {
				if (i % 2 == 0) {
					evenList.add(i);
				} else {
					oddList.add(i);
				}
			}

			int elem = evenList.remove(0);
			evenList.add(elem);

			elem = oddList.remove(0);
			oddList.add(elem);

			elem = oddList.remove(0);
			oddList.add(elem);

			answers.addAll(evenList);
			answers.addAll(oddList);
		}

		return answers;

	}

	public static void printBoard(int boardSize, List<Integer> answers) {
		for (int i = 0; i < boardSize; i++) {

			System.out.println();

			for (int j = 0; j < boardSize; j++) {

				if (answers.get(j) - (boardSize - i) == 0) {
					System.out.print(" | " + "Q");
				} else {
					System.out.print(" | " + ".");
				}

			}
			System.out.print(" | ");
		}
	}

	private static List<Integer> generatePositions(int boardSize) {
		List<Integer> positions = new ArrayList<Integer>();

		for (int i = 1; i <= boardSize; i++) {

			if (i % 2 == 0) {
				positions.add(i);
			} else {
				positions.add(i);
			}
		}

		return positions;

	}

}
