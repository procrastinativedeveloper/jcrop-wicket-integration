package jcrop;


import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.resource.PackageResourceReference;
import org.jcrop.Coordinates;
import org.jcrop.CroppableSettings;
import org.jcrop.JcropImage;

public class JcropApiUsagePage extends WebPage {

    public JcropApiUsagePage() {
        super();
        initUI();
    }

    private void initUI() {
        CroppableSettings settings = new CroppableSettings();
        settings.setBgColor("pink");
        settings.setProvideApiController(true);
        final JcropImage jcropImage = new JcropImage("example1", new PackageResourceReference(HomePage.class, "example.jpg"), settings);
        add(jcropImage);

        AjaxLink<Void> setSelectionLink = new AjaxLink<Void>("setSelection") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                jcropImage.getApiController().setSelection(new Coordinates(0, 0, 50, 50), target);
            }
        };
        add(setSelectionLink);


        AjaxLink<Void> animateToLink = new AjaxLink<Void>("animateTo") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                jcropImage.getApiController().animateTo(new Coordinates(90, 90, 100, 100), target);
            }
        };
        add(animateToLink);

        AjaxLink<Void> releaseLink = new AjaxLink<Void>("release") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                jcropImage.getApiController().release(target);
            }
        };
        add(releaseLink);


        AjaxLink<Void> enableLink = new AjaxLink<Void>("enable") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                jcropImage.getApiController().enable(target);
            }
        };

        AjaxLink<Void> disableLink = new AjaxLink<Void>("disable") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                jcropImage.getApiController().disable(target);
            }
        };

         AjaxLink<Void> destroyLink = new AjaxLink<Void>("destroy") {
             @Override
             public void onClick(AjaxRequestTarget target) {
                 jcropImage.getApiController().destroy(target);
             }
         };
        add(destroyLink);
    }
}
