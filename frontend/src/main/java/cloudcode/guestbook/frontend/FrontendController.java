package cloudcode.guestbook.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.util.Base64;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.util.LinkedMultiValueMap;
import javax.servlet.http.HttpServletRequest;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.UUID;


import org.springframework.http.HttpHeaders;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

/**
 * defines the REST endpoints managed by the server.
 */
@Controller
public class FrontendController {

    private String backendUri = String.format("http://%s/messages",
        System.getenv("GUESTBOOK_API_ADDR"));
    
    private String backendOneUri = String.format("http://%s/message",
        System.getenv("GUESTBOOK_API_ADDR"));

    private String urlbackend = String.format("http://%s/urlbackend",
        System.getenv("GUESTBOOK_API_ADDR"));
    /**
     * endpoint for the landing page
     * @param model defines model for html template
     * @return the name of the html template to render
     */
    @GetMapping("/")
    public final String main(final Model model) {
        RestTemplate restTemplate = new RestTemplate();
        FeatureEntry[] response = restTemplate.getForObject(backendUri,
            FeatureEntry[].class);

        model.addAttribute("messages", response);
        return "home";
    }

    /**
     * endpoint for handling form submission
     * @param formMessage holds date entered in html form
     * @return redirects back to home page
     * @throws URISyntaxException when there is an issue with the backend uri
     */
    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public final String post(final FeatureEntry formMessage)
            throws URISyntaxException {
        URI url = new URI(backendUri);
        String featid = UUID.randomUUID().toString();
        formMessage.setid(featid);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Type", "application/json");
        HttpEntity<FeatureEntry> httpEntity =
            new HttpEntity<FeatureEntry>(formMessage, httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject(url, httpEntity, String.class);

        return "redirect:/";
    }

    /**
     * Create an endpoint for the landing page
     * @return the index view template with a simple debate_id
     */
    @GetMapping("/newfeature")
    public final String newfeature(Model model) {
        return "newfeature";
    }

    @GetMapping("/deletefeature/{id}")
    public String deletefeature(Model model, @PathVariable String id) {
        model.addAttribute("id", id);
        return "deletefeature";
    }

    @GetMapping("/detailfeature/{id}")
    public String detailfeature(Model model, @PathVariable String id) {
        RestTemplate restTemplate = new RestTemplate();
        FeatureEntry response = restTemplate.getForObject(backendOneUri + "/" + id,
            FeatureEntry.class);

        model.addAttribute("feature", response);
        return "detailfeature";
    }

    @GetMapping("/sendinvit/{href}/{username}/{roleid}/{id1}/{id2}/{nbrounds}/{debatesubject}/{opinion}")
    public String sendinvit(Model model, @PathVariable String href, @PathVariable String username,
                            @PathVariable String roleid, @PathVariable String id1, 
                            @PathVariable String id2, @PathVariable String nbrounds,
                            @PathVariable String debatesubject, @PathVariable String opinion) {
        
        String debate_id = UUID.randomUUID().toString();
        //----
        byte[] decodedBytes = Base64.getDecoder().decode(debatesubject);
        String decodedDebateSubject = new String(decodedBytes);

        byte[] decodedBytes1 = Base64.getDecoder().decode(opinion);
        String decodedOpinion = new String(decodedBytes1);

        String resp = sendMail(decodedDebateSubject, decodedOpinion, href + "/runningdebate/" + username + "/" + roleid + "/" + debate_id + "/"+debatesubject, id1);
               resp = sendMail(decodedDebateSubject, decodedOpinion, href + "/runningdebate/invited/324SD/" + debate_id + "/" + debatesubject, id2);
        model.addAttribute("errors", "");
        model.addAttribute("debate_url", "http://" + href + "/runningdebate/" + username + "/" + roleid + "/" + debate_id + "/" + debatesubject);

        return "sendinvit";
    }


    @GetMapping("/clouddesign")
    public final String clouddesign(Model model) {
        return "clouddesign";
    }

    @GetMapping("/datatransformation")
    public final String datatransformation(Model model) {
        return "datatransformation";
    }

    @GetMapping("/restapi")
    public final String restapi(Model model) {
        return "restapi";
    }

    @GetMapping("/database")
    public final String database(Model model) {
        return "database";
    }
    
    @GetMapping("/freestyle")
    public final String freestyle(Model model) {
        return "freestyle";
    }

    @GetMapping("/webpage")
    public final String webpage(Model model) {
        return "webpage";
    }
    @GetMapping("/namingrules")
    public final String namingrules(Model model) {
        return "namingrules";
    }
    @GetMapping("/glossary")
    public final String glossary(Model model) {
        return "glossary";
    }
    @GetMapping("/batchprocess")
    public final String batchprocess(Model model) {
        return "batchprocess";
    }
    @GetMapping("/exportbutton")
    public final String exportbutton(Model model) {
        return "exportbutton";
    }
    @GetMapping("/manueloperations")
    public final String manueloperations(Model model) {
        return "manueloperations";
    }
    @GetMapping("/switchviewbutton")
    public final String switchviewbutton(Model model) {
        return "switchviewbutton";
    }

    public String sendMail(String debatesubject, String opinion, String addr, String email) {

    final String username = "hackathongreatdebaters@gmail.com";
    final String password = "hackathongreatdebaters@21";

    Properties prop = new Properties();
    prop.put("mail.smtp.host", "smtp.gmail.com");
    prop.put("mail.smtp.port", "587");
    prop.put("mail.smtp.auth", "true");
    prop.put("mail.smtp.starttls.enable", "true"); //TLS

    Session session = Session.getInstance(prop,
        new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
            }
        });

    try {

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("hackathongreatdebaters@gmail.com"));
        message.setRecipients(
            Message.RecipientType.TO,
            InternetAddress.parse(email)
        );
        message.setSubject("New debate game > : " + debatesubject);

        String html = "<p>Hello !</p>";
               html = html + "You're invited to a debate game, please click on the link to join";
               html = html + "<br/>";
               html = html + "<h4>Subject : " +debatesubject + " </h4>";
               html = html + "<h4>The other opinion : " + opinion + "</h4>";
               html = html + "<a style=\"font-size: 20px; color:blue;\" href=\"" +"http://" + addr+ "\">Join The Debate Game</a>";
        message.setContent(html, "text/html; charset=utf-8");

        Transport.send(message);

        System.out.println("Done");

    } catch (MessagingException e) {
        StringWriter errors = new StringWriter();
        e.printStackTrace(new PrintWriter(errors));
        return errors.toString();
    }

    return "message envoye yes !";
}

}
