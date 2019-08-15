package br.com.agendaeletronica.ui;

import javax.servlet.http.HttpServletRequest;    
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


public class ReCaptchaV2 {

    private final static Logger logger = LoggerFactory.getLogger(ReCaptchaV2.class);

    private final static String VERIFICATION_URL = "https://www.google.com/recaptcha/api/siteverify";
    private final static String SECRET = "6LcCYK8UAAAAAMo5BzAw_LHcpgIj3g-Mo9hQailp";

    private static ReCaptchaV2 instance = new ReCaptchaV2();

    private ReCaptchaV2() {}

    public static ReCaptchaV2 getInstance() {
        return instance;
    }

    private boolean verify(String recaptchaUserResponse, String remoteip) {
        boolean ret = false;
        if (recaptchaUserResponse == null) {
            return ret;
        }

        RestTemplate rt = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("secret", SECRET);
        map.add("response", recaptchaUserResponse);
        if (remoteip != null) {
            map.add("remoteip", remoteip);
        }
        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<MultiValueMap<String, String>>(map, headers);

        ResponseEntity<String> res = null;
        try {
            res = rt.exchange(VERIFICATION_URL, HttpMethod.POST, httpEntity, String.class);
        } catch (Exception e) {
            logger.error("Exception: " + e.getMessage());
        }

        if (res == null || res.getBody() == null) {
            return ret;
        }

        Response response = null;
        try {
            response = new ObjectMapper().readValue(res.getBody(), Response.class);
        } catch (Exception e) {
            logger.error("Exception: " + e.getMessage());
        }

        if (response != null && response.isSuccess()) {
            ret = true;
        }

        logger.info("Verification result: " + ret);
        return ret;
    }

    public boolean verify(HttpServletRequest httpServletRequest) {
        boolean ret = false;
        if (httpServletRequest == null) {
            return ret;
        }

        String recaptchaUserResponse = httpServletRequest.getParameter("g-recaptcha-response");
        String remoteAddr = httpServletRequest.getRemoteAddr();
        return verify(recaptchaUserResponse, remoteAddr);
    }
}