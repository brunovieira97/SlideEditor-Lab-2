package ga.laboratorio2.slideeditor;

/**
 *
 * @author Bruno Vieira
 * @author Orlando Rodrigues
 */
public class Footer extends Element {
    private String left,right,center, fd;

    public Footer() {
    }

    public Footer(String left, String right, String text, String center) {
        super(text);
        this.left = left;
        this.right = right;
        this.center = center;
    }

    public String getFd() {
        return fd;
    }

    public void setFd(String fd) {
        this.fd = fd;
    }
    
    public String getLeft() {
        return left;
    }

    public void setLeft(String left) {
        this.left = left;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }

    public String getCenter() {
        return center;
    }

    public void setCenter(String center) {
        this.center = center;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException{
        Footer cloned = (Footer)super.clone();
        return cloned;
    }   
    
    @Override
    public String toString() {
        return "Footer{" + "left=" + left + ", right=" + right + ", center=" + center + '}';
    }
    
    public void substituiNumSlide(int numSlide){
        if(left.startsWith("Página ")){
            left = left.substring(0, 7);
            left += String.valueOf(numSlide);
        }else if(center.startsWith("Página ")){
            center = center.substring(0, 7);
            center += String.valueOf(numSlide);
        }else{
            right = right.substring(0, 7);
            right += String.valueOf(numSlide);
        }
    }
    
    @Override
    public String print(){
        String r = left + "                         " + center + "                                        " + right;
        String msg = r;
        for (int i = msg.length(); i < 118; i++) {
            if(i == 119){
                msg += "|";
            }else{
                msg += " ";
            }
        } 
        return msg;
    }
    
    
}
