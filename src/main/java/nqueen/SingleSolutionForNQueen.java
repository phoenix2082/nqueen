package nqueen;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * For a N x N Chess Board, generate list of position so that N queens can be
 * placed without any queen threatening other.
 * 
 * @author jr
 */
public class SingleSolutionForNQueen {

	/**
	 * Given N x N board this method returns exactly one solution to 
	 * arrange N queens, so that now two queen blocks each other path.
	 * 
	 * @param boardSize
	 * @return
	 */
	public static List<Integer> findOne(int boardSize) {

		List<Integer> positions = IntStream.rangeClosed(1, boardSize).boxed().collect(Collectors.toList());
		List<Integer> evenList = positions.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
		List<Integer> oddList = positions.stream().filter(i -> i % 2 != 0).collect(Collectors.toList());
		List<Integer> answers = new ArrayList<Integer>(positions.size());
		
		// See Paper: Explicit Solutions to the N-Queens Problem for all N.
		if (boardSize % 6 == 2) {
			
			int temp = oddList.get(0);
			oddList.set(0, oddList.get(1));
			oddList.set(1, temp);

			temp = oddList.remove(2);
			oddList.add(temp);

		} else if (boardSize % 6 == 3) {

			int elem = evenList.remove(0);
			evenList.add(elem);

			elem = oddList.remove(0);
			oddList.add(elem);

			elem = oddList.remove(0);
			oddList.add(elem);

		} else {
			// handle boardSize % 6 != 3 && boardSize % 6 != 2 case.
			// The solution to just add append odd list to even list.
		} 

		answers.addAll(evenList);
		answers.addAll(oddList);
		
		return answers;

	}

	/**
	 * Print the board based on list of Queen's positions.
	 * 
	 * @param boardSize
	 * @param answers
	 */
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

}
