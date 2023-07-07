package spring_container.example.inversion_of_control;

public class Dog implements Pet {
    @Override
    public void say() {
        System.out.println("Woof");
    }

    private void init() {
        System.err.println("Dog init(): init method");
    }

    private void destroy() {
        System.err.println("Dog destroy(): destroy method");
    }

    public int init2() {
        System.err.println("Dog2 init(): init method");
        return -3;
    }

    public int destroy2() {
        System.err.println("Dog2 destroy(): destroy method");
        return -1;
    }
}
