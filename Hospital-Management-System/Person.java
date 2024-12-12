//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public abstract class Person {
    private String name;
    private int age;
    private String gender;

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            System.out.println("Age must be non-negative.");
        }

    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        if (!gender.equalsIgnoreCase("Male") && !gender.equalsIgnoreCase("Female") && !gender.equalsIgnoreCase("Other")) {
            System.out.println("Invalid gender specified.");
        } else {
            this.gender = gender;
        }

    }

    public void displayInfo() {
        System.out.println("------ Person Details ------");
        System.out.println("Name      : " + this.name);
        System.out.println("Age       : " + this.age);
        System.out.println("Gender    : " + this.gender);
        System.out.println("----------------------------");
    }
}

