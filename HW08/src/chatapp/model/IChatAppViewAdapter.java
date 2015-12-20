package chatapp.model;

import chatroom.model.ChatroomModel;
import chatroom.model.IChatroomViewAdapter;
import common.IUser;

/**
 * The chat app model to view adapter
 * @author ls53@rice.edu
 */
public interface IChatAppViewAdapter {
    
    /**
     * Append a message
     * @param message The message to append
     */
    public void append(String message);
    
    /**
     * Add a user
     * @param user The user to add
     */
    public void addUser(IUser user);
    
    /**
     * Get a new chatroom name
     * @return The new chat room name
     */
    public String getNewChatroomName();
    
    /**
     * Make a chat room model to view adapter
     * @param model The chat room model
     * @return The chat room model to view adapter
     */
    public IChatroomViewAdapter makeChatroomViewAdapter(ChatroomModel model);
    
    /**
     * Ask a user if he will join a chat room
     * @param username The user name of the user who send a invitation
     * @param chatroom The chat room
     * @return True if agree, false otherwise
     */
    public boolean willJoinChatroom(String username, String chatroom);
    
    /**
     * Set the UI's title
     * @param title The title
     */
    public void setTitle(String title);
    
    /**
     * Add a chat room
     * @param chatroom The chat room to add
     */
    public void addChatroom(ChatroomModel chatroom);
    
    /**
     * Remove a chat room
     * @param chatroom The chat room to remove
     */
    public void removeChatroom(ChatroomModel chatroom);
    
    /**
     * Send a warning message
     * @param message The message
     */
    public void warn(String message);
}
