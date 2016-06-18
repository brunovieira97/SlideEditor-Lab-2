package ga.laboratorio2.slideviewer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Bruno Vieira
 * @author Orlando Rodrigues
 */

public class SlideEditorApp {
    
    public static void menuApresentacao(String filename){
        try {
            Loader l = new Loader();
            Navigator nav = new Navigator (l.load(filename));
            Presentation ps = l.load(filename);
            int op = 0;
            Scanner s = new Scanner(System.in);
            nav.first();
            do{
                System.out.println("\nDigite a opção desejada: ");
                System.out.println("1 - Voltar para Menu Principal | 2 - Primeiro Slide | 3 - Slide Anterior | 4 - Slide Específico | 5 - Próximo Slide | 6 - Último Slide");
                op = s.nextInt() - 1;
            switch (op) {
                case 1:
                    nav.first();
                    break;
                case 2:
                    nav.previous();
                    PresentationWriter.save("MeuArquivo.txt", ps);
                    break;
                case 3:
                    int slide;
                    System.out.println("Digite o número do slide desejado:\n");
                    slide = s.nextInt() - 1;
                    nav.goTo(slide);
                    break;
                case 4:
                    nav.next();
                    break;
                case 5:
                    nav.last();
                    break;
                case 0:
                    System.out.println("Fim da Apresentação de Slides");
                    break;
                default:
                    System.out.println("Opção Inválida");
                    break;
            }
            }while(op != 0);
            
            StringBuilder sb = new StringBuilder("Teste");
            sb.setLength(100);
            String teste = sb.toString();
            String r = teste.replace("\0", " ");
            

        }catch(FileNotFoundException e){
            System.out.println("Arquivo não encontrado!");
             e.printStackTrace();
        }catch(IOException ex){
            System.out.println("Erro de Leitura!");
             ex.printStackTrace();
        }catch(ParseException ex){
            System.out.println("Erro de Parse!");
                        ex.printStackTrace();
        }catch(NullPointerException ex){
                    ex.printStackTrace();
            System.out.println("Erro de Navegação! Objeto Nulo.");
        }catch(IndexOutOfBoundsException ex){
            System.out.println("Erro de Navegação! Índice Inválido.");
                        ex.printStackTrace();
        }catch(Exception e){
            System.out.println("Erro");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String filename = "";
        while(filename.isEmpty()){
            filename = JOptionPane.showInputDialog(null, "Digite o nome do arquivo da apresentação: ", "Iniciar Apresentação de Slides", JOptionPane.PLAIN_MESSAGE) + ".txt";
        }

            int op = 0;
            Scanner s = new Scanner(System.in);
            do{
                System.out.println("\nDigite a opção desejada: ");
                System.out.println("0 - Sair | 1 - Menu Principal | 2 - Edição");
                op = s.nextInt();
            switch (op) {
                case 1:
                    menuApresentacao(filename);
                    break;
                case 2:
                    System.out.println("HEHE");
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Opção Inválida");
                    break;
            }
        }while(op != 0);
        


    }
}
