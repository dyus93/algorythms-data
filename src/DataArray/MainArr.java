package DataArray;

public class MainArr {
    public static void main(String[] args) throws ArrayIndexOutOfBoundsException{
        int size = 100;
        MyArr arr = new MyArr(size);
        arr.insert("Vasya", 10);
        arr.insert("Pavlik", 15);
        arr.display();
    }
}
