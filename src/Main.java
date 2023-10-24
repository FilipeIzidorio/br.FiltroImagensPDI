import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;

public class Main {

    private JFrame frame;
    private JLabel imageLabel;
    private JLabel imageLabel2;
    private JButton carregarImagem;
    private JButton realceDeBordaBotao;
    private JButton suavizarBotao;
    private JButton binarizacaoBotao;
    private BufferedImage imagem;

    public Main() {
        frame = new JFrame("Filtros de Imagem");
        frame.setSize(900, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(1,2));

        imageLabel = new JLabel();
        JScrollPane scrollPane = new JScrollPane(imageLabel);



        JPanel barraDeBotoes = new JPanel(new GridLayout(0,1));
        carregarImagem = new JButton("Carregar Imagem");

        realceDeBordaBotao = new JButton("Realce de Borda");
        suavizarBotao = new JButton("Suavização");
        binarizacaoBotao = new JButton("Binarização");

        barraDeBotoes.add(carregarImagem);
        barraDeBotoes.add(realceDeBordaBotao);
        barraDeBotoes.add(suavizarBotao);
        barraDeBotoes.add(binarizacaoBotao);




        imageLabel2 = new JLabel();
        JScrollPane scrollPane2 = new JScrollPane(imageLabel2);
        frame.add(scrollPane);
        frame.add(barraDeBotoes);
        frame.add(scrollPane2);

        carregarImagem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    try {
                        imagem = ImageIO.read(selectedFile);
                        exibirImagem(imagem);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        realceDeBordaBotao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (imagem != null) {
                    BufferedImage imagemSaida = null;
                    try {
                        imagemSaida = Filtros.realceBorda(imagem);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    exibirImagem2(imagemSaida);
                }
            }
        });
        suavizarBotao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (imagem != null) {
                    BufferedImage imagemSaida = null;
                    try {
                        imagemSaida = Filtros.suavizar(imagem);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    exibirImagem2(imagemSaida);
                }

            }
        });
        binarizacaoBotao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (imagem != null) {
                    BufferedImage imagemSaida = null;
                    try {
                        imagemSaida = Filtros.binarizacao(imagem);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    exibirImagem2(imagemSaida);
                }

            }
        });

        frame.setVisible(true);
    }

    private void exibirImagem(BufferedImage image) {
        ImageIcon imageIcon = new ImageIcon(image);
        imageLabel.setIcon(imageIcon);
        imageLabel.revalidate();
        imageLabel.repaint();
    }
    private void exibirImagem2(BufferedImage image) {
        ImageIcon imageIcon = new ImageIcon(image);
        imageLabel2.setIcon(imageIcon);
        imageLabel2.revalidate();
        imageLabel2.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }
}
