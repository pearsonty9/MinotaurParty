import java.util.*;

public class Guest extends Thread {

  Minotaur host;
  int number;
  int count = 0; // number of guests that have been in the maze, counted by thread 0
  boolean flag = false; // represents if the guest has already been in the maze

  public Guest(Minotaur host, int num) {
    this.host = host;
    this.number = num;
  }

  public void run() {
    while(!host.done.get()) {
      try {
        host.lock.lock();
        host.counter++;
        if (!flag && host.flag) {
          host.flag = false;
          flag = true;
        }
        if (number == 0) {
          // Case where there is no cake
          if (!host.flag) {
            count++;
            host.flag = true;
          }
          if (count == host.n) {
            host.done.set(true);
          }
        }
      }
      finally {
        host.lock.unlock();
      }
    }
  }
}
