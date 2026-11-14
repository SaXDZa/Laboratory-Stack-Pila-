public class ListStack implements StackInterface {

    StackNode top; //nodo de la cima
    int size = 0; // cantidad de elementos

    @Override
    public void clear() { //Vaciar totalmente la pila
        top = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public Object peek() { //Me devuelve el elemento de la cima sin sacarlo, y si esta vacio entonces null
        return isEmpty() ? null : top.object;
    }

    @Override
    public Object pop() { //Saca pero devuelve el elemento de la cima
        if (isEmpty()) {
            return null;
        }
        StackNode viejo = top;
        top = top.below; //la nueva cima es el nodo de abajo
        viejo.below = null;// se desconecta el nodo que fue sacado
        size--;
        return viejo.object;
    }


    @Override
    public boolean push(Object object) { //Pone un elemento en la cima, pero si es null devuelve false
        if (object == null) {
            return false;
        }
        StackNode nuevo = new StackNode();
        nuevo.object = object;
        nuevo.below = top;
        top = nuevo;
        size++;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean search(Object object) {
        StackNode actual = top;
        while (actual != null) {
            if (actual.object.equals(object)) {
                return true;
            }
            actual = actual.below;
        }
        return false;
    }
}