package org.paumard.stream;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import  java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamMethodsPrac {
    public static  void main(String args[]){
        List<Integer> values = Arrays.asList(1,2,3,4,5,6);

        //Map takes function object as input
        Function<Integer , Integer> f = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer*2;
            }
        };

        //Input to reduce method
        BinaryOperator<Integer> b = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer i, Integer j) {

                return i+j;
            }
        };


        Stream s = values.stream();

        Stream s1 = s.map(f); // 2, 4, 6, 8, 10, 12

        Integer result = (Integer) s1.reduce(0, b);  //reduce(Initial value, function)
        // 0(intial) +2, presum 2+4, 6+ 6, 12+8 , 20+10 , 30 +12 = 42



        System.out.println(result);
        //s1.forEach(System.out ::println);

        List<Integer> a = Arrays.asList(1,2,3,4);
        Integer st = a.stream().map(i -> i*2).reduce(0 , (c, e)-> c+e);
        //reduce(0, (c,e) ->Integer.sum(c,e))  || Integer::sum
        System.out.println("A sum of doubled elements " + st);

        List<Integer> c = Arrays.asList(40,5,61,75,80,9);
        //add divisible by 5
        //only focus on what to do , stream will tell how to do

        System.out.println(c.stream().filter(i -> i%5==0).reduce(0,Integer::sum));

        //Filter needs object of predicate
        //Predicate - Functional interface - 1 method test returns boolean value

        Predicate<Integer> p = new Predicate<Integer>() {
            @Override
            public boolean test(Integer i) {
                return i%5 ==0;
            }
        };

        //Optional - bcz list might not contain
        System.out.println("Printing first doubled value divisible by 5 "+c.stream().filter(i -> i%5==0)
                .map(i ->i*2)
                        .findFirst()
                .orElse(0)
        );

        //So you would think that this is first mapping and filering all elements and then giving back first elemen
        //No , its a lazy evaluation (map, filter)
        // findFirst() - triggers first --> asks map & filter to start operations
        //So more efficient than for loop
    }


}
