package ga.laboratorio2.slideeditor;

/**
 *
 * @author Bruno Vieira
 * @author Orlando Rodrigues
 */

public class Title extends Element{
    private boolean capital;

    public Title() {
    }

    public Title(String text, boolean capital) {
        super(text);
        setText(transforma(text, capital));
        this.capital = capital;
    }

    public boolean isCapital() {
        return capital;
    }

    public void setCapital(boolean capital) {
        this.capital = capital;
    }
    
    public int getCapital(){
        if(!capital){
            return 1;
        }
        return 0;
    }

    public String transforma(String text, boolean cap){
        if(cap){
            return text.toUpperCase();
        }
        return text;
    }

    @Override
    public String toString() {
        return print();
    }

    public String createTitleUpperBorder(){
        String upperBorder = "+";
        while(upperBorder.length() != 120){
            upperBorder+="-";
            if(upperBorder.length()==119){
               upperBorder+="+";
            }
        }
        return upperBorder;
    }
    
    
    @Override
    public String print(){
        String fim = getText();
        for (int i = fim.length(); i < 118; i++) {
            fim += " ";
        }
        return fim;
 
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException{
        Title cloned = (Title)super.clone();
        return cloned;
    }   
   
}
