package lesson07.hw.mapper;

/**
 * Создает SQL - запросы
 */
interface EntitySQLMetaData {
    String getSelectAllSql()

    String getSelectByIdSql()

    String getInsertSql()

    String getUpdateSql()
}
