package syc.study.javabase.cloneTest;

public class testClone {

    public void getPersonClone() throws CloneNotSupportedException {
        Personnal personnal = new Personnal("18", "21");
        Personnal clone = personnal.clone();
        System.out.println(clone.equals(personnal));
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        testClone testClone = new testClone();
        testClone.getPersonClone();
        String aa = "";

    }
}
