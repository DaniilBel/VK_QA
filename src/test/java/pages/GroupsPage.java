package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class GroupsPage extends BasePage {
    private static final String GROUP_NAME = "test";
    private static final By CREATE_GROUP_BUTTON = By.xpath("//*[contains(@class, 'groups-catalog-header_button')]");
    private static final By ACTUAL_FIELD = By.xpath("//a[contains(@aria-label,'Актуально')]");
    private static final By NEW_FIELD = By.xpath("//a[@aria-label='Новые']");
    private static final By GROUP_TYPES = By.xpath("//div[@class='create-group-dialog-v2_n']");
    private static final By GROUP_NAME_FIELD = By.xpath("//input[@name='st.layer.name']");
    private static final By GROUP_THEME_FIELD = By.xpath("//input[@autocomplete='new-password']");
    private static final By THEME = By.xpath("//div[contains(@class,'multi-select-suggest-content js-multi-select-scroll')]");
    private static final By CREATE_BUTTON = By.xpath("//input[@data-l='t,confirm']");
    private static final By MORE_BUTTON = By.xpath("//button[@class='u-menu_a toggle-dropdown button-clear']");
    private static final By DELETE_BUTTON = By.xpath(".//a[contains(text(),'Удалить')]");
    private static final By CONFIRM_BUTTON = By.xpath(".//input[@id='hook_FormButton_button_delete']");

    public GroupsPage() {
        checkPage();
    }

    @Override
    public void checkPage() {

    }

    public GroupsPage openGroupspage() {
        $(CREATE_GROUP_BUTTON).shouldBe(visible.because("createGroupButton button should be visible on groups page"));
        $(ACTUAL_FIELD).shouldBe(visible.because("ACTUAL_FIELD should be visible on groups page"));
        $(NEW_FIELD).shouldBe(visible.because("ACTUAL_FIELD should be visible on groups page"));

        return new GroupsPage();
    }

    public boolean createGroup() {
        $(CREATE_GROUP_BUTTON).shouldBe(visible.because("createGroupButton button should be visible on groups page")).click();
        $$(GROUP_TYPES).first().shouldBe(visible.because("groupTypes should be visible after click on create")).click();
        $(GROUP_NAME_FIELD).shouldBe(visible.because("groupNameField should be visible on groups type")).setValue(GROUP_NAME);
        $(GROUP_THEME_FIELD).shouldBe(visible.because("groupNameField should be visible on groups type")).click();
        $$(THEME).first().shouldBe(visible.because("theme should be visible after click on groups type")).click();
        $(CREATE_BUTTON).shouldBe(visible.because("createButton should be visible after click on theme")).click();
        return true;
    }

    public void deleteGroup() {
        $(MORE_BUTTON).shouldBe(visible.because("threeDotsButton button should be visible")).click();
        $(DELETE_BUTTON).shouldBe(visible.because("deleteButton button should be visible")).click();
        $(CONFIRM_BUTTON).shouldBe(visible.because("confirmButton button should be visible")).click();
    }
}
