"# FleetManagement" 

It is a rest api based Spring project to manage Dealers, Customer and their Car.
It used H2 Database (in memmory database) to store the different information.

This is rest API created as a tool for dealers to manage customers. The dealers are into car service.
There is one dealer in each Region. Dearer can serve multiple Customers. Dealers are servicing car.

It has following API's exposed to serve request:

![image](https://github.com/manudada88/FleetManagement/assets/128960816/2e40681a-d0d9-4a38-940f-a08bf39bab1d)

1. Create Car

**POST Resource "/cars"**
   unique number is alphanumeric string max size 5
   Assembly date is past date and today's date - future date is not allowed
   
**Request Body**
{
"uniqueNumber": "432T1",
"assemblyDate": "2019-05-20"
}

**Response - returns car object and 201 Status code**
{
    "uniqueNumber": "432T1",
    "assemblyDate": "2019-05-20"
}


2. Create Customer

**POST Resource "/customers"**
Fullname cannot be blank or null
email should be in formate and cannot be blank
   
**Request Body**
{ 
	"fullName":"Manu Shrivastava",
	"phoneNumber" : "785462154",
	"email":"manu.shrivastava@ru.com"
}	

**Response - returns created customer object and 201 Status code**
{
    "customerId": 1,
    "fullName": "Manu Shrivastava",
    "phoneNumber": "785462154",
    "email": "manu.shrivastava@ru.com",
    "carsOwned": []
}

3. Create Dealer

**POST Resource "/dealers"**
name cannot be blank or nll
email should be in formate and cannot be blank
representativefullname cannot be blank or null
   
**Request Body**
{ 
	"name":"ABC Corp",
	"email":"manu.shrivastava@ru.com",
	"representativeFullName":"Radhe Shyam Tiwari"
}	

**Response - returns created dealer object and 201 Status code**
{
    "dealerId": 1,
    "name": "ABC Corp",
    "email": "manu.shrivastava@ru.com",
    "representativeFullName": "Radhe Shyam Tiwari",
    "customersList": []
}

4. assign car to customer

**POST Resource "/assign-car-customer"**
carUniqueNumber cannot be null, but alphanumeric and of length 1-5
customerId cannot be null or blank
   
**Request Body**
{
"carUniqueNumber": "03TXA",
"customerId": "101"
}

**Response - returns customer object with car assigned and 200 Status code**
{
    "customerId": 101,
    "fullName": "Manu Shrivastava",
    "phoneNumber": "9959098655",
    "email": "manu.shrivastava@mail.ru",
    "carsOwned": [
        {
            "uniqueNumber": "03TXA",
            "assemblyDate": "2023-05-05"
        }
    ]
}

5. unassign car from customer: detach car from the customer

**POST Resource "/unassign-car-customer"**
carUniqueNumber cannot be null, but alphanumeric and of length 1-5
customerId cannot be null or blank
   
**Request Body**
{
"carUniqueNumber": "03TXA",
"customerId": "101"
}

**Response - returns customer object with car assigned and 200 Status code**
{
    "customerId": 101,
    "fullName": "Manu Shrivastava",
    "phoneNumber": "9959098655",
    "email": "manu.shrivastava@mail.ru",
    "carsOwned": []
}

6. assign customer to Dealer: 

**POST Resource "/assign-customer-dealer"**
dealerId cannot be null or blank
customerId cannot be null or blank
   
**Request Body**
{ 
	"customerId":"103",
	"dealerId" : "1001"
}	

**Response - returns Dealer object with customer details and also new customer assigned and 200 Status code**
{
    "dealerId": 1001,
    "name": "Pegas-agro",
    "email": "rahulMahajan@pegusagro.com",
    "representativeFullName": "Rahul Mahajan",
    "customersList": [
        {
            "customerId": 103,
            "fullName": "Supriya Shrivastava",
            "phoneNumber": "9959098655",
            "email": "getsupriya@gmail.com",
            "carsOwned": []
        },
        {
            "customerId": 102,
            "fullName": "Evgeniia Zalovkova",
            "phoneNumber": "9959098655",
            "email": "sunnyjeka@gmail.com",
            "carsOwned": [
                {
                    "uniqueNumber": "03AXA",
                    "assemblyDate": "2014-05-05"
                }
            ]
        },
        {
            "customerId": 101,
            "fullName": "Manu Shrivastava",
            "phoneNumber": "9959098655",
            "email": "manu.shrivastava@mail.ru",
            "carsOwned": []
        }
    ]
}


7. unassign customer from Dealer: detatch customer from the dealer

**POST Resource "/unassign-customer-dealer"**
dealerId cannot be null or blank
customerId cannot be null or blank
   
**Request Body**
{ 
	"customerId":"101",
	"dealerId" : "1001"
}

**Response - returns Dealer object with customer details and also unassign customer and 200 Status code**
{
    "dealerId": 1001,
    "name": "Pegas-agro",
    "email": "rahulMahajan@pegusagro.com",
    "representativeFullName": "Rahul Mahajan",
    "customersList": [
        {
            "customerId": 102,
            "fullName": "Evgeniia Zalovkova",
            "phoneNumber": "9959098655",
            "email": "sunnyjeka@gmail.com",
            "carsOwned": [
                {
                    "uniqueNumber": "03AXA",
                    "assemblyDate": "2014-05-05"
                }
            ]
        },
        {
            "customerId": 103,
            "fullName": "Supriya Shrivastava",
            "phoneNumber": "9959098655",
            "email": "getsupriya@gmail.com",
            "carsOwned": []
        }
    ]
}

8. Get Customer Details: returns Customer details along with car details

**Get Resource "/customers/{customerId}"**
  customerId cannot be blank or null
   
**Request Body**
none

**Response - returns customer object and 200 Status code**
{
    "customerId": 101,
    "fullName": "Manu Shrivastava",
    "phoneNumber": "9959098655",
    "email": "manu.shrivastava@mail.ru",
    "carsOwned": []
}

9. Get Dealer Details: Returns The dealer details along with Customer details and cars owned

**Get Resource "/dealers/{dealerId}"**
  dealerId cannot be blank or null
   
**Request Body**
none

**Response - returns customer object and 200 Status code**
{
    "dealerId": 1001,
    "name": "Pegas-agro",
    "email": "rahulMahajan@pegusagro.com",
    "representativeFullName": "Rahul Mahajan",
    "customersList": [
        {
            "customerId": 102,
            "fullName": "Evgeniia Zalovkova",
            "phoneNumber": "9959098655",
            "email": "sunnyjeka@gmail.com",
            "carsOwned": [
                {
                    "uniqueNumber": "03AXA",
                    "assemblyDate": "2014-05-05"
                }
            ]
        },
        {
            "customerId": 103,
            "fullName": "Supriya Shrivastava",
            "phoneNumber": "9959098655",
            "email": "getsupriya@gmail.com",
            "carsOwned": []
        }
    ]
}
