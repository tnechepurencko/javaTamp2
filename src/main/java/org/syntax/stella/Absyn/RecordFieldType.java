// File generated by the BNF Converter (bnfc 2.9.4.1).

package org.syntax.stella.Absyn;

public abstract class RecordFieldType implements java.io.Serializable {
  public abstract <R,A> R accept(RecordFieldType.Visitor<R,A> v, A arg);
  public interface Visitor <R,A> {
    public R visit(org.syntax.stella.Absyn.ARecordFieldType p, A arg);

  }

}
