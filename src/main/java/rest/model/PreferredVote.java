package rest.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PreferredVote {

    private int listNumber;
    private String candidateName;
    private int votes;

    public PreferredVote(int listNumber, String candidateName, int votes) {
        this.listNumber = listNumber;
        this.candidateName = candidateName;
        this.votes = votes;
    }

    /* ListNumber */
    @XmlElement
    public int getListNumber() {
        return listNumber;
    }

    public void setListNumber(int listNumber) {
        this.listNumber = listNumber;
    }

    /* Candidate Name */
    @XmlElement
    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    /* Votes */
    @XmlElement
    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }
}
