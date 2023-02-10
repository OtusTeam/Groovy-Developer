package ru.otus.hw.service

import ru.otus.hw.model.Manager


interface DBServiceManager {
    Manager saveManager(Manager client);
    Optional<Manager> getManager(long no);
    List<Manager> findAll();
}
