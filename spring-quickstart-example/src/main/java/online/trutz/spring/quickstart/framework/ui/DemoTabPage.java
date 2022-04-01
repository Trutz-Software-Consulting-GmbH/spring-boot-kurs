package online.trutz.spring.quickstart.framework.ui;

import org.springframework.core.annotation.Order;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

@SpringComponent
@Order(1)
@UIScope
public class DemoTabPage extends VerticalLayout implements QuickstartTabPage {

	private static final long serialVersionUID = 1320451828716510461L;

	public DemoTabPage() {
		TextField firstName = new TextField("First name");
		TextField lastName = new TextField("Last name");
		EmailField email = new EmailField("Email");
		DatePicker datePicker = new DatePicker("Start date");

		FormLayout formLayout = new FormLayout();
		formLayout.add(firstName, lastName, email, datePicker);
		add(formLayout);
	}

	@Override
	public String getName() {
		return "Demo Tab Page";
	}

	@Override
	public Component getComponent() {
		return this;
	}

}
