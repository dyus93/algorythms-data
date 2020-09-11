package DataArray;

public class ArrayInOb {
    private Person[] a;
    private int nElems;

    public ArrayInOb(int max){
        a = new Person[max];
        nElems = 0;
    }

    public void insert(String last, String first, int age){
        a[nElems] = new Person(last, first, age);
        nElems++;
    }

    public void display(){
        for (int i = 0; i <nElems ; i++) {
            a[i].displayPerson();
        }
        System.out.println("");
    }

    public void insertionSort(){
        int in, out;
        for ( out = 1; out <nElems ; out++) {   //out разделительный маркер
            Person temp = a[out];               //Скопировать помеченный элемент
            in= out;                            //Начать перемещения с out

            while(in > 0 &&                     //Пока не найден помеченный элемент
                a[in -1].getLast().compareTo(temp.getLast()) > 0){
                a[in] = a[in - 1];              //Сдвинуть эленменрт вправо
                --in;                           //Перейти на один элемент влево
            }
            a[in] = temp;                       //Вставить помеченный элемент
        }
    }
}
