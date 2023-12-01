package objectandclasses;

public class ObjectExample {
    public static void main(String[] args) {        
        Dog puppy = new Dog(1);
        puppy.bark();
        System.out.println("Am I a puppy: " + puppy.isPuppy());

        Dog adult = new Dog(5);
        adult.bark();
        System.out.println("Am I a puppy: " + adult.isPuppy());
    }
}