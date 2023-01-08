package com.mxs.huobi.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SendMessageOciStreamsRequest implements Serializable {
    private static final long serialVersionUID = -8167242821580490202L;
    @NotBlank(message = "Value cannot be blank")
    private String value;
}
