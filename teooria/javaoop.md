# Object-oriented programming
Object - an entity that holds data (attributes), perform actions(methods).
It is a reference data type

when printing an object, you get a memory address

keywords:
- static: belongs to the class, not to an object
- final: value can't be changed
- super: reference to a parent class
- this: reference to itself (python self.)

## example of an object
class Classname {
    String name;                            // fields - saves the values of an instance
    int age;

    Classname(String name, int age){    // constructor method (used when creating an object)
        this.name = name;                   // can be overloaded
        this.age = age;
    }
    void methodname(args){                  // instance method - methods that can only used by an instance of an object
        System.out.println(this.age);
    }
}

Classname objectname = new Classname(args); // creating an instance, calling the constructor with args
objectname.methodname();                    // calling an instance method

System.out.println(objectname.fieldvalue);  // accessing an instance field





# arrays of objects // anonymous objects
Car car1 = new Car("Mustang", "Red");
Car car2 = new Car("Corvette", "Blue");

Car[] cars = {car1, car2, new Car("Charger", "Yellow")}; // anonymous object - an object without a name

for(Car car : cars){        // can also use regular for loops (indexing)
    car.color = "black";    // changing field values 
    car.drive();            // calling methods
}





# Static keyword

## static variables - matching field values for all instances
Class People{
    static String country = "Estonia";
}
System.out.Println(People.country)

## static methods - methods that belong to the class
- can only be called by the class name or from inside the class (without classname. prefix)

class Maths {
    static int add(int a, int b){
        return a + b;
    }
}

int i = Maths.add(3, 5);

## static blocks - called once when loading the class
class Test {
    static {
        System.out.println("class loaded");
    }
}

## static classes - internal classes that dont need an instance
// can be accessed as Test.Internal

class Test {
    static class Internal {
    }
}





# Inheritance
- subclass(child class):    Inherits most functionality of its parent class.
- superclass(parent class): Source of common functionality among all subclasses.
- object                    Superclass of all other classes.


## extends keyword
Creates a parent-child relationship between classes.

When a class uses the extends keyword, it will inherit functionality from another class (superclass)
- Becomes a subclass of the other class
- inherits all public and protected methods from the superclass
- can overload the inherited methods
- doesn't inherit the constructor method (use super() to bypass this)
- when creating an object, superclass part is initialized first

!! Every class can inherit from max 1 parent


public class Animal {
    boolean isAlive;
    Animal(){
        isAlive = true;
    }
    
    void eat(){
        System.out.println("The animal is eating");
    }
    
}

// this class will inherit isAlive and eat()
public class Dog extends Animal{ 
    int lives = 1;
    void speak(){
        System.out.println("Woof");
    }
}

# super() constructor
When a subclass uses the constructor, it has to access the super class constructor to assign instance field values.
- Not mandatory if the super constructor is empty, but compiler will still add super()


public class Person {
    String firstname;
    String lastname;

    Person(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }
    void showname(){
        System.out.println(this.firstname + " " + this.lastname);
    }

    
} 

public class Student extends Person {
    double gpa;

    public Student(String firstname, String lastname, double gpa) {
        super(firstname, lastname);               // uses the constructor of Person
        this.gpa = gpa;
    }
    void showgpa(){
        System.out.println(this.firstname + "'s GPA: " + this.gpa);
    }
}





# Method overriding - creating an altered copy of a method in a subclass
- Override function has to have the same signature (args + return type).
- If the original method was overloaded, you have to override every version separately

## example
- When adding this to Student in the previous example, it will override Person.showname()
- showname will now be different for Person and Student
- @Override isn't mandatory, but it helps readability the compiler
    - Compiler will then get an exception if the original exists.

@Override
void showname(){
    System.out.printf("Student %s %s\n", this.firstname, this.lastname);
}





# .toString() - define object > string representations
This is a method inherited from the Object class.
- by default, it returns a hash code as a unique identifier
- it can be overriden to provide meaningful details

- can be further overriden in the subclasses

@Override
public String toString(){
    return "This will be the string representation of the object";
}





# abstraction - the process of hiding implementation details
[text](1.%20abstraction.md)

Abstract classes:
- can't be instanced directly, but can be used for inheritance
- can contain 'Abstract' methods (which have to be implemented == @Override)
- can contain 'Concrete' methods (which are inherited)

## example
abstract class People{
    isalive = true;
    abstract void breathe();    // every class must implement this method (@Override)
    
    void greeting(){            // this will be inherited and dont have to be overridden
        sout("hello") 
    }
}

class Student extends People{
    // this class inherits greeting()
    // and must implement breathe()
} 





# Interface - a blueprint for a class
Interface specifies a set of abstract methods that implementing classes must define.
Supports multiple inheritance-like behaviour
- extend keyword have max 1 superclass
- a class can implement multiple interfaces at a time

Additional info:
- from java 8, you can also create a default method, which doesnt have to be implemented
- can use private methods for helper functions inside the interface
- private methods can also be called from outside the interface

## example
public interface Prey{
    void flee();
}

public interface Predator {
    void hunt();
}

public interface Organism {
    default void eat() {
        sout(this.getname() + " is eating") // cant use instance field values
    }
}

// Fish implements both, so it has to have flee() and hunt()
// to use eat, fish also has to have getname()

public class Fish implements Prey, Predator {
    @Override
    public void flee(){
        System.out.println("The fish is swimming away");
    }
    @Override
    public void hunt(){
        System.out.println("The fish is hunting");
    }
    String getname(){
        return self.name;
    }
}





# Polymorphism - creating an object that has "many shapes"
An object can be treated as objects from a common superclass.
- All objects that "extend" the same class
- All objects that "implement" the same interface

## example
// all objects here "extend" from an abstract class Vehicles.

Bike bike = new Bike();
Boat boat = new Boat();
Car car = new Car();

Vehicle[] vehicles = {bike, boat, car};

for(Vehicle vehicle : vehicles){
    vehicle.go();
}   





# Runtime polymorphism - choosing a method at runtime
- You can decide on a subclass based on user input or other runtime variables.
- Then target the created class with the declared type of superclass

## example
- both Cat and Dog extend the Animal class.
- both classes have a speak method.

Scanner scanner = new Scanner(System.in);
Animal animal;

int input = scanner.nextint();
sout("Type 1 for dog, 2 for cat");

int choice = scanner.nextInt();

if(choice == 1){            // Both target the same class
    animal = new Dog();
    animal.speak();
}

else if(choice == 2){       ///
    animal = new Cat();
    animal.speak();
}





# getter and setter methods
They help protect object data and add rules for accessing or modifying them.
- getter: Methods that make a field readable
- setter: Methods that make a field writeable

This uses the characteristics of private keyword.
- Values are protected with the private keyword
- Define methods inside the class to give access
- these methods can have additional logic before accessing the values

## example
public class Main {
    public static void main(String[] args) {
        Car car = new Car("Charger", "Yellow", 10000);

        // these attributes can't be accessed directly, but have a getter method. (car.color > car.getColor())
        System.out.println(car.getColor() + " " + car.getModel() + " " + car.getPrice());
        
        // Only the color is changeable. (car.color = "" >> car.setColor(""))
        car.setColor("White");
    }    
}

public class Car {
    private String model;
    private String color;
    private int price;

    public Car(String model, String color, int price ) {
        this.model = model;
        this.color = color;
        this.price = price;
    }

    String getModel(){
        return this.model;
    }
    String getColor(){
        return this.color;
    }
    int getPrice(){
        return this.price;
    }
    void setColor(String color){
        this.color = color;
    }
}



