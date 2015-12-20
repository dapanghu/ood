package chatapp.view;

/**
 * The chat app view to model adatper
 * @author ls53@rice.edu
 * @param <TUser>
 * @param <TChatroom>
 */
public interface IChatAppModelAdapter<TUser, TChatroom> {
    
    /**
     * Initialize a user name
     * @param username
     */
    public void initUsername(String username);
    
    /**
     * Connect to an IP address
     * @param ip The IP address
     */
    public void connectTo(String ip);
    
    /**
     * Create a new chatroom
     */
    public void createNewChatroom();
    
    /**
     * Invite a user to a chatroom
     * @param user The invited user
     * @param chatroom The chat room to join
     */
    public void inviteUserToChatroom(TUser user, TChatroom chatroom);
    
    /**
     * Quit all chatrooms
     */
    public void quitAllChatrooms();
}