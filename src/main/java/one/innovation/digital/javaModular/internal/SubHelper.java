package one.innovation.digital.javaModular.internal;

import one.innovation.digital.javaModular.Operacao;

public class SubHelper implements Operacao {

    @Override
    public int execute(int a, int b) {
        return a-b;
    }
}
