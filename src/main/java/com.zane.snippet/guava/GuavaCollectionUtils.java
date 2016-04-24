package com.zane.snippet.guava;

import org.junit.Assert;

import com.google.common.base.Joiner;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.primitives.Ints;

/**
 * Author: luojinping
 * Date: 16/4/24
 * Time: 15:04
 */
public class GuavaCollectionUtils {
    public void createImmutableCollection() {
        ImmutableList<String> of = ImmutableList.of("a", "b", "c", "d");

        ImmutableMap<String, String> map = ImmutableMap.of("key1", "value1", "key2", "value2");
    }

    public void joinArray() {
        int[] numbers = {1, 2, 3, 4, 5};
        String numbersAsString = Joiner.on(";").join(Ints.asList(numbers));
        String numbersAsStringDirectly = Ints.join(";", numbers);

        System.out.println(numbersAsString);
        System.out.println(numbersAsStringDirectly);
    }

    public void useGuavaInts() {
        int[] array = {1, 2, 3, 4, 5};
        int[] array2 = {5, 6, 7};

        int a = 4;
        boolean isContains = Ints.contains(array, a);
        System.out.println("array contains 4: " + isContains);

        int indexOf = Ints.indexOf(array, a);
        System.out.println("index of 4: " + indexOf);

        int max = Ints.max(array);
        System.out.println("max of array: " + max);

        int min = Ints.min(array);
        System.out.println("min of array: " + min);

        int[] concat = Ints.concat(array, array2);
        System.out.println("concat array to array2: " + concat);
    }

    public void useStrings() {
        Assert.assertEquals("test", Strings.emptyToNull("test"));
        Assert.assertEquals(" ", Strings.emptyToNull(" "));
        Assert.assertNull(Strings.emptyToNull(""));
        Assert.assertNull(Strings.emptyToNull(null));

        Assert.assertFalse(Strings.isNullOrEmpty("test"));
        Assert.assertFalse(Strings.isNullOrEmpty(" "));
        Assert.assertTrue(Strings.isNullOrEmpty(""));
        Assert.assertTrue(Strings.isNullOrEmpty(null));

        Assert.assertEquals("test", Strings.nullToEmpty("test"));
        Assert.assertEquals(" ", Strings.nullToEmpty(" "));
        Assert.assertEquals("", Strings.nullToEmpty(""));
        Assert.assertEquals("", Strings.nullToEmpty(null));

        Assert.assertEquals("Ralph_____", Strings.padEnd("Ralph", 10, '_'));
        Assert.assertEquals("Bob_______", Strings.padEnd("Bob", 10, '_'));

        Assert.assertEquals("_____Ralph", Strings.padStart("Ralph", 10, '_'));
        Assert.assertEquals("_______Bob", Strings.padStart("Bob", 10, '_'));

        Assert.assertEquals("xyxyxyxyxy", Strings.repeat("xy", 5));
    }

    public static void main(String[] args) {
        GuavaCollectionUtils guavaCollectionUtils = new GuavaCollectionUtils();

        guavaCollectionUtils.joinArray();

        guavaCollectionUtils.useGuavaInts();

        guavaCollectionUtils.useStrings();
    }
}
