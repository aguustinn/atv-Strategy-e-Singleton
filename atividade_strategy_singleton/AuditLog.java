import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class AuditLog {
    private static volatile AuditLog instance;
    private final List<String> registros = Collections.synchronizedList(new ArrayList<>());

    private AuditLog() {}

    public static AuditLog getInstance() {
        if (instance == null) {
            synchronized (AuditLog.class) {
                if (instance == null) instance = new AuditLog();
            }
        }
        return instance;
    }

    public void registrar(String mensagem) {
        if (mensagem == null) throw new IllegalArgumentException("A mensagem não pode ser nula.");
        registros.add(mensagem);
    }

    public List<String> getRegistros() {
        synchronized (registros) {
            return Collections.unmodifiableList(new ArrayList<>(registros));
        }
    }

    public void limpar() {
        registros.clear();
    }
}
