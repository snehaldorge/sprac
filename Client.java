import java.rmi.Naming;
  import java.rmi.RemoteException;
  public class Client {
  public static void main(String[] args){
  try{
  RemoteInterface server = (RemoteInterface)
Naming.lookup("rmi://localhost/Server");
  server.sendMessage("User");
  String response = server.receiveMessage();
  System.out.println("Response from server:" + response);
 }catch(Exception e){
 System.err.println("Client exception: " + e.toString());
 e.printStackTrace();
}
}
}