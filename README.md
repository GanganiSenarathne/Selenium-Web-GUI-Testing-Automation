<h1>Automation Exercise Website - GUI Testing Automation</h1>
    <p>
		This project uses Selenium WebDriver with TestNG to automate testing for the <a href="https://www.automationexercise.com/" target="_blank">Automation Exercise</a> 
		website. The project aims to ensure the functionality of various features of the website through automated test cases.
		This project contains 5 automated tests.
	</p>
 
<h2>Project Overview</h2>
<ul>
    <li><strong>Website Tested</strong>: <a href="https://www.automationexercise.com/" target="_blank">Automation Exercise</a></li>
    <li><strong>Testing Framework</strong>: TestNG</li>
    <li><strong>Automation Tool</strong>: Selenium WebDriver</li>
    <li><strong>Programming Language</strong>: Java</li>
</ul>

<h2>Prerequisites</h2>
<p>Ensure you have the following installed:</p>
<ul>
    <li><strong>Java JDK</strong>: Version 8 or higher.</li>
    <li><strong>Maven</strong>: For managing dependencies.</li>
    <li><strong>IDE</strong>: (Optional) An Integrated Development Environment like IntelliJ IDEA or Eclipse.</li>
</ul>

<h2>Automated Test Cases</h2>
<p>The following test cases are implemented:</p>
<ol>
    <li><strong>Test Case 1: Register User</strong>
        <ul>
            <li><strong>Steps</strong>:
                <ol>
                                    <li>Launch browser</li>
      					<li>Navigate to url 'http://automationexercise.com'</li>
      					<li>Click on 'Signup / Login' button</li>
      					<li>Verify 'New User Signup!' is visible</li>
      					<li>Enter name and email address</li>
      					<li>Click 'Signup' button</li>
      					<li>Verify that 'ENTER ACCOUNT INFORMATION' is visible</li>
      					<li>Fill details: Title, Name, Email, Password, Date of birth</li>
      					<li>Select checkbox 'Sign up for our newsletter!'</li>
      					<li>Select checkbox 'Receive special offers from our partners!'</li>
      					<li>Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number</li>
      					<li>Click 'Create Account button'</li>
      					<li>Verify that 'ACCOUNT CREATED!' is visible</li>
      					<li>Click 'Continue' button</li>
            </ol>
        </li>
    </ul>
</li>
<br>
<li><strong>Test Case 2: Login User with correct email and password</strong>
    <ul>
        <li><strong>Steps</strong>:
            <ol>
                <li>Launch browser</li>
				<li>Navigate to url 'http://automationexercise.com'</li>
				<li>Click on 'Signup / Login' button</li>
				<li>Verify 'Login to your account' is visible</li>
				<li>Enter correct email address and password</li>
				<li>Click 'login' button</li>
            </ol>
        </li>
    </ul>
</li>
<br>
<li><strong>Test Case 3: Contact Us Form</strong>
    <ul>
        <li><strong>Steps</strong>:
            <ol>
                <li>Launch browser</li>
				<li>Navigate to url 'http://automationexercise.com'</li>
				<li>Click on 'Contact Us' button</li>
				<li>Verify 'GET IN TOUCH' is visible</li>
				<li>Enter name, email, subject and message</li>
				<li>Upload file</li>
				<li>Click 'Submit' button</li>
				<li>Click OK button</li>
            </ol>
        </li>
    </ul>
</li>
<br>
<li><strong>Test Case 4: Search Product</strong>
    <ul>
        <li><strong>Steps</strong>:
            <ol>
                <li>Launch browser</li>
				<li>Navigate to url 'http://automationexercise.com'</li>
				<li>Click on 'Products' button</li>
				<li>Enter product name in search input and click search button</li>
				<li>Add products to cart</li>
				<li>Click 'Cart' button</li>
				<li>Verify checkout page</li>
            </ol>
        </li>
    </ul>
</li>
<br>
<li><strong>Test Case 5: Download Invoice After Purchase Order</strong>
    <ul>
        <li><strong>Steps</strong>:
            <ol>
                <li>Launch browser</li>
				<li>Navigate to url 'http://automationexercise.com'</li>
				<li>Click on 'Products' button</li>
				<li>Add product to cart</li>
				<li>Click 'Cart' button</li>
				<li>Click Proceed To Checkout</li>
				<li>Click 'Register / Login' button</li>
				<li>Fill login details</li>
				<li>Click 'Cart' button</li>
				<li>Click 'Proceed To Checkout' button</li>
				<li>Enter payment details: Name on Card, Card Number, CVC, Expiration date</li>
				<li>Click 'Pay and Confirm Order' button</li>
				<li>Click 'Download Invoice' button and verify invoice is downloaded successfully.</li>
				<li>Click 'Continue' button</li>
				<li>Click 'Delete Account' button</li>
				<li>Click 'Continue' button</li>
            </ol>
        </li>
    </ul>
</li>
