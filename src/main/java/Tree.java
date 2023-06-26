public class Tree extends Product{


    private float tall;


    public Tree(int id, String name,float price, float tall){

        super()

        this.tall = tall;

    }
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getTall() {
        return this.tall;
    }

    public void setTall(float tall) {
        this.tall = tall;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPreu(float preu) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tall=" + tall +
                ", price=" + price +
                '}';
    }
}
