package lesson07.hw.sessionmanager

import lesson07.hw.exception.DataBaseOperationException

import javax.sql.DataSource
import java.util.concurrent.Callable

class TransactionRunnerJdbc implements TransactionRunner {
    private final DataSource dataSource;

    TransactionRunnerJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    <T> T doInTransaction(Closure<T> action) {
        return wrapException(() -> {
            try (def connection = dataSource.getConnection()) {
                try {
                    def result = action.call(connection);
                    connection.commit();
                    return result;
                } catch (ex) {
                    connection.rollback();
                    throw new DataBaseOperationException("doInTransaction exception", ex);
                }
            }
        });
    }

    private <T> T wrapException(Callable<T> action) {
        try {
            return action.call();
        } catch (Exception ex) {
            throw new DataBaseOperationException("exception", ex);
        }
    }
}
