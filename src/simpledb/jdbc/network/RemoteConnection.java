package simpledb.jdbc.network;

import java.rmi.*;

/**
 * The RMI remote interface corresponding to Connection.
 * The methods are identical to those of Connection,
 * except that they throw RemoteExceptions instead of SQLExceptions.
 *
 * @author Edward Sciore
 */
public interface RemoteConnection extends Remote {
    RemoteStatement createStatement() throws RemoteException;

    void close() throws RemoteException;
}

