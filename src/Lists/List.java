package Lists;

public class List<A> {

  public static class Nil<A> extends List<A> {}

  public static class Cons<A> extends List<A> {
    public A head;
    public List<A> tail;

    public Cons(A head, List<A> tail) {
      this.head = head;
      this.tail = tail;
    }
  }
}
