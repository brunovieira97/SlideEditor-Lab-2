package ga.laboratorio2.slideeditor;

/**
 *
 * @author Bruno Vieira
 * @author Orlando Rodrigues
 */

public class Style {
    private String textColor, backgroundColor, titleTextColor, titleBackColor;
    private int id;

    public Style() {
    }

    public Style(String textColor, String backgroundColor, String titleTextColor, String titleBackColor, int id) {
        this.textColor = textColor;
        this.backgroundColor = backgroundColor;
        this.titleTextColor = titleTextColor;
        this.titleBackColor = titleBackColor;
        this.id=id;
    }

    public String getTextColor() {
        return textColor;
    }

    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getTitleTextColor() {
        return titleTextColor;
    }

    public void setTitleTextColor(String titleTextColor) {
        this.titleTextColor = titleTextColor;
    }

    public String getTitleBackColor() {
        return titleBackColor;
    }

    public void setTitleBackColor(String titleBackColor) {
        this.titleBackColor = titleBackColor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ID: " + id
            + "\nCor do Texto: " + textColor
            + "\nCor do Fundo: " + backgroundColor
            + "\nCor do Texto (Título): " + titleTextColor
            + "\nCor do Fundo (Título): " + titleBackColor;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException{
        Style cloned = (Style)super.clone();
        return cloned;
    }   

}
