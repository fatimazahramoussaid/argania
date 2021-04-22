package cloudcode.guestbook.backend;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * defines the REST endpoints managed by the server.
 */
@RestController
public class BackendController {

    @Autowired private MessageRepository repository;

    /**
     * endpoint for retrieving all guest book entries stored in database
     * @return a list of FeatureEntry objects
     */
    @GetMapping("/messages")
    public final List<FeatureEntry> getMessages() {
        Sort byCreation = new Sort(Sort.Direction.DESC, "_id");
        List<FeatureEntry> msgList = repository.findAll(byCreation);
        return msgList;
    }

    @GetMapping("/message/{id}")
    public final FeatureEntry getOneMessage(@PathVariable String id) {
        FeatureEntry entry = new FeatureEntry();
        entry.setid(id);
        Example<FeatureEntry> example = Example.of(entry);
        FeatureEntry msgList = repository.findOne(example).get();
        return msgList;
    }

    @GetMapping("/urlbackend")
    public final String getUrlBackend(HttpServletRequest request) {
        return request.getRemoteAddr();
    }

    /**
     * endpoint for adding a new guest book entry to the database
     * @param message a message object passed in the HTTP POST request
     */
    @PostMapping("/messages")
    public final void addMessage(@RequestBody FeatureEntry message) {
        repository.save(message);
    }
}
