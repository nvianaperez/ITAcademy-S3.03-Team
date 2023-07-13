public class Deco extends Product{

    private String decoType;

    public Deco(String name,int stock, float price, Category category, String decoType){
        super(name, stock, price, category);
        this.decoType = decoType;
    }

    public Deco(int id, String name,int stock, float price, Category category, String decoType){
        super(id, name, stock, price, category);
        this.decoType = decoType;
    }

    public String getDecoType() {
        return decoType;
    }


    @Override
    public String toString() {
        return "Name : " + super.getName() + " DecoType: "
                + this.decoType + " Price: " + super.getPrice() + " Stock: " + super.getStock();

    }
}
