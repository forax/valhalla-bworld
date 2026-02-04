void main() {
  value record Complex(float re, float im) {}

  var array = new Complex![] { new Complex(1, 2) };
  array[0] = null;
}

