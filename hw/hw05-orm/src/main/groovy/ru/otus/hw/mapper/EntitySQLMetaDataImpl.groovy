package ru.otus.hw.mapper

import groovy.transform.Canonical

@Canonical
class EntitySQLMetaDataImpl<T> implements EntitySQLMetaData<T> {
    private final EntityClassMetaData<T> entityClassMetaData

    private final selectByIdQuery;

    EntitySQLMetaDataImpl(entityClassMetaData) {
        this.entityClassMetaData = entityClassMetaData
        selectByIdQuery = "SELECT * FROM ${entityClassMetaData.getName()} WHERE ${entityClassMetaData.getIdField()} = ?"
    }

    @Override
    String getSelectAllSql() {
        return null
    }

    @Override
    String getSelectByIdSql() {
        return selectByIdQuery
    }

    @Override
    String getInsertSql() {
        return null
    }

    @Override
    String getUpdateSql() {
        return null
    }
}
