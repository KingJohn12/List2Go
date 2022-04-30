package com.example.list2go

import com.parse.ParseClassName
import com.parse.ParseFile
import com.parse.ParseObject
import com.parse.ParseUser

// Item: String
// Price: Number
// Quantity: Number
// User: User
@ParseClassName("ListItem")
class ListItem: ParseObject() {

        // getter for item
        fun getItem(): String? {
            return getString(KEY_ITEM)
        }

        // setter for item
        fun setItem(item: String) {
            put(KEY_ITEM, item)
        }

        // getter for price
        fun getPrice(): Number? {
            return getNumber(KEY_PRICE)
        }

        // setter for price
        fun setPrice(price: Number) {
            put(KEY_PRICE, price)
        }

        // getter for quantity
        fun getQuantity(): Number? {
            return getNumber(KEY_QUANTITY)
        }

        // setter for quantity
        fun setQuantity(quantity: Number) {
            put(KEY_QUANTITY, quantity)
        }

        // getter for user
        fun getUser(): ParseUser? {
            return getParseUser(KEY_USER)
        }

        // setter for user
        fun setUser(user: ParseUser) {
            put(KEY_USER, user)
        }

        companion object {
            const val KEY_ITEM = "item"
            const val KEY_PRICE = "price"
            const val KEY_QUANTITY = "quantity"
            const val KEY_USER = "user"
        }

    }