//interface Abs {
//    void hello();
//}
//
//class Test implements Abs{
//    @Override
//    public void hello() {
//        System.out.println("Hello, Interface!");
//    }
//
//    public static void main(String[] args) {
//        Test t = new Test();
//        t.hello();
//    }
//}

//class Vehicle {
//    String name = "Mercedes Benz";
//}
//class Car extends Vehicle{
//    String carName = "Audi";
//
//    public static void main(String[] args) {
//        Car c = new Car();
//        System.out.println(c.name);
//        System.out.println(c.carName);
//    }
//}

import java.lang.reflect.Array;
import java.util.ArrayList;

class Test {
    public static void main(String[] args) {
        int arr[] = {10, 20, 30, 40};
        for (int i = 0; i <= arr.length-1; i++){
            System.out.println(arr[i]);
        }
    }
}