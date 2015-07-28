package com.mysites.example;

import java.util.ResourceBundle;

public class TextReader {
  public static String getText(){
	  ResourceBundle bundle = ResourceBundle.getBundle("text");
	  return bundle.getString("GreetingMassage");
  }
}
