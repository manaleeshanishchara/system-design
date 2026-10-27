package designpattern.Builder;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Builder {
    public static void main(String[] args) {
        System.out.println("Hello from Builder!");

        HttpRequest request = new HttpRequest.Builder("http://apple.com")
                .method("GET")
                .headers("Content-Type", "application/json")
                .timeout(5000)
                .build();

        System.out.println(request.toString());

    }
}

class HttpRequest {
    private final String url;
    private final String method;
    private final Map<String, String> headers;
    private final int timeout;

    private HttpRequest(Builder builder) {
        this.url = builder.url;
        this.method = builder.method;
        this.timeout = builder.timeout;
        this.headers = Collections.unmodifiableMap(new HashMap<>(builder.headers));
    }

    static class Builder {
        private final String url;
        private String method;
        private Map<String, String> headers = new HashMap<>();
        private int timeout;

        public Builder(String url) {
            this.url = url;
        }

        public Builder method(String method) {
            this.method = method;
            return this;
        }

        public Builder headers(String key, String value) {
            this.headers.put(key, value);
            return this;
        }

        public Builder timeout(int timeout) {
            this.timeout = timeout;
            return this;
        }

        public HttpRequest build() {
            return new HttpRequest(this);
        }

    }

    @Override
    public String toString() {
        return "HttpRequest{" +
                "url='" + url + '\'' +
                ", method='" + method + '\'' +
                ", headers=" + headers +
                ", timeout=" + timeout +
                '}';
    }

}