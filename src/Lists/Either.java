package Lists;

import java.util.function.Function;

public class Either<A, B> {

  public <T> Either<A, T> map(Function<B, T> f) {
    if (this instanceof Left) {
      return (Left<A, T>) this;
    } else {
      return new Right<>(f.apply(((Right<A, B>) this).value));
    }
  }

  public static class Left<A, B> extends Either<A, B> {
    public A value;
    public Left(A value) {
      this.value = value;
    }
  }

  public static class Right<A, B> extends Either<A, B> {
    public B value;
    public Right(B value) {
      this.value = value;
    }
  }
}
