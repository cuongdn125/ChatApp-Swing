
package chatsocket;

import model.User;
import java.io.IOException;
import java.io.DataOutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WriteServer {
    //private Socket socket;
    private static List<User> listacc;
   
    
    public WriteServer(List<User> listacc) {
        //this.socket = socket;
        this.listacc = listacc;
  
    }

    public List<User> getListacc() {
        return listacc;
    }

    public void setListacc(List<User> listacc) {
        this.listacc = listacc;
    }
    public void WriteAddGroup(String desUser,String groupName,DataOutputStream os){
        String mess = desUser+":"+groupName+":AddGroup";
//        System.out.println("_WriteChatPrivate: "+sourceUser+":"+messfromsource+":ChatPrivate:"+desUser);
        for(User item:listacc){
            if(item.getUsername().equals(desUser))
            {
                try {
                    os = new DataOutputStream(item.getSocket().getOutputStream());
                    os.writeUTF(mess);
                    os.flush();
                } catch (IOException ex) {
                    Logger.getLogger(WriteServer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
       
    }
    public void WriteChatPrivate(String sourceUser,String desUser,String messfromsource,DataOutputStream os){
        String mess = sourceUser+":"+messfromsource+":ChatPrivate:"+desUser;
        System.out.println("_WriteChatPrivate: "+sourceUser+":"+messfromsource+":ChatPrivate:"+desUser);
        for(User item:listacc){
            if(item.getUsername().equals(sourceUser) || item.getUsername().equals(desUser))
            {
                try {
                    os = new DataOutputStream(item.getSocket().getOutputStream());
                    os.writeUTF(mess);
                    os.flush();
                } catch (IOException ex) {
                    Logger.getLogger(WriteServer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
       
    }
    public void WriteChatGroup(String sourceUser,String desUser, String groupName ,String messfromsource,DataOutputStream os){
        String mess = sourceUser+":"+messfromsource+":ChatGroup:"+groupName;
        System.out.println("_WriteChatGroup: "+sourceUser+":"+messfromsource+":ChatGroup:"+groupName +":"+desUser);
        for(User item:listacc){
            if( item.getUsername().equals(desUser))
            {
                try {
                    os = new DataOutputStream(item.getSocket().getOutputStream());
                    os.writeUTF(mess);
//                    os.flush();
                } catch (IOException ex) {
                    Logger.getLogger(WriteServer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
       
    }
    public void WriteUserOnline(String username,DataOutputStream os){
        String mess = "Server: "+username+" is online!:UserOnline:";
        String mess2 = ConvertAccToString();
        WriteBroadcast(mess+";"+mess2,os);
    }
    public void WriteUserExit(String username,DataOutputStream os){
        String mess = "Server: "+username+" is offline!:UserExit:";
        String mess2 = ConvertAccToString();
        WriteBroadcast(mess+";"+mess2,os);
    }
    public void WriteUserPrivateExit(String mess,DataOutputStream os){
        //format src::ExitPrivate:des
        String src = mess.split(":")[0];
        for(User item:listacc){
            if(item.getUsername().equals(src))
            {
                try {
                    os = new DataOutputStream(item.getSocket().getOutputStream());
                    os.writeUTF(mess);
//                    os.flush();
                } catch (IOException ex) {
                    Logger.getLogger(WriteServer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    public String ConvertAccToString(){
        String result = "ListUserOnline:";
        for(User item:listacc){
            result+=item.getUsername()+",";
        }
        return result;
    }
    public void WriteBroadcast(String mess,DataOutputStream os){
        System.out.println("WriteBroadcast listacc.size(): "+listacc.size());
        if(listacc!=null){
            for(User item:listacc){
            try {
                os = new DataOutputStream(item.getSocket().getOutputStream());
                os.writeUTF(mess);
//                os.flush();
            } catch (IOException ex) {
                Logger.getLogger(WriteServer.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }else{
            System.out.println("Nobody online!");
        }
        
    }
}
