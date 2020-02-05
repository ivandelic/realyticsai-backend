package ai.realitics.lgu.manager.integration;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;

import ai.realitics.lgu.manager.information.LguManagerInformation;
import ai.realitics.lgu.manager.interfaces.integration.ILguManagerService;
import ai.realitics.lgu.manager.model.Lgu;
import ai.realitics.lgu.manager.model.LguCounty;
import ai.realitics.common.exception.RealyticsAiException;

@Path("/lgu-manager")
@RequestScoped
public class LguManagerService implements ILguManagerService {

	@Inject
	private LguManagerInformation pri;

	@Produces(MediaType.APPLICATION_JSON)
	@Path("/lgus")
	@GET
	@Override
	public List<Lgu> listLgus() {
		List<Lgu> lgus = pri.listLgus();
		return lgus;
	}

	@Produces(MediaType.APPLICATION_JSON)
	@Path("/lgu/{id}")
	@GET
	@Override
	public Lgu readLgu(@PathParam("id") Integer id) {
		Lgu Lgu = pri.readLgu(id);
		return Lgu;
	}

	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/lgu/")
	@POST
	@Operation(summary = "Update Lgu", description = "Method updates Lgu.")
	@Override
	public Lgu updateLgu(Lgu lgu) throws RealyticsAiException {
		return pri.updateLgu(lgu);
	}

	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/lgu/")
	@PUT
	@Operation(summary = "Create Lgu", description = "Method creates new Lgu.")
	@Override
	public Lgu createLgu(Lgu lgu) throws RealyticsAiException {
		return pri.createLgu(lgu);
	}

	@Produces(MediaType.APPLICATION_JSON)
	@Path("/lgu/{id}")
	@DELETE
	@Operation(summary = "Delete Lgu", description = "Method deletes Lgu.")
	@Override
	public Lgu deleteLgu(@PathParam("id") Integer id) throws RealyticsAiException {
		return pri.deleteLgu(id);
	}

	@Produces(MediaType.APPLICATION_JSON)
	@Path("/lgu-counties")
	@GET
	@Override
	public List<LguCounty> listLguCounties() {
		return pri.listLguCounties();
	}
	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/lgu-county/{id}")
	@GET
	@Override
	public LguCounty readLguCounty(@PathParam("id") Integer id) {
		LguCounty lguCounty = pri.readLguCounty(id);
		return lguCounty;
	}

	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/lgu-county/")
	@POST
	@Operation(summary = "Update Lgu County", description = "Method updates region.")
	@Override
	public LguCounty updateLguCounty(LguCounty lguCounty) throws RealyticsAiException {
		return pri.updateLguCounty(lguCounty);
	}

	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/lgu-county/")
	@PUT
	@Operation(summary = "Create Region", description = "Method creates new region.")
	@Override
	public LguCounty createLguCounty(LguCounty lguCounty) throws RealyticsAiException {
		return pri.createLguCounty(lguCounty);
	}

	@Produces(MediaType.APPLICATION_JSON)
	@Path("/lgu-county/{id}")
	@DELETE
	@Operation(summary = "Delete Region", description = "Method deletes region.")
	@Override
	public LguCounty deleteLguCounty(@PathParam("id") Integer id) throws RealyticsAiException {
		return pri.deleteLguCounty(id);
	}
}
