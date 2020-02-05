package ai.realitics.lgu.manager;

import ai.realitics.lgu.manager.model.Lgu;
import ai.realitics.lgu.manager.model.LguCounty;
import ai.realitics.lgu.manager.model.LguStatus;

public class ObjectFactory {

	public static LguCounty createLguCounty() {
		LguCounty lguCounty = new LguCounty();
		lguCounty.setName("Grad Zagreb");

		return lguCounty;
	}

	public static Lgu createLgu() {
		Lgu lgu = new Lgu();
		lgu.setName("Grad Zagreb");
		lgu.setLguCounty(createLguCounty());
		lgu.setStatus(LguStatus.City);

		return lgu;
	}

}
