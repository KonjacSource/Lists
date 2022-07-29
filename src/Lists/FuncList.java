package Lists;

import java.util.function.*;

public class FuncList {
  public static <HeadT, TailT>
    Function<BiFunction<HeadT, TailT, Either<HeadT, TailT>>, Either<HeadT, TailT>>
    cons(HeadT head, TailT tail) {
    return c -> c.apply(head, tail);
  }

  public static void main(String[] args) {
    var ls_ = cons(1, cons(2, cons(3, null)));
    int n = (Integer) ((Either.Left) ls_.apply((h, t) -> new Either.Left<>(h))) . value;
    System.out.println(n);
  }
}
