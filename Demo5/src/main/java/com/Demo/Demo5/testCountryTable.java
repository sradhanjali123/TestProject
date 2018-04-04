package com.Demo.Demo5;

import java.lang.reflect.Type;

import java.util.Collection;

import javax.persistence.EntityManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;



public class testCountryTable {
	
	public  void readCountry() {
		//List<String> countries = new ArrayList<String>();
		
		try {
			HttpResponse<String> response = Unirest.get("https://restcountries.eu/rest/v2/all")
					  .header("cache-control", "no-cache")
					  .header("postman-token", "e7f56ba2-6758-5ce0-6bbe-219cfd766535")
					  .asString();
			//System.out.println(response.getBody());
			String responseStr = response.getBody();
			
			if(responseStr.equals("[]")) {
				System.out.println("Returned empty array. Ignoring");
				return;
			}
			
			Type collectionType = new TypeToken<Collection<tableValue>>(){}.getType();
			Collection<tableValue> enums = new Gson().fromJson(responseStr, collectionType);
			
			/*Type listType = new TypeToken<ArrayList<String>>(){}.getType();
			ArrayList<String> countryList = new Gson().fromJson(responseStr, listType);*/
			
			System.out.println("total_country: " + enums.size());
			 
	           EntityManager entityManager = ResourceBase.INSTANCE.getEntityManager();
	           entityManager.getTransaction().begin();
				
			
			 for(tableValue e: enums){
		           //System.out.println("Name---->"+e.getName());
		           //System.out.println(e.getEmpId());
//		           String coun_name = e.getName();
//		           String alphaCode = e.getAlpha3code();
//		           String capit = e.getCapital();
//		           String flag = e.getFlag();
//		           long id = e.getId();
		          
		           //int i= 1;
		           //tableValue counobj = new tableValue();
		          
//		           e.setId(id);
//		           e.setName(coun_name);
//		           e.setAlpha3code(alphaCode);
//		           e.setCapital(capit);
//		           e.setFlag(flag);
				 entityManager.persist(e);
				 System.out.println("total_country: " + enums.size());
				 
		                
			 }
			 entityManager.flush();
				entityManager.clear();
				entityManager.getTransaction().commit();
			 
			
		} catch(Exception e) {
			System.out.println("err: " + e);
		}
	}

}
