package lesson07.hw.service

import lesson07.hw.model.Manager;

interface DBServiceManager {
    Manager saveManager(Manager client);
    Optional<Manager> getManager(long no);
    List<Manager> findAll();
}
