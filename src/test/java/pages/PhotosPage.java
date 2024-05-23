package pages;

import blocks.SideBar;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class PhotosPage extends BasePage {
    private final SideBar leftMenu = new SideBar();

    private static final By uploadButton = By.xpath("//div[@class='h-mod html5-link_w js-fileapi-wrapper  __no-ui']//input[@class='html5-upload-link __before-upload']");
    private static final By successUpload = By.xpath("//*[contains(@style, 'background-image:url')]");
    private static final By createAlbumButton = By.xpath("//a[@role='button']");
    private static final By allPhotosField = By.xpath("//a[@id='tab-all-photos']");
    private static final By albumsField = By.xpath("//a[@id='tab-albums']");

    public PhotosPage() {
        checkPage();
    }

    public void checkPage() {

    }

    public PhotosPage openPhotoPage() {
        $(leftMenu.getPhotoButton()).shouldBe(visible.because("photo button should be visible")).click();
        $(allPhotosField).shouldBe(visible.because("allPhotosField should be visible on photo page"));
        $(createAlbumButton).shouldBe(visible.because("createAlbumButton should be visible on photo page"));
        $(albumsField).shouldBe(visible.because("albumsField should be visible on photo page"));
        return new PhotosPage();
    }

    public boolean uploadPhoto() {
        $(uploadButton).uploadFile(new File("src/test/resources/error.JPG"));
        $(successUpload).shouldBe(visible.because("Photo should be visible after upload"));
        return true;
    }
}
