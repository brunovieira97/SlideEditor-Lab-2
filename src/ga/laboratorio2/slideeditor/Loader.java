package ga.laboratorio2.slideeditor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author Bruno Vieira
 * @author Orlando Rodrigues
 */

public class Loader {
    public static int numPagina = 0;
    public static void readStyle(BufferedReader bf, Presentation ps) throws IOException{
        String line;
            while((line = bf.readLine()) != null){
                 if("".equals(line)){
                    continue;
                }
                if ("/styles".equals(line)) {
                   return;
                }
                if (line.startsWith("style=")) {
                    String valor = line.substring(6);
                    String[] s = valor.split(";");
                    Style st = new Style();
                    st.setId(Integer.valueOf(s[0]));
                    st.setTextColor(s[1]);
                    st.setBackgroundColor(s[2]);
                    st.setTitleTextColor(s[3]);
                    st.setTitleBackColor(s[4]);
                    ps.addStyle(st);
                }
            }
    }
    
    public static String getDate(String date) throws ParseException{
        String temp;
        temp = date.substring(6);
        return new SimpleDateFormat(temp).format(Calendar.getInstance().getTime());
    }
    
    public static String ehOQ(String s) throws ParseException{
        if(s.startsWith("#date")){
            return getDate(s);
        }else if(s.startsWith("#page")){
            return "Página ";
        }else{
            return s;
        }
    }
    
    public static void readFooter(BufferedReader bf, Presentation ps) throws IOException, ParseException{
            String line;
            Footer ft = new Footer();
            while((line = bf.readLine()) != null){
                if("".equals(line)){
                    continue;
                }
                if ("/footer".equals(line)) {
                    ps.setRodape(ft);
                    return;
                }
                if (line.startsWith("left=")) {  
                    String valor = line.substring(5);
                    ft.setLeft(ehOQ(valor));
                }
                if (line.startsWith("center=")) {  
                    String valor = line.substring(7);
                    ft.setCenter(ehOQ(valor));
                    String r = line.substring(13);
                    ft.setFd(r);
                }
                if (line.startsWith("right=")) {  
                    String valor = line.substring(6);
                    ft.setRight(ehOQ(valor));
                }
            }
    }
    
     public static int contaElementContent(BufferedReader bf) throws IOException{
            int elementos=0;
            String line;
            while(!(line = bf.readLine()).startsWith("/content")){
                if("".equals(line)){
                    continue;
                }
                if (!(line.startsWith("style") || line.equals("content") ||line.equals("slide") || line.equals("/slide") )){
                    elementos++;
                }
            }
            return elementos;
    }
     
    public static Element[] readContent(BufferedReader bf) throws IOException{
        String line;

        bf.mark(1);
        int tamanho = contaElementContent(bf);
        bf.reset();
        Element[] elem = new Element[tamanho];
        int cont = 0;
        int nr = 1;
        int nr2 = 1;
        while((line = bf.readLine()) != null){
                if("".equals(line)){
                    continue;
                }
                if(line.startsWith("/content")){
                    break;
                }
                if(line.startsWith("**")){
                    StringBuilder sb = new StringBuilder();
                    String s = line.substring(1);
                    sb.append("      ");
                    sb.append(s);
                    String resultado = sb.toString();
                    Element e = new Element(resultado);

                    elem[cont++] = e;
                }else if(line.startsWith("*")){
                    Element e = new Element(line);
                    elem[cont++] = e;
                }else if(line.startsWith("##")){
                    StringBuilder sb = new StringBuilder();
                    String s = line.substring(2);
                    sb.append("      ");
                    sb.append(nr-1).append("." + "").append(nr2).append(".");
                    sb.append(s);
                    nr2++;
                    String resultado = sb.toString();
                    Element e = new Element(resultado);
                    elem[cont++] = e;
                }else if(line.startsWith("#")){
                    nr2=1;
                    StringBuilder sb = new StringBuilder();
                    String s = line.substring(1);
                    sb.append(nr).append(".");
                    sb.append(s);
                    nr++;
                    String resultado = sb.toString();
                    Element e = new Element(resultado);
                    elem[cont++] = e;
                }else{
                    Element e = new Element(line.substring(1));
                    elem[cont++] = e;
                }
        }
        return elem;
    }
    
    public static void readSlide(BufferedReader bf, Presentation ps) throws IOException{
        String line;
        boolean b=false;
        Title t;
        Element[] temp;
        Slide sl = new Slide(100);
        Slide sl2;
        int cont = 0;
            while((line = bf.readLine()) != null){
                if("".equals(line)){
                    continue;
                }
                if ("/slides".equals(line)) {
                    return;
                }
                if ("/slide".equals(line)) {
                    sl2=sl;
                    ps.addSlide(sl2);
                    sl= new Slide(100);
                    cont++;
                    continue;
                }
                if("slide".equals(line)){
                    continue;
                }
                if (line.startsWith("style=")) {
                    String valor = line.substring(6);
                    String[] s = valor.split(";");
                    int id = Integer.valueOf(s[0]);
                    if(ps.getStyle(0).getId() == id){
                        sl.setEstilo(ps.getStyle(0));
                    }else{
                        sl.setEstilo(ps.getStyle(1));
                    }
                    continue;
                }
                if(line.startsWith("title=")){
                    String valor = line.substring(6);
                    String[] s = valor.split(";");
                    if(Integer.parseInt(s[1]) == 1){
                        b=true;
                    }
                    t = new Title(s[0],b);
                    sl.setTitle(t);
                    continue;
                }
                if(line.startsWith("content")){
                    temp = readContent(bf);
                    for (int i = 0; i < temp.length; i++) {
                        sl.addElement(temp[i]);
                    }
                }
            }
    }
    
    public int contaSlide(BufferedReader bf) throws IOException{
            int paginas=0;
            String line;
            while(!(line = bf.readLine()).startsWith("/slides")){
                if ("/slide".equals(line)) {
                    paginas++;
                }
            }
            return paginas;
    }
    
    public Presentation load(String filename) throws FileNotFoundException, IOException, ParseException, NullPointerException{
        int indice=0;
        int tamanho;
        BufferedReader bf = null;
        BufferedReader bs;
        Presentation ps;
        String line;
        try{
            FileReader fr = new FileReader(filename);
            bf = new BufferedReader(fr);
            bf.mark(1);

            tamanho = contaSlide(bf);
            bf.reset();
            ps = new Presentation();
            
            while((line = bf.readLine()) != null){
                if("".equals(line)){
                    continue;
                }
                if("/presentation".equals(line)){
                    break;
                }
                if ("presentation".equals(line)) {
                    continue;
                }
                if ("styles".equals(line)) {
                    readStyle(bf, ps);
                    continue;
                }
                if ("footer".equals(line)) {
                    readFooter(bf, ps);
                    continue;
                }
                if ("slides".equals(line)){
                    readSlide(bf, ps);
                }
            }

            return ps; 
        }catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(null, "Arquivo \"" + filename+"\" não existe!", "Erro!", JOptionPane.ERROR_MESSAGE);
        }catch(IOException io){
            JOptionPane.showMessageDialog(null, "Erro na leitura do arquivo " + filename, "Erro!", JOptionPane.ERROR_MESSAGE);
        }catch(NullPointerException e){
            System.out.println("Erro na abertura do arquivo.");
        }finally{
            try{
                bf.close();
            }catch(Exception e){
                System.out.println("Erro! Não foi possível manipular o arquivo.");;
            }
        }
        return null;
    }

}
    
