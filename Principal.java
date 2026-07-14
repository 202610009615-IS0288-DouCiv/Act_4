public class Principal {
 public static void main(String[] args) {

  Verificador verificador = new Verificador();

  String texto =
      "resultado = {\n"
      + "    valores: [10, 20, 30],\n"
      + "   operacion: (10 + 20)\n"
      + "}}";

  try {

      verificador.verificarExpresion(texto);

  } catch (Excepcion error) {

      System.out.println(
          "Error en la pila: " + error.getMessage()
      );
  }
}
 
}
