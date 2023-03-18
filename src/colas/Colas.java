package colas;

/**
 * @author LUID
 */
public class Colas {

    public static void main(String[] args) {

        /**
         * Ejercicio 2
         */
        Cola<Alumnos> alumnos = new Cola<>();
        alumnos.encolar(new Alumnos("Luis", "Hombre"));
        alumnos.encolar(new Alumnos("Pepe", "Hombre"));
        alumnos.encolar(new Alumnos("Maria", "Mujer"));
        alumnos.encolar(new Alumnos("Israel", "Hombre"));
        alumnos.encolar(new Alumnos("Brithany", "Mujer"));
        alumnos.encolar(new Alumnos("Piter", "Hombre"));
        alumnos.encolar(new Alumnos("Juana", "Mujer"));
        
        colaHombreMujer(alumnos);

    }
    
    public static void colaHombreMujer(Cola<Alumnos> alumnos){
        Integer ver = alumnos.numDatos();
        Cola<Alumnos> hombres = new Cola<>();
        Cola<Alumnos> mujeres = new Cola<>();
        Alumnos aux;
        while (alumnos.numDatos() != 0) {            
            aux = alumnos.descolar();
            if (aux.getSexo().equalsIgnoreCase("Hombre")) {
                hombres.encolar(aux);
            } else if (aux.getSexo().equalsIgnoreCase("Mujer")) {
                mujeres.encolar(aux);
            }
        }
        if (ver != 0) {
            System.out.println("Cola hombres: ");
            System.out.println(hombres.toString());
            System.out.println("Cola mujeres: ");  
            System.out.println(mujeres.toString());
        } else {
            System.out.println("La cola está vacía");
        }
    }

    public static Boolean esPalindroma(String cadena) {
        Cola<Character> cola = new Cola<>();
        Boolean ver = true;
        for (int i = 0; i < cadena.length(); i++) {
            cola.encolar(cadena.charAt(i));
        }
        for (int i = cola.numDatos() - 1; i >= 0; i--) {
            if (cola.descolar() == cadena.charAt(i)) {
                ver = true;
            } else {
                ver = false;
                break;
            }
        }
        return ver;
    }
}
