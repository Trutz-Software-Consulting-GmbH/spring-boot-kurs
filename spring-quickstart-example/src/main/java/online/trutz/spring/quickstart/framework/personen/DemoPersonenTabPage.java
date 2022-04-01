package online.trutz.spring.quickstart.framework.personen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import online.trutz.spring.quickstart.framework.persistence.MongoBackendDataProvider;
import online.trutz.spring.quickstart.framework.ui.QuickstartTabPage;

@SpringComponent
@Order(1)
@UIScope
public class DemoPersonenTabPage extends VerticalLayout implements QuickstartTabPage {

	private static final long serialVersionUID = 1320451828716510461L;

	@Autowired
	public DemoPersonenTabPage(DemoPersonRepository repository) {
		Grid<DemoPerson> personen = new Grid<>(DemoPerson.class, false);
		personen.addColumn(DemoPerson::getVorname).setHeader("Vorname");
		personen.addColumn(DemoPerson::getNachname).setHeader("Nachname");
		personen.addColumn(DemoPerson::getEmail).setHeader("Email");
		personen.addColumn(DemoPerson::getGeburtsdatum).setHeader("Geburtsdatum");
		personen.setItems(new MongoBackendDataProvider<>(repository));
		add(personen);
	}

	@Override
	public String getName() {
		return "Demo Personen";
	}

	@Override
	public Component getComponent() {
		return this;
	}

}
