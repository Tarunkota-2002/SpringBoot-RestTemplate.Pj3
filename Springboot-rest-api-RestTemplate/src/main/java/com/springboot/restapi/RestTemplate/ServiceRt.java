package com.springboot.restapi.RestTemplate;

import java.util.HashMap;
import java.util.Map;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServiceRt {
	
public String createuser() {
	UserRestTemplatedto user = new UserRestTemplatedto();
    user.setName("Om");
    user.setMailid("Om@google.com");
    UserRestTemplatedto user1= new UserRestTemplatedto("Shanmukha@gmail.com","Shanmukha");
  
 //  Request Body for above 
	HttpEntity<UserRestTemplatedto> httpEntity = new HttpEntity<UserRestTemplatedto>(user);
	HttpEntity<UserRestTemplatedto> httpEntity2= new HttpEntity<UserRestTemplatedto>(user1);
	RestTemplate resttemplate = new RestTemplate();
	//resttemplate.exchange("http://localhost:876/get/create/user",  httpEntity, String.class);
	//request type for http request and request body and response type if it is array orlist list<userdetails>
	ResponseEntity<String>response= resttemplate.exchange("http://localhost:#####/get/create/user", HttpMethod.POST, httpEntity, String.class);
		ResponseEntity<String>	response1 = resttemplate.exchange("http://localhost:#####/get/create/user", HttpMethod.POST,httpEntity2,String.class);
			
	System.out.println(response.getStatusCode());
	System.out.println(response1.getStatusCode());
	return response.getBody() +  response1.getBody();
	}
	//resttemplate.exchange();

public String getInformation() {
	//HttpEntity<UserRestTemplatedto> httpEntity = new HttpEntity<UserRestTemplatedto>(user);
	RestTemplate resttemplate = new RestTemplate();
	Map<String, String> values = new HashMap<>();
	values.put("name", "Dharmasasthra");
	//values.put("mailid",Dharmasasthra@microsoft.com")
	String url ="http://localhost:876/get/user/{name}"; //?key={value}} if it is query parameters
	///{name}/{mailid} //path varaiable
	
	 ResponseEntity<String> response =resttemplate.getForEntity(url, String.class, values);
	 return response.getBody();
	
	//if return typr is list then response type islist.class map object values
}

public String getinfo() {
	RestTemplate resttemplate=new RestTemplate();
	Map<String, String>values=new HashMap<>();
	values.put("name","Shanmukha@gmail.com");
    
	String url ="http://localhost:876/get/user/{name}";
    ResponseEntity<String> response= resttemplate.getForEntity(url, String.class, values);
    return response.getBody() ;
}
}
