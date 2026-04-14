import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transferencia {
    private final Cliente emisor;
    private final Cliente receptor;
    private final BigDecimal monto;
    private final String fecha;

    private Transferencia(Builder builder) {
        this.emisor = builder.emisor;
        this.receptor = builder.receptor;
        this.monto = builder.monto;
        this.fecha = builder.fecha;
    }

    public static class Builder {
        private final Cliente emisor;
        private final Cliente receptor;
        private final BigDecimal monto;

        private String fecha = LocalDateTime.now().toString();

        public Builder(Cliente emisor, Cliente receptor, BigDecimal monto) {
            this.emisor = emisor;
            this.receptor = receptor;
            this.monto = monto;
        }

        public Transferencia.Builder fecha(String fecha) {
            this.fecha = fecha;
            return this;
        }

        public Transferencia acreditar() {
            //Validador?
            //Próximamente, solo en cines.
            receptor.sumarSaldo(monto);
            emisor.restarSaldo(monto);
            return new Transferencia(this);
        }
    }


}