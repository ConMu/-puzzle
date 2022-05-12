package basething.lambda.lamstream.po;

/**
 * @author mucongcong
 * @date 2022/05/12 10:05
 * @since
 **/
public class Employee {

    private int id;

    private int depId;

    private Integer count;


    private Department department;

    private String name;

    public Employee() {
    }

    public Employee(int id, int depId, Department department) {
        this.id = id;
        this.depId = depId;
        this.department = department;
    }

    public Employee(int id, int depId, Integer count, Department department, String name) {
        this.id = id;
        this.depId = depId;
        this.count = count;
        this.department = department;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDepId() {
        return depId;
    }

    public void setDepId(int depId) {
        this.depId = depId;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
