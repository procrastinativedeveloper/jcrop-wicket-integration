package org.jcrop;

import org.apache.wicket.markup.html.image.NonCachingImage;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.request.resource.IResource;
import org.apache.wicket.request.resource.PackageResourceReference;
import org.apache.wicket.request.resource.ResourceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JCropImage extends NonCachingImage {

    private static final Logger logger = LoggerFactory.getLogger(JCropImage.class);

    public JCropImage(String id, IResource imageResource, CroppableSettings settings) {
        super(id, imageResource);
        setOutputMarkupId(true);
        initJCrop(settings);
    }

    public JCropImage(String id, ResourceReference resourceReference, PageParameters resourceParameters, CroppableSettings settings) {
        super(id, resourceReference, resourceParameters);
        setOutputMarkupId(true);
        initJCrop(settings);
    }

    public JCropImage(String id, ResourceReference resourceReference, CroppableSettings settings) {
        super(id, resourceReference);
        setOutputMarkupId(true);
        initJCrop(settings);
    }

    public JCropImage(String id, CroppableSettings settings) {
        super(id, new PackageResourceReference(JCropImage.class, "4.jpg"));
        setOutputMarkupId(true);
        initJCrop(settings);
    }

    protected void initJCrop(CroppableSettings settings) {
        add(new JCropBehavior(settings) {
            @Override
            protected void onCooridnatsChange(Coordinates coordinates) {
                JCropImage.this.onCooridnatsChange(coordinates);
            }
        });
    }

    protected void onCooridnatsChange(Coordinates coordinates) {
        logger.info(coordinates.toString());
    }
}
