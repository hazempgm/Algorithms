import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class QueueMergeSort {

    static void sort() {
        while(queue.size() > 1) {
            List<Integer> a = queue.removeFirst();
            List<Integer> b = queue.removeFirst();
            List<Integer> c = new LinkedList<>();
            while(!a.isEmpty() && !b.isEmpty()) {
                int x = a.get(0);
                int y = b.get(0);
                if(x <= y) {
                    c.add(x);
                    a.remove(0);
                } else {
                    c.add(y);
                    b.remove(0);
                }
            }

            while(!a.isEmpty()) {
                c.add(a.remove(0));
            }

            while(!b.isEmpty()) {
                c.add(b.remove(0));
            }

            queue.addLast(c);
        }
    }
    static LinkedList<List<Integer>> queue = new LinkedList<>();
    public static void main(String[] args) {
        int N = 10000;
        int[] arr = new int[N];
        System.out.println("Array to sort: ");
        for(int i = 0; i < N; i++) {
            arr[i] = (int)(Math.random() * 100);
            System.out.print(arr[i] + " ");
        }

        for(int i = 0; i < N; i++) {
            List<Integer> l = new LinkedList<>();
            l.add(arr[i]);
            queue.addFirst(l);
        }

        sort();

        List<Integer> newArr = queue.remove();

        System.out.println("The sorted output is :");
        newArr.stream().forEach(x -> System.out.print(x + " "));
    }
}
