import java.util.concurrent.locks.*;
import java.util.concurrent.atomic.AtomicBoolean;


public class Minotaur {

  public static AtomicBoolean done = new AtomicBoolean(false);
  public static boolean flag = true;
  public static int n = 0;
  public static int counter = 0;
  public static ReentrantLock lock = new ReentrantLock();

  public static void main (String[] args) {
    n = 100;
    Guest[] guests = new Guest[n];
    Minotaur host = new Minotaur();

    for (int i = 0; i < n ; i++) {
      guests[i] = new Guest(host, i);
      guests[i].start();
    }

    while(!host.done.get()) {}
    System.out.println("All guests have entered the maze ");
    System.out.println("Total times a guest entered the maze " + counter);
  }
}
