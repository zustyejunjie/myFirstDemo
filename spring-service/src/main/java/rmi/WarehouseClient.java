package rmi;

/**
 * Created by yejj on 2017/6/19 0019.
 */

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import javax.naming.NamingException;

public class WarehouseClient{
    public static void main(String[] args) throws NamingException, RemoteException, MalformedURLException, NotBoundException{
        System.out.println("RMI registry binding:");
        String url = "rmi://localhost:1098/central_warehoues";
        Warehouse centralWarehouse = (Warehouse) Naming.lookup(url);
        String descr = "mate7";
        double price = centralWarehouse.getPrice(descr);
        System.out.println(descr + ":" + price);
    }
}