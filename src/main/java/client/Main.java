package client;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class Main {
	
	public static void main(String[] args) {
		
		Client client = ClientBuilder.newClient();
		String uri = "http://localhost:8080/rest/book";
		Jsonb jsonb = JsonbBuilder.create();
		
		//Get book #1
		String bookJson = client.target(uri + "/1").request(MediaType.APPLICATION_JSON).get(String.class);
		Book book = jsonb.fromJson(bookJson, Book.class);
		System.out.println(book);


		//Create book
		Book dune = new Book(3, "Catcher in the rye", true);;
		System.out.println(dune);

		Response response = client.target(uri).request().post(Entity.entity(jsonb.toJson(dune), MediaType.APPLICATION_JSON));
		System.out.println(response.getStatusInfo() + " " + response.getLocation());

		// Edit news
		String bookJson2 = client.target(uri + "/6").request(MediaType.APPLICATION_JSON).get(String.class);
		Book book2 = jsonb.fromJson(bookJson2, Book.class);
		System.out.println(book2);
		book2.setTitle("EDITED");
		Response response2 = client.target(uri).request().put(Entity.entity(jsonb.toJson(book2), MediaType.APPLICATION_JSON));
		System.out.println(response2.getStatusInfo() + " " + response2.getLocation());
	}
}
