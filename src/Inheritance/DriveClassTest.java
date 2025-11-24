package Inheritance;

class Parent {
    public void show(){
        System.out.println("Parent class method");
    }
}

class Chiled extends Parent {
    public void show(){
        System.out.println("Chiled class method");
    }
}

public class DriveClassTest {

    public static void main(String[] args) {
        Parent obj = new Chiled(); // out put: Chiled class method
        obj.show();
    }
}
