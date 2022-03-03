The two problems are divided into their own folders.

To run either problem navigate inside the folder and run:
javac Minotaur.java
java Minotaur

Problem 1:
  The solution implemented in this problem is the one we discussed in class for
  the prisoner problem.

  It is hard coded to use 100 threads to represents 100 guests

  The minotaur starts each thread.
  Each thread the tries to acquire the lock to enter the critical section which
  is the theoretical maze. I let the cpu scheduler be the one to let threads into
  the maze by deciding which threads get to the critical section first.

  The main idea behind the solution is that thread 0 will count the number of times
  it enters the maze and sees that there is no cake left. This will represent
  that a new thread has entered the maze for the first time.
  All the other threads will only eat the cake if it is their first time and if
  there is no cake they will not do anything.
  The only person that can restock the cake is thread 0.

  There are a couple inefficiencies with this solution. In theory if thread 0 never
  gets to enter the maze there can be a lot of threads entering and reentering
  the maze that can't count it as their first time because there is no cake.

Problem 2:
  For this problem I chose to implement solution 2, which is having a sign that
  is set to busy when someone is in the room and gets changed to available when they leave.

  I chose this solution as I thought it would allow for threads to be able to continue
  running and completing other computation while waiting for the room to be available.
  Having a sign that says if the room is available means that a thread doesn't get stuck waiting
  for a lock when there is already a thread in the critical section.

  The obvious downside to this is that there is a chance that a thread doesn't check
  the room when it is available and has to wait a long time before seeing that the room
  is open. If a guests see's that the room it busy every time they go back to check
  then they can be waiting a long time before they have a chance to enter.

  I have hard coded there to be 16 guests and created the condition, that guests
  will stop trying to enter the room after they have already entered 10 times just
  so that there is a point where the simulation stops.

  Similar to problem 1 I have the scheduling algorithm determine the randomness of
  who and when checks if the room it available.

  Inside the room I have each guest increment a counter for themselves as well as
  increment a counter for the host. This allows us to know how many times each guest
  has entered so we can stop as well as a total amount of times a guest has entered the room.
