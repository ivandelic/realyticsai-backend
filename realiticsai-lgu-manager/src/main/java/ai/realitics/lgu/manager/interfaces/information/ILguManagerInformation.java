package ai.realitics.lgu.manager.interfaces.information;

import java.util.List;

import ai.realitics.common.exception.RealyticsAiException;
import ai.realitics.lgu.manager.model.Lgu;
import ai.realitics.lgu.manager.model.LguCounty;

public interface ILguManagerInformation {

	public List<Lgu> listLgus();

	public Lgu readLgu(Integer id);

	public Lgu updateLgu(Lgu lgu) throws RealyticsAiException;

	public Lgu createLgu(Lgu lgu) throws RealyticsAiException;

	public Lgu deleteLgu(Integer id) throws RealyticsAiException;

	public List<LguCounty> listLguCounties();
	
	public LguCounty readLguCounty(Integer id);

	public LguCounty updateLguCounty(LguCounty lguCounty) throws RealyticsAiException;

	public LguCounty createLguCounty(LguCounty lguCounty) throws RealyticsAiException;

	public LguCounty deleteLguCounty(Integer id) throws RealyticsAiException;
}
