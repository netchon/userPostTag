package cv.zing.interview.utilities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.List;

public class ApiResponse {
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private final LocalDateTime timestamp;
    private final boolean status;
    private final String statusText;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Object> details;

    // Private constructor that is used by the builder
    private ApiResponse(Builder builder) {
        this.timestamp = builder.timestamp;
        this.status = builder.status;
        this.statusText = builder.statusText;
        this.details = builder.details;
    }

    // Getters (No setters to ensure immutability)
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public boolean isStatus() {
        return status;
    }

    public String getStatusText() {
        return statusText;
    }

    public List<Object> getDetails() {
        return details;
    }

    // Static Builder Class
    public static class Builder {
        private LocalDateTime timestamp = LocalDateTime.now();
        private boolean status;
        private String statusText;
        private List<Object> details;

        public Builder withTimestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder withStatus(boolean status) {
            this.status = status;
            return this;
        }

        public Builder withStatusText(String statusText) {
            this.statusText = statusText;
            return this;
        }

        public Builder withDetails(List<Object> details) {
            this.details = details;
            return this;
        }

        public ApiResponse build() {
            return new ApiResponse(this);
        }
    }
}