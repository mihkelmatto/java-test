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





# 