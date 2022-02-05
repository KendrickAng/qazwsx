package simpledb.jdbc.network;

import java.rmi.*;

/**
 * The RMI remote interface corresponding to ResultSetMetaData.
 * The methods are identical to those of ResultSetMetaData,
 * except that they throw RemoteExceptions instead of SQLExceptions.
 *
 * @author Edward Sciore
 */
public interface RemoteMetaData extends Remote {
    int getColumnCount() throws RemoteException;

    String getColumnName(int column) throws RemoteException;

    int getColumnType(int column) throws RemoteException;

    int getColumnDisplaySize(int column) throws RemoteException;
}
