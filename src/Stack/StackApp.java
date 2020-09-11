package Stack;

public class StackApp {
    public static void main(String[] args) {
        StackX theStack = new StackX(10);
        theStack.push('a');
        theStack.push('b');
        theStack.push('c');
        theStack.push('d');

        while (!theStack.isEmpty()){
            long value = theStack.pop();
            System.out.print(value);
            System.out.println(" ");
        }
        System.out.println("");
    }
}
