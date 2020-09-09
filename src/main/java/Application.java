/**
 * The main class of application
 * @author Pshenichnov Pavel
 * @version 1.0
 */
public class Application {

    public static void main(String[] args) {

        //Printer.print();

        Resource resource = new Resource();
        Resource.i = 2;
        MyThread myThread1 = new MyThread("one");
        MyThread myThread2 = new MyThread("two");
        myThread1.setResource(resource);
        myThread2.setResource(resource);
        myThread1.start();
        myThread2.start();
        try {
            myThread1.join();
            myThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(resource.i);
    }
}

class MyThread extends Thread{

    private Resource resource;
    private String name;

    MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        resource.incrementI();
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }
}
class Resource {

    static int i;

    public void incrementStaticI() {
        synchronized (Resource.class) {
            int j = i;
            j++;
            i = j;
        }
    }

    public synchronized void incrementI() {
        int j = i;
        j++;
        i = j;
    }
}