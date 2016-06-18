package ga.laboratorio2.slideviewer;

/**
 *
 * @author Bruno Vieira
 * @author Orlando Rodrigues
 */

public class Slide implements Printable {
    private Style estilo;
    private DoublyLinkedList<Element> elemento;
    private Title title;

    public Slide(int tamanho) {
        this.elemento = new DoublyLinkedList<Element>();
    }

    public void addElement(Element e){
        elemento.insertLast(e);
    }
    
    public Element getElement(int index){
        if(index>elemento.numElements()){
            return null;
        } 
        return elemento.get(index);
    }

    public Style getEstilo() {
        return estilo;
    }

    public Title getTitle() {
        return title;
    }

    public void setEstilo(Style estilo) {
        this.estilo = estilo;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public int getSize(){
        return elemento.numElements();
    }
    
    @Override
    public String print() {
        StringBuilder sb = new StringBuilder(" ");
        sb.setLength(118);
        String t = sb.toString();
        String linhab = t.replace("\0", " ");
        
        String teste ="+";
        
        String separador = "+";
        while(teste.length() != 120){
            teste+="-";
            if(teste.length()==119){
               teste+="+";
            }
        }
        while(separador.length() != 120){
            separador+="-";
            if(separador.length()==119){
               separador+="+";
            }
        }
        
        int rows = elemento.numElements();
        String[] linhas = new String[19]; 
        
        for (int i = 0; i < rows; i++) {
            linhas[i] = ColorCodes.corFonte(estilo.getTextColor()) + ColorCodes.corFundo(estilo.getBackgroundColor()) + elemento.get(i).print();
        }
        
        for (int i = rows; i < linhas.length; i++) {
            if(linhas[i]==null){
                linhas[i] = "|" + ColorCodes.corFonte(estilo.getTextColor()) + ColorCodes.corFundo(estilo.getBackgroundColor()) + linhab+"|";
            }
        }
        String r = ColorCodes.corFonte(estilo.getTextColor()) + ColorCodes.corFundo(estilo.getBackgroundColor()) + title.createTitleUpperBorder();
        System.out.println(r);
        String bordaExterna = ColorCodes.corFonte(estilo.getTextColor()) + ColorCodes.corFundo(estilo.getBackgroundColor()) + "|" + ColorCodes.ANSI_RESET;
        System.out.println(bordaExterna + ColorCodes.corFonte(estilo.getTitleTextColor()) + ColorCodes.corFundo(estilo.getTitleBackColor()) + title.print() + bordaExterna);
        System.out.println(ColorCodes.corFonte(estilo.getTextColor()) + ColorCodes.corFundo(estilo.getBackgroundColor()) + separador);
        for (String l : linhas) {
            System.out.println(l);
        }
        
        return ColorCodes.corFonte(estilo.getTextColor()) + ColorCodes.corFundo(estilo.getBackgroundColor());
    }
    
    public void buildFooter(String footer){
        String separador = "+";
        while(separador.length() != 120){
            separador+="-";
            if(separador.length()==119){
               separador+="+";
            }
        }
        
        String text = "|" + footer;
        while(text.length() != 120){
            text+=" ";
            if(text.length()==119){
               text+="|";
            }
        }
        String r = ColorCodes.corFonte(estilo.getTextColor()) + ColorCodes.corFundo(estilo.getBackgroundColor()) + title.createTitleUpperBorder();
        
        System.out.println(r);
        
        String bordaExterna = ColorCodes.corFonte(estilo.getTextColor()) + ColorCodes.corFundo(estilo.getBackgroundColor()) + "|" + ColorCodes.ANSI_RESET;
        
        System.out.println(bordaExterna + ColorCodes.corFonte(estilo.getTitleTextColor()) + ColorCodes.corFundo(estilo.getTitleBackColor()) + footer + bordaExterna);
        
        System.out.println(ColorCodes.corFonte(estilo.getTextColor()) + ColorCodes.corFundo(estilo.getBackgroundColor()) + separador + ColorCodes.ANSI_RESET);
    }
    
}
