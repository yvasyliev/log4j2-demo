package io.github.yvasyliev.appender;

import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.plugins.Configurable;
import org.apache.logging.log4j.plugins.Plugin;
import org.apache.logging.log4j.plugins.PluginAttribute;
import org.apache.logging.log4j.plugins.PluginFactory;

@Configurable(elementType = Appender.ELEMENT_TYPE)
@Plugin("MessageTemplate")
public record MessageTemplate(String prefix, String suffix) {
    @PluginFactory
    public static MessageTemplate createAppender(@PluginAttribute String prefix,
                                                 @PluginAttribute String suffix) {
        return new MessageTemplate(prefix, suffix);
    }
}
