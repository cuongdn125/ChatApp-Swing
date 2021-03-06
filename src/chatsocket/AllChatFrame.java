
package chatsocket;


import java.io.DataInputStream;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import controller.MessController;
import model.Message;
import model.Group;
import model.User;
import controller.GroupController;


public class AllChatFrame extends javax.swing.JFrame {

    private static ClientHandle client;
    private static String username;
    private  MessController mctr;
    private  GroupController gctr;
    private ArrayList<String> listMess;
    private static List<ChatGroupClass> listChatGroup = new ArrayList<>();
    private List<String> listGroup;
    private static List<ChatPrivateClass> listChatPrivate = new ArrayList<>();
    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        AllChatFrame.username = username;
    }


    public static ClientHandle getClient() {
        return client;
    }

    public static void setClient(ClientHandle client) {
        AllChatFrame.client = client;
    }
    
    public AllChatFrame(String name) {
        this.username = name;
        mctr = new MessController();
        gctr = new GroupController();
        listMess = mctr.getMessAll();
        this.listGroup = new ArrayList<>();
        this.listGroup = gctr.getGroup(name);
        
        initComponents();
//        listMess.stream().map(mes -> mes.split(":")[0] + ": "+mes.split(":")[1] + "\n").forEachOrdered(m -> {
//            txtareaChatGroup.append(m);
//        });
//        System.out.println("tin nhan: "+listMess.toString());
        listMess.forEach((m) -> {
            txtareaChatGroup.append(m+"\n");
        });
        showTableGroup(listGroup);
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                client.WriteExitClient();
                client.CloseClient();
            }
        });
        Thread clientthread = new Thread(){
            public void run() {
                client = new ClientHandle();
                client.InitClient(username);
            }
        };
        
        Thread readupdate = new Thread(){
          public void run() {
              //System.out.println("readupdate");
              ReadUpdate(client.getSocket()); 
          }
         };
        clientthread.start();
        try{
            clientthread.join();
            
        }catch(Exception ex){
        }
        readupdate.start();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtareaChatGroup = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbOnlineUser = new javax.swing.JTable();
        txtMess = new javax.swing.JTextField();
        btnSend = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        label1 = new java.awt.Label();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableGroup = new javax.swing.JTable();
        jTextGroup = new javax.swing.JTextField();
        jButtonAddGroup = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtareaChatGroup.setColumns(20);
        txtareaChatGroup.setRows(5);
        txtareaChatGroup.setEnabled(false);
        txtareaChatGroup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtareaChatGroupMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(txtareaChatGroup);

        jtbOnlineUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Online User"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbOnlineUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbOnlineUserMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtbOnlineUser);

        txtMess.setActionCommand("<Not Set>");
        txtMess.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        txtMess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMessActionPerformed(evt);
            }
        });
        txtMess.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMessKeyPressed(evt);
            }
        });

        btnSend.setText("Send");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        label1.setText("Double-Click to chat private");

        jTableGroup.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Group"
            }
        ){
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableGroup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableGroupMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTableGroup);

        jButtonAddGroup.setText("T???o");
        jButtonAddGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddGroupActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtMess, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnSend)
                        .addGap(18, 18, 18)
                        .addComponent(btnExit))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(38, 38, 38)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonAddGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonAddGroup))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMess, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSend, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMessActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMessActionPerformed

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        // TODO add your handling code here:
        String m = txtMess.getText().toString();
        if(!m.isEmpty()){
            String type = "ChatAll";
            String mess = username+":"+txtMess.getText()+":"+type;
            client.WriteClient(mess);
            Message x = new Message(txtMess.getText(), "ChatAll", "All", username);
            mctr.insertMess(x);
            txtMess.setText("");
        }
    }//GEN-LAST:event_btnSendActionPerformed

    private void txtMessKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMessKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            String type = "ChatAll";
            String mess = username+":"+txtMess.getText()+":"+type;
            client.WriteClient(mess);
            Message x = new Message(txtMess.getText(), "ChatAll", "All", username);
            mctr.insertMess(x);
            txtMess.setText("");
        }
        
    }//GEN-LAST:event_txtMessKeyPressed

    private void jtbOnlineUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbOnlineUserMouseClicked
        // TODO add your handling code here:
        
        if(evt.getClickCount()==2){
            int i = jtbOnlineUser.getSelectedRow();
            TableModel model = jtbOnlineUser.getModel();
            String desUser = model.getValueAt(i, 0).toString();
            String source = username;
            Thread th = new Thread(){
                public void run(){
                    PrivateChatFrame chatPrivatef = new PrivateChatFrame(source,desUser,client,"");
                    ChatPrivateClass chatPrivate = new ChatPrivateClass(chatPrivatef,source,desUser);
                    listChatPrivate.add(chatPrivate);
                    chatPrivate.getChatprivate().setVisible(true);
                }
            };
            th.setName(source+"-"+desUser);
            th.start();
        }
        
        
    }//GEN-LAST:event_jtbOnlineUserMouseClicked

    private void txtareaChatGroupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtareaChatGroupMouseClicked
        // TODO add your handling code here:
         

    }//GEN-LAST:event_txtareaChatGroupMouseClicked

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        client.WriteExitClient();
        client.CloseClient();
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void jButtonAddGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddGroupActionPerformed
        // TODO add your handling code here:
        String groupName = jTextGroup.getText();
        String mess = username+":"+groupName+":AddGroup";
        Group group = new Group(groupName);
        gctr.insertGroup(group, username);
        client.WriteClient(mess);
        jTextGroup.setText("");
        
        
        
    }//GEN-LAST:event_jButtonAddGroupActionPerformed

    private void jTableGroupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableGroupMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==2){
            int i = jTableGroup.getSelectedRow();
            TableModel model = jTableGroup.getModel();
            String groupName = model.getValueAt(i, 0).toString();
            String source = username;
            Thread th = new Thread(){
                public void run(){
                    ChatGroupFrame chatGroupf = new ChatGroupFrame(source,groupName,client,"");
                    ChatGroupClass chatGroup = new ChatGroupClass(chatGroupf,source,groupName);
                    listChatGroup.add(chatGroup);
                    chatGroup.getChatgroup().setVisible(true);
//                        chatGroupf.setVisible(true);
                }
            };
            th.setName(source+"-"+groupName);
            th.start();
        }
    }//GEN-LAST:event_jTableGroupMouseClicked
    public void ReadUpdate(Socket socket)
    {
        DataInputStream is=null;
        String line=null;
        try {
            is=new DataInputStream(socket.getInputStream());
        }
        catch (IOException e){
            e.printStackTrace();
            System.err.print("IO Exception");
        }
        try{
            while(true){
                line = is.readUTF();
                System.out.println("line: "+line);
                String rq = line.split(":")[2];
                String messfromserver = line.split(":")[1];
                String userfromserver = line.split(":")[0];
                String messappendtochatgroup = userfromserver+":"+messfromserver+"\n";
                if(rq.equals("ChatAll")){
                    txtareaChatGroup.append(messappendtochatgroup);
                }
                if (rq.equals("UserOnline") ||rq.equals("UserExit") )
                {
                    txtareaChatGroup.append(messfromserver+"\n");
                    String ListOnlineUser = line.split(";")[1];
                    System.out.println(ListOnlineUser);
                    List<String> OnlineUsers = new ArrayList<>();
                    String[]datatmp = ListOnlineUser.split(":");
                    String[] data = datatmp[1].split(",");
                    for(String item:data){
                        if(!item.equals(username)){
                            OnlineUsers.add(item);
                        }
                    }
                    showTableUserOnline(OnlineUsers);
                    System.out.println("OnlineUsers: "+OnlineUsers);
                }
                if(rq.equals("AddGroup")){
                    System.out.println("abc........." + line);
                    String u = line.split(":")[0];
                    String g = line.split(":")[1];
//                    System.out.println(username + " :  " +u);
                    if(username.equals(u)){
                        System.out.println("ok");
                        this.listGroup.add(g);
//                       
                    }
                    showTableGroup(listGroup);
                    System.out.println(this.listGroup);
                    
                }
                
                if(rq.equals("ChatPrivate")){
                    //format sourceUser:mess:ChatPrivate:desUser
                    String[]data = line.split(":");
                    String sourceUser = data[0];
                    String desUser = data[3];
                    boolean flag = false;
                    System.out.println("_Read_ChatPrivate: "+line);
                    for(ChatPrivateClass item:listChatPrivate){
                        //String sourceExist = item.split(":")[0];
                        String desExist = item.getDes();
                        String sourceExist = item.getSource();
                        System.out.println(sourceUser+";"+desExist+"---"+desUser+";"+sourceExist);
                        if((sourceUser.equals(desExist)&& desUser.equals(sourceExist)) 
                                || (sourceUser.equals(sourceExist)&& desUser.equals(desExist))){
                            item.getChatprivate().appendmess(sourceUser+":"+data[1]);
                            flag = true;
                        }
                    }
                    if(!flag){
                         Thread t = new Thread(){
                            public void run(){
                                PrivateChatFrame chatPrivateF = new PrivateChatFrame(desUser,sourceUser,client,data[1]);
                                ChatPrivateClass chatPrivate = new ChatPrivateClass(chatPrivateF,desUser,sourceUser);
                                listChatPrivate.add(chatPrivate);
                                chatPrivate.getChatprivate().setVisible(true);
                                chatPrivate.getChatprivate().appendmess(sourceUser+":"+data[1]);
                            }
                        };
                        t.start();
                    }
                }
                if(rq.equals("ChatGroup")){
                    //format sourceUser:mess:ChatGroup:desUser
                    String[]data = line.split(":");
                    String sourceUser = data[0];
                    String desUser = data[3];
//                    boolean flag1 = false;
                    System.out.println("_Read_ChatGroup: "+line);
//                    System.out.println("dadasdasdasddssssssssssss");
                    for(ChatGroupClass item:listChatGroup){
                        //String sourceExist = item.split(":")[0];
                        String desExist = item.getGroupName();
                        String sourceExist = item.getSource();
                        System.out.println(sourceUser+";"+desExist+"---"+desUser+";"+sourceExist);
                        if(desUser.equals(desExist)) {
                            item.getChatgroup().appendmess(sourceUser+":"+data[1]);
//                            flag1 = true;
                        }
                    }
//                    if(!flag1){
//                         Thread t = new Thread(){
//                            public void run(){
//                                ChatGroupFrame chatGroupF = new ChatGroupFrame(sourceUser,desUser,client,data[1]);
//                                ChatGroupClass chatGroup = new ChatGroupClass(chatGroupF,sourceUser,desUser);
//                                listChatGroup.add(chatGroup);
//                                chatGroup.getChatgroup().setVisible(true);
//                                chatGroup.getChatgroup().appendmess(sourceUser+":"+data[1]);
//                            }
//                        };
//                        t.start();
//                    }
                }
                if(rq.equals("ExitPrivate")){
                    //format src::ExitPrivate:des
                    String src = line.split(":")[0];
                    String des = line.split(":")[1];
                    int count=0;
                    for(ChatPrivateClass item:listChatPrivate){
                        String sourceExist = item.getSource();
                        String desExist = item.getDes();
                        if(src.equals(sourceExist) && des.equals(desExist)){
                            listChatPrivate.remove(count);
                        }
                        count++;
                    }
                }

                
            }
        }
        catch(IOException e){
            e.printStackTrace();
            System.out.println("Socket read Error");
        }
    }
        
    
    public void showTableUserOnline(List<String> ListUserOnline){
        DefaultTableModel model = (DefaultTableModel) jtbOnlineUser.getModel();
        model.setRowCount(0);
        for(int i=0; i<ListUserOnline.size();i++){
            model.addRow(new Object[]{ListUserOnline.get(i)});
        }
    }
    public void showTableGroup(List<String> ListGroup){
        DefaultTableModel model = (DefaultTableModel) jTableGroup.getModel();
        model.setRowCount(0);
        for(int i=0; i<ListGroup.size();i++){
            model.addRow(new Object[]{ListGroup.get(i)});
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AllChatFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AllChatFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AllChatFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AllChatFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AllChatFrame(username).setVisible(true);
                
            }
        });
        
    }
   public class Foo implements Runnable {
    private String messtmp2 = null;
    private Socket socket;

    public Foo(Socket socket) {
        this.socket = socket;
    }
    
    public String getMesstmp2() {
        return messtmp2;
    }

    public void setMesstmp2(String messtmp2) {
        this.messtmp2 = messtmp2;
    }
    
    @Override
    public void run(){
        System.out.println("Thread read file");
        DataInputStream is2=null;
        try {
             
             String tmp2 = null;
             is2=new DataInputStream(socket.getInputStream());
             System.out.println("Thread passs read file is2");
             System.out.println("socket : "+socket);
             tmp2 = is2.readUTF();
             System.out.println("is2.readline() : "+tmp2);
            while((tmp2 = is2.readUTF()).isEmpty() || (tmp2 = is2.readUTF())!=null)
            {
                System.out.println("tmp 1: "+tmp2);
                messtmp2+=(tmp2+"\n");
                System.out.println("messtmp2: "+messtmp2);
            }
        } catch (IOException ex) {
            Logger.getLogger(AllChatFrame.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                is2.close();
            } catch (IOException ex) {
                Logger.getLogger(AllChatFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
 }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSend;
    private javax.swing.JButton jButtonAddGroup;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTableGroup;
    private javax.swing.JTextField jTextGroup;
    private javax.swing.JTable jtbOnlineUser;
    private java.awt.Label label1;
    private javax.swing.JTextField txtMess;
    private javax.swing.JTextArea txtareaChatGroup;
    // End of variables declaration//GEN-END:variables
}
