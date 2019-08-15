package br.com.agendaeletronica.ui;

public class Response {
    private String challenge_ts;
    private String hostname;
    private boolean success;

    public Response() {}

    public String getChallenge_ts() {
        return challenge_ts;
    }

    public void setChallenge_ts(String challenge_ts) {
        this.challenge_ts = challenge_ts;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "ClassPojo [challenge_ts = " + challenge_ts + ", hostname = " + hostname + ", success = " + success + "]";
    }
}
