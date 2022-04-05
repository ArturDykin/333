import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "rqUID",
            "rqType",
            "rqTm",
            "systemFrom",
            "systemTo",
            "contextUserInfo",
            "contextId",
            "sessionId",
            "ipAddress"
    })
    @ToString
    @Builder
    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public class HeaderInfo {

        @JsonProperty("rqUID")
        private String rqUID;
        @JsonProperty("rqType")
        private String rqType;
        @JsonProperty("rqTm")
        private String rqTm;
        @JsonProperty("systemFrom")
        private String systemFrom;
        @JsonProperty("systemTo")
        private String systemTo;
        @JsonProperty("contextUserInfo")
        private String contextUserInfo;
        @JsonProperty("contextId")
        private String contextId;
        @JsonProperty("sessionId")
        private String sessionId;
        @JsonProperty("ipAddress")
        private String ipAddress;


    }



