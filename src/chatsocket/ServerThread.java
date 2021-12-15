
package chatsocket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import model.User;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import controller.GroupController;
import java.util.ArrayList;


public class ServerThread extends Thread{
    String line=null;
    DataInputStream  is = null;
    DataOutputStream os=null;
    Socket s=null;
    GroupController gctr;
    List<User> listacc = null;

    ServerThread(Socket s,List<User> list){
        this.s=s;
        this.listacc = list;
        gctr = new GroupController();
    }
    

    @Override
    public void run() {
    try{
        is= new DataInputStream(s.getInputStream());
        //os=new PrintWriter(s.getOutputStream());

    }catch(IOException e){
        System.out.println("IO error in server thread");
    }

    try {
        WriteServer write = null;
        while(true){
            line=is.readUTF();
            //username:mess:rq
            String username = line.split(":")[0];
            String mess = line.split(":")[1];
            String rq = line.split(":")[2];
            if(rq.equals("info")){
                User tmp = new User(s,username);
                ServerRun.addUser(tmp);
                write = new WriteServer(listacc);
                write.WriteUserOnline(username, os);
            } 
            if(rq.equals("ChatAll")){
                
                write.WriteBroadcast(line,os);
            }
            if(rq.equals("Exit")){
                User tmp = new User(s,username);
                System.out.println(ServerRun.accountinfolist.size());
                ServerRun.removeUser(tmp);
                System.out.println(ServerRun.accountinfolist.size());
                try{
                    System.out.println("listacc.size(): "+listacc.size());
                    /*for(int i=0; i<= listacc.size(); i++)
                    {
                        if(listacc.get(i).getUsername().equals(username)){
                            listacc.remove(i);
                            break;
                        }
                    }*/
                    System.out.println("listacc.size(): "+listacc.size());
                    write.setListacc(listacc);
                    write.WriteUserExit(username, os);
                }catch(Exception ex){
                    listacc.clear();
                    System.out.println("listacc.size(): "+listacc.size());
                }
               
                
            }
            if(rq.equals("ChatPrivate")){
                //format: username::ChatPrivate:desUser,mess
                String[]data = line.split(":");
                String sourceUser = data[0];
                String desUser = data[3].split(",")[0];
                String messfromsource = data[3].split(",")[1];
                write.WriteChatPrivate(sourceUser,desUser,messfromsource,os);
                System.out.println("_ChatPrivate:"+line);
            }
            if(rq.equals("ChatGroup")){
                //format: username::ChatPrivate:desUser,mess
                String[]data = line.split(":");
                String sourceUser = data[0];
                String groupName = data[3].split(",")[0];
                ArrayList<String> list = gctr.getUserGroup(groupName);
                System.out.println(list);
                String messfromsource = data[3].split(",")[1];
                for(String item:list){
                    System.out.println("_ChatGroup:"+line);
                    write.WriteChatGroup(sourceUser,item,groupName,messfromsource,os);
                    
                }
                
                
                
            }
            if(rq.equals("AddGroup")){
                String[]data = line.split(":");
                String desUser = data[0];
                String groupName = data[1];
                write.WriteAddGroup(desUser,groupName,os);
            }
            if(rq.equals("ExitPrivate")){
                //format src::ExitPrivate:des
                
            }
            System.out.println("Line from server: "+line);
            
        }   
    } catch (IOException e) {

        line=this.getName(); //reused String line for getting thread name
        System.out.println("IO Error/ Client "+line+" terminated abruptly");
    }
    catch(NullPointerException e){
        line=this.getName(); //reused String line for getting thread name
        System.out.println("Client "+line+" Closed");
        System.out.println("User Online: "+this.listacc.size());
        System.out.println("User Online ServerHandle: "+ServerRun.accountinfolist.size());
    }
    finally{    
        try
        {
            
            if (is!=null){
                is.close(); 
                //System.out.println(" Socket Input Stream Closed");
            }

            if(os!=null){
                os.close();
                //System.out.println("Socket Out Closed");
            }
            if (s!=null){
                System.out.println("Disconnect "+s);
                s.close();
            }

        }
        catch(IOException ie){
            System.out.println("Socket Close Error");
        }
        }
    }
    public Thread getThreadByName(String threadName) {
        for (Thread t : Thread.getAllStackTraces().keySet()) {
            if (t.getName().equals(threadName)) return t;
        }
        return null;    
    }
    
}
