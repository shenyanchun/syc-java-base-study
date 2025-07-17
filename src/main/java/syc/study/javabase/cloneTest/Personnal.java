package syc.study.javabase.cloneTest;

/**
 * @author Administrator
 */
public class Personnal implements Cloneable{

    private String age;

    private String name;

    public Personnal(String age, String name) {
        this.age = age;
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Personnal clone() throws CloneNotSupportedException {

        return (Personnal) super.clone();
    }
}
