package designpattern.Builder;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello from Builder!");

        HttpRequestTelescoping request = new HttpRequestTelescoping.Builder("https://example.com")
                .method("POST")
                .headers(Map.of("Content-Type", "application/json"))
                .queryParams(Map.of("param1", "value1"))
                .body("{\"key\":\"value\"}")
                .timeout(5000)
                .build();

        System.out.println("Request URL: " + request);
    }
}

class HttpRequestTelescoping {
    private final String url;
    private final String method;
    private final Map<String, String> headers;
    private final Map<String, String> queryParams;
    private final String body;
    private final int timeout;

    private HttpRequestTelescoping(Builder builder) {
        this.url = builder.url;
        this.method = builder.method;
        this.headers = builder.headers;
        this.queryParams = builder.queryParams;
        this.body = builder.body;
        this.timeout = builder.timeout;
    }

    @Override
    public String toString() {
        return "HttpRequestTelescoping{ " +
                "url='" + url + '\'' +
                ", method='" + method + '\'' +
                ", headers=" + headers +
                ", queryParams=" + queryParams +
                ", body='" + body + '\'' +
                ", timeout=" + timeout +
                " }";
    }

    public static class Builder {
        private final String url;
        public String method = "GET";
        public Map<String, String> headers;
        public Map<String, String> queryParams;
        public String body;
        public int timeout;

        public Builder(String url) {
            this.url = url;
        }

        public Builder method(String method) {
            this.method = method;
            return this;
        }

        public Builder headers(Map<String, String> headers) {
            this.headers = headers;
            return this;
        }

        public Builder queryParams(Map<String, String> queryParams) {
            this.queryParams = queryParams;
            return this;
        }

        public Builder body(String body) {
            this.body = body;
            return this;
        }

        public Builder timeout(int timeout) {
            this.timeout = timeout;
            return this;
        }

        public HttpRequestTelescoping build() {
            return new HttpRequestTelescoping(this);
        }
    }

}