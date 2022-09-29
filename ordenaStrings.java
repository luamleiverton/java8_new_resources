import java.util.List;
import java.util.function.Consumer;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;

public class ordenaStrings {

  public static void main(String[] args) {
    List<String> palavras = new ArrayList<String>();
    palavras.add("alura online");
    palavras.add("editora casa do código");
    palavras.add("caelum");

    Comparator<String> comparador = new ComparadorPorTamanho();
    //Collections.sort(palavras, comparador);
    
    /*concepcao do novo método sort na classe List a partir do java 8 - é um default method 
    palavras.sort(comparador);
    System.out.println(palavras);
    */

    //métodos lambda são passíveis de ser utilizados quando a interface implementa apenas um método abstrato
    //sort com método lambda utilizando o método compare da api Integer
    //palavras.sort((s1, s2) -> {return Integer.compare(s1.length(), s2.length());});
    
    /*sort utilizando lambda(interfaces funcionais) e métodos estáticos
    palavras.sort((Comparator.comparing(s -> s.length())));
    */

    //sort com lambda e method references
    palavras.sort((Comparator.comparing(String::length)));

    System.out.println(palavras);

    /*
    for (String p:palavras) {
      System.out.println(p);
    }
    */

    /*outro default method é o forEach que recebe como parâmetro um consumer
    Consumer<String> consumidor = new ImprimeNaLinha();
    palavras.forEach(consumidor);
    */

    /*outra estrutura são os métodos lambda --> forEach com lambda
    palavras.forEach(s -> {System.out.println(s);});
    */

    //foreach com method references
    palavras.forEach(System.out::println);

    

  }
  
}

class ImprimeNaLinha implements Consumer<String> {

  @Override
  public void accept(String s) {
    System.out.println(s);    
  }
  
}

class ComparadorPorTamanho implements Comparator<String> {
  @Override
  public int compare(String s1, String s2) {
    if(s1.length() < s2.length()){
      return -1;
    }
    if(s1.length() > s2.length()) {
      return 1;
    }
    return 0;
  }
}