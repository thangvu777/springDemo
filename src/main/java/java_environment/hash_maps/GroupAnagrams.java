package java_environment.hash_maps;

import java.util.*;

// Time: O( N x K log K ): Where N is the size of the list of strings, and K is the sorting you will have to do per string
// Space: O( N x K ): Total number of characters, where N is the size of the list of strings, and K is the maximum length of a string
public class GroupAnagrams {

    private static List<String> list = List.of("ex", "bcale", "xe", "caleb", "re");
    private static List<String> list2 = List.of("fjja", "jaaf", "kak", "oesj", "applepen");
    private static List<String> list3 = List.of("alskd", "kdals", "erjs", "rejs", "helloami", "iamhello", "lol", "wowmom", "momwow");

    private static List<List<String>> groupAnagrams(List<String> strs){
        if( strs == null || strs.isEmpty()){
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();

        for(String str: strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = String.valueOf(charArray);
            // first time seeing the unique anagram
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            // retrieve the list, then append the anagram item to list
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

    static void main() {
        IO.println("Output 1: " + groupAnagrams(list));
        IO.println("Output 2: " + groupAnagrams(list2));
        IO.println("Output 3: " + groupAnagrams(list3));
    }
}
