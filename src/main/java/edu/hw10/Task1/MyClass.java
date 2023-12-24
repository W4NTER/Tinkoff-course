package edu.hw10.Task1;

public class MyClass {
    private String name;
    private int age;

    public int getAge() {
        return age;
    }

    private MyClass(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static MyClass create(String name, int age) {
        return new MyClass(name, age);
    }

}
//record MyRecord(int value) {}
