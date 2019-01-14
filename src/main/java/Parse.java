import java.io.IOException;

public class Parse extends UserAgentParser {

    public static void main(String[] args) throws IOException, UknownParameterException {
        String userAgent = "Mozilla/5.0 (Linux; U; Android 4.1; en-us; GT-N7100 Build/JRO03C) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";

        UserAgent uAgent = getUserAgentParameters(userAgent);
        System.out.println(uAgent.isItMobileDevice);
        System.out.println(uAgent.isItDesktopDevice);

    }
}
