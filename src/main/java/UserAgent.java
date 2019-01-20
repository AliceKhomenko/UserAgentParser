public class UserAgent {
   private String browserName;
    private String browserVersion;
    private String operationSystem;
    private String hardwareVendor;
    private String hardwareModel;
    private    int screenWidth;
    private int screenHeight;
    private boolean isItDesktopDevice;
    private boolean isItMobileDevice;
    private boolean isItTablet;
    private boolean isItCrawlerOrRobot;
    private boolean isItConsole;

    public String getBrowserName() {
        return browserName;
    }

    public void setBrowserName(String browserName) {
        this.browserName = browserName;
    }

    public String getBrowserVersion() {
        return browserVersion;
    }

    public void setBrowserVersion(String browserVersion) {
        this.browserVersion = browserVersion;
    }

    public String getOperationSystem() {
        return operationSystem;
    }

    public void setOperationSystem(String operationSystem) {
        this.operationSystem = operationSystem;
    }

    public String getHardwareVendor() {
        return hardwareVendor;
    }

    public void setHardwareVendor(String hardwareVendor) {
        this.hardwareVendor = hardwareVendor;
    }

    public String getHardwareModel() {
        return hardwareModel;
    }

    public void setHardwareModel(String hardwareModel) {
        this.hardwareModel = hardwareModel;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public void setScreenWidth(int screenWidth) {
        this.screenWidth = screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public void setScreenHeight(int screenHeight) {
        this.screenHeight = screenHeight;
    }

    public boolean isItDesktopDevice() {
        return isItDesktopDevice;
    }

    public void setItDesktopDevice(boolean itDesktopDevice) {
        isItDesktopDevice = itDesktopDevice;
    }

    public boolean isItMobileDevice() {
        return isItMobileDevice;
    }

    public void setItMobileDevice(boolean itMobileDevice) {
        isItMobileDevice = itMobileDevice;
    }

    public boolean isItTablet() {
        return isItTablet;
    }

    public void setItTablet(boolean itTablet) {
        isItTablet = itTablet;
    }

    public boolean isItCrawlerOrRobot() {
        return isItCrawlerOrRobot;
    }

    public void setItCrawlerOrRobot(boolean itCrawlerOrRobot) {
        isItCrawlerOrRobot = itCrawlerOrRobot;
    }

    public boolean isItConsole() {
        return isItConsole;
    }

    public void setItConsole(boolean itConsole) {
        isItConsole = itConsole;
    }



}
