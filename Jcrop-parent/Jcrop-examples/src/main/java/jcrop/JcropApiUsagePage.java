package jcrop;


import org.apache.wicket.Page;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.request.resource.PackageResourceReference;
import org.jcrop.Coordinates;
import org.jcrop.CroppableSettings;
import org.jcrop.JcropImage;

public class JcropApiUsagePage extends Page {

    protected JcropApiUsagePage() {
        super();
        initUI();
    }

    private void initUI() {
        CroppableSettings settings = new CroppableSettings();
        settings.setBgColor("pink");
        settings.setProvideApiController(true);
        final JcropImage jcropImage = new JcropImage("example1", new PackageResourceReference(HomePage.class, "example.jpg"), settings);

        AjaxLink<Void> setSelectionLink = new AjaxLink<Void>("setSelection") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                jcropImage.getApiController().setSelection(new Coordinates(0, 0, 50, 50), target);
            }
        };
        add(jcropImage);
        add(setSelectionLink);
    }
}
