package DataArray;

public class MyArr {
    private PersonArr[] arr;
    private int size;

    public MyArr(int s){
        this.size = 0;
        this.arr = new PersonArr[size];
    }

    public void insert(String name, int age){
       this.arr[this.size] = new PersonArr(name, age);
       this.size++;

    }

    public void delete(String search){
        int i = 0;
        for ( i = 0; i < this.size ; i++) {
            if (this.arr[i].getName().equals(search))
                break;
        }
        for (int j = i; j < this.size - 1 ; j++) {
            this.arr[j] = this.arr[j + 1];
        }
        this.size --;
    }

    public int getSize(){
        return this.size;
    }
    public void display(){
        for (int i = 0; i <this.size ; i++) {
            System.out.print(this.arr[i].getName() + " " + this.arr[i].getAge());
        }
        System.out.println("");
    }

    public boolean find(String search){
        int i;
        for ( i = 0; i < this.size; i++){
            if (this.arr[i].getName().equals(search))
                break;
        }
        if (i == this.size)
            return false;
        else
            return true;
    }

//    public boolean binaryFind(int value){
//        int low = 0;
//        int high = this.size -1;
//        int mid;
//
//        while (low <= high){
//            mid = (low + high)/2;
//            if (value == this.arr[mid])
//                return true;
//            else{
//                if (value < this.arr[mid]){
//                    high = mid - 1;
//                }
//                else
//                    low = mid + 1;
//            }
//        }
//        return false;
//    }
}
