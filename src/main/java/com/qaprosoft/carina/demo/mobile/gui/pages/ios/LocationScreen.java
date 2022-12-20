package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.DrawScreenBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.LocationScreenBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = LocationScreenBase.class)

public class LocationScreen extends LocationScreenBase {
    public LocationScreen(WebDriver driver) {
        super(driver);
    }
}
