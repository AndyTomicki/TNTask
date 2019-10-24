package truNarrative;

import org.openqa.selenium.By;

class POM {
    static final By GOOGLE_SEARCH_BOX = By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input");
    static final By FIRST_GOOGLE_RESULT = By.xpath("//*[@id=\"rso\"]/div/div/div[1]/div/div/div[1]/a[1]/div/cite");
    static final By EASY_ONBOARDING_STRAP = By.xpath("//*[@id=\"main-content-wrapper\"]/section[1]/div[2]/div/div/h4");
    static final By MENU_MORE = By.id("menu-item-6055");
    static final By MENU_MORE_TRU_NARRATIVE_TEAM = By.id("menu-item-6388");
    static final By MEMBER_HOLDER = By.className("stack-img-content");
}
