package org.example.functions;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.annotation.EventGridTrigger;
import com.microsoft.azure.functions.annotation.FunctionName;
import org.apache.commons.text.StringEscapeUtils;

/**
 * Azure Functions with HTTP Trigger.
 */
public class EventTriggerFunction {
    /**
     * This function listens at endpoint "/api/HttpExample". Two ways to invoke it using "curl" command in bash:
     * 1. curl -d "HTTP Body" {your host}/api/HttpExample
     * 2. curl "{your host}/api/HttpExample?name=HTTP%20Query"
     */
    @FunctionName("LMSFolioEventLoyaltyTeamConsumer")
    public void logEvent(
            @EventGridTrigger(
                    name = "event"
            )
            String content,
            final ExecutionContext context) {
        context.getLogger().info("Event content as is: " + content);
        context.getLogger().info("Event content unescaped: " + StringEscapeUtils.unescapeXml(content));

    }
}
