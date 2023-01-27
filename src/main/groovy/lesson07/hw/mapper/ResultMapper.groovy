package lesson07.hw.mapper

import lesson07.hw.ReflectionUtility
import lesson07.hw.exception.ResultMapperException;

import java.lang.reflect.Field;
import java.sql.ResultSet;

class ResultMapper<T> extends Closure<T> {

    private final EntityClassMetaData<T> entityClassMetaData;

    ResultMapper(Object owner, Object thisObject, EntityClassMetaData<T> entityClassMetaData) {
        super(owner, thisObject)
    }

    ResultMapper(Object owner, EntityClassMetaData<T> entityClassMetaData) {
        super(owner)
    }

    @Override
    def apply(ResultSet resultSet) {
        try {
            def object = entityClassMetaData.getConstructor().newInstance();
            if (resultSet.next()) {
                for (Field f : entityClassMetaData.getAllFields()) {
                    ReflectionUtility.setValue(f, object, resultSet.getObject(f.getName()));
                }
            }
            object;
        } catch (ex) {
            throw new ResultMapperException(ex.getMessage());
        }
    }

}
