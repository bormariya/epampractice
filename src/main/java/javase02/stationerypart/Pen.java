package javase02.stationerypart;

public class Pen {

    private String producer;
    private Color color;

    Pen(String producer, Color color){
        this.producer = producer;
        this.color = color;
    }

    @Override
    public boolean equals(Object obj) {
        return(obj instanceof Pen
                && this.producer.equals(((Pen)obj).producer)
                && this.color.equals(((Pen)obj).color));
    }

    @Override
    public int hashCode() {
        int hashCode = 37;
        hashCode = hashCode*17+producer.hashCode();
        hashCode = hashCode*17+color.hashCode();
        return hashCode;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " +
                this.producer + ", " +
                this.color.toString();
    }
}
