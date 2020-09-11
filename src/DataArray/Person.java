package DataArray;

public class Person {
    private String lastName;
    private String firstName;
    private int age;

    public Person(String last, String first, int a){
        lastName = last;
        firstName = first;
        age = a;
    }
    public void displayPerson(){
        System.out.print(" Фамилия: " + lastName);
        System.out.print(". Имя: " + firstName);
        System.out.println(" Возраст: " + age);
    }
    public String getLast(){
        return lastName;
    }
}
