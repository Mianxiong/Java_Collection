package sort;

public class Student implements Comparable<Student>{
    private int id;
    private String name;
    private int score;

    public Student(int id, String name, int score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(Student o) {
        if(this.score > o.score) {
            return 1;
        } else if(this.score < o.score) {
            return -1;
        } else {
            return this.name.compareTo(o.name);
        }
//        return this.score - o.score;
    }
}
