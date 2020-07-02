package challenge;

public class CriptografiaCesariana implements Criptografia {

    private final int FATOR_ENCRYPT = 3;
    private final int FATOR_DECRYPT = -3;
    private final String VALID_PATTERN = "^[a-z]+$";

    @Override
    public String criptografar(String texto) {
        return execute(texto, FATOR_ENCRYPT);
    }

    @Override
    public String descriptografar(String texto) {
        return execute(texto, FATOR_DECRYPT);
    }

    private String execute(String texto, int fator) {
        validarTexto(texto);

        StringBuilder resultado = new StringBuilder();

        for (int indice = 0; indice < texto.length(); indice++) {
            String letraAtual = String.valueOf(texto.charAt(indice)).toLowerCase();

            if (letraAtual.matches(VALID_PATTERN)) {
                int codigoLetraAtual = Character.codePointAt(texto, indice);
                char[] codigoProximaLetra = Character.toChars(codigoLetraAtual + fator);
                String proximaLetra = String.valueOf(codigoProximaLetra);
                resultado.append(proximaLetra);
            } else {
                resultado.append(letraAtual);
            }
        }

        return resultado.toString().toLowerCase();
    }

    private void validarTexto(String texto) {
        if (!(texto.trim().length() > 0)) {
            throw new IllegalArgumentException();
        }
    }

}
