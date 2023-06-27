public class Flower extends Product{

    private String colour;
    public Flower(int id,String name,int numb, float price,String colour){
        super(id,name, numb, price);
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
