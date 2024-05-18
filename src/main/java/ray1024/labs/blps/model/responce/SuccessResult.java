package ray1024.labs.blps.model.responce;

import lombok.Getter;

@Getter
public class SuccessResult<T> extends ResultResponse {
    private T data;

    public SuccessResult() {
        super(Status.SUCCESS);
    }

    public SuccessResult(T data) {
        super(Status.SUCCESS);
        this.data = data;
    }
}
