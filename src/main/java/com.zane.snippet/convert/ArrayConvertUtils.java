package com.zane.snippet.convert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: luojinping
 * Date: 16/4/24
 * Time: 15:02
 */
public class ArrayConvertUtils {
    public void convertArrayToFixedSizeList() {
        String[] array = new String[]{"a1", "a2", "a3"};
        List<String> list = Arrays.asList(array);
        System.out.println("array to fixed size list: " + list);
    }

    public void convertPrimitiveArrayToList() {
        int[] intArray = new int[]{1, 2, 3};
        List<Integer> intList = new ArrayList<Integer>() {{
            for (int i : intArray) add(i);
        }};
        System.out.println("primitive int array to list by foreach: " + intList);

        // Supported by Java 8
        List<Integer> intlist2 = Arrays.stream(intArray).boxed().collect(Collectors.toList());
        System.out.println("primitive int array to list by java8: " + intlist2);
    }

    public void convertArrayToModifySupportedList() {
        /** As mentioned in pitfalls above, the result of Arrays.asList() does not support adding or
         removing items. If you don't want this behavior, here is an alternative solution:
         */
        String[] array = {"l1", "l2", "l3"};
        List<String> modifyList = new ArrayList<>(Arrays.asList(array));
        modifyList.add("l4");

        System.out.println("array to modify supported list : " + modifyList);
    }

    public void convertArrayToListUsingOwnImplementation() {
        String[] myArray = {"1", "2", "3"};
        List<Integer> myList = new ArrayList<>();
        for (String str : myArray) {
            myList.add(Integer.valueOf(str));
        }
    }

    public static void main(String[] args) {
        ArrayConvertUtils arrayConvertUtils = new ArrayConvertUtils();

        arrayConvertUtils.convertArrayToFixedSizeList();

        arrayConvertUtils.convertPrimitiveArrayToList();

        arrayConvertUtils.convertArrayToModifySupportedList();

        arrayConvertUtils.convertArrayToListUsingOwnImplementation();
    }
}
