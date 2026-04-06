//The approach is to use a sliding window of size equal to the length of s1 and compare the frequency of characters
//in the current window with the frequency of characters in s1. If they match, it means we have found a permutation 
//of s1 in s2.
class PermuationInString {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length())
            return false;
        int[] s1Count = new int[26];
        int[] window = new int[26];
        for (char c : s1.toCharArray()) {
            s1Count[c - 'a']++;
        }
        int k = s1.length();
        for (int i = 0; i < s2.length(); i++) {
            window[s2.charAt(i) - 'a']++;

            if (i >= k) {
                window[s2.charAt(i - k) - 'a']--;
            }
            if (matches(s1Count, window))
                return true;

        }
        return false;
    }

    public boolean matches(int[] a, int[] b) {

        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i])
                return false;
        }
        return true;

    }
}