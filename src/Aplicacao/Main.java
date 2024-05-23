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
        ArrayList<Double> notas = new ArrayList<>();
        Aluno a;
        ArrayList<Aluno> alunos = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("SISTEMA DE NOTAS");
            do {
                qtdeAlunos = 0;
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
                for (i = 0; i < qtdeAlunos; i++) {
                    System.out.println("Digite o nome do aluno");
                    nome = sc.next();
                    do {
                        nota1 = 0;
                        try {
                            System.out.println("Digite a nota 1 do aluno " + nome);
                            nota1 = sc.nextDouble();
                            if (nota1 < 0 || nota1 > 10) {
                                System.out.println("ERRO - Digite uma quantidade válida");
                            }
                        } catch (Exception e) {
                            System.out.println("ERRO - Digite uma quantidade válida");
                            sc.next();
                        }
                    } while(nota1 < 0 || nota1 > 10);
                    do {
                        nota2 = 0;
                        try {
                            System.out.println("Digite a nota 2 do aluno " + nome);
                            nota2 = sc.nextDouble();
                            if (nota2 < 0 || nota2 > 10) {
                                System.out.println("ERRO - Digite uma quantidade válida");
                            }
                        } catch (Exception e) {
                            System.out.println("ERRO - Digite uma quantidade válida");
                            sc.next();
                        }
                    } while(nota2 < 0 || nota2 > 10);
                    do {
                        nota3 = 0;
                        try {
                            System.out.println("Digite a nota 3 do aluno " + nome);
                            nota3 = sc.nextDouble();
                            if (nota3 < 0 || nota3 > 10) {
                                System.out.println("ERRO - Digite uma quantidade válida");
                            }
                        } catch (Exception e) {
                            System.out.println("ERRO - Digite uma quantidade válida");
                            sc.next();
                        }
                    } while(nota3 < 0 || nota3 > 10);
                    media = (nota1+nota2+nota3)/3;
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
                                if (nota4 < 0 || nota4 > 10) {
                                    System.out.println("ERRO - Digite uma quantidade válida");
                                }
                            } catch (Exception e) {
                                System.out.println("ERRO - Digite uma quantidade válida");
                                sc.next();
                            }
                        } while(nota4 < 0 || nota4 > 10);
                    }
                    alunos.get(i).setNota4(nota4);
                    media = alunos.get(i).getMedia();
                    if(alunos.get(i).getNota1()<alunos.get(i).getNota2() && alunos.get(i).getNota1()<alunos.get(i).getNota3() && alunos.get(i).getNota1()<nota4){
                        media = (nota4+alunos.get(i).getNota2()+alunos.get(i).getNota3())/3;
                    }else if(alunos.get(i).getNota2()<alunos.get(i).getNota1() && alunos.get(i).getNota2()<alunos.get(i).getNota3() && alunos.get(i).getNota2()<nota4){
                        media = (alunos.get(i).getNota1()+nota4+alunos.get(i).getNota3())/3;
                    }else if(alunos.get(i).getNota3()<alunos.get(i).getNota1() && alunos.get(i).getNota3()<alunos.get(i).getNota2() && alunos.get(i).getNota3()<nota4){
                        media = (alunos.get(i).getNota1()+alunos.get(i).getNota2()+nota4)/3;
                    }
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
}
