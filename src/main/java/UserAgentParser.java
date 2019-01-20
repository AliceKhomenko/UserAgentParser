import java.io.IOException;

public interface UserAgentParser {
    UserAgent getUserAgentParameters(String userAgent) throws IOException;
}
