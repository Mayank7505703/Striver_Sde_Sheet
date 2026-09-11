class Solution {
    public int totalNumbers(int[] arr) {
        Set<Integer> set = new HashSet<>();
		int n = arr.length;
		for (int i = 0; i < n; i++) { // For hundreds
			if (arr[i] == 0)
				continue;
			for (int j = 0; j < arr.length; j++) {// For tens
				if (i == j) {
					continue;
				}
				for (int k = 0; k < arr.length; k++) { // For unit digit
					if (i == k || j == k)
						continue; 
					if (arr[k] % 2 != 0)
						continue; // Last digit must be even

					int num = arr[i] * 100 + arr[j] * 10 + arr[k];
					set.add(num);
				}
			}

		}
		return set.size();
    }
}