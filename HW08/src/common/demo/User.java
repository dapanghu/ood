package common.demo;

/**
 * This abstract class contains the fields assocaited with the user.
 * Each user has a name, IP address, and AConnect. 
 * @author xc7, bb26
 */

import java.net.InetAddress;

import common.IConnect;
import common.IUser;

public class User implements IUser{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -119130136862198169L;

	private IConnect myConnect;

	private String name;
	
	private InetAddress IP;

	public User(IConnect myConnect, String name, InetAddress IP) {
		this.myConnect = myConnect;
		this.name = name;
		this.IP = IP;
	}

	/**
	 * get AConnect associated with this user
	 */
	public IConnect getConnect() {
		return myConnect;
	}
	
	/**
	 * set AConnect associated with this user
	 */
	public void setConnect(IConnect stub)
	{
		myConnect = stub;
	}
	
	/**
	 * get user name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * set user name
	 */
	public void setName(String name){
		this.name = name;
	}

	/** 
	 * get IP address from this user
	 */
	public InetAddress getIP() {
		return IP;
	}
	
	//Question: Should we allow to change the ip address?
	/** 
	 * set IP address for this user
	 */
	public void setIP(InetAddress newIP) {
		this.IP = newIP;
	}

	/**
     * Overriden equals() method to simply compare hashCodes.
     * @return  Equal if the hashCodes are the same.  False otherwise.
     */
    @Override
    public boolean equals(Object other) {
        return hashCode() == other.hashCode();
    }
    /**
     * Overriden hashCode() method to create a hashcode from all the accessible values in IUser.
     * @return a hashCode tied to the values of this IUser.
     */
    @Override
    public int hashCode() {
            // using IP and name to calculate hashcode.
			int hash = 1;
			hash = hash * 17 + IP.hashCode();
			hash = hash * 31 + name.hashCode();
            return hash;
    }


}