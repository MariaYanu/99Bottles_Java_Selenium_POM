package tests;

import base.BaseTest;
import network.CaptureNetworkTraffic;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pages.search_languages.SearchLanguagesPage;
import utils.TestUtils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class APISearchLanguagesTest extends BaseTest {

    final static String LANGUAGE_NAME = "python";
    final static String ACTION = "search.html";
    final static String METHOD = "post";
    final static String NAME_INPUT_1 = "search";
    final static String NAME_INPUT_2 = "submitsearch";
    final static String VALUE_INPUT2 = "GO";
    //search=python&submitsearch=GO - payload
    final static String PAYLOAD = NAME_INPUT_1 + "=" + LANGUAGE_NAME + "&" + NAME_INPUT_2 + "=" + VALUE_INPUT2;
    final static String PAGE_CONTEXT_BEFORE_REQUEST = "Search Languages\n" + "Search for:";

    @Test
    public void testAttributes_DefaultValues() {
        SearchLanguagesPage searchLanguagesPage =
                openBaseURL().clickSearchLanguagesHeader();

        Assert.assertEquals(searchLanguagesPage.getAction(), TestUtils.getBaseUrl()+ACTION);
        Assert.assertEquals(searchLanguagesPage.getMethod(), METHOD);
        Assert.assertEquals(searchLanguagesPage.getInput1Name(), NAME_INPUT_1);
        Assert.assertEquals(searchLanguagesPage.getInput2Name(), NAME_INPUT_2);
        Assert.assertEquals(searchLanguagesPage.getInput2Value(), VALUE_INPUT2);
        Assert.assertEquals(searchLanguagesPage.getPageContext(), PAGE_CONTEXT_BEFORE_REQUEST);

    }

    @Test
    public void testAPI_HttpRequest_GET() {
        final String expectedMethod = "GET";
        final String expectedEndPoint = "search.html";

        List<String> httpRequest = new CaptureNetworkTraffic()
                .setUpDevTool(getDriver())
                .captureHttpRequests(expectedEndPoint,expectedMethod);

        openBaseURL().clickSearchLanguagesHeader();

        System.out.println(httpRequest);

        Assert.assertEquals(httpRequest.get(0), expectedMethod);
        Assert.assertEquals(httpRequest.get(1), TestUtils.getBaseUrl() + expectedEndPoint);
        Assert.assertEquals(httpRequest.get(2), "Optional.empty");
        Assert.assertEquals(httpRequest.get(3), "Optional.empty");
    }

    @Test
    public void testAPI_HttpResponse_GET() {
        final String expectedStatusCode = "200";
        final String expectedStatusText = "OK";
        final String expectedEndPoint = "search.html";
        final double expectedResponseTimeStandard = 3;

        List<String> httpResponse = new CaptureNetworkTraffic()
                .setUpDevTool(getDriver())
                .captureHttpResponses(expectedEndPoint);

        openBaseURL().clickSearchLanguagesHeader();

        System.out.println(httpResponse);

        Assert.assertEquals(httpResponse.get(0), expectedStatusCode);
        Assert.assertEquals(httpResponse.get(1), expectedStatusText);
        Assert.assertEquals(httpResponse.get(2), TestUtils.getBaseUrl() + expectedEndPoint);
        Assert.assertTrue(Double.parseDouble(httpResponse.get(3).substring(10, 14)) <= expectedResponseTimeStandard);
    }

    @Test
    public void testAPI_HttpRequest_POST() {
        List<String> httpRequest = new CaptureNetworkTraffic()
                .setUpDevTool(getDriver())
                .captureHttpRequests(ACTION,METHOD.toUpperCase());

        openBaseURL()
                .clickSearchLanguagesHeader()
                .inputSearchCriteria(LANGUAGE_NAME)
                .clickGoButton();

        System.out.println(httpRequest);

        Assert.assertEquals(httpRequest.get(0).toLowerCase(), METHOD);
        Assert.assertEquals(httpRequest.get(1), TestUtils.getBaseUrl() + ACTION);
        Assert.assertEquals(httpRequest.get(2), "Optional[" + PAYLOAD + "]");
        Assert.assertEquals(httpRequest.get(3), "Optional.empty");
    }

    @Test (dependsOnMethods = "testAPI_HttpRequest_POST")
    public void testAPI_HttpResponse_POST() {
        final String expectedStatusCode = "200";
        final String expectedStatusText = "OK";
        final String expectedEndPoint = "search.html";
        final double expectedResponseTimeStandard = 3;

        List<String> httpResponse = new CaptureNetworkTraffic()
                .setUpDevTool(getDriver())
                .captureHttpResponses(expectedEndPoint);

       SearchLanguagesPage searchLanguagesPage = openBaseURL()
                .clickSearchLanguagesHeader()
                .inputSearchCriteria(LANGUAGE_NAME)
                .clickGoButton();

        System.out.println(httpResponse);

        Assert.assertEquals(httpResponse.get(0), expectedStatusCode);
        Assert.assertEquals(httpResponse.get(1), expectedStatusText);
        Assert.assertEquals(httpResponse.get(2), TestUtils.getBaseUrl() + expectedEndPoint);
        Assert.assertTrue(Double.parseDouble(httpResponse.get(3).substring(10, 14)) <= expectedResponseTimeStandard);
        Assert.assertNotEquals(searchLanguagesPage.getPageContext(),PAGE_CONTEXT_BEFORE_REQUEST);
    }

    @Test
    public void testAPI_allLanguagesLinksAreNotBroken() {
        String linkURL = "";
        int responseCode;
        int actualWorkingLinksAmount = 0;

        List < WebElement> aTags = openBaseURL()
                .clickSearchLanguagesHeader()
                .inputSearchCriteria(LANGUAGE_NAME)
                .clickGoButton()
                .getLanguagesLinks();

        final int expectedWorkingLinksAmount = aTags.size();
        int internalLinks = expectedWorkingLinksAmount;

        for (WebElement link : aTags) {
            linkURL = link.getAttribute("href");

            if(linkURL != null && !linkURL.isBlank() && !linkURL.isEmpty()) {
                if(!linkURL.startsWith(TestUtils.getBaseUrl())) {
                    Reporter.log(linkURL + " is external link", true);
                    internalLinks--;
                } else {
                    try {
                        HttpURLConnection connection = (HttpURLConnection)(new URL(linkURL).openConnection());
                        connection.setRequestMethod("HEAD");
                        connection.connect();

                        responseCode = connection.getResponseCode();

                        if(responseCode < 400) {
                            actualWorkingLinksAmount++;
                        } else {
                            Reporter.log(linkURL + " is broken, response code " + responseCode, true);
                        }
                    }
                    catch (IOException e) {
                       e.printStackTrace();
                    }
                }
            }
        }

        Assert.assertEquals(actualWorkingLinksAmount, internalLinks);
        Assert.assertEquals(actualWorkingLinksAmount, expectedWorkingLinksAmount);
    }

    @Test
    public void testAPI_allImagesLinksAreNotBroken() {
        String imageURL = "";
        int responseCode;
        int actualWorkingImagesAmount = 0;

        List < WebElement> imgTags = openBaseURL()
                .clickSearchLanguagesHeader()
                .inputSearchCriteria(LANGUAGE_NAME)
                .clickGoButton()
                .getImages();

        final int expectedWorkingImagesAmount = imgTags.size();

        for (WebElement image : imgTags) {
            imageURL = image.getAttribute("src");

            if(imageURL != null && !imageURL.isBlank() && !imageURL.isEmpty()) {
                    try {
                        HttpURLConnection connection = (HttpURLConnection)(new URL(imageURL).openConnection());
                        connection.connect();

                        responseCode = connection.getResponseCode();

                        if(responseCode < 400 && new SearchLanguagesPage(getDriver()).isImageDisplayed(image)) {
                            actualWorkingImagesAmount++;
                        } else {
                            Reporter.log(imageURL + " is broken, response code " + responseCode + "or not displayed", true);
                        }
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
            }
        }

        System.out.println(actualWorkingImagesAmount);
        Assert.assertEquals(actualWorkingImagesAmount, expectedWorkingImagesAmount);
    }
}
