package textos;

public class Utils {
    /** Separa las palabras del texto en un array de Strings, de forma que cada String contenga una palabra del texto
     * Se debe considerar que el texto puede contener espacios en blanco
     * @param texto Texto a separar
     * @return Array de Strings con las palabras
     */
    public static String[] separarPalabras(String texto){
        String[] palabra = new String[texto.length()];
        int palabras = 0;
        int i = 0;
        int j = 0;

        while(i < texto.length()){
            if (texto.charAt(j) != ' '){
                palabra[i] = palabra[i] + texto.charAt(j);
                j++;
            }else{
                palabras++;
                i++;
            }
        }


        
        return palabra;
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
