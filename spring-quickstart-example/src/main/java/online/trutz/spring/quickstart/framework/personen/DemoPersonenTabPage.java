package online.trutz.spring.quickstart.framework.personen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import com.vaadin.flow.spring.data.VaadinSpringDataHelpers;

import online.trutz.spring.quickstart.framework.ui.QuickstartTabPage;

@SpringComponent
@Order(1)
@UIScope
public class DemoPersonenTabPage extends VerticalLayout implements QuickstartTabPage {

	private static final long serialVersionUID = 1320451828716510461L;

	@Autowired
	public DemoPersonenTabPage(DemoPersonRepository repository) {
		Grid<DemoPerson> personen = new Grid<>(DemoPerson.class, false);
		personen.addColumn(DemoPerson::getVorname).setHeader("Vorname").setKey("vorname").setSortable(true);
		personen.addColumn(DemoPerson::getNachname).setHeader("Nachname").setKey("nachname").setSortable(true);
		personen.addColumn(DemoPerson::getEmail).setHeader("Email");
		personen.addColumn(DemoPerson::getGeburtsdatum).setHeader("Geburtsdatum");
		personen.setSortableColumns("vorname", "nachname");
		personen.setItems(VaadinSpringDataHelpers.fromPagingRepository(repository));
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
