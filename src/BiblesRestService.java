import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RequestScoped
@Path("/john1")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class BiblesRestService {

	@Inject 
	BibleBusinessService bbs;
	
	@GET
	@Path("/find/{word}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getJohnOne(@PathParam("word") String word) 
	{
		return bbs.findOccurences(word);
	}
}
