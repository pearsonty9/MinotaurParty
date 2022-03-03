import java.util.*;

public class Guest extends Thread {

  Minotaur host;
  int number;
  int count = 0; // the number of times the thread has entered the room

  public Guest(Minotaur host, int num) {
    this.host = host;
    this.number = num;
  }

  public void run() {
    while(count < 10) {
      if (host.flag.compareAndSet(true, false)) {
        try {
          host.lock.lock();
          host.counter++;
          count++;
          host.flag.set(true);
        }
        finally {
          host.lock.unlock();
        }
      }
    }
  }
}
