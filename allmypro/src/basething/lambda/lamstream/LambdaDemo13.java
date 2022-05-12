package basething.lambda.lamstream;

import basething.lambda.lamstream.po.Department;
import basething.lambda.lamstream.po.Employee;
import basething.lambda.lamstream.po.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * collect()
 * 使用Collectors.toMap()生成的收集器，用户需要指定如何生成Map的key和value。
 * 使用Collectors.partitioningBy()生成的收集器，对元素进行二分区操作时用到。
 * 使用Collectors.groupingBy()生成的收集器，对元素做group操作时用到。
 *
 * @author mucongcong
 * @date 2022/05/12 09:47
 * @since
 **/
public class LambdaDemo13 {
    final static private Double PASS_THRESHOLD = 60.0;

    public static void main(String[] args) {
        //情况1：使用toMap()生成的收集器，这种情况是最直接的，前面例子中已提到，
        // 这是和Collectors.toCollection()并列的方法。如下代码展示将学生列表转换成由<学生，GPA>组成的Map。非常直观，无需多言
        ArrayList<Student> students = new ArrayList<>(Arrays.asList(new Student(1,98.0),new Student(2,97.5)));
        // 使用toMap()统计学生GPA
        Map<Student, Double> studentToGPA =
                students.stream().collect(Collectors.toMap(Function.identity(),// 如何生成key
                        student -> computeGPA(student)));// 如何生成value

        // Partition students into passing and failing
        // 情况2：使用partitioningBy()生成的收集器，这种情况适用于将Stream中的元素依据某个二值逻辑（满足条件，或不满足）分成互补相交的两部分，
        // 比如男女性别、成绩及格与否等。下列代码展示将学生分成成绩及格或不及格的两部分
        ArrayList<Student> students2 = new ArrayList<>(Arrays.asList(new Student(1,98.0),new Student(2,97.5),new Student(3,59.5)));
        Map<Boolean, List<Student>> passingFailing = students2.stream()
                .collect(Collectors.partitioningBy(s -> s.getGrade() >= PASS_THRESHOLD));

        // 情况3：使用groupingBy()生成的收集器，这是比较灵活的一种情况。跟SQL中的group by语句类似，
        // 这里的groupingBy()也是按照某个属性对数据进行分组，属性相同的元素会被对应到Map的同一个key上。下列代码展示将员工按照部门进行分组：
        // Group employees by department
        ArrayList<Employee> employees = new ArrayList<>(Arrays.asList(new Employee(1, 1, new Department("东厂")), new Employee(2, 2, new Department("西厂"))));
        Map<Department, List<Employee>> byDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        // 增强版的groupingBy()允许我们对元素分组之后再执行某种运算，比如求和、计数、平均值、类型转换等。
        // 这种先将元素分组的收集器叫做上游收集器，之后执行其他运算的收集器叫做下游收集器(downstream Collector)。
        // 使用下游收集器统计每个部门的人数
        ArrayList<Employee> employees2 = new ArrayList<>(Arrays.asList(new Employee(1, 1, new Department("东厂")), new Employee(2, 2, new Department("西厂"))));
        Map<Department, Long> totalByDept = employees2.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.counting()));// 下游收集器

        // 按照部门对员工分布组，并只保留员工的名字
        ArrayList<Employee> employees3 = new ArrayList<>(Arrays.asList(new Employee(1, 1, new Department("东厂")), new Employee(2, 2, new Department("西厂"))));
        Map<Department, List<String>> dept = employees3.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.mapping(Employee::getName,// 下游收集器
                                Collectors.toList())));// 更下游的收集器
    }

    private static Double computeGPA(Student student) {
        return student.getGrade();
    }
}
