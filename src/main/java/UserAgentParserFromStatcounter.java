import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class UserAgentParserFromStatcounter implements UserAgentParser{

@Override
public UserAgent getUserAgentParameters(String userAgent) throws IOException{
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
                    ua.setBrowserName(valueParameter);
                    break;
                case "Browser Version":
                    ua.setBrowserVersion( valueParameter);
                    break;
                case "OS":
                    ua.setOperationSystem(valueParameter);
                    break;
                case "Hardware Vendor":
                    ua.setHardwareVendor(valueParameter);
                    break;
                case "Hardware Model":
                    ua.setHardwareModel( valueParameter);
                    break;
                case "Screen Width":
                    if (!valueParameter.isEmpty())
                        ua.setScreenWidth( Integer.parseInt(valueParameter));
                    break;
                case "Screen Height":
                    if (!valueParameter.isEmpty())
                        ua.setScreenHeight( Integer.parseInt(valueParameter));
                    break;
                case "Is it a desktop device":

                    ua.setItDesktopDevice( parseBooleanValue(valueParameter));
                    break;
                case "Is it a mobile device":

                    ua.setItMobileDevice(parseBooleanValue(valueParameter));
                    break;
                case "Is it a tablet":
                    ua.setItTablet( parseBooleanValue(valueParameter));
                    break;
                case "Is it a crawler/robot":

                    ua.setItCrawlerOrRobot(parseBooleanValue(valueParameter));
                    break;
                case "Is it a console":
                    ua.setItConsole( parseBooleanValue(valueParameter));

                    break;

                default:
                    throw new UknownParameterException(s[0] + " is unknown parameter");
            }
        }
        return ua;

    }

     private boolean parseBooleanValue(String value) {
        return "yes".equals(value.toLowerCase());


    }

}
