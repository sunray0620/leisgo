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

    public void iLetterCombinations(char[] digitsCharArray, List<String> results) {
        int strLength = digitsCharArray.length;
        int[] digits = new int[strLength];
        for(int i = 0; i < strLength; ++i) {
            digits[i] = digitsCharArray[i] - '0';
        }
        char[] ret = new char[strLength];
        int[] idx = new int[strLength];

        int i = strLength - 1;
        while(i >= 0) {
            results.add(this.convertIdxToString(digits, idx, ret));

            i = strLength - 1;
            idx[i] += 1;
            while(i >= 0 && idx[i] == dict[digits[i]].length()) {
                idx[i] = 0;
                --i;
                if (i >= 0) {
                    idx[i] += 1;
                }
            }
        }
    }

    private String convertIdxToString(int[] digits, int[] idx, char[] ret) {
        for (int i = 0; i < ret.length; ++i) {
            ret[i] = dict[digits[i]].charAt(idx[i]);
        }
        return new String(ret);
    }
}
