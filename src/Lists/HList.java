package Lists;
import static Lists.TList.*;

public class HList<Ts extends TList> {

  public static class HNil extends HList<TNil> {}

  public static class HCons<HeadT, Tail extends TList> extends HList<TCons<HeadT, Tail>> {

    public HeadT head;
    public HList<Tail> tail;

    public HCons(HeadT head, HList<Tail> tail) {
      this.head = head;
      this.tail = tail;
    }
  }

  public boolean empty() {
    return this instanceof HNil;
  }

  public static <HeadT, Tail extends TList> HList<TCons<HeadT, Tail>> cons(HeadT head, HList<Tail> tail) {
    return new HCons<>(head, tail);
  }

  public static <Ts extends TList> int length(HList<Ts> ls) {
    if (ls.empty()) {
      return 0;
    } else {
      HCons<?, ?> ls_ = (HCons<?, ?>) ls;
      return 1 + length(ls_.tail);
    }
  }

  public static void main(String[] args) {
    HList<TCons<String, TCons<Integer, TCons<Boolean, TNil>>>>
      ls = cons("hello", cons(3, cons(true, new HNil())));
    var ls2 = cons(3, ls);
    System.out.println(((HCons<String, TCons<Integer, TCons<Boolean, TNil>>>) ls).head);
  }
}
