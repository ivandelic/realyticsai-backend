package ai.realitics.lgu.manager.information;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import ai.realitics.common.exception.MessageCode;
import ai.realitics.common.exception.RealyticsAiException;
import ai.realitics.lgu.manager.interfaces.information.ILguManagerInformation;
import ai.realitics.lgu.manager.model.Lgu;
import ai.realitics.lgu.manager.model.LguCounty;

@Dependent
public class LguManagerInformation implements ILguManagerInformation {

	@PersistenceContext(unitName = "lgu-manager-persistence")
	private EntityManager em;

	@Override
	public List<Lgu> listLgus() {
		em.clear(); // FIXME witchcraft clearing em!
		List<Lgu> pp = queryItems("listLgus", null, Lgu.class);

		return pp;
	}

	@Override
	public Lgu readLgu(Integer id) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("id", id);

		return querySingleItem("readLgu", parameters, Lgu.class);
	}

	@Override
	@Transactional(Transactional.TxType.REQUIRED)
	public Lgu updateLgu(Lgu lgu) throws RealyticsAiException {
		if (lgu == null)
			throw new RealyticsAiException(MessageCode.ERROR_GENERAL_MISSING_INPUT_OBJECT);
		if (lgu.getId() == null)
			throw new RealyticsAiException(MessageCode.ERROR_GENERAL_MISSING_ID_UPDATE);

		lgu = em.merge(lgu);
		em.flush();

		return lgu;
	}

	@Override
	@Transactional(Transactional.TxType.REQUIRED)
	public Lgu createLgu(Lgu lgu) throws RealyticsAiException {
		if (lgu == null)
			throw new RealyticsAiException(MessageCode.ERROR_GENERAL_MISSING_INPUT_OBJECT);
		if (lgu.getId() != null)
			throw new RealyticsAiException(MessageCode.ERROR_GENERAL_PROVIDED_ID_INSERT);

		lgu = em.merge(lgu);
		em.flush();

		return lgu;
	}

	@Override
	@Transactional(Transactional.TxType.REQUIRED)
	public Lgu deleteLgu(Integer id) throws RealyticsAiException {
		if (id == null)
			throw new RealyticsAiException(MessageCode.ERROR_GENERAL_MISSING_ID_DELETE);

		Lgu lgu = readLgu(id);
		lgu.setArchived(true);

		lgu = em.merge(lgu);
		em.flush();

		return lgu;
	}

	@Override
	public List<LguCounty> listLguCounties() {
		return queryItems("listLguCounties", null, LguCounty.class);
	}
	
	@Override
	public LguCounty readLguCounty(Integer id) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("id", id);

		return querySingleItem("readRegion", parameters, LguCounty.class);
	}

	@Override
	@Transactional(Transactional.TxType.REQUIRED)
	public LguCounty updateLguCounty(LguCounty region) throws RealyticsAiException {
		if (region == null)
			throw new RealyticsAiException(MessageCode.ERROR_GENERAL_MISSING_INPUT_OBJECT);
		if (region.getId() == null)
			throw new RealyticsAiException(MessageCode.ERROR_GENERAL_MISSING_ID_UPDATE);

		region = em.merge(region);
		em.flush();

		return region;
	}

	@Override
	@Transactional(Transactional.TxType.REQUIRED)
	public LguCounty createLguCounty(LguCounty region) throws RealyticsAiException {
		if (region == null)
			throw new RealyticsAiException(MessageCode.ERROR_GENERAL_MISSING_INPUT_OBJECT);
		if (region.getId() != null)
			throw new RealyticsAiException(MessageCode.ERROR_GENERAL_PROVIDED_ID_INSERT);

		region = em.merge(region);
		em.flush();

		return region;
	}

	@Override
	@Transactional(Transactional.TxType.REQUIRED)
	public LguCounty deleteLguCounty(Integer id) throws RealyticsAiException {
		if (id == null)
			throw new RealyticsAiException(MessageCode.ERROR_GENERAL_MISSING_ID_DELETE);

		LguCounty region = readLguCounty(id);
		region.setArchived(true);

		region = em.merge(region);
		em.flush();

		return region;
	}

	private <T> T querySingleItem(String queryName, Map<String, Object> parameters, Class<T> _class) {
		TypedQuery<T> query = (TypedQuery<T>) em.createNamedQuery(queryName, _class);

		for (String item : parameters.keySet())
			query.setParameter(item, parameters.get(item));
		query.setMaxResults(1);

		List<T> results = query.getResultList();

		return results.isEmpty() ? null : results.get(0);
	}

	private <T> List<T> queryItems(String queryName, Map<String, Object> parameters, Class<T> _class) {
		TypedQuery<T> query = (TypedQuery<T>) em.createNamedQuery(queryName, _class);

		if (parameters != null)
			for (String item : parameters.keySet())
				query.setParameter(item, parameters.get(item));

		return query.getResultList();
	}
}
