package org.paumard.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamPrac2<nameCount, word2> {

    public static  void main(String args[]) {

        List<Integer> l = new ArrayList<>();
        for(int i=0;i<10;i++) {
            l.add(i);
        }

        List<String> l2 = Arrays.asList("one", "two", "three", "four", "five");

        //count no of strings with length > 3
        long count = l2.stream().filter(s -> s .length() > 3).count();

        System.out.println("count = " + count);

        //count string starts with t

        long count2 = l2.stream().filter(s -> s.startsWith("t")).count();

        System.out.println("count2 = " + count2);

        //Sort the stream and convert into upper case and collect into other stream

        List<String > newL = l2.stream().sorted().map(s -> s.toUpperCase()).collect(Collectors.toList());

        System.out.println("newL = " + newL);

        //remove duplicates from list
        List<Integer> l3 = Arrays.asList(1,2,3,4,5,6,7,8,9,10,1,2,3);

        l3.stream().distinct().forEach(System.out::println);

        //skip first 5 elements
        l3.stream().skip(5).forEach(System.out::println);

        //print first 5 elements

        l3.stream().limit(5).forEach(System.out::println);


        List<Integer> l4 = Arrays.asList(10,11, 21,13, 45, 56, 11, 10);

        //Print elements starting with 1

        l4.stream().map(i -> i.toString()).filter(s -> s.startsWith("1")).forEach(System.out::println);
        //or
        l4.stream().filter(i -> i.toString().startsWith("1")).forEach(System.out::println);

        //Print duplicate elements

        l4.stream().filter(i -> l4.stream().filter(j -> j == i).count() > 1).forEach(System.out::println);
        Set<Integer> s = new HashSet<>();
        l4.stream().filter(i -> !s.add(i)).forEach(System.out::println);

        //Get max and min value

        System.out.println(l4.stream().max(Integer::compare).get());
        System.out.println(l4.stream().min(Integer::compare).get());

        //Find sum of all elements
        System.out.println(l4.stream().reduce(0, (a,b) -> a+b));


        String input = "Java articles are Awesome";

        //Find first non repeating character

        Character result = input.chars()
                .mapToObj(i -> Character.toLowerCase(Character.valueOf((char) i)))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() == 1L)
                .map(Map.Entry::getKey)
                .findFirst().get();

        System.out.println(input.chars()
                .mapToObj( i -> (char) i)
        .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1L)
                .map(e -> e.getKey())
                .findFirst().get());

    }

    List<String> names = Arrays.asList("AA", "BB", "AA", "CC");

    // Count each name occurrence in a list

    Map<String , Long> namesCount = names.stream().collect(Collectors.groupingBy(c -> c, Collectors.counting()));

    // Count each name occurrence in a list using map




}
