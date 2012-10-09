/*
 * Copyright (C) 2012 Dimitrios Menounos
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package memo.web.portal.client;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

import mojo.gwt.ui.client.activity.ClientFactory;
import mojo.gwt.ui.client.content.ContentActivity.ContentPlace;

public class PortalClientFactory implements ClientFactory {

	private EventBus eventBus;
	private ActivityMapper activityMapper;
	private ActivityManager activityManager;
	private PlaceController placeController;
	private PlaceHistoryMapper historyMapper;
	private PlaceHistoryHandler historyHandler;

	/**
	 * Initializes the GWT MVP framework.
	 */
	public void initClientFactory() {
		eventBus = new SimpleEventBus();

		// Activity factory
		// Maps places to activities
		activityMapper = new AppActivityMapper(this);

		// Swaps the current activity in response to PlaceChangeEvents
		activityManager = new ActivityManager(activityMapper, eventBus);
		activityManager.setDisplay(new AcceptsOneWidget() {

			private Widget currentWidget;

			@Override
			public void setWidget(IsWidget newWidget) {
				UIHelper.getContentPanel().clear();

				if (newWidget != null) {
					currentWidget = newWidget.asWidget();
					UIHelper.getContentPanel().add(currentWidget);
				}
			}
		});

		// Maintains the current place
		// Fires PlaceChangeEvents to trigger an activity swap
		placeController = new PlaceController(eventBus);

		// Maps places to / from tokens
		historyMapper = GWT.create(AppPlaceHistoryMapper.class);

		// Updates the history in response to PlaceChangeEvents
		historyHandler = new PlaceHistoryHandler(historyMapper);
		historyHandler.register(placeController, eventBus, new ContentPlace());
		historyHandler.handleCurrentHistory(); // fires initial PlaceChangeEvent
	}

	@Override
	public EventBus getEventBus() {
		return eventBus;
	}

	@Override
	public PlaceController getPlaceController() {
		return placeController;
	}
}
