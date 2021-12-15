
package chatsocket;

import model.User;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;



public class ServerRun {
    static final int PORT = 4445;
    public static List<User> accountinfolist;

    public List<User> getAccountinfolist() {
        return accountinfolist;
    }

    public void setAccountinfolist(List<User> accountinfolist) {
        this.accountinfolist = accountinfolist;
    }
    public static void addUser(User item){
        accountinfolist.add(item);
    }
    public static void removeUser(User item){
        try{
            for(int i=0; i<= accountinfolist.size(); i++){
                if(accountinfolist.get(i).getUsername().equals(item.getUsername())){
                    accountinfolist.remove(i);
                    break;
                }
            }
        }catch(Exception ex){
            accountinfolist.clear();
        }
        
    }
    public static void main(String args[]) {
        accountinfolist = new ArrayList<>();
        Socket s=null;
        ServerSocket ss2=null;
        System.out.println("Server Listening on port "+PORT+"......");
        try{
            ss2 = new ServerSocket(PORT); 
        }
        catch(IOException e){
            System.out.println("Server error");
        }

        while(true){
            try{
                synchronized(ss2) {
                    s= ss2.accept();
                    System.out.println("connection Established: Address "+ s);
                    ServerThread st=new ServerThread(s,ServerRun.accountinfolist);
                    st.start();
                    
                }
            }

        catch(Exception e){
            //System.out.println("Connection Error");

        }
        }
    }
    
}
