public class Tree extends Product{

    private float heigh;

    public Tree(String name,int stock, float price, Category category, float heigh){

        super(name, stock, price, category);
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
        return "Name : " + super.getName()  + " Height: "
                + this.heigh + " Price: " + super.getPrice() + " Stock: " + super.getStock();
    }


}
