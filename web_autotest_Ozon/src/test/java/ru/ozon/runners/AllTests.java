package ru.ozon.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import utils.JsonParseUtils;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;


/**
 * Created by azamat on 10.02.17.
 */

@RunWith(Cucumber.class)

@CucumberOptions(
        features = "src/test/java/ru/ozon/features",
        glue = "ru/ozon/steps",
        tags = "@test")
public class AllTests {
}
