
package chatsocket;


import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ReadClient extends Thread{
    private static Socket socket;
    public static String mess;
    public ReadClient(Socket socket) {
        this.socket = socket;
    }

    public static String getMess() {
        return mess;
    }

    public static void setMess(String mess) {
        ReadClient.mess = mess;
    }
    
    @Override
    public void run() {
        
        
        DataInputStream is=null;
        try {
            is=new DataInputStream(socket.getInputStream());
        }
        catch (IOException e){
            e.printStackTrace();
            System.err.print("IO Exception");
        }
        try{
            while(true){
                mess = is.readUTF();
            }
        }
        catch(IOException e){
            e.printStackTrace();
        System.out.println("Socket read Error");
        }
        finally{

            try {
                is.close();
                socket.close();
                System.out.println("Connection Closed");
            } catch (IOException ex) {
                Logger.getLogger(ReadClient.class.getName()).log(Level.SEVERE, null, ex);
            }
            

        }
    }
}
