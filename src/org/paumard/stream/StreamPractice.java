package org.paumard.stream;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPractice {
    public static  void main(String args[]){
        System.out.println("Hello");

        int[] v = {2, 3, 45, 6, 7};
        //variables in lambda expression are effectively final
        // #1 - Internal Iterations
        System.out.println("Using InteStream");
        IntStream.of(v)
                .forEach(val -> System.out.printf("%d\t", val));

        List<Integer> l = Arrays.asList(1, 2,3, 4, 5, 6);

        //#2 - External Iterations - For loops
        System.out.println();
        System.out.println("Using normal");
        Iterator<Integer> i = l.iterator();
        while(i.hasNext()){
            System.out.printf("%d\t",i.next());
        }
        System.out.println("Stream on List");
        //Internal
        l.forEach(j -> System.out.printf("%d\t",j));

     // Consumer functional interface and creating anonymous class here
        Consumer<Integer> c = new Consumer<Integer>(){

            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        };
        //lambda for above expression

        Consumer<Integer> c1 = (Integer j) -> System.out.println(j);
        l.forEach(c); // here for each accepts Consumer interface

        //Functional interfaces have only one method but we can define default method there
        //Declare void run();   define void run(){ sout("some thing") };

        //Using method reference
        System.out.println("Using method ref");
        l.forEach(System.out:: println); // function will derive values by its own

        // Stream Api
       // To print large number of data using multithreading provided by stream
        l.parallelStream().forEach(System.out::println);

        //Stream provided methods to process huge number of data

        //Intermediate - filter , map .....Terminate - findFirst(), forEach
        //Once the values is used we can't use it any more
        //Streams are lazy because intermediate operations are not evaluated unless terminal operation is invoked.
        // Each intermediate operation creates a new stream, stores the provided operation/function and return the new stream.
        // The pipeline accumulates these newly created streams.

        //Stream api gives optional bcz list might not contain values based on filters applied

        Stream<Integer> s = l.stream();
        s.forEach(System.out::println); // will work
        //s.forEach(System.out :: println);// gives exception , cant use again

        List<Integer> values = Arrays.asList(10, 11 , 12, 13 , 14, 15);

        //Sum all using stream / without mutation (means using var which is changed everytime in loop like res =0 , res+=i;
        // values.stream() gives object of stream interface which has lots of methods
        //Sum of doubled elements
        System.out.println("Sum using stream");
        System.out.println(values.stream().map(k ->k*2).reduce(0, (carry, e) ->carry+e));



        List<String> word = Arrays.asList("a", "bc", "d");

        //Get a concatenated string from list using streams
        String res = word.stream().reduce("", (a,b) -> a+b);

        System.out.println(res);


    }
}
