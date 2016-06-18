package ga.laboratorio2.slideviewer;

/**
 *
 * @author Brolee
 */

public class PresentationEditor {
    public static void addSlide(Slide slide, int order, Presentation pres ){
        if(order < 0 || order > pres.getSize()+1){
            System.out.println("Indice inválido");
        }else{
            pres.addSlideEsp(slide, order);
        }
    }
    
    public static void duplica(int page, Presentation pres){
        if(page < 0 || page > pres.getSize()+1){
           System.out.println("Indice inválido");
        }else{
            Slide s = pres.getSlide(page);
            int i = pres.getPagina().search(s);
            pres.addSlideEsp(s,i);
        }
    }
    
    public static void remove(int page, Presentation pres){
        if(page < 0 || page > pres.getSize()+1){
           System.out.println("Indice inválido");
        }else{
            pres.getPagina().remove(page);
        }
    }
    
    public static void move(int from, int to, Presentation pres){
        if((from < 0 || from > pres.getSize()+1) || (to < 0 || to > pres.getSize()+1)){
            System.out.println("Indice inválido");
        }else{
            Slide s = pres.getPagina().remove(from);
            pres.addSlideEsp(s, to);
        }
    }
    
    public static void changeTitle(Title title, int page, Presentation pres){
        if(page < 0 || page > pres.getSize()+1){
           System.out.println("Indice inválido");
        }else{
            pres.getSlide(page).setTitle(title);
        }
    }
    
    public static void addElement(Element item, int parentItem, Presentation pres){
    
    }
    
}
