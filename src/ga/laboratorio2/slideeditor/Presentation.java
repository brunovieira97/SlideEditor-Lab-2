package ga.laboratorio2.slideeditor;

/**
 *
 * @author Bruno Vieira
 * @author Orlando Rodrigues
 */

public class Presentation{
    private DoublyLinkedList<Style> estilo;
    private DoublyLinkedList<Slide> pagina;
    private Footer rodape;

    public Presentation() {
        estilo = new DoublyLinkedList<Style>();
        pagina = new DoublyLinkedList<Slide>();
    }

    public void addStyle(Style est) {
        estilo.insertLast(est);
    }

    public Style getStyle(int index){
        if(index>estilo.numElements()){
            return null;
        } 
        return estilo.get(index);
    }
    
    public void addSlide(Slide pag) {
        pagina.insertLast(pag);
    }
    
    public void addSlideEsp(Slide pag, int index){
        pagina.insert(pag, index);
    }

    public Slide getSlide(int index){
        if(index>pagina.numElements()){
            return null;
        } 
        return pagina.get(index);
    }
    
    public DoublyLinkedList<Slide> getPagina(){
        return pagina;
    }
    
    public int getSize(){
        return pagina.numElements();
    }
    
    public Footer getRodape() {
        return rodape;
    }

    public void setRodape(Footer rodape) {
        this.rodape = rodape;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Presentation cloned = new Presentation();
        return cloned;
    }
    
    @Override
    public String toString() {
        return "Presentation{" + "estilo=" + estilo + ", pagina=" + pagina + ", rodape=" + rodape + '}';
    }
        
}
