public class Flower extends Product{

    private String colour;
    public Flower(int id,String name,int stock, float price, Category category, String colour){
        super(id, name, stock, price, category);
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
        return "Id: " + super.getId() + " || " + "Name : " + super.getName() + " || " + "Colour: "
                + this.colour + " || " + "Price: " + super.getPrice() + " || " + "Stock: " + super.getStock();
    }
}
