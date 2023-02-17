

И так продолжение)))
2. Шаблон Прототип 
— это шаблон проектирования, который позволяет создавать новые объекты путем копирования существующего объекта, а не создавать новые объекты с помощью конструктора класса. Основная идея за шаблоном заключается в том, что вы создаете прототип объекта, а затем используете этот прототип для создания новых экземпляров объекта.
Применяется:
1. когда необходимо много раз создавать новые объекты от одного класса (высаживаем деревья)
2. если объект сложно составной, например внутри другие классы - есть объект Car с характеристиками (Цвет, размер, ДВС, Коробка и др.) 
```
public class Car {
    private String name;
    private String type;
    private String color;
    private Engine engine;
    private Transmission transmission;
}

public class Engine {
    private String name;
    private String type;
    private String cylinders;
    private int power;
}

public class Transmission {
    private String name;
    private String type;
    private int power;
}
```
Шаблон прототипа обычно используется, когда у нас есть экземпляр класса (прототип) и мы хотим создать новые объекты, просто скопировав прототип.

Вообщем это всё понятно и обычно этого достаточно для ответа, но лучше всего понять как он работает! А для этого лучше всего пойти путём советских инженеров - путём экспериментов))).
 


Есть 2 варианта. Первый официальный используя “interface Cloneable” и второй создать самописный интерфейс или абстрактный класс.

Начнем с официального варианта с применением interface Cloneable (я его и рекомендую, меньше писанины)

A class implements the Cloneable interface to indicate to the Object.clone() method that it is legal for that method to make a field-for-field copy of instances of that class.
Invoking Object's clone method on an instance that does not implement the Cloneable interface results in the exception CloneNotSupportedException being thrown.
By convention, classes that implement this interface should override Object.clone (which is protected) with a public method. See Object.clone() for details on overriding this method.
Note that this interface does not contain the clone method. Therefore, it is not possible to clone an object merely by virtue of the fact that it implements this interface. Even if the clone method is invoked reflectively, there is no guarantee that it will succeed.
—
Класс реализует интерфейс Cloneable, чтобы указать методу Object.clone(), что этому методу разрешено создавать полевые копии экземпляров этого класса.
Вызов метода clone объекта для экземпляра, который не реализует интерфейс Cloneable, приводит к возникновению исключения CloneNotSupportedException.
По соглашению классы, реализующие этот интерфейс, должны переопределять Object.clone (который защищен) с помощью общедоступного метода. Подробнее о переопределении этого метода см. в Object.clone().
Обратите внимание, что этот интерфейс не содержит метод клонирования. Следовательно, невозможно клонировать объект только в силу того, что он реализует этот интерфейс. Даже если метод clone вызывается рефлексивно, нет гарантии, что он будет успешным.
```

Для использования interface Cloneable необходимо его имплементировать (implements) в наш класс Car и сделать переопределение (@Override) его метода clone().

Должно получиться так
```
public class Car implements Cloneable {
	…
	…
	@Override
public Object clone() throws CloneNotSupportedException {
       		return super.clone();
    	}
}
```
При самописной реализации нам необходимо создать дополнительный интерфейс (или абстрактный метод) 
```
public interface Clonable {
    public Clonable cloneInterface();
}
```
и так же как interface Cloneable его имплементировать (implements) в наш класс Car и сделать переопределение (@Override) его метода clone()

```
public class Car implements Clonable {
	…
	…

@Override
   	 public Clonable cloneInterface() {
        		return new Car(this.name, this.type, this.color, this.engine, this.transmission);
    	}
}
```

```
!!! в представленных вариантах различный return (1- return super.clone(); 2- return new Car(...)). Еще один плюс использовать официальный вариант  Можете применять любой, **super.clone()** короче и при изменении переменных вам не потребуется вносить правки в метод))) А самое главное не используйте вариант **return this**, как пишут некоторые ГУРУ, это приведёт к тому что вы на создаете множество объектов имеющих одну ссылку и изменяя любой из них вы будите изменять все созданные объекты.
```
И всё))) Шаблон Прототип реализован. Просто правда?

Потренимся…
```
public class Main {
public static void main(String[] args) throws CloneNotSupportedException {
       		System.out.println("Hello world!");

       		Engine engine = new Engine("ДВС1", "Бензиновый двигатель", "4", 123);
       		Transmission transmission = new Transmission("Коробка передач", "4х ступенчатая", 20);
       		Car car = new Car("Лада Приора", "Седан", "Чёрный", engine, transmission);

       		Car car1 = (Car) car.clone(); // официальная реализация
Clonable car2 = car.cloneInterface(); // самописная реализация
	}
}
```
посмотрим на результат выведя его на экран
```
System.out.println(car);
            System.out.println(car1);
