public class Tree extends Product{

    private float high;

    public Tree(int id, String name,int stock, float price, float high){

        super(id,name, stock, price);
        this.high = high;

    }
    public float getHigh() {
        return this.high;
    }

    public void setHigh(float high) {
        this.high = high;
    }

    @Override
    public String toString() {
        return "Id: " + super.getId() + " || " + "Name : " + super.getName() + " || " + "Colour: "
                + this.high + " || " + "Price: " + super.getPrice() + " || " + "Stock: " + super.getStock();
    }
}
