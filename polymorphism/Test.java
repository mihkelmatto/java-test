package polymorphism;

public class Test {
    public static void main(String[] args) {
        Car car = new Car("Charger", "Yellow", 10000);

        // these attributes can't be accessed directly, but have a getter method. (car.color > car.getColor())
        System.out.println(car.getColor() + " " + car.getModel() + " " + car.getPrice());
        
        // Only the color is changeable. (car.color = "" >> car.setColor(""))
        car.setColor("White");
    }    
}
