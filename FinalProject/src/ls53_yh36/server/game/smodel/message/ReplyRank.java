package ls53_yh36.server.game.smodel.message;

import java.util.UUID;

import common.message.IChatMessage;
import provided.datapacket.DataPacket;

/**
 * Replay rank message
 * @author ls53@rice.edu
 */
public class ReplyRank implements IChatMessage {

    /**
     * The generated serial version UID
     */
	private static final long serialVersionUID = 5820001539650160343L;

	/**
	 * The rank
	 */
	private String rank;
	
	/**
	 * The constructor
	 * @param res The result
	 */
	public ReplyRank(String res) {
		rank = res;
	}
	
	/**
	 * Get ID
	 * @return The ID
	 */
	@Override
	public UUID getID() {
		return null;
	}

	/**
	 * Get data packet
	 * @return The data packet
	 */
	@Override
	public DataPacket<? extends IChatMessage> getDataPacket() {
		return new DataPacket<ReplyRank>(ReplyRank.class, this);
	}
	
	/**
	 * String shows the rank of the team
	 * @return Return the team's rank in string
	 */
	public String rank() {
		return rank;
	}

}
