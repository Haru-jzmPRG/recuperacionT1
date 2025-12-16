package textos;

public class Utils {
    /** Separa las palabras del texto en un array de Strings, de forma que cada String contenga una palabra del texto
     * Se debe considerar que el texto puede contener espacios en blanco
     * @param texto Texto a separar
     * @return Array de Strings con las palabras
     */
    public static String[] separarPalabras(String texto) {

    int contador = 0;
    boolean dentroPalabra = false;

    for (int i = 0; i < texto.length(); i++) {
        char c = texto.charAt(i);

        if (c != ' ' && c != ',' && c != '.') {
            if (!dentroPalabra) {
                contador++;
                dentroPalabra = true;
            }
        } else {
            dentroPalabra = false;
        }
    }

    String[] palabras = new String[contador];

    int indice = 0;
    String palabra = "";

    for (int i = 0; i < texto.length(); i++) {
        char c = texto.charAt(i);

        if (c != ' ' && c != ',' && c != '.') {
            palabra += c;
        } else {
            if (!palabra.equals("")) {
                palabras[indice] = palabra;
                indice++;
                palabra = "";
            }
        }
    }

    if (!palabra.equals("")) {
        palabras[indice] = palabra;
    }

    return palabras;
}
    /** Cuenta las palabras del texto
     * @param texto Texto a contar
     * @return Número de palabras
     */
    public static int cuentaPalabras(String texto){
        String[] palabras = separarPalabras(texto);
        return palabras.length;
    }



}
