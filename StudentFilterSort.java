import java.util.*;
import java.util.stream.Collectors;

class Student {
    String name;
    double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }
}

public class StudentFilterSort {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 85.0));
        students.add(new Student("Bob", 72.0));
        students.add(new Student("Charlie", 90.0));
        students.add(new Student("David", 60.0));
        students.add(new Student("Eve", 78.0));
        
        List<String> filteredSortedNames = students.stream()
            .filter(student -> student.getMarks() > 75)
            .sorted(Comparator.comparingDouble(Student::getMarks))
            .map(Student::getName)
            .collect(Collectors.toList());

        filteredSortedNames.forEach(System.out::println);
    }
}
