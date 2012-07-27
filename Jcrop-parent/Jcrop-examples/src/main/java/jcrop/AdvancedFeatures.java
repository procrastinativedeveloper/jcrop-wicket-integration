package jcrop;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.request.resource.PackageResourceReference;
import org.jcrop.CroppableSettings;
import org.jcrop.JcropImage;
import org.jcrop.PreviewSettings;

public class AdvancedFeatures extends WebPage {
	private static final long serialVersionUID = 1L;

    public AdvancedFeatures(final PageParameters parameters) {
	super(parameters);

        CroppableSettings settings4 = new CroppableSettings();
        settings4.setAspectRatio(0.5);
        add(new JcropImage("example4", new PackageResourceReference(HomePage.class, "example.jpg"), settings4));

        CroppableSettings settings5 = new CroppableSettings();
        settings5.setAspectRatio(1.0);
        settings5.setPreview(new PreviewSettings("preview", 100, 100));
        add(new JcropImage("example5", new PackageResourceReference(HomePage.class, "example.jpg"), settings5));

        CroppableSettings settings6 = new CroppableSettings();
        settings6.setBgColor("blue");
        settings6.setBgOpacity(0.2);
        settings6.setBoxWidth(350);
        add(new JcropImage("example6", new PackageResourceReference(HomePage.class, "example.jpg"), settings6));


        add(new Link<Void>("return_to_menu") {

            @Override
            public void onClick() {
                setResponsePage(HomePage.class);
            }
        });
    }
}
