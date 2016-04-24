package com.zane.snippet.convert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Author: luojinping
 * Date: 16/4/24
 * Time: 11:33
 */
public class ListConvertUtils {
    public void convertListToArray() {
        List<String> list = new ArrayList<>();
        list.add("l1");
        list.add("l2");
        list.add("l3");

        /**
         * Turns out that providing a zero-length array, even creating it and throwing it away, is
         * on average faster than allocating an array of the right size.
         * For benchmarks and explanation see here:
         * http://shipilev.net/blog/2016/arrays-wisdom-ancients
         */
        String[] strings = list.toArray(new String[0]);

        System.out.println("list to array: " + Arrays.toString(strings));
    }

    public static void main(String[] args) {
        ListConvertUtils listConvertUtils = new ListConvertUtils();

        listConvertUtils.convertListToArray();
    }
}
