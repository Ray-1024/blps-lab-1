package ray1024.labs.blps.model.responce;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResultResponse {
    enum Status {
        SUCCESS, FAILURE
    }

    private Status status;
}
