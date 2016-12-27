package root;

public class Friendship {
	
	private String requester_username;
	private String requested_username;
	private String Whenrequested;
	private String whenwithdrawn;
	private String whenrejected;
	private String whenconfirmed;
	private String whenunfriended;
	
	Friendship(String from,String to,String whenreq,String whenwd,String whenrej,String whencon,String unfrnd)
	{
		requester_username=from;
		requested_username=to;
		Whenrequested=whenreq;
		whenwithdrawn=whenwd;
		whenrejected=whenrej;
		whenconfirmed=whencon;
		whenunfriended=whencon;
	}

	public String getRequester_username() {
		return requester_username;
	}

	public void setRequester_username(String requester_username) {
		this.requester_username = requester_username;
	}

	public String getRequested_username() {
		return requested_username;
	}

	public void setRequested_username(String requested_username) {
		this.requested_username = requested_username;
	}

	public String getWhenrejected() {
		return whenrejected;
	}

	public void setWhenrejected(String whenrejected) {
		this.whenrejected = whenrejected;
	}

	public String getWhenconfirmed() {
		return whenconfirmed;
	}

	public void setWhenconfirmed(String whenconfirmed) {
		this.whenconfirmed = whenconfirmed;
	}
	
}
