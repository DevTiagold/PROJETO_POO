import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Arquivo arq = new Arquivo();
        ContatoExport cont = new ContatoExport();
        GerenciadorDeContatos gerenciador = new GerenciadorDeContatos();

        boolean executando = true;
        while (executando) {
            System.out.println("====== Sistema de Gerenciamento de Contatos ======");
            System.out.println("1 - Adicionar contato");
            System.out.println("2 - Remover contato");
            System.out.println("3 - Buscar contato por nome");
            System.out.println("4 - Listar todos os contatos");
            System.out.println("5 - Exportar contatos para cópia");
            System.out.println("6 - Sair");
            System.out.print("Escolha uma opção: ");

            try {
                int opcao = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer
                switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    cont.setNome(nome);
                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();
                    cont.setTelefone(telefone);
                    System.out.print("Cidade: ");
                    String cidade = scanner.nextLine();
                    cont.setCidade(cidade);

                    Contato novoContato = new Contato(nome, telefone, cidade);
                    gerenciador.addContato(novoContato);
                    arq.escrever(cont);
                    System.out.println("Contato adicionado com sucesso!");
                    System.out.println();
                    break;

                case 2:
                    System.out.print("Nome do contato a ser removido: ");
                    String nomeRemover = scanner.nextLine();

                    Contato contatoRemover = gerenciador.buscContatoNome(nomeRemover);
                    if (contatoRemover != null) {
                        gerenciador.remContato(contatoRemover);
                        System.out.println("Contato removido com sucesso!");
                    } else {
                        System.out.println("Contato não encontrado!");
                    }
                    System.out.println();
                    break;

                case 3:
                    System.out.print("Nome do contato a ser buscado: ");
                    String nomeBuscar = scanner.nextLine();

                    Contato contatoEncontrado = gerenciador.buscContatoNome(nomeBuscar);
                    if (contatoEncontrado != null) {
                        System.out.println("Contato encontrado:");
                        System.out.println("Nome: " + contatoEncontrado.getNome());
                        System.out.println("Telefone: " + contatoEncontrado.getTelefone());
                        System.out.println("Endereço: " + contatoEncontrado.getCidade());
                    } else {
                        System.out.println("Contato não encontrado!");
                    }
                    System.out.println();
                    break;

                case 4:
                    List<Contato> listaContatos = gerenciador.listarContatos();
                    Collections.sort(listaContatos);
                    if (listaContatos.isEmpty()) {
                        System.out.println("Nenhum contato cadastrado!");
                    } else {
                        System.out.println("Lista de contatos:");
                        for (Contato contato : listaContatos) {
                            System.out.println("Nome: " + contato.getNome());
                            System.out.println("Telefone: " + contato.getTelefone());
                            System.out.println("Endereço: " + contato.getCidade());
                            System.out.println("-------------------------------");
                        }
                    }
                    System.out.println();
                    break;
                case 5:
                    List<ContatoExport> lists = arq.ler();
                    Collections.sort(lists);
                    if(lists.isEmpty()){
                        System.out.println("Nenhum contato a ser exportado!");
                    }
                    else
                    {
                        for(int i = 0 ; i < lists.size(); i++){
                            lists.get(i).getNome();
                            lists.get(i).getTelefone();
                            lists.get(i).getCidade();
                        }
                        System.out.println("Exportado com sucesso!");
                        System.out.println();

                    }
                    break;
                case 6:
                    executando = false;
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    System.out.println();
                    break;
            }
            }catch (InputMismatchException e){
                System.out.println("Opção inválida! Certifique-se de digitar um número entre 1 e 6!");
                scanner.nextLine(); // Limpar o buffer
            }

        }
        scanner.close();
    }
}