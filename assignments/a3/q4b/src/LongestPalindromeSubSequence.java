public class LongestPalindromeSubSequence {
    public static String findLongestPalindromeSubSequence(String text) {
        int len = text.length();
        int memory[][] = new int[len][len];
        int palindrome[][] = new int[len][len];
        String result = "";

        // Base case
        for (int i = 0; i < text.length(); i++) {
            memory[i][i] = 1;
            palindrome[i][i] = 0;
        }

        // Table
        for (int i = 2; i <= len; i++) {
            for (int j = 0; j < (len - i + 1); j++) {
                int k = j + i - 1;
                if (i == 2 && text.charAt(j) == text.charAt(k)) {
                    memory[j][k] = 2;
                    palindrome[j][k] = 0;
                } else if (text.charAt(j) == text.charAt(k)) {
                    memory[j][k] = memory[j + 1][k - 1] + 2;
                    palindrome[j][k] = 0;
                } else {
                    if (memory[j][k - 1] > memory[j + 1][k]) {
                        memory[j][k] = memory[j][k - 1];
                        palindrome[j][k] = 1;
                    } else {
                        memory[j][k] = memory[j + 1][k];
                        palindrome[j][k] = 2;
                    }
                }
            }
        }

        // Build our string
        int i = 0, j = len - 1;
        while (i <= j) {
            if (palindrome[i][j] == 0) {
                result += text.charAt(i);
                i += 1;
                j -= 1;
            } else if (palindrome[i][j] == 1) {
                j -= 1;
            } else if (palindrome[i][j] == 1) {
                i += 1;
            }
        }

        return result;
    }

    private static void test() {
        assert(findLongestPalindromeSubSequence("character").equals("carac"));
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            String longest = findLongestPalindromeSubSequence(args[0]);
            System.out.println(longest.length());
            System.out.println(longest);
        } else {
            System.out.println("Testing. (Only failures will appear)");
            test();
            System.out.println("Usage: java LongestPalindromeSubSequence <text>");
        }

    }
}
