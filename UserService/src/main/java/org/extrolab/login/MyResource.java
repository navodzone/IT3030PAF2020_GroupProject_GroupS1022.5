package org.extrolab.login;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("login")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got i sadsadst!";
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public UserResponse createCustomer(@FormParam("userName") String username,
                                 @FormParam("password") String password) {
		UserDAO userDAO = new UserDAOImpl();
		User user = userDAO.getUser(username, password);
		UserResponse userRes = new UserResponse();
		if(user != null && user.getUsername() != null) {
			userRes.setStatus(true);
			userRes.setUsername(user.getUsername());
		} else {
			userRes.setStatus(false);
			userRes.setUsername(null);
			
		}
            return userRes;
        }
}
