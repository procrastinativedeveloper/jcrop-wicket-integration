package jcrop;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.request.resource.PackageResourceReference;
import org.jcrop.Coordinates;
import org.jcrop.CroppableSettings;
import org.jcrop.JcropImage;

public class BasicExamples extends WebPage {
	private static final long serialVersionUID = 1L;

    public BasicExamples(final PageParameters parameters) {
	super(parameters);
        add(new JcropImage("example1", new PackageResourceReference(BasicExamples.class, "example.jpg"), new CroppableSettings()));

        CroppableSettings settings2 = new CroppableSettings()
                .setBgColor("yellow")
                .setBgOpacity(0.2);
        add(new JcropImage("example2", new PackageResourceReference(BasicExamples.class, "example.jpg"), settings2));

        CroppableSettings settings3 = new CroppableSettings()
                .setBgColor("green")
                .setSelect(new Coordinates(10, 10, 100, 100));
        add(new JcropImage("example3", new PackageResourceReference(BasicExamples.class, "example.jpg"), settings3));

        add(new Link<Void>("return_to_menu") {

            @Override
            public void onClick() {
                setResponsePage(HomePage.class);
            }
        });
    }
}
