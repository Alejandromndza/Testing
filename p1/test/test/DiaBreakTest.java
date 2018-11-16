package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import Agenda.*;

class DiaBreakTest {
	
	@Test
	void testBuild() {
		
		try {
			DiaBreak dia = new DiaBreak(300);
			
		} catch (DatoException e) {
			fail("Wrong parameters");
			e.printStackTrace();
		}
		
	}

	@Test
	void testAsignarCita() {
		
		DiaBreak agenda = null;
		
		try {
			
			agenda = new DiaBreak(200);
			
		} catch (DatoException e) {
			fail("Wrong parameters");
			e.printStackTrace();
		}
		
		Cita nuevaCita = new Cita("cita 1", 1);
		Cita nuevaCitaSolapacion = new Cita("cita 1", 5);
		
		assertEquals(agenda.asignarCita(16, nuevaCita), true);
		assertEquals(agenda.asignarCita(9, nuevaCita), true);
		
		//Comprobacion solapamiento
		assertEquals(agenda.asignarCita(9, nuevaCitaSolapacion), false);
		
		//Comprobacion limites hora
		assertEquals(agenda.asignarCita(18, nuevaCita), false);
		assertEquals(agenda.asignarCita(8, nuevaCita), false);
		
	}
	
	@Test
	void testGetCita() {
		
		DiaBreak agenda = null;
		
		try {
			
			agenda = new DiaBreak(300);
			
		} catch (DatoException e) {
			fail("Wrong parameters");
			e.printStackTrace();
		}
		
		Cita nuevaCita = new Cita("cita 1", 1);

		agenda.asignarCita(9, nuevaCita);
		agenda.asignarCita(13, nuevaCita);
		
		assertNull(agenda.getCita(15));
		assertEquals(agenda.getCita(9), nuevaCita);
		
	}
	
	

	@Test
	void testMuestraCita() {
		
		DiaBreak agenda = null;
		
		try {
			
			agenda = new DiaBreak(300);
			
		} catch (DatoException e) {
			fail("Wrong parameters");
			e.printStackTrace();
		}
		
		Cita nuevaCita = new Cita("cita 1", 1);

		agenda.asignarCita(9, nuevaCita);
		
		assertEquals(agenda.muestraCita(9), "9:00 cita 1");
		assertEquals(agenda.muestraCita(20), "Hora no valida");
		assertEquals(agenda.muestraCita(12), "No existe");
		
	}
	
	
	@Test
	void testValidaHora() {
		
		DiaBreak agenda = null;
		
		try {
			
			agenda = new DiaBreak(300);
			
		} catch (DatoException e) {
			fail("Wrong parameters");
			e.printStackTrace();
		}
	
		assertEquals(agenda.validaHora(9), true);
		assertEquals(agenda.validaHora(10), true);
		assertEquals(agenda.validaHora(11), true);
		assertEquals(agenda.validaHora(12), true);
		assertEquals(agenda.validaHora(13), true);
		assertEquals(agenda.validaHora(14), true);
		assertEquals(agenda.validaHora(15), true);
		assertEquals(agenda.validaHora(16), true);
		assertEquals(agenda.validaHora(17), true);
		assertEquals(agenda.validaHora(18), false);
		assertEquals(agenda.validaHora(19), false);
		assertEquals(agenda.validaHora(20), false);
		assertEquals(agenda.validaHora(21), false);
		assertEquals(agenda.validaHora(22), false);
		assertEquals(agenda.validaHora(23), false);
		assertEquals(agenda.validaHora(0), false);
		assertEquals(agenda.validaHora(1), false);
		assertEquals(agenda.validaHora(2), false);
		assertEquals(agenda.validaHora(3), false);
		assertEquals(agenda.validaHora(4), false);
		assertEquals(agenda.validaHora(5), false);
		assertEquals(agenda.validaHora(6), false);
		assertEquals(agenda.validaHora(7), false);
		assertEquals(agenda.validaHora(8), false);
	}
	
	


}
