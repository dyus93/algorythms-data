package DataArray;

public class ArraySelect {
    private long[] a;
    private int nElems;

    public ArraySelect(int max){
        a = new long[max];
        nElems = 0;
    }

    public void insert(long value){
        a[nElems] = value;
        nElems ++;
    }

    public void display(){
        for (int i = 0; i < nElems; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("");
    }

    public void selectionSort(){
        int out, in, min;
        for ( out = 0; out < nElems - 1; out++) {
            min = out;
            for (in = out + 1; in < nElems; in ++){
                if (a[in] < a[min])
                    min = in;
            }
            swap(out, min);
        }
    }

    public void swap(int one, int two){
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }
}
