package ga.laboratorio2.slideeditor;

/**
 *
 * @author Bruno Vieira
 * @author Orlando Rodrigues
 */

public class Navigator{
    private int current;
    private Presentation pres;
    
    public Navigator(Presentation pres) {
        this.pres = pres;
        this.current = 0;
    }

    public Presentation getCurrent() {
        return pres;
    }
    
    public int getPagina(){
        return current;
    }

    private void setCurrent(int current) {
        this.current = current;
    }
    
    public void goTo(int index) throws IndexOutOfBoundsException{
        if(index > pres.getSize()){
            throw new IndexOutOfBoundsException("Índice Inválido!");
        }
        setCurrent(index);
        System.out.print(getCurrent().getSlide(current).print());
        getCurrent().getRodape().substituiNumSlide(index + 1);
        getCurrent().getSlide(current).buildFooter(getCurrent().getRodape().print());
    }
    
    public void first(){
        goTo(0);
    }
    
    public void next(){
        if(current == (pres.getSize() - 1)){
            System.out.println("Último slide já em exibição");
        }else{
            goTo(current + 1);
        }
    }
    
    public void previous(){
        if(current == 0){
            System.out.println("Primeiro slide já em exibição");
        }else{
            goTo(current - 1);
        }
    }
    
    public void last(){
        goTo(pres.getSize() - 1);
    }
}
