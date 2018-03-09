package javase02.stationerypart;

public class Divider implements Stationery {
    private String producer;
    private Double diameter;
    private Rigidity rigidity;
    private Double price;

    Divider(String producer, Double diameter, Rigidity rigidity, Double price){
        this.producer = producer;
        this.diameter = diameter;
        this.rigidity = rigidity;
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        return(obj instanceof Divider
                && this.producer.equals(((Divider)obj).producer)
                && this.diameter.equals(((Divider)obj).diameter)
                && this.rigidity.equals(((Divider)obj).rigidity)
                && this.price.equals(((Divider)obj).price));
    }

    @Override
    public int hashCode() {
        int hashCode = 37;
        hashCode = hashCode*17+producer.hashCode();
        hashCode = hashCode*17+diameter.hashCode();
        hashCode = hashCode*17+rigidity.hashCode();
        hashCode = hashCode*17+price.hashCode();
        return hashCode;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " +
                this.producer + ", " +
                this.diameter + ", " +
                this.rigidity.toString() + ", " +
                this.price + " RUB";
    }
}
