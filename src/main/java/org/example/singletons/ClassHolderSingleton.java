package org.example.singletons;

/**
 * Плюсы:
 * <p>-Ленивая инициализация.
 * <p>-Потокобезопасность.
 * <p>-Высокая производительность в многопоточной среде.
 * <p>Минусы:
 * <p>-Для корректной работы необходима гарантия, что объект класса Singleton инициализируется без ошибок.
 * Иначе первый вызов метода getInstance закончится ошибкой ExceptionInInitializerError, а все последующие
 * NoClassDefFoundError.</p>
 *  <p>Реализация практически идеальная. И ленивая, и потокобезопасная, и быстрая. Но есть нюанс, описанный
 *  в минусе.
 */
public class ClassHolderSingleton {
    private ClassHolderSingleton() {
    }

    private static class SingletonHolder {
        public static final ClassHolderSingleton HOLDER_INSTANCE = new ClassHolderSingleton();
    }

    public static ClassHolderSingleton getInstance() {
        return SingletonHolder.HOLDER_INSTANCE;
    }
}
