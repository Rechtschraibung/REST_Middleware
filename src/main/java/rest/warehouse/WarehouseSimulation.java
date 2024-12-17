package rest.warehouse;

import rest.model.WarehouseData;
import rest.model.PartyVotes;
import rest.model.PreferredVote;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class WarehouseSimulation {
	Random rng = new Random();

	public WarehouseData getData(String inID) {
		WarehouseData data = new WarehouseData();

		data.setRegionID(inID);
		data.setRegionName("Wien Rudolfsheim");
		data.setRegionAddress("Wien Westbahnhof");
		data.setPostalCode("1150");
		data.setFederalState("Wien");

		data.setTimestamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

		List<PartyVotes> votes = Arrays.asList(
				new PartyVotes(
						"OEVP",
						rng.nextInt(600, 1200),
						generatePreferredVotes()
				),

				new PartyVotes(
						"SPOE",
						rng.nextInt(570, 800),
						generatePreferredVotes()
				),

				new PartyVotes(
						"FPOE",
						rng.nextInt(600, 800),
						generatePreferredVotes()
				),

				new PartyVotes(
						"GRUENE",
						rng.nextInt(300, 500),
						generatePreferredVotes()
				),

				new PartyVotes(
						"NEOS",
						rng.nextInt(330, 600),
						generatePreferredVotes()
				)
		);

		data.setCountingData(votes);
		return data;
	}

	private List<PreferredVote> generatePreferredVotes() {
		List<PreferredVote> preferredVotes = new ArrayList<>();

		preferredVotes.add(new PreferredVote(1, "John John", rng.nextInt(50, 70)));
		preferredVotes.add(new PreferredVote(2, "Max M. Mustermann", rng.nextInt(31, 45)));
		preferredVotes.add(new PreferredVote(3, "Disa Y. Ene", rng.nextInt(20, 30)));
		preferredVotes.add(new PreferredVote(4, "Di Z. Ertyp", rng.nextInt(0, 20)));

		return preferredVotes;
	}
}
