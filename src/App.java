import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class App {
    public static void main(String[] args) throws Exception {
        String [] candidatosSelecionados = selecaoCandidatos();
        imprimirSelecionados(candidatosSelecionados);
        for (String candidato: candidatosSelecionados){
            contatarCandidatos(candidato);
        }
    }
    
    static void contatarCandidatos(String candidatoSelecionado){
        
    }

    static boolean atender(){
        return new Random().nextInt(3) == 1;
    }

    static void imprimirSelecionados(String[] candidatosSelecionados) {
        System.out.println("Imprimindo os selecionados com o índice (usando for).");
    
        for(int i = 0; i < candidatosSelecionados.length; i++) {
        System.out.println("Nome: " + candidatosSelecionados[i] + ", índice " + i);
        }

        System.out.println("Imprimindo somente os nomes (usando for each).");

        for(String candidato: candidatosSelecionados){
            System.out.println("Candidato " + candidato);
        }
    }

    static String[] selecaoCandidatos() {        
        String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "JOAO", "ANTONIO", "GUSTAVO", "GIOVANI", "BIANCA"};
        String [] candidatosSelecionados = new String[5];
        
        int qtdCandidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;

        while (qtdCandidatosSelecionados < 5 && candidatoAtual < candidatos.length){
            double salarioPretendido = valorPretendido();

            if (salarioPretendido < salarioBase)
            {
                candidatosSelecionados[qtdCandidatosSelecionados] = candidatos[candidatoAtual];
                qtdCandidatosSelecionados++;
            }
            candidatoAtual++;
        }

        return candidatosSelecionados;
    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void analisarCandidato (double salarioPretendido){
        var salarioBase = 2000.0;

        if (salarioBase > salarioPretendido) 
            System.out.printf("LIGAR PARA O CANDIDATO");
        else if (salarioBase == salarioPretendido) 
            System.out.printf("LIGAR PARA O CANDIDATO COM UMA CONTRAPROPOSTA");
        else 
            System.out.printf("AGUARDANDO RESULTADO DEMAIS CANDIDATOS");
    }
}
