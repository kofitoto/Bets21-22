package test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import dataAccess.DataAccess;
import domain.Admin;
import domain.Bezeroa;
import domain.Langilea;
import domain.Pertsona;
import exceptions.UserAlreadyExist;

public class RegisterTest {
	private DataAccess dataAccessMock = Mockito.mock (DataAccess.class);
	private BLFacade sut = new BLFacadeImplementation(dataAccessMock);
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(dataAccessMock);
	}

	@Test
	@DisplayName("Test 1: Prueba ")
	public void test1() {

			try {
				Mockito.doReturn(UserAlreadyExist.class).when(dataAccessMock).register("Jon", "Perez", "Perez", 
						"Jon99","98shcs9", "666699999","jon@ikasle.com", new Date(02,02,1999), "admin");
				assertThrows(UserAlreadyExist.class, ()-> sut.register("Jon", "Perez", "Perez", "Jon99"
						,"98shcs9", "666699999","jon@ikasle.com", new Date(02,02,1999), "admin"));
			} catch (UserAlreadyExist e) {
				e.printStackTrace();
			}	
	}
	@Test
	@DisplayName("Test 2: Prueba ")
	public void test2() {
		try {
			Mockito.doReturn(new Admin("Jon", "Perez", "Perez", "Jon99","98shcs9", "666699999",
					"jon@ikasle.com", new Date(02,02,1999))).when(dataAccessMock).register("Jon", "Perez",
					"Perez", "Jon99","98shcs9", "666699999","jon@ikasle.com", new Date(02,02,1999), "admin");
			Admin a;
			a = (Admin) sut.register("Jon", "Perez", "Perez", "Jon99","98shcs9", "666699999",
					"jon@ikasle.com", new Date(02,02,1999), "admin");
			assertTrue(a.getIzena() == "Jon");
		} catch (UserAlreadyExist e) {
			e.printStackTrace();
		}	
}
	@Test
	@DisplayName("Test 3: Prueba ")
	public void test3() {
		try {
			Mockito.doReturn(new Langilea("Jon", "Perez", "Perez", "Jon99","98shcs9", "666699999",
					"jon@ikasle.com", new Date(02,02,1999))).when(dataAccessMock).register("Jon", "Perez", 
					"Perez", "Jon99","98shcs9", "666699999","jon@ikasle.com", new Date(02,02,1999), "langilea");
			Admin a;
			a = (Admin) sut.register("Jon", "Perez", "Perez", "Jon99","98shcs9", "666699999",
					"jon@ikasle.com", new Date(02,02,1999), "langilea");
			assertTrue(a.getIzena() == "Jon");
		} catch (UserAlreadyExist e) {
			e.printStackTrace();
		}	
	}
	@Test
	@DisplayName("Test 4: Prueba ")
	public void test4() {
		try {
			Mockito.doReturn(new Bezeroa("Jon", "Perez", "Perez", "Jon99","98shcs9", "666699999",
					"jon@ikasle.com", new Date(02,02,1999))).when(dataAccessMock).register("Jon", "Perez", 
					"Perez", "Jon99","98shcs9", "666699999",	"jon@ikasle.com", new Date(02,02,1999), "bezeroa");
			Admin a;
			a = (Admin) sut.register("Jon", "Perez", "Perez", "Jon99","98shcs9", "666699999",
					"jon@ikasle.com", new Date(02,02,1999), "bezeroa");
			assertTrue(a.getIzena() == "Jon");
		} catch (UserAlreadyExist e) {
			e.printStackTrace();
		}	
	}
	@Test
	@DisplayName("Test 5: Prueba ")
	public void test5() {
		try {
			Mockito.doReturn(false).when(dataAccessMock).register("1","1","1","1","1","1","1",new Date (1),"1");
			sut.register("1","1","1","1","1","1","1",new Date (1),"1");
		} catch (UserAlreadyExist e) {
			e.printStackTrace();
		}	
	}
}