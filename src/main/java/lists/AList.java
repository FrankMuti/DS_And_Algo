package lists;

/**
 * Array-based list implementation
 *
 * @param <E>
 */
public class AList<E> implements List<E> {

  private static final int defaultSize = 10; // Default size
  private final int maxSize;             // Maximum size of list
  private int listSize;                  // Current number of list items
  private int curr;                      // Position of current element
  private final E[] listArray;           // Array holding list elements

  // BEGIN CONSTRUCTORS

  /**
   * Create a list with the default capacity
   */
  AList() {
    this(defaultSize);
  }

  /**
   * Create a new list object
   *
   * @param size Max no. of elements a list can contain.
   */
  @SuppressWarnings("unchecked")
  // Generic Array allocation
  AList(int size) {
    maxSize = size;
    listSize = curr = 0;
    listArray = (E[]) new Object[size]; // Create listArray
  }

  // END CONSTRUCTORS

  @Override
  public void clear() {                 // Reinitialize the list
    listSize = curr = 0;                // Simply reinitialize values
  }

  /**
   * Insert "item" at the curent position
   *
   * @param item, The item to be inserted
   */
  @Override
  public void insert(E item) {
    assert listSize < maxSize : "List capacity exceeded";
    for (int i = listSize; i > curr; i--) {
      listArray[i] = listArray[i - 1];  // Shift elements up to make room
    }
    listArray[curr] = item;
    listSize++;                         // Increment list size
  }

  /**
   * Append "item" to list
   *
   * @param item The element to be appended
   */
  @Override
  public void append(E item) {
    assert listSize < maxSize : "List capacity exceeded";
    listArray[listSize++] = item;
  }

  /**
   * Remove and return the current element
   *
   * @return The current element
   */
  @Override
  public E remove() {
    if ((curr < 0 || curr >= listSize)) // No current element
      return null;
    E it = listArray[curr];             // Copy the element
    //noinspection ManualArrayCopy
    for (int i = curr; i < listSize - 1; i++) { // Shift them down
      listArray[i] = listArray[i + 1];
    }
    listSize--;                         // Decrement size
    return it;
  }

  @Override
  public void moveToStart() {
    curr = 0;                           // Set to front
  }

  @Override
  public void moveToEnd() {
    curr = listSize;                    // Set at end
  }

  @Override
  public void prev() {
    if (curr != 0) {
      curr--;                           // Back up
    }
  }

  @Override
  public void next() {
    if (curr < listSize) {
      curr++;
    }
  }

  /**
   * @return List size
   */
  @Override
  public int length() {
    return listSize;
  }

  /**
   * @return Current position
   */
  @Override
  public int currPos() {
    return curr;
  }

  /**
   * Set current list position to "pos"
   *
   * @param pos The position to make current.
   */
  @Override
  public void moveToPos(int pos) {
    assert (pos >= 0 && pos <= listSize) : "Pos out of range";
    curr = pos;
  }

  @Override
  public E getValue() {
    assert (curr >= 0 && curr < listSize) : "No current element";
    return listArray[curr];
  }
}
