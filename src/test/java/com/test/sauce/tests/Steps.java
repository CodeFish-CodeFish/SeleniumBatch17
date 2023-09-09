package com.test.sauce.tests;

public class Steps {

    /*
1-Navigate to the website https://www.saucedemo.com/
2-You should have 1 loginpage 1 logintest 1 allData class(under test package)
3-Under login test you should have:
   -->PositiveTest
   -->NegativeTest
4-Both should work with DataProvider
5-For positive test:\
   1-standard_user
   2-problem_user
   3-performance_glitch_user
   They should all login successfully (https://www.saucedemo.com/inventory.html)
 6-For negative test:
   1-Provide wrong username and password and validate "Epic sadface: Username and password do not match any user in this service"
   2-Provide empty username and wrong password and validate "Epic sadface: Username is required"
   3-Provide correct username and empty password and validate "Epic sadface: Password is required"
   4-Provide both empty for username and password and validate ""Epic sadface: Username is required""
   5-Provide username locked_out_user and password secret_sauce and validate "Epic sadface: Sorry, this user has been locked out."
 */
}
