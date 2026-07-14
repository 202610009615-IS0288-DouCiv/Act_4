public class Nodo {

 private final String simbolo;
 private final int linea;
 private final int columna;
 private Nodo siguiente;

 public Nodo(String simbolo, int linea, int columna) {
  this.simbolo = simbolo;
  this.linea = linea;
  this.columna = columna;

 }

 public String getSimbolo() {
  return this.simbolo;
 }

 public int getLinea() {
  return this.linea;
 }

 public int getColumna() {
  return this.columna;

 }

public Nodo getSiguiente(){
 return this.siguiente;
}

 public void setSiguiente(Nodo siguiente) {

  this.siguiente = siguiente;
 }

}
