
package chatsocket;
public class ChatPrivateClass {
    private PrivateChatFrame chatprivate;
    private String source;
    private String des;
    public ChatPrivateClass(){
        
    }

    public ChatPrivateClass(PrivateChatFrame chatprivate, String source, String des) {
        this.chatprivate = chatprivate;
        this.source = source;
        this.des = des;
    }

    public PrivateChatFrame getChatprivate() {
        return chatprivate;
    }

    public void setChatprivate(PrivateChatFrame chatprivate) {
        this.chatprivate = chatprivate;
    }
   

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
    
}
