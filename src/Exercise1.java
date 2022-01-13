import java.util.*;

public class Exercise1 {

    public static void main(String[] args) {

        Visualizer v = new Visualizer();
        Filter f = new Filter(v);
        Counter c = new Counter(f);

        c.addObserver(f);
        f.addObserver(v);

        c.start();
    }
}

class Counter extends Observable{

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
                setChanged();
                notifyObservers(c);
            }
        }
    }
}

class Filter extends Observable implements Observer {

    private List<Integer> list;
    Visualizer visualizer;

    public Filter(Visualizer v) {
        visualizer = v;
        list = new ArrayList<Integer>();
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o != null && o instanceof Counter){
            list.add((Integer) arg);
            if (list.size()%2==0) {
                setChanged();
                notifyObservers(list);
            }
        }
    }
}

class Visualizer implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        if (o != null && o instanceof Filter) {
            for (Integer i : (List<Integer>) arg) {
                System.out.println(i.intValue());
            }
            System.out.println();
        }
    }
}