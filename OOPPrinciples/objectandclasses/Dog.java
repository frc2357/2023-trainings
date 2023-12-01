package objectandclasses;


public class Dog {
    private int age;

    public Dog(int age) {
        this.age=age;
    }

    public void bark() {
        System.out.println("Bark");
    }

    public boolean isPuppy() {
        return age <= 1;
    }
}
