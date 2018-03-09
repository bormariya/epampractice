package javase02.stationerypart;

import java.util.ArrayList;

public class StationerySet {

    ArrayList<Stationery> set;

    StationerySet(){
        this.set = new ArrayList<>();
    };

    StationerySet(Stationery... set){
        this.set = new ArrayList<>();

        for (Stationery element : set) {
            this.set.add(element);
        }
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


}
