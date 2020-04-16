package com.adobe.aem.guides.yamato.core.models.content;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

public class Image {
    private Map<String, String> backgroundStyle = new HashMap<String, String>();
    private String src;
    private String contentsTitle;
    private String contentsText;
    private String url;
    private String buttonLabel;

    public Image(String item) {
        try {
            JSONObject jsonItem = new JSONObject(item);
            src = jsonItem.getString("imagePath");
            backgroundStyle.put("style", String.format("background-image:url(%s);", src));
            contentsTitle = jsonItem.getString("contentsTitle");
            contentsText = jsonItem.getString("contentsText");
            url = jsonItem.getString("url");
            buttonLabel = jsonItem.getString("buttonLabel");
        } catch (JSONException e) {
            throw new RuntimeException(item);
        }
    }

    public Map<String, String> getBackgroundStyle() {
        return backgroundStyle;
    }

    public String getSrc() {
        return src;
    }

    public String getContentsTitle() {
        return contentsTitle;
    }

    public String getContentsText() {
        return contentsText;
    }

    public String getUrl() {
        return url;
    }

    public String getButtonLabel() {
        return buttonLabel;
    }
}