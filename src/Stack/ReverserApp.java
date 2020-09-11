package Stack;
//Перестановка букв в слове

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ReverserApp {
    public static void main(String[] args) throws Exception {
        String input, output;
        while (true){
            System.out.println("Enter a String");
            System.out.flush();
            input = getString();
            if (input.equals(""))
                break;

            Reverser reverser = new Reverser(input);
            output = reverser.doRev();
            System.out.println("Reversed: " + output);
        }
    }

    public static String getString() throws Exception{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
}
