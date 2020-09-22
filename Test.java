import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {



        List<String> names = getEmployeeList().stream().map(Employee::getEName).collect(Collectors.toList());
        System.out.println(names);



        Map<String, List<Employee>> groupDept =
                getEmployeeList().stream().collect(Collectors.groupingBy(Employee::getDept));

       // System.out.println(groupDept);


        List<List<Employee>> listEmpMap =
                groupDept.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());

        List<String> flatMap = listEmpMap.stream()
                .flatMap(Collection::stream)
                .map(Employee::getEName)
                .collect(Collectors.toList());

        System.out.println(flatMap);
    }


    private static List<Employee> getEmployeeList() {
        Employee emp1 = new Employee(101, "dhananjay", 3000.00, "IT");
        Employee emp2 = new Employee(102, "Hari", 3000.00, "IT");
        Employee emp3 = new Employee(103, "Ram", 3000.00, "IT");
        Employee emp4 = new Employee(104, "Gyan", 3000.00, "Sales");
        Employee emp5 = new Employee(105, "Ranjit", 3000.00, "Sales");
        return Arrays.asList(emp1, emp2, emp3, emp4, emp5);
    }
}

@Getter
@Setter
@ToString
@AllArgsConstructor
class Employee {

    private Integer eId;
    private String eName;
    private double eSal;
    private String dept;


}
