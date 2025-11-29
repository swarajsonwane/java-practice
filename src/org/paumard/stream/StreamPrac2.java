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


    /*
groupingBy → Groups stream elements into a Map<K, List<T>> or another collection/result.
Think of SQL:

SELECT city, COUNT(*) FROM users GROUP BY city;
Java equivalent:
Map<String, List<User>> map =
    users.stream()
         .collect(Collectors.groupingBy(User::getCity));
Creates:

{
  "Pune":   [user1, user2],
  "Mumbai": [user3],
  "Delhi":  [user4, user5]
}

🔥 2. All groupingBy Overloads

groupingBy has 3 variants, each adding more control.

1. groupingBy(classifier)
Map<K, List<T>> groupingBy(Function<? super T, ? extends K> classifier)
2. groupingBy(classifier, downstream)
Map<K, D> groupingBy(Function<? super T, ? extends K> classifier,
                     Collector<? super T, A, D> downstream)
3. groupingBy(classifier, mapFactory, downstream)
<M extends Map<K, D>> M groupingBy(Function<? super T, ? extends K> classifier,
                                    Supplier<M> mapFactory,
                                    Collector<? super T, A, D> downstream)

The first overload is the simplest one, which groups elements into a Map<K, List<T>>.
The second overload allows you to specify a downstream collector, which defines how the grouped elements should be collected.
The third overload allows you to specify a custom Map implementation for the result.
    Map<String, Long> namesCount2 = names.stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    | What you want            | Downstream collector | Example result      |
| ------------------------ | -------------------- | ------------------- |
| Count elements per group | `counting()`         | Map<K, Long>        |
| Get max/min              | `maxBy(...)`         | Map<K, Optional<T>> |
| Sum values               | `summingInt(...)`    | Map<K, Integer>     |
| Create Map<K, Set<T>>    | `toSet()`            | Set instead of List |
| Apply more grouping      | nested groupingBy    | Map<K1, Map<K2, …>> |

Map<String, Set<User>> result =
    users.stream()
         .collect(Collectors.groupingBy(
             User::getCity,
             TreeMap::new,         // sorted keys
             Collectors.toSet()    // values are sets
         ));
 This above is of 3rd Type.. so resultant map is of type TreeMap and values are of type Set instead of List

 Map<String, Optional<User>> highestSalary =
    users.stream()
         .collect(Collectors.groupingBy(
             User::getCity,
             Collectors.maxBy(Comparator.comparing(User::getSalary))
         ));


What Is partitioningBy?

partitioningBy → splits elements into two groups based on a boolean predicate:

true → items matching condition

false → items not matching

Output: Map<Boolean, List<T>> or with downstream → Map<Boolean, Something>

Map<Boolean, List<User>> map =
    users.stream()
         .collect(Collectors.partitioningBy(u -> u.getAge() > 18));

Variant with downstream:
Map<Boolean, Long> count =
    users.stream()
         .collect(Collectors.partitioningBy(
             u -> u.getAge() > 18,
             Collectors.counting()
         ));

| Feature     | groupingBy                    | partitioningBy              |
| ----------- | ----------------------------- | --------------------------- |
| Key type    | ANY type (String, enum, int…) | Boolean                     |
| Buckets     | Many                          | Exactly 2                   |
| Output      | Map<K, List<T>>               | Map<Boolean, List<T>>       |
| Performance | Usually slower                | Faster (boolean check only) |
| Usage       | General-purpose grouping      | True/False splits           |


Map<Boolean, Map<String, List<User>>> result =
    users.stream()
         .collect(Collectors.partitioningBy(
             u -> u.getAge() > 18,
             Collectors.groupingBy(User::getCity)
         ));

true → {
         Pune: [adult1, adult2],
         Delhi: [adult3]
       }

false → {
         Pune: [minor1],
         Mumbai: [minor2]
       }

     */


}
