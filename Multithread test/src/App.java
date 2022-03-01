class Car implements Runnable {

    public Thread thread;

    public Car(String name){
        thread = new Thread(this, name);
        thread.start();
    }

    public void run(){

        System.out.println("I'm running a " + thread.getName());

    }

}

public class App {
    public static void main(String[] args) throws Exception {
       
        Car car = new Car("Toyota");

        System.out.println("STATUS = " + car.thread.getState());
        
        car.thread.join();
        
        System.out.println("STATUS = " + car.thread.getState());
        
        System.out.println("come back to main...");

        car.thread.join();

        System.out.println("STATUS = " + car.thread.getState());

        car.thread.join();

        System.out.println("STATUS = " + car.thread.getState());

        System.out.println("Finishing the program...");
    }
}
