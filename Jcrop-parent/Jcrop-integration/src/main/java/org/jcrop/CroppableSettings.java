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

    /*jsFunction*/
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

    public boolean isShowingPreview() {
        return preview != null;
    }

    public double getAspectRatio() {
        return aspectRatio;
    }

    public void setAspectRatio(double aspectRatio) {
        this.aspectRatio = aspectRatio;
    }

    public List<JsFunction> getOnSelectCallbacks() {
        return onSelectCallbacks;
    }

    public void setOnSelectCallbacks(List<JsFunction> onSelectCallbacks) {
        this.onSelectCallbacks = onSelectCallbacks;
    }

    public List<JsFunction> getOnChangeCallbacks() {
        return onChangeCallbacks;
    }

    public void setOnChangeCallbacks(List<JsFunction> onChangeCallbacks) {
        this.onChangeCallbacks = onChangeCallbacks;
    }

    public List<JsFunction> getOnReleaseCallbacks() {
        return onReleaseCallbacks;
    }

    public void setOnReleaseCallbacks(List<JsFunction> onReleaseCallbacks) {
        this.onReleaseCallbacks = onReleaseCallbacks;
    }

    public List<JsFunction> getHelperFunctions() {
        return helperFunctions;
    }

    public void setHelperFunctions(List<JsFunction> helperFunctions) {
        this.helperFunctions = helperFunctions;
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

    public Coordinates getSelect() {
        return setSelect;
    }

    public void setSelect(Coordinates setSelect) {
        this.setSelect = setSelect;
    }

    public String getBgColor() {
        return bgColor;
    }

    /**
     *
     *
     * @param bgColor  Text values must be quoted (e.g. 'red', '#ccc', 'rgb(10,10,10)')
     */
    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

    public Double getBgOpacity() {
        return bgOpacity;
    }

    public void setBgOpacity(Double bgOpacity) {
        this.bgOpacity = bgOpacity;
    }

    public PreviewSettings getPreview() {
        return preview;
    }

    public void setPreview(PreviewSettings preview) {
        this.preview = preview;
    }

    public Integer getBoxWidth() {
        return boxWidth;
    }

    public void setBoxWidth(Integer boxWidth) {
        this.boxWidth = boxWidth;
    }

    public Integer getBoxHeight() {
        return boxHeight;
    }

    public void setBoxHeight(Integer boxHeight) {
        this.boxHeight = boxHeight;
    }

    public Coordinates getSetSelect() {
        return setSelect;
    }

    public void setSetSelect(Coordinates setSelect) {
        this.setSelect = setSelect;
    }

    public boolean isProvideApiController() {
        return provideApiController;
    }

    public void setProvideApiController(boolean provideApiController) {
        this.provideApiController = provideApiController;
    }
}