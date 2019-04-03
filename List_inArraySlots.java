/**
  Implement a list of integer elements, including
  both data and operations.
 */

public class List_inArraySlots {

    // declare fields here

	private int[] list;
	private int numberOfElements;

	private static final int INITIAL_CAPACITY = 10;


    /**
      Construct an empty list with a small initial capacity.
     */
  public List_inArraySlots() {
		list = new int[INITIAL_CAPACITY];
  }


  /**
    @return the number of elements in this list
   */
  public int size() {
    return numberOfElements;
  }


   /**
     @return a string representation of this list,
     in [a,b,c,] format
    */
	public String toString() {
		String result = "[";
		for( int elemIndex = 0; elemIndex < filledElements; elemIndex++)
    	result += elements[ elemIndex] + ",";
		return result + "]";
	}


  /**
    Appends @value to the end of this list.

    @return true, in keeping with conventions yet to be discussed
   */
  public boolean add( int value) {
    if(numberOfElements == list.length) expand();
    list[numberOfElements++] = value;
		return true;
  }

	public void addAsHead( int value) {
		add(0, value);
	}


  /**
    Double the capacity of the List_inArraySlots,
    preserving existing data
   */
  private void expand() {
      // System.out.println( "expand... (for debugging)");
  	int[] doubledArray = new int[list.length * 2];
    for(int i = 0; i < numberOfElements; i++){
      doubledArray[i] = list[i];
    }
    list = doubledArray;
 // /* S.O.P. rules for debugging:
            // Working methods should be silent. But during
            // development, the programmer must verify that
            // this method is called when that is appropriate.
            // So test using the println(), then comment it out.
            // */
   }

  /**
    accessor
    @return element @index from this list
    precondition: @index is within the bounds of the array.
        (Having warned the user about this precondition,
         you should NOT complicate your code to check
         whether user violated the condition.)
   */
  public int get(int index) {
		return list[index];
  }

  /**
    Set value at @index to @newValue
    @return old value at @index
    @precondition: @index is within the bounds of this list.
   */
  public int set(int index, int newValue) {
		int oldValue = list[index];
		list[index] = newValue;
		return oldValue;
  }

  /**
    Remove the element at position @index in this list.
    Shift any subsequent elements to the left (that is,
    decrease the index associated with each).
    @return the value that was removed from the list
  */
  public int remove (int index) {
		int oldValue = list[index];
		int[] newArray = new int[list.length - 1];
		for(int i = 0; i < numberOfElements; i++) {
		    if (i < index) {
					newArray[i] = list[i];
		    }
		    else {
					newArray[i] = list[i+1];
		    }
		}
		list = newArray;
		numberOfElements -= 1;
		return oldValue;
  }

  /**
    Insert @value at position @index in this list.
    Shift the element currently at that position (if any)
    and any subsequent elements to the right
    (that is, increase the index associated with each).
  */
  public void add( int index, int value) {
  	add(list[numberOfElements - 1]);
		for(int i = numberOfElements - 2; i > index; i--){
    	list[i] = list[i - 1];
		}
		list[index] = value;
  }

}
