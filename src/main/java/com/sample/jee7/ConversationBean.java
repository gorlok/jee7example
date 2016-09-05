package com.sample.jee7;

import java.io.Serializable;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.logging.log4j.Logger;

@Named
@ConversationScoped
public class ConversationBean
implements Serializable {
    private static final long serialVersionUID = 1;
    private String someValue;
    @Inject
    private Conversation conversation;
    @Inject
    private transient Logger logger;

    public void start() {
        this.conversation.begin();
        this.logger.trace("conversation started");
    }

    public void end() {
        this.conversation.end();
        this.logger.trace("conversation ended");
    }

    public String onClick() {
        this.logger.trace("on click");
        if (this.someValue.equals("") || this.conversation == null) {
            return "";
        }
        this.start();
        return "nextpage?faces-redirect=true";
    }

    public String onKeepGoing() {
        this.logger.trace("on keep going");
        return "finish?faces-redirect=true";
    }

    public String onFinish() {
        this.logger.trace("on finish");
        this.end();
        return "index?faces-redirect=true";
    }

    public String getSomeValue() {
        return this.someValue;
    }

    public void setSomeValue(String someValue) {
        this.someValue = someValue;
    }
}