package ru.otus.hw.repository

import groovy.transform.Canonical
import ru.otus.hw.mapper.EntityClassMetaData
import ru.otus.hw.mapper.EntitySQLMetaData

@Canonical
class DataTemplateJdbc implements DataTemplate {
    private DbExecutor dbExecutor
    private EntitySQLMetaData entitySQLMetaData
    private EntityClassMetaData entityClassMetaData

    @Override
    def findById(Object connection, long id) {
        return null
    }

    @Override
    List findAll( connection) {
        return null
    }

    @Override
    long insert( connection,  object) {
        return 0
    }

    @Override
    void update( connection,  object) {

    }
}
