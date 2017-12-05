package rmi;

import java.rmi.RemoteException;

/**
 * Created by yejj on 2017/6/19 0019.
 */
public interface Warehouse {
    double getPrice(String description) throws RemoteException;
}
