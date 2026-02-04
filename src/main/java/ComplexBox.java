// Layout of class ComplexBox@0x6000004ec0a0 extends java/lang/Object@0x6000004e4000
//Instance fields:
// @0 RESERVED 12/-
// @12 EMPTY 4/1
// @16 FLAT 8/8 "complex" LComplexBox$Complex; ComplexBox$Complex@0x6000004ec0a0 NULL_FREE_ATOMIC_FLAT
//Static fields:
// @0 RESERVED 120/-
//Instance size = 24 bytes

public class ComplexBox {
  public value record Complex(int re, int im) {}

  private Complex! complex;

  public ComplexBox(Complex! complex) {
    this.complex = complex;
    super();
  }

  @Override
  public String toString() {
    return "ComplexBox (" + complex + ")";
  }

  // -XX:+UnlockDiagnosticVMOptions -XX:+PrintInlineLayout
  static void main() {
    var complex = new Complex(2, 1);
    var box = new ComplexBox(complex);

    IO.println(box);
  }
}
