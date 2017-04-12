package com.excilys.computerdatabase.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.excilys.computerdatabase.exceptions.IntroducedAfterDiscontinuedException;
import com.excilys.computerdatabase.models.Company;
import com.excilys.computerdatabase.models.Computer;
import com.excilys.computerdatabase.services.ComputerService;

public class ComputerTest {
	
	private ComputerService computerService;
	private Company comp1;
	private Computer c1;
	private Computer c2;
	
	public ComputerTest() {
		computerService = new ComputerService();
		comp1 = new Company.Builder(1, "Apple Inc.").build();
		try {
			c1 = new Computer.Builder("Computer1").id(1000).company(comp1).build();
			c2 = new Computer.Builder("Computer2").id(1001).company(comp1).build();
		} catch (IntroducedAfterDiscontinuedException e) {
			e.printStackTrace();
		}
	}
	
	@Before	
    public void executedBeforeEach() {
		computerService.delete(1000);
		computerService.delete(1001);
    }
	
	@Test
	public void testDelete() {		
		try{
		    
			computerService.add(c1);
			
			assertEquals(c1, computerService.get(1000));
		    
		    computerService.delete(1000);

		    assertNull(computerService.get(1000));

		    
		  } catch (Exception e) {
			  e.printStackTrace();
		} 
	}

	@Test
	public void testGet() {
		
		try{

		    assertEquals(1, computerService.get(1).getId());
		    
		    assertEquals(574, computerService.get().size());
		    
		    assertEquals(10, computerService.getPage(5,10).getObjectNumber());
		    
		    assertNull(computerService.get(1000));

		    
		  } catch (Exception e) {
			  e.printStackTrace();
		} 
	}
	
	@Test
	public void testAdd() {
		
		try{		    
			computerService.add(c1);

		    assertEquals(c1, computerService.get(1000));
		    
		  } catch (Exception e) {
			  e.printStackTrace();
		} 
	}
	
	@Test
	public void testUpdate() {
		
		try{
		    
			computerService.add(c1);
		    c1.setName(c2.getName());
		    computerService.update(c1);

		    assertEquals(c2.getName(), computerService.get(1000).getName());
		    
		  } catch (Exception e) {
			  e.printStackTrace();
		} 
	}
	
	@Test
	public void testGetCompany() {
		
		try{

		    assertEquals(1, computerService.getCompany(1).getId());

		    
		  } catch (Exception e) {
			  e.printStackTrace();
		} 
	}
}
