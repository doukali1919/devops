package tn.esprit.spring.controllers;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import tn.esprit.spring.entities.Registration;
import tn.esprit.spring.services.IRegistrationServices;

@ExtendWith(MockitoExtension.class)
public class RegistrationRestControllerTest {

	@Mock
	private IRegistrationServices registrationServices;

	@InjectMocks
	private RegistrationRestController registrationRestController;

	private Registration registration;

	@BeforeEach
	public void setUp() {
		registration = new Registration();
		registration.setNumRegistration(1L);
		registration.setNumWeek(12);
	}

	@Test
	public void testAddAndAssignToSkier() {
		Long numSkieur = 1L;

		// Simuler le comportement du service
		when(registrationServices.addRegistrationAndAssignToSkier(registration, numSkieur))
				.thenReturn(registration);

		// Appeler la méthode du contrôleur
		Registration result = registrationRestController.addAndAssignToSkier(registration, numSkieur);

		// Vérifier le résultat
		assertNotNull(result);
		assertEquals(1L, result.getNumRegistration());
		verify(registrationServices, times(1)).addRegistrationAndAssignToSkier(registration, numSkieur);
	}

	@Test
	public void testAssignToCourse() {
		Long numRegistration = 1L;
		Long numCourse = 2L;

		// Simuler le comportement du service
		when(registrationServices.assignRegistrationToCourse(numRegistration, numCourse))
				.thenReturn(registration);

		// Appeler la méthode du contrôleur
		Registration result = registrationRestController.assignToCourse(numRegistration, numCourse);

		// Vérifier le résultat
		assertNotNull(result);
		assertEquals(1L, result.getNumRegistration());
		verify(registrationServices, times(1)).assignRegistrationToCourse(numRegistration, numCourse);
	}
}
