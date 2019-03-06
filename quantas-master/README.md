##Environment Setup:
- Install Java 8
- Preferred IDE - Intellij Idea
- Additional plugin for Intellij - Lombok
- Lombok and Swagger dependency has to be added in project pom
- Database - H2
- Port - 8090

##Authentication:

Basic authentication is in place

username - securerest

password - password

Every server request must have Basic Authentication header with username set to securrest and password set to password

To logout call the url /quantas/logout

Note that current implementation doesn't include any timeout mechanism. Users have to call logout endpoint explicitly.

##Rest Endpoints:
1. Save/ Update - /quantas/customers/save

Sample post to save new customer:

{
    "firstName": "William",
    "lastName": "La",
    "dateOfBirth": "09-01-1972",
    "addresses": [
        {
            "streetNo": "111",
            "street": "George Street",
            "suburb": "Redfern",
            "pincode": "2005",
            "state": "NSW",
            "contactNo": "123456789",
            "addressType": "OFFICE",
            "email": null
        }
    ]
}

Sample post request to update existing customer:

{
    "id": 4,
    "firstName": "William",
    "lastName": "La",
    "dateOfBirth": "09-01-1972",
    "addresses": [
        {
            "id": 5,
            "streetNo": "111",
            "street": "George Street",
            "suburb": "Redfern",
            "pincode": "2005",
            "state": "NSW",
            "contactNo": "123456789",
            "addressType": "OFFICE",
            "email": null
        }
    ]
}

2. Find All - /quantas/customers/find/all

This project comes with a driver program which inserts 2 customer profile records to the HSQL DB. When find all is called, below JSON can be seen as a response:

{
    "customerProfileDtos": [
        {
            "id": 1,
            "firstName": "John",
            "lastName": "Welsch",
            "dateOfBirth": "09-01-1980",
            "addresses": [
                {
                    "id": 2,
                    "streetNo": "111",
                    "street": "George Street",
                    "suburb": "Ultimo",
                    "pincode": "2000",
                    "state": "NSW",
                    "contactNo": "123456789",
                    "addressType": "OFFICE",
                    "email": null
                },
                {
                    "id": 3,
                    "streetNo": "222",
                    "street": "George Street",
                    "suburb": "Sydney",
                    "pincode": "2001",
                    "state": "NSW",
                    "contactNo": "123456789",
                    "addressType": "HOME",
                    "email": null
                }
            ]
        },
        {
            "id": 4,
            "firstName": "William",
            "lastName": "La",
            "dateOfBirth": "09-01-1972",
            "addresses": [
                {
                    "id": 5,
                    "streetNo": "111",
                    "street": "George Street",
                    "suburb": "Redfern",
                    "pincode": "2005",
                    "state": "NSW",
                    "contactNo": "123456789",
                    "addressType": "OFFICE",
                    "email": null
                }
            ]
        }
    ]
}

3. Find by ID - /quantas/customers/find/{customerId}

Sample JSON response:

{
    "customerProfileDtos": [
        {
            "id": 4,
            "firstName": "William",
            "lastName": "La",
            "dateOfBirth": "09-01-1972",
            "addresses": [
                {
                    "id": 5,
                    "streetNo": "111",
                    "street": "George Street",
                    "suburb": "Redfern",
                    "pincode": "2005",
                    "state": "NSW",
                    "contactNo": "123456789",
                    "addressType": "OFFICE",
                    "email": null
                }
            ]
        }
    ]
}

When the requested customer isn't found:
{
    "message": "Unable to find the customer profile with ID: 10",
    "customerProfileDtos": [
        null
    ]
}

4. Delete - /quantas/customers/delete

Sample JSON post request to delete the customer:

{"id": 4}


##Swagger URL
http://localhost:8090/quantas/v2/api-docs


