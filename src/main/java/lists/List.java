package lists;

/**
 * List ADT
 * @param <E> data type
 */
public interface List<E> {
  public void clear();
  public void insert(E item);
  public void append(E item);
  public E remove();
  public void moveToStart();
  public void moveToEnd();
  public void prev();
}
