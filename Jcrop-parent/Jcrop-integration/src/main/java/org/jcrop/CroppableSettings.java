package org.jcrop;

import org.jcrop.utils.JsFunction;

import java.util.ArrayList;
import java.util.List;

public class CroppableSettings implements java.io.Serializable {

    private PreviewSettings preview;
    private Double aspectRatio = null;
    private Coordinates setSelect = null;
    private String bgColor = "white";
    private Double bgOpacity = 0.5;
    private Integer boxWidth = null;
    private Integer boxHeight = null;

    private boolean provideApiController = Boolean.FALSE;

    /*jsFunctions*/
    private List<JsFunction> helperFunctions = new ArrayList<JsFunction>();
    private List<JsFunction> onSelectCallbacks = new ArrayList<JsFunction>();
    private List<JsFunction> onChangeCallbacks = new ArrayList<JsFunction>();
    private List<JsFunction> onReleaseCallbacks = new ArrayList<JsFunction>();

    public String generateSettings() {
        StringBuilder result = new StringBuilder();

        if (onChangeCallbacks.size() > 0) {
            result.append("onChange: onChange, ");
        }

        if (onSelectCallbacks.size() > 0) {
            result.append("onSelect: onSelect, ");
        }

        if (onReleaseCallbacks.size() > 0) {
            result.append("onRelease: onRelease, ");
        }

        if (null != aspectRatio) {
            result.append("aspectRatio: ").append(aspectRatio).append(", ");
        }
        result.append("bgColor: '").append(bgColor).append("',");

        if (null != setSelect) {
            result.append("setSelect: ").append(setSelect.toJsArray()).append(",");
        }

        if (null != boxWidth) {
            result.append("boxWidth: ").append(boxWidth).append(",");
        }

        if (null != boxHeight) {
            result.append("boxHeight: ").append(boxHeight).append(",");
        }

        /*TODO nie dodawać nic poza - element bez średnika, aby js się dobrze generował */
        result.append("bgOpacity: '").append(Math.round(bgOpacity * 100.0) / 100.0).append("'");
        return result.toString();
    }

    //fluent setters
    public CroppableSettings setPreview(final PreviewSettings preview) {
        this.preview = preview;
        return this;
    }

    public CroppableSettings setAspectRatio(final Double aspectRatio) {
        this.aspectRatio = aspectRatio;
        return this;
    }

    public CroppableSettings setSelect(final Coordinates setSelect) {
        this.setSelect = setSelect;
        return this;
    }

    public CroppableSettings setBgColor(final String bgColor) {
        this.bgColor = bgColor;
        return this;
    }

    public CroppableSettings setBgOpacity(final Double bgOpacity) {
        this.bgOpacity = bgOpacity;
        return this;
    }

    public CroppableSettings setBoxWidth(final Integer boxWidth) {
        this.boxWidth = boxWidth;
        return this;
    }

    public CroppableSettings setBoxHeight(final Integer boxHeight) {
        this.boxHeight = boxHeight;
        return this;
    }

    public CroppableSettings setProvideApiController(final boolean provideApiController) {
        this.provideApiController = provideApiController;
        return this;
    }

    public CroppableSettings setHelperFunctions(final List<JsFunction> helperFunctions) {
        this.helperFunctions = helperFunctions;
        return this;
    }

    public CroppableSettings setOnSelectCallbacks(final List<JsFunction> onSelectCallbacks) {
        this.onSelectCallbacks = onSelectCallbacks;
        return this;
    }

    public CroppableSettings setOnChangeCallbacks(final List<JsFunction> onChangeCallbacks) {
        this.onChangeCallbacks = onChangeCallbacks;
        return this;
    }

    public CroppableSettings setOnReleaseCallbacks(final List<JsFunction> onReleaseCallbacks) {
        this.onReleaseCallbacks = onReleaseCallbacks;
        return this;
    }


    //getters
    public PreviewSettings getPreview() {
        return preview;
    }

    public Double getAspectRatio() {
        return aspectRatio;
    }

    public Coordinates getSelect() {
        return setSelect;
    }

    public String getBgColor() {
        return bgColor;
    }

    public Double getBgOpacity() {
        return bgOpacity;
    }

    public Integer getBoxWidth() {
        return boxWidth;
    }

    public Integer getBoxHeight() {
        return boxHeight;
    }

    public boolean isProvideApiController() {
        return provideApiController;
    }

    public List<JsFunction> getHelperFunctions() {
        return helperFunctions;
    }

    public List<JsFunction> getOnSelectCallbacks() {
        return onSelectCallbacks;
    }

    public List<JsFunction> getOnChangeCallbacks() {
        return onChangeCallbacks;
    }

    public List<JsFunction> getOnReleaseCallbacks() {
        return onReleaseCallbacks;
    }

    public void putOnSelectCallback(JsFunction jsFunctionCallback) {
        if (jsFunctionCallback == null) {
            throw new IllegalArgumentException("jsFunction callback shouldn't be null");
        }
        onSelectCallbacks.add(jsFunctionCallback);
    }

    public void putOnChangeCallback(JsFunction jsFunctionCallback) {
        if (jsFunctionCallback == null) {
            throw new IllegalArgumentException("jsFunction callback shouldn't be null");
        }
        onChangeCallbacks.add(jsFunctionCallback);
    }

    public void putOnReleaseCallback(JsFunction jsFunctionCallback) {
        if (jsFunctionCallback == null) {
            throw new IllegalArgumentException("jsFunction callback shouldn't be null");
        }
        onReleaseCallbacks.add(jsFunctionCallback);
    }

    public void putHelperFunction(JsFunction jsFunction) {
        if (null == jsFunction) {
            throw new IllegalArgumentException("jsFunction callback shouldn't be null");
        }
        helperFunctions.add(jsFunction);
    }

    public boolean isShowingPreview() {
        return  preview != null;
    }
}