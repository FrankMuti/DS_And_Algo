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

  }

  @Override
  public void append(E item) {

  }

  @Override
  public E remove() {
    return null;
  }

  @Override
  public void moveToStart() {

  }

  @Override
  public void moveToEnd() {

  }

  @Override
  public void prev() {

  }

  @Override
  public void next() {

  }

  @Override
  public int length() {
    return 0;
  }

  @Override
  public int currPos() {
    return 0;
  }

  @Override
  public void moveToPos(int pos) {

  }

  @Override
  public E getValue() {
    return null;
  }
}
