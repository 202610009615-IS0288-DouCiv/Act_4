public class Verificador {

 public void verificarExpresion(String texto) {

      Pila pila = new Pila();

      int linea = 1;
      int columna = 0;

      for (int i = 0; i < texto.length(); i++) {

          char caracter = texto.charAt(i);

          // Cuando empieza una línea nueva.
          if (caracter == '\n') {
              linea++;
              columna = 0;
              continue;
          }

          columna++;

          // Símbolos de apertura.
          if (esApertura(caracter)) {

              pila.push(
                  String.valueOf(caracter),
                  linea,
                  columna
              );
          }

          // Símbolos de cierre.
          else if (esCierre(caracter)) {

              if (pila.isEmpty()) {

                  System.out.println(
                      "Error: cierre '" + caracter
                      + "' sin apertura en línea "
                      + linea + ", columna " + columna
                  );

                  return;
              }

              Nodo apertura = pila.peek();

              char simboloApertura =
                  apertura.getSimbolo().charAt(0);

              if (!sonPareja(simboloApertura, caracter)) {

                  System.out.println(
                      "Error de jerarquía en línea "
                      + linea + ", columna " + columna
                      + ". Se encontró '" + caracter
                      + "', pero la última apertura fue '"
                      + simboloApertura
                      + "' en línea "
                      + apertura.getLinea()
                      + ", columna "
                      + apertura.getColumna()
                      + ". Se esperaba '"
                      + obtenerCierre(simboloApertura)
                      + "'."
                  );

                  return;
              }

              pila.pop();
          }
      }

      if (!pila.isEmpty()) {

          System.out.println(
              "Error: existen símbolos de apertura sin cierre."
          );

          while (!pila.isEmpty()) {

              Nodo pendiente = pila.pop();

              System.out.println(
                  "El símbolo '"
                  + pendiente.getSimbolo()
                  + "' abierto en línea "
                  + pendiente.getLinea()
                  + ", columna "
                  + pendiente.getColumna()
                  + " no fue cerrado."
              );
          }

      } else {

          System.out.println(
              "Expresión válida y correctamente balanceada."
          );
      }
  }

  private boolean esApertura(char caracter) {
      return caracter == '('
          || caracter == '['
          || caracter == '{';
  }

  private boolean esCierre(char caracter) {
      return caracter == ')'
          || caracter == ']'
          || caracter == '}';
  }

  private boolean sonPareja(char apertura, char cierre) {

      return apertura == '(' && cierre == ')'
          || apertura == '[' && cierre == ']'
          || apertura == '{' && cierre == '}';
  }

  private char obtenerCierre(char apertura) {

      if (apertura == '(') {
          return ')';
      }

      if (apertura == '[') {
          return ']';
      }

      return '}';
  }

 
}
