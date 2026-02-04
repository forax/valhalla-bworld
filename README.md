# valhalla-bworld
Test Valhalla Bang World

## Can use '!' to denote non-null type

For example:
```java
public value record Person(String! name, int age) {
  public Person! withName(String! name) {
    return new Person(name, age);
  }

  static void main() {
    var bob = new Person("Bob", 31);
    IO.println(bob);

    var ana = bob.withName("Ana");
    IO.println(ana);
  }
}
```

## build your JDK

```bash
git clone http://github.com/openjkd/valhalla
```

switch to the bworld branch

```
git switch bworld
```

then build the JDK
```
cd valhalla
bash configure
make images  
```
