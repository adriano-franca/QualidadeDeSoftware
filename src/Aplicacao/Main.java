package Aplicacao;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String nome;
        int i, opcao = 0, qtdeAlunos;
        double nota1, nota2, nota3, nota4;
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
                    a = new Aluno(nome, nota1, nota2, nota3);
                    alunos.add(a);

                }
            }while (qtdeAlunos <= 0 || qtdeAlunos > 5) ;
        }while (opcao != 0);
    }
}
