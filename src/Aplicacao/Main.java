package Aplicacao;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        String nome;
        int i, opcao = 0, qtdeAlunos;
        double nota1, nota2, nota3, nota4, media;
        boolean situacao;
        Aluno a;
        ArrayList<Aluno> alunos = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("SISTEMA DE NOTAS");
            do {
                qtdeAlunos = 0;
                do{
                    try {
                        System.out.println("Digite a quantidade de alunos");
                        qtdeAlunos = sc.nextInt();
                        if (qtdeAlunos <= 0 || qtdeAlunos > 5) {
                            System.out.println("ERRO - Digite uma quantidade válida");
                        }
                    } catch (Exception e) {
                        System.out.println("ERRO - Digite uma quantidade válida");
                        sc.next();
                    }
                }while(qtdeAlunos <=0 || qtdeAlunos > 5);
                for (i = 0; i < qtdeAlunos; i++) {
                    System.out.println("Digite o nome do aluno");
                    nome = sc.next();
                    do {
                        nota1 = 0;
                        try {
                            System.out.println("Digite a nota 1 do aluno " + nome);
                            nota1 = sc.nextDouble();
                            if (testaIntervaloNota(0, 10, nota1)) {
                                System.out.println("ERRO - Digite uma quantidade válida");
                            }
                        } catch (Exception e) {
                            System.out.println("ERRO - Digite uma quantidade válida");
                            sc.next();
                        }
                    } while(testaIntervaloNota(0, 10, nota1));
                    do {
                        nota2 = 0;
                        try {
                            System.out.println("Digite a nota 2 do aluno " + nome);
                            nota2 = sc.nextDouble();
                            if (testaIntervaloNota(0, 10, nota2)) {
                                System.out.println("ERRO - Digite uma quantidade válida");
                            }
                        } catch (Exception e) {
                            System.out.println("ERRO - Digite uma quantidade válida");
                            sc.next();
                        }
                    } while(testaIntervaloNota(0, 10, nota2));
                    do {
                        nota3 = 0;
                        try {
                            System.out.println("Digite a nota 3 do aluno " + nome);
                            nota3 = sc.nextDouble();
                            if (testaIntervaloNota(0, 10, nota3)) {
                                System.out.println("ERRO - Digite uma quantidade válida");
                            }
                        } catch (Exception e) {
                            System.out.println("ERRO - Digite uma quantidade válida");
                            sc.next();
                        }
                    } while(testaIntervaloNota(0, 10, nota3));
                    media = calculaMedia(nota1, nota2, nota3);
                    if(media >= 7) {
                        situacao = true;
                    }else{
                        situacao = false;
                    }
                    a = new Aluno(nome, nota1, nota2, nota3, media, situacao);
                    alunos.add(a);
                    a.exibirAluno();
                }
                for (i = 0; i < qtdeAlunos; i++) {
                    nota4 = 0;
                    if(!alunos.get(i).isAprovado()){
                        do {
                            try {
                                System.out.println("Digite a nota de reposição do aluno " + alunos.get(i).getNome());
                                nota4 = sc.nextDouble();
                                if (testaIntervaloNota(0, 10, nota4)) {
                                    System.out.println("ERRO - Digite uma quantidade válida");
                                }
                            } catch (Exception e) {
                                System.out.println("ERRO - Digite uma quantidade válida");
                                sc.next();
                            }
                        } while(testaIntervaloNota(0, 10, nota4));
                    }
                    alunos.get(i).setNota4(nota4);
                    nota1 = alunos.get(i).getNota1();
                    nota2 = alunos.get(i).getNota2();
                    nota3 = alunos.get(i).getNota3();
                    media = recalculaMedia(nota1, nota2, nota3, nota4, alunos.get(i).getMedia());
                    if(media >= 7) {
                        situacao = true;
                    }else{
                        situacao = false;
                    }
                    alunos.get(i).setMedia(media);
                    alunos.get(i).setAprovado(situacao);
                    alunos.get(i).exibirAluno();
                }
            }while (qtdeAlunos <= 0 || qtdeAlunos > 5) ;
        }while (opcao != 0);
    }

    public static double calculaMedia(double nota1, double nota2, double nota3){
        double media;
        media = (nota1+nota2+nota3)/3;
        return media;
    }

    public static double recalculaMedia(double nota1, double nota2, double nota3, double nota4, double mediaAtual){
        double mediaNova = mediaAtual;
        if(nota1<nota2 && nota1<nota3 && nota1<nota4){
            mediaNova = (nota4+nota2+nota3)/3;
        }else if(nota2<nota1 && nota2<nota3 && nota2<nota4){
            mediaNova = (nota1+nota4+nota3)/3;
        }else if(nota3<nota1 && nota3<nota2 && nota3<nota4){
            mediaNova = (nota1+nota2+nota4)/3;
        }
        return mediaNova;
    }

    public static boolean testaIntervaloNota(double minimo, double maximo, double valor){
        if(valor < minimo || valor > maximo){
            return true;
        }
        return false;
    }
}
