import dao.CustomerMapDAO;
import dao.ICustomerDAO;
import domain.Customer;

import javax.swing.*;

public class App {

    private static ICustomerDAO database = new CustomerMapDAO();
    public static void main(String[] args){
        String answer = JOptionPane.showInputDialog(null, "Digite um número: 1 - Cadastro | 2 - Consulta | 3 - Alteração | 4 - Remoção | 5 - Fechar Programa", "Opções", JOptionPane.INFORMATION_MESSAGE);
        while(!isValidOption(answer)){
            JOptionPane.showMessageDialog(null, "Você digitou um valor inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
            answer = JOptionPane.showInputDialog(null, "Digite um número: 1 - Cadastro | 2 - Consulta | 3 - Alteração | 4 - Remoção | 5 - Fechar Programa", "Opções", JOptionPane.INFORMATION_MESSAGE);
        }
        while(isValidOption(answer)){
            if("5".equals(answer)){
                close();
            } else if("4".equals(answer)){
                String cpf = JOptionPane.showInputDialog(null, "Digite o CPF do cliente:", "Remover", JOptionPane.INFORMATION_MESSAGE);
                removeCustomer(cpf);
            } else if("3".equals(answer)){
                Integer resultAnswer = JOptionPane.showConfirmDialog(null, "Não é possível alterar o CPF de um cliente, mas caso seja necessário, exclua o cliente da lista e o cadastre novamente! Deseja continuar?", "Aviso", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                if(resultAnswer.equals(JOptionPane.YES_OPTION)){
                    String cpf = JOptionPane.showInputDialog(null, "Digite o CPF do cliente:", "Alterar", JOptionPane.INFORMATION_MESSAGE);
                    updateCustomer(cpf);
                }
            } else if("2".equals(answer)){
                String cpf = JOptionPane.showInputDialog(null, "Digite o CPF do cliente:", "Consultar", JOptionPane.INFORMATION_MESSAGE);
                readCustomer(cpf);
            } else if("1".equals(answer)){
                createCustomer();
            }

            answer = JOptionPane.showInputDialog(null, "Digite um número: 1 - Cadastro | 2 - Consulta | 3 - Alteração | 4 - Remoção | 5 - Fechar Programa", "Opções", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    private static boolean isValidOption(String answer) {
        try{
            Long numberAnswer = Long.parseLong(answer);
            if(numberAnswer <= 5 && numberAnswer >= 1){
                return true;
            } else{
                return false;
            }
        } catch(Exception e){
            return false;
        }
    }
    private static void close(){
        JOptionPane.showMessageDialog(null, "Até logo", "Sair", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
    private static void removeCustomer(String cpf) {
        try{
            Long numberCpf = Long.parseLong(cpf);
            Boolean result = database.delete(numberCpf);
            if(result){
                JOptionPane.showMessageDialog(null, "A remoção do Cliente ocorreu com sucesso!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "O Cliente não se encontra no Banco de Dados", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Você digitou um valor inválido, tente novamente!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    private static void updateCustomer(String cpf) {
        try{
            Long numberCpf = Long.parseLong(cpf);
            Customer object = database.read(numberCpf);
            if(object != null){
                String data = JOptionPane.showInputDialog(null,"Digite os novos dados: nome, telefone, endereço, número endereço, cidade, estado.", "Alteração", JOptionPane.INFORMATION_MESSAGE);
                String[] cutData = data.split(",");
                if(cutData.length != 6){
                    JOptionPane.showMessageDialog(null, "Você não digitou os 6 itens citados anteriormente! Portanto a atualização dos dados do Cliente não ocorreu.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
                for(int i = 0; i < cutData.length; i++){
                    if(cutData[i].isEmpty() || cutData[i] == null){
                        JOptionPane.showMessageDialog(null, "Faltaram dados a serem preenchidos! Por favor, reinicie o programa", "Erro", JOptionPane.ERROR_MESSAGE);
                        System.exit(0);
                    }
                }
                String[] dataWithoutSpaces = new String[cutData.length];
                for(int i = 0; i < dataWithoutSpaces.length; i++){
                    dataWithoutSpaces[i] = cutData[i].toLowerCase().trim();
                }
                checkUpdatedNumbers(dataWithoutSpaces);
                Customer updatedCustomer = new Customer(dataWithoutSpaces[0], cpf, dataWithoutSpaces[1], dataWithoutSpaces[2], dataWithoutSpaces[3], dataWithoutSpaces[4], dataWithoutSpaces[5]);
                database.update(updatedCustomer);
                JOptionPane.showMessageDialog(null, "A alteração dos dados do Cliente ocorrem com sucesso!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            } else{
                JOptionPane.showMessageDialog(null, "O Cliente não se encontra no Banco de Dados", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Você digitou um valor inválido, tente novamente!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    private static void checkUpdatedNumbers(String[] cutData) {
        try {
            Long phoneNumber = Long.parseLong(cutData[1]);
            Integer addressNumber = Integer.parseInt(cutData[3]);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Você digitou letras em locais que deveria ir números! Por favor, reinicie o programa.", "Erro", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    private static void readCustomer(String cpf) {
        try{
            Long numberCpf = Long.parseLong(cpf);
            Customer object = database.read(numberCpf);
            if(object != null){
                JOptionPane.showMessageDialog(null, object.toString(), "Informações", JOptionPane.INFORMATION_MESSAGE);
            } else{
                JOptionPane.showMessageDialog(null, "O Cliente não se encontra no Banco de Dados", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Você digitou um valor inválido, tente novamente!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    private static void createCustomer() {
        String data = JOptionPane.showInputDialog(null, "Digite os dados: nome, cpf, telefone, endereço, número endereço, cidade, estado.", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        String[] cutData = data.split(",");
        if(cutData.length != 7){
            JOptionPane.showMessageDialog(null, "Você não digitou os 7 itens citados anteriormente! Portanto a atualização dos dados do Cliente não ocorreu.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        for(int i = 0; i < cutData.length; i++){
            if(cutData[i].isEmpty() || cutData[i] == null){
                JOptionPane.showMessageDialog(null, "Faltaram dados a serem preenchidos! Por favor, reinicie o programa", "Erro", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        }
        String[] dataWithoutSpaces = new String[cutData.length];
        for(int i = 0; i < dataWithoutSpaces.length; i++){
            dataWithoutSpaces[i] = cutData[i].toLowerCase().trim();
        }

        checkCreatedNumbers(dataWithoutSpaces);
        Customer createdCustomer = new Customer(dataWithoutSpaces[0], dataWithoutSpaces[1], dataWithoutSpaces[2], dataWithoutSpaces[3], dataWithoutSpaces[4], dataWithoutSpaces[5], dataWithoutSpaces[6]);
        Boolean result = database.create(createdCustomer);
        if(result){
            JOptionPane.showMessageDialog(null, "A criação do Cliente ocorreu com sucesso!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        } else{
            JOptionPane.showMessageDialog(null, "O CPF digitado já se encontra no Banco de Dados", "Aviso", JOptionPane.ERROR_MESSAGE);
        }

    }
    private static void checkCreatedNumbers(String[] dataWithoutSpaces) {
        try {
            Long cpf = Long.parseLong(dataWithoutSpaces[1]);
            Long phoneNumber = Long.parseLong(dataWithoutSpaces[2]);
            Integer addressNumber = Integer.parseInt(dataWithoutSpaces[4]);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Você digitou letras em locais que deveriam ir números! Por favor, reinicie o programa.", "Erro", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
}
