package simpledb.jdbc;

import java.sql.*;
import java.util.*;
import java.util.concurrent.*;

/**
 * This class implements all of the methods of the Connection interface,
 * by throwing an exception for each one.
 * Subclasses (such as SimpleConnection) can override those methods that
 * it want to implement.
 *
 * @author Edward Sciore
 */
public abstract class ConnectionAdapter implements Connection {
    public void clearWarnings() throws SQLException {
        throw new SQLException("operation not implemented");
    }

    public void close() throws SQLException {
        throw new SQLException("operation not implemented");
    }

    public void commit() throws SQLException {
        throw new SQLException("operation not implemented");
    }

    public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
        throw new SQLException("operation not implemented");
    }

    public Blob createBlob() throws SQLException {
        throw new SQLException("operation not implemented");
    }

    public Clob createClob() throws SQLException {
        throw new SQLException("operation not implemented");
    }

    public NClob createNClob() throws SQLException {
        throw new SQLException("operation not implemented");
    }

    public SQLXML createSQLXML() throws SQLException {
        throw new SQLException("operation not implemented");
    }

    public Statement createStatement() throws SQLException {
        throw new SQLException("operation not implemented");
    }

    public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
        throw new SQLException("operation not implemented");
    }

    public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        throw new SQLException("operation not implemented");
    }

    public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
        throw new SQLException("operation not implemented");
    }

    public boolean getAutoCommit() throws SQLException {
        throw new SQLException("operation not implemented");
    }

    public String getCatalog() throws SQLException {
        throw new SQLException("operation not implemented");
    }

    public Properties getClientInfo() throws SQLException {
        throw new SQLException("operation not implemented");
    }

    public String getClientInfo(String name) throws SQLException {
        throw new SQLException("operation not implemented");
    }

    public int getHoldability() throws SQLException {
        throw new SQLException("operation not implemented");
    }

    public DatabaseMetaData getMetaData() throws SQLException {
        throw new SQLException("operation not implemented");
    }

    public int getTransactionIsolation() throws SQLException {
        throw new SQLException("operation not implemented");
    }

    public Map<String, Class<?>> getTypeMap() throws SQLException {
        throw new SQLException("operation not implemented");
    }

    public SQLWarning getWarnings() throws SQLException {
        throw new SQLException("operation not implemented");
    }

    public boolean isClosed() throws SQLException {
        throw new SQLException("operation not implemented");
    }

    public boolean isReadOnly() throws SQLException {
        throw new SQLException("operation not implemented");
    }

    public boolean isValid(int timeout) throws SQLException {
        throw new SQLException("operation not implemented");
    }

    public String nativeSQL(String sql) throws SQLException {
        throw new SQLException("operation not implemented");
    }

    public CallableStatement prepareCall(String sql) throws SQLException {
        throw new SQLException("operation not implemented");
    }

    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
        throw new SQLException("operation not implemented");
    }

    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        throw new SQLException("operation not implemented");
    }

    public PreparedStatement prepareStatement(String sql) throws SQLException {
        throw new SQLException("operation not implemented");
    }

    public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
        throw new SQLException("operation not implemented");
    }

    public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
        throw new SQLException("operation not implemented");
    }

    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
        throw new SQLException("operation not implemented");
    }

    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        throw new SQLException("operation not implemented");
    }

    public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
        throw new SQLException("operation not implemented");
    }

    public void releaseSavepoint(Savepoint savepoint) throws SQLException {
        throw new SQLException("operation not implemented");
    }

    public void rollback() throws SQLException {
        throw new SQLException("operation not implemented");
    }

    public void rollback(Savepoint svepoint) throws SQLException {
        throw new SQLException("operation not implemented");
    }

    public void setAutoCommit(boolean autoCommit) throws SQLException {
        throw new SQLException("operation not implemented");
    }

    public void setCatalog(String catalog) throws SQLException {
        throw new SQLException("operation not implemented");
    }

    public void setClientInfo(String name, String value) {
    }

    public void setClientInfo(Properties properties) {
    }

    public void setHoldability(int holdability) throws SQLException {
        throw new SQLException("operation not implemented");
    }

    public void setReadOnly(boolean readOnly) throws SQLException {
        throw new SQLException("operation not implemented");
    }

    public Savepoint setSavepoint() throws SQLException {
        throw new SQLException("operation not implemented");
    }

    public Savepoint setSavepoint(String name) throws SQLException {
        throw new SQLException("operation not implemented");
    }

    public void setTransactionIsolation(int level) throws SQLException {
        throw new SQLException("operation not implemented");
    }

    public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
        throw new SQLException("operation not implemented");
    }

    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        throw new SQLException("operation not implemented");
    }

    public <T> T unwrap(Class<T> iface) throws SQLException {
        throw new SQLException("operation not implemented");
    }

    public void abort(Executor executor) throws SQLException {
        throw new SQLException("operation not implemented");
    }

    public int getNetworkTimeout() throws SQLException {
        throw new SQLException("operation not implemented");
    }

    public String getSchema() throws SQLException {
        throw new SQLException("operation not implemented");
    }

    public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {
        throw new SQLException("operation not implemented");
    }

    public void setSchema(String schema) throws SQLException {
        throw new SQLException("operation not implemented");
    }
}