package test;

import static org.junit.Assert.*;
import java.time.LocalDate;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import dataAccess.DataAccess;
import domain.Admin;
import domain.Bezeroa;
import domain.Langilea;
import exceptions.UserAlreadyExist;

public class RegisterTest {
	private static final LocalDate JAIOTZE_DATA = LocalDate.of(1999,02,02);
	private static final String ADMIN = "admin";
	private static final String CORREOA = "jon@ikasle.com";
	private static final String TELEFONOA = "666699999";
	private static final String PASAHITZA = "98shcs9";
	private static final String JON99 = "Jon99";
	private static final String PEREZ = "Perez";
	private DataAccess dataAccessMock = Mockito.mock (DataAccess.class);
	private BLFacade sut = new BLFacadeImplementation(dataAccessMock);
	

	public void setUp() {
		MockitoAnnotations.initMocks(dataAccessMock);
	}

	

	public void test1() {

			try {
				Mockito.doReturn(UserAlreadyExist.class).when(dataAccessMock).register("Jon", PEREZ, PEREZ, 
						JON99,PASAHITZA, TELEFONOA,CORREOA, JAIOTZE_DATA, ADMIN);
				assertThrows(UserAlreadyExist.class, ()-> sut.register("Jon", PEREZ, PEREZ, JON99
						,PASAHITZA, TELEFONOA,CORREOA, JAIOTZE_DATA, ADMIN));
			} catch (UserAlreadyExist e) {
				e.printStackTrace();
			}	
	}
	

	public void test2() {
		try {
			Mockito.doReturn(new Admin("Jon", PEREZ, PEREZ, JON99,PASAHITZA, TELEFONOA,
					CORREOA, JAIOTZE_DATA)).when(dataAccessMock).register("Jon", PEREZ,
					PEREZ, JON99,PASAHITZA, TELEFONOA,CORREOA, JAIOTZE_DATA, ADMIN);
			Admin a;
			a = (Admin) sut.register("Jon", PEREZ, PEREZ, JON99,PASAHITZA, TELEFONOA,
					CORREOA, JAIOTZE_DATA, ADMIN);
			assertTrue(a.getIzena().equals("Jon"));
		} catch (UserAlreadyExist e) {
			e.printStackTrace();
		}	
}
	
	public void test3() {
		try {
			Mockito.doReturn(new Langilea("Jon", PEREZ, PEREZ, JON99,PASAHITZA, TELEFONOA,
					CORREOA, JAIOTZE_DATA)).when(dataAccessMock).register("Jon", PEREZ, 
					PEREZ, JON99,PASAHITZA, TELEFONOA,CORREOA, JAIOTZE_DATA, "langilea");
			Admin a;
			a = (Admin) sut.register("Jon", PEREZ, PEREZ, JON99,PASAHITZA, TELEFONOA,
					CORREOA, JAIOTZE_DATA, "langilea");
			assertTrue(a.getIzena().equals("Jon"));
		} catch (UserAlreadyExist e) {
			e.printStackTrace();
		}	
	}

	public void test4() {
		try {
			Mockito.doReturn(new Bezeroa("Jon", PEREZ, PEREZ, JON99,PASAHITZA, TELEFONOA,
					CORREOA, JAIOTZE_DATA)).when(dataAccessMock).register("Jon", PEREZ, 
					PEREZ, JON99,PASAHITZA, TELEFONOA,	CORREOA, JAIOTZE_DATA, "bezeroa");
			Admin a;
			a = (Admin) sut.register("Jon", PEREZ, PEREZ, JON99,PASAHITZA, TELEFONOA,
					CORREOA, JAIOTZE_DATA, "bezeroa");
			assertTrue(a.getIzena().equals("Jon") );
		} catch (UserAlreadyExist e) {
			e.printStackTrace();
		}	
	}

	public void test5() {
		try {
			Mockito.doReturn(false).when(dataAccessMock).register("1","1","1","1","1","1","1",JAIOTZE_DATA,"1");
			sut.register("1","1","1","1","1","1","1",JAIOTZE_DATA,"1");
		} catch (UserAlreadyExist e) {
			e.printStackTrace();
		}	
	}
}