package labs.lab8;

import java.util.ArrayList;
import java.util.List;

/**
 * This class generates permutations of a string.
 */
public class PermutationGenerator<E> {

	private List<E> items;

	/**
	 * Constructs a permutation generator.
	 * 
	 * @param str the string to permute, must have length > 0
	 */
	public PermutationGenerator(List<E> items) {
		this.items = new ArrayList<>(items);
	}


	/**
	 * Gets all permutations of the string.
	 */
	public List<List<E>> getPermutations() {
		List<List<E>> result = new ArrayList<>();
		// The empty string has a single permutation: itself
		if (items.isEmpty()) {
			result.add(new ArrayList<>());
			return result;
		}

		// Loop through all character positions:
		for (int i = 0; i < items.size(); i++) {
			
			// Form a shorter word by removing the ith character
			List<E> shorter = new ArrayList<>(items);
			E removed = shorter.remove(i);

			// Generate all permutations of the simpler word
            PermutationGenerator<E> shorterPermutationGenerator = new PermutationGenerator<>(shorter);
            List<List<E>> shorterWordPermutations = shorterPermutationGenerator.getPermutations();
			// E shorter = word.get(0, i) + word.substring(i + 1);

            
			// Add the removed character to the front of
			// each permutation of the simpler word:
			for (List<E> s : shorterWordPermutations) {
				List<E> newPermutation = new ArrayList<>();
                newPermutation.add(removed);
                newPermutation.addAll(s);
                result.add(newPermutation);
			}
		}
		// Return all permutations:
		return result;
	}


	public static void main(String[] args) {
		
	}

}
