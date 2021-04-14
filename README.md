Task:
Your task is to Create a Customer with validated data by using a dto form object and follow the requirements. You also need to make sure that the client gets nice feedback by displaying friendly error messages when he/she send invalid data.

Class requirements:
Customer.class contains five fields: • String customerId
o Should be a UUID and be unique.
o Shouldnotbenull
• String email
o Shouldbeawell-formedemail.
o Shouldnotbenull
• LocalDate regDate
o Should be the date the user was registered.
o Shouldnotbenull • Boolean active
o Decides whether the Customer is active or not.
o Defaultvalueshouldbesettotrue • CustomerDetails details
o Additional details about the customer. o Shouldnotbenull
CustomerDetails.class contains six fields: • String detailsId
o Should be a UUID and be unique
o Required • String street
o Should represent a street address.
o Optional
o If not set should be given a default String value o Shouldnotbenull
• String zipCode
o A Swedish type of zipCode: ex. 35263
o Optional
o If not set should be given a default String value o Shouldnotbenull
• String city
o Representsacityname.
o Optional
o If not set should be given a default String value o Shouldnotbenull
• String homePhone
o Swedishphonenumber.
o Optional
o If not set should be given a default String value o Shouldnotbenull
• String cellphone
o Swedish cellphone number
o Optional
o If not set should be given a default value o Shouldnotbenull.