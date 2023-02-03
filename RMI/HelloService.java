package Sever.RMI;
import java.rmi.RemoteException;

public interface HelloService extends java.rmi.Remote
{
    String sayHello(String name) throws RemoteException;
}