package simpledb.jdbc.network;

import java.rmi.*;

/**
 * The RMI remote interface corresponding to ResultSet.
 * The methods are identical to those of ResultSet,
 * except that they throw RemoteExceptions instead of SQLExceptions.
 *
 * @author Edward Sciore
 */
public interface RemoteResultSet extends Remote {
    boolean next() throws RemoteException;

    int getInt(String fldname) throws RemoteException;

    String getString(String fldname) throws RemoteException;

    RemoteMetaData getMetaData() throws RemoteException;

    void close() throws RemoteException;
}

