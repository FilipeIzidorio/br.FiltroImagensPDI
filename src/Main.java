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
    private JButton filtro1Botao;
    private JButton filtro2Botao;
    private JButton filtro3Botao;
    private JButton filtro4Botao;
    private JButton filtro5Botao;
    private JButton filtro6Botao;
    private JButton filtro7Botao;
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
        filtro1Botao = new JButton("Filtro 1");
        filtro2Botao = new JButton("Filtro 2");
        filtro3Botao = new JButton("Filtro 3");
        filtro4Botao = new JButton("Filtro 4");
        filtro5Botao = new JButton("Filtro 5");
        filtro6Botao = new JButton("Filtro 6");
        filtro7Botao = new JButton("Filtro 7");

        barraDeBotoes.add(carregarImagem);
        barraDeBotoes.add(realceDeBordaBotao);
        barraDeBotoes.add(suavizarBotao);
        barraDeBotoes.add(binarizacaoBotao);
        barraDeBotoes.add(filtro1Botao);
        barraDeBotoes.add(filtro2Botao);
        barraDeBotoes.add(filtro3Botao);
        barraDeBotoes.add(filtro4Botao);
        barraDeBotoes.add(filtro5Botao);
        barraDeBotoes.add(filtro6Botao);
        barraDeBotoes.add(filtro7Botao);




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
        filtro1Botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (imagem != null) {
                    BufferedImage imagemSaida = null;
                    try {
                        imagemSaida = Filtros.filter1(imagem);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    exibirImagem2(imagemSaida);
                }

            }
        });
        filtro2Botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (imagem != null) {
                    BufferedImage imagemSaida = null;
                    try {
                        imagemSaida = Filtros.filter2(imagem);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    exibirImagem2(imagemSaida);
                }

            }
        });
        filtro3Botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (imagem != null) {
                    BufferedImage imagemSaida = null;
                    try {
                        imagemSaida = Filtros.filter3(imagem);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    exibirImagem2(imagemSaida);
                }

            }
        });
        filtro4Botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (imagem != null) {
                    BufferedImage imagemSaida = null;
                    try {
                        imagemSaida = Filtros.filter4(imagem);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    exibirImagem2(imagemSaida);
                }

            }
        });
        filtro5Botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (imagem != null) {
                    BufferedImage imagemSaida = null;
                    try {
                        imagemSaida = Filtros.filter5(imagem);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    exibirImagem2(imagemSaida);
                }

            }
        });
        filtro6Botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (imagem != null) {
                    BufferedImage imagemSaida = null;
                    try {
                        imagemSaida = Filtros.filter6(imagem);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    exibirImagem2(imagemSaida);
                }

            }
        });
        filtro7Botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (imagem != null) {
                    BufferedImage imagemSaida = null;
                    try {
                        imagemSaida = Filtros.filter7(imagem);
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
