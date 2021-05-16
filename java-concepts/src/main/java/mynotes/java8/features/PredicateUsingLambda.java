package mynotes.java8.features;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
 
public class PredicateUsingLambda {
     
    public static void main(String[] args) {
        List<Employee> empList=new ArrayList<Employee>();
        empList.add(new Employee("John", 27, 98000));
        empList.add(new Employee("Jane", 25, 80000));
        empList.add(new Employee("Max", 28, 110000));
        empList.add(new Employee("Matt", 32, 150000));
         
        Predicate<Employee> predSalary=(e)->e.getSalary()>100000;
        System.out.println("=================Employees having salary > 100000================");
        displayList(empList, predSalary);
        Predicate<Employee> predAge=(e)->e.getAge()<30;
        System.out.println("===================Employees having age <30==================");
        displayList(empList, predAge);
    }
 
    private static void displayList(List<Employee> empList,
            Predicate<Employee> pred) {
        empList.forEach(tempEmp ->{
            if(pred.test(tempEmp)){
                System.out.println(tempEmp);
            }
        });
    }
}