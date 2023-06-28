public class Deco extends Product{

    private String decoType;

    public Deco(int id,String name,int stock, float price, String decoType){
        super(id,name, stock, price);
        this.decoType = decoType;
    }

    public String getDecoType() {
        return decoType;
    }

    public void setDecoType(String decoType) {
        this.decoType = decoType;
    }

    @Override
    public String toString() {
        return "Id: " + super.getId() + " || " + "Name : " + super.getName() + " || " + "Colour: "
                + this.decoType + " || " + "Price: " + super.getPrice() + " || " + "Stock: " + super.getStock();
    }
}
