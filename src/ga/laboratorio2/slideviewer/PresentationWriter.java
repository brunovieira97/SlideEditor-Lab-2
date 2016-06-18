package ga.laboratorio2.slideviewer;

/**
 *
 * @author Unisinos
 */
import java.io.*;

public class PresentationWriter {
    
    public static void save(String filename, Presentation ps){
        try {
            File f = new File(filename);
            FileWriter fr = new FileWriter(f);
            PrintWriter out = new PrintWriter(fr);
            out.println("presentation");
            writeStyles(ps, out);
            writeFooter(ps, out);
            writeSlides(ps, out);
            out.print("/presentation");
            out.close();
        } catch (IOException e) {
            System.out.println("Erro ao escrever arquivo.");
        }
    }

    public static void writeStyles(Presentation ps, PrintWriter out) {
        out.println("styles");
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        out.print("style=");
        sb.append(ps.getStyle(0).getId()).append(";").append(ColorCodes.decodeFonte(ps.getStyle(0).getTextColor())).
        append(";").append(ps.getStyle(0).getBackgroundColor()).append(";").append(ps.getStyle(0).getTitleTextColor()).
        append(";").append(ps.getStyle(0).getTitleBackColor());
        String resultado = sb.toString();
        out.println(resultado);
        out.print("style=");
        sb1.append(ps.getStyle(1).getId()).append(";").append(ColorCodes.decodeFonte(ps.getStyle(1).getTextColor())).
        append(";").append(ps.getStyle(1).getBackgroundColor()).append(";").append(ps.getStyle(1).getTitleTextColor()).
        append(";").append(ps.getStyle(1).getTitleBackColor());
        String res = sb1.toString();
        out.println(res);
        out.println("/styles");

    }
    
    public static void writeFooter(Presentation ps, PrintWriter out){
        out.println("footer");
        out.print("left=");
        out.println(ps.getRodape().getLeft());
        out.print("center=#date;");
        out.println(ps.getRodape().getCenter());
        out.println("right=#page");
        out.println("/footer");
    }
    
    public static void writeSlides(Presentation ps, PrintWriter out){
                out.println("slides");
                for(int i = 0; i < ps.getSize(); i++){
                    out.println("slide");
                    out.print("title=");
                    out.println(ps.getSlide(i).getTitle().getText()+";"+ps.getSlide(i).getTitle().getCapital());
                    out.print("style=");
                    out.println(ps.getSlide(i).getEstilo().getId());
                    out.println("content");
                    for(int x = 0; x < ps.getSlide(i).getSize();x++){
                        out.println("MEU DEEEEEEUS!");
                    }
                    out.println("/content");
                    out.println("/slide");
                }
                out.println("/slides");
    }
    
    
    
    
}
