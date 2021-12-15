
package chatsocket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientHandle {
    static final int PORT = 4445;
    private static String user ;
    static InetAddress address;
    static Socket socket=null;
    static String line=null;
    static BufferedReader br=null;
    static DataInputStream is=null;
    static DataOutputStream os=null;
    
    public ClientHandle() {
    }

    public static Socket getSocket() {
        return socket;
    }

    public static void setSocket(Socket socket) {
        ClientHandle.socket = socket;
    }

    public static String getUser() {
        return user;
    }

    public static void setUser(String user) {
        ClientHandle.user = user;
    }
    
    
    public static void sendInfo(String username){
        
        try {
            os= new DataOutputStream(socket.getOutputStream());
            os.writeUTF(username+":info:info");
            System.out.println("_sendInfo: "+username+":info");
            os.flush();
        } catch (IOException ex) {
            Logger.getLogger(ClientHandle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void InitClient(String username){
        
        try {
           user = username;
           address=InetAddress.getLocalHost();
           System.out.println("address: "+address);
           socket=new Socket(address, 4445);
           br= new BufferedReader(new InputStreamReader(System.in));
           is=new DataInputStream(socket.getInputStream());
           os= new DataOutputStream(socket.getOutputStream());
           sendInfo(username);
       }
       catch (IOException e){
           e.printStackTrace();
           System.err.print("IO Exception");
       }
    }
    public static void CloseClient(){
        try {
            System.out.println("Connection Closed: "+socket);
            is.close();
            os.close();
            br.close();
            socket.close();
            
        } catch (IOException ex) {
            Logger.getLogger(ClientHandle.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("CloseClient err!");
        }
    }
    public void WriteExitClient(){
        try {
            os= new DataOutputStream(socket.getOutputStream());
            os.writeUTF(user+"::Exit");
            System.out.println("_WriteExitClient: "+user+"::Exit");
            os.flush();
        } catch (IOException ex) {
            Logger.getLogger(ClientHandle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void WriteExitPrivateClient(String des){
        try {
            os= new DataOutputStream(socket.getOutputStream());
            os.writeUTF(user+"::ExitPrivate:"+des);
            System.out.println("WriteExitPrivateClient: "+user+"::ExitPrivate:"+des);
            os.flush();
        } catch (IOException ex) {
            Logger.getLogger(ClientHandle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static String ReadClient(){
        String mess;
        ReadClient read = new ReadClient(socket);
        read.start();
        mess = read.getMess();
        return mess;
    }
    public static void WriteClient(String mess){
        WriteClient write = new WriteClient(socket,user,mess);
        write.start();
    }
    public void WriteChatPrivate(String desUser,String mess){
        try {
            //format: username::ChatPrivate:desUser,mess
            os= new DataOutputStream(socket.getOutputStream());
            os.writeUTF(user+"::ChatPrivate:"+desUser+","+mess);
            System.out.println("_WriteChatPrivate_Client "+user+"::ChatPrivate:"+desUser+","+mess);
            os.flush();
        } catch (IOException ex) {
            Logger.getLogger(ClientHandle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void WriteChatGroup(String desUser,String mess){
        try {
            //format: username::ChatPrivate:desUser,mess
            os= new DataOutputStream(socket.getOutputStream());
            os.writeUTF(user+"::ChatGroup:"+desUser+","+mess);
            System.out.println("_WriteChatGroup_Client "+user+"::ChatGroup:"+desUser+","+mess);
            os.flush();
        } catch (IOException ex) {
            Logger.getLogger(ClientHandle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
