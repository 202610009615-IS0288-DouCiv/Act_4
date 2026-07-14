public class Pila {

 private Nodo cima;

 public Pila() {
  cima = null;
 }

 public void push(String simbolo, int linea, int columna) {
  Nodo nuevo = new Nodo(simbolo, linea, columna);
  nuevo.setSiguiente(cima); // Aca se apunto el dato nuevo asi el que estaba antes
  cima = nuevo; // ahora cima es nuevo

 }

 public Nodo pop() {
  if (isEmpty()) {
   throw new Excepcion(

     "No se puede desapilar porque la pila esta vacia");

  }

  Nodo temp = cima;
  cima = cima.getSiguiente();

  temp.setSiguiente(null);
  return temp;

 }

 public Nodo peek() {
  if (isEmpty()) {
   throw new Excepcion(
     "No se puede consultar la cima porque la pila está vacía.");

  }
  return cima;
 }

 public boolean isEmpty() {
  return cima == null;
 }

}
