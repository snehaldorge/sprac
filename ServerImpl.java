 import java.rmi.Naming;
  import java.rmi.RemoteException;
  import java.rmi.server.UnicastRemoteObject;
  public class ServerImpl extends UnicastRemoteObject implements RemoteInterface{
  String Msg = "Good day, ";
  public ServerImpl() throws RemoteException{
  super();
  }
 
 @Override
 public void sendMessage(String message) throws RemoteException{
 System.out.println("Message received at server"+message);
 
 Thread thread = new Thread(() -> {
 try{
 String response = "Response to: " + message;
 Msg+= message;
 System.out.println("Sending response to client "+ response);
 sendResponseToClient(response);
 } catch (RemoteException e){
 System.err.println("Error sending response to client: "+e.getMessage());
 }
 });
 thread.start();
 }
 @Override
 public String receiveMessage() throws RemoteException{
 return this.Msg;
 }
 
 private void sendResponseToClient(String response) throws RemoteException{
 System.out.println("Response send");
 }
 
 public static void main(String[] args) {
 try {
 ServerImpl server = new ServerImpl();
 
 // Bind the server object to the RMI registry
 Naming.rebind("rmi://localhost/Server", server);
 
 System.out.println("Server running...");
 } catch (Exception e) {
 System.err.println("Server exception: " + e.toString());
 e.printStackTrace();
 }
 }
 }
