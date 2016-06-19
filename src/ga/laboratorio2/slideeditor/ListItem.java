package ga.laboratorio2.slideeditor;

/**
 *
 * @author Bruno Vieira
 * @author Orlando Rodrigues
 */

public class ListItem extends Element{
    private boolean numbered;
    private int order;
    DoublyLinkedList<ListItem> childListItems;

    public ListItem(boolean numbered, String text) {
        super(text);
        this.numbered = numbered;
        this.childListItems = new DoublyLinkedList<>();
    }
    
    public ListItem(boolean numbered, int order, String text){
        super(text);
        this.numbered = numbered;
        this.order = order;
        this.childListItems = new DoublyLinkedList<>();
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
        return childListItems.numElements();
    }
    
    public void addChild(ListItem item){
        childListItems.insertLast(item);
    }
    
    public String print(){
        String msg = getText() + "\n";
        for(int i = 0; i < this.getChildCount(); i++){
            msg += childListItems.get(i).print();
        }
        return msg;
    }
    
}
