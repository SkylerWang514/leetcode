package Calculation;

import io.swagger.models.auth.In;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @program: leetcode
 * @description: 383
 * @author: Skyler
 * @create: 2024-02-05 22:33
 **/

public class ransomNote {
    public static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> charactersMagazine = new HashMap<>();
        charactersMagazine = constructHashMap(magazine);
        HashMap<Character, Integer> charactersRansomNote = new HashMap<>();
        charactersRansomNote = constructHashMap(ransomNote);
        System.out.println(charactersMagazine);
        System.out.println(charactersRansomNote);
        for (Map.Entry<Character, Integer> entry : charactersRansomNote.entrySet()) {
            System.out.println("key="+entry.getKey()+"  value="+entry.getValue());
            if (charactersMagazine.containsKey(entry.getKey())){
                if (charactersMagazine.get(entry.getKey()) < entry.getValue())
                    return false;
            }else return false;
        }
        return true;

    }

    public static HashMap<Character, Integer> constructHashMap(String s){
        HashMap<Character, Integer> characters = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            characters.putIfAbsent(s.charAt(i), 0);
            characters.computeIfPresent(s.charAt(i), ((character, integer) -> integer = integer + 1));
        }
        return characters;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("a", "b"));
    }
}
