package org.paumard.stream;


import java.util.*;
        import java.util.stream.*;

class Employee {
    String name;
    int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }

    @Override
    public String toString() {
        return "(" + name + "," + age + ")";
    }
}

public class MastercardQuestion {

    private static String getAgeRange(int age) {
        int lower = (age / 10) * 10;
        int upper = lower + 10;
        return lower + "-" + upper;
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Ankit", 32),
                new Employee("Mayank", 40),
                new Employee("Rahul", 32),
                new Employee("Niky", 24)
        );

        // Initialize all ranges
        Map<String, List<Employee>> result = new LinkedHashMap<>();
        List<String> ranges = Arrays.asList("10-20", "20-30", "30-40", "40-50", "50-60");
        ranges.forEach(r -> result.put(r, new ArrayList<>()));

        // Fill data
        employees.stream()
                .collect(Collectors.groupingBy(e -> getAgeRange(e.getAge())))
                .forEach((k, v) -> result.put(k, v));

        // Print
        result.forEach((k, v) -> System.out.println(k + " -> " + v));
    }
}
