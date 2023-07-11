public class Deco extends Product{

    private String decoType;

    //ToDo: pasar decoType a Enum como en Product
    public Deco(String name,int stock, float price, Category category, String decoType){
        super(name, stock, price, category);
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
        return "Name : " + super.getName() + " DecoType: "
                + this.decoType + " Price: " + super.getPrice() + " Stock: " + super.getStock();
    }
}