System.out.println(car2);
```
Результат ->
```
Car{name='Лада Приора', type='Седан', color='Чёрный', engine=Engine{name='ДВС1', type='Бензиновый двигатель', cylinders='4', power=123}, transmission=Transmission{name='Коробка передач', type='4х ступенчатая', power=20}}
—
Car{name='Лада Приора', type='Седан', color='Чёрный', engine=Engine{name='ДВС1', type='Бензиновый двигатель', cylinders='4', power=123}, transmission=Transmission{name='Коробка передач', type='4х ступенчатая', power=20}}
—
Car{name='Лада Приора', type='Седан', color='Чёрный', engine=Engine{name='ДВС1', type='Бензиновый двигатель', cylinders='4', power=123}, transmission=Transmission{name='Коробка передач', type='4х ступенчатая', power=20}}
```
Визуально они одинаковы, отметим, что мы не переопределяли hashCode() и equals(Object o) в классе Car и мне интересно как будет идти сравнение объектов с ‘equals’ и ‘==’, воспользуемся следующей конструкцией

```
if (car.equals(car1)) {
                System.out.println("car.equals(car1)");
            } else {
                System.out.println("NO car.equals(car1)");
            }
            if (car == car1) {
                System.out.println("car == car1");
            } else {
                System.out.println("NO car == car1");
            }
            if (car.equals(car2)) {
                System.out.println("car.equals(car2)");
            } else {
                System.out.println("NO car.equals(car2)");
            }
            if (car == car2) {
                System.out.println("car == car2");
            } else {
                System.out.println("NO car == car2");
            }            
```
Результаты сравнения без переопределения:
```
NO car.equals(car1)
NO car == car1
NO car.equals(car2)
NO car == car2

```
Результат показывает, что эти 3 объекта абсолютно различны, хоть и  клонированы от одного объекта без изменений.
А теперь переопределим hashCode() и equals(Object o)
```
@Override
public boolean equals(Object o) {
if (this == o) return true;
if (o == null || getClass() != o.getClass()) return false;
Car car = (Car) o;
return Objects.equals(name, car.name) && Objects.equals(type, car.type) && Objects.equals(color, car.color) && Objects.equals(engine, car.engine) && Objects.equals(transmission, car.transmission);
}

@Override
public int hashCode() {
int hash = 17; // объявляем и инициализируем переменную hash
if (name != null) { // проверяем значение первого поля
hash = name.hashCode(); // вычисляем хеш первого поля
}
if (type != null) { // проверяем значение второго поля
hash = hash + type.hashCode(); // вычисляем хеш второго поля и общий хеш
}
if (color != null) { // проверяем значение второго поля
hash = hash + color.hashCode(); // вычисляем хеш второго поля и общий хеш
}
if (engine != null) { // проверяем значение второго поля
hash = hash + engine.hashCode(); // вычисляем хеш второго поля и общий хеш
}
if (transmission != null) { // проверяем значение второго поля
hash = hash + transmission.hashCode(); // вычисляем хеш второго поля и общий хеш
}
return hash; // возвращаем хеш
}
```
, и получим…
```
car.equals(car1) // Объекты имеют одинаковые значения
NO car == car1  // Объекты имеют разные ссылки
car.equals(car2) // Объекты имеют одинаковые значения
NO car == car2 // Объекты имеют разные ссылки
```
С предопределенными методами имеем правильный результат:
при сравнении оператором ‘==’ сравниваются ссылки на объекты и в нашем случае они не равны, что говорит о том, что наши объекты различны
а при сравнении ‘equals’ приходит результат **true**
Как вывод - обязательно переопределяйте методы hashCode() и equals(Object o).

