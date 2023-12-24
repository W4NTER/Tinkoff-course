package edu.hw10.Task1;

public class Main {
    public static void main(String[] args) {
        RandomObjectGenerator randomObjectGenerator = new RandomObjectGenerator();

        var myClass = randomObjectGenerator.nextObject(MyClass.class, "create");
//        var myRecord = randomObjectGenerator.nextObject(MyRecord.class);

        System.out.println(myClass);
//        System.out.println(myRecord);
        System.out.println(myClass.getAge());
    }
}
