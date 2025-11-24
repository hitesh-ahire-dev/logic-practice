package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDublicateEmployee {

    public static void main(String[] args) {
        List<Employee> dublicateEmpList = Arrays.asList(
                new Employee(1, "John", "IT", 5000),
                new Employee(2, "Mike", "IT", 6000),
                new Employee(3, "Robert", "HR", 4500),
                new Employee(4, "Smith", "HR", 5500),
                new Employee(5, "Emily", "IT", 7000),
                new Employee(6, "Anna", "HR", 6500),
                new Employee(6, "Anna", "HR", 6500),
                new Employee(6, "Anna", "HR", 6500)
        );


        List<Employee> collect = dublicateEmpList
                .stream()
                .distinct()
                .collect(Collectors.toList());


       for (Employee emp : collect){
           System.out.println(emp);
       }
    }
}