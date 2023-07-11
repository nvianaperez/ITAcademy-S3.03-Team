public class Flower extends Product{

    private String colour;
    public Flower(String name,int stock, float price, Category category, String colour){
        super( name, stock, price, category);
        this.colour = colour;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {

        return "Name : " + super.getName() +  " Colour: "
                + this.colour + " Price: " + super.getPrice() +  " Stock: " + super.getStock();

    }
}
