package javase02.stationerypart;

import java.util.Comparator;

public class StationeryComparator implements Comparator<Stationery>{
    private Criterion criterion;

    StationeryComparator(Criterion criterion){
        this.criterion = criterion;
    }

    @Override
    public int compare(Stationery o1, Stationery o2) {
        Integer result;
        switch (this.criterion){
            case NAME:{
                result = o1.getName().compareTo(o2.getName());
                break;
            }
            case PRICE:{
                result = (int) (o1.getPrice() - o2.getPrice());
                break;
            }
            case PRICE_AND_NAME:{
                if(!o1.getPrice().equals(o2.getPrice()))
                    result = (int) (o1.getPrice() - o2.getPrice());
                else
                    result = o1.getName().compareTo(o2.getName());
                break;
            }
            default:
                result = null;
        }
            return  result;
    }
}
