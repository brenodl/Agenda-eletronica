package br.com.agendaeletronica;

import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;

import br.com.agendaeletronica.ui.Inicio;
import br.com.agendaeletronica.ui.WicketApplication;

/**
 * Simple test using the WicketTester
 */
public class TestHomePage
{
	private WicketTester tester;

	@Before
	public void setUp()
	{
		tester = new WicketTester(new WicketApplication());
	}

	@Test
	public void homepageRendersSuccessfully()
	{
		//start and render the test page
		tester.startPage(Inicio.class);

		//assert rendered page class
		tester.assertRenderedPage(Inicio.class);
	}
}
