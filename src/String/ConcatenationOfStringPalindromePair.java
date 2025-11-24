package String;
    //Given a list of unique words, return all the pairs of the distinct indices (i, j) in the given list,
    // so that the concatenation of the two words words[i] + words[j] is a palindrome.
//        Example 1:
//Input: words = ["abcd","dcba","lls","s","sssll"]
//Output: [[0,1],[1,0],[3,2],[2,4]]
//
//
//Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
//Example 2:
//Input: words = ["bat","tab","cat"]
//Output: [[0,1],[1,0]]
//
//
//Explanation: The palindromes are ["battab","tabbat"]
//Example 3:
//Input: words = ["a",""]
//Output: [[0,1],[1,0]]


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConcatenationOfStringPalindromePair {

    public static boolean isPalindrome(String str) {

        return IntStream.range(0, str.length())
                .mapToObj(i -> str.charAt(str.length() - i - 1))
                .map(String::valueOf)
                .collect(Collectors.joining())
                .equals(str);
    }

    public static void main(String[] args) {
        String[] word = {"abcd","dcba","lls","s","sssll"};

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < word.length; i++) {
                for (int j = i+1; j < word.length; j++) {
                    if (isPalindrome(word[i] + word[j])) {
    //                    System.out.println("[ " + i + " " + j + " ]");
                        result.add(Arrays.asList(i, j));
                    }
                    if (isPalindrome(word[j] + word[i])) {
    //                    System.out.println("[ " + j + " " + i + " ]");

                        result.add(Arrays.asList(j,i));
                    }
            }
        }
        System.out.println(result);
    }
}
