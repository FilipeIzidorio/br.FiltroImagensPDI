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

        for (int linha = 1; linha < largura-2; linha++){
            for (int coluna = 1; coluna < altura-2; coluna++){

                px1 = new Color( entrada.getRGB(linha-1, coluna-1) );
                px2 = new Color( entrada.getRGB(linha-1, coluna) );
                px3 = new Color( entrada.getRGB(linha-1, coluna+1) );
                px4 = new Color( entrada.getRGB(linha, coluna-1) );
                px5 = new Color( entrada.getRGB(linha, coluna) );
                px6 = new Color( entrada.getRGB(linha, coluna+1) );
                px7 = new Color( entrada.getRGB(linha+1, coluna-1) );
                px8 = new Color( entrada.getRGB(linha+1, coluna) );
                px9 = new Color( entrada.getRGB(linha+1, coluna+1) );

                int pixel = (int) (
                        (filtro_gau[0] * px1.getRed())+
                                (filtro_gau[1] * px2.getRed())+
                                (filtro_gau[2] * px3.getRed())+
                                (filtro_gau[3] * px4.getRed())+
                                (filtro_gau[4] * px5.getRed())+
                                (filtro_gau[5] * px6.getRed())+
                                (filtro_gau[6] * px7.getRed())+
                                (filtro_gau[7] * px8.getRed())+
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

        for (int linha = 1; linha < largura-2; linha++){
            for (int coluna = 1; coluna < altura-2; coluna++){

                px1 = new Color( entrada.getRGB(linha-1, coluna-1) );
                px2 = new Color( entrada.getRGB(linha-1, coluna) );
                px3 = new Color( entrada.getRGB(linha-1, coluna+1) );
                px4 = new Color( entrada.getRGB(linha, coluna-1) );
                px5 = new Color( entrada.getRGB(linha, coluna) );
                px6 = new Color( entrada.getRGB(linha, coluna+1) );
                px7 = new Color( entrada.getRGB(linha+1, coluna-1) );
                px8 = new Color( entrada.getRGB(linha+1, coluna) );
                px9 = new Color( entrada.getRGB(linha+1, coluna+1) );

                int pixel = (int) (
                        (realce[0] * px1.getRed())+
                                (realce[1] * px2.getRed())+
                                (realce[2] * px3.getRed())+
                                (realce[3] * px4.getRed())+
                                (realce[4] * px5.getRed())+
                                (realce[5] * px6.getRed())+
                                (realce[6] * px7.getRed())+
                                (realce[7] * px8.getRed())+
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

}
