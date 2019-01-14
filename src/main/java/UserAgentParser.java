import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class UserAgentParser {


    static UserAgent getUserAgentParameters(String userAgent) throws IOException, UknownParameterException {
        UserAgent ua = new UserAgent();

        Document doc = Jsoup.connect("http://gs.statcounter.com/detect")
                .userAgent(userAgent)
                .timeout(3000)
                .get();

        Elements links = doc.select("#main-el div.section p");

        String value = links.get(1).toString();


        String[] values = value.replaceAll("<br>", "")
                .replaceAll("<p>", "")
                .replaceAll("</p>", "")
                .replaceAll("<strong>", "")
                .split("</strong>");

        for (String parameter : values) {
            String[] s = parameter.split(":");
            String valueParameter = s[1].replaceAll(" ", "");
            switch (s[0]) {
                case "Browser Name":
                    ua.browserName = valueParameter;
                    break;
                case "Browser Version":
                    ua.browserVersion = valueParameter;
                    break;
                case "OS":
                    ua.operationSystem = valueParameter;
                    break;
                case "Hardware Vendor":
                    ua.hardwareVendor = valueParameter;
                    break;
                case "Hardware Model":
                    ua.hardwareModel = valueParameter;
                    break;
                case "Screen Width":
                    if (!valueParameter.equals(""))
                        ua.screenHeight = Integer.parseInt(valueParameter);
                    break;
                case "Screen Height":
                    if (!valueParameter.equals(""))
                        ua.screenWidth = Integer.parseInt(valueParameter);
                    break;
                case "Is it a desktop device":

                    ua.isItDesktopDevice = parseBooleanValue(valueParameter);
                    break;
                case "Is it a mobile device":

                    ua.isItMobileDevice = parseBooleanValue(valueParameter);
                    break;
                case "Is it a tablet":
                    ua.isItTablet = parseBooleanValue(valueParameter);
                    break;
                case "Is it a crawler/robot":

                    ua.isItCrawlerOrRobot = parseBooleanValue(valueParameter);
                    break;
                case "Is it a console":
                    ua.isItConsole = parseBooleanValue(valueParameter);

                    break;

                default:
                    throw new UknownParameterException(s[0] + " is unknown parameter");
            }
        }
        return ua;

    }

    static boolean parseBooleanValue(String value) {
        if (value.toLowerCase().equals("yes"))
            return true;
        else return false;

    }

}
