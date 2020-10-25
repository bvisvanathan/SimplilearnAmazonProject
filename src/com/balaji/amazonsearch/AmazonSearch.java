package com.balaji.amazonsearch;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class AmazonSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","/home/balajivisvanath/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		AmazonSearchPage searchPage = PageFactory.initElements(driver, AmazonSearchPage.class);
		searchPage.openAmazonIndia();
		searchPage.selectProductCategory("search-alias=electronics");
		searchPage.inputSearchText("headphones with mic");
		searchPage.clickSearchButton();
		searchPage.getProductLists();
		try {
			searchPage.insertProductListDatabase("search-alias=electronics","headphones with mic");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		searchPage.closeAmazonIndia();

	}

}
