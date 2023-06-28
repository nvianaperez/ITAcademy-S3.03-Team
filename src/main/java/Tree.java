public class Tree extends Product{

    private float heigh;

    public Tree(int id, String name,int stock, float price, float heigh){

        super(id,name, stock, price);
        this.heigh = heigh;

    }
    public float getHeigh() {
        return this.heigh;
    }

    public void setHeigh(float heigh) {
        this.heigh = heigh;
    }

    @Override
    public String toString() {
        return "Id: " + super.getId() + " || " + "Name : " + super.getName() + " || " + "Colour: "
                + this.heigh + " || " + "Price: " + super.getPrice() + " || " + "Stock: " + super.getStock();
    }
}
