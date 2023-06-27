public class Tree extends Product{

    private float tall;

    public Tree(int id, String name,int numb, float price, float tall){

        super(id,name, numb, price);
        this.tall = tall;

    }
    public float getTall() {
        return this.tall;
    }

    public void setTall(float tall) {
        this.tall = tall;
    }

    @Override
    public String toString() {
        return "Id: " + super.getId() + " || " + "Name : " + super.getName() + " || " + "Colour: "
                + this.tall + " || " + "Price: " + super.getPrice() + " || " + "Stock: " + super.getStock();
    }
}
