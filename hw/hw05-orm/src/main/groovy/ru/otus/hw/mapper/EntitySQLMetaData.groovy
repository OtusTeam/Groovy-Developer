package ru.otus.hw.mapper;

/**
 * Создает SQL - запросы
 */
interface EntitySQLMetaData {
    String getSelectAllSql()

    String getSelectByIdSql() // SELECT * FROM <CLient>  WHERE <Client.id> = ?

    String getInsertSql()

    String getUpdateSql()
}
