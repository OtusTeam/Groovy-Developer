package lesson07.hw

import lesson07.hw.exception.EntityMetaDataException

import java.lang.reflect.Constructor
import java.lang.reflect.Field

class ReflectionUtility {

    static def getValueFromObjectByField(Field field, object) {
        try {
            field.setAccessible(true)
            field.get(object)
        } catch (ex) {
            throw new EntityMetaDataException(ex.getMessage())
        }
    }

    static void setValue(Field field, object, value) {
        try {
            field.setAccessible(true)
            field.set(object, value)
        } catch (ex) {
            throw new EntityMetaDataException(ex.getMessage())
        }
    }

    static  <T> T useConstructor(Constructor<T> constructor) {
        try {
            constructor.newInstance();
        } catch (ex) {
            throw new EntityMetaDataException(ex.getMessage());
        }
    }
}
