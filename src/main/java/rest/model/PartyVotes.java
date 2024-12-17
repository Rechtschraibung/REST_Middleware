package rest.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class PartyVotes {

    private String partyID;
    private int amountVotes;

    private List<PreferredVote> preferredVotes;

    public PartyVotes(String partyID, int amountVotes, List<PreferredVote> preferredVotes) {
        this.partyID = partyID;
        this.amountVotes = amountVotes;
        this.preferredVotes = preferredVotes;
    }

    /* PartyID */
    @XmlElement
    public String getPartyID() {
        return partyID;
    }

    public void setPartyID(String partyID) {
        this.partyID = partyID;
    }

    /* Votes */
    @XmlElement
    public int getAmountVotes() {
        return amountVotes;
    }

    public void setAmountVotes(int amountVotes) {
        this.amountVotes = amountVotes;
    }

    @XmlElement(name = "preferredVote")
    public List<PreferredVote> getPreferredVotes() {
        return preferredVotes;
    }

    public void setPreferredVotes(List<PreferredVote> preferredVotes) {
        this.preferredVotes = preferredVotes;
    }
}
