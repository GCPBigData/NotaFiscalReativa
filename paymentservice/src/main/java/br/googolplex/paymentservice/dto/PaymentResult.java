package br.googolplex.paymentservice.dto;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 07/07/2020
 */
public class PaymentResult {

    private boolean successful;

    public PaymentResult() {
    }

    public PaymentResult(boolean successful) {
        this.successful = successful;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }
}
