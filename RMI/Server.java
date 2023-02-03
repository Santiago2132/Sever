package Sever.RMI;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    public static void main(String[] args)
    {
        try {
            // Create and export a remote object
            HelloServiceImpl helloService = new HelloServiceImpl();
            HelloService stub = (HelloService) UnicastRemoteObject.exportObject((Remote) helloService, 0);

            // Create and start the registry
            Registry registry = LocateRegistry.createRegistry(1099);

            // Bind the remote object's stub in the registry
            registry.rebind("HelloService", stub);

            System.out.println("Server ready");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
    
}
