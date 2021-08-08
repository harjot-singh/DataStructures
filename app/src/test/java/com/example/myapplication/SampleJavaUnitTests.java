package com.example.myapplication;

import android.telephony.mbms.StreamingServiceInfo;

import androidx.annotation.NonNull;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class SampleJavaUnitTests {

    @Test
    public void test() {

        Assert.assertEquals(3,lengthOfLongestSubstring("pwwkew"));
        Assert.assertEquals(3,lengthOfLongestSubstring("abcabcbb"));
        Assert.assertEquals(1,lengthOfLongestSubstring("bbbbb"));
        Assert.assertEquals(0,lengthOfLongestSubstring(""));
        int value = lengthOfLongestSubstring(" ");
        Assert.assertEquals(1,value);
    }

    @Test
    public void testDuplicates() {
        Integer array[] = {1,6,9,4,6,5,7, 8, 3, 56, 5, 9};
        //printDuplicates(array);
        printDuplicatesSet(array);

    }

    private void printDuplicates(int[] array) {
        for(int i = 0; i< array.length-1; i++) {
            int a = array[i];
            for(int j= i+1; j < array.length; j++) {
                if(array[j] == a)
                    System.out.print(a);
            }
        }
    }

    private void printDuplicatesSet(Integer[] array) {
        List<String> arrayString = new ArrayList<>();
        List<Integer> arrayStrinweg = new ArrayList<>();
        List<Integer> arrayList = Arrays.asList(array);
        Map<Integer, String> map1  = new LinkedHashMap<>();
        System.out.print("Thanks for writing");

        System.out.println(arrayList);
    }

    public int lengthOfLongestSubstring(String s) {
        String longestSubString = "";

        for (int i = 0; i < s.length() - 1; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(s.charAt(i));
            for (int j = i + 1; j < s.length(); j++) {
                if (!stringBuilder.toString().contains(String.valueOf(s.charAt(j)))) {
                    stringBuilder.append(s.charAt(j));
                } else {
                    break;
                }
            }
            if (stringBuilder.toString().length() > longestSubString.length()) {
                longestSubString = stringBuilder.toString();
            }
        }
        return longestSubString.length();
    }

//    public String longestPalindrome(String s) {
//        char array[] = s.toCharArray();
//        for(int i = 0; i < s.length() - 1; i++) {
//            StringBuilder stringBuilder = new StringBuilder();
//            stringBuilder.append(s.charAt(i));
//            for (int j = i + 1; j < s.length(); j++) {
//                if (!stringBuilder.toString().contains(String.valueOf(s.charAt(j)))) {
//                    stringBuilder.append(s.charAt(j));
//                } else {
//
//                }
//            }
//        }
//    }

    //Given a list of non-negative numbers and a target integer k, write a function to check if the array has a continuous subarray of size
    // at least 2 that sums up to a multiple of k, that is, sums up to n*k where n is also an integer.
    public boolean checkSubarraySum(int[] nums, int k) {
        k = Math.abs(k);
        for (int i = 0; i < nums.length; i++) {
            int check = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                check += nums[j];
                if (check == 0 && k ==0) return true;
                if (check != 0 && k== 0) break;
                if (check % k == 0) return true;
            }
        }
        return false;
    }
    @Test
    public void testReverseString() {
        String string = reverseWords("a good   example");
        System.out.println(string.contains("good"));
        Assert.assertEquals("", string);
    }

    public String reverseWords(String s) {
        String arrays[] = s.trim().split("\\s");
        //String arrays[] = s.trim().split(" ");

        System.out.println(Arrays.toString(arrays));
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = arrays.length-1; i>=0; i--) {
            if (!arrays[i].isEmpty()) {
                stringBuilder.append(arrays[i]);
                stringBuilder.append(" ");
            }
        }
        /*Arrays.sort(arrays);
        Arrays.asList(arrays);
        Arrays.toString(arrays);*/
        return stringBuilder.toString().trim();
    }

    @Test
    public void testRepeatedStrings() {
        //char c = nonRepeated("hheello");
        char c = nonRepeatedCharacter("hheello");
        Assert.assertEquals("",c);
    }

    public char nonRepeatedCharacter(String string) {
        char [] chars = string.toCharArray();
        //getDistinctChars:: remove the duplicates
        //get the count of each character in the above distinct array
        //

        for(char ch: getDistincttArray(chars)) {
            int count =checkOccrences(chars, ch);
            if (count == 1) return ch;
        }
        throw new RuntimeException("didn't find any non repeated Character");
    }

    public char[] getDistincttArray(char [] source) {
        char[] newArray = new char[source.length];
        int i =0;
        for (char ch: source) {
            if(!checkIfArrayHasCharacter(newArray, ch)) {
                newArray[i] = ch;
                i++;
            }
        }
        System.out.println(newArray);
        return newArray;
    }

    private int checkOccrences(char[] source, char ch) {
        int i =0;
        for (char c: source) {
            if (c == ch) i =i+1;
        }
        return i;
    }

    private boolean checkIfArrayHasCharacter(char array[], char ch) {
        for (char c: array) {
            if(c == ch) {
                return true;
            }
        }
        return false;
    }



    public char nonRepeated(String s) {
        // Hello ..h..
        /*Map<Character, Integer> counts = new LinkedHashMap<>(str.length());
        for (char c : str.toCharArray()) {
            counts.put(c, counts.containsKey(c) ? counts.get(c) + 1 : 1);
        }
        for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        throw new RuntimeException("didn't find any non repeated Character");*/

        Map<Character, Integer> characterIntegerMap = new LinkedHashMap(s.length());
        for(char ch: s.toCharArray()) {
            characterIntegerMap.put( ch, characterIntegerMap.containsKey(ch) ? characterIntegerMap.get(ch) + 1: 1);
        }

        for(Character ch: characterIntegerMap.keySet()) {
            if(characterIntegerMap.get(ch) == 1) {
                return ch;
            }
        }
        throw new RuntimeException("didn't find any non repeated Character");
    }

    @Test
    public void testCombinations() {
        printAllCombinations("abc");
    }

    public void printAllCombinations( String s)  {
        //"abc"
        char arrays[] = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0; i< arrays.length; i++) {
            stringBuilder.append(arrays[i]);
            for(int j= 0; j !=i; j ++) {
                char temp = arrays[i];
                arrays[i] = arrays[j];
                arrays[j] = temp;
            }
            System.out.println(stringBuilder.toString());
        }
    }

    static int migratoryBirds(List<Integer> arr) {
        Map<Integer, Integer> keyValue = new LinkedHashMap<>();
        for (int element: arr) {
            if(keyValue.containsKey(element)) {
                keyValue.put(element, keyValue.get(element) + 1);
            } else
                keyValue.put(element, 1);
        }
        int max = 0;
        int minKey = 0;
        for (int key: keyValue.keySet()) {
            int value = keyValue.get(key);
            if (value > max) {
                minKey = key;
                max = value;
            } else if(value == max) {
                minKey = minKey > key ? key: minKey;
            }
        }
        return minKey;
    }

    /*
    A string containing only parentheses is balanced if the following is true: 1. if it is an empty string 2. if A and B are correct, AB is correct, 3. if A is correct, (A) and {A} and [A] are also correct.

Examples of some correctly balanced strings are: "{}()", "[{()}]", "({()})"

Examples of some unbalanced strings are: "{}(", "({)}", "[[", "}{" etc.

Given a string, determine if it is balanced or not.
     */
    @Test
    public void verifyBalanceedStructure() {


         String string = "[{()}]";
        Stack<Character> stack = new Stack();
        boolean flag = true;
        for (int i=0; i< string.length(); i ++) {
            char ch = string.charAt(i);
            if(ch =='{' || ch == '[' || ch == '(') {
                stack.push(ch);
            } else {
                if(stack.isEmpty()) {
                    flag = false;
                    break;
                } else {
                    char c =  stack.pop();
                    if((c == '(' && ch != ')') || (c == '{' && ch != '}') || (c == '[' && ch != ']')) {
                        flag = false;
                        break;
                    }
                }

            }
        }

        if(flag && stack.isEmpty())
            System.out.print("true");
        else
            System.out.print("false");
    }

    @Test
    public void samoe() {
        String s = "5;3:1,2,3";
        String array1[] = s.split(";");
        System.out.println(array1[0]);
        System.out.println(array1[1]);

        String string2[] = array1[1].split(":")[1].split(",");
       String t = "".join("@", "Thamls", "too");
       System.out.println(t);
        System.out.println(string2[0]);
        System.out.println(string2[1]);
        System.out.println(string2[2]);

        double d =Double.valueOf("3.5");
        System.out.println(d);
        System.out.print(((double)3/5)*100);
    }

    @Test
    public void printFactorial() {
        int n = 5;
        int fact = 1;
        for(int i =1; i <= n; i ++) {
            fact = fact*i;
        }
        System.out.println(fact);
    }

    @Test
    public void playWithStrings() {
        char arrayTest[] = {'s','d','r','s'};
        String test = "Hello";
        test.substring(0,5);
        char []tr = test.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = tr.length-1; i >= 0; i --) {
            stringBuilder.append(tr[i]);
        }
        System.out.println(stringBuilder.toString().trim());

        //Remove duplicates

        char newChar[] = new char[arrayTest.length];
        int i =0;
        for (char ch: arrayTest) {
            if(!checkIfArrayHasCharacters(newChar, ch)) {
                newChar[i] = ch;
                i++;
            }
        }
        StringBuilder stringBuiilder = new StringBuilder();
        for(char ch: newChar) {
            stringBuiilder.append(ch);
        }

        System.out.println(stringBuiilder.toString().trim());

        String st = "Hello how are you";
        System.out.println(st.replace(' ', ':'));
        System.out.println(st.replace(" ", ""));
        System.out.println(st.replaceAll("\\s", ""));
    }

    private boolean checkIfArrayHasCharacters(char []arr, char ch) {
        for (char c: arr) {
            if(c== ch) return true;
        }
        return false;
    }

    @Test
    public void printCombinatoions() {
        getPermutuations("abc","");
    }


    private void getPermutuations(String input, String ans) {

        if (input.length() == 0) {
            System.out.print(ans + " ");
        } else {
            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);

                String ros = input.substring(0, i) + input.substring(i + 1);

                getPermutuations(ros, ans + ch);
            }
        }

    }


}
