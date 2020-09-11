package DataArray;

public class Replay {
    private int maxSize;
    private long[] stackArray;
    private int top;

    public Replay(int s){
        maxSize = s;
        stackArray = new long[maxSize];
        top = -1;
    }

    public void push(int i){
        stackArray[++top] = i;
    }

    public long pop(){
       return stackArray[top--];
    }

    public boolean isEmpty(){
        return top == -1 ;
    }

    public long peek(){
       return stackArray[top];
    }

    public boolean isFull(){
        return top == maxSize - 1;
    }

}
