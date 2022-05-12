package basething.lambda.lamstream.po;

/**
 * @author mucongcong
 * @date 2022/05/12 09:48
 * @since
 **/
public class Student {
    private int id;

    private Double grade;

    public Student() {
    }

    public Student(int id, Double grade) {
        this.id = id;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }
}
