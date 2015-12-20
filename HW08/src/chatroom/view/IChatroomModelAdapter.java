package chatroom.view;

import javax.swing.ImageIcon;

/**
 * The chat room view to model adapter
 * @author ls53@rice.edu
 */
public interface IChatroomModelAdapter {
    
    /**
     * Send a message
     * @param message The message to send
     */
    public void sendMessage(String message);
    
    /**
     * Send an image
     * @param image The image to send
     */
    public void sendImage(ImageIcon image);
    
    /**
     * Quit the chat room
     */
    public void quiteChatroom();
}
