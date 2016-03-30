package leetcode.recursions;

import java.security.DigestException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * For leetcode problem 17: Letter Combinations of a Phone Number
 */
public class LetterOfPhoneNumber {
    private String[] dict = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return results;
        }
        char[] digitsArray = digits.toCharArray();
        // char[] ret = new char[digits.length()];
        this.iLetterCombinations(digitsArray, results);
        return results;
    }

    public void rLetterCombinations(char[] digitsArray, int curPos, char[] ret, List<String> results) {
        if (curPos == digitsArray.length) {
            results.add(new String(ret));
            return;
        }

        int curDigit = digitsArray[curPos] - '0';
        for (int i = 0; i < dict[curDigit].length(); ++i) {
            char c = dict[curDigit].charAt(i);
            ret[curPos] = c;
            this.rLetterCombinations(digitsArray, curPos + 1, ret, results);
        }
    }

    public void iLetterCombinations(char[] digitsArray, List<String> results) {
        // Initialize ret;
        char[] ret = new char[digitsArray.length];
        for (int i = digitsArray.length - 1; i >= 0; --i) {
            int curDigit = digitsArray[i] - '0';
            ret[i] = dict[curDigit].charAt(0);
        }

        int i = digitsArray.length - 1;
        while(i >= 0) {
            int curDigit = digitsArray[i] - '0';
            ret[i] = dict[curDigit].charAt(j);
            results.add(new String(ret));

            ++j;
            if (j == dict[curDigit].length()) {
                --i;
                j = 0;
            }
        }
    }
}
