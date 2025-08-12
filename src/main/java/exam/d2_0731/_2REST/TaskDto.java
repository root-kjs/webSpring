package exam.d2_0731._2REST;

public class TaskDto {
    private int age;
    private String name;

    public TaskDto() {
    }

    public TaskDto(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }
}// class end
