package java8;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CalculateSecondHigestSalaryOfEmpByDept {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "John", "IT", 5000),
                new Employee(2, "Mike", "IT", 6000),
                new Employee(3, "Robert", "HR", 4500),
                new Employee(4, "Smith", "HR", 5500),
                new Employee(5, "Emily", "IT", 7000),
                new Employee(6, "Anna", "HR", 6500)
        );

        Map<String, Employee> secondHighestByDept = employees.
                stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> list.stream()
                                        .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                                        .skip(1)
                                        .findFirst()
                                        .orElse(null)
                        )
                ));

        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.collectingAndThen(
                        Collectors.toList(),
                        list -> list
                                .stream()
                                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                                .distinct()
                                .skip(1)
                                .findFirst()
                                .orElse(null)
                ))).forEach((key, value)->{
                    System.out.println(key + " -> "+value);
                });


//        System.out.println(secondHighestByDept);
    }
}