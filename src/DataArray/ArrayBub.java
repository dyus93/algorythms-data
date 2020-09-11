package DataArray;

public class ArrayBub {
    private long[] a;
    private int nElems;

    public ArrayBub(int max){
        a = new long[max];
        nElems = 0;
    }

    public void insert(long value){
        a[nElems] = value;
        nElems++;
    }

    public void display(){
        for (int i = 0; i < nElems ; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("");
    }

    public void bubbleSort(){
        int in, out;
        for (out = this.nElems - 1; out > 1; out--){
            for (in = 0; in < out; in++ ){
                if (this.a[in] > this.a[in + 1])
                    swap(in, in + 1 );
            }
        }
    }

    public void swap(int one, int two){
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }
}
