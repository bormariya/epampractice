package javase02.stationerypart;

public class Pencil implements Stationery {

    private String producer;
    private Color color;
    private Rigidity rigidity;
    private Double price;


    Pencil(String producer, Color color, Rigidity rigidity, Double price) {
        this.producer = producer;
        this.color = color;
        this.rigidity = rigidity;
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Pencil
                && this.producer.equals(((Pencil) obj).producer)
                && this.color.equals(((Pencil) obj).color)
                && this.rigidity.equals(((Pencil) obj).rigidity)
                && this.price.equals(((Pencil) obj).price));
    }

    @Override
    public int hashCode() {
        int hashCode = 37;
        hashCode = hashCode * 17 + producer.hashCode();
        hashCode = hashCode * 17 + color.hashCode();
        hashCode = hashCode * 17 + rigidity.hashCode();
        hashCode = hashCode * 17 + price.hashCode();
        return hashCode;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " +
                this.producer + ", " +
                this.color.toString() + ", " +
                this.rigidity.toString() + ", " +
                this.price + " RUB";
    }

    @Override
    public Double getPrice() {
        return this.price;
    }
}
