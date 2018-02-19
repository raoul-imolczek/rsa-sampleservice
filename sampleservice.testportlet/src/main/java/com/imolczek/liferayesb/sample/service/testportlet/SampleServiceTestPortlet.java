package com.imolczek.liferayesb.sample.service.testportlet;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.imolczek.liferayesb.sample.service.api.SampleService;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

@Component (
		immediate = true,
		property = {
				"com.liferay.portlet.display-category=category.sample",
				"com.liferay.portlet.instanceable=true",
				"javax.portlet.display-name=SampleService Test Portlet",
				"javax.portlet.name=SampleServiceTestPortlet",
				"javax.portlet.init-param.view-template=/view.jsp",
				"javax.portlet.security-role-ref=power-user,user"
		},		
		service = Portlet.class
		)
public class SampleServiceTestPortlet extends MVCPortlet {
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
	
		String greetings = sampleService.sayHello("Raoul");
		
		renderRequest.setAttribute("greetings", greetings);

		super.doView(renderRequest, renderResponse);

	}
	
	@Reference
	private SampleService sampleService;
	
}
