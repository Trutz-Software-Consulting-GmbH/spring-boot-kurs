package online.trutz.spring.quickstart.framework.ui;

import java.util.List;

import com.vaadin.flow.router.Route;

@Route("/")
public class DemoMainView extends QuickstartMainView {

	private static final long serialVersionUID = -5085282239915297833L;

	public DemoMainView(List<QuickstartTabPage> tabPages) {
		super(tabPages);
	}

}
