package org.example.singletons;

/**
 * Самая простая реализация.
 * <p>Плюсы:
 * <p>-Простота и прозрачность кода
 * <p>-Потокобезопасность
 * <p>-Высокая производительность в многопоточной среде
 * <p>Минусы:
 * <p>-Не ленивая инициализация.
 */
public class Singleton {
    private static final Singleton INSTANCE = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return INSTANCE;
    }
}
