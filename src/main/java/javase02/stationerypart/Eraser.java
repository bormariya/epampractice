package javase02.stationerypart;

public class Eraser implements Stationery {

    private String producer;
    private String material;
    private Double price;
    private String name = getClass().getSimpleName();

    Eraser(String producer, String material, Double price){
        this.producer = producer;
        this.material = material;
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        return(obj instanceof Eraser
                && this.producer.equals(((Eraser)obj).producer)
                && this.material.equals(((Eraser)obj).material)
                && this.price.equals(((Eraser)obj).price));
    }

    @Override
    public int hashCode() {
        int hashCode = 37;
        hashCode = hashCode*17+producer.hashCode();
        hashCode = hashCode*17+material.hashCode();
        hashCode = hashCode*17+price.hashCode();
        return hashCode;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " +
                this.producer + ", " +
                this.material + ", " +
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
