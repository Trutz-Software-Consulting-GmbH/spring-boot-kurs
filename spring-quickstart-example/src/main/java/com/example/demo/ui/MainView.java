package com.example.demo.ui;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends AppLayout {

	private static final long serialVersionUID = 1L;

	private final boolean touchOptimized = true;

	public MainView(@Autowired List<TabPage> tabPages) {
		addToNavbar(touchOptimized, createDrawerToggle());
		addToDrawer(createTabs(tabPages));
		// show first page
		tabPages.stream().findFirst().ifPresent(page -> setContent(page.getComponent()));
	}

	private DrawerToggle createDrawerToggle() {
		DrawerToggle drawerToggle = new DrawerToggle();
		return drawerToggle;
	}

	private Tabs createTabs(List<TabPage> tabPages) {
		Map<Tab, Component> tabComponents = new LinkedHashMap<>();
		for (TabPage page : tabPages) {
			tabComponents.put(new Tab(page.getName()), page.getComponent());
		}
		Tabs tabs = new Tabs(tabComponents.keySet().stream().toArray(size -> new Tab[size]));
		tabs.setOrientation(Tabs.Orientation.VERTICAL);
		tabs.addSelectedChangeListener(event -> {
			setContent(tabComponents.get(event.getSelectedTab()));
		});
		return tabs;
	}

}
