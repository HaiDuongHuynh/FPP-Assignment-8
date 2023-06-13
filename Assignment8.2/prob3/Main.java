package prob3;

import java.util.*;
import java.util.ArrayList;
import java.util.Comparator;


public class Main {
    public static void main(String[] args) {
        ArrayList<Marketing> lists = new ArrayList<Marketing>();
        lists.add(new Marketing("Tom","Bike", 5000));
        lists.add(new Marketing("Clinton","Car", 150000));
        lists.add(new Marketing("Jhin","Art", 40000));
        lists.add(new Marketing("Jayce","Hammer", 50000));
        lists.add(new Marketing("Kate","Paper", 300));
        System.out.println(lists);
        System.out.println("Size of the list is: " + lists.size());
        lists.remove(2);
        System.out.println("Lists after removed: ");
        System.out.println(lists);
        System.out.println("Size of the list is: " + lists.size());
        lists.sort(new sortBySales());
        System.out.println("Lists after sorted: ");
        System.out.println(lists);

        List<Marketing> lists2 = listMoreThan1000(lists);
        lists2.sort(new sortBySales());
        System.out.println("Lists of employees make more than $1000: ");
        System.out.println(lists2);
    }

    static class sortBySales implements Comparator<Marketing>{
        public int compare(Marketing m1, Marketing m2){
            return m1.getSaleAmount() - m2.getSaleAmount();
        }
    }

    public static List<Marketing> listMoreThan1000(List<Marketing> list) {
        List<Marketing> result = new ArrayList<>();
        for (Marketing marketing : list) {
            if (marketing.getSaleAmount() > 1000) {
                result.add(marketing);
            }
        }
        return result;
    }

}
