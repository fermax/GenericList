# GenericList<T>

`GenericList<T>` هي بنية بيانات عامة (Generic) تم تطويرها بلغة Java لتكون بديلًا خفيفًا ومرنًا لـ `ArrayList<T>`، وتتميز بأنها تدير النمو الداخلي للمصفوفة عند امتلائها، وتدعم المقارنة والفرز والبث (Stream) والتكرار (Iteration).

## الميزات

- 📦 **تخزين ديناميكي**: تنمو تلقائيًا عندما تمتلئ.
- 🔄 **دعم التكرار**: عبر تنفيذ `Iterable<T>`.
- 📊 **دعم المقارنة**: عبر تنفيذ `Comparable<GenericList<T>>`، للمقارنة حسب ترتيب العناصر.
- 💧 **دعم Stream API**: يمكن تحويلها إلى `Stream<T>`.
- 🧹 **تنظيف مرن**: يمكن إعادة تهيئة القائمة باستخدام `clear()`.
- 🔁 **تحويل إلى List**: يمكن تحويلها إلى `java.util.List<T>` بسهولة.

## الاستخدام

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

### التكرار

```java
for (Integer value : list) {
    System.out.println(value);
}
```

### المقارنة

```java
GenericList<Integer> a = new GenericList<>();
a.add(1); a.add(2);

GenericList<Integer> b = new GenericList<>();
b.add(1); b.add(3);

System.out.println(a.compareTo(b)); // < 0 لأن 2 < 3
```

### التحويل إلى Stream

```java
list.stream().filter(x -> x > 7).forEach(System.out::println);
```

## نقاط القوة

- **مرونة التوسعة الذاتية** دون الحاجة للتعامل مع إعادة تخصيص المصفوفات يدويًا.
- **واجهة مألوفة** لمطوري Java بفضل دعم `Iterable`, `Comparable`, و`Stream`.
- **كود نظيف ومقروء** يسهل صيانته وتطويره لاحقًا.

## الترخيص

تم ترخيص هذا المشروع تحت رخصة [GNU General Public License v3.0](https://www.gnu.org/licenses/gpl-3.0.html).

> هذا يعني أنك حر في استخدام وتعديل وتوزيع الكود، بشرط أن تحتفظ بنفس الترخيص عند التوزيع.

---

تم تطوير هذا الكلاس باستخدام Java 💛، بهدف التعلم وتوفير بدائل مرنة لبنى البيانات التقليدية.
