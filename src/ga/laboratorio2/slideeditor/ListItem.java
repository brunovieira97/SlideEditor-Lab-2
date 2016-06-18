package ga.laboratorio2.slideviewer;

/**
 *
 * @author Bruno Vieira
 * @author Orlando Rodrigues
 */

public class ListItem extends Element{
    private boolean numbered;
    private int order;
    DoublyLinkedList<ListItem> subElements;

    public ListItem(boolean numbered, String text) {
        super(text);
        this.numbered = numbered;
        subElements = new DoublyLinkedList<>();
    }
    
    public ListItem(boolean numbered, int order, String text){
        super(text);
        this.numbered = numbered;
        this.order = order;
        subElements = new DoublyLinkedList<>();
    }

    public boolean isNumbered() {
        return numbered;
    }

    public void setNumbered(boolean numbered) {
        this.numbered = numbered;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getChildCount(){
        return subElements.numElements();
    }
    
    public void addChild(ListItem item){
        subElements.insertLast(item);
    }
    
    public String print(){
        String msg = getText() + "\n";
        for(int i = 0; i < this.getChildCount(); i++){
            msg += subElements.get(i).print();
        }
        return msg;
    }
    
}
