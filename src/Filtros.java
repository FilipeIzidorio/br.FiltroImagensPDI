import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Filtros {
    public static BufferedImage suavizar(BufferedImage entrada) throws IOException {
        int largura = entrada.getWidth();
        int altura = entrada.getHeight();

        BufferedImage saida = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);

        double[] filtro_gau = {
                0.0625, 0.125, 0.0625,
                0.125, 0.25, 0.125,
                0.0625, 0.125, 0.0625
        };

        Color px1, px2, px3, px4, px5, px6, px7, px8, px9;

        for (int linha = 1; linha < largura - 2; linha++) {
            for (int coluna = 1; coluna < altura - 2; coluna++) {

                px1 = new Color(entrada.getRGB(linha - 1, coluna - 1));
                px2 = new Color(entrada.getRGB(linha - 1, coluna));
                px3 = new Color(entrada.getRGB(linha - 1, coluna + 1));
                px4 = new Color(entrada.getRGB(linha, coluna - 1));
                px5 = new Color(entrada.getRGB(linha, coluna));
                px6 = new Color(entrada.getRGB(linha, coluna + 1));
                px7 = new Color(entrada.getRGB(linha + 1, coluna - 1));
                px8 = new Color(entrada.getRGB(linha + 1, coluna));
                px9 = new Color(entrada.getRGB(linha + 1, coluna + 1));

                int pixel = (int) (
                        (filtro_gau[0] * px1.getRed()) +
                                (filtro_gau[1] * px2.getRed()) +
                                (filtro_gau[2] * px3.getRed()) +
                                (filtro_gau[3] * px4.getRed()) +
                                (filtro_gau[4] * px5.getRed()) +
                                (filtro_gau[5] * px6.getRed()) +
                                (filtro_gau[6] * px7.getRed()) +
                                (filtro_gau[7] * px8.getRed()) +
                                (filtro_gau[8] * px9.getRed())
                );

                if (pixel > 255) {
                    pixel = 255;
                }
                if (pixel < 0) {
                    pixel = 0;
                }

                Color novaCor = new Color(pixel, pixel, pixel);
                saida.setRGB(linha, coluna, novaCor.getRGB());

            }
        }


        return saida;
    }

    public static BufferedImage realceBorda(BufferedImage entrada) throws IOException {
        int largura = entrada.getWidth();
        int altura = entrada.getHeight();

        BufferedImage saida = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);

        int[] realce = {-1, -1, -1, -1, 8, -1, -1, -1, -1};

        Color px1, px2, px3, px4, px5, px6, px7, px8, px9;

        for (int linha = 1; linha < largura - 2; linha++) {
            for (int coluna = 1; coluna < altura - 2; coluna++) {

                px1 = new Color(entrada.getRGB(linha - 1, coluna - 1));
                px2 = new Color(entrada.getRGB(linha - 1, coluna));
                px3 = new Color(entrada.getRGB(linha - 1, coluna + 1));
                px4 = new Color(entrada.getRGB(linha, coluna - 1));
                px5 = new Color(entrada.getRGB(linha, coluna));
                px6 = new Color(entrada.getRGB(linha, coluna + 1));
                px7 = new Color(entrada.getRGB(linha + 1, coluna - 1));
                px8 = new Color(entrada.getRGB(linha + 1, coluna));
                px9 = new Color(entrada.getRGB(linha + 1, coluna + 1));

                int pixel = (int) (
                        (realce[0] * px1.getRed()) +
                                (realce[1] * px2.getRed()) +
                                (realce[2] * px3.getRed()) +
                                (realce[3] * px4.getRed()) +
                                (realce[4] * px5.getRed()) +
                                (realce[5] * px6.getRed()) +
                                (realce[6] * px7.getRed()) +
                                (realce[7] * px8.getRed()) +
                                (realce[8] * px9.getRed())
                );

                if (pixel > 255) {
                    pixel = 255;
                }
                if (pixel < 0) {
                    pixel = 0;
                }

                Color novaCor = new Color(pixel, pixel, pixel);
                saida.setRGB(linha, coluna, novaCor.getRGB());

            }
        }

        return saida;
    }

    public static BufferedImage binarizacao(BufferedImage entrada) throws IOException {

        int limiar = 130;

        int largura = entrada.getWidth();
        int altura = entrada.getHeight();

        BufferedImage saida = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);

        for (int linha = 0; linha < largura; linha++) {
            for (int coluna = 0; coluna < altura; coluna++) {
                int pixel = entrada.getRGB(linha, coluna);
                Color cor = new Color(pixel);
                int valorCinza = (cor.getRed() + cor.getGreen() + cor.getBlue()) / 3;

                // Verificar se o valor de cinza é menor que o limiar
                if (valorCinza < limiar) {
                    // Definir o pixel como preto
                    saida.setRGB(linha, coluna, Color.BLACK.getRGB());
                } else {
                    // Definir o pixel como branco
                    saida.setRGB(linha, coluna, Color.WHITE.getRGB());
                }


            }

        }
        return saida;

    }

    public static BufferedImage filtroMascara(BufferedImage imagem, String modificacaoNome,
                                              double n1, double n2, double n3, double n4, double n5,
                                              double n6, double n7, double n8, double n9) throws IOException {

        double[] filtro = {n1, n2, n3, n4, n5, n6, n7, n8, n9};
        int altura = imagem.getHeight();
        int largura = imagem.getWidth();
        BufferedImage saida = new BufferedImage(largura, altura, 1);
        for (int coluna = 1; coluna < altura - 1; coluna++) {
            for (int linha = 1; linha < largura - 1; linha++) {
                int px1 = imagem.getRGB(linha - 1, coluna - 1);
                Color cor1 = new Color(px1);
                int px2 = imagem.getRGB(linha - 1, coluna);
                Color cor2 = new Color(px2);
                int px3 = imagem.getRGB(linha - 1, coluna + 1);
                Color cor3 = new Color(px3);
                int px4 = imagem.getRGB(linha, coluna - 1);
                Color cor4 = new Color(px4);
                int px5 = imagem.getRGB(linha, coluna);
                Color cor5 = new Color(px5);
                int px6 = imagem.getRGB(linha, coluna + 1);
                Color cor6 = new Color(px6);
                int px7 = imagem.getRGB(linha + 1, coluna - 1);
                Color cor7 = new Color(px7);
                int px8 = imagem.getRGB(linha + 1, coluna);
                Color cor8 = new Color(px8);
                int px9 = imagem.getRGB(linha + 1, coluna + 1);
                Color cor9 = new Color(px9);

                int novoAzul, novoVermelho, novoVerde;
                novoAzul = (int) (filtro[0] * cor1.getBlue() + filtro[1] * cor2.getBlue() + filtro[2] * cor3.getBlue() +
                        filtro[3] * cor4.getBlue() + filtro[4] * cor5.getBlue() + filtro[5] * cor6.getBlue() +
                        filtro[6] * cor7.getBlue() + filtro[7] * cor8.getBlue() + filtro[8] * cor9.getBlue());
                if (novoAzul > 255) {
                    novoAzul = 255;
                } else if (novoAzul < 0) {
                    novoAzul = 0;
                }
                novoVerde = (int) (filtro[0] * cor1.getGreen() + filtro[1] * cor2.getGreen() + filtro[2] * cor3.getGreen() +
                        filtro[3] * cor4.getGreen() + filtro[4] * cor5.getGreen() + filtro[5] * cor6.getGreen() +
                        filtro[6] * cor7.getGreen() + filtro[7] * cor8.getGreen() + filtro[8] * cor9.getGreen());
                if (novoVerde > 255) {
                    novoVerde = 255;
                } else if (novoVerde < 0) {
                    novoVerde = 0;
                }
                novoVermelho = (int) (filtro[0] * cor1.getRed() + filtro[1] * cor2.getRed() + filtro[2] * cor3.getRed() +
                        filtro[3] * cor4.getRed() + filtro[4] * cor5.getRed() + filtro[5] * cor6.getRed() +
                        filtro[6] * cor7.getRed() + filtro[7] * cor8.getRed() + filtro[8] * cor9.getRed());
                if (novoVermelho > 255) {
                    novoVermelho = 255;
                } else if (novoVermelho < 0) {
                    novoVermelho = 0;
                }
                Color cor = new Color(novoVermelho, novoVerde, novoAzul);
                saida.setRGB(linha, coluna, cor.getRGB());
            }
        }

        return saida;
    }


    public static BufferedImage filter1(BufferedImage imagem) throws IOException {
        return filtroMascara(imagem, "f1", 1, 1, 1, 0, 0, 0, -1, -1, -1);
    }

    public static BufferedImage filter2(BufferedImage imagem) throws IOException {
        return filtroMascara(imagem, "f2", 1, 0, -1, 1, 0, -1, 1, 0, -1);
    }

    public static BufferedImage filter3(BufferedImage imagem) throws IOException {
        return filtroMascara(imagem, "f3", -1, -1, -1, -1, 8, -1, -1, -1, -1);
    }

    public static BufferedImage filter4(BufferedImage imagem) throws IOException {
        return filtroMascara(imagem, "f4", 0, -1, 0, -1, 5, -1, 0, -1, 0);
    }

    public static BufferedImage filter5(BufferedImage imagem) throws IOException {
        return filtroMascara(imagem, "f5", 0, 0, 0, -1, 1, 0, 0, 0, 0);
    }

    public static BufferedImage filter6(BufferedImage imagem) throws IOException {
        return filtroMascara(imagem, "f6", 0, 1, 0, 1, -4, 1, 0, 1, 0);
    }

    public static BufferedImage filter7(BufferedImage imagem) throws IOException {
        return filtroMascara(imagem, "f7", -2, -1, 0, -1, 1, 1, 0, 1, 2);
    }
}
