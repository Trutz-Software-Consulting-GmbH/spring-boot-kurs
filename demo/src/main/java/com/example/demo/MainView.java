package com.example.demo;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends VerticalLayout {

	private static final long serialVersionUID = 1L;

    public MainView() {
    	TextField filterText = new TextField();
    	filterText.setPlaceholder("Filter by name...");
        add(filterText); 
    }

}
