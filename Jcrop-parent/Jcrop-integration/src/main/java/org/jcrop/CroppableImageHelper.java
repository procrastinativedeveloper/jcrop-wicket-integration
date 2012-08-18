package org.jcrop;

import org.apache.wicket.util.string.Strings;
import org.jcrop.utils.JsFunction;

public class CroppableImageHelper implements java.io.Serializable {

    private static final String CALLBACK_PLACEHOLDER = "${callbackUrl}";

    private CroppableImageHelper() {
        throw new RuntimeException("This is helper function");
    }

    public static JsFunction getDefaultPreviewFunction(String wicketId, String scaleProportionVariable, String previewDivName, int thumbnailWidht, int thumbnailHeight) {
        String name = "showPreview";

        if (Strings.isEmpty(previewDivName)) {
            throw new IllegalArgumentException("Null or empty string is not allowed here");
        }
        String body =
                "function (wicket_coordinats){\n" +
                        getJsScaleVariableDeclaration(scaleProportionVariable, wicketId) + "\n" +
                        "	var rx = " + thumbnailWidht + " / (wicket_coordinats.w * " + scaleProportionVariable + "); \n" +
                        "	var ry = " + thumbnailHeight + "/ (wicket_coordinats.h * " + scaleProportionVariable + "); \n" +
                        "   rx = (rx == 0) ? 1 : rx;\n" +
                        "   ry = (ry == 0) ? 1 : ry;\n" +

                        " 	$('#" + previewDivName + " #previewImg').css({ \n" +
                        "		width: Math.round(rx * img_width) + 'px', \n" +
                        "		height: Math.round(ry *  img_height) + 'px', \n" +
                        "		marginLeft: '-' + Math.round(rx * wicket_coordinats.x * " + scaleProportionVariable + " ) + 'px', \n" +
                        "		marginTop: '-' + Math.round(ry * wicket_coordinats.y * " + scaleProportionVariable + " ) + 'px' \n" +
                        "	}); " +
                        // "console.log('coords.w' + wicket_coordinats.w); console.log('wicket_coordinats.h' + wicket_coordinats.h); " +
                        // "console.log('widhtIndicator:' + widhtIndicator); " +
                        // "console.log('heightIndicator:' + heightIndicator); " +
                        // "console.log('rx:' + rx); console.log('ry:' + ry); " +
                        // "console.log('img_width:' + img_width); console.log('img_height:' + img_height);" +
                        // "console.log('rx * img_width:' + rx * img_width); console.log('ry *  img_height:' + ry *  img_height);" +
                        // "console.log('Math.round(rx * wicket_coordinats.x):' + Math.round(rx * wicket_coordinats.x)); + console.log('Math.round(ry * wicket_coordinats.y):' + Math.round(ry * wicket_coordinats.y));" +
                        "}; \n ";

        return new JsFunction(name, body);
    }


    public static JsFunction getDefaulOnSelectFunction() {
        String name = "sendNewCoordinatesOnServer";
        String body = "function (c) { " +
                "var data = 'x=\'+c.x+\'&y=\'+c.y+\'&x2=\'+c.x2+\'&y2=\'+c.y2;" +
                " $.ajax({type: 'POST', url: '${callbackUrl}', data: data}); " +
                "}; \n";
        return new JsFunction(name, body);
    }

    public static String getJsScaleVariableDeclaration(String proportionVariableName, String markupId) {
        return "var img_width = $('#" + markupId + "').siblings('.jcrop-holder').width();\n" +
                "var img_height = $('#" + markupId + "').siblings('.jcrop-holder').height();\n" +
                "var real_width = $('#" + markupId + "').width(); \n" +
                "var " + proportionVariableName + " = img_width / real_width;\n";
    }
}