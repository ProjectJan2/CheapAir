
Feature: Registration page of cheapair project

Scenario: Registration Page Scenario 
 		
 		When Enter the details for registration
 		  |Fields |	values1|values2|values3|values4|values5|values6|values7|values8|values9|
 			|FirstName |divya |tharini  |priya |surya|nathi|laya|john|jacob|neemu|
 			|MiddleName|praba |murugesan|hari|jannani|ganesh|joyce|simon|gowry|gg|
 			|LastName  |R     |ganesh |gowri  |bala   |madan  |jaga  |jaga     |jav|udeen|
 			|suffix    |Jr		|Jr     |Jr     |  Jr   |   Jr  |  Sr  |   Sr    |II|III|
 			|Gender    |F     |F      |F      |M      | F     | M    | F       |M|M|
 			|Month     |January|January|January|January|January|January|January|January|January|
 			|day			 |01		|01			|01			|01			|01			|01			|01			|01|01|
 			|year				|2000 |2000		|2000   |2000   |2000   |2000   |2000   |2000|2000|
 		Then Enter the card details
 		|Fields |	values1|
 		|ccNum|4408041234567890|
 		|month|01|
 		|year|2023|
 		|cvv|234|
 		|name|bhanu|
 		|country|India|
 		|address|chennai|
 		|address|anna nagar|
 		|city|chennai|
 		|phone|9842222848|
 		|email|mcabhanu2gmail.com|
 		|password|welcome@1987|
 		|confirm|welcome@1987|
 		
 