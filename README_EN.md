# GenericList<T>

`GenericList<T>` is a generic data structure developed in Java as a lightweight and flexible alternative to `ArrayList<T>`. It automatically manages internal array resizing, supports comparison, sorting, streaming, and iteration.

## Features

- 📦 **Dynamic Storage**: Automatically resizes when full.
- 🔄 **Iterable Support**: Implements `Iterable<T>` for enhanced for-loops.
- 📊 **Comparable Support**: Implements `Comparable<GenericList<T>>` for comparing lists by their elements.
- 💧 **Stream API Ready**: Easily converted to Java Stream API.
- 🧹 **Easy Clearing**: Reset the list to initial state using `clear()`.
- 🔁 **Conversion to List**: Convert to standard `java.util.List<T>` easily.

## Usage

```java
GenericList<Integer> list = new GenericList<>();
list.add(10);
list.add(5);
list.add(15);

System.out.println(list);         // [10, 5, 15]
System.out.println(list.get(1));  // 5
System.out.println(list.size());  // 3
System.out.println(list.length()); // 10 or more depending on resizing
```

### Iteration

```java
for (Integer value : list) {
    System.out.println(value);
}
```

### Comparison

```java
GenericList<Integer> a = new GenericList<>();
a.add(1); a.add(2);

GenericList<Integer> b = new GenericList<>();
b.add(1); b.add(3);

System.out.println(a.compareTo(b)); // < 0 because 2 < 3
```

### Stream Conversion

```java
list.stream().filter(x -> x > 7).forEach(System.out::println);
```

## Strengths

- **Flexible auto-resizing** without manual array reallocation.
- **Familiar interface** for Java developers thanks to `Iterable`, `Comparable`, and `Stream` support.
- **Clean and maintainable code** ideal for learning and extending.

## License

This project is licensed under the [GNU General Public License v3.0](https://www.gnu.org/licenses/gpl-3.0.html).

> This means you are free to use, modify, and distribute the code as long as you retain the same license when distributing.

---

This class was developed in Java 💛 with learning and flexible data structure design in mind.