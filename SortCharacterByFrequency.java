// https://leetcode.com/problems/sort-characters-by-frequency/

class SortCharacterByFrequency {

    public String frequencySort(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int[] charCount = new int[128];
        for (char c : s.toCharArray()) {
            charCount[c]++;
        }
        int maxFrequency = 0;
        for (int count : charCount) {
            maxFrequency = Math.max(maxFrequency, count);
        }
        StringBuilder[] buckets = new StringBuilder[maxFrequency + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new StringBuilder();
        }
        for (int i = 0; i < charCount.length; i++) {
            if (charCount[i] > 0) {
                char c = (char) i;
                int count = charCount[i];
                while (count > 0) {
                    buckets[charCount[i]].append(c);
                    count--;
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = buckets.length - 1; i >= 0; i--) {
            result.append(buckets[i]);
        }
        return result.toString();

    }
}
