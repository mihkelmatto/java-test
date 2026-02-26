package polymorphism;

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
