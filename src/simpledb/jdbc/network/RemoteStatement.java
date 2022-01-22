package simpledb.jdbc.network;

import java.rmi.*;

/**
 * The RMI remote interface corresponding to Statement.
 * The methods are identical to those of Statement,
 * except that they throw RemoteExceptions instead of SQLExceptions.
 *
 * @author Edward Sciore
 */
public interface RemoteStatement extends Remote {
    RemoteResultSet executeQuery(String qry) throws RemoteException;

    int executeUpdate(String cmd) throws RemoteException;

    void close() throws RemoteException;
}

