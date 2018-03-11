package javase02.stationerypart;

public class Ruler implements Stationery {

    private String producer;
    private Double maxLength;
    private Double price;
    private String name = getClass().getSimpleName();

    Ruler(String producer, Double maxLength, Double price){
        this.producer = producer;
        this.maxLength = maxLength;
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        return(obj instanceof Ruler
                && this.producer.equals(((Ruler)obj).producer)
                && this.maxLength.equals(((Ruler)obj).maxLength)
                && this.price.equals(((Ruler)obj).price));
    }

    @Override
    public int hashCode() {
        int hashCode = 37;
        hashCode = hashCode*17+producer.hashCode();
        hashCode = hashCode*17+maxLength.hashCode();
        hashCode = hashCode*17+price.hashCode();
        return hashCode;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " +
                this.producer + ", " +
                this.maxLength + ", " +
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