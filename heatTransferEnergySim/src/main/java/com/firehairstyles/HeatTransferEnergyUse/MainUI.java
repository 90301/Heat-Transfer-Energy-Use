package com.firehairstyles.HeatTransferEnergyUse;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import simulation.Simulation;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("lightTheme")
public class MainUI extends UI {

	HorizontalLayout topLayout = new HorizontalLayout();
	Label output = new Label();
	{
		//set component settings
		
		//set events
		
		//set up layouts
	}
	
    @Override
    protected void init(VaadinRequest vaadinRequest) {
    	
    	Simulation s = new Simulation();
    	s.testCode();
    	s.simMonth();
        output.setCaption("energy cost for 1 month: " + s.totalEnergyCost);
        topLayout.addComponent(output);
        setContent(topLayout);
    }

    @WebServlet(urlPatterns = "/*", name = "MainUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MainUI.class, productionMode = false)
    public static class MainUIServlet extends VaadinServlet {
    }
}
