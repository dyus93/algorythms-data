package Queue;

public class PriorityQueApp {
    public static void main(String[] args) {
        PriorityQue thePQ = new PriorityQue(5);
        thePQ.insert(30);
        thePQ.insert(50);
        thePQ.insert(10);
        thePQ.insert(40);
        thePQ.insert(20);

        while (!thePQ.isEmpty()){
            long item = thePQ.remove();
            System.out.print(item + " ");
            System.out.println("");
        }
    }
}