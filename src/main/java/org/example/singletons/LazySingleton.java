package org.example.singletons;

/**
 * Плюсы:
 * <p>-Ленивая инициализация.
 * <p>Минусы:
 * <p>-Не потокобезопасно
 * <p>Реализация интересна. Мы можем инициализироваться лениво, но утратили потокобезопасность.
 */
public class LazySingleton {
    private static LazySingleton INSTANCE;

    private LazySingleton() {}

    public static LazySingleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LazySingleton();
        }
        return INSTANCE;
    }
}
