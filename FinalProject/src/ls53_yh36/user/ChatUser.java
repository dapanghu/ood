package ls53_yh36.user;

import java.io.Serializable;
import java.rmi.RemoteException;

import common.IChatUser;
import common.message.IChatMessage;
import provided.datapacket.DataPacket;
import provided.datapacket.DataPacketAlgo;

/**
 * The chat user implementation
 * @author ls53@rice.edu
 *
 */
public class ChatUser implements IChatUser, Serializable {
    
    /**
     * The generated serial version UID
     */
    private static final long serialVersionUID = 6409238694307962072L;

    /**
     * The name
     */
    private String name;
    
    /**
     * The ip
     */
    private String ip;
    
    /**
     * The data packet algorithm
     */
    private DataPacketAlgo<String, IChatUser> dataPacketAlgo;
    
    /**
     * Constructor
     * @param name The name
     * @param ip The IP
     * @param dataPacketAlgo The data packet algorithm
     */
    public ChatUser(String name, String ip, DataPacketAlgo<String, IChatUser> dataPacketAlgo) {
        this.name = name;
        this.ip = ip;
        this.dataPacketAlgo = dataPacketAlgo;
    }

    /**
     * Receive a message
     * @param sender The sender
     * @param dp The data packet
     */
    @Override
    public void receive(IChatUser sender, DataPacket<? extends IChatMessage> dp) throws RemoteException {
        dp.execute(dataPacketAlgo, sender);
    }
    
    /**
     * Get the name
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * Get the IP
     * @return The IP
     */
    public String getIp() {
        return ip;
    }

    /**
     * Set the IP
     * @param ip The IP
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * Set the name
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * To String method
     * @return The result
     */
    @Override
    public String toString() {
        return name;
    }
}
