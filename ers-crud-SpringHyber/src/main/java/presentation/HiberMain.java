package presentation;

import io.javalin.Javalin;
import service.RequestService;
import service.RequestServiceImpl;
import service.UserServiceImpl;
import pojo.RequestPojo;
import pojo.UserPojo;

public class HiberMain {

	public static void main(String[] args) {
		Javalin server = Javalin.create((config) -> config.enableCorsForAllOrigins()).start(4040);
		RequestServiceImpl RSI = new RequestServiceImpl();
		UserServiceImpl USI = new UserServiceImpl();
		server.get("hello", (ctx) -> {
			ctx.result("hello");
		});
		
		// http://localhost:4040/api/request
		//endpoint to fetch all requests
		server.get("api/request", (ctx) -> {
			ctx.json(RSI.getAllRequests());
		});
		
		//fetch specific request
		// http://localhost:4040/api/request/{uid}
		server.get("api/request/{uid}", (ctx) -> {
			ctx.json(RSI.getRequestsForUser(Integer.parseInt(ctx.pathParam("uid"))));
		});
		
		//delete a request
		server.delete("api/request/{rid}", (ctx) -> {
			RSI.deleteRequest(Integer.parseInt(ctx.pathParam("rid")));
		});
		
		// http://localhost4040/api/request
		server.post("api/request", (ctx) -> {
			RSI.createRequest(ctx.bodyAsClass(RequestPojo.class));
		});
		
		
		// http://localhost4040/api/request
		server.put("api/request/{rid}/{stat}", (ctx) -> {
			RSI.updateRequest(Integer.parseInt(ctx.pathParam("rid")), ctx.pathParam("stat"));
		});
		
		server.get("api/requestpending", (ctx) ->{
			ctx.json(RSI.getPendingRequests());
		});
		
		server.get("api/request/pending/{uid}", (ctx) ->{
			ctx.json(RSI.getUserPending(Integer.parseInt(ctx.pathParam("uid"))));
			
		});
		
		server.get("api/requestresolved", (ctx) -> {
			ctx.json(RSI.getResolvedRequests());
		});
		
		server.get("api/request/resolved/{uid}", (ctx) -> {
			ctx.json(RSI.getUserResolved(Integer.parseInt(ctx.pathParam("uid"))));
		});
		
		server.get("api/user/login/{email}/{password}", (ctx) -> {
			ctx.json(USI.login(ctx.pathParam("email"), ctx.pathParam("password")));
		});
		
		server.get("api/user/{userId}", (ctx) -> {
			ctx.json(USI.getUserInfo(Integer.parseInt(ctx.pathParam("userId"))));
		});
		
		server.get("api/user", (ctx) -> {
			ctx.json(USI.getAllUsers());
		});
		
		server.put("api/user", (ctx) -> {
			USI.editUser(ctx.bodyAsClass(UserPojo.class));
		});
	}
	
	
}