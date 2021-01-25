package com.platform.salus.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;
import java.util.ResourceBundle;

@Configuration
public class Internationalization implements WebMvcConfigurer {

    private ResourceBundle messagesBundle;

    public void setMessagesBundle(Locale locale) {
        this.messagesBundle = ResourceBundle.getBundle("messages", locale);
    }

    public ResourceBundle getMessagesBundle(){
        return this.messagesBundle;
    }

    public String getMessage(String key){
        if(this.messagesBundle == null)
            initDefaultMessagesBundle();

        return this.messagesBundle.getString(key);
    }

    public void initDefaultMessagesBundle(){
        this.setMessagesBundle(Locale.getDefault());
    }
}

