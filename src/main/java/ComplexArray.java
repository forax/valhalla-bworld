void main() {
  value record Complex(float re, float im) {}

  var array = new Complex![] { new Complex(1, 2) };
  // array[0] = null;  // NPE!

  var ACC_NULL_CHECKED = 0X200;
  var copy = (Complex[]) Array.newInstance(Complex.class, ACC_NULL_CHECKED, 1,
      array, 0);
  // copy[0] = null;  // NPE!
}

