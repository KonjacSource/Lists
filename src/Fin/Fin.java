package Fin;
import Nats.*;

public class Fin<N extends Nat> {
  private Fin() {}

  public static class FZ<N extends Nat> extends Fin<S<N>> {
    private FZ() {}
    public static <K extends Nat> FZ<K> fz() { return new FZ<>(); }
  }

  public static class FS<N extends Nat> extends Fin<S<N>> {
    private final Fin<N> pre;
    private FS(Fin<N> pre) { this.pre = pre; }
    public Fin<N> getPre() { return pre; }
    public static <K extends Nat> FS<K> fs(Fin<K> pre) { return new FS<K>(pre); }
  }

}
