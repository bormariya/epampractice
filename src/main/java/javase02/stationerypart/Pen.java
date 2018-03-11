package javase02.stationerypart;

public class Pen implements  Stationery{

    private String producer;
    private Color color;
    private Double price;
    private String name = getClass().getSimpleName();

    Pen(String producer, Color color, Double price){
        this.producer = producer;
        this.color = color;
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        return(obj instanceof Pen
                && this.producer.equals(((Pen)obj).producer)
                && this.color.equals(((Pen)obj).color)
                && this.price.equals(((Pen)obj).price));
    }

    @Override
    public int hashCode() {
        int hashCode = 37;
        hashCode = hashCode*17+producer.hashCode();
        hashCode = hashCode*17+color.hashCode();
        hashCode = hashCode*17+price.hashCode();
        return hashCode;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " +
                this.producer + ", " +
                this.color.toString() + ", " +
                this.price + " RUB";
    }

    @Override
    public Double getPrice() {
        return this.price;
    }

    public String getName() {
        return this.name;
    }
}
