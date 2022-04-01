package com.example.demo.ui;

import org.springframework.core.annotation.Order;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

@SpringComponent
@Order(1)
@UIScope
public class DummyTabPage extends VerticalLayout implements TabPage {

	private static final long serialVersionUID = 1320451828716510461L;

	@Override
	public String getName() {
		return "Dummy Tab Page";
	}

	@Override
	public Component getComponent() {
		return this;
	}

}
