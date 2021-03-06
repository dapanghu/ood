package ls53_yh36.client.app.view;

/**
 * The App view to model adapter
 * @author ls53@rice.edu
 */
/**
 * The App view to model adapter
 * @author ls53@rice.edu
 * @param <TUser> Generic user type
 * @param <TChatroom> Generic chatroom type
 */
public interface IAppModelAdapter<TUser, TChatroom> {
    
    /**
     * Set a user name
     * @param username The user name to set
     */
    public void setUsername(String username);
    
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
     * Join a user's chatroom
     * @param user The user to join
     */
    public void join(TUser user);
    
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