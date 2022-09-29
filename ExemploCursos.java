import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Cursos {

  private String nome;
  private int inscritos;

  public Cursos(String nome, int inscritos){
    this.nome = nome;
    this.inscritos = inscritos;
  }

  public String getNome(){
    return this.nome;
  }

  public void setNome(String nome){
    this.nome = nome;
  } 

  public int getInscritos(){
    return this.inscritos;
  }

  public void setInscritos(int inscritos){
    this.inscritos = inscritos;
  }
  
}

public class ExemploCursos {
  public static void main(String[] args){
    List<Cursos> cursos = new ArrayList<>();
    cursos.add(new Cursos("Python", 45));
    cursos.add(new Cursos("Java", 123));
    cursos.add(new Cursos("C#", 118));
    cursos.add(new Cursos("JavaScript", 13));
    cursos.add(new Cursos("Ruby", 57));
    cursos.add(new Cursos("Go", 57));

    cursos.sort(Comparator.comparing(Cursos::getInscritos));

    /*
    cursos.forEach(c -> System.out.println(c.getNome()));
    */

    //Collections agora tem os métodos streams para mapear e filtrar objetos e já possui um iterador foreach
    //cursos.stream().filter(c -> c.getInscritos() >= 100).forEach(c -> System.out.println(c.getNome()));;


    cursos.stream().filter(c -> c.getInscritos() >= 100)
    .map(Cursos::getInscritos)
    .forEach(System.out::println);

    int sum = cursos.stream().filter(c -> c.getInscritos() >= 100)
    .mapToInt(Cursos::getInscritos)
    .sum();

    System.out.println(sum);


  }

}
