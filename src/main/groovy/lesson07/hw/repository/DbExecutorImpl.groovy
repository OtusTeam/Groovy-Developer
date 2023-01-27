package lesson07.hw.repository

import lesson07.hw.exception.DataBaseOperationException

import java.sql.Connection
import java.sql.Statement

class DbExecutorImpl implements DbExecutor {

    @Override
    long executeStatement(Connection connection, String sql, List<Object> params) {
        try (def pst = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            for (def idx = 0; idx < params.size(); idx++) {
                pst.setObject(idx + 1, params.get(idx));
            }
            pst.executeUpdate();
            try (def rs = pst.getGeneratedKeys()) {
                rs.next();
                return rs.getInt(1);
            }
        } catch (ex) {
            throw new DataBaseOperationException("executeInsert error", ex);
        }
    }

    @Override
    <T> Optional<T> executeSelect(Connection connection, String sql, List<Object> params, Closure<T> rsHandler) {
        try (def pst = connection.prepareStatement(sql)) {
            for (def idx = 0; idx < params.size(); idx++) {
                pst.setObject(idx + 1, params.get(idx));
            }
            try (def rs = pst.executeQuery()) {
                return Optional.ofNullable(rsHandler.call(rs));
            }
        } catch (ex) {
            throw new DataBaseOperationException("executeSelect error", ex);
        }
    }
}
