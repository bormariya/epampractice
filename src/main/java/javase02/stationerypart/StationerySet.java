package javase02.stationerypart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class StationerySet {

    private ArrayList<Stationery> set;

    StationerySet(){
        this.set = new ArrayList<>();
    }

    StationerySet(Stationery... set){
        this.set = new ArrayList<>();
        this.set.addAll(Arrays.asList(set));
    }

    public void addPosition(Stationery element){
        set.add(element);
    }

    public ArrayList<Stationery> getSet() {
        return set;
    }

    public Double getFullPriceOfSet(){
        Double sum = 0.0;
        for (Stationery element : this.getSet()) {
            sum += element.getPrice();
        }
        return sum;
    }

    public void sortByName(){
        Comparator<Stationery> comp = new StationeryComparator(Criterion.NAME);
        this.set.sort(comp);
    }

    public void sortByPrice(){
        Comparator<Stationery> comp = new StationeryComparator(Criterion.PRICE);
        this.set.sort(comp);
    }

    public void sortByPriceAndName(){
        Comparator<Stationery> comp = new StationeryComparator(Criterion.PRICE_AND_NAME);
        this.set.sort(comp);
    }


}
