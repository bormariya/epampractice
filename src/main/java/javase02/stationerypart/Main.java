package javase02.stationerypart;

public class Main {
    public static void main(String[] args) {
        StationerySet nubSet = new StationerySet();
        nubSet.addPosition(new Pen("SomeProducer", Color.BLUE, 10.5));
        nubSet.addPosition(new Pencil("SomeProducer2", Color.GRAY, Rigidity.HB, 5.0));
        nubSet.addPosition(new Divider("SomeProducer3", 7.5, Rigidity.HB, 20.99));
        nubSet.addPosition(new Eraser("SomeProducer2", "Каучук", 10.0));
        nubSet.addPosition(new Ruler("SomeProducer", 30.0, 20.99));

        for (Stationery element : nubSet.getSet()) {
            System.out.println(element);
        }
    }
}
