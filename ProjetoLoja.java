import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class ProjetoLoja {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        short finalizarCompra = 0, pagarCartao = 0, notaFiscal = 0, qntParcelas, codigoCompra, codigoPagamento;
        int qntProduto;
        Double valorTotal = 0.0, valorParcela = 0.0, valorParcelaJuros = 0.0;

        Map<String, Integer> quantidadeCompras = new HashMap<String, Integer>();

        System.out.println("------------------------------------------");
        System.out.println("Bem vindo ao mercadinho!");
        
        //TASK 1 e TASK 5
        while(finalizarCompra == 0){
            System.out.println("------------------------------------------");
            System.out.println("Itens disponíveis: ");
            System.out.println("[1] Shampoo = R$ 36,90");
            System.out.println("[2] Sabonete = R$ 16,90");
            System.out.println("[3] Feijão = R$ 26,90");
            System.out.println("[4] Monster = R$ 60,00");
            System.out.println("[5] Agua = R$ 6,00");
            System.out.println("------------------------------------------");
            System.out.print("Digite o código do produto que deseja comprar: ");
            codigoCompra = sc.nextShort();

            while(codigoCompra > 5 || codigoCompra < 1){
                System.out.println("------------------------------------------");
                System.out.print("ERROR: Código digitado é inválido!\nDigite novamente: ");
                codigoCompra = sc.nextShort();
                System.out.println("------------------------------------------");
            }

            switch(codigoCompra){
                case 1:
                    System.out.print("Qual a quantidade desejada?: ");
                    qntProduto = sc.nextInt();
                    if (!quantidadeCompras.containsKey("shampoo")){
                        quantidadeCompras.put("shampoo", qntProduto);
                    }else{
                        quantidadeCompras.put("shampoo", quantidadeCompras.get("shampoo") + qntProduto);
                    }

                    valorTotal += quantidadeCompras.get("shampoo") * 36.90;
                    break;
                case 2:
                    System.out.print("Qual a quantidade desejada?: ");
                    qntProduto = sc.nextInt();
                    if (!quantidadeCompras.containsKey("sabonete")){
                        quantidadeCompras.put("sabonete", qntProduto);
                    }else{
                        quantidadeCompras.put("sabonete", quantidadeCompras.get("sabonete") + qntProduto);
                    }

                    valorTotal += quantidadeCompras.get("sabonete") * 16.90;
                    break;
                case 3:
                    System.out.print("Qual a quantidade desejada?: ");
                    qntProduto = sc.nextInt();
                    if (!quantidadeCompras.containsKey("feijao")){
                        quantidadeCompras.put("feijao", qntProduto);
                    }else{
                        quantidadeCompras.put("feijao", quantidadeCompras.get("feijao") + qntProduto);
                    }

                    valorTotal += quantidadeCompras.get("feijao") * 26.90;
                    break;
                case 4:
                    System.out.print("Qual a quantidade desejada?: ");
                    qntProduto = sc.nextInt();
                    if (!quantidadeCompras.containsKey("monster")){
                        quantidadeCompras.put("monster", qntProduto);
                    }else{
                        quantidadeCompras.put("monster", quantidadeCompras.get("monster") + qntProduto);
                    }

                    valorTotal += quantidadeCompras.get("monster") * 60.00;
                    break;
                case 5:
                    System.out.print("Qual a quantidade desejada?: ");
                    qntProduto = sc.nextInt();
                    if (!quantidadeCompras.containsKey("agua")){
                        quantidadeCompras.put("agua", qntProduto);
                    }else{
                        quantidadeCompras.put("agua", quantidadeCompras.get("agua") + qntProduto);
                    }

                    valorTotal += quantidadeCompras.get("agua") * 6.00;
                    break;
            }

            System.out.println("------------------------------------------");
            System.out.print("Compra adicionada!\nDeseja finalizar suas compras [1 - sim | 0 - não]?: ");
            finalizarCompra = sc.nextShort();
            System.out.println("------------------------------------------");
            
            //TASK 2
            if(finalizarCompra == 1){
                System.out.println("Compra finalizada! Sua conta deu: R$" + valorTotal);
                if(valorTotal <= 200){
                    System.out.println("Frete gratuito disponível");
                    System.out.println("------------------------------------------");
                }else{
                    System.out.println("Frete pago, valor excedeu 200 reais");
                    System.out.println("------------------------------------------");
                }
                break;
            }
        }

        //TASK 3
        System.out.println("[1] PIX (10% de desconto)");
        System.out.println("[2] Boleto (5% de desconto)");
        System.out.println("[3] Cartão de crédito");
        System.out.println("------------------------------------------");
        System.out.print("Digite o código da forma de pagamento: ");
        codigoPagamento = sc.nextShort();

        while(codigoPagamento > 3 || codigoPagamento < 1){
            System.out.println("------------------------------------------");
            System.out.print("ERROR: Código digitado é inválido!\nDigite novamente: ");
            codigoPagamento = sc.nextShort();
            System.out.println("------------------------------------------");
        }

        switch(codigoPagamento){
            case 1:
                valorTotal = valorTotal - valorTotal * 0.10;
                System.out.println("Valor total da compra aplicado o desconto: R$" + valorTotal);
                break;
            case 2:
                valorTotal = valorTotal - valorTotal * 0.05;
                System.out.println("Valor total da compra aplicado o desconto: R$" + valorTotal);
                break;
                
            //TASK 4
            case 3:
                System.out.print("Você deseja parcelar a sua compra? [1 - sim | 0 - não]: ");
                pagarCartao = sc.nextShort();

                if (pagarCartao == 1){
                    System.out.print("Em quantas vezes deseja parcelar a compra? (a partir de 3 acrescenta juros de 2,5% ao mês): ");
                    qntParcelas = sc.nextShort();
                    valorParcela = valorTotal/qntParcelas;

                    if (qntParcelas <= 3){
                        System.out.println("------------------------------------------");
                        System.out.println("Valor de cada parcela: R$" + valorParcela);
                        System.out.println("Valor total: R$" + valorParcela * qntParcelas);
                        System.out.println("------------------------------------------");
                    }else{
                        System.out.println("------------------------------------------");
                        valorParcelaJuros = valorParcela + valorParcela * 0.025;
                        System.out.println("Valor de cada parcela com juros de 2,5%: R$" + valorParcelaJuros);
                        System.out.println("Valor total: R$" + valorParcelaJuros * qntParcelas);
                        System.out.println("------------------------------------------");
                    }

                }else{
                    System.out.println("Valor total da compra: R$" + valorTotal);
                }
                break;
        }
    }  
}