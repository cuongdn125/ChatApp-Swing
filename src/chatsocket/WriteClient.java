
package chatsocket;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class WriteClient extends Thread{
    private static Socket socket;
    private static String username;
    private static String mess;
    public WriteClient(Socket socket,String username,String mess) {
        this.socket = socket;
        this.username = username;
        this.mess = mess;
    }
    public void run(){
        DataOutputStream os=null;
        try {
            os= new DataOutputStream(socket.getOutputStream());
            
            System.out.println("_WriteClient: "+username+":"+mess);
            
            System.out.println("_WriteClient: username: " +username );
            os.writeUTF(mess);
            os.flush();
        } catch (IOException ex) {
            System.out.println("err!");
            Logger.getLogger(WriteClient.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
            
    }
}
