
package chatsocket;


public class ClientRun {
    public static void main(String args[]){
        //LoginForm loginf = new LoginForm();
        //loginf.setVisible(true);
        
        Thread th = new Thread(){
            public void run(){
                Login chat = new Login();
                chat.setVisible(true);
            }
        };
        th.start();
        
    }
}
