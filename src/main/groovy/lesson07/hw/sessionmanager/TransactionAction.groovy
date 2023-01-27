package lesson07.hw.sessionmanager;

import java.sql.Connection
import java.util.function.Function

/**
 * Warning: not applicable for Groovy
 * @param <T>
 */
interface TransactionAction<T> extends Function<Connection, T> {
}
