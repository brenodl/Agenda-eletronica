package br.com.agendaeletronica.ui;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.apache.wicket.Component;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.RequestCycle;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.form.FormComponentPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.protocol.http.WebRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.agendaeletronica.service.ReCaptcha;
import br.com.agendaeletronica.service.ReCaptchaFactory;
import br.com.agendaeletronica.service.ReCaptchaImpl;
import br.com.agendaeletronica.service.ReCaptchaResponse;


@SuppressWarnings("serial")
public class RecaptchaPanel extends Panel {
	
	private final String PRIVATE_KEY = "6LcCYK8UAAAAAMo5BzAw_LHcpgIj3g-Mo9hQailp";
	private final String PUBLIC_KEY = "6LcCYK8UAAAAAMD5BD6F-h21MHoNr7jvcqnNH0Ph";
	
  private static final Logger LOG = LoggerFactory.getLogger(RecaptchaPanel.class);

  public RecaptchaPanel(final String id) {
    super(id);
    final ReCaptcha recaptcha = ReCaptchaFactory.newReCaptcha(PUBLIC_KEY, PRIVATE_KEY, false);
    add(new FormComponent<Serializable>("captcha", new Model<Serializable>()) {
      @Override
	public void onComponentTagBody(final MarkupStream markupStream, final ComponentTag openTag) {
        replaceComponentTagBody(markupStream, openTag, recaptcha.createRecaptchaHtml(null, null));
      }
    });  
  } 
  public void validate() {
//	  
//	  
//     //final String remoteAddr = request.getHttpServletRequest().getRemoteAddr();
//      final ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
//      reCaptcha.setPrivateKey(PRIVATE_KEY);
//
//      final String challenge = request.getParameter("recaptcha_challenge_field");
//      final String uresponse = request.getParameter("recaptcha_response_field");
//      final ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(remoteAddr, challenge, uresponse);
//
//      if (!reCaptchaResponse.isValid()) {
//        LOG.debug("wrong captcha");
//        error("Invalid captcha!");
//      }
    }
  
}