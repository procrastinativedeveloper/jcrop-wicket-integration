package  jcrop;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

    public HomePage(final PageParameters parameters) {
	super(parameters);

        add(new Link<Void>("basic_configuation_example") {
            @Override
            public void onClick() {
                setResponsePage(BasicExamples.class);
            }
        });

        add(new Link<Void>("advanced_configuation_example") {
            @Override
            public void onClick() {
                setResponsePage(AdvancedFeatures.class);
            }
        });

        add(new Link<Void>("show_api_usage") {
            @Override
            public void onClick() {
                setResponsePage(JcropApiUsagePage.class);
            }
        });
    }
}
