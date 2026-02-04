public value record Person(String! name, int age) {
  public Person! withName(String! name) {
    return new Person(name, age);
  }

  static void main() {
    var bob = new Person("Bob", 31);
    IO.println(bob);

    IO.println(bob.name());

    var ana = bob.withName("Ana");
    IO.println(ana);
  }
}
