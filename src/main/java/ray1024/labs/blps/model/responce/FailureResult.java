package ray1024.labs.blps.model.responce;

import lombok.Getter;

@Getter
public class FailureResult extends ResultResponse {
    private String reason;

    public FailureResult() {
        super(Status.FAILURE);
    }

    public FailureResult(String reason) {
        super(Status.FAILURE);
        this.reason = reason;
    }
}
