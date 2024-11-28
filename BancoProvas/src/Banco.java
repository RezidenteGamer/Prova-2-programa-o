import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Banco {
    public JLabel saldo;
    private JTextField depositoCamp;
    private JTextField saqueCamp;
    private JButton depositoBtn;
    private JButton saqueBtn;
    private JTextArea mensagemArea;
    private JButton limpaBtn;
    private JPanel tela;
    private JLabel mensagem;

    double saldoAtual = 500;
    double saque = 0;
    double deposito = 0;

    public Banco() {

        saqueBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    saque = Double.parseDouble(saqueCamp.getText());
                    if(saque > 0 && saque < saldoAtual) {
                        saldoAtual -= saque;

                        saldo.setText(String.valueOf("R$ " + saldoAtual));

                        mensagem.setText("Saque concluido com sucesso!");
                    }else if(saque < 0){
                        mensagem.setText("Saque não pode ser negativo!");
                    }else if(saque > saldoAtual){
                        mensagem.setText("Saque precisa ser menor ou igual ao saldo!");
                    } else {
                        mensagem.setText("Insira um valor valido!");
                    }
                } catch (NumberFormatException ex){

                        mensagem.setText("Coloque um número válido!");

                }
            }
        });
        depositoBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    deposito = Double.parseDouble(depositoCamp.getText());
                    if(deposito <= 1000 && deposito > 0) {

                        saldoAtual += deposito;

                        saldo.setText("R$ " + saldoAtual);

                        mensagem.setText("Deposito concluido com sucesso!");
                    }else if (deposito > 1000){
                        mensagem.setText("Insira um valor menor que R$ 1000,00 para conseguir depositar!");
                    }else if (deposito < 0){
                        mensagem.setText("Insira um valor maior que 0!");
                    } else {
                        mensagem.setText("Insira um número valido!");
                    }
                }catch (NumberFormatException ex){

                        mensagem.setText("Coloque um número válido!");
                    }
                }
        });
        limpaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mensagem.setText("");
            }
        });
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Banco Provas");
        frame.setContentPane(new Banco().tela);
        frame.setSize(500, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
