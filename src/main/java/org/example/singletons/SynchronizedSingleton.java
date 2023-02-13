package org.example.singletons;

/**
 * Плюсы:
 * <p>-Ленивая инициализация.
 * <p>Потокобезопасность
 * <p>Минусы:
 * <p>-Низкая производительность в многопоточной среде
 * <p>В реализации SynchronizedSingleton мы вернули потокобезопасность! Правда, медленную…
 * Теперь метод getInstance синхронизирован, и входить в него можно только по одному.
 * На самом деле нам нужно синхронизировать не весь метод, а лишь ту его часть, в которой
 * мы инициализируем новый объект класса. Но мы не можем просто обернуть в synchronized блок часть,
 * отвечающую за создание нового объекта: это не обеспечит потокобезопасность. Все немного сложнее.
 */

public class SynchronizedSingleton {
    private static SynchronizedSingleton INSTANCE;

    private SynchronizedSingleton() {
    }

    public static synchronized SynchronizedSingleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SynchronizedSingleton();
        }
        return INSTANCE;
    }
}
