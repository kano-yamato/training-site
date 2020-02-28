package com.adobe.aem.guides.yamato.core.models.form;

public class OptionItemImpl implements OptionItem {
    private final boolean selected;
    private final boolean disabled;
    private final String text;
    private final String value;

    public OptionItemImpl(boolean selected, boolean disabled, String text, String value) {
        this.selected = selected;
        this.disabled = disabled;
        this.text = text;
        this.value = value;
    }

    @Override
    public boolean isSelected() {
        return selected;
    }

    @Override
    public boolean isDisabled() {
        return disabled;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public String getValue() {
        return value;
    }

}
