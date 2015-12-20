package chatroom.model;

import java.awt.Container;
import java.awt.Image;

import common.IUser;

/**
 * The chat room model to view adatper
 * @author ls53@rice.edu
 *
 */
public interface IChatroomViewAdapter {
    
    /**
     * Start the chat room view
     */
    public void start();
    
    /**
     * Append a message to the view
     * @param user The user who send this message
     * @param message The message
     */
    public void append(IUser user, String message);
    
    /**
     * Add a user
     * @param user The user to add
     */
    public void addUser(IUser user);
    
    /**
     * Remove a user
     * @param user The user to remove
     */
    public void removeUser(IUser user);
    
    /**
     * Send a warning message
     * @param message The warning message
     */
    public void warn(String message);
    
    public void setTitle(String title);
    
    public Container createImageView();

    public void showImage(Container container, Image image);
}
