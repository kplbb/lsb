<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="../header.jsp" %>
<!--	<form id="join" name="formm" method="post" action="LsbServlet?command=join_form"> -->
	<div class="modal-content-contract">					     	 
	    <form id="join"  method="post" name="formm">
        <label>&nbsp;User ID</label><br>
        <input id="headerInput_contract" type="text"      name="id"        size="12"  >
        <input type="hidden"    name="reid">
        &nbsp;<input type="button" id="headerBut" style="width:120px; background-color:#f2f2f2; 
        	color:black; font-size:10px; text-aling:left; padding: 5px;" value="ID availability"  class="dup" onclick="idcheck()"> <br>
        <label>&nbsp;Password</label><br> 
        <input id="headerInput_contract" type="password"  name="pwd"><br> 
        <label>&nbsp;Confirm Password</label> 
        <input id="headerInput" type="password"  name="pwdCheck"><br> 
        <label>&nbsp;Name</label>
        <input id="headerInput_contract" type="text"      name="name"><br> 
        <label>&nbsp;E-Mail</label>
        <input id="headerInput_contract" type="text"      name="email">
        <input name="news_email_yn" type="checkbox" value="y"><span style="font-size: 12px;">Subscribe to Newsletter!</span><br><br>

        <label>&nbsp;Address</label> 
        <input type="text" id="headerInput_contract" name="addr1"   size="50">
        <input type="text" id="headerInput_contract" name="addr2"   size="25"> <br>
        <label>&nbsp;Zip Code</label> 
        <input type="text" id="headerInput_contract" name="zipNum"   size="10" ><br>      
        <label>&nbsp;Phone Number</label> 
        <input  type="text" id="headerInput_contract"  name="phone"><br>

      <div class="clear"></div>
    

	<!-- 
 	<textarea rows="25" cols="120" >
	 Chapter 1: General Provisions
	
	Article 1 [Purpose)
	These terms and conditions (hereinafter referred to as'Terms and Conditions') are the following terms and conditions for the subscription conditions and use of the jjang0u.com service provided by the company between Nonage Co., Ltd. (hereinafter referred to as the company) and users (hereinafter referred to as'members'), and other basic The purpose is to specify the matters in detail.
	
	Article 2 (Effect and Change of Terms of Use)
	(1) These Terms and Conditions become effective by publishing online on the Nonage website (www.wownoage.com hereinafter'Nonage Web'), and if a reasonable reason arises, it may be amended within the scope of not violating the relevant laws and regulations. The revised terms and conditions take effect by notifying them online, and any revisions to important regulations such as the rights or obligations of users will be notified in advance.
	(2) The company may change these terms and conditions if there is a reasonable reason, and if the terms and conditions are changed, it will be disclosed in advance without delay.
	(3) If the user does not agree to the revised terms and conditions, they can always stop using the "Service" and terminate the contract of use. Continued use of the "service" after the effective date of the terms and conditions is considered as the user's consent to the changes to the terms and conditions.
	
	Article 3 (rules other than the terms and conditions)
	(1) These terms and conditions apply together with the usage guide for individual services provided by the company (hereinafter referred to as service-specific information).
	(2) For matters not specified in these terms and conditions, it can be applied according to the purpose of separate detailed terms and conditions, business practices, company announcements, usage guidelines, related laws, and service-specific guidance.
	
	Article 4 (definition of terms)
	(1) "User" or "Member" means access to "Nonage" and sign up for "Nonage" in accordance with these Terms and Conditions, and the user himself selects and grants it to the user for identification of the user and the use of the service of the user. It refers to a person who receives the services provided by "Nonage" by using the'User Number (ID)', which is a combination of letters and numbers, and the'Password' selected by the user himself to confirm that the user is matched accordingly.
	(2) The definitions of terms used in these terms and conditions are as stipulated in related laws and service-specific guidance, except for those specified in paragraph 1.
	
	Chapter 2 Signing a contract for use
	
	Article 5 (establishment of use contract)
	(1) The contract of use is established by the user's consent to the terms and conditions of use and the company's consent to the use application, and consent to the terms of use is made by pressing the'I agree' button on the nonage web at the time of application for use. Mark.
	
	Article 6 (application for service use)
	(1) Users who want to use this service by signing up as a member must provide all the information (name, resident registration number, contact information, etc.) requested by the company.
	(2) All members must provide the member's name and resident registration number to use the service, and only users who have registered with their real name cannot claim their rights.
	(3) Membership registration can only be done with a real name.
	(4) All IDs of members who applied for use by stealing another person's name (name and resident registration number) will be deleted, and may be punished in accordance with relevant laws and regulations.
	(5) The Company may classify members who use this service by grade and divide the usage time, number of times, service menu, etc. into different usage.
	
	Article 7 (Protection of users' personal information)
	The company strives to protect the personal information of users, including user registration information, in accordance with the relevant laws and regulations. The protection of users' personal information is in accordance with the relevant laws and "Personal Information Protection Policy" set by "Nonage".
	
	Article 8 (approval and restriction of application for use)
	(1) A person who wants to become a user applies for membership registration by filling in member information according to the registration form set by the company and clicking the "Register" button.
	(2) The company does not accept the following cases.
	G. When the applicant for membership has previously lost membership in accordance with these terms and conditions. In the case of a person who has not passed 1 month after the loss and attempts to obtain the consent of "Nonage" for membership re-registration
	N. In the case of false information, omission, or mistake in the registration details
	C. In case of applying for the purpose of hindering the well-being, order, and morals of society
	L. If you want to use this service for illegal purposes
	E. In the case of loss of membership due to repeated acts that violate Nonage's policy
	F. When a user who is in a competitive relationship with this service applies
	(3) In the event that the application for service use falls under any of the following, the company may withhold the application until the reasons for restriction of consent are resolved.
	G. When there is no room for facilities
	N. If there is a technical problem
	C. In case it is difficult to approve use due to other reasons
	(4) If the customer applying for use is a minor stipulated by relevant laws and regulations, the company may withhold approval as prescribed in the guide for each service.
	
	Article 9 (User ID grant and change, etc.)
	(1) The company grants a user ID to the user according to the terms and conditions.
	(2) User ID cannot be changed in principle, and if you want to change it due to unavoidable reasons, you must cancel the ID and re-register.
	(3) The user ID of ‘Nonage’ may be linked with the member ID of the company’s site operated by ‘Nonage’ with the consent of the user.
	(4) User ID can be changed at the request of the user or the company in the following cases.
	G. If the user ID is registered with the user's phone number or resident registration number, etc., and there is a concern of invasion of privacy
	N. In case of disgust to others or contrary to public morals
	C. If there are other reasonable reasons
	(5) The user is responsible for managing the service user ID and password. The user is responsible for any damages in the use of the service or illegal use by a third party due to negligence management, and the company does not take any responsibility for it.
	(6) Other matters related to the management and change of user personal information are as specified in the guide for each service.
	
	Chapter 3 Obligations of Contracting Parties
	
	Article 10 (Company's Obligation)
	(1) The company does not act against laws and regulations and these terms and conditions, or against public order and morals, and strives to provide consistent and stable services in accordance with these terms and conditions.
	(2) The company establishes a security system to protect users' personal information (including credit information) so that users can safely use Internet services.
	(3) If the opinion or complaint raised by the user is objectively recognized as legitimate, the company must immediately deal with it through appropriate procedures. However, if immediate processing is difficult, the user must be notified of the reason and processing schedule.
	
	Article 11 (user's obligations)
	(1) When applying for membership or changing member information, the user must fill out all matters based on the facts in his real name, and if he/she registers false or other person's information, he or she cannot claim any rights.
	(2) Members must comply with the matters stipulated in these terms and conditions and other regulations and related laws and regulations set by the company, such as announcements, and other acts that interfere with the company's business, damage the company's reputation. You must not do anything that tells you.
	(3) Members must immediately notify the company of any changes in the contract of use such as address, contact information, e-mail address, etc. through the appropriate procedure.
	(4) Members are responsible for all consequences arising from negligence or illegal use of the password of the ID given to the member, except when the company is responsible for it in accordance with relevant laws and'Personal Information Protection Policy'. .
	(5) Members cannot conduct business activities using the service without prior approval from the company, and the company is not responsible for the results of such business activities. In addition, if the member suffers damages to the company due to such business activities, the member shall be liable for damages to the company, and the company may request compensation for damages, etc., for the member through service use restrictions and legal procedures.
	(6) Members cannot transfer or donate the right to use the service or other status in the contract of use to another person, and cannot provide it as collateral, unless the company's explicit consent is given.
	(7) Members must not infringe the intellectual property rights of the company and third parties.
	(8) Members shall not engage in any of the following acts, and the company may impose sanctions, including restrictions on members' use of the service and legal actions, in the event of such acts.
	G. Posting or sending e-mails by impersonating or pretending to be an employee or service manager, or by stealing the name of another person
	N. Registering false information when applying for membership or changing member information
	C. Stealing other users' IDs, passwords, and resident registration numbers
	L. The act of transacting user ID with others
	E. Impersonating the company's management team, employees, or officials
	F. Changing the company's client program, hacking the company's server, or arbitrarily changing part or all of the website or posted information without being granted special rights from the company.
	G. Any act that harms or intentionally interferes with the service
	ㅇ. Reproducing the information obtained through this service for purposes other than using the service without prior consent of the company, using it for publication and broadcasting, or providing it to a third party
	D. The act of transmitting or posting information (computer programs, etc.) that is prohibited from being transmitted or posted in accordance with relevant laws.
	I. The act of distributing information, sentences, figures, sounds, and videos of vulgar or obscene content to others by transmission, posting, e-mail or other methods that violate public order and morals
	Ha. The act of distributing content that is offensive or about personal information that may infringe on the honor or privacy of others by transmission, posting, direct message or other means
	T. Harassing or threatening other users, or continuously causing pain or inconvenience to specific users
	F. Collecting or storing personal information of other users without approval from the company
	H. Acts that are objectively judged to be associated with a crime
	</textarea>	

	<br>
	-->
	<!-- style="text-align: center;" -->
   <!--   <input id="contractRadio1" type="radio" name="okon1" checked> Agree &nbsp; &nbsp; &nbsp;
      <input id="contractRadio2" type="radio" name="okon1" > Disagree &nbsp; &nbsp; &nbsp; 
    --> 
    <!--  <input id="nextJoin" type="button" value="Next" class="submit"  onclick="go_next()">  --> 
   
 <div id="buttons">
        <input type="button" id="headerBut" style="width:49%; float:left;" value="register"   class="submit" onclick="go_save()"> 
        <input type="reset" id="headerBut" style="width:49%; float:right;" value="cancel"     class="cancel">
      </div>
      </form>
     </div>
 <%@ include file="../footer.jsp" %>
