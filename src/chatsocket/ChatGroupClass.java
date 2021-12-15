
package chatsocket;
public class ChatGroupClass {
    private ChatGroupFrame chatgroup;
    private String source;
    private String groupName;
    public ChatGroupClass(){
        
    }

    public ChatGroupClass(ChatGroupFrame chatgroup, String source, String groupName) {
        this.chatgroup = chatgroup;
        this.source = source;
        this.groupName = groupName;
    }

    public ChatGroupFrame getChatgroup() {
        return chatgroup;
    }

    public void setChatgroup(ChatGroupFrame chatgroup) {
        this.chatgroup = chatgroup;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    
}
