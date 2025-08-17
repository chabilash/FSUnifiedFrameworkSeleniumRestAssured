package in.podtest.pom;

import com.fasterxml.jackson.databind.ser.Serializers;
import in.podtest.pom.components.HeaderPOM;
import jdk.javadoc.internal.doclets.formats.html.markup.Head;
import org.openqa.selenium.WebDriver;

public class BasePOM {

    protected WebDriver wd;

    protected HeaderPOM headerPOM;

    public BasePOM(WebDriver wd){
        this.wd = wd;
        headerPOM = new HeaderPOM(wd);
    }

    public BasePOM get(String url) {
        wd.get(url);
        return this;
    }

    public HeaderPOM getHeader(){
        return headerPOM;
    }
}
