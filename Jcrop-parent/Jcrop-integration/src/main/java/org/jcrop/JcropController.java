package org.jcrop;


import org.apache.wicket.ajax.AjaxRequestTarget;

import java.io.Serializable;

public class JcropController implements Serializable {

    private String jcropVariableName = null;

    public JcropController(String jcropVariableName) {
        this.jcropVariableName = jcropVariableName;
    }

    public void setSelection(Coordinates coordinates, AjaxRequestTarget target) {
        if ( null == coordinates) {
            throw new IllegalArgumentException("Coordinates shoudn't be null");
        }

        if ( null == target ) {
            throw new IllegalArgumentException("AjaxRequestTarget shoudn't be null");
        }
        target.appendJavaScript(jcropVariableName + ".setSelect("+coordinates.toJsArray() + ");");
    }

    public void animateTo(Coordinates coordinates, AjaxRequestTarget target) {
        if ( null == coordinates) {
            throw new IllegalArgumentException("Coordinates shoudn't be null");
        }

        if ( null == target ) {
            throw new IllegalArgumentException("AjaxRequestTarget shoudn't be null");
        }
        target.appendJavaScript(jcropVariableName + ".animateTo("+coordinates.toJsArray() + ");");
    }

    /**
     * Clear the selection
     * @param target
     */
    public void release (AjaxRequestTarget target) {
        if ( null == target ) {
            throw new IllegalArgumentException("AjaxRequestTarget shoudn't be null");
        }
        target.appendJavaScript(jcropVariableName+ ".relase();");
    }

    public void disable(AjaxRequestTarget target){
        if ( null == target ) {
            throw new IllegalArgumentException("AjaxRequestTarget shoudn't be null");
        }
        target.appendJavaScript(jcropVariableName+".disable();");
    }

    public void enable(AjaxRequestTarget target){
        if ( null == target ) {
            throw new IllegalArgumentException("AjaxRequestTarget shoudn't be null");
        }
        target.appendJavaScript(jcropVariableName+".enable();");
    }

    public void destroy(AjaxRequestTarget target){
        if ( null == target ) {
            throw new IllegalArgumentException("AjaxRequestTarget shoudn't be null");
        }
        target.appendJavaScript(jcropVariableName+".destroy();");
        //TODO: remove variable? jcropVaribaleName?
    }



}
