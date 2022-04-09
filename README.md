# List2Go

## Table of Contents
1. [Overview](#Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)
2. [Schema](#Schema)

## Overview
### Description
List2Go is an app that lets the user create a simple grocery list with the quantity of items, and provides 
suggestions to the user such as the nearest grocery shops, the best deals, and the best brands.

### App Evaluation
[Evaluation of your app across the following attributes]
- **Category:** Lifestyle
- **Mobile:** We use data from the users location and provide a list of nearby stores that have what the user wants on a map
- **Story:** This app can help people who shift to new cities or don't know their surrondings well and need help figuring out how to get what they need without wasting time on doing all the research.
- **Market:** The main market will be anyone who moves, but it can also include people who are interested in learning about stores in their cities or for deals
- **Habit:** The user could use this app potentially any time they want to buy groceries, and the user can create tasks while consuming the data that the app provides
- **Scope:** It will be a challenge to complete this project, because although the ground level version of the app is very basic, we want to implement new features that we have not done before.

## Product Spec

### 1. User Stories (Required and Optional)

**Required Must-have Stories**

- [ ] User can sign up/login
- [ ] User can log out
- [ ] User can enter items in a list
- [ ] User can enter quantities in a list
- [ ] User can modify/delete items in a list
- [ ] User can modify/delete quantities in list
- [ ] User can enter prices and calculate total
- [ ] User is able to save their list (up to certain number of items)
- [ ] User is able to see stores near their location
- [ ] User is able to see profile with name

**Optional Nice-to-have Stories**

- [ ] User is able to see saved list in profile
- [ ] User gets suggestions on which store is best for which products based on search
- [ ] User get suggestions on best deals in the area based on search
- [ ] User gets suggestions on best brands based on search
- [ ] User is able to add suggestions to grocery list
- [ ] User is able to view suggestions on best way to buy groceries
- [ ] User is able to see which stores includes best deals and brands on their grocery list


### 2. Screen Archetypes

* Login / Register
   * User can sign up/login
* Creation
   * User can enter items in a list
   * User can enter quantities in a list
   * User can modify/delete items in a list
   * User can modify/delete quantities in list
   * User can enter prices and calculate total
   * User is able to save their list (up to certain number of items)
* Detail
   * User is able to see stores near their location
* Profile
   * User is able to see profile with name
   * User can log out
   * User is able to see saved list

### 3. Navigation

**Tab Navigation** (Tab to Screen)

* Grocery List
* Map
* Profile

**Flow Navigation** (Screen to Screen)

* Login / Register
   * Grocery List
   * Map
   * Profile

## Wireframes
[Add picture of your hand sketched wireframes in this section]
![wireframe](/Wireframe.jpg-1.jpeg)

### [BONUS] Digital Wireframes & Mockups

### [BONUS] Interactive Prototype

## Schema 
User
Property | Type | Description 
--- | --- | --- 
username | String | id that user creates
password | String | password that user creates
userId | String | unique id of the created user when created
list | Pointer | pointer to grocery list that user saved to profile
location | JSONObject | current location of user

List
Property | Type | Description 
--- | --- | --- 
item | String | name of item that user wants to buy
quantity | Number | quantity of item that user wants
price | Number | price of 1 item
author | Pointer | List author


### Models
[Add table of models]

### Networking
- Login / Register Screen
   - (Create/USER) User can sign up
   - (Read/GET) User can login
- List Screen
   - (Create/LIST) User can enter items in a list
   - (Create/LIST) User can enter quantities in a list
   - (Create/LIST) User can modify/delete items in a list
   - (Create/LIST) User can modify/delete quantities in list
   - (Create/LIST) User can enter prices and calculate total
   - (Update/PUT) User is able to save their list (up to certain number of items)
- Maps Screen
   -(Read/GET) User is able to see stores near their location
- Profile
   - (Read/GET) User is able to see profile with name
   - User can log out
   - (Read/GET) User is able to see new list
