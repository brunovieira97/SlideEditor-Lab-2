package ga.laboratorio2.slideviewer;

/**
 *
 * @author Bruno Vieira
 * @author Orlando Rodrigues
 */
public class ColorCodes {

    public static final String ANSI_RESET = "\u001B[0;0m";
    private static final String comando = "\u001B[";

    public static String corFonte(String cor) {
        String corFonte = comando;
        if (cor.equals("BLACK")) {
            corFonte += "30;";
        } else if (cor.equals("RED")) {
            corFonte += "31;";
        } else if (cor.equals("GREEN")) {
            corFonte += "32;";
        } else if (cor.equals("YELLOW")) {
            corFonte += "33;";
        } else if (cor.equals("BLUE")) {
            corFonte += "34;";
        } else if (cor.equals("MAGENTA")) {
            corFonte += "35;";
        } else if (cor.equals("CYAN")) {
            corFonte += "36;";
        } else {
            corFonte += "37;";
        }
        return corFonte;
    }

    public static String corFundo(String cor) {
        String corFundo = comando;
        if (cor.equals("BLACK")) {
            corFundo = "40m";
        } else if (cor.equals("RED")) {
            corFundo = "41m";
        } else if (cor.equals("GREEN")) {
            corFundo = "42m";
        } else if (cor.equals("YELLOW")) {
            corFundo = "43m";
        } else if (cor.equals("BLUE")) {
            corFundo = "44m";
        } else if (cor.equals("MAGENTA")) {
            corFundo = "45m";
        } else if (cor.equals("CYAN")) {
            corFundo = "46m";
        } else {
            corFundo = "47m";
        }
        return corFundo;
    }

    public static String decodeFonte(String cor) {
        if (cor.equals("[30")) {
            return "BLACK";
        } else if (cor.equals("[31")) {
            return "RED";
        } else if (cor.equals("[32")) {
            return "GREEN";
        } else if (cor.equals("[33")) {
            return "YELLOW";
        } else if (cor.equals("[34")) {
            return "BLUE";
        } else if (cor.equals("[35")) {
            return "MAGENTA";
        } else if (cor.equals("[36")) {
            return "CYAN";
        } else {
            return "WHITE";
        }
    }

    public static String decodeFundo(String cor) {
        cor = cor.substring(7, 10);
        if (cor.equals("30;")) {
            return "BLACK";
        } else if (cor.equals("31;")) {
            return "RED";
        } else if (cor.equals("32;")) {
            return "GREEN";
        } else if (cor.equals("33;")) {
            return "YELLOW";
        } else if (cor.equals("34;")) {
            return "BLUE";
        } else if (cor.equals("35;")) {
            return "MAGENTA";
        } else if (cor.equals("36;")) {
            return "CYAN";
        } else {
            return "WHITE";
        }
    }

}
