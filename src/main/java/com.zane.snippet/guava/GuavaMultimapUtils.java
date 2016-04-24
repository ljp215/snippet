package com.zane.snippet.guava;

import java.util.*;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multimap;

/**
 * Author: luojinping
 * Date: 16/4/24
 * Time: 16:09
 */
public class GuavaMultimapUtils {
    public void useSampleMultimap() {
        // old codes
        Map<String, List<Integer>> map = new HashMap<>();
        String key = "k1";
        int addValue1 = 1, addValue2 = 2;
        addValue(map, key, addValue1);
        addValue(map, key, addValue2);
        System.out.println("map k1 value: " + map.get(key));

        // guava codes
        Multimap<String, Integer> multimap = ArrayListMultimap.create();
        multimap.put(key, addValue1);
        multimap.put(key, addValue2);
        System.out.println("multimap k1 value: " + map.get(key));
    }

    private void addValue(Map<String, List<Integer>> map, String key, int value) {
        List<Integer> valueList = map.get(key);
        if (valueList == null) {
            valueList = new ArrayList<>();
            map.put(key, valueList);
        }
        valueList.add(value);
    }

    public void useMultimap(){
        Multimap<String, String> myMultimap = ArrayListMultimap.create();

        // Adding some key/value
        myMultimap.put("Fruits", "Bannana");
        myMultimap.put("Fruits", "Apple");
        myMultimap.put("Fruits", "Pear");
        myMultimap.put("Fruits", "Pear");
        myMultimap.put("Vegetables", "Carrot");

        // Getting the size
        int size = myMultimap.size();
        System.out.println(size); // 5

        // Getting values
        Collection<String> fruits = myMultimap.get("Fruits");
        System.out.println(fruits); //  [Bannana, Apple, Pear, Pear]
        System.out.println(ImmutableSet.copyOf(fruits));// [Bannana, Apple, Pear]

        Collection<String> vegetables = myMultimap.get("Vegetables");
        System.out.println(vegetables); // [Carrot]

        // Iterating over entire Mutlimap
        for (String value : myMultimap.values()) {
            System.out.println(value);
        }

        // Removing a single value
        myMultimap.remove("Fruits", "Pear");
        System.out.println(myMultimap.get("Fruits")); // [Bannana, Apple, Pear]

        // Remove all values for a key
        myMultimap.removeAll("Fruits");
        System.out.println(myMultimap.get("Fruits")); // [] (Empty Collection!)

    }

    public static void main(String[] args) {
        GuavaMultimapUtils guavaMultimapUtils = new GuavaMultimapUtils();

        guavaMultimapUtils.useSampleMultimap();
        guavaMultimapUtils.useMultimap();
    }
}
