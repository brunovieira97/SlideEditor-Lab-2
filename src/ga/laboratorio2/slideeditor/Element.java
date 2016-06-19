package ga.laboratorio2.slideeditor;

/**
 *
 * @author Bruno Vieira
 * @author Orlando Rodrigues
 */

public class Element implements Printable, Cloneable{
    private String text;

    public Element() {
    }

    public Element(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return print();
    }
    
    @Override
    public String print() {
        
        String r = "|" + text;
        while(r.length() != 120){
            if(r.length() == 119){
                r += "|";
                continue;
            }
            r += " ";
        }
        return r;
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException{
        Element cloned = (Element)super.clone();
        return cloned;
    }   

}
