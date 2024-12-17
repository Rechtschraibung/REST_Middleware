package rest.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "electionData")
public class WarehouseData {

	private String regionAddress;
	private String regionID;
	private String regionName;
	private String postalCode;

	private String federalState;
	private String timestamp;

	private List<PartyVotes> countingData;

	/* RegionID */
	@XmlElement
	public String getRegionID() {
		return regionID;
	}

	public void setRegionID(String regionID) {
		this.regionID = regionID;
	}

	/* RegionName */
	@XmlElement
	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	/* RegionAddress */
	@XmlElement
	public String getRegionAddress() {
		return regionAddress;
	}

	public void setRegionAddress(String regionAddress) {
		this.regionAddress = regionAddress;
	}

	/* PostalCode */
	@XmlElement
	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/* Federal State */
	@XmlElement
	public String getFederalState() {
		return federalState;
	}

	public void setFederalState(String federalState) {
		this.federalState = federalState;
	}

	/* Timestamp */
	@XmlElement
	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@XmlElement(name = "party")
	public List<PartyVotes> getCountingData() {
		return countingData;
	}

	public void setCountingData(List<PartyVotes> countingData) {
		this.countingData = countingData;
	}
}
