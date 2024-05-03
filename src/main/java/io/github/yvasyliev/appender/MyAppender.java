package io.github.yvasyliev.appender;

import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.Property;
import org.apache.logging.log4j.core.layout.PatternLayout;
import org.apache.logging.log4j.plugins.Configurable;
import org.apache.logging.log4j.plugins.Plugin;
import org.apache.logging.log4j.plugins.PluginAttribute;
import org.apache.logging.log4j.plugins.PluginElement;
import org.apache.logging.log4j.plugins.PluginFactory;

@Configurable(elementType = Appender.ELEMENT_TYPE)
@Plugin("MyAppender")
public class MyAppender extends AbstractAppender {
    private final MessageTemplate messageTemplate;

    private MyAppender(String name, MessageTemplate messageTemplate) {
        super(name, null, PatternLayout.createDefaultLayout(), true, Property.EMPTY_ARRAY);
        this.messageTemplate = messageTemplate;
    }

    @PluginFactory
    public static MyAppender createAppender(@PluginAttribute("name") String name,
                                            @PluginElement("MessageTemplate") MessageTemplate messageTemplate) {
        return new MyAppender(name, messageTemplate);
    }

    @Override
    public void append(LogEvent event) {
        var prefix = messageTemplate.prefix();
        var formattedMessage = event.getMessage().getFormattedMessage();
        var suffix = messageTemplate.suffix();

        var text = prefix + formattedMessage + suffix;
        System.out.println(text);
    }
}
