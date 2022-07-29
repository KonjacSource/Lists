package Lists;
// type level list
public class TList {
  private TList(){}

  public static class TNil extends TList { private TNil(){} }

  public static class TCons<Head, Tail extends TList> extends TList { private TCons(){} }
}

