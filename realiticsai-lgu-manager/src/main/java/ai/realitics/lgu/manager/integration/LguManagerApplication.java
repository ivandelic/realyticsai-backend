package ai.realitics.lgu.manager.integration;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import ai.realitics.lgu.manager.CORSFilter;
import ai.realitics.common.exception.RealyticsAiExceptionMapper;

@ApplicationScoped
@ApplicationPath("/")
public class LguManagerApplication extends Application {

	private final Set<Class<?>> classes;

	public LguManagerApplication() {
		super();
		final Set<Class<?>> classes = new HashSet<>();
		classes.add(LguManagerService.class);
		classes.add(RealyticsAiExceptionMapper.class);
		classes.add(CORSFilter.class);
		this.classes = Collections.unmodifiableSet(classes);
	}

	@Override
	public Set<Class<?>> getClasses() {
		return this.classes;
	}
}