package lists;

/**
 * Singly linked list node
 * @param <E> data type
 */
class Link<E> {
  private E element;                    // Value for this node
  private Link<E> next;                 // Pointer to next node in list

  // Constructors
  Link(E it, Link<E> nextVal) {
    element = it;
    next = nextVal;
  }

  Link(Link<E> nextVal) {
    next = nextVal;
  }

  Link<E> next() {                      // Return next value
    return next;
  }

  Link<E> setNext(Link<E> nextVal) {    // Set next field
    return next = nextVal;
  }

  E element() {                         // Return element field
    return element;
  }

  E setElement(E it) {                  // Set element field
    return element = it;
  }
}
