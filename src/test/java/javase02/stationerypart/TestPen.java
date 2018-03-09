package javase02.stationerypart;

import junit.framework.TestCase;

public class TestPen extends TestCase {

    public void testEquals(){
        Pen blackPen = new Pen("SomeProducer", Color.BLACK, 7.5);
        Pen bluePen = new Pen("SomeProducer", Color.BLUE, 7.5);
        Pen anotherBlackPen = new Pen("SomeOtherProducer", Color.BLACK, 7.5);
        Pen anotherSameBlackPen = new Pen("SomeProducer", Color.BLACK, 7.5);

        if(blackPen.equals(bluePen))
            System.out.println("blackPen почему-то равно bluePen");
        if(blackPen.equals(anotherBlackPen))
            System.out.println("blackPen почему-то равно anotherBlackPen");
        if(blackPen.equals(anotherSameBlackPen))
            System.out.println("blackPen верно равно anotherBlackPen");
        if(blackPen.equals(blackPen))
            System.out.println("blackPen верно равно blackPen (самому себе)");


    }

    public void testHashCode(){
        Pen blackPen = new Pen("SomeProducer", Color.BLACK, 7.5);
        Pen bluePen = new Pen("SomeProducer", Color.BLUE, 7.5);
        Pen anotherBlackPen = new Pen("SomeOtherProducer", Color.BLACK, 7.5);
        Pen anotherSameBlackPen = new Pen("SomeProducer", Color.BLACK, 7.5);

        if(blackPen.hashCode() == bluePen.hashCode())
            System.out.println("hashCode blackPen почему-то равен hashCode bluePen");
        if(blackPen.hashCode() == anotherBlackPen.hashCode())
            System.out.println("hashCode blackPen почему-то равен hashCode anotherBlackPen");
        if(blackPen.hashCode() == anotherSameBlackPen.hashCode())
            System.out.println("hashCode blackPen верно равено hashCode anotherSameBlackPen");
        if(blackPen.hashCode() == blackPen.hashCode())
            System.out.println("hashCode blackPen верно равен hashCode blackPen (самому себе)");
    }

    public void testToString(){
        Pen blackPen = new Pen("SomeProducer", Color.BLACK, 7.5);

        System.out.println(blackPen.toString());
    }
}
