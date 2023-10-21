package Lists;

import Fin.*;
import static Fin.Fin.*;

import Nats.*;


public class Vec<A, Len extends Nat> {
  private Vec() {}

  public static class Nil<A> extends Vec<A, Z> { public Nil() {} }

  public static class Cons<A, N extends Nat> extends Vec<A, S<N>> {
    private final A val;
    private final Vec<A, N> tail;
    public Cons(A a, Vec<A, N> tail) { val = a; this.tail = tail; }
    public A get() { return val; }
    public Vec<A, N> tail() { return tail; }
  }

  public static <A> Vec<A, Z> nil() { return new Nil<>(); }

  public static <A, N extends Nat> Vec<A, S<N>> cons(A a, Vec<A, N> tail) { return new Cons<>(a, tail); }

  public static <A, Len extends Nat> A index(Vec<A, Len> vect, Fin<Len> fin) {
    if (fin instanceof FZ) {
      return ((Cons<A, Len>) vect) .get();
    } else if (fin instanceof FS){ // fin instanceof FS
      return index(((Cons<A, Len>) vect).tail(), ((FS<Len>) fin).getPre());
    } else {
      // Unreachable. But java can't see.
      throw new ClassCastException("???");
    }
  }

  public A unsafeIndex(int i) {
    if (i == 0) return ((Cons<A, ?>) this).get();
    else        return ((Cons<A, ?>) this).tail().unsafeIndex(i - 1);
  }

}

