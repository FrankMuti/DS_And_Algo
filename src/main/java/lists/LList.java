package lists;

public class LList<E> implements List<E> {

  private Link<E> head;
  private Link<E> tail;
  protected Link<E> curr;

  int cnt;

  // CONSTRUCTORS
  LList(int size) {
    this();
  }

  LList() {
    curr = tail = head = new Link<>(null);
    cnt = 0;
  }

  @Override
  public void clear() {
    head.setNext(null);
    curr = tail = head = new Link<>(null);
    cnt = 0;
  }

  @Override
  public void insert(E item) {
    curr.setNext(new Link<>(item, curr.next()));
    if (tail == curr) {
      tail = curr.next();
    }
    cnt++;
  }

  @Override
  public void append(E item) {
    tail = tail.setNext(new Link<>(item, null));
  }

  @Override
  public E remove() {
    if (curr.next() == null) {
      return null;
    }
    E item = curr.next().element();
    if (tail == curr.next()) {
      tail = curr;
    }
    curr.setNext(curr.next().next());
    cnt--;
    return item;
  }

  @Override
  public void moveToStart() {
    curr = head;
  }

  @Override
  public void moveToEnd() {
    curr = tail;
  }

  @Override
  public void prev() {
    if (curr == head) {
      return;
    }
    Link<E> tmp = head;
    while (tmp.next() != curr) {
      tmp = tmp.next();
    }
    curr = tmp;
  }

  @Override
  public void next() {
    if (curr != tail) {
      curr = curr.next();
    }
  }

  @Override
  public int length() {
    return cnt;
  }

  @Override
  public int currPos() {
    Link<E> tmp = head;
    int i;
    for (i = 0; curr != tmp; i++) {
      tmp = tmp.next();
    }
    return i;
  }

  @Override
  public void moveToPos(int pos) {
    assert (pos >= 0) && (pos <= cnt) : "Position out of range";
    curr = head;
    for (int i = 0; i < pos; i++) {
      curr = curr.next();
    }
  }

  @Override
  public E getValue() {
    if (curr.next() == null) {
      return null;
    }
    return curr.next().element();
  }
}
