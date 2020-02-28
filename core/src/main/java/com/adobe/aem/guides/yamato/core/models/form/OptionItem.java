package com.adobe.aem.guides.yamato.core.models.form;

public class OptionItem {
    private final boolean selected;
    private final boolean disabled;
    private final String text;
    private final String value;

    public OptionItem(boolean selected, boolean disabled, String text, String value) {
        this.selected = selected;
        this.disabled = disabled;
        this.text = text;
        this.value = value;
    }

    public boolean isSelected() {
        return selected;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public String getText() {
        return text;
    }

    public String getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (disabled ? 1231 : 1237);
        result = prime * result + (selected ? 1231 : 1237);
        result = prime * result + ((text == null) ? 0 : text.hashCode());
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OptionItem other = (OptionItem) obj;
        if (disabled != other.disabled)
            return false;
        if (selected != other.selected)
            return false;
        if (text == null) {
            if (other.text != null)
                return false;
        } else if (!text.equals(other.text))
            return false;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }

}
