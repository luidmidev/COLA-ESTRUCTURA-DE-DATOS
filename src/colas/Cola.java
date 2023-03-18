package colas;

import java.util.Objects;

/**
 * @author Luid
 * @param <T>
 */
public class Cola<T> {

    private Nodo<T> inicio;
    private Nodo<T> fin;
    private Integer size;
    private Integer max = null;

    /**
     * @CONSTRUCTOR INSTANCIA UNA NUEVA COLA SIN TAMAÑO MÁXIMO DEFININIDO
     */
    public Cola() {
        inicio = null;
        fin = null;
        size = 0;
        max = null;
    }

    /**
     * @param max TAMAÑO MÁXIMO
     * @CONSTRUCTOR INSTANCIA UNA NUEVA COLA CON TAMAÑO MÁXIMO DEFININIDO
     */
    public Cola(Integer max) {
        inicio = null;
        fin = null;
        size = 0;
        this.max = max;
    }

    /**
     * @return LA CANTIDAD DE DATOS DE LA COLA 
     */
    public int numDatos() {
        return size;
    }

    /**
     * AÑADE UN NUEVO ELEMENTO AL INCIO DE LA COLA
     * @param dato ELEMENTO
     */
    public void encolar(T dato) {
        Nodo<T> n = new Nodo<>(dato);
        if (Objects.isNull(max)) {
            if (isEmpty()) {
                inicio = fin = n;
                size++;
            } else {
                n.setNext(inicio);
                inicio = n;
                size++;
            }
        } else {
            if (size <= max) {
                if (isEmpty()) {
                    inicio = fin = n;
                    size++;
                } else {
                    n.setNext(inicio);
                    inicio = n;
                    size++;
                }
            } else {
                System.out.println("La cola ha llegado a su tamaño maximo");
            }
        }
    }

    /**
     * @return TRUE SI LA COLA ESTÁ VACIA
     */
    public Boolean isEmpty() {
        return size == 0;
    }

    /**
     * @return TRUE SI LA COLA ESTÁ LLENA
     */
    public Boolean isFull() {
        if (!Objects.isNull(max)) {
            return Objects.equals(size, max);
        } else {
            System.out.print("Este metodo es exlusivo de las colas con tamaño máximo");
            return null;
        }
    }

    /**
     * ELIMINA TODOS LOS ELEMENTOS DE LA COLA
     */
    public void clear() {
        inicio = null;
        fin = null;
        size = 0;
    }

    /**
     * @return EL ÚLTIMO ELEMENTO DE LA COLA.
     * A SU VES SE ELIMINA ESTE ÚLTIMO ELEMENTO
     */
    public T descolar() {
        if (!isEmpty()) {
            if (inicio == fin && size - 1 == 0) {
                Nodo<T> unico = new Nodo<>(inicio.getDato());
                inicio = fin = null;
                size--;
                return unico.getDato();
            } else {
                Nodo<T> a, b;
                a = inicio;
                b = inicio.getNext();
                int i = 1;
                while (i < size - 1) {
                    a = a.getNext();
                    b = b.getNext();
                    i++;
                }
                a.setNext(null);
                fin = a;
                size--;
                return b.getDato();
            }
        }
        return null;
    }

    /**
     * @return LA COLA EN FORMA DE LISTA
     */
    @Override
    public String toString() {
        Nodo<T> pointer = inicio;
        String texto = "";
        while (pointer != null) {
            texto += "[" + pointer.getDato() + "]--->";
            pointer = pointer.getNext();
        }
        if (texto.equals("")) {
            return "Cola Vacia";
        } else {
            return texto;
        }
    }
}
