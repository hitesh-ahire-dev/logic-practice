package java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByFirstChar {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "John", "IT", 5000),
                new Employee(2, "Jayashree", "IT", 6000),
                new Employee(3, "Robert", "HR", 4500),
                new Employee(4, "Rahul", "HR", 5500),
                new Employee(5, "Ramesh", "IT", 7000),
                new Employee(6, "Anna", "HR", 6500),
                new Employee(7, "Alice", "Finance", 4800)
        );

        Map<Character, List<Employee>> mapResul = employees
                .stream()
                .collect(
                        Collectors.groupingBy(
                                emp -> Character.toUpperCase(emp.getName().charAt(0))
                        )
                );

       mapResul.forEach((key, value)->{
           System.out.println(key + " -> " + value);
       });


        Map<String, Employee> collect = employees
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.collectingAndThen(
                        Collectors.toList(),
                        list ->
                                list.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                                        .skip(1)
                                        .findFirst()
                                        .orElse(null)
                )));

        System.out.println("test - " + collect);
    }
}