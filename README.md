# belian
ERP Application for SME.

Version 2.0.0
Upgrade version 1.0, make project modular.
- Try to implement Domain Driven Design
- Use latest spring boot
- use apache camel for JMS Api and Rest Api
- migrate from maven to gradle
- change web client from java zkoss to ReactJs
- add Mobile client build using React Native
- use postman as UAT

erp (Middleware, core application)
- JMS for java client
- Rest API for non java client

Manggis 
- Web based client build using ReactJs
- https://github.com/agungperdana/manggis.git

WortelJus 
- Mobile client build using React Native
- https://github.com/agungperdana/wortel-jus.git

Available Module:
Security (role based security)
- Module
- Role
- User 

Party Management
- Party Data (Organization or Person)
- Address
- Contact
- Classification
- Role (as customer, supplier, employee, employer, etc)
- Relationship
- Physical characteristic (person)
- Marital history (person)

Geographic management (Country, city, province, etc)
