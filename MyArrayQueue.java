//c21012668
/** a queue class that uses a one-dimensional array */

public class MyArrayQueue
{
   // data members
   int front;          // one counterclockwise from first element
   int rear;           // position of rear element of queue
   Object [] queue;    // element array

   // constructors
   /** create a queue with the given initial capacity */
   public MyArrayQueue(int initialCapacity)
   {
      if (initialCapacity < 1)
         throw new IllegalArgumentException
               ("initialCapacity must be >= 1");
      queue = new Object [initialCapacity + 1];
      // default front = rear = 0
   }

   /** create a queue with initial capacity 5 */
   public MyArrayQueue()
   {// use default capacity of 5
      this(5);
   }

   // methods
   /** @return true iff queue is empty */
   public boolean isEmpty()
      {return front == rear;}


   /** @return front element of queue
     * @return null if queue is empty */
   public Object getFrontElement()
   {
      if (isEmpty())
         return null;
      else
         return queue[(front + 1) % queue.length];
   }

   /** @return rear element of queue
     * @return null if the queue is empty */
   public Object getRearElement()
   {
      if (isEmpty())
         return null;
      else
         return queue[rear];
   }

   /** insert theElement at the rear of the queue */
   public void enqueue(Object theElement)
   {
	  // Add your code here
    //Step 1 − Check if the queue is full.

    if(rear-front ==  queue.length - 1) { //**** to check if queue is full
      int double_queue_length = 2 * queue.length;
      Object[] queue2 = new Object[double_queue_length];
      // copy all elements
      System.arraycopy(queue, 0, queue2, 0, queue.length);
      queue = null;
      queue = queue2;
      rear = rear + 1;
      queue[rear] = theElement;
      System.out.print("enqueued : ");
      System.out.println(theElement);

    } else {
      rear = rear + 1;
      queue[rear] = theElement;
      System.out.print("enqueued : ");
      System.out.println(theElement);


    }

    //Step 2 − If the queue is full, produce overflow error and exit.

    //Step 3 − If the queue is not full, increment rear pointer to point the next empty space.

    //Step 4 − Add data element to the queue location, where the rear is pointing.


    //Step 5 − return success.

   }

   /** remove an element from the front of the queue
     * @return removed element */
   public Object dequeue()
   {
	   // Add your code here
     if(isEmpty()) {
       System.out.println("Could not dequeue since queue has no elements.");
       return null;
     } else {
      /* System.out.print("rear :");
         System.out.println(rear);
       System.out.print("front :");
       System.out.println(front);
         System.out.print("queue length - 1: ");
         System.out.println(queue.length - 1 ); */
       Object previous_front = queue[front+1];

       Object[] queue2 = new Object[queue.length];
       // copy all elements except element at getFrontElement()
       queue2[0] = 0; //set to zero since null cannot be compared with other objects
       queue[0] = 0;
       boolean element_front = false;
      for (int i = 0; i < queue2.length; i++) {

        if(element_front == false) {
        if(!(queue[i].equals(getFrontElement()))) { //when we reach the element at the front, we must remove it
         queue2[i] = queue[i];                      //This means in the new array we create it won't be included
       } else {
         element_front = true;

       }
     } else {
       queue2[i-1] = queue[i]; //set elements at -1 the position they would have been in since front element is removed
     }
      }

      for (int i = 0; i < queue2.length; i++) {
        if(queue2[i] == null) {   //again null cannot be compared so is set to zero
          queue2[i] = 0;
        }
      }

      queue = null;
      queue = queue2; //give back modified elements to original queue

      rear--; //rear pointer now points to last entered element


      return previous_front;



     }
     //Step 1 − Check if the queue is empty.

    // Step 2 − If the queue is empty, produce underflow error and exit.

    // Step 3 − If the queue is not empty, access the data where front is pointing.

     //Step 4 − Return object at front.
   }

   /** test program */
   public static void main(String [] args)
   {
      MyArrayQueue q = new MyArrayQueue(3);
      // add a few elements
      q.enqueue("element1");	//q.put(new Integer(1));
      q.enqueue("element2");	//q.put(new Integer(2));
      q.enqueue("element3");	//q.put(new Integer(3));
      q.enqueue("element4");	//q.put(new Integer(4));

      // remove and add to test wraparound array doubling
      q.dequeue();
      q.dequeue();
      q.enqueue("element5");	//q.put(new Integer(5));
      q.enqueue("element6");	//q.put(new Integer(6));
      q.enqueue("element7");	//q.put(new Integer(7));
      q.enqueue("element8");	//q.put(new Integer(8));
      q.enqueue("element9");	//q.put(new Integer(9));
      q.enqueue("element10");	//q.put(new Integer(10));
      q.enqueue("element11");	//q.put(new Integer(11));
      q.enqueue("element12");	//q.put(new Integer(12));

      // delete all elements
      while (!q.isEmpty())
      {
      	  System.out.println("Rear element   : " + q.getRearElement());
    	  System.out.println("Front element  : " + q.getFrontElement());
    	  System.out.println("Removed element: " + q.dequeue() + "\n");
      }
	  if (q.isEmpty()) System.out.println("empty queue");
   }
}
