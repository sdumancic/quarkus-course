package org.agoncal.quarkus.panache.resource;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import org.agoncal.quarkus.jdbc.Artist;
import org.agoncal.quarkus.panache.model.Publisher;
import org.agoncal.quarkus.panache.repository.ArtistRepository;

import java.util.List;

@RequestScoped
@Path("/api/publishers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PublisherResource {

    @GET
    @Path("{id}")
    public Publisher findPublisherById(@PathParam("id") Long id){
        return (Publisher) Publisher.findByIdOptional(id).orElseThrow(NotFoundException::new);
    }

    @GET
    public List<Publisher> findPublishers(){
        return Publisher.listAll();
    }

    @Transactional
    @POST
    public Response persist(Publisher publisher, @Context UriInfo uriInfo){
        Publisher.persist(publisher);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder().path(Long.toString(publisher.id));
        return Response.created(builder.build()).build();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public void deletePublisher(@PathParam("id") Long id){
        Publisher.deleteById(id);
    }

}
