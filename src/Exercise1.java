import java.util.*;

public class Exercise1 {
    
    public static void main(String[] args) {

        Visualizer v = new Visualizer();
        Filter f = new Filter(v);
        Counter c = new Counter(f);
        c.start();
    }
}

class Counter{

    private int c;
    private Filter filter;

    public Counter(Filter f) {
        c = 0;
        filter = f;
    }

    public void start() {

        for (int i=0; i<50; i++) {
            c++;
            if (c%5==0) {
                filter.filter(c);
            }
        }
    }
}

class Filter {

    private List<Integer> list;
    Visualizer visualizer;

    public Filter(Visualizer v) {
        visualizer = v;
        list = new ArrayList<Integer>();
    }

    public void filter(int c) {
        list.add(c);
        if (list.size()%2==0) {

            System.out.println("lista size: " + list.size());

            visualizer.visualize(list);
        }
    }
}

class Visualizer {

    public void visualize(List<Integer> list) {

        for (Integer i : list) {
            System.out.println(i.intValue());
        }
        System.out.println();
    }
}