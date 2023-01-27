package lesson07.hw.repository;

import java.sql.Connection

/**
 * CRUD operations with database (like JdbcTemplate)
 */
interface DataTemplate<T> {
    Optional<T> findById(connection, long id);

    List<T> findAll(connection);

    long insert(connection, T object);

    void update(connection, T object);
}
